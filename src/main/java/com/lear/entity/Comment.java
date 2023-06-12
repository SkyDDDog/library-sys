package com.lear.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.lear.entity.base.DataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;

/**
 * comment数据库实体类
 * @author 天狗
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Comment extends DataEntity<Comment> {

    // 内容
    @NotNull(message = "内容不能为空")
    private String content;
    // 评分
    @Max(value = 5, message = "评分最大为5")
    @Min(value = 0, message = "评分最小为0")
    @Digits(integer = 1, fraction = 0, message = "评分必须为整数")
    private Integer score;
    // 书籍id
    @NotEmpty(message = "书籍isbn不能为空")
    private String bookId;
    // 用户id
    @NotEmpty(message = "用户id不能为空")
    private String userId;

}
