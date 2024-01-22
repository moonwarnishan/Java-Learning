package org.example.BitwiseOperation;

public class UpdateIthBit {

    public static int clearIthBit(int number, int i)
    {
        int bitmask =  ~(1<<i);
        return number & bitmask;
    }
    public static int updateIthBit(int n, int i, int newBit)
    {
        n = clearIthBit(n,i);
        int bitMask = newBit << i;
        return n | bitMask;

    }

    public static int clearlastIBits(int n, int i)
    {
        var rightShift = n >> i;
        return rightShift << i;
    }

    public static int removeRangeOfBit(int n, int i, int j)
    {
        int a = ((~0)<<(j+1));
        int b = (a << j) -1;
        int bitMask = a | b;
        return n& bitMask;
    }

    public static void main(String[] args)
    {
        System.out.println(updateIthBit(10,2,1));
        System.out.println(clearlastIBits(15,2));
        System.out.println(removeRangeOfBit(10,2,4));

    }
}
