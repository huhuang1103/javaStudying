package com.huh.Sort_Algorithms;

/**
 * @author huh
 * @version 1.0
 * @date 2021/10/26 23:38
 */
public class Bubble_Sort_Optimization {
    public static void sort(int arr[]){
        for( int i = 0;i < arr.length - 1 ; i++ ){
            boolean isSort = true;
            for( int j = 0;j < arr.length - 1 - i ; j++ ){
                int temp = 0;
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSort = false;
                }
            }
            if(isSort){
                break;
            }
        }
    }
    public static void main(String[] args) {
        int arr[] ={31,22,51,7,8,31};
        sort(arr);
        for( int i = 0 ; i <= arr.length -1 ; i++ ){
            System.out.println(arr[i]);
        }

    }
}
