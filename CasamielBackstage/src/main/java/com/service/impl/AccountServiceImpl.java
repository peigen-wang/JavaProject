package com.service.impl;

import com.commom.MethodResultFull;
import com.dao.MemberDao;
import com.domain.entity.MemberEntity;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private MemberDao memberDao;

    @Override
    @Transactional
    public MethodResultFull<MemberEntity> getById(int id) {
        MemberEntity memberEntity = memberDao.get(id);
        return new MethodResultFull<>(memberEntity);
    }
}
