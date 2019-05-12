package com.tu.hystrix.service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.ObservableExecutionMode;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.tu.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.Future;

/**
 * @Description
 * @Classname HystrixService
 * @Date 2019/5/6 16:00
 * @Created by tuyongjian
 *
 * @DefaultProperties(defaultFallback = "defaultFallback") 这个方法是指定统一的熔断方法
 * HystrixCommand  注解后面没有指定的熔断方法都会执行 fallbackMethod方法，
 * 注解后面指定了方法会执行指定的方法，这样做既可以方便指定统一的方法，也可以定制化\
 *
 *
 */
@Service
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 这种调用方式是同步调用
     * @return
     */
    @HystrixCommand(fallbackMethod = "getUserFallBack")
    public User getUser(){
        return restTemplate.getForObject("http://SERVER/server/getUser",User.class);
    }

    /***
     * 这种调用方式是异步调用
     * @return
     */
    @HystrixCommand(fallbackMethod = "getUserFallBack")
    public Future<User> getUserAsync(){
        return new AsyncResult<User>() {
            @Override
            public User invoke() {
                return restTemplate.getForObject("http://SERVER/server/getUser",User.class);
            }
        };
    }

    /**
     * 响应式调用。有二种
     * @HystrixCommand(observableExecutionMode = ObservableExecutionMode.EAGER) 即observe
     * @HystrixCommand(observableExecutionMode = ObservableExecutionMode.LAZY)即 toObservavle
     * observe 这种是 Hot Observable 这个会在observe之后立即调用
     * toObservavle  这种是Cold Ovservable 在toObservable之后不会立即执行，只有当所以订阅者
     * 都订阅之后才会执行
     * @return
     */
    @HystrixCommand(observableExecutionMode = ObservableExecutionMode.EAGER,fallbackMethod ="getUserFallBack" )
    public Observable<User> getUserObservable(){
        return Observable.unsafeCreate(new Observable.OnSubscribe<User>() {
            @Override
            public void call(Subscriber<? super User> observer) {
                try {
                    if(!observer.isUnsubscribed()){
                       User user =  restTemplate.getForObject("http://SERVER/server/getUser",User.class);
                       observer.onNext(user);
                       observer.onCompleted();
                    }
                }catch (Exception e){
                    observer.onError(e);
                }

            }
        });
    }


    @HystrixCommand
    public String testDefaultFallback(){
        return restTemplate.getForObject("http://SERVER/server/port",String.class);
    }


    /***
     * ignoreExceptions = {IndexOutOfBoundsException.class} 忽略这个异常
     * 当调用Server方法是如果发生上面这个异常，则不会进入服务降级fallback方法
     *
     * groupKey 分组，threadPoolKey 线程组，commandKey 命名名称
     *
     * @return
     */
    @CacheResult
    @HystrixCommand(fallbackMethod = "fallback",ignoreExceptions = {IndexOutOfBoundsException.class},
            commandKey = "getPort",groupKey = "UserGroup",threadPoolKey = "getPortThread")
    public String getPort(){
        return restTemplate.getForObject("http://SERVER/server/port",String.class);
    }

    public User getUserFallBack(){
        return new User("test",1);
    }

    public String fallback(){
        return "I am Hystrix ";
    }

    public String defaultFallback(){
        return "I am defaultFallback ";
    }

}