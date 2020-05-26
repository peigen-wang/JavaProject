package com.casamiel.backstage.service.impl;

import com.casamiel.backstage.entity.Token;
import com.casamiel.backstage.mapper.TokenMapper;
import com.casamiel.backstage.service.TokenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录信息表 服务实现类
 * </p>
 *
 * @author peigen
 * @since 2020-05-23
 */
@Service
public class TokenServiceImpl extends ServiceImpl<TokenMapper, Token> implements TokenService {

}
