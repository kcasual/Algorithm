package com.cangxiao.sort;

import java.util.Arrays;

/**
 * @Author cangxiao
 * @Date 2021/7/2
 * @Desc
 */
public class QuickSort3 {


    public static void main(String[] args) {
//        int[] array = {13, 15, 24, 99, 14, 11, 1, 2, 3};
        int[] array = {6, 11, 9, 3, 8, 6};
//        int[] array = {4, 3, 2, 1, 5, 4};
        QuickSort3 quickSort= new QuickSort3();
        quickSort.sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public void sort(int[] array, int left, int right) {
        if (left < right) {
            //获取基准值索引进行分区
            int index = partition(array, left, right);
            //每次只需quickSort将原数组一份为2；
            sort(array, left, index - 1);
            sort(array, index + 1, right);
        }
    }

    public int partition(int[] array, int left, int right) {

        //选择一个基准值，大于基准值的放右边，小于基准值的放左边
        int temp = array[left];
        while (left < right) {
            //从右往左，右边的值大于基准值，不需要交换位置，比较下一个值
            while (left < right && temp <= array[right]) {
                right--;
            }
            //当右边的值小于基准值时，交换位置，将右边小的值放到左边
            if(left!=right){
                swap(array, left, right);
            }
            //从左往右，基准值大于左边的值，不需要交换位置，比较下一个值
            while (left < right && temp > array[left]) {
                left++;
            }
            //当左边的值大于基准值时，交换位置，将左边大的值放到右边
            if(left!=right){
                swap(array, left, right);
            }
        }
        //排序完，基准值都会排到数组的中间位置；即 left==right时
        int index = left;
        return index;
    }

    private void swap(int[] array, int left, int right) {

        int t = array[left];
        array[left] = array[right];
        array[right] = t;
    }


}
