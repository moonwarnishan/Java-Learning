package org.example.Recursion;

public class FirstOccurenceOfArray {

    public static int firstOccur(int[] arr, int key, int i)
    {
        if(i == arr.length)
        {
            return -1;
        }
        if(arr[i] == key)
        {
            return i;
        }
        return firstOccur(arr,key,i+1);
    }
    public static void main(String[] args)
    {
        int[] arr = {0,1,2,3,4,54,67};
        System.out.println(firstOccur(arr,66,0));
    }
}
