package org.example.BitwiseOperation;


public class CheckIfANumberIsPowerOfTwoOrNot {
    public static boolean isPowerOfTwo(int number)
    {
        return (number & (number - 1)) == 0;
    }
    public static void main(String[] args)
    {
        System.out.println(isPowerOfTwo(16));
    }
}
