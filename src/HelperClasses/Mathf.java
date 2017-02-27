package HelperClasses;

/**
 * Created by Chris on 30-Jan-17.
 */
public class Mathf
{
    public static int factorial(int number)
    {
        int fact = 1;
        for (int i = 2; i <= number; i++)
        {
            fact *= i;
        }
        return fact;
    }

    public static long factorial(long number)
    {
        long fact = 1;
        for (int i = 2; i <= number; i++)
        {
            fact *= i;
        }
        return fact;
    }

    public static int factorialRecursion(int n)
    {
        if (n < 3)
        {
            return n;
        }else
        {
            return factorialRecursion(n - 1);
        }
    }
}
