public class Problem4
{
    public static boolean isPalindrome(int number)
    {
        int reversed = 0;
        int copy = number;
        while( copy != 0)
        {
            reversed = reversed * 10 + (copy % 10);
            copy /= 10;
        }
        return number == reversed;
    }

    public static void biggestPalindrome()
    {
        int max = 0;
        for(int i = 999; i > 1; i--)
        {
            for (int j = 999; j>1; j--)
            {
                if (isPalindrome(j * i) && j*i > max)
                {
                    max = j*i;
                    System.out.printf("max=%d i=%d j=%d\n", max,i,j);
                }
            }
        }
        System.out.println(max);
    }

    public static void main(String[] args)
    {
        biggestPalindrome();
    }
}
