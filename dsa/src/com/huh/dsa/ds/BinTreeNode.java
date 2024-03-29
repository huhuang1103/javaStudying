package com.huh.dsa.ds;

import com.huh.dsa.ds.list.List;
import com.huh.dsa.ds.list.List_DLNode;

/******************************************************************************************
 * Data Structures in C++
 * ISBN: 7-302-33064-6 & 7-302-33065-3 & 7-302-29652-2 & 7-302-26883-3
 * Junhui DENG, deng@tsinghua.edu.cn
 * Computer Science & Technology, Tsinghua University
 * Copyright (c) 2006-2013. All rights reserved.
 ******************************************************************************************/

/*
 * 基于链表节点实现二叉树节点
 */


public class BinTreeNode implements BinTreePosition {
    protected Object element;// 该节点中存放的对象
    protected BinTreePosition parent;// 父亲
    protected BinTreePosition lChild;// 左孩子
    protected BinTreePosition rChild;// 右孩子
    protected int size;// 后代数目
    protected int height;// 高度
    protected int depth;// 深度

    /**************************** 构造方法 ****************************/
    public BinTreeNode() {
        this(null, null, true, null, null);
    }

    public BinTreeNode(Object e, // 节点内容
                       BinTreePosition p, // 父节点
                       boolean asLChild, // 是否作为父节点的左孩子
                       BinTreePosition l, // 左孩子
                       BinTreePosition r) { // 右孩子
        size = 1;
        height = depth = 0;
        parent = lChild = rChild = null;// 初始化
        element = e;// 存放的对象
        // 建立与父亲的关系
        if (null != p)
            if (asLChild)
                p.attachL(this);
            else
                p.attachR(this);
        // 建立与孩子的关系
        if (null != l)
            attachL(l);
        if (null != r)
            attachR(r);
    }

    /**************************** Position接口方法 ********************************/
    // 返回当前节点中存放的对象
    public Object getElem() {
        return element;
    }

    // 将对象obj存入当前节点，并返回此前的内容
    public Object setElem(Object obj) {
        Object bak = element;
        element = obj;
        return bak;
    }

    /**************************** BinTreePosition接口方法 *************************/
    // 判断是否有父亲（为使代码描述简洁）
    public boolean hasParent() {
        return null != parent;
    }

    // 返回当前节点的父节点
    public BinTreePosition getParent() {
        return parent;
    }

    // 设置当前节点的父节点
    public void setParent(BinTreePosition p) {
        parent = p;
    }

    // 判断是否为叶子
    public boolean isLeaf() {
        return !hasLChild() && !hasRChild();
    }

    // 判断是否为左孩子（为使代码描述简洁）
    // 若当前节点有父亲，而且是左孩子，则返回true；否则，返回false
    public boolean isLChild() {
        return (hasParent() && this == getParent().getLChild()) ? true : false;
    }

    // 判断是否有左孩子（为使代码描述简洁）
    public boolean hasLChild() {
        return null != lChild;
    }

    // 返回当前节点的左孩子
    public BinTreePosition getLChild() {
        return lChild;
    }

    // 设置当前节点的左孩子（注意：this.lChild和c.parent都不一定为空）
    public void setLChild(BinTreePosition c) {
        lChild = c;
    }

    // 判断是否为右孩子（为使代码描述简洁）
    // 若当前节点有父亲，而且是右孩子，则返回true；否则，返回false
    public boolean isRChild() {
        return (hasParent() && this == getParent().getRChild()) ? true : false;
    }

    // 判断是否有右孩子（为使代码描述简洁）
    public boolean hasRChild() {
        return null != rChild;
    }

    // 返回当前节点的右孩子
    public BinTreePosition getRChild() {
        return rChild;
    }

    // 设置当前节点的右孩子（注意：this.rChild和c.parent都不一定为空）
    public void setRChild(BinTreePosition c) {
        rChild = c;
    }

    // 返回当前节点后代元素的数目
    public int getSize() {
        return size;
    }

    // 在孩子发生变化后，更新当前节点及其祖先的规模
    public void updateSize() {
        size = 1;// 当前节点
        if (hasLChild())
            size += getLChild().getSize();// 左子树的规模
        if (hasRChild())
            size += getRChild().getSize();// 右子树的规模
        if (hasParent())
            getParent().updateSize();// 递归更新各个真祖先的规模记录
    }

    // 返回当前节点的高度
    public int getHeight() {
        return height;
    }

    // 在孩子发生变化后，更新当前节点及其祖先的高度
    public void updateHeight() {
        height = 0;// 先假设没有左、右孩子
        if (hasLChild())
            height = Math.max(height, 1 + getLChild().getHeight()); // 左孩子
        if (hasRChild())
            height = Math.max(height, 1 + getRChild().getHeight()); // 右孩子
        if (hasParent())
            getParent().updateHeight();// 递归更新各个真祖先的高度记录
    }

    // 返回当前节点的深度
    public int getDepth() {
        return depth;
    }

    // 在父亲发生变化后，更新当前节点及其后代的深度
    public void updateDepth() {
        depth = hasParent() ? 1 + getParent().getDepth() : 0; // 当前节点
        if (hasLChild())
            getLChild().updateDepth();// 沿孩子引用逐层向下，
        if (hasRChild())
            getRChild().updateDepth();// 递归地更新所有后代的深度记录
    }

    // 按照中序遍历的次序，找到当前节点的直接前驱
    public BinTreePosition getPrev() {
        // 若左子树非空，则其中的最大者即为当前节点的直接前驱
        if (hasLChild())
            return findMaxDescendant(getLChild());
        // 至此，当前节点没有左孩子
        if (isRChild())
            return getParent();// 若当前节点是右孩子，则父亲即为其直接前驱
        // 至此，当前节点没有左孩子，而且是左孩子
        BinTreePosition v = this;// 从当前节点出发
        while (v.isLChild())
            v = v.getParent();// 沿左孩子链一直上升
        // 至此，v或者没有父亲，或者是父亲的右孩子
        return v.getParent();
    }

    // 按照中序遍历的次序，找到当前节点的直接后继
    public BinTreePosition getSucc() {
        // 若右子树非空，则其中的最小者即为当前节点的直接后继
        if (hasRChild())
            return findMinDescendant(getRChild());
        // 至此，当前节点没有右孩子
        if (isLChild())
            return getParent();// 若当前节点是左孩子，则父亲即为其直接后继
        // 至此，当前节点没有右孩子，而且是右孩子
        BinTreePosition v = this;// 从当前节点出发
        while (v.isRChild())
            v = v.getParent();// 沿右孩子链一直上升
        // 至此，v或者没有父亲，或者是父亲的左孩子
        return v.getParent();
    }

    // 断绝当前节点与其父亲的父子关系
    // 返回当前节点
    public BinTreePosition secede() {
        if (null != parent) {
            if (isLChild())
                parent.setLChild(null);// 切断父亲指向当前节点的引用
            else
                parent.setRChild(null);
            parent.updateSize();// 更新当前节点及其祖先的规模
            parent.updateHeight();// 更新当前节点及其祖先的高度
            parent = null;// 切断当前节点指向原父亲的引用
            updateDepth();// 更新节点及其后代节点的深度
        }
        return this;// 返回当前节点
    }

    // 将节点c作为当前节点的左孩子
    public BinTreePosition attachL(BinTreePosition c) {
        if (hasLChild())
            getLChild().secede();// 摘除当前节点原先的左孩子
        if (null != c) {
            c.secede();// c脱离原父亲
            lChild = c;
            c.setParent(this);// 确立新的父子关系
            updateSize();// 更新当前节点及其祖先的规模
            updateHeight();// 更新当前节点及其祖先的高度
            c.updateDepth();// 更新c及其后代节点的深度
        }
        return this;
    }

    // 将节点c作为当前节点的右孩子
    public BinTreePosition attachR(BinTreePosition c) {
        if (hasRChild())
            getRChild().secede();// 摘除当前节点原先的右孩子
        if (null != c) {
            c.secede();// c脱离原父亲
            rChild = c;
            c.setParent(this);// 确立新的父子关系
            updateSize();// 更新当前节点及其祖先的规模
            updateHeight();// 更新当前节点及其祖先的高度
            c.updateDepth();// 更新c及其后代节点的深度
        }
        return this;
    }

    // 前序遍历
    public Iterator elementsPreorder() {
        List list = new List_DLNode();
        preorder(list, this);
        return list.elements();
    }

    // 中序遍历
    public Iterator elementsInorder() {
        List list = new List_DLNode();
        inorder(list, this);
        return list.elements();
    }

    // 后序遍历
    public Iterator elementsPostorder() {
        List list = new List_DLNode();
        postorder(list, this);
        return list.elements();
    }

    // 层次遍历
    public Iterator elementsLevelorder() {
        List list = new List_DLNode();
        levelorder(list, this);
        return list.elements();
    }

    /**************************** 辅助方法 ****************************/
    // 在v的后代中，找出最小者
    protected static BinTreePosition findMinDescendant(BinTreePosition v) {
        if (null != v)
            while (v.hasLChild())
                v = v.getLChild();// 从v出发，沿左孩子链一直下降
        // 至此，v或者为空，或者没有左孩子
        return v;
    }

    // 在v的后代中，找出最大者
    protected static BinTreePosition findMaxDescendant(BinTreePosition v) {
        if (null != v)
            while (v.hasRChild())
                v = v.getRChild();// 从v出发，沿右孩子链一直下降
        // 至此，v或者为空，或者没有右孩子
        return v;
    }

    // 前序遍历以v为根节的（子）树
    protected static void preorder(List list, BinTreePosition v) {
        if (null == v)
            return;// 递归基：空树
        list.insertLast(v);// 访问v
        preorder(list, v.getLChild());// 遍历左子树
        preorder(list, v.getRChild());// 遍历右子树
    }

    // 中序遍历以v为根节的（子）树
    protected static void inorder(List list, BinTreePosition v) {
        if (null == v)
            return;// 递归基：空树
        inorder(list, v.getLChild());// 遍历左子树
        list.insertLast(v);// 访问v
        inorder(list, v.getRChild());// 遍历右子树
    }

    // 后序遍历以v为根节的（子）树
    protected static void postorder(List list, BinTreePosition v) {
        if (null == v)
            return;// 递归基：空树
        postorder(list, v.getLChild());// 遍历左子树
        postorder(list, v.getRChild());// 遍历右子树
        list.insertLast(v);// 访问v
    }

    // 层次遍历以v为根节的（子）树
    protected static void levelorder(List list, BinTreePosition v) {
        Queue_List Q = new Queue_List();// 空队
        Q.enqueue(v);// 根节点入队
        while (!Q.isEmpty()) {
            BinTreePosition u = (BinTreePosition) Q.dequeue();// 出队
            list.insertLast(u);// 访问v
            if (u.hasLChild())
                Q.enqueue(u.getLChild());
            if (u.hasRChild())
                Q.enqueue(u.getRChild());
        }
    }

    @Override
    public String toString() {
        return element.toString();
    }

    // 二叉树先序遍历算法(迭代版#1)
    public static void tranPre_I1(List list, BinTreePosition v) {
        // 辅助栈
        Stack_List stack = new Stack_List();
        if (v != null)
            stack.push(v);// 根节点入栈
        while (!stack.isEmpty()) {// 在栈发空之前反复循环
            v = (BinTreePosition) stack.pop();
            list.insertLast(v);// 弹出幵讵问弼前节点，其非空孩子癿入栈次序为
            if (v.hasRChild())
                stack.push(v.getRChild());// 右孩子先入后出
            if (v.hasLChild())
                stack.push(v.getLChild());// 左孩子后入先出
        }

    }

    protected static void visitAlongLeftBranch(List list, BinTreePosition v, Stack_List stack) {
        while (v != null) {
            list.insertLast(v);// 讵问弼前节点
            stack.push(v.getRChild()); // 右孩子入栈暂存（可优化：通过刞断，避免空的右孩子入栈）
            if (v.hasLChild())
                v = v.getLChild(); // 沿左分支深入一局
        }
    }

    // 二叉树先序遍历算法(迭代版#2) 分摊O(1)
    public static void tranPre_I2(List list, BinTreePosition v) {
        // 辅助栈
        Stack_List stack = new Stack_List();
        while (true) {
            visitAlongLeftBranch(list, v, stack);
            if (stack.isEmpty())
                break;
            v = (BinTreePosition) stack.pop();
        }
    }

    // 从当前节点出发，沿左分支丌断深入，直至没有左分支的节点
    static void goAlongLeftBranch(BinTreePosition v, Stack_List stack) {
        while (v != null) {
            stack.push(v);
//	    	if(v.hasLChild()) stack.push(v.getLChild());
            if (v.hasLChild()) {
                v = v.getLChild();
            } else {
                break;
            }
        } // 当前节点入栈后随即向左侧分支深入，迭代直到无左孩子
    }

    // 二叉树中序遍历算法（迭代版#1）
    public static void travIn_I1(List list, BinTreePosition v) {
        // 辅助栈
        Stack_List stack = new Stack_List();
        while (true) {
            goAlongLeftBranch(v, stack); // 从弼前节点出収，逐批入栈
            if (stack.isEmpty())
                break; // 直至所有节点处理完毕
            v = (BinTreePosition) stack.pop();
            list.insertLast(v); // 弹出栈顶节点幵讵问乀
            v = v.getRChild(); // 转向右子树
        }
    }

    // 二叉树中序遍历算法（迭代版#2）
    public static void travIn_I2(List list, BinTreePosition v) {
        // 辅助栈
        Stack_List stack = new Stack_List();
        while (true)
            if (v != null) {
                stack.push(v); // 根节点入栈
                v = v.getLChild(); // 深入遍历左子树
            } else if (!stack.isEmpty()) {
                v = (BinTreePosition) stack.pop(); // 尚未讵问癿最低祖先节点退栈
                list.insertLast(v); // 讵问诠祖先节点
                v = v.getRChild(); // 遍历祖先的右子树
            } else
                break; // 遍历完成
    }

    //前继节点
    public BinTreePosition prev() { // 定位节点v的直接后继
        BinTreePosition s = this; // 纪录后继的临时发量
        if (s.hasLChild()) { // 若有左孩子，则直接后继必在左子树中，具体地就是
            s =  s.getLChild(); // 左子树中
            while (s.hasRChild())
                s = s.getRChild(); // 最靠左（最小）癿节点
        } else { // 否则，直接后继应是“将当前节点包含于其左子树中的最低祖先”，具体地就是
            while (s.isLChild())
                s = s.getParent(); // 逆向地沿右向分支，不断朝左方向移动
            s = s.getParent(); // 最后再朝右上斱秱劢一步，即抵达直接后继（如枅存在）
        }
        return s;
    }

    //后继节点
    public BinTreePosition succ() { // 定位节点v的直接后继
        BinTreePosition s = this; // 纪录后继的临时发量
        if (s.hasRChild()) { // 若有右孩子，则直接后继必在右子树中，具体地就是
            s =  s.getRChild(); // 右子树中
            while (s.hasLChild())
                s = s.getLChild(); // 最靠左（最小）癿节点
        } else { // 否则，直接后继应是“将当前节点包含于其左子树中的最低祖先”，具体地就是
            while (s.isRChild())
                s = s.getParent(); // 逆向地沿右向分支，不断朝左方向移动
            s = s.getParent(); // 最后再朝右上斱秱劢一步，即抵达直接后继（如枅存在）
        }
        return s;
    }

    // 二叉树中序遍历算法（迭代版#3）
    public static void travIn_I3(List list, BinTreePosition v) { // 二叉树中序遍历算法（迭代版#3，无需辅劣栈）
        boolean backtrack = false; // 前一步是否刚从右子树回溯——省去栈，仅O(1)辅劣空间
        while (true)
            if (!backtrack && v.hasLChild()) { // 若有左子树且不是刚刚回溯，则
                v = v.getLChild();
            } // 深入遍历左子树
            else { // 否则——无左子树戒刚刚回溯（相弼亍无左子树）
                list.insertLast(v); // 讵问诠节点
                if (v.hasRChild()) { // 若其右子树非空，则
                    v = v.getRChild(); // 深入右子树继续遍历
                    backtrack = false; // 幵兲闭回溯标志
                } else { // 若右子树空，则
                    if (v.succ() ==null)
                        break; // 回溯（含抵达末节点时癿退出迒回）
                    backtrack = true; // 幵讴置回溯标志
                }
            }
    }

    public static void main(String[] args) {
        BinTreeNode root = new BinTreeNode();
        root.setElem("1");
        // 左子树
        BinTreeNode rootLeft = new BinTreeNode();
        BinTreeNode leftSonL = new BinTreeNode();
        BinTreeNode leftSonR = new BinTreeNode();
        rootLeft.setElem("2");
        leftSonL.setElem("4");
        leftSonR.setElem("5");
        rootLeft.setParent(root);
        rootLeft.setLChild(leftSonL);
        rootLeft.setRChild(leftSonR);
        leftSonL.setParent(rootLeft);
        leftSonR.setParent(rootLeft);

        // 右子树
        BinTreeNode rootRight = new BinTreeNode();
        BinTreeNode rightSonL = new BinTreeNode();
        BinTreeNode rightSonR = new BinTreeNode();
        rootRight.setElem("3");
        rightSonL.setElem("6");
        rightSonR.setElem("7");
        rightSonR.setParent(rootRight);
        rootRight.setLChild(rightSonL);
        rootRight.setRChild(rightSonR);
        rightSonL.setParent(rootRight);


        root.setLChild(rootLeft);
        root.setRChild(rootRight);
        List_DLNode list = new List_DLNode();
//	BinTreeNode.tranPre_I2(list, root);
//	BinTreeNode.tranPre_I1(list, root);
        // 中序遍历
	BinTreeNode.inorder(list, root);
//	BinTreeNode.travIn_I1(list, root);
//	BinTreeNode.travIn_I2(list, root);
//        BinTreeNode.travIn_I3(list, root);
//	System.out.println(rightSonR.succ());
//	System.out.println(rightSonR.getSucc());
//	System.out.println(rightSonR.getPrev());
//	System.out.println(rightSonR.prev());
        for (Iterator iterator = list.elements(); iterator.hasNext();) {
            Object obj = iterator.getNext();
            System.out.println(obj.toString());
        }
    }
}
