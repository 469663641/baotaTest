/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.example.constant;


/**
 * @author baoxing
 * @version $Id: MemberErrorCode.java, v 0.1 2019年04月20日 9:45 PM baoxing Exp $
 */
public enum  MemberErrorCode implements ErrorCode{

    /** 会员锁定中 */
    MEMBER_LOCKING("MEMBER_LOCKING","会员锁定中"),
    /** 会员个数超限 */
    MEMBER_NUM_OVER("MEMBER_NUM_OVER","会员个数超限"),
    ;

    private String errorCode;

    private String errorMsg;

    MemberErrorCode(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMsg() {
        return errorMsg;
    }
}