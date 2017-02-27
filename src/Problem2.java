// This may be a small improvement.  The Fibonacci series is:
// 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610...
// Now, replacing an odd number with O and an even with E, we get:
// O, O, E, O, O, E, O, O, E, O, O, E, O, O, E...
// And so each third number is even.  We don't need to calculate the odd numbers.  Starting from
// an two odd terms x, y, the series is:
// x, y, x + y, x + 2y, 2x + 3y, 3x + 5y
// x = x + 2 * y;
// y = 2 * x + 3 * y;

// using the golden ratio for this

import HelperClasses.Fibonacci;

public class Problem2
{


    public static int solution()
    {
        int fib;
        int sum = 0;
        int i = 2;
        do
        {
            fib = (int)Fibonacci.fibonacci(i);
            if (fib % 2 == 0)
            {
                sum += fib;
            }
            i++;
        } while (fib <= 4000000);
        return sum;
    }

    public static void main(String[] args)
    {
        System.out.println(solution());
    }

}
