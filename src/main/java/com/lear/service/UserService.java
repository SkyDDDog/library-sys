package com.lear.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lear.entity.User;
import com.lear.mapper.UserMapper;
import com.lear.service.base.CrudService;
import com.lear.util.Digests;
import com.lear.util.EncodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户Service
 * @author 天狗
 */
@Slf4j
@Service
public class UserService extends CrudService<UserMapper, User> {

    public int register(User user) {
        user.setPassword(entryptPassword(user.getPassword()));
        return this.save(user);
    }

    public int register(String username, String password) {
        User registerUser = this.getByLoginUsername(username);
        if (registerUser != null) {
            return 0;
        }
        User user = new User();
        user.setNickName(username);
        user.setPassword(entryptPassword(password));
        return this.save(user);
    }

    public User login(String username, String password) {
        User user = this.getByLoginUsername(username);
        if (user != null) {
            if (validatePassword(password, user.getPassword())) {
                return user;
            } else {
                return null;
            }
        }
        return null;
    }


    public static boolean validatePassword(String plainPassword, String password) {
        String plain = EncodeUtil.unescapeHtml(plainPassword);
        byte[] salt = EncodeUtil.decodeHex(password.substring(0, 16));
        byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, 1024);
        return password.equals(EncodeUtil.encodeHex(salt) + EncodeUtil.encodeHex(hashPassword));
    }

    public static String entryptPassword(String plainPassword) {
        String plain = EncodeUtil.unescapeHtml(plainPassword);
        byte[] salt = Digests.generateSalt(8);
        byte[] hashPassword = Digests.sha1(plain.getBytes(), salt, 1024);
        return EncodeUtil.encodeHex(salt) + EncodeUtil.encodeHex(hashPassword);
    }
    public User getByLoginUsername(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("nick_name", username);
        List<User> list = this.findList(wrapper);
        if (list.size()==1) {
            return list.get(0);
        } else {
            return null;
        }
    }






}
