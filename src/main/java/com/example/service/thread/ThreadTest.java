package com.example.service.thread;


import com.example.model.SubjectDTO;
import com.example.model.SubjectDTO2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by duguangquan on 2018/8/13.
 */
class MyThread implements Runnable{

    private int count =0;


    @Override
    public void run() {
        System.err.println("进入守护线程，"+ Thread.currentThread().getName());
        try {
            writeToFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.err.println("退出守护线程，"+ Thread.currentThread().getName());
    }

    private void writeToFile() throws Exception{

        File file = new File("/Users/duguangquan/myFille/demo.txt");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, true);
            //int count = 0;
            while (count<10){
                fileOutputStream.write(("\r\nworld"+count+Thread.currentThread().getName()).getBytes());
                System.err.println(Thread.currentThread().getName()+"守护线程写入"+count++);
                Thread.sleep(1000);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadTest {

    /*定义线程池*/
    private static ExecutorService executorService = new ThreadPoolExecutor(10, 10,
            10L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(10));



    public static void dumpThread(){

        /*java.lang.Exception: Stack trace
        at java.lang.Thread.dumpStack(Thread.java:1336)
        at com.example.service.thread.ThreadTest.dumpThread(ThreadTest.java:62)
        at com.example.service.thread.ThreadTest.main(ThreadTest.java:138)*/
        Thread.dumpStack();

        Thread.currentThread().getId();

        //线程的堆栈信息，第一个是最新调用的方法，下面是打印的demo
        /*java.lang.Thread.getStackTrace(Thread.java:1559)
        com.example.service.thread.ThreadTest.dumpThread(ThreadTest.java:10)
        com.example.service.thread.ThreadTest.main(ThreadTest.java:21)*/
        System.err.println(Thread.currentThread().getName());

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();



        for (StackTraceElement element : stackTrace){

            System.err.println(element);
            String className = element.getClassName();
            String methodName = element.getMethodName();
            System.err.println(methodName);

        }
    }

    /**
     * 利用线程的堆栈信息，打印dao层查询数据库的时间日志
     * @param costTime
     * @return
     */
    private static String getInfoMsg(long costTime) {

        StringBuilder infoMsg = new StringBuilder();

        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (stackTraceElement.getClassName()
                    .startsWith("com.meitu.meipu.communitycenter.dao")) {

                infoMsg.append("DAO耗时超长 ");
                infoMsg.append(stackTraceElement.getClassName());
                infoMsg.append("#");
                infoMsg.append(stackTraceElement.getMethodName());
                infoMsg.append(" RT:");
                infoMsg.append(costTime);
                infoMsg.append("ms");
                break;
            }
        }

        return infoMsg.toString();
    }

    public static void execute(){

        List<String> list = new ArrayList<>();
        /*CountDownLatch 用来阻塞资源的，等list都执行完才可以，防止阻塞队列溢出丢失数据*/
        CountDownLatch countDownLatch = new CountDownLatch(list.size());
        MyThread myThread = new MyThread();
        list.forEach(str ->{

            try {
                executorService.execute(new MyThread());
            } finally {
                countDownLatch.countDown();
            }
        });

        try {
            countDownLatch.await();
            list.clear();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {


        List<SubjectDTO> list = new ArrayList<>();
        SubjectDTO2 subjectDTO2 = new SubjectDTO2();
        subjectDTO2.setStatus("hah");
        subjectDTO2.setId(1L);
        list.add(subjectDTO2);
        System.err.println(list);

        dumpThread();

        System.err.println("进入主线程"+ Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        Thread thread = new Thread(myThread);
        Thread thread2 = new Thread(myThread);
        thread.start();
        thread2.start();

        System.err.println("退出主线程"+ Thread.currentThread().getName());


        //System.err.println(Thread.currentThread().getName());
        //dumpThread();
    }
}
