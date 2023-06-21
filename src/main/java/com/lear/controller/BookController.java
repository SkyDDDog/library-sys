package com.lear.controller;

import com.lear.common.CommonResult;
import com.lear.entity.Book;
import com.lear.entity.dto.BookBorrowDTO;
import com.lear.entity.dto.BookReturnDTO;
import com.lear.service.BookService;
import com.lear.service.LentInfoService;
import com.lear.service.LibraryService;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Autowired
    private LentInfoService lentService;
    @Autowired
    private LibraryService libraryService;

    @ApiOperation(value = "获取所有书籍")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "userId",
                    value = "用户id",
                    required = false,
                    dataType = "String",
                    paramType = "query"
            )
    })
    @RequestMapping(value = "", method = RequestMethod.GET)
    public CommonResult getAllBook(@RequestParam(required = false) String userId) {
        CommonResult result = new CommonResult().init();
        List<Book> list = bookService.findList(null);
        result.success("book", bookService.buildBookListVO(list, userId));
        return (CommonResult) result.end();
    }

    @RequestMapping(value = "{bookId}", method = RequestMethod.POST)
    public CommonResult updateBook(@PathVariable String bookId, @RequestBody Book book) {
        CommonResult result = new CommonResult().init();
        book.setId(bookId);
        if (0 < bookService.save(book)) {
            result.success();
        }

        return (CommonResult) result.end();
    }

    @ApiOperation(value = "删除书籍")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "bookId",
                    value = "书籍id",
                    required = true,
                    dataType = "String",
                    paramType = "path"
            )
    })
    @RequestMapping(value = "{bookId}", method = RequestMethod.DELETE)
    public CommonResult deleteBook(@PathVariable String bookId) {
        CommonResult result = new CommonResult().init();
        Book book = bookService.get(bookId);
        if (book==null) {
            return (CommonResult) result.failCustom("不存在该书本").end();
        }
        if (0 < bookService.delete(book) &&  0 < libraryService.deleteEntity(bookId)) {
            result.success();
        }

        return (CommonResult) result.end();
    }

    @ApiOperation(value = "添加书籍")
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

    @ApiOperation(value = "搜索书籍")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "content",
                    value = "搜索内容",
                    required = true,
                    dataType = "String",
                    paramType = "path"
            ),
            @ApiImplicitParam(
                    name = "userId",
                    value = "用户id",
                    required = false,
                    dataType = "String",
                    paramType = "query"
            )
    })
    @RequestMapping(value = "search/{content}", method = RequestMethod.GET)
    public CommonResult searchBook(@PathVariable String content,
                                   @RequestParam(required = false) String userId) {
        CommonResult result = new CommonResult().init();
        List<Book> list = bookService.searchBook(content);
        result.success("book", bookService.buildBookListVO(list, userId));
        return (CommonResult) result.end();
    }

    @ApiOperation(value = "获取书籍详情")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "id",
                    value = "书籍id",
                    required = true,
                    dataType = "String",
                    paramType = "path"
            ),
            @ApiImplicitParam(
                    name = "userId",
                    value = "用户id",
                    required = false,
                    dataType = "String",
                    paramType = "query"
            )
    })
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public CommonResult getDetail(@PathVariable String id,
                                  @RequestParam(required = false) String userId) {
        CommonResult result = new CommonResult().init();
        Book book = bookService.get(id);
        result.success("book", bookService.buildBookVO(book, userId));

        return (CommonResult) result.end();
    }

    @ApiOperation(value = "借阅书籍")
    @RequestMapping(value = "borrow", method = RequestMethod.POST)
    public CommonResult borrowBook(@Validated @RequestBody @ApiParam("借阅dto") BookBorrowDTO req,
                                   BindingResult bindingResult) {
        CommonResult result = new CommonResult().init();
        if (bindingResult.hasErrors()) {
            return (CommonResult) result.failIllegalArgument(bindingResult.getFieldErrors()).end();
        }
        String entityId = libraryService.getEntityId(req.getBookId());
        if (0 < lentService.borrowBook(req.getUserId(), entityId)) {
            result.success("entity_id", entityId);
        } else {
            result.fail();
        }

        return (CommonResult) result.end();
    }

    @ApiOperation(value = "归还书籍")
    @RequestMapping(value = "return", method = RequestMethod.POST)
    public CommonResult returnBook(@Validated @RequestBody @ApiParam("归还dto") BookReturnDTO req,
                                   BindingResult bindingResult) {
        CommonResult result = new CommonResult().init();
        if (bindingResult.hasErrors()) {
            return (CommonResult) result.failIllegalArgument(bindingResult.getFieldErrors()).end();
        }
        if (0 < lentService.returnBook(req.getUserId(), req.getEntityId())) {
            result.success();
        } else {
            result.fail();
        }

        return (CommonResult) result.end();
    }

}
