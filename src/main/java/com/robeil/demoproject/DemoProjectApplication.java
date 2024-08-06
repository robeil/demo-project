package com.robeil.demoproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoProjectApplication {
    private static final Logger logger = LoggerFactory.getLogger(DemoProjectApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoProjectApplication.class, args);
        System.out.println("Gradle Project is up and running");
        logger.info("After adding this comment the application is restarted");
    }
}
