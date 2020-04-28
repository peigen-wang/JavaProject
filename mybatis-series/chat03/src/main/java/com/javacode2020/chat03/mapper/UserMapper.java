package com.javacode2020.chat03.mapper;

import com.javacode2020.chat03.UserModel;

public interface UserMapper {


    /**
     * 插入
     *
     * @param model
     * @return
     */
    int insertUser(UserModel model);

    /**
     * 更新
     *
     * @param model
     * @return
     */
    long updateUser(UserModel model);

    /**
     * 删除
     *
     * @param userId
     * @return
     */
    boolean deleteUser(Long userId);
}
