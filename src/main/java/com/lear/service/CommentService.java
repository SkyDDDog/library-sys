package com.lear.service;

import com.lear.entity.Comment;
import com.lear.mapper.CommentMapper;
import com.lear.service.base.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CommentService extends CrudService<CommentMapper, Comment> {



}
