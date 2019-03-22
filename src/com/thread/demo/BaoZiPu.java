package com.thread.demo;

/**
 * @program: Thread
 * @description:
 * @author: Mr.Yan
 * @create: 2019-03-22 22:46
 **/

public class BaoZiPu extends Thread {
    private BaoZi bz;

    public BaoZiPu(String name, BaoZi bz) {
        super(name);
        this.bz = bz;
    }

    @Override
    public void run() {
        int count = 0;
        while (true) {
            synchronized (bz) {
                if (bz.flag == true) {
                    try {
                        bz.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("包包子");
                if (count % 2 == 0) {
                    bz.pier = "牛肉";
                    bz.xianer = "粉条";
                } else {
                    bz.pier = "猪肉";
                    bz.xianer = "大葱";
                }
                count++;
                bz.flag = false;
                System.out.println("包子包好了" + bz.pier + bz.xianer);
                bz.notify();
            }
        }
    }
}
