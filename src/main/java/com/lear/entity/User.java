package com.lear.entity;


import com.lear.entity.base.DataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 用户Entity
 * @author 天狗
 */
@EqualsAndHashCode(callSuper = true)
@Data
@Accessors(chain = true)
public class User extends DataEntity<User> {

    // 用户名
    private String nickName;
    // 密码
    private String password;
    // 邮箱
    private String email;
    // 电话
    private String phone;

}
