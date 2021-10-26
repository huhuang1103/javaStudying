package com.huh.Sort_Algorithms;

/**
 * @author huh
 * @version 1.0
 * @date 2021/10/27 0:17
 */
public class Merge_Sort {
    public static void sort(int[] arr) {
        int[] tempArr = new int[arr.length];
        sort(arr, tempArr, 0, arr.length-1);
    }
    private static void sort(int[] arr,int[] tempArr,int startIndex,int endIndex){
        if(endIndex <= startIndex){
            return;
        }
        //中部下标
        int middleIndex = startIndex + (endIndex - startIndex) / 2;

        //分解
        sort(arr,tempArr,startIndex,middleIndex);
        sort(arr,tempArr,middleIndex + 1,endIndex);

        //归并
        merge(arr,tempArr,startIndex,middleIndex,endIndex);
    }

    private static void merge(int[] arr, int[] tempArr, int startIndex, int middleIndex, int endIndex) {
        //复制要合并的数据
        for (int s = startIndex; s <= endIndex; s++) {
            tempArr[s] = arr[s];
        }

        int left = startIndex;//左边首位下标
        int right = middleIndex + 1;//右边首位下标
        for (int k = startIndex; k <= endIndex; k++) {
            if(left > middleIndex){
                //如果左边的首位下标大于中部下标,证明左边的数据已经排完了。
                arr[k] = tempArr[right++];
            } else if (right > endIndex){
                //如果右边的首位下标大于了数组长度,证明右边的数据已经排完了。
                arr[k] = tempArr[left++];
            } else if (tempArr[right] < tempArr[left]){
                arr[k] = tempArr[right++];//将右边的首位排入,然后右边的下标指针+1。
            } else {
                arr[k] = tempArr[left++];//将左边的首位排入,然后左边的下标指针+1。
            }
        }
    }

    /**
     * 归并排序
     * 简介:将两个（或两个以上）有序表合并成一个新的有序表 即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列
     * 时间复杂度为O(nlogn)
     * 稳定排序方式
     * @param nums 待排序数组
     * @return 输出有序数组
     */
    public static int[] sort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            // 左边
            sort(nums, low, mid);
            // 右边
            sort(nums, mid + 1, high);
            // 左右归并
            merge(nums, low, mid, high);
        }
        return nums;
    }

    /**
     * 将数组中low到high位置的数进行排序
     * @param nums 待排序数组
     * @param low 待排的开始位置
     * @param mid 待排中间位置
     * @param high 待排结束位置
     */
    public static void merge(int[] nums, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;

        // 把较小的数先移到新数组中
        while (i <= mid && j <= high) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // 把右边边剩余的数移入数组
        while (j <= high) {
            temp[k++] = nums[j++];
        }

        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            nums[k2 + low] = temp[k2];
        }
    }

}
