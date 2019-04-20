/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.example.exception;

import com.example.constant.ErrorCode;

/**
 * @author baoxing
 * @version $Id: KbMemberprodException.java, v 0.1 2019年04月20日 9:35 PM baoxing Exp $
 */
public class KbMemberprodException extends RuntimeException {


    private static final long serialVersionUID = -604177474421443909L;

    private String errorCode;

    private String errorMsg;


    public KbMemberprodException(String errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public KbMemberprodException(ErrorCode errorCode) {
        super(errorCode.getErrorMsg());
        this.errorCode = errorCode.getErrorCode();
        this.errorMsg = errorCode.getErrorMsg();

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
}