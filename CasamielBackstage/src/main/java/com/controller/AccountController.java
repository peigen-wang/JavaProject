package com.controller;

import com.commom.MethodResultFull;
import com.domain.entity.MemberEntity;
import com.dto.base.BaseModelReq;
import com.dto.base.BaseModelRsp;
import com.dto.base.PagingReq;
import com.dto.base.WapperSingleRsp;
import com.service.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/account")
@Api(description = "用户信息接口")
public class AccountController {

    @Autowired
    private  AccountService accountService;

    @ApiOperation(value = "测试接口")
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    @ResponseBody
    public WapperSingleRsp<MemberEntity> test(int id) {
        MethodResultFull<MemberEntity> result = accountService.getById(id);
        WapperSingleRsp<MemberEntity> rsp = new WapperSingleRsp<MemberEntity>(result);
        rsp.setData(result.getContent());
        return rsp;
    }

    @ApiOperation("测试Json")
    @RequestMapping(value = "/testJson.action", method = RequestMethod.POST)
    @ResponseBody
    public MemberEntity testJson(@RequestBody MemberEntity item) {
        return item;
    }


    @ApiOperation("测试全局验证RequestBody 异常捕获")
    @RequestMapping(value = "/postBaseModelReqByJson",method = RequestMethod.POST)
    @ResponseBody
    public BaseModelRsp postBaseModelReqByJson(@Valid @RequestBody BaseModelReq req){
        return  new BaseModelRsp();
    }

    @ApiOperation("测试全局验证多条验证 异常捕获")
    @RequestMapping(value = "/postPagingReq",method = RequestMethod.POST)
    @ResponseBody
    public BaseModelRsp postPagingReq(@Valid @RequestBody PagingReq req){
        return new BaseModelRsp();
    }

    @ApiOperation("测试全局验证RequestParam 异常捕获")
    @RequestMapping(value = "/postBaseModelReq",method = RequestMethod.POST)
    @ResponseBody
    public BaseModelRsp postBaseModelReq(@Valid BaseModelReq req){
        return  new BaseModelRsp();
    }

    @ApiOperation("测试全局验证getMapping 异常捕获")
    @GetMapping(value = "/get")
    @ResponseBody
    public BaseModelRsp getBaseModelReq(@Valid BaseModelReq req){
        return  new BaseModelRsp();
    }

}
