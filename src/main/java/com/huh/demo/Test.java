package com.huh.demo;

public class Test {
    public static  void  main(String [] str){
        try
        {
            PrintString mPrintString = new PrintString();
            Thread mThread = new Thread(mPrintString);
            mThread.start();
            Thread.sleep(1000);
            mPrintString.setContinuePrint(false);//在-server模式下，这个操作修改的是公共堆栈中的值，而线程的私有堆栈并没有修改
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}
