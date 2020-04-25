package com.javacode2020.chat02.mapper;

import com.javacode2020.chat02.UserModel;

import java.util.List;

public interface UserMapper {

    int insertUser(UserModel model);

    List<UserModel> getUserList();
}
