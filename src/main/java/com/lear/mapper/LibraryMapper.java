package com.lear.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lear.entity.Library;
import org.apache.ibatis.annotations.Mapper;

/**
 * library数据库操作接口
 * @author 天狗
 */
@Mapper
public interface LibraryMapper extends BaseMapper<Library> {
}
