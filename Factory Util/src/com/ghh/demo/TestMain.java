package com.ghh.demo;

import org.omg.Messaging.SyncScopeHelper;

public class TestMain {
    public static void main(String[] args) {
        User user = (User) BeanFactory.getBean("user");
        System.out.println(user);
    }
}