package com.lear.entity.base;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;

/**
 * @desc 基本实体类
 * @date 2022/11/26
 */
@ApiModel(
        value = "BaseEntity",
        description = "BaseEntity"
)
@Accessors(chain = true)
public abstract class BaseEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final String DEL_FLAG_NORMAL = "0";
    public static final String DEL_FLAG_DELETE = "1";
    @ApiModelProperty(
            value = "实体编号",
            example = "2333"
    )
    protected String id;
    @ApiModelProperty(
            value = "是否是新记录",
            example = "false"
    )
    @TableField(exist = false)
    protected boolean isNewRecord = false;

    public BaseEntity() {
    }

    public BaseEntity(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract void preInsert();

    public abstract void preUpdate();

    @JsonIgnore
    public boolean isNewRecord() {
        return this.isNewRecord || StringUtils.isBlank(this.getId());
    }

    public void setNewRecord(boolean newRecord) {
        this.isNewRecord = newRecord;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }


}
