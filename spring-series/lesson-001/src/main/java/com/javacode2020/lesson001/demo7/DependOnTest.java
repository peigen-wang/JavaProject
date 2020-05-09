package com.javacode2020.lesson001.demo7;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DependOnTest {
    /**
     * 无依赖的bean创建和销毁的顺序
     */
    @Test
    public void normalBean() {
        System.out.println("容器启动中!");
        String beanXml = "classpath:/com/javacode2020/lesson001/demo7/normalBean.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
        System.out.println("容器启动完毕，准备关闭spring容器!");
        //关闭容器
        context.close();
        System.out.println("spring容器已关闭!");
    }
}
