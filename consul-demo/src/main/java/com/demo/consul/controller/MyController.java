package com.demo.consul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{param}")
    public String serviceUrl(@PathVariable String param) {
        List<ServiceInstance> list = discoveryClient.getInstances(param);
        if (list != null && !list.isEmpty()) {
            return list.get(0).getUri().toString();
        }
        return null;
    }
}
