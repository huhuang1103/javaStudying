package com.huh.demo;

public class Sort {

	/**
	 * 冒泡排序法
	 * @param array
	 */
	public static void bubbleSort(int [] array) {
		for (int i = 0; i < array.length-1; i++) {
			for (int j = 0; j < array.length-1-i; j++) {
				if(array[j] >array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					 array[j+1] = temp;
				}
			}
		}
		for (int i : array) {
			
			System.out.println(i);
		}
	}
	public static void main(String[] args) {
		int [] array = {42,3,2,5,7,4,6,0,21,312};
		bubbleSort(array);
	}
}
