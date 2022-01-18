package com.ikats.components.communication.file;

import com.ikats.components.filemanager.storage.handler.FileStorageFactory;
import com.ikats.framework.utils.DateUtils;
import com.ikats.framework.utils.FileUtils;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.nio.charset.StandardCharsets;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FileStorageFactoryTest {
    private Logger logger = LoggerFactory.getLogger(FileStorageFactoryTest.class);

    @Autowired
    FileStorageFactory fileStorageFactory;

    @BeforeEach
     void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void create() {
        logger.info("start testing");
        try {
            File f = new File("test.txt");
            FileUtils.write(f, String.format("%s - this is a testing file", DateUtils.getCurrentDateTime()), StandardCharsets.UTF_8);
            fileStorageFactory.uploadFile(null, "test", f);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}