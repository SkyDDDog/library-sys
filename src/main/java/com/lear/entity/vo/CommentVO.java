package com.lear.entity.vo;

import lombok.Data;

/**
 * 评论视图对象
 * @author 天狗
 */
@Data
public class CommentVO {

    private String id;
    private String nickname;
    private Double rating;
    private String content;


}
