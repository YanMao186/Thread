package com.thread.demo;

/**
 * @program: Thread
 * @description:通过春运抢票的例子来演示线程安全问题
 * @author: Mr.Yan
 * @create: 2019-03-21 22:33
 **/

public class BuyTicket extends Thread {
    private int ticket = 100;
    @Override
    public void run() {
        while (true) {
            if (ticket>0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "售出票1张,还剩" + ticket-- + "张");
            }else {
                System.out.println("票卖完了");
                break;
            }
        }
    }

    public static void main(String[] args) {
        BuyTicket bt1 = new BuyTicket();
        Thread th1 = new Thread(bt1,"窗口1");
        Thread th2 = new Thread(bt1,"窗口2");
        Thread th3 = new Thread(bt1,"窗口3");
        th1.start();
        th2.start();
        th3.start();
    }
}
