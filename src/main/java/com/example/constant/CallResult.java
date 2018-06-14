package com.example.constant;

import org.hibernate.loader.custom.Return;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

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

    public Integer getCode(){
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
    
    public CallResult getCallResultByCode(Integer code) {

        CallResult callResult = null;

        ArrayList<Object> list = new ArrayList<>();

        if (code == null) {
            return CallResult.UN_KNOWN;
        }
        Optional<CallResult> callResultOpt = Arrays.stream(CallResult.values())
                .filter(c -> c.getCode().equals(code)).findAny();

        //callResultOpt.ifPresent(c -> list.add(c));

        if (callResultOpt.isPresent()) {
            return callResultOpt.get();
        }
        return null;
    }




}
