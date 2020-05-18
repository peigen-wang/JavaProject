package com.javacode2020.lesson001.demo14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service2 {
    private Service1 service1;

   /* public Service2(){
        System.out.println(this.getClass()+"无参构造");
    }

    @Autowired
    public Service2(Service1 service1){
        System.out.println(this.getClass()+"有参构造");
        this.service1=service1;
    }*/

   /* @Autowired
    public void setService1(Service1 service1) { //@1
        System.out.println(this.getClass().getName() + ".setService1方法");
        this.service1 = service1;
    }*/

    @Autowired
    public void injectService1(Service1 service1, @Autowired(required = false) String name) { //@1
        System.out.println(String.format("%s.injectService1(),{service1=%s,name=%s}", this.getClass().getName(), service1, name));
        this.service1 = service1;
    }

    @Override
    public String toString() {
        return "Service2{" +
                "service1=" + service1 +
                '}';
    }
}
