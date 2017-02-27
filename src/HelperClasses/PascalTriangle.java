package HelperClasses;

/**
 * Created by Cat Home on 23.01.2017.
 */
import java.util.Scanner;

public class PascalTriangle
{
    public static int factorial(int i)
    {
        if(i == 0)
        {
            return 1;
        }
        else
        {
            return factorial(i-1)*i;
        }
    }

    public static void printPascalTriangle(int lines)
    {
        for(int n=0;n<=lines;n++)
        {
            for(int i = 0;i<(lines-n)/2;i++)
            {
                System.out.print("    ");
            }
            if(n % 2 == 1)
            {
                System.out.print("  ");
            }
            for(int k=0;k<=n;k++)
            {
                int number = factorial(n)/(factorial(k)*factorial(n-k));
                System.out.printf("%4d",number);
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        System.out.print("Number of lines: ");
        int lines = console.nextInt();
        printPascalTriangle(lines);
    }
}
