package org.example.Recursion;

public class XPowerN {
    public static int pow(int x,int n)
    {
        if(n == 1)
        {
            return x;
        }
        return x * pow(x, n-1);
    }
    public static int powOptimizedSolution(int a, int n)
    {
        if(n == 0)
            return 1;
        int halfPowerSq = powOptimizedSolution(a,n/2) * powOptimizedSolution(a,n/2);
        if((n & 1) !=0)
        {
            halfPowerSq = a* halfPowerSq;
        }
        return halfPowerSq;
    }
    public static void main(String[] args)
    {
         System.out.println(pow(3,3));
         System.out.println(powOptimizedSolution(3,3));
    }
}
