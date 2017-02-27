import HelperClasses.PrimeNumber;

import java.util.List;

public class Problem10
{
    public static void main(String[] args)
    {
        long sum = 0L;
        List<Integer> primeNumbers = PrimeNumber.getPrimeNumberList(2000000);
        for (Integer primeNumber : primeNumbers)
        {
            sum += primeNumber;
        }
        System.out.println(sum);
    }
}
