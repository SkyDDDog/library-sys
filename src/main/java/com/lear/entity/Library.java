package com.lear.entity;

import com.lear.entity.base.DataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * library数据库实体类
 * @author 天狗
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class Library extends DataEntity<Library> {

    // 书籍id
    @NotNull(message = "书籍id不能为空")
    private String entityId;
    // 用户id
    @NotNull(message = "用户id不能为空")
    private String userId;
    // 借出flag
    @NotNull(message = "借出flag不能为空")
    private String lentFlag;


}
