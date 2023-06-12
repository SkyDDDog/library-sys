package com.lear.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lear.entity.Book;
import com.lear.entity.LentInfo;
import com.lear.entity.vo.BorrowVO;
import com.lear.mapper.LentInfoMapper;
import com.lear.service.base.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * lent_info服务
 * @author 天狗
 */
@Slf4j
@Service
public class LentInfoService extends CrudService<LentInfoMapper, LentInfo> {

    @Autowired
    private BookService bookService;

    public int borrowBook(String userId, String bookId) {
        QueryWrapper<LentInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId)
                .eq("entity_id", bookId)
                .isNull("returned_at");
        List<LentInfo> list = this.findList(wrapper);
        if (list.size()>0) {
            return 0;
        }
        LentInfo lentInfo = new LentInfo();
        lentInfo.setEntityId(bookId)
                .setUserId(userId)
                .setLentAt(new Date())
                .setLentDay(30);
        return this.save(lentInfo);
    }

    public int returnBook(String userId, String bookId) {
        QueryWrapper<LentInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId)
                .eq("entity_id", bookId)
                .isNull("returned_at");
        List<LentInfo> list = this.findList(wrapper);
        if (list.size()<1) {
            return 0;
        }
        LentInfo lentInfo = list.get(0);
        lentInfo.setReturnedAt(new Date());
        return this.save(lentInfo);
    }

    public List<LentInfo> borrowList(String userId) {
        QueryWrapper<LentInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        return this.findList(wrapper);
    }

    public List<BorrowVO> buildBorrowListVO(List<LentInfo> list) {
        ArrayList<BorrowVO> result = new ArrayList<>(list.size());
        for (LentInfo lentInfo : list) {
            result.add(this.buildBorrowVO(lentInfo));
        }
        return result;
    }

    public BorrowVO buildBorrowVO(LentInfo lentInfo) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        BorrowVO vo = new BorrowVO();
        Book book = bookService.get(lentInfo.getEntityId());
        vo.setId(book.getId())
                .setName(book.getName())
                .setIsReturn(lentInfo.getReturnedAt() != null)
                .setReturnTime(lentInfo.getReturnedAt() != null ? sdf.format(lentInfo.getReturnedAt()) : null);
        return vo;
    }

}
