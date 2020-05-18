package com.casamiel.backstage.backstage.service.impl;

import com.casamiel.backstage.backstage.entity.News;
import com.casamiel.backstage.backstage.mapper.NewsMapper;
import com.casamiel.backstage.backstage.service.NewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 素材数据 服务实现类
 * </p>
 *
 * @author peigen
 * @since 2020-05-18
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

}
