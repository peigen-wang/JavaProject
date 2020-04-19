package com.dao.impl;

import com.dao.NewstypeDao;
import com.domain.entity.NewstypeEntity;
import org.springframework.stereotype.Repository;

@Repository("newstypeDao")
public class NewstypeDaoImpl extends BaseDaoImpl<NewstypeEntity> implements NewstypeDao {
}
