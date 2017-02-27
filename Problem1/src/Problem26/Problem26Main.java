package Problem26;

import java.math.BigDecimal;

/**
 * Created by Chris on 01-Feb-17.
 */
public class Problem26Main
{
    public static void main(String[] args)
    {
        //solution();
        test();
    }

    public static void solution()
    {
        int repeatingValues = 0;
        int index = 0;
        Problem26Main obj = new Problem26Main();
        for (int i = 2; i < 1000; i++)
        {
            BigDecimal d = BigDecimal.ONE.divide(BigDecimal.valueOf(i), 50, BigDecimal.ROUND_DOWN);
            String decimals = d.toString().substring(2);
            int temp = obj.countRepeatingDecimals(decimals);
            if (temp > repeatingValues)
            {
                repeatingValues = temp;
                index = i;
            }
            System.out.println(" is the cycle in number " + d.toString() + " with " + temp + " decimals, index " + i);
        }
        System.out.println("Longest cycle " + repeatingValues + " decimals, found at " + index);
    }

    public static void test()
    {
        Problem26Main obj = new Problem26Main();
        System.out.println(obj.test("500000000000"));
    }

    public int countRepeatingDecimals(String number)
    {
        int repeatingDecimals;
        int offset = 0;
        String temp = "";
        String repeatingCycle = number.charAt(number.length() - 1) + "";
        for (int i = number.length() - 2; i >= 0; i--)
        {
            int length = number.length();
            if (number.charAt(i) != number.charAt(length - 1 - offset))
            {
                repeatingCycle = number.charAt(i) + temp + repeatingCycle;
                temp = "";
            } else
            {
                offset++;
                temp = number.charAt(i) + temp;
            }
        }
        repeatingDecimals = repeatingCycle.length();
        //System.out.print(repeatingCycle);
        return repeatingDecimals;
    }

    public int testOld(String number)
    {
        int length = number.length();
        String repeatingCycle = number.charAt(length - 1) + "";
        number = number.substring(0, length - 1);
        int count = 0;
        while (number.contains(repeatingCycle))
        {
            if (repeatingCycle.equals("0000"))
            {
                return 0;
            }
            count++;
            length = number.length();
            repeatingCycle = number.charAt(length - 1) + "";
            number = number.substring(0, length - 1);
        }
        return count - 1;
    }

    public int test(String number)
    {
        int length = number.length();
        String repeatingCycle = number.charAt(length - 1) + "";
        int counted = 0;
        for (int i = 0; i < length - repeatingCycle.length(); i++)
        {

        }
        return -1;
    }
}
