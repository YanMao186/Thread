package com.thread.demo;

/**
 * @program: Thread
 * @description:
 * @author: Mr.Yan
 * @create: 2019-03-22 22:43
 **/

public class ChiHuo extends Thread {
    private BaoZi bz;

    public ChiHuo(String name, BaoZi bz) {
        super(name);
        this.bz = bz;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bz) {
                if (bz.flag == false) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("吃货正在吃"+bz.pier+bz.xianer+"包子");
                bz.flag = false;
                bz.notify();
            }
        }
    }
}
