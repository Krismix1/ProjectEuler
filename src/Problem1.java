// Find the sum of all the multiples of 3 or 5 below 1000.

public class Problem1
{
    // My solution
    public static int multiples(int max)
    {
        int sum = 0;
        for(int i = 0; i < max; i++)
        {
            if (i % 3 == 0 || i % 5 == 0)
            {
                sum += i;
            }
        }
        return sum;
    }

    // Faster solution
    public static int sumDivisibleBy(int n,int number)
    {
        int p = number / n;
        return n * (p * (p+1) / 2);
    }

    public static void main(String[] args)
    {
        // Not working for bigger numbers?
        System.out.println(sumDivisibleBy(3,999) + sumDivisibleBy(5,999) - sumDivisibleBy(15, 999));
    }
}
