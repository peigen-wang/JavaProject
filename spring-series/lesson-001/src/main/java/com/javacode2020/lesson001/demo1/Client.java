package com.javacode2020.lesson001.demo1;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args){
        String beanXml = "classpath:/com/javacode2020/lesson001/demo1/bean.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
        HelloWorld helloWorld = context.getBean("helloWorld",HelloWorld.class);
        helloWorld.say();
    }
}
