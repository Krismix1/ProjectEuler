public class Problem9
{
    public static boolean isPytagorianTriplete(int a, int b, int c)
    {
        return a*a + b*b == c*c;
    }

    public static void main(String[] args)
    {
        for (int i = 1; i <= 1000; i++)
        {
            for (int j = 1; j <= 1000; j++)
            {
                for (int k = 1; k <= 1000; k++)
                {
                    if (i < j)
                    {
                        if (isPytagorianTriplete(i, j, k))
                        {
                            if( i + j + k == 1000)
                            {
                                System.out.println(i*j*k);
                            }
                        }
                    }
                }
            }
        }
    }
}
