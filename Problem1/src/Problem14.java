import java.util.LinkedList;
import java.util.List;

public class Problem14
{
    public static long nextNumber(long n)
    {
        if (n % 2 == 0)
        {
            return n/2;
        }else return n*3 + 1; // the result of odd * 3 + 1 is always even so you know you can divide it by 2.
    }

    public static List<Long> generateSequence(long start)
    {
        List<Long> sequence = new LinkedList<>();
        while (start != 1)
        {
            sequence.add(start);
            start = nextNumber(start);
        }
        if (start == 1)
        {
            sequence.add(start);
        }
        return sequence;
    }

    public static void main(String[] args)
    {
        int longest = 0;
        int number = -1;
        for (int i = 1; i <= 999999; i+=1)
        {
            List<Long> sequence = generateSequence(i);
            if (sequence.size() > longest)
            {
                longest = sequence.size();
                number = i;
                System.out.println("In loop number = " + number);
            }
        }
        System.out.println(number);
    }
}
