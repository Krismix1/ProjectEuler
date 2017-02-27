import java.io.File;
import java.util.Scanner;

public class Problem8
{
    public static int largeProduct(String number)
    {
        int product = 0;
        int counter = 0;
        int index = 0;
        while (counter < 4)
        {
            for (int i = index; i < number.length() - 3 ; i++)
            {
                //System.out.println(i);
                int a = Integer.parseInt(number.charAt(i)+"");
                int b = Integer.parseInt(number.charAt(i+1)+"");
                int c = Integer.parseInt(number.charAt(i+2)+"");
                int d = Integer.parseInt(number.charAt(i+3)+"");
                if( a * b * c * d > product)
                {
                    product = a * b * c * d;
                    System.out.printf("%d=%d*%d*%d*%d\n",product,a,b,c,d);
                    counter++;
                }
                index = i;
            }
        }
        return product;
    }

    public static long largestProduct(String number, int length)
    {
        long largestProduct = 0;
        int index = 0;
        while (index + length < number.length())
        {
            long product = 1;
            for (int i = index; i < length + index; i++)
            {
                product *= Integer.parseInt(number.charAt(i)+"");
            }

            if (product > largestProduct)
            {
                largestProduct = product;
            }
            index++;
        }

        return largestProduct;
    }

    public static void main(String[] args)
    {
        try
        {
            File f = new File("number.txt");
            Scanner input = new Scanner(f);
            System.out.println(largestProduct(input.next(), 13));
            input.close();

        } catch (Exception e)
        {
            System.out.println("Error");
        }
    }
}
