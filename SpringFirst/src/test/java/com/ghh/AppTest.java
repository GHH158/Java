package com.ghh;

import static org.junit.Assert.assertTrue;

import com.ghh.basic.Person;
import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * SpringBasic的测试方法
     */
    @Test
    public void springBasic() {
        // 创建spring的工厂实现
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        // 通过工厂类得到实例对象
        Person person = (Person) ctx.getBean("person");
        System.out.println("person = " + person);
    }

    /**
     * Spring工厂提供的其他方法
     */
    @Test
    public void springBasic1() {
        // 创建Spring的工厂实现
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取Bean的第一种方式
        //Person person = (Person) ctx.getBean("person");
        //System.out.println("person = " + person);

        // 获取Bean的第二种方式
        // Person person = ctx.getBean("person", Person.class);
        // System.out.println("person = " + person);

        // 获取Bean的第三种方式
        // 这种方式创建Bean有一个定义就是配置文件只能存在一个该类的对象，否则就会报错
        //Person person = ctx.getBean(Person.class);
        //System.out.println("person = " + person);

        // 获取配置文件里的所有Bean的id
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }

        // 根据类的类型获取Bean的Id
        String[] beanNamesForTypes = ctx.getBeanNamesForType(Person.class);
        for (String beanNamesForType : beanNamesForTypes) {
            System.out.println("beanNamesForType = " + beanNamesForType);
        }
        // 判断当前配置文件中是否存在对应的Bean
        if (ctx.containsBeanDefinition("person")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        // 获取Bean是否存在
        if (ctx.containsBean("person")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    @Test
    public void springBasic2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = ctx.getBean(Person.class);
        System.out.println("person = " + person);
        //获取Bean的id值
        for (String definitionName : ctx.getBeanDefinitionNames()) {
            System.out.println("definitionName = " + definitionName);
        }
    }
}
