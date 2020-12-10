package com.tangv.demo.thread;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/4/20 3:02 下午
 */
public class Station extends Thread {

    public Station(String name){
        super(name);
    }

    static int ticket = 20;

    Object lock = "q";

    @Override
    public void run() {
        while(ticket>0) {
            synchronized (lock) {
                if (ticket > 0) {
                    System.out.println(getName() + "卖出了第" + ticket + "张票");
                    ticket--;
                } else {
                    System.out.println("票卖完了");
                }
            }
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
