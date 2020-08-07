package com.yif.community.exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
    QUESTION_NOT_FOUND("你找的问题不在了，要不要换个试试",2001),
    TARGET_PARAM_NOT_FOUND("未选中任何问题或评论进行回复",2002),
    NO_LOGIN("未登录不能进行评论，请先登录",2003),
    SYS_ERROR("服务冒烟了，要不然你稍后再试试",2004),
    TYPE_PARAM_WRONG("评论类型为空或不存在",2005),
    COMMENT_NOT_FOUND("回复的评论已经被删除",2006);
    private String message;
    private Integer code;

    CustomizeErrorCode(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage(){
        return message;
    }
    @Override
    public Integer getCode(){
        return code;
    }
}
