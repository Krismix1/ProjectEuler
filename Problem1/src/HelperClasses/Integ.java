package HelperClasses;

public class Integ
{
    // Maybe use an LinkedList/ArrayList to store the digits
    // Or change so that the units are stored in index 0 and use copyOf to increase the size of array when needed
    private int[] array = new int[50];
    public static int moreDigits = 0;

    // Holds the index of first non-zero digit.
    private int index;

    public Integ(String number)
    {
        this.index = 0;
        readInt(number);
    }


    public static Integ addInts(Integ firstArray, Integ secondArray)
    {
        int firstIndex = firstArray.getIndex();
        int secIndex = secondArray.getIndex();
        String tempArrayString;

        // The first non-zero digit is lefter in the first array
        if (firstIndex <= secIndex)
        {
            tempArrayString = addHelper(firstArray, secondArray);
        } else
        {
            tempArrayString = addHelper(secondArray, firstArray);
        }

        // This would better be changed
        String finalArrayString;
        if (tempArrayString.length() > 50)
        {
            // Keep only the 50 right most digits
            finalArrayString = tempArrayString.substring(tempArrayString.length() - 50);
            // Doesn't really count
            moreDigits++;
        }else finalArrayString = tempArrayString;
        return new Integ(finalArrayString);
    }

    // temp1 will be longer than temp2
    private static String addHelper(Integ temp1, Integ temp2)
    {
        String finalArrayString = "";
        int sum = 0;
        int stopIndex = temp1.getIndex();
        for (int i = 49; i >= stopIndex; i--)
        {
            sum = temp1.array[i] + temp2.array[i];
            if (sum >= 10)
            {
                finalArrayString = sum % 10 + finalArrayString;
                if ( i != stopIndex)
                {
                    temp1.array[i - 1]++;
                }
            } else
            {
                finalArrayString = sum + finalArrayString;
            }
        }
        finalArrayString = sum / 10 + finalArrayString;
        return finalArrayString;
    }

    private void readInt(String number)
    {
        if (number.length() > 0)
        {
            // Finds the first non-zero digit
            // if parameter passed has the following format: 00001
            // i.e. has zeroes in front
            int i = 0;
            while (i < number.length() && number.charAt(i) == '0')
            {
                i++;
            }
            int length = number.length() - i; // How many digits the number has
            // We have found at least 1 non-zero digit
            // Maybe the units
            if ( length > 0)
            {
                index = array.length - length;
                int digit = index;
                for (int j = i; j < number.length(); j++)
                {
                    this.array[digit] = Integer.parseInt(number.charAt(j) + "");
                    digit++;
                }
            } else
                // Numbers is 0
            {
                index = array.length - 1;
            }
        }
    }

    public void displayArray()
    {
        for (int i = index; i < array.length; i++)
        {
            System.out.print(array[i]);
        }
    }

    public void displayAllArray()
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public int getIndex()
    {
        return this.index;
    }

    public String toString()
    {
        String temp = "";
        for (int i = index; i < array.length; i++)
        {
            temp += array[i];
        }
        return temp;
    }
}
