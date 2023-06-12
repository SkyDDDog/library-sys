package com.lear.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lear.entity.Book;
import com.lear.entity.Collection;
import com.lear.entity.vo.CollectionVO;
import com.lear.mapper.CollectionMapper;
import com.lear.service.base.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 收藏服务
 * @author 天狗
 */
@Slf4j
@Service
public class CollectionService extends CrudService<CollectionMapper, Collection> {

    @Autowired
    private BookService bookService;

    public int collectBook(String userId, String bookId) {
        QueryWrapper<Collection> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId)
                .eq("book_id", bookId);
        List<Collection> list = this.findList(wrapper);
        if (list.size()>0) {
            return 0;
        }
        Collection collection = new Collection();
        collection.setUserId(userId);
        collection.setBookId(bookId);
        return this.save(collection);
    }

    public int uncollectBook(String userId, String bookId) {
        QueryWrapper<Collection> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId)
                .eq("book_id", bookId);
        List<Collection> list = this.findList(wrapper);
        if (list.size()<1) {
            return 0;
        }
        return this.delete(list.get(0));
    }

    public List<Collection> collectionList(String userId) {
        QueryWrapper<Collection> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return this.findList(wrapper);
    }

    public Boolean isCollected(String userId, String bookId) {
        QueryWrapper<Collection> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId)
                .eq("book_id", bookId);
        List<Collection> list = this.findList(wrapper);
        return list.size()>0;
    }

    public List<CollectionVO> buildCollectionListVO(List<Collection> list) {
        ArrayList<CollectionVO> result = new ArrayList<>();
        for (Collection collection : list) {
            result.add(this.buildCollectionVO(collection));
        }
        return result;
    }

    public CollectionVO buildCollectionVO(Collection collection) {
        CollectionVO vo = new CollectionVO();
        Book book = bookService.get(collection.getBookId());
        vo.setId(book.getId())
                .setName(book.getName())
                .setAuthor(book.getAuthor());
        return vo;
    }

}
