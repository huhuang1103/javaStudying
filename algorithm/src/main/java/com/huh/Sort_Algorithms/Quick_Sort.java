package com.huh.Sort_Algorithms;

/**
 * @author huh
 * @version 1.0
 * @date 2021/10/27 0:35
 */
public class Quick_Sort {

    /*
     * 快速排序
     * 两个方向，左边的i下标一直往右走，当a[i] <= a[center_index]，
     * 其中center_index是中枢元素的数组下标，而右边的j下标一直往左走，当a[j] > a[center_index]
     * 如果i和j都走不动了，i <= j, 交换a[i]和a[j],重复上面的过程，直到i>j
     * 交换a[j]和a[center_index]，完成一趟快速排序
     * 枢轴采用三数中值分割法可以优化
     */
    //递归快速排序
    public static void quickSort(int a[]){
        qSort(a, 0, a.length - 1);
    }
    //递归排序，利用两路划分
    public static void qSort(int a[],int low,int high){
        int pivot = 0;
        if(low < high){
            //将数组一分为二
            pivot = partition(a,low,high);
            //对第一部分进行递归排序
            qSort(a,low,pivot);
            //对第二部分进行递归排序
            qSort(a,pivot + 1,high);
        }
    }
    //partition函数，实现三数中值分割法
    public static int partition(int a[],int low,int high){
        int pivotkey = a[low];   //选取第一个元素为枢轴记录
        while(low < high){
            //将比枢轴记录小的交换到低端
            while(low < high && a[high] >= pivotkey){
                high--;
            }
            //采用替换而不是交换的方式操作
            a[low] = a[high];
            //将比枢轴记录大的交换到高端
            while(low < high && a[low] <= pivotkey){
                low++;
            }
            a[high] = a[low];
        }
        //枢纽所在位置赋值
        a[low] = pivotkey;
        //返回枢纽所在的位置
        return low;
    }

    public static void sort(int[] arr,int begin,int end) {
        //先定义两个参数接收排序起始值和结束值
        int a = begin;
        int b = end;
        //先判断a是否大于b

        if (a >= b) {
            //没必要排序
            return;
        }
        //基准数,默认设置为第一个值
        int x = arr[a];

        //循环
        while (a < b) {
            //从后往前找,找到一个比基准数x小的值,赋给arr[a]
            //如果a和b的逻辑正确--a<b ,并且最后一个值arr[b]>x,就一直往下找,直到找到后面的值大于x
            while (a < b && arr[b] >= x) {
                b--;
            }
            //跳出循环,两种情况,一是a和b的逻辑不对了,a>=b,这时候排序结束.二是在后面找到了比x小的值
            if (a < b) {
                //将这时候找到的arr[b]放到最前面arr[a]
                arr[a] = arr[b];
                //排序的起始位置后移一位
                a++;
            }

            //从前往后找,找到一个比基准数x大的值,放在最后面arr[b]
            while (a < b && arr[a] <= x) {
                a++;
            }
            if (a < b) {
                arr[b] = arr[a];
                //排序的终止位置前移一位
                b--;
            }
        }
        //跳出循环 a < b的逻辑不成立了,a==b重合了,此时将x赋值回去arr[a]
        arr[a] = x;
        //调用递归函数,再细分再排序
        sort(arr,begin,a-1);
        sort(arr,a+1,end);
    }


    public static void printArr(int[] numbers)
    {
        for(int i = 0 ; i < numbers.length ; i ++ )
        {
            System.out.print(numbers[i] + ",");
        }
        System.out.println("");
    }

    public static void main(String[] args)
    {
        int[] numbers = {10,20,15,0,6,7,2,1,-5,55};
        System.out.print("排序前：");
        printArr(numbers);

        Bubble_Sort.bubbleSort(numbers);
        System.out.print("冒泡排序后：");
        printArr(numbers);


        sort(numbers,0,numbers.length-1);
        System.out.print("快速排序后：");
        printArr(numbers);
    }
}
