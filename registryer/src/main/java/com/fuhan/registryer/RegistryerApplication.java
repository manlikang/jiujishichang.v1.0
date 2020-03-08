package com.fuhan.registryer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RegistryerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistryerApplication.class, args);
    }

}
