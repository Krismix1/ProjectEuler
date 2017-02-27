package HelperClasses;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chris on 31-Jan-17.
 */
public class Fibonacci
{

    // Saves the numbers so we don't have to calculate them again
    public static long fibonacci(int n)
    {
        if (n < 3)
        {
            return 1;
        }

        //Map to store the previous results
        Map<Integer, Long> computedValues = new HashMap<>();

        //The two edge cases
        computedValues.put(1, 1L);
        computedValues.put(2, 1L);

        return fibonacci(n, computedValues);
    }

    private static long fibonacci(int n, Map<Integer, Long> computedValues)
    {
        if (computedValues.containsKey(n))
        {
            return computedValues.get(n);
        }

        computedValues.put(n - 1, fibonacci(n - 1, computedValues));
        computedValues.put(n - 2, fibonacci(n - 2, computedValues));

        long newValue = computedValues.get(n - 1) + computedValues.get(n - 2);

        computedValues.put(n, newValue);
        return newValue;
    }


    // Iterative solution
    public static long fibonacciDP1(int n)
    {
        long[] results = new long[n + 1];
        results[1] = 1;
        results[2] = 1;
        for (int i = 3; i <= n; i++)
        {
            results[i] = results[i - 1] + results[i - 2];
        }
        return results[n];
    }

    // Improved by requiring less memory
    public static long fibonacciDP2(int n)
    {
        if (n < 3)
        {
            return 1;
        }
        long n1 = 1;
        long n2 = 1;
        long current = 2;
        for (int i = 3; i <= n; i++)
        {
            current = n1 + n2;
            n2 = n1;
            n1 = current;
        }
        return current;
    }

    public static BigInteger fibonacciBigInteger(int n)
    {
        BigInteger number = BigInteger.valueOf(n);
        if (number.compareTo(BigInteger.valueOf(3)) < 0)
        {
            return BigInteger.ONE;
        } else
        {
            Map<Integer, BigInteger> computedValues = new HashMap<>();
            computedValues.put(1, BigInteger.ONE);
            computedValues.put(2, BigInteger.ONE);

            BigInteger temp = fibonacciBigInteger(n - 1, computedValues);
            BigInteger temp2 = fibonacciBigInteger(n - 2, computedValues);
            return temp.add(temp2);
        }
    }

    private static BigInteger fibonacciBigInteger(int n, Map<Integer, BigInteger> computedValues)
    {
        if (computedValues.containsKey(n))
        {
            return computedValues.get(n);
        } else
        {
            BigInteger number1 = fibonacciBigInteger(n - 1, computedValues);
            BigInteger number2 = fibonacciBigInteger(n - 2, computedValues);

            BigInteger newValue = number1.add(number2);
            computedValues.put(n, newValue);
            return newValue;
        }
    }
}
