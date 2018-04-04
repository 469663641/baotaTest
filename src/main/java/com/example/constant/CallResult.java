package com.example.constant;

/**
 * Created by baota on 2018/4/4.
 */

public enum CallResult {
    ANSWER(33,"接通"),
    ABANDON(77,"拒接"),
    UN_KNOWN(88,"未知");

    private Integer code;
    private String desc;

    CallResult(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return this.code;
    }

    public String getDesc(){
        return this.desc;
    }

    public String stateOf(int code){

        for (CallResult element: CallResult.values()){
            if (code == element.getCode()){

                return element.getDesc();
            }
        }
        return CallResult.UN_KNOWN.desc;

    }


}
