package iducs.springboot.blog;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Blog201912061ApplicationTests {
    private static Logger logger = null;

    @BeforeEach
    public void setLogger() {
        System.setProperty("log4j.configurationFile", "log4j2.yml");
        logger = LogManager.getLogger();
    }

    @RepeatedTest(2)
    void givenLoggerWithDefaultConfig_whenLogToConsole_thanOK() {
        Exception e = new RuntimeException("Hello World!");

        logger.info("THIS IS INFO LEVEL LOG");
        logger.debug("THIS IS DEBUG LEVEL LOG");
        logger.error("THIS IS ERROR LEVEL LOG.", e);
        logger.fatal("THIS IS FATAL LEVEL LOG.");
    }
}
