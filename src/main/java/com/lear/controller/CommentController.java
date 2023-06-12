package com.lear.controller;

import com.lear.common.CommonResult;
import com.lear.entity.Comment;
import com.lear.entity.dto.CommentDTO;
import com.lear.service.CommentService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 评论控制器
 * @author 天狗
 */
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping(value = "${apiPath}/comment")
@Api(value = "CommentController", tags = "评论接口")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @ApiOperation(value = "获取所有评论")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "bookId",
                    value = "书籍id",
                    required = true,
                    dataType = "String",
                    paramType = "path"
            )
    })
    @RequestMapping(value = "{bookId}", method = RequestMethod.GET)
    public CommonResult getComment(@PathVariable String bookId) {
        CommonResult result = new CommonResult().init();
        List<Comment> list = commentService.getCommentByBookId(bookId);
        result.success("comment", commentService.buildCommentListVO(list));

        return (CommonResult) result.end();
    }

    @ApiOperation(value = "发布书评")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public CommonResult postComment(@Validated @RequestBody @ApiParam("书评dto") CommentDTO req,
                                    BindingResult bindingResult) {
        CommonResult result = new CommonResult().init();
        if (bindingResult.hasErrors()) {
            return (CommonResult) result.failIllegalArgument(bindingResult.getFieldErrors()).end();
        }
        Comment comment = new Comment();
        BeanUtils.copyProperties(req, comment);
        comment.setScore(req.getRating());
        if (0 < commentService.save(comment)) {
            result.success();
        } else {
            result.fail();
        }
        return (CommonResult) result.end();
    }

    @ApiOperation(value = "删除书评")
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public CommonResult deleteComment(@PathVariable String id) {
        CommonResult result = new CommonResult().init();
        Comment comment = new Comment();
        comment.setId(id);
        if (0 < commentService.delete(comment)) {
            result.success();
        } else {
            result.fail();
        }
        return (CommonResult) result.end();
    }



}
