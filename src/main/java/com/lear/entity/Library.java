package com.lear.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lear.entity.base.DataEntity;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 图书馆实体类
 * @author 天狗
 */
@Data
@Accessors(chain = true)
public class Library extends DataEntity<Library> {

    // 书籍id
    private String bookId;
    // 是否借出 0:未借出 1:已借出
    private String lentFlag;

    @JsonIgnore
    public static final String NOT_LENT = "0";
    @JsonIgnore
    public static final String LENT = "1";

}
