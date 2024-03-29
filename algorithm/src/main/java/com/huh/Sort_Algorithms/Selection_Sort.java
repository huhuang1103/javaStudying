package com.huh.Sort_Algorithms;

/**
 * 选择排序算法
 * 在未排序序列中找到最小元素，存放到排序序列的起始位置
 * 再从剩余未排序元素中继续寻找最小元素，然后放到排序序列末尾。
 * 以此类推，直到所有元素均排序完毕。
 */

/**
 * @author huh
 * @version 1.0
 * @date 2021/10/26 23:44
 */
public class Selection_Sort {
    public static void sort(int[] numbers) {
        int size = numbers.length; //数组长度
        int temp = 0; //中间变量

        for (int i = 0; i < size; i++) {
            int k = i;   //待确定的位置
            //选择出应该在第i个位置的数
            for (int j = size - 1; j > i; j--) {
                if (numbers[j] < numbers[k]) {
                    k = j;
                }
            }
            //交换两个数
            temp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = temp;
        }
    }
        public static void selectSort(int[] arr){
            for( int i = 0;i < arr.length ; i++ ){
                int min = i;//最小元素的下标
                for(int j = i + 1;j < arr.length ; j++ ){
                    if(arr[j] < arr[min]){
                        min = j;//找最小值
                    }
                }
                //交换位置
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }

    public static void main(String[] args) {
        int arr[] ={1,32,21,23,4,31};
        selectSort(arr);
        for( int i = 0 ; i <= arr.length -1 ; i++ ){
            System.out.println(arr[i]);
        }

    }
}
