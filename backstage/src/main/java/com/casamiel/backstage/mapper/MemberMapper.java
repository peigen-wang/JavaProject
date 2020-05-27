package com.casamiel.backstage.mapper;

import com.casamiel.backstage.dto.rsp.MemberToken;
import com.casamiel.backstage.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author peigen
 * @since 2020-05-23
 */
public interface MemberMapper extends BaseMapper<Member> {

   MemberToken GetMTokenById(int id);
}
