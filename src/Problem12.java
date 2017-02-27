import java.util.LinkedList;
import java.util.List;

public class Problem12
{
    private static int getTriangleNumber(int n)
    {
        return (1 + n) * n / 2;
    }

    private static int getNumberOfDivisors(List<Integer> primeDivisors)
    {
        System.out.println(primeDivisors);
        int numberOfDivisors = 1;
        if (primeDivisors.size() > 0)
        {
            for(int i = 0; i < primeDivisors.size(); i = primeDivisors.lastIndexOf(primeDivisors.get(i)) + 1)
            {
                int numberOfAppearance = countAppearances(primeDivisors, primeDivisors.get(i));
                numberOfDivisors *= (numberOfAppearance + 1);
            }
            return numberOfDivisors;
        } else
        {
            return 0;
        }
    }

    private static int countAppearances(List<Integer> list, int number)
    {
        int counter = 0;
        for (Integer integer : list)
        {
            if (integer == number)
            {
                counter++;
            }
        }
        return counter;
    }

    public static List<Integer> primeFactors(int n)
    {
        List<Integer> divisors = new LinkedList<>();
        // Add the number of 2s that divide n
        while (n%2==0)
        {
            divisors.add(2);
            n /= 2;
        }

        // n must be odd at this point. So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i*i <= n; i+= 2)
        {
            // While i divides n, add i and divide n
            while (n%i == 0)
            {
                divisors.add(i);
                n /= i;
            }
        }

        // This condition is to handle the case when
        // n is a prime number greater than 2
        if (n > 2)
        {
            divisors.add(n);
        }
        return divisors;
    }

    public static void main(String[] args)
    {
        long starttime=System.nanoTime();
        int divisors = 0;
        int number = 0;
        for (int i = 1; divisors <= 500; i++)
        {
            number = getTriangleNumber(i);
            List<Integer> temp = primeFactors(number);
            divisors = getNumberOfDivisors(temp);
        }
        System.out.println(number);
        System.out.println("took " + (System.nanoTime()-starttime)*0.000000001 + " secs");
    }
}
