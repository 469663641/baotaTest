package com.example.service.exception;

/**
 * Created by duguangquan on 2018/8/31.
 */
public class BaseException extends RuntimeException{

    private static final long serialVersionUID = 7767580164367673287L;

    protected String errorCode;

    protected String errorMsg;

    public BaseException() {
    }

    public BaseException(String errorCode, String errorMsg) {
        super(buildErrorMsg(errorCode, errorMsg));
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BaseException(String errorCode, String errorMsg, Throwable throwable) {
        super(throwable);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;

    }


    public BaseException(String message) {
        super(message);

    }

    public BaseException(Throwable throwable) {
        super(throwable);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public  static String buildErrorMsg(String errorCode, String errorMsg){
        return new StringBuilder(errorCode).append("#").append(errorMsg).toString();
    }
}
