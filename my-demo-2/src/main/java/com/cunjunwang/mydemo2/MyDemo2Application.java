package com.cunjunwang.mydemo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyDemo2Application {

    public static void main(String[] args) {
        SpringApplication.run(MyDemo2Application.class, args);
    }

    @PostMapping("/getGreetingDemo2")
    public String greet(@RequestParam String id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "This is message from demo 2" + id;
    }
}
