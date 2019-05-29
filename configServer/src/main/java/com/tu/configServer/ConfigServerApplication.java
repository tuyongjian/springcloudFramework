package com.tu.configServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by tuyongjian on 2019/5/20.
 * EnableConfigServer 开启config服务端
 *
 * 在 git上面有一个配置中心，tu是其中一个配置的文件的一个属性，，dev是文件名的环境，访问以下路径可以查看
 * 配置中心内容
 * http://localhost:1119/tu/dev
 *
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServerApplication{
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class,args);
    }
}












