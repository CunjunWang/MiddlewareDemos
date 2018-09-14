package com.cunjunwang.mydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "com.cunjunwang")
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
public class MyDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyDemoApplication.class, args);
    }

}
