package com.zafu.nichang.exception;

import com.zafu.nichang.enums.ResultEnums;

/**
 * @author ncg
 *  * 在抛出该异常的时候，请指定好返回枚举类信息{@link ResultEnums} 在其中定义好code 和 msg
 *  * 然后调用自身的{@link #UserException(ResultEnums, Throwable)}
 *  * 交由全局异常处理#{@link com.zafu.nichang.handler.WholeExceptionHandler} 统一返回给前端
 */
public class UserException extends RuntimeException {

    /**
     * 返回码
     */
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public UserException(ResultEnums resultEnums, Throwable cause) {
        super(resultEnums.getMessage(), cause);
        this.code = resultEnums.getMessageCode();
    }

    public UserException(ResultEnums resultEnums) {
        super(resultEnums.getMessage());
        this.code = resultEnums.getMessageCode();
    }

    public UserException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public UserException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
