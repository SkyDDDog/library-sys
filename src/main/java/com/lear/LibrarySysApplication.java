package com.lear;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Spring Boot启动类
 * @author 天狗
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class LibrarySysApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibrarySysApplication.class, args);
    }

}
