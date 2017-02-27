package Problem22;

import java.util.Collections;
import java.util.List;

/**
 * Created by Cat Home on 14.01.2017.
 */
public class Main
{
    public static void solution()
    {
        Problem22Alphabet obj = new Problem22Alphabet();
        List<String> names = obj.readNames();
        Collections.sort(names);
        long sum = 0;
        for (int i = 0; i < names.size(); i++)
        {
            int value = obj.valueOf(names.get(i));
            sum += obj.getScore(value, i);
        }
        System.out.println(sum);
    }

    public static void main(String[] args)
    {
        solution();
    }
}
