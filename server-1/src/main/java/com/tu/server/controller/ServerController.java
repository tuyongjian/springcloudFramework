package com.tu.server.controller;

import com.tu.common.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Classname RibbonServerController
 * @Date 2019/4/30 15:30
 * @Created by tuyongjian
 */
@RestController
@RequestMapping(value = "/serverAction")
public class ServerController {

    @RequestMapping(value = "port",method = RequestMethod.GET)
    private String getPort(){
        return "This port is 1124";
    }


    @RequestMapping(value = "getName",method = RequestMethod.GET)
    private String getName(@RequestParam(value = "name")String name){
        return "my name is "+name;
    }

    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    private User getUser(){
        User user = new User();
        user.setAge(27);
        user.setUserName("tuyongjian");
        return user;
    }
}