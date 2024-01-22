package org.example.BitwiseOperation;

public class GetSetAndClearithbit {

    public static int getIthBit(int number, int ithNumber)
    {
        var bitmask = 1 << ithNumber;
        if((number&bitmask) == 0)
        {
            return 0;
        }
        else
            return 1;
    }

    public static int setIthBit(int number, int i)
    {
        var bitMask = 1 << i;
        return number | bitMask;
    }
    public static int clearIthBit(int number, int i)
    {
        int bitmask =  ~(1<<i);
        return number & bitmask;
    }

    public static void main(String[] args)
    {
        System.out.println(getIthBit(15,2));
        System.out.println(setIthBit(10,2));
        System.out.println(clearIthBit(10,1));
    }
}
