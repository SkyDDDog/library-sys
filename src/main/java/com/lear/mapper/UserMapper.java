package com.lear.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lear.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户Mapper
 * @author 天狗
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {



}
