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
 *
 * 重新启动客户端，会重新获取远程的配置文件，同时也会刷新本地缓存的文件内容
 * 如果不重新启动，修改了配置文件 则获取的还是老的配置
 * 可以使用http://localhost:1120/actuator/refresh来手动刷新
 *
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