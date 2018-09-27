package com.example.springmall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableCircuitBreaker
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMallApplication.class, args);
    }
}
