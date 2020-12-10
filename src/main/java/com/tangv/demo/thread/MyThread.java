package com.tangv.demo.thread;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/3/25 1:47 下午
 */
public class MyThread {
    public static class Mythread1 extends Thread{
        @Override
        public void run() {
            System.out.println("hello 仙本那");
        }
    }

    public static class Mythread2 extends Thread{
        @Override
        public void run() {
            System.out.println("hi，新西兰");
        }
    }

    public static int cal(int num){
        if (num == 0 || num == 1){
            return 1;
        }
        return cal(num-1)+cal(num-2);
    }


    /*public static void main(String[] args) {
        int[] array = {1,1,2,3,5,8,13,21,34,55,89,144};
        int first = 1;
        int second = 1;
        int third = 0;
        int num = 10;
        for (int i = 2;i<=num;i++){
            third = first+second;
            first = second;
            second = third;
        }
        System.out.println(third);
        int second2 = LocalDateTime.now().getSecond();
        System.out.println(cal(10));
        int second3 = LocalDateTime.now().getSecond();
    }*/

    public static void main(String[] args) {
        String island = "仙本那";
        island = "新西兰";
        System.out.println(island);
    }

}


