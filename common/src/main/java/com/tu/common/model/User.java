package com.tu.common.model;

/**
 * Created by tuyongjian on 2019/5/12.
 */
public class User {

    private String userName;

    private Integer age;


    public User() {
    }

    public User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
