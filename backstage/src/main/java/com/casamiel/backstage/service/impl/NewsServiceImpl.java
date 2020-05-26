package com.casamiel.backstage.service.impl;

import com.casamiel.backstage.entity.News;
import com.casamiel.backstage.mapper.NewsMapper;
import com.casamiel.backstage.service.NewsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 素材数据 服务实现类
 * </p>
 *
 * @author peigen
 * @since 2020-05-23
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements NewsService {

}
