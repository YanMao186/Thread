package com.thread.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: Thread
 * @description:
 * @author: Mr.Yan
 * @create: 2019-03-23 00:12
 **/

public class MyRunnable extends Thread {
    @Override
    public void run() {
        System.out.println("我需要一个教练");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"教练来了");
        System.out.println("教我游泳,交完后,教练回到泳池");
    }

    public static void main(String[] args) {
        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(2);

        MyRunnable mr = new MyRunnable();
        service.submit(mr);
        service.submit(mr);
        service.shutdown();    //关闭线程池

    }
}
