package com.tu.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @Auther: tuyongjian
 * @Date: 2020/3/9 10:29
 * @Description: springcloud 提供的新的网关服务
 *
 * gateway是使用webFlue框架实现的，所以不能引入spring-boot-starter-web包
 *
 * gateway
 * 参考网址
 * https://www.cnblogs.com/crazymakercircle/p/11704077.html
 * https://www.cnblogs.com/qianwei/p/10127700.html
 * https://www.cnblogs.com/crazymakercircle/p/11704077.html
 * https://www.jianshu.com/p/5e40bbc95eb9
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
public class GateWayApplication {




    /**
     * 访问 http://localhost:1122/gateway/serverAction/post就可以访问到server里面的服务
     *
     *
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder){
        return builder.routes().route(
                r->r.path("/gateway/**")
                        //这个过滤的作用是去除一个url前缀，在这里就是去除gateway.不然请求url
                        //会带着gateway
                        .filters(f->f.stripPrefix(1))
                        //请求的服务名 lb是负载均衡的意思
                        .uri("lb://server")
                        //路由的id
                        .id("server-route"))
                .build();
    }

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class,args);
    }


}
