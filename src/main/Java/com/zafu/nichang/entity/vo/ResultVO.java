package com.zafu.nichang.entity.vo;

import com.zafu.nichang.enums.ResultEnums;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author 倪畅
 * @date 2019/1/29 14:24
 * @description 统一返回对象
 */

public class ResultVO<T> implements Serializable {

    private static final long serialVersionUID = 8684210625897199829L;

    /**
     * 成功与否
     */
    private Boolean success;
    /**
     * 返回码
     */
    private Integer messageCode;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 具体数据
     */
    private T data;

    /**
     * 私有构造
     */
    private ResultVO(Boolean success, Integer messageCode, String message, T data) {
        this.success = success;
        this.messageCode = messageCode;
        this.message = message;
        this.data = data;
    }

    /**
     * 私有构造
     */
    private ResultVO(Boolean success, ResultEnums enums, T data) {
        this(success, enums.getMessageCode(), enums.getMessage(), data);
    }

    /**
     * 不支持空构造
     */
    private ResultVO() {
        throw new UnsupportedOperationException();
    }

    /**
     * error 时使用 这个用来接收自定义异常中的msg 和 code
     */
    public static ResultVO error(Integer code, String msg) {
        return new ResultVO<>(false, code, msg, null);
    }

    /**
     * error 时使用 这个只应该在全局异常中使用 不应该在其他类中使用
     */
    public static ResultVO error(ResultEnums enums) {
        return error(enums.getMessageCode(), enums.getMessage());
    }

    /**
     * 尽量少用！ error 时使用 使用#{@link HttpStatus}中的枚举对象
     */
    public static ResultVO error(HttpStatus status) {
        return error(status.value(), status.getReasonPhrase());
    }

    /**
     * 成功的时候 请调用这个方法，指定好成功返回信息
     */
    public static <T> ResultVO<T> success(String msg, T data) {
        return new ResultVO<>(true, ResultEnums.SUCCESS.getMessageCode(), msg, data);
    }

    /**
     * 成功的时候 默认信息为操作成功
     */
    public static <T> ResultVO<T> success(T data) {
        return new ResultVO<>(true, ResultEnums.SUCCESS, data);
    }

    public static <T> ResultVO<T> success(String msg) {
        return new ResultVO<>(true, ResultEnums.SUCCESS.getMessageCode(), msg, null);
    }

    /**
     * 成功的时候 默认信息为操作成功 数据为空
     */
    public static <T> ResultVO<T> success() {
        return new ResultVO<>(true, ResultEnums.SUCCESS, null);
    }

    /**
     * 成功的时候 默认信息为操作成功 数据为空
     */
    public static <T> ResultVO<T> success(ResultEnums resultEnums) {
        return success(resultEnums.getMessage(), null);
    }


    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(Integer messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("success", success)
                .append("messageCode", messageCode)
                .append("message", message)
                .append("data", data)
                .toString();
    }
}
