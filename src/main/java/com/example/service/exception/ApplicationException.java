package com.example.service.exception;

import java.util.ArrayList;

/**
 * Created by duguangquan on 2018/8/31.
 */
public class ApplicationException extends BaseException {

    public ApplicationException(String errorCode, String errorMsg){
        super(buildErrorMsg(errorCode, errorMsg));
        this.errorCode= errorCode;
        this.errorMsg= errorMsg;
    }

    public ApplicationException(String errorCode, String errorMsg, Throwable throwable) {
        super(throwable);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;

    }

    /**
     * Exception in thread "main" com.example.service.exception.ApplicationException: ERROR#不能为空
     at com.example.service.exception.ApplicationException.main(ApplicationException.java:22)
     * @param args
     */
    public static void main(String[] args) {
        //throw new ApplicationException("ERROR","不能为空");

        ArrayList<Object> objects = new ArrayList<>();
        objects.add("hah");
        objects.add(3);

        try {
            System.err.println("uu");
        } catch (Exception e) {
            throw new ApplicationException("error","message",e);
        }

        throw new IllegalArgumentException("id must not been null");


    }

}
