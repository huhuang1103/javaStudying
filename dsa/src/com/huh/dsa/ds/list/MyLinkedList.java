package com.huh.dsa.ds.list;

/**
 * 单向链表-自己手写
 * @author huh
 * @version 1.0
 * @date 2021/4/15 1:22
 */

public class MyLinkedList {

    class Node{
        Integer val;
        Node next;
        Node(Integer val,Node next){
            this.val = val;
            this.next = next;
        }
        Node(){

        }
    }
    /**
     * 链表长度
     */
    private transient int size;
    private Node head;
    MyLinkedList(){
        size=0;
        head = new Node();
    }
    public int size() {
        return size;
    }

    public int get(int index) {
        if(index <0 || index>= size){
            return -1;
        }
        Node node = head;
        for(int i=0;i<= index; i++){
            node = node.next;
        }
        if(node == null){
            return -1;
        }
        return node.val;
    }

    public boolean isEmpty(){
        return size ==0;
    }

    Node node(int index) {
        if(isEmpty()){
            return null;
        }
        Node x = head.next;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }
    public void addAtHead(int val) {
        Node newNode = new Node(val,null);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }

    public void addAtTail(int val){
        Node newNode = new Node(val,null);
        if(isEmpty()){
            newNode.next = head.next;
            head.next = newNode;
        }else {
            Node node = node(size-1);
            node.next = newNode;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index > size || index < 0){
            return ;
        }
        if(index == 0){
            addAtHead(val);
        } else if(index == size){
            addAtTail(val);
        }else {
            Node preNode = node(index-1);
            Node newNode = new Node(val,null);
            newNode.next = preNode.next;
            preNode.next = newNode;
            size++;
        }

    }

    public void deleteAtIndex(int index) {
        if(index <0 || index >= size){
            return ;
        }
        if(isEmpty()){
            return;
        }
        Node node = node(index-1);
        if(index == size-1){

        }else if(index == 0){
            Node temp = head.next;
            head.next = temp.next;
            temp = null;
        }else {
            Node preNode = node(index-1);
            Node currentNode = preNode.next;
            preNode.next = currentNode.next;
            currentNode = null;
        }
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        int param_1 = obj.get(0);
        obj.addAtHead(1);
        obj.addAtTail(3);
        obj.addAtIndex(1,2);
        obj.get(1);
        obj.deleteAtIndex(1);
        obj.get(1);
    }
}



/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
