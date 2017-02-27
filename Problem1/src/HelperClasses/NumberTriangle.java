package HelperClasses;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Chris on 29-Dec-16.
 */
public class NumberTriangle
{
    private List<String> triangleAsString;
    private int[][] triangle;
    private int position;

    /**
     * Creates and instance and initiates the triangle
     */
    public NumberTriangle(File file)
    {
        triangleAsString = readTriangleFromFile(file);
        //position = 0;
        setTriangle();
    }


    public int calculateSum()
    {
        int[] previous = null;
        for (int i = 0; i < triangle.length - 1; i++)
        {
            int[] last = triangle[i];
            previous = findMaximumsOnLine(triangle[i + 1], last);
        }
        return previous[0];
    }

    private int[] findMaximumsOnLine(int[] previous, int[] last)
    {
        for (int i = 0; i < previous.length; i++)
        {
            previous[i] = previous[i] + Math.max(last[i], last[i + 1]);
        }
        return previous;
    }

    private List<String> readTriangleFromFile(File file)
    {
        List<String> toReturn = new LinkedList<>();
        try
        {
            Scanner input = new Scanner(file);
            while (input.hasNextLine())
            {
                toReturn.add(0, input.nextLine());
            }

        } catch (Exception e)
        {
            System.out.println("Error");
        }
        return toReturn;
    }

    private int[] convertLineToNumbers(String line)
    {
        String[] numbers = line.split(" ");
        int[] toReturn = new int[numbers.length];
        int index = 0;
        for (String s : numbers)
        {
            toReturn[index] = Integer.parseInt(s);
            index++;
        }
        return toReturn;
    }

    private void setTriangle()
    {
        triangle = new int[triangleAsString.size()][];
        int index = 0;
        for (String s : triangleAsString)
        {
            triangle[index] = convertLineToNumbers(s);
            index++;
        }
    }

    public int calculateSumDebug()
    {
        int sum = 0;
        for (String line : triangleAsString)
        {
            int[] temp = convertLineToNumbers(line);
            sum += getBiggestNumberFromTriplet(temp);
        }
        return sum;
    }

    public int getBiggestNumberFromTriplet(int[] numbers)
    {
        int max;
        if (numbers.length == 1)
        {
            max = numbers[0];
            return max;
        } else
        {
            {
                max = numbers[position];
                if (max < numbers[position + 1])
                {
                    position++;
                    max = numbers[position];
                }
            }
        }
        return max;
    }
}
