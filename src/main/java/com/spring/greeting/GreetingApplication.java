package com.spring.greeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GreetingApplication {
    public static void main(String[] args) {
        System.out.println("Welcome to the Greeting App");
        SpringApplication.run(GreetingApplication.class, args);
    }

}
