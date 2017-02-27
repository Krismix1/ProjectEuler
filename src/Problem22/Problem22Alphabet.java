package Problem22;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by Chris on 14.01.2017.
 */
public class Problem22Alphabet
{
    Map<Character, Integer> alphabet = new HashMap<>();

    public Problem22Alphabet()
    {
        createAlphabet();
    }

    public List<String> readNames()
    {
        try
        {
            File file = new File("Problem22.txt");
            Scanner input = new Scanner(file);
            List<String> list = new ArrayList<>();
            while (input.hasNextLine())
            {
                String line = input.nextLine();
                String[] names = line.split(",");
                removeQuotes(names);
                list.addAll(Arrays.asList(names));
            }
            return list;
        } catch (FileNotFoundException e)
        {
            System.out.println("Error");
        }
        return null;
    }

    public void removeQuotes(String[] names)
    {
        for (int i = 0; i < names.length; i++)
        {
            String temp = names[i].substring(1, names[i].length() - 1);
            names[i] = temp;
        }
    }

    public int valueOf(String s)
    {
        int value = 0;
        for (int i = 0; i < s.length(); i++)
        {
            value += alphabet.get(s.charAt(i));
        }
        return value;
    }

    public int getScore(int value, int position)
    {
        return value * (position + 1);
    }

    public void createAlphabet()
    {
        int value = 1;
        for (char c = 'A'; c <= 'Z'; c++)
        {
            alphabet.put(c, value);
            value++;
        }
    }
}
