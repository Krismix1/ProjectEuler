package Problem21;

/**
 * Created by Cat Home on 13.01.2017.
 */
public class PDFSolution
{
    public static void main(String[] args)
    {
        int sum = 0;
        for( int a = 2; a <= 9999; a++)
        {
            int b = PDFSolutionNr2.sumOfProperDivisors(a);
            if (b > a)
            {
                if (PDFSolutionNr2.sumOfProperDivisors(b) == a)
                {
                    sum += a + b;
                }
            }
        }
        System.out.println("Sum = " + sum);
    }

    public static int sumOfProperDivisors(int n)
    {
        if (n == 1)
        {
            return 0;
        }
        int sum;
        int r = (int) Math.sqrt(n);
        if (r * r == n)
        {
            sum = 1 + r;
            r = r - 1;
        }else
        {
            sum = 1;
        }
        int f;
        int step;
        if (n % 2 == 1)
        {
            f = 3;
            step = 2;
        }else
        {
            f = 2;
            step = 1;
        }
        while (f <= r)
        {
            if (n % f == 0)
            {
                sum += f + n / f;
            }
            f += step;
        }
        return sum;
    }
}
