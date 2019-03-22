package com.thread.demo;

/**
 * @program: Thread
 * @description:使用同步代码块解决线程安全问题
 * @author: Mr.Yan
 * @create: 2019-03-21 23:05
 **/

public class BuyTicket1 extends Thread {
    private int ticket = 100;
    Object lock = new Object();
    @Override
    public void run() {
        while (ticket > 0) {
            synchronized (lock) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "售出票1张,还剩"+ --ticket+"张");
                }
            }
        }
    }

    public static void main(String[] args) {
        BuyTicket1 bt1 = new BuyTicket1();
        Thread th1 = new Thread(bt1,"窗口1");
        Thread th2 = new Thread(bt1,"窗口2");
        Thread th3 = new Thread(bt1,"窗口3");
        th1.start();
        th2.start();
        th3.start();
    }
}
