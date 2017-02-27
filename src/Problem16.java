import java.math.BigInteger;

public class Problem16
{
    public static void main(String[] args)
    {
        BigInteger a = BigInteger.valueOf(1);
		BigInteger b = BigInteger.valueOf(2);

		for(int i = 1; i <= 1000; i++)
		{
			a = a.multiply(b);
		}

		String str = a.toString();

		int digit;
		int total = 0;
		for(int i = 0; i < str.length(); i++)
		{
			digit = str.charAt(i) - '0';
			total += digit;
		}
		System.out.println(total);
    }
}
