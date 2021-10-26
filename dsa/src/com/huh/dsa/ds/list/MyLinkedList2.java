package com.huh.dsa.ds.list;

/**
 * 双向链表的实现--自己手写
 * @author huh
 * @version 1.0
 * @date 2021/4/25 21:37
 */
public class MyLinkedList2 {
    class ListNode{
        int val;
        ListNode prev,next;
        public ListNode(int x){
            this.val =x;
        }
    }

    private  transient int size;
    ListNode head,tail;
    public MyLinkedList2() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    public boolean empty(){
        return size ==0;
    }
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        // if index is invalid
        if (index < 0 || index >= size) return -1;

        if(index < (size>>1) ){
           ListNode curr = head;
           for (int i =0 ;i<= index; ++i) curr = curr.next;
           return curr.val;
        }else {
            ListNode curr = tail;
            for (int i = size - 1; i >= index; i--) curr = curr.prev;
            return curr.val;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode pred = head,succ = head.next;
        ++size;
        ListNode toAdd = new ListNode(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;

    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        ListNode succ = tail, pred = tail.prev;

        ++size;
        ListNode toAdd = new ListNode(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
    }
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        // If index is greater than the length,
        // the node will not be inserted.
        if (index > size) return;

        // [so weird] If index is negative,
        // the node will be inserted at the head of the list.
        if (index < 0) index = 0;

        // find predecessor and successor of the node to be added
        ListNode pred, succ;
        if (index < size - index) {
            pred = head;
            for(int i = 0; i < index; ++i) pred = pred.next;
            succ = pred.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index; ++i) succ = succ.prev;
            pred = succ.prev;
        }

        // insertion itself
        ++size;
        ListNode toAdd = new ListNode(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        // if the index is invalid, do nothing
        if (index < 0 || index >= size) return;

        ListNode currentNode = node(index);
        final ListNode next = currentNode.next;
        final ListNode prev = currentNode.prev;
        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            currentNode.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            currentNode.next = null;
        }
        size--;
    }

    ListNode node(int index){
        if(index < (size>>1)){
           ListNode x = head;
            for (int i = 0; i <= index; i++)
                x = x.next;
            return x;
        } else {
            ListNode x = tail;
            for (int i = size - 1; i >= index; i--)
                x = x.prev;
            return x;
        }
    }
}
