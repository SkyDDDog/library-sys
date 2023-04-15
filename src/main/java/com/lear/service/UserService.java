package com.lear.service;

import com.lear.entity.User;
import com.lear.mapper.UserMapper;
import com.lear.service.base.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 用户Service
 * @author 天狗
 */
@Slf4j
@Service
public class UserService extends CrudService<UserMapper, User> {
}
