package com.lear.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 借阅信息VO
 * @author 天狗
 */
@Data
@Accessors(chain = true)
public class BorrowVO {

    private String id;
    private String name;
    private Boolean isReturn;
    private String returnTime;

}
