package Problem15;

import HelperClasses.MyConsole;

import java.math.BigInteger;

/**
 * Created by Chris on 23.01.2017.
 * The answer is achieved by using central binomial coefficients
 * The number of paths are the central binomial coefficients
 * 'central' meaning they fall along the center line of Pascal’s triangle.
 * The numbers are given my the formula (2*n)! / (n!^2)
 * The solution uses BigInteger because the numbers get very big
 * And can not be saved in long variables
 */

/**
 * for a generalized solution of grid size a*b
 * routes=[(a+b)!]/[a!* b!]
 */
public class Problem15V1
{
    public static void solution()
    {
        // First we will read the length
        // Then we calculate the nominator of the fraction
        // Then we calculate the denominator of the fraction
        // The value of the fraction represents the number of paths
        MyConsole console = new MyConsole();
        System.out.println("Enter the length of the square");
        int length = console.readInt();
        BigInteger number = new BigInteger(length + "");
        BigInteger paths;

        BigInteger nominator = factorial(number.multiply(new BigInteger("2")));

        BigInteger denominator = factorial(number);
        denominator = square(denominator);

        paths = nominator.divide(denominator);
        System.out.println("Paths: " + paths.toString());
    }

    public static void main(String[] args)
    {
        solution();
    }

    public static BigInteger factorial(BigInteger number)
    {
        BigInteger decrement = BigInteger.ONE;
        BigInteger result = BigInteger.ONE;
        while (number.signum() > 0)
        {
            result = result.multiply(number);
            number = number.subtract(decrement);
        }
        return result;
    }

    public static BigInteger square(BigInteger number)
    {
        BigInteger result;
        result = number.multiply(number);
        return result;
    }
}
