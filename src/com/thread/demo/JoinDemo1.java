package com.thread.demo;

/**
 * @program: Thread
 * @description:
 * @author: Mr.Yan
 * @create: 2019-03-21 21:14
 **/

public class JoinDemo1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        JoinDemo1 dj1 = new JoinDemo1();
        JoinDemo1 dj2 = new JoinDemo1();
        JoinDemo1 dj3 = new JoinDemo1();
        dj1.start();
        try {
            dj1.join();
        }catch (Exception e) {
            System.out.println(e);
        }
        dj2.start();
        dj3.start();
    }

}