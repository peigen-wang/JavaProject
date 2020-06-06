package com.casamiel.backstage.controller;



import com.casamiel.backstage.commom.MethodResultFull;
import com.casamiel.backstage.commom.emun.ErrorCodeEnum;
import com.casamiel.backstage.dto.base.BaseModelReq;
import com.casamiel.backstage.dto.base.BaseModelRsp;
import com.casamiel.backstage.dto.base.PagingReq;
import com.casamiel.backstage.dto.base.WapperSingleRsp;
import com.casamiel.backstage.dto.rsp.MemberToken;
import com.casamiel.backstage.entity.Member;
import com.casamiel.backstage.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author peigen
 * @since 2020-05-23
 */
@RestController
@RequestMapping("/backstage/member")
@Api(description = "用户信息接口")
public class MemberController {

    @Autowired
    private MemberService memberService;


    @ApiOperation(value = "测试接口")
    @RequestMapping(value = "/getById", method = RequestMethod.POST)
    public WapperSingleRsp<Member> getById(int id){
        Member result = memberService.getById(id);
        WapperSingleRsp<Member> rsp = new WapperSingleRsp<>();
        rsp.setData(result);
        return rsp;
    }


    @ApiOperation(value = "联表查询测试")
    @PostMapping(value = "/getmtokeById")
    public WapperSingleRsp<MemberToken> getmtokeById(int id){
        MethodResultFull<MemberToken> result = memberService.getmtokenById(id);
        WapperSingleRsp<MemberToken> rsp = new WapperSingleRsp<>(result);
        rsp.setData(result.getContent());
        return rsp;
    }



    @ApiOperation("测试全局验证多条验证 异常捕获")
    @RequestMapping(value = "/postPagingReq", method = RequestMethod.POST)
    @ResponseBody
    public BaseModelRsp postPagingReq(@Valid @RequestBody PagingReq req) {
        return new BaseModelRsp(ErrorCodeEnum.ParamEmpty,"手机号不能为空");
    }

    @ApiOperation(value = "异常测试")
    @RequestMapping(value = "/checkToken",method = RequestMethod.POST)
    public BaseModelRsp checkToken(@Valid @RequestBody BaseModelReq req){
        return  new BaseModelRsp();
    }
}
