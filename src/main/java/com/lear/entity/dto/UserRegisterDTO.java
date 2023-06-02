package com.lear.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.Example;
import io.swagger.annotations.ExampleProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户注册参数
 * @author 天狗
 */
@Data
public class UserRegisterDTO {

    @ApiModelProperty(value = "用户名", example = "test")
    @NotBlank(message = "用户名不能为空")
    private String nickname;

    @ApiModelProperty(value = "密码", example = "123456")
    @NotBlank(message = "密码不能为空")
    private String password;

    @ApiModelProperty(value = "邮箱", example = "362664609@qq.com")
    @NotBlank(message = "邮箱不能为空")
    private String email;

    @ApiModelProperty(value = "手机号", example = "12345678901")
    @NotBlank(message = "手机号不能为空")
    private String phone;
}
