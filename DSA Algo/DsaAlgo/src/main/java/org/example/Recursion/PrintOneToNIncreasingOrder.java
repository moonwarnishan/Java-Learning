package org.example.Recursion;

public class PrintOneToNIncreasingOrder {
    public static void oneToN(int num)
    {
        if(num == 0)
        {
            return;
        }
        oneToN(num-1);
        System.out.println(num);

    }
    public static void main(String[] args)
    {
        oneToN(10);
    }
}
