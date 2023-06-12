package com.lear.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

/**
 * 评论数据传输对象
 * @author 天狗
 */
@Data
public class CommentDTO {

    @ApiModelProperty(value = "用户id", example = "1662687163094454274")
    @NotBlank(message = "用户id不能为空")
    private String userId;

    @ApiModelProperty(value = "书籍id", example = "9787020166930")
    @NotBlank(message = "书籍id不能为空")
    private String bookId;

    @ApiModelProperty(value = "书籍评分", example = "5")
    @Digits(integer = 1, fraction = 0, message = "评分只能为整数")
    private Integer rating;

    @ApiModelProperty(value = "评论内容", example = "666666")
    private String content;


}
