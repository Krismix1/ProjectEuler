package Problem29;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chris on 05-Feb-17.
 */
public class Problem29Main
{
    public static void solution()
    {
        long start = System.nanoTime();
        Set<BigInteger> sequence = new HashSet<>();
        for (int a = 2; a <= 100; a++)
        {
            for (int b = 2; b <= 100; b++)
            {
                BigInteger number = BigInteger.valueOf(a);
                sequence.add(number.pow(b));
            }
        }
        System.out.println(sequence.size());
        long time = System.nanoTime() - start;
        System.out.println("Solution found in " + time / 1000000000.0 + " sec");
    }

    public static void main(String[] args)
    {
        solution();
    }
}
