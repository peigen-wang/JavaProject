package com.javacode2020.lesson001.demo10;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LookupMethodTest {

    @Test
    public void normalBean() {
        String beanXml = "classpath:/com/javacode2020/lesson001/demo10/normalBean.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);

        System.out.println(context.getBean(ServiceA.class));
        System.out.println(context.getBean(ServiceA.class));

        System.out.println("serviceB中的serviceA");
        ServiceB serviceB = context.getBean(ServiceB.class);
        System.out.println(serviceB.getServiceA());
        System.out.println(serviceB.getServiceA());
    }
}
