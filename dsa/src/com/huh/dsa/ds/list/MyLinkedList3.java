package com.huh.dsa.ds.list;

/**
 * 力扣原题-设计链表（双向链表）
 *  题解标准答案
 *
 *  复杂度分析
 *
 * 时间复杂度：
 * addAtHead，addAtTail：O(1)
 * get，addAtIndex，delete：O(min(k,N−k))，其中 kk 指的是元素的索引。
 * 空间复杂度：所有的操作都是 O(1)。
 *
 * @author huh
 * @version 1.0
 * @date 2021/5/2 16:53
 */
public class MyLinkedList3 {
    class ListNode {
        int val;
        ListNode next;
        ListNode prev;
        ListNode(int x) { val = x; }
    }

    int size;
    // sentinel nodes as pseudo-head and pseudo-tail
    ListNode head, tail;
    public MyLinkedList3() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        // if index is invalid
        if (index < 0 || index >= size) return -1;

        // choose the fastest way: to move from the head
        // or to move from the tail
        ListNode curr = head;
        if (index + 1 < size - index)
            for(int i = 0; i < index + 1; ++i) curr = curr.next;
        else {
            curr = tail;
            for(int i = 0; i < size - index; ++i) curr = curr.prev;
        }

        return curr.val;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        ListNode pred = head, succ = head.next;

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
        }
        else {
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

        // find predecessor and successor of the node to be deleted
        ListNode pred, succ;
        if (index < size - index) {
            pred = head;
            for(int i = 0; i < index; ++i) pred = pred.next;
            succ = pred.next.next;
        }
        else {
            succ = tail;
            for (int i = 0; i < size - index - 1; ++i) succ = succ.prev;
            pred = succ.prev.prev;
        }

        // delete pred.next
        --size;
        pred.next = succ;
        succ.prev = pred;
    }

}
