package com.tangv.demo.IO;

import java.io.*;
import java.util.HashSet;
import java.util.logging.Logger;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/4/27 11:31 上午
 */
public class IOtest {

    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getGlobal();
        FileReader file = null;
        FileWriter writer = null;
        HashSet s = new HashSet();
        try {
            file = new FileReader("/Users/apple/Downloads/response.txt");
            writer = new FileWriter("/Users/apple/Downloads/滕王阁序.txt");
            char[] b = new char[1024];
            int hasRead = 0;
            while((hasRead=file.read(b))>0){
                writer.write(b,0,hasRead);
            }
            /*
            * 已在内存缓冲中写入，但未写入文档中，可以调用flush()刷新，也可以调用close()，可以刷新缓冲也可以节约内存，推荐close();
            * */
            /*writer.flush();*/
        } catch (FileNotFoundException e) {
            logger.info("文件路径不存在！");
            e.printStackTrace();
        }finally {
            file.close();
            writer.close();
        }

    }

}
