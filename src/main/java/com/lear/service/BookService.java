package com.lear.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lear.entity.Book;
import com.lear.entity.vo.BookVO;
import com.lear.mapper.BookMapper;
import com.lear.service.base.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class BookService extends CrudService<BookMapper, Book> {

    @Autowired
    private CommentService commentService;
    @Autowired
    private CollectionService collectionService;
    @Autowired
    private LibraryService libraryService;

    public List<Book> searchBook(String key) {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.like("name", key);
        return this.findList(wrapper);
    }

    public List<BookVO> buildBookListVO(List<Book> books) {
        return this.buildBookListVO(books, null);
    }
    public List<BookVO> buildBookListVO(List<Book> books, String userId) {
        ArrayList<BookVO> result = new ArrayList<>();
        for (Book book : books) {
            BookVO bookVO = this.buildBookVO(book, userId);

            result.add(bookVO);
        }
        return result;
    }

    public BookVO buildBookVO(Book book) {
        return this.buildBookVO(book, null);
    }
    public BookVO buildBookVO(Book book, String userId) {
        BookVO bookVO = new BookVO();
        BeanUtils.copyProperties(book, bookVO);
        bookVO.setBookId(book.getId());
        bookVO.setQuantity(libraryService.getBookCount(book.getId()));
        bookVO.setRating(commentService.getRate(book.getId())==null?0.0:commentService.getRate(book.getId()));
        bookVO.setCollectNum(collectionService.getCollectCount(book.getId()));
        if (userId!=null) {
            bookVO.setFavorite(collectionService.isCollected(userId, book.getId()));
        }
        return bookVO;
    }


}
