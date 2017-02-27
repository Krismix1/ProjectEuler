import HelperClasses.PrimeNumber;

import java.util.ArrayList;
import java.util.List;

public class Problem3
{

    public static ArrayList<Integer> getPrimeFactors(int number)
    {
        ArrayList<Integer> factors = new ArrayList<>();
        List<Integer> primeNumbers = PrimeNumber.getPrimeNumberList(number);
        int copy = number;
        for (int i = 0; i < primeNumbers.size(); i++)
        {
            int divisor = primeNumbers.get(i);
            while (copy % divisor == 0)
            {
                copy /= divisor;
                factors.add(divisor);
            }

        }
        return factors;
    }

    public static void main(String[] args)
    {
        /*long number = 600851475143L;
        long copy = number;
        long max = 2L;
        for(long i = 2; i <= copy; i++)
        {
            if (copy % i == 0 && PrimeNumber.isPrime(i))
            {
                max = i;
                copy /= i;
            }
        }
        System.out.println(max);*/
    }
}
