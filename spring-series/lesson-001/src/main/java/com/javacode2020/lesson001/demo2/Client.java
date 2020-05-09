package com.javacode2020.lesson001.demo2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Client {
    public static void main(String[] agrs){
        String beanXml = "classpath:/com/javacode2020/lesson001/demo2/bean.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
        for (String beanName: Arrays.asList("user1","user2","user3","user4","user5")) {
                String[] aliases = context.getAliases(beanName);
                System.out.println(String.format("beanName:%s,别名:[%s]", beanName, String.join(",", aliases)));
        }
        System.out.println("spring容器中所有bean如下：");
        for (String beanName : context.getBeanDefinitionNames()) {
            //获取bean的别名
            String[] aliases = context.getAliases(beanName);
            System.out.println(String.format("beanName:%s,别名:[%s]", beanName, String.join(",", aliases)));
        }

    }
}
