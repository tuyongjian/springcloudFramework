package com.tu.nacosService.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: tuyongjian
 * @Date: 2020/5/11 10:40
 * @Description:
 */
@RefreshScope
@RestController
@RequestMapping(value = "nacosProvider")
public class NacosAction {

    @Value("${test}")
    private String testProperties;

    @GetMapping("/test")
    public String test(){
        return testProperties;
    }
}
