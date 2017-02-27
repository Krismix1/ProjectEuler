public class Problem5
{
    public static int smallestMultiple(int min, int max)
    {
        int smallest = max;
        while (!isDivisible(min, max, smallest))
        {
            smallest++;
        }
        return smallest;
    }

    public static boolean isDivisible(int min, int max, int number)
    {
        boolean div = true;
        for (int i = min; i <= max; i++)
        {
            div = div && (number % i == 0);
        }
        return div;
    }

    public static void main(String[] args)
    {
        System.out.println(smallestMultiple(1,20));
    }
}
