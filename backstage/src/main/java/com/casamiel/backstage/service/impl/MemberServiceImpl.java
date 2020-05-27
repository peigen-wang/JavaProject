package com.casamiel.backstage.service.impl;

import com.casamiel.backstage.commom.MethodResultFull;
import com.casamiel.backstage.commom.emun.ErrorCodeEnum;
import com.casamiel.backstage.dto.rsp.MemberToken;
import com.casamiel.backstage.entity.Member;
import com.casamiel.backstage.mapper.MemberMapper;
import com.casamiel.backstage.service.MemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author peigen
 * @since 2020-05-23
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {


    @Override
    public MethodResultFull<MemberToken> getmtokenById(int id) {
        MemberToken memberToken = baseMapper.GetMTokenById(id);
        if(memberToken==null)
        {
            return new MethodResultFull<>(ErrorCodeEnum.FrameError);
        }
        MethodResultFull<MemberToken> result = new MethodResultFull<MemberToken>();
        result.setContent(memberToken);
        return result;
    }
}
