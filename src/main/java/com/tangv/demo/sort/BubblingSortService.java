package com.tangv.demo.sort;

import org.springframework.stereotype.Service;

/**
 * Description: 冒泡排序
 * Author:      TangWei
 * Date:        2020/8/11 4:11 下午
 */
@Service
public class BubblingSortService {

    //降序
    public static int[] numDesc(int[] array) {
        int len = array.length;
        for(int i = 0;i < len-1;i++) {
            for (int j = 0;j < len-1-i;j++) {
                if (array[j] < array[j+1]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    //升序
    public static int[] numAsc(int[] array) {
        for (int i = 0;i < array.length-1;i++) {
            for (int j = 0;j<array.length-1-i;j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }


}
