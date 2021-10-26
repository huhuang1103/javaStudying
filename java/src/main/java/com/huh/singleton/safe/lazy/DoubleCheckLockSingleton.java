package com.huh.singleton.safe.lazy;

/**
 * 懒汉式(双重检查加锁版本)
 * @author huh
 * @version 1.0
 * @date 2021/5/11 0:31
 * 优点：这种方式相比于使用synchronized关键字的方法，可以大大减少getInstance() 的时间消费。
 */
public class DoubleCheckLockSingleton {
    private static DoubleCheckLockSingleton UNIQUEINSTANCE;
    private DoubleCheckLockSingleton(){

    }

    public DoubleCheckLockSingleton getInstance(){
        //检查实例，如果不存在，就进入同步代码块
        if (UNIQUEINSTANCE == null){
            //只有第一次才彻底执行这里的代码
            synchronized (DoubleCheckLockSingleton.class){
            //进入同步代码块后，再检查一次，如果仍是null，才创建实例
                if (UNIQUEINSTANCE == null) {
                    UNIQUEINSTANCE = new DoubleCheckLockSingleton();
                }

            }
        }
        return UNIQUEINSTANCE;
    }
}
