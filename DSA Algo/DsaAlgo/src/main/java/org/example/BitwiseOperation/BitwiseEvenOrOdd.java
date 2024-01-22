package org.example.BitwiseOperation;

public class BitwiseEvenOrOdd {
    public static void evenOrOdd(int number)
    {
        if((number & 1) == 1)
        {
            System.out.println("Odd");
        }
        else
            System.out.println("even");
    }
    public static void main(String[] args) {

        evenOrOdd(1);
        evenOrOdd(2);

    }
}