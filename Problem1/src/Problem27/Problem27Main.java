package Problem27;

import HelperClasses.PrimeNumber;

import java.util.List;

/**
 * Created by Chris on 08-Feb-17.
 */
public class Problem27Main
{
    static int function(int n, int a, int b)
    {
        return n * n + a * n + b;
    }

    public static void solution()
    {
        long start = System.nanoTime();
        int max = 0;
        int product = 0;
        int aMax = 0;
        int bMax = 0;
        List<Integer> bPrimes = PrimeNumber.getPrimeNumberList(1001);
        for (int a = -999; a < 1000; a += 2)
        {
            for (int b = 0; b < bPrimes.size(); b++)
            {
                for (int j = 0; j <= 1; j++)
                {
                    int n = 0;
                    int aOdd = b % 2 == 0 ? -1 : 0;
                    int sign = j == 0 ? -1 : 1;
                    while (PrimeNumber.isPrime(function(Math.abs(n), a + aOdd, sign * bPrimes.get(b))))
                    {
                        n++;
                    }
                    if (n > max)
                    {
                        max = n;
                        aMax = a;
                        bMax = bPrimes.get(b);
                    }
                }
            }
        }
        product = aMax * bMax;
        System.out.println("product " + product);
        System.out.println("a " + aMax + " b " + bMax);
        long time = System.nanoTime() - start;
        System.out.println("Solution found in " + time / 1000000000.0 + " sec");
    }

    public static void main(String[] args)
    {
        solution();
    }
}
