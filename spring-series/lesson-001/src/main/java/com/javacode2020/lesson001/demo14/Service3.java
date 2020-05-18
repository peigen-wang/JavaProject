package com.javacode2020.lesson001.demo14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service3 {
    @Autowired
    private Service1 service1;//@1

    @Autowired
    private Service2 service2;//@2

    @Override
    public String toString() {
        return "Service3{" +
                "service1=" + service1 +
                ", service2=" + service2 +
                '}';
    }
}
