package com.tu.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tu.common.model.User;
import com.tu.hystrix.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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

    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    private User getUser(){
        return hystrixService.getUser();
    }

    @RequestMapping(value = "getUserAsync",method = RequestMethod.GET)
    private User getUserAsync() throws InterruptedException, ExecutionException{
         Future<User> userFuture = hystrixService.getUserAsync();
         User user = userFuture.get();
         return user;

    }

    @RequestMapping(value = "getUserObservable",method = RequestMethod.GET)
    private User getUserObservable() throws InterruptedException, ExecutionException{
        Observable<User> userObservable = hystrixService.getUserObservable();
        User user = userObservable.toBlocking().single();
        return user;

    }

    @RequestMapping(value = "test",method = RequestMethod.GET)
    private String test(){
        return hystrixService.getPort();
    }

    @RequestMapping(value = "testDefaultFallback",method = RequestMethod.GET)
    private String testDefaultFallback(){
        return hystrixService.testDefaultFallback();
    }


}