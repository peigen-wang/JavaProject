package com.javacode2020.lesson001.demo3;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        //1.bean配置文件位置
        String beanXml = "classpath:/com/javacode2020/lesson001/demo3/bean.xml";

        //2.创建ClassPathXmlApplicationContext容器，给容器指定需要加载的bean配置文件
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        System.out.println("spring容器中所有bean如下：");

        //getBeanDefinitionNames用于获取容器中所有bean的名称
        for (String beanName : context.getBeanDefinitionNames()) {
            System.out.println(beanName + ":" + context.getBean(beanName));
        }

    }
}
