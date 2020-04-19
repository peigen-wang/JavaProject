package com.dao.impl;

import com.dao.ContentDao;
import com.domain.entity.ContentEntity;
import org.springframework.stereotype.Repository;

/**
 * @author peigen
 */
@Repository("contentDao")
public class ContentDaoImpl extends BaseDaoImpl<ContentEntity> implements ContentDao {
}
