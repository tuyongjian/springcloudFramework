package com.tu.feign.controller;

import com.tu.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description feign action
 * @Classname FeignAction
 * @Date 2019/5/10 15:59
 * @Created by tuyongjian
 */
@RestController
@RequestMapping(value = "feign")
public class FeignAction {

    @Autowired
    FeignService feignService;

    @RequestMapping(value = "test" ,method = RequestMethod.GET)
    public String test(){
        return "Hello World";
    }

    @RequestMapping(value = "getPort" ,method = RequestMethod.GET)
    public String getPort(){
        return feignService.getPort();
    }

    @RequestMapping(value = "getName",method = RequestMethod.GET)
    public String getName(){
        String name ="tuyongjian";
        return feignService.getName(name);
    }
}