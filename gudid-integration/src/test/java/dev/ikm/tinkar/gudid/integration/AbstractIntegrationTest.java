package dev.ikm.tinkar.gudid.integration;

import dev.ikm.maven.GudidUtility;
import dev.ikm.tinkar.common.service.CachingService;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.common.service.ServiceKeys;
import dev.ikm.tinkar.common.service.ServiceProperties;
import dev.ikm.tinkar.common.util.uuid.UuidT5Generator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;

public abstract class AbstractIntegrationTest {
    Logger LOG = LoggerFactory.getLogger(AbstractIntegrationTest.class);
    static String namespaceString;
    static GudidUtility gudidUtilityWithNameSpace;
//    static String gudIdFileName;
    static long timeForStamp;

    static Map<String, Set<String>> primaryDiToProductCodes;
    static String previousPrimaryDi = "";
    static Set<String> productCodes;
    
    @AfterAll
    public static void shutdown() {
        PrimitiveData.stop();
    }

    @BeforeAll
    public static void setup() throws IOException {
        CachingService.clearAll();
        //Note. Dataset needed to be generated within repo, with command 'mvn clean install'
        namespaceString = System.getProperty("origin.namespace"); // property set in pom.xml
        gudidUtilityWithNameSpace = new GudidUtility(UUID.fromString(namespaceString));
        File datastore = new File(System.getProperty("datastorePath")); // property set in pom.xml
        ServiceProperties.set(ServiceKeys.DATA_STORE_ROOT, datastore);
        PrimitiveData.selectControllerByName("Open SpinedArrayStore");
        PrimitiveData.start();
//        gudIdFileName = System.getProperty("source.zip"); // property set in pom.xml
        
        productCodes = null;
    }

    /**
     * Find FilePath
     *
     * @param baseDir
     * @param fileKeyword
     * @return absolutePath
     * @throws IOException
     */
    protected String findFilePath(String baseDir, String fileKeyword) throws IOException {
        try (Stream<Path> dirStream = Files.walk(Paths.get(baseDir))) {
            Path targetDir = dirStream.filter(Files::isDirectory)
//                    .filter(path -> path.toFile().getAbsoluteFile().toString().toLowerCase().contains(dirKeyword.toLowerCase()))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Target DIRECTORY not found"));

            try (Stream<Path> fileStream = Files.walk(targetDir)) {
                Path targetFile = fileStream.filter(Files::isRegularFile)
                        .filter(path -> path.toFile().getAbsoluteFile().toString().toLowerCase().contains(fileKeyword.toLowerCase()))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Target FILE not found for: " + fileKeyword));

                return targetFile.toAbsolutePath().toString();
            }
        }
    }

    /**
     * Process sourceFilePath
     *
     * @param sourceFilePath
     * @param errorFile
     * @return File status, either Found/NotFound
     * @throws IOException
     */
    protected int processFile(String sourceFilePath, String errorFile) throws IOException {
        int notFound = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFilePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(errorFile))) {
            String line;
            while ((line = br.readLine()) != null) {
            	if (line.startsWith("PrimaryDI")) continue;
            	if (line.startsWith("REVIEW_PANEL")) continue;
                if (!assertLine(line.split("\\|", -1))) {
                    notFound++;
                    bw.write(line);
                }
            }
        }
        LOG.info("We found file: " + sourceFilePath);
        return notFound;
    }

    protected UUID conceptUuid(String id) {
        return UuidT5Generator.get(UUID.fromString(namespaceString), "FDA_PRODUCT_CODE_" + id);
    }

    protected UUID conceptUuidForPrimaryDi(String id) {
        return UuidT5Generator.get(UUID.fromString(namespaceString), id);
    }
    
    protected abstract boolean assertLine(String[] columns);

}
