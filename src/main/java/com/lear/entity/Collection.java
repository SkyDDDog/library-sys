package com.lear.entity;


import com.lear.entity.base.DataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * collection数据库实体类
 * @author 天狗
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Collection extends DataEntity<Collection> {

    // 用户id
    @NotNull(message = "用户id不能为空")
    private String userId;
    // 书籍id
    @NotNull(message = "书籍id不能为空")
    private String bookId;

}
