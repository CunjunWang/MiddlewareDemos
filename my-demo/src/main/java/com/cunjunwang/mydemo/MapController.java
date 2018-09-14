package com.cunjunwang.mydemo;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CunjunWang on 2018/9/1.
 */

@RestController
public class MapController {

    @GetMapping(value = "/getGreeting")
    public String greeting() {
        return "Hello from another demo application.";
    }

    @GetMapping(value = "/shouldNotAccessedByOthers")
    public String info(){
        return "This page should not be accessible to other services";
    }

    @GetMapping(value = "/crossOrigin")
    // 允许Cookie跨域
    @CrossOrigin(allowCredentials = "true")
    public String cross(){
        return "This is for cross origin";
    }

}
