package com.cunjunwang.zuulhystrixdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableZuulProxy
@RestController
public class ZuulHystrixDemoApplication {

    @Value("${myName}")
    private String myName;

    public static void main(String[] args) {
        SpringApplication.run(ZuulHystrixDemoApplication.class, args);
    }

    @GetMapping(value = "/")
    public String greeting() {
        return "Hello, " + myName;
    }
}
