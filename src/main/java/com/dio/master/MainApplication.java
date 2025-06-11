package com.dio.master;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class MainApplication implements CommandLineRunner {

    public static void main(String[] args) {
        /**/
        SpringApplication.run(MainApplication.class, args);
        System.out.println("ServerUP");
    }

    public void run(String... args) {
        /**/
    }
}