package com.thread.demo;

/**
 * @program: Thread
 * @description:
 * @author: Mr.Yan
 * @create: 2019-03-22 16:43
 **/

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) {
                System.out.println("===="+i+"====");
            }
            System.out.println(i);
            try {
                Thread.sleep(1000);
                System.out.println("线程睡眠1秒!");
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();
    }
}
