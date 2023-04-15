package com.lear.entity;

import com.lear.entity.base.DataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * book数据库实体类
 * @author 天狗
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Book extends DataEntity<Book> {

    // 书名
    private String name;
    // 种类
    private String type;
    // 概要
    private String abs;


}
