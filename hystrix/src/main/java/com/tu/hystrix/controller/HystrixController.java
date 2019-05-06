package com.tu.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tu.hystrix.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description 模拟熔断机制action
 * @Classname HystrixController
 * @Date 2019/5/6 15:15
 * @Created by tuyongjian
 */
@RestController
public class HystrixController {

    @Autowired
    HystrixService hystrixService;

    @RequestMapping(value = "test",method = RequestMethod.GET)
    private String test(){
        return hystrixService.test();
    }

    @RequestMapping(value = "testDefaultFallback",method = RequestMethod.GET)
    private String testDefaultFallback(){
        return hystrixService.testDefaultFallback();
    }


}