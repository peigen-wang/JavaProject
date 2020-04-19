package com.dao.impl;

import com.dao.NewsDao;
import com.domain.entity.NewsEntity;
import org.springframework.stereotype.Repository;

@Repository("newsDao")
public class NewsDaoImpl extends BaseDaoImpl<NewsEntity> implements NewsDao {
}
