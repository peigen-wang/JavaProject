package com.javacode2020.lesson001.demo12;

public class ServiceB {
    private ServiceA serviceA;
    public ServiceB(ServiceA serviceA){
        this.serviceA =serviceA;
    }

    @Override
    public String toString() {
        return "ServiceB{" +
                "serviceA=" + serviceA +
                '}';
    }
}
