package com.service;


import com.commom.MethodResultBase;
import com.commom.MethodResultFull;
import com.domain.entity.MemberEntity;

public interface AccountService {

    MethodResultFull<MemberEntity> getById(int id);
}
