package com.lear.controller;

import com.lear.common.CommonResult;
import com.lear.entity.User;
import com.lear.entity.dto.UpdatePasswordDTO;
import com.lear.entity.dto.UserLoginDTO;
import com.lear.entity.dto.UserRegisterDTO;
import com.lear.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户控制器
 * @author 天狗
 */
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping(value = "${apiPath}/user")
@Api(value = "UserController", tags = "用户接口")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CommonResult register(@Validated @RequestBody @ApiParam("用户注册dto") UserRegisterDTO req,
                                 BindingResult bindingResult) {
        CommonResult result = new CommonResult().init();
        if (bindingResult.hasErrors()) {
            return (CommonResult) result.failIllegalArgument(bindingResult.getFieldErrors()).end();
        }
        User registerUser = userService.getByLoginUsername(req.getNickname());
        if (registerUser!= null) {
            return (CommonResult) result.failCustom("用户名已存在").end();
        }
        registerUser = new User();
        BeanUtils.copyProperties(req, registerUser);
        registerUser.setNickName(req.getNickname());
        if (0 < userService.register(registerUser)) {
            result.success();
        } else {
            result.failCustom("注册失败");
        }
        return (CommonResult) result.end();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public CommonResult login(@Validated @RequestBody @ApiParam("用户登录dto") UserLoginDTO req,
                              BindingResult bindingResult) {
        CommonResult result = new CommonResult().init();
        if (bindingResult.hasErrors()) {
            return (CommonResult) result.failIllegalArgument(bindingResult.getFieldErrors()).end();
        }
        User loginUser = userService.login(req.getNickname(), req.getPassword());
        if (loginUser!=null) {
            result.success("user", loginUser);
        } else {
            result.failCustom("登陆失败");
        }

        return (CommonResult) result.end();
    }

//    @RequestMapping(value = "pwd", method = RequestMethod.PUT)
    public CommonResult updatePassword(@Validated @RequestBody @ApiParam("修改密码dto")UpdatePasswordDTO req,
                                       BindingResult bindingResult) {
        CommonResult result = new CommonResult().init();
        if (bindingResult.hasErrors()) {
            return (CommonResult) result.failIllegalArgument(bindingResult.getFieldErrors()).end();
        }
        //TODO
        // 修改密码参数?


        return (CommonResult) result.end();
    }


}
