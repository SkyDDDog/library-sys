package com.lear.entity;


import com.lear.entity.base.DataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * collection数据库实体类
 * @author 天狗
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Collection extends DataEntity<Collection> {

    // 用户id
    private String userId;
    // 书籍isbn
    private String bookIsbn;

}
