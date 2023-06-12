package com.lear.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户更新dto
 * @author 天狗
 */
@Data
public class UserUpdateDTO {

    @ApiModelProperty(value = "用户id", example = "1662687163094454274")
    @NotBlank(message = "用户id不能为空")
    private String userId;
    @ApiModelProperty(value = "用户邮箱", example = "362664609@qq.com")
    private String email;
    @ApiModelProperty(value = "用户电话", example = "18888888888")
    private String tel;
    @ApiModelProperty(value = "用户昵称", example = "天狗")
    private String nickname;
    @ApiModelProperty(value = "用户密码", example = "123456")
    private String password;

}
