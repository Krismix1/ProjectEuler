package Problem24.AnotherSolutions;

import HelperClasses.Permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Chris on 30-Jan-17.
 */
public class Sol1
{
    private static List<String> list = new ArrayList<>();

    public static void permutation(String str)
    {
        permutation("", str);
    }

    private static void permutation(String prefix, String str)
    {
        int n = str.length();
        if (n == 0)
        {
            list.add(prefix);
        } else
        {
            for (int i = 0; i < n; i++)
            {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }

    public static void solution()
    {
        permutation("0123456789");
        Collections.sort(list);
        System.out.println(list.get(999999));
    }

    public static void main(String[] args)
    {
        long start = System.nanoTime();
        solution();
        long time = System.nanoTime() - start;
        System.out.println("The program took " + time / 1000 / 1000.0 + ".ms");
    }
}
