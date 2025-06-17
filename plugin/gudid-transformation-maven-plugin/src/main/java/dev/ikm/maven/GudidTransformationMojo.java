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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
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

    private UUID namespace;
    private GudidUtility gudidUtility;

    // Define processing order based on dependencies
    private static final List<String> FILE_PROCESSING_ORDER = Arrays.asList(
            "foiclass.txt",     // Creates FDA product code concepts first
            "Device.txt",       // Creates device concepts and mappings
            "Identifiers.txt",  // Uses device mappings
            "ProductCodes.txt"  // Uses both device and FDA product code mappings
    );

    public void execute() throws MojoExecutionException {
        try {
            this.namespace = UUID.fromString(namespaceString);
            this.gudidUtility = new GudidUtility(namespace);

            File datastore = new File(datastorePath);
            LOG.info("inputDirectoryPath: " + inputDirectoryPath);
            File inputFileOrDirectory;
            if (skipUnzip) {
                // Let lucene shut down???
                //Thread.sleep(10000);
                inputFileOrDirectory = new File(inputDirectoryPath);
            } else {
                String unzippedData = unzipRawData(inputDirectoryPath);
                LOG.info("unzippedData: " + unzippedData);
                inputFileOrDirectory = new File(unzippedData);
            }
            LOG.info("inputFileOrDirectory: " + inputFileOrDirectory);
            validateInputDirectory(inputFileOrDirectory);

            transformFiles(datastore, inputFileOrDirectory);
        } catch (IllegalArgumentException e) {
            throw new MojoExecutionException("Invalid namespace for UUID formatting");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String unzipRawData(String zipFilePath) throws IOException {
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
        File terminologyFolder = searchTerminologyFolder(outputDirectory);

        if (terminologyFolder != null) {
            return terminologyFolder.getAbsolutePath();
        } else {
            throw new FileNotFoundException("The 'Terminology' folder could not be found...");
        }
    }

    private static File searchTerminologyFolder(File dir) {
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory() && file.getName().equals("Terminology") &&
                            file.getParentFile().getName().equals("Full")) {
                        return file;
                    }
                    File found = searchTerminologyFolder(file);
                    if (found != null) {
                        return found;
                    }
                }
            }
        }
        return null;
    }

    private void validateInputDirectory(File inputFileOrDirectory) throws MojoExecutionException {
        if (!inputFileOrDirectory.exists()) {
            throw new RuntimeException("Invalid input directory or file. Directory or file does not exist");
        }
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
            Composer composer = new Composer("GUDID Transformer Composer");
            processFilesInOrder(inputDirectory, composer);
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

    private void processFilesInOrder(File inputDirectory, Composer composer) {
        LOG.info("Processing GUDID files in dependency order...");

        for (String fileName : FILE_PROCESSING_ORDER) {
            File file = new File(inputDirectory, fileName);
            if (file.exists() && file.isFile()) {
                processIndividualFile(file, composer);
            } else {
                LOG.warn("Skipping missing file: " + fileName);
            }
        }

        // Process any additional .txt files not in the main processing order
        processRemainingFiles(inputDirectory, composer);
    }

    private void processRemainingFiles(File inputDirectory, Composer composer) {
        File[] allFiles = inputDirectory.listFiles((dir, name) ->
                name.endsWith(".txt") && !FILE_PROCESSING_ORDER.contains(name));

        if (allFiles != null && allFiles.length > 0) {
            LOG.info("Processing additional files...");
            Arrays.stream(allFiles)
                    .forEach(file -> processIndividualFile(file, composer));
        }
    }

    private void processFilesFromInput(File inputFileOrDirectory, Composer composer) {
        if (inputFileOrDirectory.isDirectory()) {
            Arrays.stream(inputFileOrDirectory.listFiles())
                    .filter(file -> file.getName().endsWith(".txt"))
                    .forEach(file -> processIndividualFile(file, composer));
        } else if (inputFileOrDirectory.isFile() && inputFileOrDirectory.getName().endsWith(".txt")) {
            processIndividualFile(inputFileOrDirectory, composer);
        }
    }

    private void processIndividualFile(File file, Composer composer) {
        String fileName = file.getName();
        Transformer transformer = getTransformer(fileName);

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
    private Transformer getTransformer(String fileName) {
        String lowerFileName = fileName.toLowerCase();

        if (lowerFileName.equals("foiclass.txt")) {
            return new FoiClassTransformer(namespace, gudidUtility);
        } else if (lowerFileName.equals("device.txt")) {
            return new DeviceTransformer(namespace, gudidUtility);
        } else if (lowerFileName.equals("identifiers.txt")) {
            return new GudidIdentifierTransformer(namespace, gudidUtility);
        } else if (lowerFileName.equals("productcodes.txt")) {
            return new ProductCodeTransformer(namespace, gudidUtility);
        }

        return null;
    }

    public UUID getNamespace() {
        return namespace;
    }

    public GudidUtility getGudidUtility() {
        return gudidUtility;
    }
}
