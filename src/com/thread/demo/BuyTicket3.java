package com.thread.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Thread
 * @description:
 * @author: Mr.Yan
 * @create: 2019-03-21 23:36
 **/

public class BuyTicket3 extends Thread {
    private int ticket = 100;
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (ticket > 0) {
            lock.lock();
            if (ticket > 0) {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"卖出1张票,还剩"+ --ticket+"张");
            }
            lock.unlock();
        }

    }
    public static void main(String[] args) {
        BuyTicket3 bt3 = new BuyTicket3();
        Thread th1 = new Thread(bt3,"线程1");
        Thread th2 = new Thread(bt3,"线程2");
        Thread th3 = new Thread(bt3,"线程3");
        th1.start();
        th2.start();
        th3.start();
    }

}
