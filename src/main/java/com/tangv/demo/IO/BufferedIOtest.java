package com.tangv.demo.IO;

import java.io.*;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/4/29 2:21 下午
 */
public class BufferedIOtest {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInput = null;
        FileOutputStream fileOutput = null;
        BufferedInputStream bufferedInput = null;
        BufferedOutputStream bufferedOutput = null;
        try {
            fileInput = new FileInputStream("/Users/apple/Downloads/滕王阁序.txt");
            fileOutput = new FileOutputStream("/Users/apple/Downloads/新滕王阁序.txt");
            bufferedInput = new BufferedInputStream(fileInput);
            bufferedOutput = new BufferedOutputStream(fileOutput);
            byte[] b = new byte[1024];
            int hasRead = 0;
            while ((hasRead=bufferedInput.read(b))>0) {
                bufferedOutput.write(b,0,hasRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            bufferedInput.close();
            bufferedOutput.close();
        }
    }

}
