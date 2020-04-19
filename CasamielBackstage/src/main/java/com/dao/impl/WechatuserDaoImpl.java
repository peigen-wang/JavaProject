package com.dao.impl;

import com.dao.WechatuserDao;
import com.domain.entity.WechatuserEntity;
import org.springframework.stereotype.Repository;

@Repository("wechatuserDao")
public class WechatuserDaoImpl extends BaseDaoImpl<WechatuserEntity> implements WechatuserDao {
}
