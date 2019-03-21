package com.thread.demo;

/**
 * @program: Thread
 * @description:使用Thread类实现多线程
 * @author: Mr.Yan
 * @create: 2019-03-21 21:05
 **/

public class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println("线程启动");
    }

    public static void main(String[] args) {
        Thread1 th = new Thread1();
        Thread t = new Thread(th);
        t.start();
    }
}
