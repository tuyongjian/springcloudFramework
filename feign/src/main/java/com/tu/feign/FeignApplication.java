package com.tu.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Description fegin 模块启动项
 * @Classname FeignApplication
 * @Date 2019/5/10 15:07
 * @Created by tuyongjian
 *
 * fegin 整合了ribbon 和 hystrix 具有这二个模块的功能
 * 例如，客户端的负载均衡，熔断，服务降级等
 *
 * @EnableFeignClients 开启fegin
 */
@EnableFeignClients
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class,args);
    }
}