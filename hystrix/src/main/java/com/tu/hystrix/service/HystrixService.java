package com.tu.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Classname HystrixService
 * @Date 2019/5/6 16:00
 * @Created by tuyongjian
 *
 * @DefaultProperties(defaultFallback = "defaultFallback") 这个方法是指定统一的熔断方法
 * HystrixCommand  注解后面没有指定的熔断方法都会执行 fallbackMethod方法，
 * 注解后面指定了方法会执行指定的方法，这样做既可以方便指定统一的方法，也可以定制化
 *
 */
@Service
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand
    public String testDefaultFallback(){
        return restTemplate.getForObject("http://SERVER/ribbon/port",String.class);
    }


    @HystrixCommand(fallbackMethod = "fallback")
    public String test(){
        return restTemplate.getForObject("http://SERVER/ribbon/port",String.class);
    }


    public String fallback(){
        return "I am Hystrix ";
    }

    public String defaultFallback(){
        return "I am defaultFallback ";
    }

}