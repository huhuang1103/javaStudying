package com.huh.dsa.ds.list;

import com.huh.dsa.ds.ExceptionPositionInvalid;
import com.huh.dsa.ds.Iterator;
import com.huh.dsa.ds.Node;
import com.huh.dsa.ds.Position;

import java.util.NoSuchElementException;

/**
 * 带头尾节点的单链表
 * @author huh
 * @version 1.0
 * @date 2021/4/2 1:05
 */
public class List_SLNode {
    private transient int size;//链表的长度
    private Node head, tail;//带头尾节点

    protected transient int modCount = 0;

    public List_SLNode(){
        this.size = 0;
        head = tail = new Node(null,null);
        head.setNext(tail);
    }

    public int getSize() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


    /**
     *
     * @return the first element in this list.
     */
    public Object first() {
        final Node l = head;
        if (l == null)
            throw new NoSuchElementException();
        return l.getElem();
    }


    /**
     *
     * @return the last element in this list.
     */
    public Object last() {
        final Node l = tail;
        if (l == null)
            throw new NoSuchElementException();
        return l.getElem();
    }


    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public Object get(int index) {
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);
        }
        return node(index).getElem();
    }

    /**
     * Inserts the specified element at the beginning of this list.
     * @param e
     */
    public void addFirst(Object e) {
        Node f = head;
        Node newNode = new Node(e,head.getNext());
        this.size++;
        modCount++;
    }

    /**
     * add e at the end of this list
     * @param e
     */
    public void addLast(Object e) {
        Node l = tail;
        Node newNode = new Node(e,null);
        if(l == null){
           head = newNode;
        }else {
            l.setNext(newNode);
        }
        size++;
        modCount++;
    }

    public void add(){

    }


    public Position insertAfter(Position p, Object e) throws ExceptionPositionInvalid {
        return null;
    }


    public Position insertBefore(Position p, Object e) throws ExceptionPositionInvalid {
        return null;
    }


    public Object remove(Position p) throws ExceptionPositionInvalid {
        return null;
    }


    public Object removeFirst() {
        return null;
    }


    public Object removeLast() {
        return null;
    }


    public Object replace(Position p, Object e) throws ExceptionPositionInvalid {
        return null;
    }


    public Iterator positions() {
        return null;
    }


    public Iterator elements() {
        return null;
    }

    /**************************** 辅助方法 ****************************/
    // 检查给定位置在列表中是否合法，若是，则将其转换为*DLNode
    protected Node checkPosition(Position p) throws ExceptionPositionInvalid {
        if (null == p)
            throw new ExceptionPositionInvalid("意外：传递给Single_List的位置是null");
        if (head == p)
            throw new ExceptionPositionInvalid("意外：头节点哨兵位置非法");
        if (tail == p)
            throw new ExceptionPositionInvalid("意外：尾结点哨兵位置非法");
        Node temp = (Node) p;
        return temp;
    }

    Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++)
            x = x.getNext();
        return x;
    }
}
