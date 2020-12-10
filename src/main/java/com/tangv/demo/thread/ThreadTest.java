package com.tangv.demo.thread;

import org.springframework.util.CollectionUtils;

import java.util.Arrays;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/3/25 1:54 下午
 */
public class ThreadTest {

    public static void main(String[] args) {
        /*MyThread.Mythread1 mythread1 = new MyThread.Mythread1();
        MyThread.Mythread2 mythread2 = new MyThread.Mythread2();
        mythread1.start();
        mythread2.start();
        for (int i = 0;i<100;i++){
            if (i%2==0){
                mythread2.run();
            }else{
                mythread1.run();
            }
        }*/

        Station stationA = new Station("窗口A");
        Station stationB = new Station("窗口B");
        Station stationC = new Station("窗口C");
        stationA.start();
        stationB.start();
        stationC.start();
    }

}
