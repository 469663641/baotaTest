package com.example.model;

import com.example.common.BaseDomain;

import java.util.List;

/**
 * Created by duguangquan on 2018/8/16.
 */
public class TipsMixModel<T> extends BaseDomain{


    private static final long serialVersionUID = -1269495601891747791L;

    private String key;

    private List<T> values;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<T> getValues() {
        return values;
    }

    public void setValues(List<T> values) {
        this.values = values;
    }
}
