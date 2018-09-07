package com.example.service.thread;


/**
 * Created by duguangquan on 2018/8/13.
 */
public class ThreadTest {



    public static void dumpThread(){

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

    public static void main(String[] args) {

        System.err.println(Thread.currentThread().getName());
        dumpThread();
    }
}
