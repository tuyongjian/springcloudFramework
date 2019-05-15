package com.tu.zuul;

import com.tu.zuul.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @Description zuul 是springcloud的智能网关服务，类似于nginx，可以在所有服务的
 * 最前端进行拦截服务，分发服务路由等功能。
 * @Classname ZuulApplication
 * @Date 2019/5/14 17:54
 * @Created by tuyongjian
 *
 * @EnableZuulProxy 注解开启zuul功能 在没有注册中心的情况下也是可以使用zuul功能的
 *
 */
@EnableZuulProxy
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
}