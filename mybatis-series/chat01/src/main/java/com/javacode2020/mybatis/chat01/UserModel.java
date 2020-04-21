package com.javacode2020.mybatis.chat01;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserModel {
    private Long id;
    private String name;
    private Integer age;
    private Double salary;
}
