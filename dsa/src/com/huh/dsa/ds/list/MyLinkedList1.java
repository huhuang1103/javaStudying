package com.huh.dsa.ds.list;

/**
 * 力扣原题-设计链表（单向链表）
 *  题解标准答案
 *
 *  时间复杂度：
 * addAtHead： O(1)
 * addAtInder，get，deleteAtIndex: O(k)，其中 kk 指的是元素的索引。
 * addAtTail：O(N)，其中 NN 指的是链表的元素个数。
 * 空间复杂度：所有的操作都是 O(1)。
 *
 * @author huh
 * @version 1.0
 * @date 2021/4/25 21:21
 */
public class MyLinkedList1 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    int size;
    ListNode head;  // sentinel node as pseudo-head
    public MyLinkedList1() {
        size = 0;
        head = new ListNode(0);
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        // if index is invalid
        if (index < 0 || index >= size) return -1;
        ListNode curr = head;
        // index steps needed
        // to move from sentinel node to wanted index
        for(int i = 0; i < index + 1; ++i)
            curr = curr.next;
        return curr.val;
    }
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        // If index is greater than the length,
        // the node will not be inserted.
        if (index > size) return;

        // [so weird] If index is negative,
        // the node will be inserted at the head of the list.
        if (index < 0) index = 0;

        ++size;
        // find predecessor of the node to be added
        ListNode pred = head;
        for(int i = 0; i < index; ++i) pred = pred.next;

        // node to be added
        ListNode toAdd = new ListNode(val);
        // insertion itself
        toAdd.next = pred.next;
        pred.next = toAdd;
    }
}
