package com.userserviceapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserServiceAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceAppApplication.class, args);
    }

}
