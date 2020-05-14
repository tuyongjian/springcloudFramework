package com.tu.nacosConsumer.controller;

import com.tu.nacosConsumer.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "nacosConsumer")
public class NacosAction {

    @Autowired
    private FeignService feginService;

    @GetMapping("/test")
    public String test(){
        return feginService.getMsg();
    }
}
