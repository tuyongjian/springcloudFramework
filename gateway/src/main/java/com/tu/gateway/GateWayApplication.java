package com.tu.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Auther: tuyongjian
 * @Date: 2020/3/9 10:29
 * @Description: springcloud 提供的新的网关服务
 *
 * gateway是使用webFlue框架实现的，所以不能引入spring-boot-starter-web包
 *
 * gateway
 * 参考网址 https://www.cnblogs.com/qianwei/p/10127700.html
 * https://www.cnblogs.com/crazymakercircle/p/11704077.html
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class,args);
    }
}
