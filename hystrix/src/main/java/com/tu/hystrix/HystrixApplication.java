package com.tu.hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description 熔断服务启动项
 * @Classname HystrixApplication
 * @Date 2019/5/6 14:53
 * @Created by tuyongjian
 *
 * EnableCircuitBreaker 开启hystrix
 * EnableEurekaClient 注册成为eureka客户端
 * EnableDiscoveryClient 让服务可以被发现
 *
 */
@EnableDiscoveryClient
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HystrixApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixApplication.class,args);
    }

    /**
     * Spring 提供的rest访问模板，loadBalances实现负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}