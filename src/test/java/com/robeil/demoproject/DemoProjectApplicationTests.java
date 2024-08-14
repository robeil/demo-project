package com.robeil.demoproject;

import com.robeil.demoproject.controller.CarController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoProjectApplicationTests {

    @Autowired
    private CarController controller;
    @Test
    @DisplayName(("First example test case"))
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
