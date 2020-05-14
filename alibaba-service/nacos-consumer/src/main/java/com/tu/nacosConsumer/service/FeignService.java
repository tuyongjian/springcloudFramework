package com.tu.nacosConsumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description 测试feign的功能
 * @Classname FeignService
 * @Date 2019/5/10 15:17
 * @Created by tuyongjian
 *
 *@FeignClient(value = "Server")
 * 声明调用按个服务，这个的Server 就是ribbon-server-1模块的spring.application.name名字
 * 因为这个名字是注册到eureka中的，所以调用的话，是使用这个
 *
 * fallback = FeignFallBack.class 指定服务降级的类，当调用的远程接口不可用时，会返回服务降级的内容
 */
@FeignClient(value = "nacos-cloud-provider",fallback = FeignFallBack.class)
public interface FeignService {

    /***
     *  server/port server/getName 等都是ribbon-server 模块中提供的接口名字
     * @return
     */

     @RequestMapping(value = "/nacosProvider/test",method = RequestMethod.GET)
     String getMsg();


}