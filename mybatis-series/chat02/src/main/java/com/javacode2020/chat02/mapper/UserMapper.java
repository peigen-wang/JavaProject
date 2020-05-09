package com.javacode2020.chat02.mapper;

import com.javacode2020.chat02.UserFindDto;
import com.javacode2020.chat02.UserModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.ResultHandler;


import java.util.List;
import java.util.Map;

public interface UserMapper {

    int insertUser(UserModel model);

    List<UserModel> getUserList();

    UserModel getByName(String name);

    List<UserModel> getByMap(Map<String, Object> map);

    List<UserModel> getListByUserFindDto(UserFindDto userFindDto);

    UserModel getByIdOrName(@Param("userId") Long id, @Param("userName") String name);

    void getList(ResultHandler<UserModel> resultHandler);

    List<UserModel> getListByIds(List<Long> ids);
}
