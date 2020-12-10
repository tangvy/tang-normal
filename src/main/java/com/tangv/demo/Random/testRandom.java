package com.tangv.demo.Random;

import java.util.Random;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/4/26 9:50 上午
 */
public class testRandom {

    public static void main(String[] args) {
        Random random = new Random();
        int d = random.nextInt(10);
        System.out.println(d);
        System.out.println((int)(Math.random()*10));
    }

}
