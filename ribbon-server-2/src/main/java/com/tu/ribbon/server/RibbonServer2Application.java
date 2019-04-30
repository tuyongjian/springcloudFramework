package com.tu.ribbon.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Description
 * @Classname RibbonServer2Application
 * @Date 2019/4/30 15:18
 * @Created by tuyongjian
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableEurekaClient
public class RibbonServer2Application {

    public static void main(String[] args) {
        SpringApplication.run(RibbonServer2Application.class,args);
    }
}