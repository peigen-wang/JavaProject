package com.casamiel.backstage.backstage.service.impl;

import com.casamiel.backstage.backstage.entity.Member;
import com.casamiel.backstage.backstage.mapper.MemberMapper;
import com.casamiel.backstage.backstage.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author peigen
 * @since 2020-05-18
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {

}
