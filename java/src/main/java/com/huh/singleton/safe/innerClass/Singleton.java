package com.huh.singleton.safe.innerClass;

/**
 * 静态内部实现的单例是懒加载的且线程安全。
 * @author huh
 * @version 1.0
 * @date 2021/5/11 0:46
 */
public class Singleton {
    private static class SingletonHolder{
        private static Singleton INSTANCE = new Singleton();

    }
    private Singleton (){}
    public static final Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
