package com.javacode2020.chat02;

import java.util.List;

public interface UserMapper {

    int insertUser(UserModel model);

    List<UserModel> getUserList();
}
