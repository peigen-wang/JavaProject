package com.javacode2020.lesson001.demo13;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ImportTest {

    @Test
    public void test1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig1.class);
        for (String beanName:context.getBeanDefinitionNames()) {
            System.out.println(String.format("%s->%s",beanName,context.getBean(beanName)));
        }
    }
}
