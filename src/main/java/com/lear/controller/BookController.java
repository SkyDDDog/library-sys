package com.lear.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lear.common.CommonResult;
import com.lear.entity.Book;
import com.lear.service.BookService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 书籍控制器
 * @author 天狗
 */
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping(value = "${apiPath}/book")
@Api(value = "BookController", tags = "书籍接口")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public CommonResult getAllBook() {
        CommonResult result = new CommonResult().init();
        result.success("book", bookService.findList(null));
        return (CommonResult) result.end();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public CommonResult createBook(@RequestBody Book book) {
        CommonResult result = new CommonResult().init();
        if (0 < bookService.save(book)) {
            result.success();
        } else {
            result.fail();
        }
        return (CommonResult) result.end();
    }


}
