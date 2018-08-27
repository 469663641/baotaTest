package com.example.model;

import com.example.common.BaseDomain;

/**
 * Created by duguangquan on 2018/8/5.
 */
public class TipsModel<T> extends BaseDomain{

    private String title;

    private T content;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
