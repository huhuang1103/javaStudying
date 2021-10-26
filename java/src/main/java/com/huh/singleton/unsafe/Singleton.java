package com.huh.singleton.unsafe;

/**
 * 懒汉模式（线程不安全）
 * @author huh
 * @version 1.0
 * @date 2021/5/11 0:17
 */
public class Singleton {
    private static Singleton uniqueInstance;
    private Singleton(){

    }
    //没有加入synchronized关键字的版本是线程不安全的
    public static Singleton getInstance() {
        //判断当前单例是否已经存在，若存在则返回，不存在则再建立单例
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

}
