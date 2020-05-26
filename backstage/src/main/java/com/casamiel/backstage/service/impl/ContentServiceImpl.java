package com.casamiel.backstage.service.impl;

import com.casamiel.backstage.entity.Content;
import com.casamiel.backstage.mapper.ContentMapper;
import com.casamiel.backstage.service.ContentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author peigen
 * @since 2020-05-23
 */
@Service
public class ContentServiceImpl extends ServiceImpl<ContentMapper, Content> implements ContentService {

}
