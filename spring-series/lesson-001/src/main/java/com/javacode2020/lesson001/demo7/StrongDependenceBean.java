package com.javacode2020.lesson001.demo7;

import org.junit.Test;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StrongDependenceBean {
    public static class Bean1 implements DisposableBean{
        public Bean1() {
            System.out.println(this.getClass() + " constructor!");
        }

        @Override
        public void destroy() throws Exception {
            System.out.println(this.getClass() + " destroy()");
        }
    }

    public static class Bean2 implements DisposableBean{
        private Bean1 bean1;
        public Bean2(Bean1 bean1) {
            this.bean1 = bean1;
            System.out.println(this.getClass() + " constructor!");
        }

        @Override
        public void destroy() throws Exception {
            System.out.println(this.getClass() + " destroy()");
        }
    }

    public static class Bean3 implements DisposableBean {

        private Bean2 bean2;

        public Bean3(Bean2 bean2) { //@2
            this.bean2 = bean2;
            System.out.println(this.getClass() + " constructor!");
        }

        @Override
        public void destroy() throws Exception {
            System.out.println(this.getClass() + " destroy()");
        }
    }

    @Test
    public void strongDependenceBean() {
        System.out.println("容器启动中!");
        String beanXml = "classpath:/com/javacode2020/lesson001/demo7/strongDependenceBean.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
        System.out.println("容器启动完毕，准备关闭spring容器!");
        context.close();
        System.out.println("spring容器已关闭!");
    }
}
