package org.example.service.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "microservice-three")
public interface HelloService {
    @GetMapping("/three/hello")
    String hello() ;
}
