package com.tangv.demo.sort;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/8/12 11:42 上午
 */
public class SortMain {
    public static void main(String[] args) {
        /*
        冒泡排序
        */
        int[] array = {13,41,16,6,5,2,19,4567,27,16};
        //降序
        int[] descBubblingSort = BubblingSortService.numDesc(array);
        SortMain.print("冒泡排序降序：",descBubblingSort);
        //升序
        int[] ascBubblingSort = BubblingSortService.numAsc(array);
        SortMain.print("冒泡排序升序：",ascBubblingSort);

        /*
        * 选择排序
        * */
        //降序
        int[] descSelectionSort = SelectionSortService.descSelectionSort(array);
        SortMain.print("选择排序降序：",descSelectionSort);
        //升序
        int[] ascSelectionSort = SelectionSortService.ascSelectionSort(array);
        SortMain.print("选择排序升序：",ascSelectionSort);

        /*
        * 插入排序
        * */
        //降序
        int[] descInsertionSort = InsertionSortService.descInsertionSort(array);
        SortMain.print("插入排序降序：",descInsertionSort);
        //升序
        int[] ascInsertionSort = InsertionSortService.ascInsertionSort(array);
        SortMain.print("插入排序升序：",ascInsertionSort);
    }

    public static void print(String description,int[] array) {

        for (int i = 0;i < array.length;i++) {
            description = description+array[i]+" ";
        }
        System.out.println(description);
    }
}
