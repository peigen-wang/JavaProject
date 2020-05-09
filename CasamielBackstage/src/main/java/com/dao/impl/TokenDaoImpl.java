package com.dao.impl;

import com.dao.TokenDao;
import com.domain.entity.TokenEntity;
import org.springframework.stereotype.Repository;

@Repository("tokenDao")
public class TokenDaoImpl extends BaseDaoImpl<TokenEntity> implements TokenDao {
}
