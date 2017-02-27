import java.math.BigInteger;

public class Problem20
{
    public static void main(String[] args)
    {
        BigInteger number = BigInteger.ONE;
        for (int i = 1; i < 100; i++)
        {
            number = number.multiply(BigInteger.valueOf(i));
        }
        int sum = 0;
        String num = number.toString();
        for (int i = 0; i < num.length(); i++)
        {
            sum += Integer.parseInt(num.charAt(i) + "");
        }
        System.out.println(sum);
    }
}
