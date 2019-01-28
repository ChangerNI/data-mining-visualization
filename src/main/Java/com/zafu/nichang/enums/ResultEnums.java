package com.zafu.nichang.enums;

/**
 * @author 朱文赵
 * @date 2018/3/22 14:58
 * @description 返回信息msg枚举类
 */
public enum ResultEnums {

    /** 操作成功 */
    SUCCESS(0, "操作成功"),
    INNER_ERROR(-1, "内部错误")
    ;

    /** 返回码*/
    private Integer messageCode;
    /** 返回信息 */
    private String message;

    ResultEnums(Integer messageCode, String message) {
        this.messageCode = messageCode;
        this.message = message;
    }

    public Integer getMessageCode() {
        return messageCode;
    }

    public String getMessage() {
        return message;
    }
}
