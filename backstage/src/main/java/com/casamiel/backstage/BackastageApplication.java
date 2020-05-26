package com.casamiel.backstage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.casamiel.backstage.mapper")
public class BackastageApplication {
    public static void main(String[] args){
        SpringApplication.run(BackastageApplication.class,args);
    }
}
