package com.lear.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.FieldError;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

/**
 * @desc 返回结果基础类
 * @date 2022/11/26
 */
@Slf4j
public class BaseResult implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(
            value = "请求返回状态码",
            required = true,
            example = "-10000"
    )
    private int msgCode = 0;
    @ApiModelProperty(
            value = "状态信息",
            required = true,
            example = "未知错误."
    )
    protected String errMsg;

    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @ApiModelProperty(
            value = "服务器端接收请求时间",
            required = true,
            example = "2018-09-29 11:26:20"
    )
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)		// 反序列化
    @JsonSerialize(using = LocalDateTimeSerializer.class)		// 序列化
    private LocalDateTime receiptDateTime;
    @JsonFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @DateTimeFormat(
            pattern = "yyyy-MM-dd HH:mm:ss"
    )
    @ApiModelProperty(
            value = "服务端处理完请求时间",
            required = true,
            example = "2018-09-29 11:26:20"
    )
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)		// 反序列化
    @JsonSerialize(using = LocalDateTimeSerializer.class)		// 序列化
    private LocalDateTime returnDateTime;

    public boolean isSuccess() {
        return this.msgCode >= 0;
    }


    public BaseResult init() {
        this.receiptDateTime = LocalDateTime.now();
        return this;
    }

    public BaseResult success() {
        int msgCode = 0;
        this.msgCode = msgCode;
        this.errMsg = MsgCodeUtil.getErrMsg(msgCode);
        return this;
    }

    public BaseResult fail(int msgCode) {
        this.msgCode = msgCode;
        this.errMsg = MsgCodeUtil.getErrMsg(msgCode);
        log.error("接口报错. 错误码：{} 错误信息：{}", this.msgCode, this.errMsg);
        return this;
    }

    public BaseResult failCustom(int msgCode, String errMsg) {
        this.msgCode = msgCode;
        if (StringUtils.isBlank(errMsg)) {
            this.errMsg = MsgCodeUtil.getErrMsg(msgCode);
        } else {
            String msgCodeMsg = MsgCodeUtil.getErrMsg(msgCode);
            if (StringUtils.isNotBlank(msgCodeMsg)) {
                this.errMsg = MsgCodeUtil.getErrMsg(msgCode) + errMsg;
            } else {
                this.errMsg = errMsg;
            }
        }

        log.error("接口报错. 错误码：{} 错误信息：{}", this.msgCode, this.errMsg);
        return this;
    }

    public BaseResult failCustom(String errMsg) {
        this.msgCode = -10000;
        this.errMsg = errMsg;
        log.error("接口报错. 错误码：{} 错误信息：{}", this.msgCode, this.errMsg);
        return this;
    }

    public BaseResult failIllegalArgument(List<FieldError> fieldErrors) {
        this.fail(-10016);
        StringBuilder errorStringBuilder = (new StringBuilder(this.errMsg)).append("\n");
        Iterator var3 = fieldErrors.iterator();

        while(var3.hasNext()) {
            FieldError fieldError = (FieldError)var3.next();
            log.error(fieldError.toString());
            errorStringBuilder.append(fieldError.getDefaultMessage()).append("\n");
        }

        this.errMsg = errorStringBuilder.toString();
        return this;
    }

    public BaseResult end() {
        this.returnDateTime = LocalDateTime.now();
        return this;
    }

    public BaseResult() {
    }

    public BaseResult(int msgCode, String errMsg, LocalDateTime receiptDateTime, LocalDateTime returnDateTime) {
        this.msgCode = msgCode;
        this.errMsg = errMsg;
        this.receiptDateTime = receiptDateTime;
        this.returnDateTime = returnDateTime;
    }

    public void error(int msgCode) {
        this.msgCode = msgCode;
        this.errMsg = MsgCodeUtil.getErrMsg(msgCode);
    }

    public static long getSerialVersionUID() {
        return 1L;
    }

    public int getMsgCode() {
        return this.msgCode;
    }

    public void setMsgCode(int msgCode) {
        this.msgCode = msgCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public LocalDateTime getReceiptDateTime() {
        return this.receiptDateTime;
    }

    public void setReceiptDateTime(LocalDateTime receiptDateTime) {
        this.receiptDateTime = receiptDateTime;
    }

    public LocalDateTime getReturnDateTime() {
        return this.returnDateTime;
    }

    public void setReturnDateTime(LocalDateTime returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "msgCode=" + msgCode +
                ", errMsg='" + errMsg + '\'' +
                ", receiptDateTime=" + receiptDateTime +
                ", returnDateTime=" + returnDateTime +
                '}';
    }

}
