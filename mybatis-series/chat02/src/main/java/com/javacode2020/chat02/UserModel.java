package com.javacode2020.chat02;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author peigen
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {
    private Long id;
    private String name;
    private Integer age;
    private Double salary;
}
