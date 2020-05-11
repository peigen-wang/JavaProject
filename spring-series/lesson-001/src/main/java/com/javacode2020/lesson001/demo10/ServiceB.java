package com.javacode2020.lesson001.demo10;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ServiceB implements ApplicationContextAware {

    public ServiceA getServiceA() {
        return this.applicationContext.getBean(ServiceA.class);
    }



    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext =applicationContext;
    }
}
