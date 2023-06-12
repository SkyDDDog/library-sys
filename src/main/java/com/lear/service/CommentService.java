package com.lear.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lear.entity.Comment;
import com.lear.entity.User;
import com.lear.entity.vo.CommentVO;
import com.lear.mapper.CommentMapper;
import com.lear.service.base.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 天狗
 */
@Slf4j
@Service
public class CommentService extends CrudService<CommentMapper, Comment> {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserService userService;

    public List<Comment> getCommentByBookId(String bookId) {
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("book_id", bookId);
        return this.findList(wrapper);
    }

    /**
     * 获取书籍的平均评分
     * @param bookId 书籍id
     * @return
     */
    public Double getRate(String bookId) {
        return commentMapper.getRate(bookId);
    }

    public List<CommentVO> buildCommentListVO(List<Comment> list) {
        ArrayList<CommentVO> result = new ArrayList<>(list.size());
        for (Comment comment : list) {
            result.add(this.buildCommentVO(comment));
        }
        return result;
    }

    public CommentVO buildCommentVO(Comment comment) {
        CommentVO vo = new CommentVO();
        BeanUtils.copyProperties(comment, vo);
        vo.setRating(comment.getScore() * 1.0);
        User user = userService.get(comment.getUserId());
        if (user!=null) {
            vo.setNickname(user.getNickName());
        }
        return vo;
    }

}
