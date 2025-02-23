package com.pisa.techtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.pisa.techtest")
public class TechTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechTestApplication.class, args);
    }

}
