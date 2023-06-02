package com.lear.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录参数
 * @author 天狗
 */
@Data
public class UserLoginDTO {

    @ApiModelProperty(value = "用户名", example = "test")
    @NotBlank(message = "用户名不能为空")
    private String nickname;

    @ApiModelProperty(value = "密码", example = "123456")
    @NotBlank(message = "密码不能为空")
    private String password;

}
