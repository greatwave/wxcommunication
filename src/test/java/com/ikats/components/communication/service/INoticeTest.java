package com.ikats.components.communication.service;

import com.ikats.components.filemanager.storage.handler.FileStorageFactory;
import com.ikats.framework.business.service.ServiceResult;
import com.ikats.framework.utils.DateUtils;
import com.ikats.framework.utils.FileUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class INoticeTest {
    private Logger logger = LoggerFactory.getLogger(INoticeTest.class);

    @Autowired
    FileStorageFactory fileStorageFactory;

    @Test
    void sendNotice() {
        logger.info("start testing");
        try {
            File f = new File("test.txt");
            FileUtils.write(f, String.format("%s - this is a testing file", DateUtils.getCurrentDateTime()), StandardCharsets.UTF_8);
            ServiceResult<String> result = fileStorageFactory.uploadFile(null, "communcation", f);
            logger.info(result.toJsonString());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}