package com.tangv.demo.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/8/11 4:11 下午
 */
public class SortController {

    public static void main(String[] args) {
        int[] array = {13,41,16,6,5,2,19,4567,27,16};
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < array.length-1;i++) {
            for (int j = 0;j<array.length-1-i;j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        for (int i= 0;i<array.length;i++) {
            System.out.print(array[i]+",");
        }
    }


}
