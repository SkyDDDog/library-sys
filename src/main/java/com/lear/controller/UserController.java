package com.lear.controller;

import com.lear.common.CommonResult;
import com.lear.entity.Collection;
import com.lear.entity.LentInfo;
import com.lear.entity.User;
import com.lear.entity.dto.UpdatePasswordDTO;
import com.lear.entity.dto.UserLoginDTO;
import com.lear.entity.dto.UserRegisterDTO;
import com.lear.entity.dto.UserUpdateDTO;
import com.lear.service.CollectionService;
import com.lear.service.LentInfoService;
import com.lear.service.UserService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private LentInfoService lentInfoService;

    @ApiOperation(value = "用户注册")
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

    @ApiOperation(value = "用户登录")
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

    @ApiOperation(value = "修改用户信息")
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public CommonResult updateInfo(@Validated @RequestBody @ApiParam("修改信息dto") UserUpdateDTO req,
                                   BindingResult bindingResult) {
        CommonResult result = new CommonResult().init();
        if (bindingResult.hasErrors()) {
            return (CommonResult) result.failIllegalArgument(bindingResult.getFieldErrors()).end();
        }

        User updateUser = new User();
        updateUser.setId(req.getUserId());
        updateUser.setNewRecord(false);
        updateUser.setNickName(req.getNickname())
                .setPhone(req.getTel())
                .setNickName(req.getNickname());
        if (req.getPassword()!=null) {
            updateUser.setPassword(UserService.entryptPassword(req.getPassword()));
        }

        if (0 < userService.save(updateUser)) {
            result.success();
        } else {
            result.fail();
        }

        return (CommonResult) result.end();
    }

    @ApiOperation(value = "我的喜欢")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "userId",
                    value = "用户id",
                    required = true,
                    paramType = "path",
                    dataType = "String"
            )
    })
    @RequestMapping(value = "/collect/{userId}", method = RequestMethod.GET)
    public CommonResult myCollect(@PathVariable String userId) {
        CommonResult result = new CommonResult().init();
        List<Collection> list = collectionService.collectionList(userId);
        result.success("collect", collectionService.buildCollectionListVO(list));

        return (CommonResult) result.end();
    }

    @ApiOperation(value = "我的借阅")
    @RequestMapping(value = "/borrow/{userId}", method = RequestMethod.GET)
    public CommonResult myBorrow(@PathVariable String userId) {
        CommonResult result = new CommonResult().init();
        List<LentInfo> list = lentInfoService.borrowList(userId);
        result.success("borrow", lentInfoService.buildBorrowListVO(list));

        return (CommonResult) result.end();
    }

}
