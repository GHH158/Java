package com.ghh.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BeanFactory {
    private static Properties env = new Properties();
    //    通过Properties将属性文件读取进来
    // 避免重复的读取开启流线程，这里采用静态代码块完成
    static {
        try {
            // 第一步 获得IO输入流
            InputStream ins = BeanFactory.class.getResourceAsStream("applicationContext.properties");
            // 第二步 文件内容封装到Properties集合中
            env.load(ins);
            ins.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建Bean的构造工厂
     *
     * @param beanName 需要实例化的Bean名
     * @return 创建的实例化对象
     */
    public static Object getBean(String beanName) {
        Object obj = null;
        try {
            Class clz = Class.forName(env.getProperty(beanName));
            obj = clz.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
