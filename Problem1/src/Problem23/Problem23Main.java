package Problem23;

import Problem21.Problem21;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Cristian Betivu on 16.01.2017.
 * Project Euler Problem 23
 */
public class Problem23Main
{
    // This is the limit till where there exist numbers that can't
    // be written as a sum of 2 abundant numbers
    public static final int LIMIT = 28123;

    public boolean isAbundantNumber(int number)
    {
        Problem21 findDivisors = new Problem21();
        List<Integer> divisors = findDivisors.getProperDivisors(number);
        int sum = findDivisors.sumOfElements(divisors);
        return sum > number;
    }

    // Finds all the abundant numbers till LIMIT
    public List<Integer> findAbundantNumbers()
    {
        List<Integer> abundantNumbers = new ArrayList<>();

        for (int i = 1; i <= LIMIT; i++)
        {
            if (isAbundantNumber(i))
            {
                abundantNumbers.add(i);
            }
        }
        return abundantNumbers;
    }

    // Calculates all possible sums by combining 2 numbers
    public Set<Integer> sumsOfAbundantNumbers()
    {
        Set<Integer> sums = new HashSet<>();
        List<Integer> abundantNumbers = findAbundantNumbers();
        for (int i = 0; i < abundantNumbers.size(); i++)
        {
            int a = abundantNumbers.get(i);
            for (int j = i; j < abundantNumbers.size(); j++)
            {
                int b = abundantNumbers.get(j);
                sums.add(a + b);
            }
        }
        return sums;
    }

    public static void solution()
    {
        long sum = 0;
        Problem23Main obj = new Problem23Main();
        Set<Integer> sums = obj.sumsOfAbundantNumbers();
        for (int i = 1; i <= LIMIT; i++)
        {
            if (!sums.contains(i))
            {
                sum += i;
            }
        }
        System.out.println("The sum is " + sum);
    }

    public static void main(String[] args)
    {
        solution();
    }
}
