package com.lear.controller;

import com.lear.common.CommonResult;
import com.lear.service.CollectionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 收藏控制器
 * @author 天狗
 */
@Slf4j
@CrossOrigin("*")
@RestController
@RequestMapping(value = "${apiPath}/collect")
@Api(value = "CollectionController", tags = "收藏接口")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    @ApiOperation(value = "收藏书籍")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "userId",
                    value = "用户ID",
                    required = true,
                    dataType = "String",
                    paramType = "path"
            ), @ApiImplicitParam(
                    name = "bookId",
                    value = "书籍ID",
                    required = true,
                    dataType = "String",
                    paramType = "path"
            )
    })
    @RequestMapping(value = "/book/{userId}/{bookId}", method = RequestMethod.POST)
    public CommonResult collectBook(@PathVariable String userId, @PathVariable String bookId) {
        CommonResult result = new CommonResult().init();
        if (0 < collectionService.collectBook(userId, bookId)) {
            result.success();
        } else {
            result.fail();
        }
        return (CommonResult) result.end();
    }

    @ApiOperation(value = "取消收藏书籍")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "userId",
                    value = "用户ID",
                    required = true,
                    dataType = "String",
                    paramType = "path"
            ), @ApiImplicitParam(
            name = "bookId",
            value = "书籍ID",
            required = true,
            dataType = "String",
            paramType = "path"
    )
    })
    @RequestMapping(value = "/book/{userId}/{bookId}", method = RequestMethod.DELETE)
    public CommonResult uncollectBook(@PathVariable String userId, @PathVariable String bookId) {
        CommonResult result = new CommonResult().init();
        if (0 < collectionService.uncollectBook(userId, bookId)) {
            result.success();
        } else {
            result.fail();
        }
        return (CommonResult) result.end();
    }


}
