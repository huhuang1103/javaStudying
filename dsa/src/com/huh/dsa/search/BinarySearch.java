package com.huh.dsa.search;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/**
 * 二分查找
 *
 * @author huh
 * @version 1.0
 * @date 2021/3/24 0:34
 */
public class BinarySearch {
    /**
     * 时间复杂度分析：当n/2^k= 1 时，最坏情况，k=log2n
     * 常量级时间复杂度的算法有时候可能还没有 O(logn) 的算法执行效率高
     */

    /**
     * 必须是有序的线性表
     * <p>
     * 时间复杂度 O(logn)
     *
     * @param array
     * @param value
     * @return
     */
    public static int binarySearch(int[] array, int value) {
        int low = 0, high = array.length - 1;
        while (low < high){
            int middle = (low + high) / 2;
            if (value == array[middle]) {
                return middle;
            } else if (value > array[middle]) {
                low = middle + 1;
            } else if (value < array[middle]) {
                high = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找的递归查找
     *
     * @param array
     * @param findVal
     * @param low
     * @param high
     * @return
     */
    public static int binarySearch(int[] array, int findVal, int low, int high) {
        //low>high，说明递归整个数组，但是没有找到
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (array[mid] == findVal) {
            return mid;
        } else if (array[mid] > findVal) {
            return binarySearch(array, findVal, low, mid - 1);
        } else if (array[mid] < findVal) {
            return binarySearch(array, findVal, mid + 1, high);
        }
        return -1;
    }

    /**
     * 插值排序，二分查找的变种
     * mid = low + （high-low）/2，改成mid =low + (key - a[low])/(a[high]-a[low])*(high-low)
     * 插值索引:int mid = low +（high-low）*（key-a[low])/(a[high]-a[low]);
     *
     * @param array
     * @param findVal
     * @return
     */
    public static int insertValueSearch(int[] array, int findVal) {
        int low = 0, high = array.length - 1;
        while (low < high) {
            int mid = low + (high - low) * (findVal - array[low]) / (array[high] - array[low]);
            // mid = (high + low) / 2;// 折半下标
            if (findVal > array[mid]) {
                low = mid + 1; // 关键字比 折半值 大，则最小下标 调成 折半下标的下一位
            } else if (findVal < array[mid]) {
                high = mid - 1;// 关键字比 折半值 小，则最大下标 调成 折半下标的前一位
            } else {
                return mid; // 当 key == a[mid] 返回 折半下标
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
//        FileChannel largeAllowlist = new FileInputStream("F:\\Users\\huhuang\\GitHub\\javaStudying\\dsa\\doc\\file\\largeAllowlist.txt").getChannel();
//        FileChannel fileChannel = new FileInputStream("F:\\Users\\huhuang\\GitHub\\javaStudying\\dsa\\doc\\file\\largeText.txt").getChannel();
//        ByteBuffer byteBuffer = ByteBuffer.allocate(8);
////        int[] whiteList =
//
//        largeAllowlist.read(byteBuffer);
//        byteBuffer.flip();
//        IntBuffer intBuffer = byteBuffer.asIntBuffer();
//        while (intBuffer.hasRemaining()) {
//            System.out.println(intBuffer.get());
//        }
        int[] wihteList = In.readInts("F:\\Users\\huhuang\\GitHub\\javaStudying\\dsa\\doc\\file\\largeAllowlist.txt");
        int[] largeText = In.readInts("F:\\\\Users\\\\huhuang\\\\GitHub\\\\javaStudying\\\\dsa\\\\doc\\\\file\\\\largeText.txt");
        Arrays.sort(wihteList);
//        while (!StdIn.isEmpty()) {
//            int key = StdIn.readInt();
//            if(binarySearch(wihteList,key)<0){
//                StdOut.println(key);
//            }
//        }
        long start = System.currentTimeMillis();
        for (int key: largeText) {
            if(binarySearch(wihteList,key)<0){
               System.out.println(key);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("search time is:"+(end-start)/1000);
    }
}
