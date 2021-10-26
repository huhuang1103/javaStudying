package com.huh.demo;

public class PrintString implements Runnable
{

    private volatile boolean isContinuePrint = true;

    public boolean isContinuePrint() {
        return isContinuePrint;
    }

    public void setContinuePrint(boolean isContinuePrint) {
        this.isContinuePrint = isContinuePrint;
    }

    public void printStringMethod()
    {
        try
        {
            while(isContinuePrint)
            {
                System.out.println("run printStringMethod threadName = " + Thread.currentThread().getName());
                Thread.sleep(100);
            }
        }
        catch(InterruptedException exception)
        {
            exception.printStackTrace();
        }
    }

    @Override
    public void run() {

        printStringMethod();
    }
}

