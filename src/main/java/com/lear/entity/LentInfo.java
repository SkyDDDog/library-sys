package com.lear.entity;

import com.lear.entity.base.DataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * lent_info数据库实体类
 * @Author 天狗
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class LentInfo extends DataEntity<LentInfo> {

    // 实体书籍id
    @NotNull(message = "实体书籍id不能为空")
    private String entityId;
    // 用户id
    @NotNull
    private String userId;
    // 借出时长(天)
    @Digits(integer = 3, fraction = 0, message = "借阅天数必须为整数")
    private Integer lentDay;
    // 借出实践
    @NotNull(message = "借阅时间不能为空")
    private Date lentAt;
    // 归还时间
    @NotNull(message = "归还时间不能为空")
    private Date returnedAt;

}
