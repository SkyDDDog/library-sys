package com.lear.entity;

import com.lear.entity.base.DataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * library数据库实体类
 * @author 天狗
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Library extends DataEntity<Library> {

    // 用户id
    private String bookId;
    // 书籍isbn
    private String bookIsbn;
    // 借出flag
    private String lentFlag;


}
