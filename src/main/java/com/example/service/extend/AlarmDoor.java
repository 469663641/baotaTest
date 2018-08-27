package com.example.service.extend;

/**
 * Created by duguangquan on 2018/8/19.
 */
/*
这种实现方式基本上能够明确的反映出我们对于问题领域的理解，正确的揭示我们的设计意图。
其实抽象类表示 的是"is-a"关系，接口表示的是"like-a"关系
*/
public class AlarmDoor extends Door implements Alarm{
    @Override
    public void alarm() {

    }

    @Override
    void open() {

    }

    @Override
    void close() {

    }
}
