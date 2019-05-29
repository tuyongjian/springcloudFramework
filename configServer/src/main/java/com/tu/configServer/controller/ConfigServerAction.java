package com.tu.configServer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Classname ConfigServerAction
 * @Date 2019/5/29 9:50
 * @Created by tuyongjian
 */
@RestController
@RequestMapping(value = "configServer")
public class ConfigServerAction {

    @Value("${config.name}")
    public String name;

    @RequestMapping(value = "name",method = RequestMethod.GET)
    public String name(){
        return name;
    }

}