package com.lear.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lear.entity.Library;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author 天狗
 */
@Mapper
public interface LibraryMapper extends BaseMapper<Library> {

    @Select("select COUNT(*) from `library` where book_id = #{bookId} and lent_flag = 0")
    public Integer getBookCount(String bookId);

}
