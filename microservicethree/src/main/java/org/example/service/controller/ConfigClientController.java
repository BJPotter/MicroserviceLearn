package org.example.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConfigClientController {
    @GetMapping("/three/hello")
    public String getMessage() {
        return "hello,i am  microservice three";
    }
}
