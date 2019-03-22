package com.thread.demo;

/**
 * @program: Thread
 * @description:
 * @author: Mr.Yan
 * @create: 2019-03-22 22:50
 **/

public class Demo {
    public static void main(String[] args) {
        BaoZi bz = new BaoZi();
        ChiHuo ch = new ChiHuo("吃货",bz);
        BaoZiPu bzp = new BaoZiPu("包子铺",bz);
        ch.start();
        bzp.start();
    }
}
