package Problem21;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cat Home on 13.01.2017.
 */
public class Problem21
{
    public int sumOfElements(List<Integer> list)
    {
        int sum = 0;
        for (Integer i : list)
        {
            sum += i;
        }
        return sum;
    }

    // Finds the proper divisors of n (numbers less than n which divide evenly into n)
    // I.e all divisors except the number itself
    public List<Integer> getProperDivisors(int number)
    {
        List<Integer> properDivisors = getDivisors(number);
        properDivisors.remove((Integer) number);
        return properDivisors;
    }

    public List<Integer> getDivisors(int number)
    {
        List<Integer> divisors = new ArrayList<>();
        if (number < 1)
        {
            return new ArrayList<>();
        }
        divisors.add(1);
        // Checks only to half of the number because dividing to any number bigger than
        // the half will give us only decimals numbers and 1.
        for (int i = 2; i <= number / 2; i++)
        {
            if (number % i == 0)
            {
                divisors.add(i);
            }
        }
        divisors.add(number);
        return divisors;
    }

    public List<Integer> amicableNumbers(int upperLimit)
    {
        List<Integer> amicableNumbers = new ArrayList<>();
        for (int i = 2; i < upperLimit; i++)
        {
            List<Integer> divisors = getProperDivisors(i);
            int a = sumOfElements(divisors);
            if (a != i)
            {
                divisors = getProperDivisors(a);
                int b = sumOfElements(divisors);
                if (b == i && a > b) // we compare if bigger so that we don't add twice the same pair
                {
                    amicableNumbers.add(i);
                    amicableNumbers.add(a);
                    //amicableNumbers.add(a + i); // we can add the sum right away and have less numbers to add later
                    //System.out.printf("i = %d, a = %d\n", i, a);
                }
            }
        }
        return amicableNumbers;
    }

    public static void solution()
    {
        Problem21 obj = new Problem21();
        List<Integer> amicableNumbers = obj.amicableNumbers(10000);
        int sum = obj.sumOfElements(amicableNumbers);
        System.out.println("Sum is " + sum);
        //obj.test();
    }

    public void test()
    {
        int i = 220;
        List<Integer> divisors = getProperDivisors(i);
        int a = sumOfElements(divisors);
        if (a != i)
        {
            divisors = getProperDivisors(a);
            int b = sumOfElements(divisors);
            if (b == i)
            {
                System.out.println("works");
            }
            System.out.println("i = " + i);
            System.out.println("a = " + a);
            System.out.println("b = " + b);

        }
    }

    public static void main(String[] args)
    {
        solution();
    }
}
