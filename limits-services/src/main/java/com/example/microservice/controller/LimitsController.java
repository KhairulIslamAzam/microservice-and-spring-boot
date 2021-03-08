package com.example.microservice.controller;

import com.example.microservice.bean.Limits;
import com.example.microservice.configuration.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    private final Configuration configuration;

    public LimitsController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/limits")
    public Limits retreiveLimits(){
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
    }

}
