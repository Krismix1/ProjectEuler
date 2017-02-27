package Problem13;

import HelperClasses.Integ;

import java.io.File;
import java.math.BigInteger;
import java.util.Scanner;

// Since the required answer to this problem only requires the first 10 digits of the sum,
// there is absolutely no need to add more than the first 11 digits of each of the 100 numbers,
// yielding a 13-digit number. Adding the 12th++ digits could never affect more than the 11th digit of the sum

public class Main
{
    public static Integ addNumbers(String number1, String number2)
    {
        Integ first = new Integ(number1);
        Integ second = new Integ(number2);
        return Integ.addInts(first, second);
    }

    public static void main(String[] args)
    {
        try
        {
            Integ finalNumber = new Integ("0");
            Scanner input = new Scanner(new File("Problem13.txt"));
            if (input.hasNextLine())
            {
                finalNumber = new Integ(input.nextLine());
            }
            while (input.hasNextLine())
            {
                String number = input.nextLine();
                System.out.println("Final number: " + finalNumber.moreDigits + finalNumber.toString());
                System.out.println("Number: " + number);
                System.out.println();
                finalNumber = addNumbers(finalNumber.toString(), number);
            }
            System.out.println(finalNumber.moreDigits + finalNumber.toString());
        } catch (Exception e)
        {
            System.out.println("Error");
        }
        // We have big integer :O
        String data[] = new String[100];
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < data.length; i++)
        {
            BigInteger b = new BigInteger(data[i]);
            sum = sum.add(b);
        }
    }
}
