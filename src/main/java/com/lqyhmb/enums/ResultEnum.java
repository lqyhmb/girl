package com.lqyhmb.enums;

/**
 * Created by Rodriguez
 * 2017/9/15 13:14
 */

public enum ResultEnum {
    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(0, "请求成功"),
    PRIMARY_SCHOOL(100, "你还在上小学吧"),
    MIDDLE_SCHOOL(101, "你可能还在上初中");


    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
