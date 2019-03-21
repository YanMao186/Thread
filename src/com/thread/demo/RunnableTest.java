package com.thread.demo;

/**
 * @program: Thread
 * @description:
 * @author: Mr.Yan
 * @create: 2019-03-21 21:15
 **/

public class RunnableTest implements Runnable {
    @Override
    public void run() {
        System.out.println("线程启动");
    }

    public static void main(String[] args) {
        RunnableTest rt = new RunnableTest();
        Thread th = new Thread(rt);
        th.start();
    }
}
