package com.javacode2020.lesson001.demo12;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class ConfigBean2 {

    @Bean
    public ServiceA serviceA(){
        System.out.println("调用ServiceA方法");
        return new ServiceA();
    }

    @Bean
    ServiceB serviceB1(){
        System.out.println("调用serviceB1()方法");
        ServiceA serviceA = this.serviceA();
        return new ServiceB(serviceA);
    }

    @Bean
    ServiceB serviceB2(){
        System.out.println("调用serviceB2()方法");
        ServiceA serviceA = this.serviceA();
        return new ServiceB(serviceA);
    }


}
