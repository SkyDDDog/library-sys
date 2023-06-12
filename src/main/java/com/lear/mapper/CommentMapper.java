package com.lear.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lear.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 评论数据库操作接口
 * @author 天狗
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

    @Select("SELECT AVG(score) FROM `comment` WHERE book_id = #{bookId} AND (del_flag = 0)")
    public Double getRate(String bookId);

}
