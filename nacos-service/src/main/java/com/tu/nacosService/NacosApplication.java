package com.tu.nacosService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * nacos
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosApplication
{
        public static void main( String[] args ) throws InterruptedException {
            SpringApplication.run(NacosApplication.class, args);
        }
}
