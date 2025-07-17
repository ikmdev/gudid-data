package dev.ikm.maven;

import dev.ikm.tinkar.common.service.CachingService;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.common.service.ServiceKeys;
import dev.ikm.tinkar.common.service.ServiceProperties;
import dev.ikm.tinkar.composer.Composer;
import dev.ikm.tinkar.entity.EntityService;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@Mojo(name = "run-gudid-transformation", defaultPhase = LifecyclePhase.INSTALL)
public class GudidTransformationMojo extends AbstractMojo {
    private static final Logger LOG = LoggerFactory.getLogger(GudidTransformationMojo.class.getSimpleName());

    @Parameter(property = "origin.namespace", required = true)
    String namespaceString;
    @Parameter(property = "datastorePath", required = true)
    private String datastorePath;
    @Parameter(property = "inputDirectoryPath", required = true)
    private String inputDirectoryPath;
    @Parameter(property = "dataOutputPath", required = true)
    private String dataOutputPath;
    @Parameter(property = "controllerName", defaultValue = "Open SpinedArrayStore")
    private String controllerName;
    @Parameter(property = "skipUnzip", defaultValue = "false")
    private boolean skipUnzip;
    @Parameter(property = "medicalSpecialties")
    private String[] medicalSpecialties;

    private UUID namespace;

    // Define processing order based on dependencies
    private static final List<String> FILE_PROCESSING_ORDER = Arrays.asList(
            "foi/foiclass.txt",
            "gudid/productCodes.txt",
            "gudid/identifiers.txt",
            "gudid/device.txt"
    );

    public void execute() throws MojoExecutionException {
        try {
            this.namespace = UUID.fromString(namespaceString);

            File datastore = new File(datastorePath);
            LOG.info("inputDirectoryPath: " + inputDirectoryPath);
            File inputFileOrDirectory;
            if (skipUnzip) {
                inputFileOrDirectory = new File(inputDirectoryPath);
            } else {
                File unzippedData = unzipRawData(inputDirectoryPath);
                LOG.info("unzippedData: " + unzippedData);
                inputFileOrDirectory = new File(unzippedData, "src");
            }
            LOG.info("inputFileOrDirectory: " + inputFileOrDirectory);

            transformFiles(datastore, inputFileOrDirectory);
        } catch (IllegalArgumentException e) {
            throw new MojoExecutionException("Invalid namespace for UUID formatting");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private File unzipRawData(String zipFilePath) throws IOException {
        File outputDirectory = new File(dataOutputPath);
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                File newFile = new File(outputDirectory, zipEntry.getName());
                if (zipEntry.isDirectory()) {
                    newFile.mkdirs();
                } else {
                    new File(newFile.getParent()).mkdirs();
                    try (FileOutputStream fos = new FileOutputStream(newFile)) {
                        byte[] buffer = new byte[1024];
                        int len;
                        while ((len = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }
                zis.closeEntry();
            }
        }
        return outputDirectory;
    }

    /**
     * Transforms each snomed file in a directory based on filename
     *
     * @param datastore            location of datastore to write entities to
     * @param inputFileOrDirectory directory containing snomed files
     */
    /**
     * Transforms GUDID files in the specified directory
     *
     * @param datastore location of datastore to write entities to
     * @param inputDirectory directory containing GUDID files
     */
    public void transformFiles(File datastore, File inputDirectory) {
        LOG.info("########## GUDID Transformer Starting...");
        initializeDatastore(datastore);

        EntityService.get().beginLoadPhase();
        try {
            GudidUtility gudidUtility = new GudidUtility(namespace, ".", medicalSpecialties);
            Composer composer = new Composer("GUDID Transformer Composer");
            processFilesInOrder(inputDirectory, composer, gudidUtility);
            composer.commitAllSessions();
            LOG.info("GUDID transformation completed successfully");
        } catch (Exception e) {
            LOG.error("Error during GUDID transformation", e);
            throw new RuntimeException("GUDID transformation failed", e);
        } finally {
            EntityService.get().endLoadPhase();
            PrimitiveData.stop();
            LOG.info("########## GUDID Transformer Finishing...");
        }
    }

    private void initializeDatastore(File datastore) {
        CachingService.clearAll();
        ServiceProperties.set(ServiceKeys.DATA_STORE_ROOT, datastore);
        PrimitiveData.selectControllerByName(controllerName);
        PrimitiveData.start();
    }

    private void processFilesInOrder(File inputDirectory, Composer composer, GudidUtility gudidUtility) {
        LOG.info("Processing GUDID files in dependency order...");

        for (String fileName : FILE_PROCESSING_ORDER) {
            File file = new File(inputDirectory, fileName);
            if (file.exists() && file.isFile()) {
                processIndividualFile(file, composer, gudidUtility);
            } else {
                throw new RuntimeException("Origin file does not exist: " + file);
            }
        }
    }

    private void processIndividualFile(File file, Composer composer, GudidUtility gudidUtility) {
        String fileName = file.getName();
        Transformer transformer = getTransformer(fileName, gudidUtility);

        if (transformer != null) {
            LOG.info("### Transformer Starting for file: " + fileName);
            transformer.transform(file, composer);
            LOG.info("### Transformer Finishing for file : " + fileName);
        } else {
            LOG.info("This file cannot be processed at the moment : " + file.getName());
        }
    }

    /**
     * Returns appropriate transformer based on filename
     *
     * @param fileName File name to match against transformers
     * @return Transformer instance or null if no match found
     */
    private Transformer getTransformer(String fileName, GudidUtility gudidUtility) {
        String lowerFileName = fileName.toLowerCase();

        if (lowerFileName.contains("foiclass.txt")) {
            return new FoiClassTransformer(gudidUtility);
        } else if (lowerFileName.contains("device.txt")) {
            return new DeviceTransformer(gudidUtility);
        } else if (lowerFileName.contains("identifiers.txt")) {
            return new GudidIdentifierTransformer(gudidUtility);
        } else if (lowerFileName.contains("productcodes.txt")) {
            return new ProductCodeTransformer(gudidUtility);
        }

        return null;
    }

}
