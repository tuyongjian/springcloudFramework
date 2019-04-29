package com.tu.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Description eureka启动类，eureka是springcloud的服务注册中心
 * 可以把服务注册到注册中心，进行集中管理
 *
 * @Classname EurekaApplication
 * @Date 2019/4/29 15:11
 * @Created by tuyongjian
 *
 * EnableEurekaServer 注解开启eureka服务
 */
@EnableEurekaServer
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class,args);
    }
}