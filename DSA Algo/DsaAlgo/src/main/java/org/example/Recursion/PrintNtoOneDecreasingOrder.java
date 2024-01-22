package org.example.Recursion;

public class PrintNtoOneDecreasingOrder {

    public static void nToOne(int num)
    {
        if(num == 0)
        {
            return ;
        }
        System.out.println(num);
        nToOne(num-1);
    }

    public static void main(String[] args)
    {
        nToOne(10);
    }
}
