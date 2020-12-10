package com.tangv.demo.sort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description: 选择排序
 * Author:      TangWei
 * Date:        2020/8/12 11:34 上午
 */
public class SelectionSortService {
    //选择排序降序
    public static int[] descSelectionSort(int[] array) {
        int len = array.length;
        //最后剩一个数不需要排序了，所以范围是len-1
        for (int i = 0;i < len-1;i++) {
            int max = array[i];
            int index = i;
            //当前数不需要比较，从后一位开始，所以从i+1开始
            for (int j = i+1;j <len;j++) {
                if (array[j] > max) {
                    max = array[j];
                    index = j;
                }
            }
            int temp = array[i];
            array[i] = max;
            array[index] = temp;
        }
        return array;
    }

    //选择排序升序
    public static int[] ascSelectionSort(int[] array) {
        int len = array.length;
        //最后剩一个数不需要排序了，所以范围是len-1
        for (int i = 0;i < len-1;i++) {
            int min = array[i];
            int index = i;
            //当前数不需要比较，从后一位开始，所以从i+1开始
            for (int j = i+1;j < len;j++) {
                if (array[j] < min) {
                    min = array[j];
                    index = j;
                }
            }
            int temp = array[i];
            array[i] = min;
            array[index] = temp;
        }
        return array;
    }
}
