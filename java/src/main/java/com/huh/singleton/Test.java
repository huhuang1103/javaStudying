package com.huh.singleton;

import com.huh.singleton.safe.enumClass.Singleton;

/**
 * @author huh
 * @version 1.0
 * @date 2021/5/11 0:51
 */
public class Test {
    public static void main(String[] args) {
        Singleton singleton  = Singleton.INSTANCE;
        singleton.doSomeThing();
    }
}
