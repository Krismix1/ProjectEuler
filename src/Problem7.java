public class Problem7
{
    public static boolean isPrime(int number)
    {
        for (int i = 2; i < number / 2; i++)
        {
            if (number % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        int counter = 0;
        int prime = 0;
        for (int i = 2; counter <= 10001; i++)
        {
            if (isPrime(i))
            {
                counter++;
                prime = i;
            }
        }
        System.out.println(prime);
    }
}
