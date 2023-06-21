package com.lear.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 书籍视图对象
 * @author 天狗
 */
@Data
@Accessors(chain = true)
public class BookVO {

    private String bookId;
    private String name;
    private String author;
    private Integer quantity;
    private Double rating;
    private Boolean favorite;
    private Integer collectNum;

}
