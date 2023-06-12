package com.lear.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 收藏视图对象
 * @author 天狗
 */
@Data
@Accessors(chain = true)
public class CollectionVO {

    private String id;
    private String name;
    private String author;

}
