public class Problem6
{
    public static int sum(int n)
    {
//        if (n % 2 == 0)
//        {
//            return (n + 1) * n / 2;
//        }
//        return n * (n / 2 + 1);
        return (n + 1) * n / 2;
    }

    public static int sumOfSquares(int max)
    {
        int sum = 0;
        for( int i = 1; i <= max; i++)
        {
            sum += i*i;
        }
        return sum;
    }

    // Using arithmetic progressions
    public static int test(int n)
    {
        // 3 ^ 2 = 1 + 3 + 5 primele 3 numere impare
        return 1 * n + 2 * ( n * (n - 1) / 2);
    }

    public static void main(String[] args)
    {
        int squaredSum = (int)Math.pow( sum(100),2);
        int sumOfSquares = sumOfSquares(100);
        System.out.println(squaredSum - sumOfSquares);
    }
}
