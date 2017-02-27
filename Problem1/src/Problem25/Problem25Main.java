package Problem25;

import HelperClasses.Fibonacci;

import java.math.BigInteger;

/**
 * Created by Chris on 31-Jan-17.
 */
public class Problem25Main
{
    public static void test()
    {
        BigInteger number = Fibonacci.fibonacciBigInteger(100);
        System.out.println(number.toString());
    }

    public long countDigits(BigInteger number)
    {
        long digits = 1;
        BigInteger quotient = number.divide(BigInteger.TEN);
        while (quotient.compareTo(BigInteger.ZERO) > 0)
        {
            digits++;
            quotient = quotient.divide(BigInteger.TEN);
        }
        return digits;
    }

    public static void solution()
    {
        long start = System.nanoTime();
        Problem25Main obj = new Problem25Main();
        int index = 1;
        BigInteger number = Fibonacci.fibonacciBigInteger(index);
        long digits = obj.countDigits(number);
        while (digits < 1000)
        {
            index++;
            number = Fibonacci.fibonacciBigInteger(index);
            digits = obj.countDigits(number);
        }
        long time = System.nanoTime() - start;
        System.out.printf("Index %d found in %.3f s\n", index, time / 1000000000.0);
    }

    public static void solution2()
    {
        long start = System.nanoTime();
        int index = 1;
        BigInteger number = Fibonacci.fibonacciBigInteger(index);
        while (number.toString().length() < 1000)
        {
            index++;
            number = Fibonacci.fibonacciBigInteger(index);
        }
        long time = System.nanoTime() - start;
        System.out.printf("Index %d found in %.3f s\n", index, time / 1000000000.0);
    }

    public static void main(String[] args)
    {
        solution2();
        solution();
    }
}
