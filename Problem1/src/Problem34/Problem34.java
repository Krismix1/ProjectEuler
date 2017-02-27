package Problem34;

import HelperClasses.Mathf;

/**
 * Created by Chris on 27-Feb-17.
 */
public class Problem34
{
    // A factorion is an integer which is equal to the sum of factorials of its digits. There are exactly four such numbers: 1, 2, 145, 40585
    // The factorion of an n-digit number cannot exceed n*9!.
    private int[] factorials = new int[10];

    public void createFactorials()
    {
        for (int i = 0; i < factorials.length; i++)
        {
            factorials[i] = Mathf.factorial(i);
        }
    }

    public int sumOfDigits(int number)
    {
        int sum = 0;
        while (number > 0)
        {
            sum += factorials[number % 10];
            number /= 10;
        }
        return sum;
    }

    public boolean isMagicNumber(int number)
    {
        return number == sumOfDigits(number);
    }

    public boolean isCurious(int i)
    {
        int sum = 0;
        int j = i;
        while (j > 0)
        {
            sum += factorials[j % 10];
            j = j / 10;
            if (sum > i) return false;
        }
        return (sum == i);
    }

    private static void solution()
    {
        long start = System.nanoTime();
        Problem34 obj = new Problem34();
        obj.createFactorials();
        int number = 3;
        int sum = 0;
        while (number < 10000000) // 9999999 is upper bound because 7 * 9! is less
        {
            if (obj.isMagicNumber(number))
            {
                sum += number;
                System.out.println(sum + " number " + number);
            }
            number++;
        }
        long time = System.nanoTime() - start;
        System.out.println("Found solution in " + time / 1000000000.0);
    }

    public static void main(String[] args)
    {
        solution();
    }
}
