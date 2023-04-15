package com.lear.entity;

import com.lear.entity.base.DataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * lent_info数据库实体类
 * @Author 天狗
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class LentInfo extends DataEntity<LentInfo> {

    // 书籍id
    private String bookId;
    // 书籍isbn
    private String userId;
    // 用户id
    private Integer lentDay;
    // 借阅天数
    private Date lentAt;
    // 借阅时间
    private Date returnedAt;

}
