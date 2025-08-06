package com.chlcn.enums;

/**
 * 评论的删除状态
 */
public enum CommentDeleteEnum  {
    NORMAL(0,"正常"),
    DELETED(1,"已删除");


    int code;
    String msg;

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    CommentDeleteEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
