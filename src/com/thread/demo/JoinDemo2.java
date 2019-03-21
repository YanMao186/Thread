package com.thread.demo;

/**
 * @program: Thread
 * @description:
 * @author: Mr.Yan
 * @create: 2019-03-21 21:09
 **/

public class JoinDemo2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        JoinDemo2 jd1 = new JoinDemo2();
        JoinDemo2 jd2 = new JoinDemo2();
        JoinDemo2 jd3 = new JoinDemo2();
        jd1.start();
        try {
            jd1.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        jd2.start();
        jd3.start();
    }
}
