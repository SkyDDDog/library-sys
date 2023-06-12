package com.lear.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lear.entity.Collection;
import org.apache.ibatis.annotations.Mapper;

/**
 * 收藏数据库操作接口
 * @author 天狗
 */
@Mapper
public interface CollectionMapper extends BaseMapper<Collection> {

}
