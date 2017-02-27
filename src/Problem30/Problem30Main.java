package Problem30;

/**
 * Created by Chris on 05-Feb-17.
 */
public class Problem30Main
{
    public static void solution()
    {
        long start = System.nanoTime();
        Problem30Main obj = new Problem30Main();
        int sum = 0;
        int startingNumber = 10;
        int sumOfDigits = 0;
        while (true)
        {
            sumOfDigits = obj.sumOfPowersOfDigits(startingNumber, 5);
            if (startingNumber == sumOfDigits)
            {
                System.out.println("number: " + startingNumber);
                sum += startingNumber;
                System.out.println("sum: " + sum);
            }
            startingNumber++;
        }// sum is 443839
        //System.out.println("Sum is " + sum);
        //long time = System.nanoTime() - start;
        //System.out.println("Solution found in " + time / 1000000000.0);
    }

    public static void main(String[] args)
    {
        solution();
    }

    public int sumOfPowersOfDigits(int number, int power)
    {
        int sum = 0;
        while (number > 0)
        {
            int digit = number % 10;
            number = number / 10;
            sum += (int) Math.pow(digit, power);
        }
        return sum;
    }
}
