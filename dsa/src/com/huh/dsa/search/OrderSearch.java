package com.huh.dsa.search;


/**
 * @author huh
 * @version 1.0
 * @date 2021/3/24 0:34
 */
public class OrderSearch {

    /**
     * 顺序查找或线性查找,也叫暴力查找
     * @param arry
     * @param value
     * @return
     */
    public static int orderSearch(int [] arry, int value){
        if(arry == null){
            return -1;
        }
        for (int i =0;i<arry.length;i++){
            if(arry[i] == value){
                return i;
            }
        }

        return -1;
    }

    /**
     * 顺序表查找优化（哨兵）
     * @param arry
     * @param value
     * @return
     */
    public static int seqSearch(int [] arry,int value){
        if(arry == null){
            return -1;
        }
        if(arry[0] == value){
            return 0;
        }
        int index = arry.length-1;
        arry[0] = value;
        while (arry[index] != value){
            index--;
        }
        return index==0?-1:index;
    }

    // 相比单纯的线性查找每次for循环需要判断两次,这里设置关键字值(即哨兵)，可以让每次for循环只判断一次
    // 当数据量比较大时,如果单纯从线性查找角度看,优化后的线性搜索优势明显
    public static int search(int[] array, int key) {
        int len = array.length;
        if (len == 0) // array为空,返回-1
            return -1;
        if (array[0] == key)
            return 0;
        array[0] = key; // array[0]不是key,那么将key赋值给array[0],将array[0]作为哨兵
        // 这里"哨兵"也可以放在数组尾部
        int i = len - 1;
        while (array[i] != key) { // 每次循环少判断一个
            i--;
        }
        if (i == 0) // 从数组尾部一直查找到array[0]才找到,说明不存在
            return -1;
        return i;
    }

    public static void main(String[] args) {
        int[] array ={1,23,4,8,5,9,0};
        int i = orderSearch(array, 0);
        System.out.println(i);
//        int index = seqSearch(array,0);
//        System.out.println(index);
        int search = search(array, 0);
        System.out.println(search);

    }
}
