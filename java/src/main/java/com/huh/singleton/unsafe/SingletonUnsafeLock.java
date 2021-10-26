package com.huh.singleton.unsafe;

/**
 * 懒汉模式（将方法锁换成代码块锁,线程不安全）
 * @author huh
 * @version 1.0
 * @date 2021/5/11 0:37
 * 缺点：尝试将方法锁换成代码块锁，想要用减少锁的力度来换取一点效率上的提升，但是却又引入了线程安全的问题
 */
public class SingletonUnsafeLock {
    private static SingletonUnsafeLock INSTANCE;
    private SingletonUnsafeLock(){

    }

    public static SingletonUnsafeLock getINSTANCE() {
        if (INSTANCE == null){
            synchronized (SingletonUnsafeLock.class){
                INSTANCE = new SingletonUnsafeLock();
            }
        }
        return INSTANCE;
    }
}
