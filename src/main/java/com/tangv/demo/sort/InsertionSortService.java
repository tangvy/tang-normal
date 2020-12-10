package com.tangv.demo.sort;

/**
 * Description: 插入排序
 * Author:      TangWei
 * Date:        2020/8/12 2:33 下午
 */
public class InsertionSortService {
    public static int[] ascInsertionSort(int[] array) {
        int len = array.length;
        for (int i =1;i < len;i++) {
            int preIndex = i-1;
            int current = array[i];
            while(preIndex >= 0 && array[preIndex] > current) {
                array[preIndex+1] = array[preIndex];
                preIndex--;
            }
            array[preIndex+1] = current;
        }
        return array;
    }

    public static int[] descInsertionSort(int[] array){
        int len = array.length;
        for (int i = 1;i < len;i++) {
            int preIndex = i-1;
            int current = array[i];
            while (preIndex >= 0 && array[preIndex] < current) {
                array[preIndex+1] = array[preIndex];
                preIndex--;
            }
            array[preIndex+1] = current;
        }
        return array;
    }
}
