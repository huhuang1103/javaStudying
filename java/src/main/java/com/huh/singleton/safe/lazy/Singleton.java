package com.huh.singleton.safe.lazy;

/**
 * 懒汉模式（synchronized关键字线程安全版本）
 * @author huh
 * @version 1.0
 * @date 2021/5/11 0:17
 *
 * 缺点：程序中每次使用getInstance() 都要经过synchronized加锁这一层，这难免会增加getInstance()的方法的时间消费，
 * 而且还可能会发生阻塞。我们下面介绍到的 双重检查加锁版本 就是为了解决这个问题而存在的
 */
public class Singleton {
    private static Singleton uniqueInstance;
    private Singleton(){

    }
    //加入synchronized关键字的版本是线程安全的
    public static synchronized Singleton getInstance() {
        //判断当前单例是否已经存在，若存在则返回，不存在则再建立单例
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }

}
