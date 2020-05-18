package com.casamiel.backstage.backstage.service.impl;

import com.casamiel.backstage.backstage.entity.User;
import com.casamiel.backstage.backstage.mapper.UserMapper;
import com.casamiel.backstage.backstage.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
