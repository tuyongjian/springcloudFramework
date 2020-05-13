package com.tu.nacosConsumer.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description  对feignService 提供的服务降级服务
 * @Classname FeignFallBack
 * @Date 2019/5/10 16:46
 * @Created by tuyongjian
 */
@Component
public class FeignFallBack implements FeignService {

    @Override
    public String getMsg() {
        return "This is feignFallBack msg";
    }


}