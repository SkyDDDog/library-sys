package com.lear.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 书籍借阅dto
 * @author 天狗
 */
@Data
public class BookBorrowDTO {

    @ApiModelProperty(value = "用户id", example = "1662687163094454274")
    @NotBlank(message = "用户id不能为空")
    private String userId;
    @ApiModelProperty(value = "书籍id", example = "9787020166930")
    @NotBlank(message = "书籍id不能为空")
    private String bookId;

}
