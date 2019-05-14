package com.tu.hystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 *
 * 这个模块作为独立工程，使用
 *
 * Created by tuyongjian on 2018/8/12.
 * hystrixdashboard 启动类
 * @EnableHystrixDashboard 启动仪盘功能
 *
 * http://localhost:1115/actuator/hystrix.stream 这样可以监听一个单体服务
 *
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
public class HystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication.class);
    }
}
