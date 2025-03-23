package com.nr.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {


    @GetMapping("/studentServiceFallback")
    public String studentServiceFailure() {
        return "Student service failure";
    }
}
