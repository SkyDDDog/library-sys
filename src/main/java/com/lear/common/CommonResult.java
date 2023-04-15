package com.lear.common;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

/**
 * @desc 返回结果常用类
 * @date 2022/11/26
 */
@ApiModel(
        value = "CommonResult",
        description = "返回结果常用类"
)
public class CommonResult extends BaseResult {

    @ApiModelProperty("具体返回的数据")
    private JSONObject item;

    @Override
    public CommonResult init() {
        super.init();
        this.item = new JSONObject();

        return this;
    }

    public CommonResult() {
    }

    public CommonResult(JSONObject item) {
        this.item = item;
    }

    public CommonResult(int msgCode, String errMsg, LocalDateTime receiptDateTime, LocalDateTime returnDateTime) {
        super(msgCode, errMsg, receiptDateTime, returnDateTime);
    }

    public CommonResult(int msgCode, String errMsg, LocalDateTime receiptDateTime, LocalDateTime returnDateTime, String requesterId, JSONObject item) {
        super(msgCode, errMsg, receiptDateTime, returnDateTime);
        this.item = item;
    }

    public CommonResult success(String key, Object value) {
        super.success();
        if (null != key && null != value) {
            this.item.put(key, value);
        }

        return this;
    }

    public void putItem(String key, Object value) {
        this.item.put(key, value);
    }

    public JSONObject getItem() {
        return this.item;
    }

    public void setItem(JSONObject item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "CommonResult{" +
                "errMsg='" + errMsg + '\'' +
                ", item=" + item +
                '}';
    }

}
