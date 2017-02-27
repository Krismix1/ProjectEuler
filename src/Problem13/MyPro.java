package Problem13;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Not mine
class MyPro
{
    public static void main(String[] args) throws FileNotFoundException
    {
        ArrayList<String> list = new ArrayList<>();
        Scanner scanner = new Scanner(new File("Problem13.txt"));
        while (scanner.hasNext())
        {
            list.add(scanner.nextLine());
        }
        scanner.close();

        String strWork = "0";
        int lenStr = list.get(0).length();
        for (int i = 0; i < lenStr; i++)
        {
            int sum = 0;
            for (String s : list)
            {
                sum += Integer.parseInt(s.substring(lenStr - i - 1, lenStr - i));
            }
            if (i == 0)
            {
                strWork = sum + "";
            } else
            {
                String tmp;
                tmp = strWork.substring(strWork.length() - i);
                sum = sum + Integer.parseInt(strWork.substring(0, strWork.length() - i));
                strWork = sum + tmp;
            }
        }
        System.out.println("All number   " + strWork);
        System.out.println("10 first num " + strWork.substring(0, 10));
    }
}