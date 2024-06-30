package org.example.service.controller;

import org.example.service.fegin.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class ConfigClientController {
    @Autowired
    private  RestTemplate restTemplate;

    @Autowired
    HelloService helloService;


    @Value("${message:Default Hello}")
    private String message;

    @GetMapping("/one/hello")
    public String getHello() {

        return message;
    }

    @GetMapping("/one/helloGateway")
    public String getHelloGateway() {

        return "hello,gateway";
    }

    @GetMapping("/one/open")
    public String getOpen() {
        String hello = helloService.hello();
        return "i am open!" + hello;
    }


    @GetMapping("/one/message")
    public String getMessage() {
        String url = "http://microservice-three/three/hello";
        return message+restTemplate.getForObject(url, String.class);
    }
}
