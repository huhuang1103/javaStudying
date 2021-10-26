package com.huh.dsa.ds.list;

import com.huh.dsa.ds.ExceptionBoundaryViolation;

import java.util.Arrays;

/**
 * 数组实现顺序表结构
 * @author huh
 * @version 1.0
 * @date 2021/4/6 21:31
 */
public class  ArrayList<T> {
    private static final int DEFAULT_SIZE = 16;//默认初始化大小
    private Object[] elementData ;//保存顺序表中元素
    private int size;//顺序表元素个数
    private static final Object[] EMPTY_ELEMENTDATA = {};

    public ArrayList(){
     this.elementData = EMPTY_ELEMENTDATA;
    }

    /***
     * 初始化顺序表
     * @param initialCapacity
     */
    public ArrayList(int initialCapacity){
        if(initialCapacity > 0){
          this.elementData = new Object[initialCapacity];
        }else if(initialCapacity == 0){
            this.elementData = EMPTY_ELEMENTDATA;
        }else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }

    }

    public boolean isEmpty() {
        return size == 0;
    }

    T elementData(int index) {
        return (T) elementData[index];
    }

    /**
     * 获取下标尾index的元素
     * @param index
     * @return
     */
    public T get(int index){
      if(index >= size){
          throw new ExceptionBoundaryViolation("下标越界");
      }
      return (T) elementData[index];
    }

    /**
     * 在index后添加元素
     * @param index
     * @param element
     */
    public boolean add(int index,T element){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        }
        grow(calculateCapacity(elementData,size+1));
//        System.arraycopy(elementData,index,elementData,index+1,size-index);
        for (int i = size;i>index;i--){
            elementData[size] = elementData[size-1];
        }
        elementData[index] = element;
        size++;
        return true;
    }

    public boolean add(T element){
        grow(calculateCapacity(elementData,size+1));
        elementData[size+1] = element;
        return true;
    }

    public T set(int index,T value){
        rangeCheck(index);
        T oldValue = (T) elementData[index];
        elementData[index] = value;
        return oldValue;
    }

    public T remove(int index){
        rangeCheck(index);
        T oldValue = (T) elementData[index];
        int numMoved = size - index -1;
        if(numMoved > 0){
//            System.arraycopy(elementData, index+1, elementData, index,numMoved);
            for(int i = index;i < size-1;i++){
                elementData[index] = elementData[index +1];
            }
        }
        elementData[--size] = null;//表的长度-1，旧表最后一个元素为空，垃圾回收掉
        return oldValue;
    }

    /**
     * 计算线性表的容量
     * @param elementData
     * @param minCapacity
     * @return
     */
    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_SIZE, minCapacity);
        }
        return minCapacity;
    }

    /**
     * 增长线性表的容量大小
     */
    public void grow(int minCapacity){
         int oldCapacity = elementData.length;
         int newCapacity = oldCapacity + oldCapacity>>2;
         if(newCapacity - minCapacity < 0){
             newCapacity = minCapacity;
         }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private void rangeCheck(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
    }
}
