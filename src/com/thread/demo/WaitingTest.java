package com.thread.demo;

/**
 * @program: Thread
 * @description:
 * @author: Mr.Yan
 * @create: 2019-03-22 17:07
 **/

public class WaitingTest {
    public static Object obj = new Object();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (obj) {
                        try {
                            obj.wait(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(Thread.currentThread().getName()+"获取到锁对象,调用wait方法,进入waiting状态,释放锁对象");
                    }
                }
            }
        },"等待线程").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println(Thread.currentThread().getName()+"-----等待3秒钟");
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (obj) {
                        System.out.println(Thread.currentThread().getName()+"---获取到锁对象,调用notify()方法,释放锁对象");
                        obj.notify();
                    }
                }
            }
        },"唤醒线程").start();
    }
}
