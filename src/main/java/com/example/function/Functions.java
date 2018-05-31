package com.example.function;

/**
 * Created by duguangquan on 2018/5/31.
 */
@FunctionalInterface
public interface Functions<T> {
    /**
     * 多个参数的函数
     * @param params 多个参数
     * @return
     */
    T apply(Object... params);

}
