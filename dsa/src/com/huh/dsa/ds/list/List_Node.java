package com.huh.dsa.ds.list;

/**
 * @author huh
 * @version 1.0
 * @date 2021/4/15 2:34
 */
public class List_Node {
    private int data;
    private List_Node next;

    public List_Node getNext() {
        return next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(List_Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public List_Node(int data,List_Node next){
        this.data = data;
        this.next = next;
    }
}
