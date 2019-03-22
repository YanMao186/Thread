package com.thread.demo;

/**
 * @program: Thread
 * @description:使用同步方法解决线程安全问题
 * @author: Mr.Yan
 * @create: 2019-03-21 23:26
 **/

public class BuyTicket2 extends Thread {
    private int ticket = 100;
    @Override
    public void run() {
        sellTicket();
    }
    public synchronized void sellTicket() {
        while (ticket > 0) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName()+"卖出1张票,还剩"+ --ticket+"张");
            }
        }
    }

    public static void main(String[] args) {
        BuyTicket2 bt2 = new BuyTicket2();
        Thread th1 = new Thread(bt2,"线程1");
        Thread th2 = new Thread(bt2,"线程2");
        Thread th3 = new Thread(bt2,"线程3");
        th1.start();
        th2.start();
        th3.start();
    }
}
