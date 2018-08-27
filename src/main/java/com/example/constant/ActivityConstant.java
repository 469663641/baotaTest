package com.example.constant;

/**
 * Created by duguangquan on 2018/8/19.
 */
public interface ActivityConstant {


    //接口中定义的常亮都是默认 修饰 public static final的
    interface STATUS {

        int UN_START = 0;

        int FINISH = 1;
    }

    interface IS_ONLINE{

        boolean ON_LINE = true;

        boolean OFF_LINE = false;
    }

    public static void main(String[] args) {
        int finish = STATUS.FINISH;
    }
}
