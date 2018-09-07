package com.example.service.thread;

/**
 * Created by duguangquan on 2018/8/29.
 */
public class threadLocalTest {

    public static void testThreadLocal(){

        Thread t = new Thread(){

            ThreadLocal<String> threadLocal = new ThreadLocal<>();

            @Override
            public void run() {
                super.run();
                threadLocal.set("baota");
                String str = threadLocal.get();
                System.err.println(str);
            }
        };
        t.start();
    }

    /**
     * 1。start():

     我们先来看看API中对于该方法的介绍：

     使该线程开始执行；Java 虚拟机调用该线程的 run 方法。

     结果是两个线程并发地运行；当前线程（从调用返回给 start 方法）和另一个线程（执行其 run 方法）。

     多次启动一个线程是非法的。特别是当线程已经结束执行后，不能再重新启动。

     用start方法来启动线程，真正实现了多线程运行，这时无需等待run方法体代码执行完毕而直接继续执行下面的代码。
     通过调用Thread类的 start()方法来启动一个线程，这时此线程处于就绪（可运行）状态，并没有运行，
     一旦得到cpu时间片，就开始执行run()方法，这里方法 run()称为线程体，它包含了要执行的这个线程的内容，Run方法运行结束，此线程随即终止。
     */
    public static void threadLocalTest2(){

        AccountThread thread = new AccountThread();
        thread.setAccount("baota");
        AccountThread thread2 = new AccountThread();
        thread2.setAccount("baota2");

        Thread thread1 = new Thread(thread);
        thread1.start();
        String account = LoginUtils.getAccount();
        String name = Thread.currentThread().getName();
        System.err.println(name);

        System.err.println(account);
        new Thread(thread2).start();

        String account2 = LoginUtils.getAccount();
        System.err.println(account2);


    }


    public static void main(String[] args) {
        //testThreadLocal();
        threadLocalTest2();

    }




}
