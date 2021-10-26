package com.huh.dsa.search;

/**
 * @author huh
 * @version 1.0
 * @date 2021/3/26 21:09
 */
public class Fibonacci {
    /**
     * 递归
     * @param n
     * @return
     */
    /**
     * 这里有必要写个注释
     * @param n 数列的第几项（从1开始）
     * */
    private static int fibonacci(int n){
        if(n < 1)
            throw new IllegalArgumentException("index of an array must be a positive number");
        if(n < 3)
            return 1;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * 尾递归计算斐波那契数列第n项
     * @param n
     * @param a
     * @param b
     * @return
     */

    public static int fibonacci(int n, int a,int b){
        if(n < 1)
            throw new IllegalArgumentException("index of an array must be a positive number");
        if(n==1) {
            return a;
        }
        if(n==2) {
            return b;
        }
        return fibonacci(n-1,b,a+b);
    }

    /**
     * f1 = 0, f2 = 1 //fibonacciIteration(1) = 1,fibonacciIteration(0) =0;
     * @param n
     * @return
     */
    public static int fibonacciIteration(int n){
        if (n <= 0) {
            return 0;
        }
        int f1 = 0, f2 = 1;
//        for (int i = 1; i <= n; i++) {
//            f1 = f1 + f2;
//            f2 = f1 - f2;
//        }
        // 下面这种写法更为巧妙
        while (n-- > 0) {
            f1 = f1 + f2;
            f2 = f1 - f2;
        }
        return f1;
    }

    /**
     * for循环
     *
     * @param n
     * @return
     */
    public static  int fibonacciFor(int n) {
        int a = 0;
        int b = 1;
        int c = 0;

        int ni = Integer.valueOf(n).toString().length();

        if (n == 1) {
            c = 0;
        } else if (n == 2) {
            c = 1;
        } else if (n >= 3 && ni <= 32) {
            for (int i = 2; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int fibonacci = fibonacci(6);
        System.out.println(fibonacci);
        int fibonacci1 = fibonacci(6, 1, 1);
        System.out.println(fibonacci1);
        int fibonacciIteration = fibonacciIteration(6);
        System.out.println(fibonacciIteration);

        int n = 44;
//        Scanner input = new Scanner(System.in);
//        System.out.println("请输入要计算的斐波那契数的下标值（从0开始）：");
//        int n = input.nextInt();

        long startTime = System.currentTimeMillis();
//        System.out.println("递归方法输入的斐波那契数的下标值： " + n + ",对应的斐波那契数为 ： " + fibonacci(n));
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("程序运行时间：" + time / 60 + "s");

        long startTime2 = System.currentTimeMillis();
        System.out.println("迭代方法输入的斐波那契数的下标值： " + n + ",对应的斐波那契数为 ： " + fibonacciIteration(n));
        long endTime2 = System.currentTimeMillis();
        long time2 = endTime2 - startTime2;
        System.out.println("程序运行时间：" + time2 / 60 + "s");

        long startTime3 = System.currentTimeMillis();
        System.out.println("for循环方法输入的斐波那契数的下标值： " + n + ",对应的斐波那契数为 ： " + fibonacciFor(n));
        long endTime3 = System.currentTimeMillis();
        long time3 = endTime3 - startTime3;
        System.out.println("程序运行时间：" + time3 / 60 + "s");

        long startTime4 = System.currentTimeMillis();
        System.out.println("尾递归方法输入的斐波那契数的下标值： " + n + ",对应的斐波那契数为 ： " + fibonacci(n,1,1));
        long endTime4 = System.currentTimeMillis();
        long time4 = endTime4 - startTime4;
        System.out.println("程序运行时间：" + time4 / 60 + "s");
    }
}
