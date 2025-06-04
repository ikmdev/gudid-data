package dev.ikm.tinkar.gudid.integration;

import dev.ikm.maven.RxnormData;
import dev.ikm.maven.RxnormUtility;
import dev.ikm.tinkar.common.service.CachingService;
import dev.ikm.tinkar.common.service.PrimitiveData;
import dev.ikm.tinkar.common.service.ServiceKeys;
import dev.ikm.tinkar.common.service.ServiceProperties;
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
import java.util.List;
import java.util.UUID;

public abstract class AbstractIntegrationTest {
    Logger LOG = LoggerFactory.getLogger(AbstractIntegrationTest.class);
    static String namespaceString;
    static String gudIdFileName;
    static long timeForStamp;

    @AfterAll
    public static void shutdown() {
        PrimitiveData.stop();
    }

    @BeforeAll
    public static void setup() throws IOException {
        CachingService.clearAll();
        //Note. Dataset needed to be generated within repo, with command 'mvn clean install'
        namespaceString = System.getProperty("origin.namespace"); // property set in pom.xml
        File datastore = new File(System.getProperty("datastorePath")); // property set in pom.xml
        ServiceProperties.set(ServiceKeys.DATA_STORE_ROOT, datastore);
        PrimitiveData.selectControllerByName("Open SpinedArrayStore");
        PrimitiveData.start();
        gudIdFileName = System.getProperty("source.zip"); // property set in pom.xml
        timeForStamp = GudIdUtility.parseTimeFromFileName(gudIdFileName);
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
        return -1;
    }

    /**
     *
     * @param fileName
     * @return Content of file into a String
     * @throws IOException
     */
    private String readFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    protected UUID conceptUuid(String id) {
        return null;
    }

    protected abstract boolean assertOwlElement();
}
