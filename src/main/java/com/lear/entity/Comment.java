package com.lear.entity;

import com.lear.entity.base.DataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * comment数据库实体类
 * @author 天狗
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Comment extends DataEntity<Comment> {

    // 内容
    private String content;
    // 评分
    private Integer score;
    // 书籍isbn
    private String bookIsbn;
    // 用户id
    private String userId;

}
