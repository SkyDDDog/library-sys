package com.lear.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * 书籍归还dto
 * @author 天狗
 */
@Data
@Accessors(chain = true)
public class BookReturnDTO {

    @ApiModelProperty(value = "用户id", example = "1662687163094454274")
    @NotBlank(message = "用户id不能为空")
    private String userId;
    @ApiModelProperty(value = "实体书id", example = "407254816505861")
    @NotBlank(message = "实体书id不能为空")
    private String entityId;


}
