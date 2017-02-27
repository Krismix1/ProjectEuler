package HelperClasses;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cristian Betivu on 16.01.2017.
 */
public class Permutation
{

    private String str;
    private int numberOfPermutations;
    private List<String> list = new ArrayList<>();

    public Permutation()
    {

    }

    public Permutation(String str)
    {
        this.str = str;
        numberOfPermutations = Mathf.factorial(str.length());
    }

    public void swapDigits(int index1, int index2)
    {
        if (index1 != index2)
        {
            // Swap the numbers so that we can use replaceFirst later
            if (index1 > index2)
            {
                int temp = index2;
                index2 = index1;
                index1 = temp;
            }
            char c1 = str.charAt(index1);
            char c2 = str.charAt(index2);
            str = str.replace(c2, c1);
            // Because char at index1 is the same as char at index2 and index1 < index2
            // Change the first appearance of the digit
            str = str.replaceFirst(c1 + "", c2 + "");
        }
    }

    public void permutation()
    {
        permutation("", str);
    }


    private void permutation(String prefix, String str)
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

    public String getCharacters()
    {
        return str;
    }

    public void setCharacters(String str)
    {
        this.str = str;
    }

    public int getNumberOfPermutations()
    {
        return numberOfPermutations;
    }

    public List<String> getPermutationList()
    {
        return this.list;
    }

    public String toString()
    {
        return this.list.toString();
    }
}
