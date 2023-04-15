package com.lear.common;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @desc 返回值状态码
 * @date 2022/11/26
 */
public class MsgCodeUtil {
    public static final int MSG_CODE_SUCCESS = 0;
    public static final int MSG_CODE_UNKNOWN = -10000;
    public static final int MSG_CODE_FORBIDDEN_LOGIN = -10001;
    public static final int MSG_CODE_JWT_TOKEN_ISNULL = -10002;
    public static final int MSG_CODE_JWT_SIGNATURE_EXCEPTION = -10003;
    public static final int MSG_CODE_JWT_MALFORMED = -10004;
    public static final int MSG_CODE_JWT_TOKEN_EXPIRED = -10005;
    public static final int MSG_CODE_JWT_TOKEN_UNSUPPORTED = -10006;
    public static final int MSG_CODE_JWT_ILLEGAL_ARGUMENT = -10007;
    public static final int MSG_CODE_USERNAME_OR_PASSWORD_INCORRECT = -10008;
    public static final int MSG_CODE_JWT_TOKEN_TYPE_MISMATCH = -10009;
    public static final int MSG_CODE_SYSTEM_USER_NAME_EXIST = -10010;
    public static final int MSG_CODE_SYSTEM_ROLE_ENNAME_EXIST = -10011;
    public static final int MSG_CODE_SYSTEM_NOT_SUPER_ADMIN_PERMISSION = -10012;
    public static final int MSG_CODE_SYSTEM_DATABASE_KEY_DUPLICATE = -10013;
    public static final int MSG_CODE_JWT_REFRESH_TOKEN_EXPIRED = -10014;
    public static final int MSG_CODE_REFRESH_TOKEN_FREQUENT = -10015;
    public static final int MSG_CODE_ILLEGAL_ARGUMENT = -10016;
    public static final int MSG_CODE_PARAMETER_IS_NULL = -10017;
    public static final int MSG_CODE_ID_IS_NULL = -10018;
    public static final int MSG_CODE_DATA_NOT_EXIST = -10024;
    public static final int MSG_CODE_DATA_EXIST = -10025;
    public static final int MSG_CODE_PARENT_NODE_NOT_HIMSELF = -10026;
    public static final int MSG_CODE_FLOWINFO_STATE = -10027;
    public static final int MSG_CODE_FLOWINFO_NOT_FOUNT = -10028;
    public static final int MSC_DATA_DRODATA_ERROR = -10029;
    public static final int MSC_DATA_ADDDATA_ERROR = -10030;
    public static final int MSC_DATA_UPDATADATA_ERROR = -10031;

    public static final int MSG_CODE_VERCODE_EXISTED = -10032;
    public static final int MSG_CODE_VERCODE_SEND_FAILURE = -10033;
    public static final int MSG_CODE_VERCODE_INVALID = -10034;

    protected static Map<Integer, String> map = Maps.newHashMap();

    public MsgCodeUtil() {
    }

    public static String getErrMsg(int msgCode) {
        return (String)map.get(msgCode);
    }

    static {
        map.put(0, "请求成功.");
        map.put(-10000, "未知错误.");
        map.put(-10001, "该帐号禁止登录.");
        map.put(-10002, "access token为空.");
        map.put(-10003, "token签名异常或者token过期.");
        map.put(-10004, "token格式错误.");
        map.put(-10005, "token过期.");
        map.put(-10006, "不支持该token.");
        map.put(-10007, "token参数错误异常.");
        map.put(-10008, "账号或者密码错误.");
        map.put(-10009, "token类型错误.");
        map.put(-10010, "角色名称已经存在.");
        map.put(-10011, "角色英文名称已经存在.");
        map.put(-10012, "越权操作，需超级管理员权限.");
        map.put(-10013, "数据库主键重复.");
        map.put(-10014, "refresh token过期.");
        map.put(-10015, "refresh token刷新频率太高，请稍后再试.");
        map.put(-10016, "非法参数异常:");
        map.put(-10017, "参数为空.");
        map.put(-10018, "参数ID为空.");
        map.put(-10024, "数据不存在：");
        map.put(-10025, "数据存在：");
        map.put(-10026, "父级节点不能是自己");
        map.put(-10029, "删除失败");
        map.put(-10030, "新增失败");
        map.put(-10031, "修改失败");
        map.put(-10032, "请勿在60秒重复发送验证码");
        map.put(-10033, "验证码发送失败");
        map.put(-10034, "验证码错误");

    }
}
