package com.lear.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 书籍用户dto
 * @author 天狗
 */
@Data
public class BookUserDTO {

    @ApiModelProperty(value = "用户id", example = "1662687163094454274")
    @NotBlank(message = "用户id不能为空")
    private String userId;
    @ApiModelProperty(value = "实体书id", example = "407254816505861")
    @NotBlank(message = "书籍id不能为空")
    private String entityId;

}
