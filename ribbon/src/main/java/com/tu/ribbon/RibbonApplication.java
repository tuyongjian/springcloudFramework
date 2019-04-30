package com.tu.ribbon;

import com.tu.ribbon.config.RibbonConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Classname RibbonApplication
 * @Date 2019/4/30 15:01
 * @Created by tuyongjian
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableDiscoveryClient
@RibbonClient(name = "Ribbon-Server",configuration = RibbonConfig.class)
public class RibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class,args);
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