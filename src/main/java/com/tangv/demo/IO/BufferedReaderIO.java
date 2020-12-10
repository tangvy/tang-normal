package com.tangv.demo.IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/4/29 2:53 下午
 */
public class BufferedReaderIO {

    public static void main(String[] args) {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String bf = null;
            try {
                while ((bf = bufferedReader.readLine()) != null){
                    if (bf.equals("exit")) {
                        System.exit(1);
                    }
                    System.out.println("输入内容："+bf);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}
