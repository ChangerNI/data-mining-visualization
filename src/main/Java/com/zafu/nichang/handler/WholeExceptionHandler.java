package com.zafu.nichang.handler;

import com.zafu.nichang.entity.vo.ResultVO;
import com.zafu.nichang.enums.ResultEnums;
import com.zafu.nichang.exception.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author  倪畅
 * @date 2018/1/28 17:20
 * @description 全局异常处理 凡是遇到异常请直接抛出 交由此类处理
 */
@RestControllerAdvice
public class WholeExceptionHandler {

    /** 日志 */
    private static final Logger log = LoggerFactory.getLogger(WholeExceptionHandler.class);

    /**
     * 未捕获异常 指定Http返回状态为500
     *
     * @return 内部错误 #{@code INNER_ERROR(-1, "内部错误")}
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResultVO handleException(Exception e) {
        log.error("【全局异常处理】未捕获异常", e);
        return ResultVO.error(ResultEnums.INNER_ERROR);
    }

    /**
     * 处理自己的异常
     *
     * @param e 已知异常
     * @return 已知错误（一般是业务异常）
     */
    @ExceptionHandler(UserException.class)
    public ResultVO handleQuickQueryToolException(UserException e) {
        log.error("【全局异常处理】已知异常", e);
        return ResultVO.error(e.getCode(), e.getMessage());
    }

    /**
     * 处理405错误
     *
     * @param e 405错误
     * @return 405 Method Not Allowed 请求方法不支持
     */
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResultVO handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("【全局异常处理】请求方法不支持", e);
        return ResultVO.error(HttpStatus.METHOD_NOT_ALLOWED);
    }

    /**
     * 处理缺少参数的异常
     *
     * @param e 缺少必要参数
     * @return BAD_REQUEST
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResultVO handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        log.error("【全局异常处理】请求方法缺少必要的参数", e);
        return ResultVO.error(HttpStatus.BAD_REQUEST);
    }

}
