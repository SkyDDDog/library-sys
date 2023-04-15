package com.lear.service;

import com.lear.entity.Book;
import com.lear.mapper.BookMapper;
import com.lear.service.base.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BookService extends CrudService<BookMapper, Book> {




}
