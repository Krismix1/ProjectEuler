package HelperClasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PrimeNumber
{
    private static List<Integer> primeNumbers = new ArrayList<>();
    private static int lastNumberChecked = 0;

    public static boolean isPrime(int number)
    {
        if (number > lastNumberChecked)
        {
            generatePrimeSequence(number);
        }
        return primeNumbers.contains(number);
    }

    // Returns a list of all prime numbers up to given max
    public static List<Integer> getPrimeNumberList(int number)
    {
        if (number > lastNumberChecked)
        {
            generatePrimeSequence(number);
        }
        List<Integer> toReturn = new LinkedList<>();
        Iterator<Integer> iter = primeNumbers.iterator();
        int numberIteration = 0;
        while (iter.hasNext() && numberIteration < number)
        {
            numberIteration = iter.next();
            toReturn.add(numberIteration);
        }
        return toReturn;
    }

    public List<Integer> createPrimes(int max)
    {
        int[] numbers = new int[max];
        List<Integer> primes = new ArrayList<>();
        for (int i = 1; i < 1000; i++)
        {
            numbers[i] = i;
        }
        for (int i = 2; i < 1000; i++)
        {
            if (numbers[i] != 0)
            {
                for (int j = numbers[i] * 2; j < 1000; j += numbers[i])
                {
                    numbers[j] = 0;
                }
            }
        }
        for (int i = 0; i < 1000; i++)
        {
            if (numbers[i] != 0)
            {
                primes.add(numbers[i]);
            }
        }
        return primes;
    }

    private static void generatePrimeSequence(int max)
    {
        // Generates a list of all prime numbers up to given max
        // using the sieve of Eratosthenes algorithm.

        if (max > lastNumberChecked)
        {
            // There aren't prime numbers smaller than 2
            if (max >= 2)
            {
                List<Integer> allNumbers = generateAllNumbers(max);
                while (!allNumbers.isEmpty())
                {
                    // remove a prime number from the front of the list
                    int front = allNumbers.get(0);

                    // if the first element of the numbers list is greater than the square root of the maximum,
                    // then any number this large that remains in the list cannot have any multiples
                    // remaining in the list
                    if (front <= Math.sqrt(max))
                    {
                        primeNumbers.add(front);
                        allNumbers.remove(0);

                        // remove all multiples of the prime number
                        Iterator<Integer> itr = allNumbers.iterator();
                        while (itr.hasNext())
                        {
                            int current = itr.next();
                            if (current % front == 0)
                            {
                                itr.remove();
                            }
                        }
                    } else
                    { // So we just add all the remaining numbers and empty the list
                        primeNumbers.addAll(allNumbers);
                        allNumbers.clear();
                    }
                }
            }
            lastNumberChecked = max;
        }
    }

    private static List<Integer> generateAllNumbers(int max)
    {
        List<Integer> allNumbers = new ArrayList<>();
        allNumbers.add(2);
        // TODO: 24-Dec-16 change starting point
        for (int i = 3; i <= max; i += 2)
        {
            allNumbers.add(i);
        }
        return allNumbers;
    }
}
