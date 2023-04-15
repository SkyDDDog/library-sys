package com.lear.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lear.entity.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * book数据库操作接口
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {


}
