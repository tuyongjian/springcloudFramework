package com.tu.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Classname TestAction
 * @Date 2019/4/19 13:35
 * @Created by tuyongjian
 */
@RestController
public class TestAction {

    @GetMapping("index")
    public String index(){
        return "Hello world";
    }
}