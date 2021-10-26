package com.huh.singleton.safe.enumClass;

/**
 * @author huh
 * @version 1.0
 * @date 2021/5/11 0:50
 */
public enum Singleton {
    //定义一个枚举的元素，它就是 Singleton 的一个实例
    INSTANCE;

    public void doSomeThing() {
        System.out.println("枚举方法实现单例");
    }
}
