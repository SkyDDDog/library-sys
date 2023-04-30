package com.lear.entity;


import com.lear.entity.base.DataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

/**
 * 用户Entity
 * @author 天狗
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class User extends DataEntity<User> {

    // 用户名
    @NotNull(message = "用户名不能为空")
    private String nickName;
    // 密码
    @NotNull(message = "密码不能为空")
    private String password;
    // 邮箱(查重)
    @NotNull(message = "邮箱不能为空")
    private String email;
    // 电话(查重)
    @NotNull(message = "电话不能为空")
    private String phone;

}
