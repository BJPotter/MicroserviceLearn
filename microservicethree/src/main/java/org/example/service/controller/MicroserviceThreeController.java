package org.example.service.controller;

import org.example.service.service.MicroserviceThreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class MicroserviceThreeController {

    @Autowired
    private MicroserviceThreeService service;

    @GetMapping("/three/call/{url}")
    public CompletableFuture<String> callMicroservice(@PathVariable String url) {
        return service.callMicroservice(url);
    }
}
