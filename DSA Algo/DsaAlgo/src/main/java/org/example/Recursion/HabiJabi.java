package org.example.Recursion;

import jdk.dynalink.beans.StaticClass;

public class HabiJabi {

    public static int sumOfNNumber(int n)
    {
        if(n == 1)
        {
            return 1;
        }
        return n + sumOfNNumber(n-1);
    }

    //calculate nth term in fibonacchi
    public static int fibo(int n)
    {
        if(n == 0 || n == 1)
        {
            return n;
        }
       return fibo(n-1) + fibo(n-2);
    }

    public static void main(String[] args)
    {
        //   System.out.println(sumOfNNumber(10));
        System.out.println(fibo(7));
    }
}
