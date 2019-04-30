package com.tu.ribbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 自定义ribbon规则
 * @Classname RibbonConfig
 * @Date 2019/4/30 15:59
 * @Created by tuyongjian
 */
@Configuration
public class RibbonConfig {

    public IRule ribbonRule(){
        return new RandomRule();
    }


}