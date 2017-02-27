package Problem21;

/**
 * Created by Cat Home on 13.01.2017.
 */
public class PDFSolutionNr2
{
    public static int sumOfDivisors(int n)
    {
        int sum = 1;
        int p = 2;
        while (p * p <= n && n > 1)
        {
            if (n % p == 0)
            {
                int j;
                j = p * p;
                n = n / p;
                while (n % p == 0)
                {
                    j = j * p;
                    n = n / p;
                }
                sum = sum * (j-1);
                sum = sum / (p-1);
            }
            if (p == 2)
            {
                p = 3;
            }else
            {
                p = p +2;
            }
            if (n > 1)
            {
                sum = sum * (n + 1);
            }
        }
        return sum;
    }

    public static int sumOfProperDivisors(int n)
    {
        return sumOfDivisors(n) - n;
    }
}
