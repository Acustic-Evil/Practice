package com.example.praktika;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;

@SpringBootApplication
public class PraktikaApplication {
    @Async
    public static void main(String[] args) {
        SpringApplication.run(PraktikaApplication.class, args);
    }

}
