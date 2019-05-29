package com.tu.configClient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Classname configClientAction
 * @Date 2019/5/29 10:33
 * @Created by tuyongjian
 */
@RefreshScope
@RestController
@RequestMapping(value = "configClient")
public class configClientAction {

    @Value("${tu}")
    String tu;

    @RequestMapping(value = "tu",method = RequestMethod.GET)
    public String tu(){
        return tu;
    }
}