package com.tu.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Classname RibbonController
 * @Date 2019/4/30 15:27
 * @Created by tuyongjian
 */
@RestController
@RequestMapping(value = "RibbonAction")
public class RibbonController {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 测试负载均衡，这里返回的端口会随机出现
     * @return
     */
    @RequestMapping(value = "test",method = RequestMethod.GET)
    private String test(){
        return restTemplate.getForObject("http://Server/serverAction/port",String.class);
    }
}