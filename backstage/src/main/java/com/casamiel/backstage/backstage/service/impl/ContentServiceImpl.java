package com.casamiel.backstage.backstage.service.impl;

import com.casamiel.backstage.backstage.entity.Content;
import com.casamiel.backstage.backstage.mapper.ContentMapper;
import com.casamiel.backstage.backstage.service.ContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author peigen
 * @since 2020-05-18
 */
@Service
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements ContentService {

}
