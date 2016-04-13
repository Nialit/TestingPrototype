package ru.ddg.prototype.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"ru.ddg.prototype.web"})
@Slf4j
public class Application {
    public static void main(String[] args) {
        logger.info("Start application.");
        SpringApplication.run(Application.class, args);
        logger.info("Application started.");
    }

}
