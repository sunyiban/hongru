package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @autor sunyiban
 * @date 2019/7/24 10:37
 * @descrpition
 */
@SpringBootApplication
//@ComponentScan(basePackages = "com")
//@ServletComponentScan(basePackages = "com.filter")
public class SunhongruApplication {

    public static void main(String[] args) {
        SpringApplication.run(SunhongruApplication.class, args);
    }

}
