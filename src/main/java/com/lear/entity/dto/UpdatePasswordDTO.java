package com.lear.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 修改密码参数
 * @author 天狗
 */
@Data
public class UpdatePasswordDTO {

    @ApiModelProperty(value = "用户id", example = "1662687163094454274")
    @NotBlank(message = "用户id不能为空")
    private String id;

    @ApiModelProperty(value = "新密码", example = "123456")
    @NotBlank(message = "新密码不能为空")
    private String password;


}
