package com.javacode2020.lesson001.demo8;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PrimaryBean {
    public interface IService{} //@1
    public static class ServiceA implements IService{} //@2
    public static class ServiceB implements IService{} //@3

    private IService service;
    public void setService(IService service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return "PrimaryBean{" +
                "service=" + service +
                '}';
    }

    @Test
    public void primaryBean() {
        String beanXml = "classpath:/com/javacode2020/lesson001/demo8/primaryBean.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext (beanXml);
        PrimaryBean.IService service = context.getBean(PrimaryBean.IService.class); //@1
        System.out.println(service);
        PrimaryBean primaryBean = context.getBean(PrimaryBean.class); //@2
        System.out.println(primaryBean);
    }
}
