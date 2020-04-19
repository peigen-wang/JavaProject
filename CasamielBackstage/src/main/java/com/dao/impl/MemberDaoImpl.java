package com.dao.impl;

import com.dao.MemberDao;
import com.domain.entity.MemberEntity;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDaoImpl extends BaseDaoImpl<MemberEntity> implements MemberDao {
}
