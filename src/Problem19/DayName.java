package Problem19;

/**
 * Created by Cat Home on 13.01.2017.
 */

import HelperClasses.Date;

import java.util.Scanner;

public class DayName
{
    public String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    public int getAbsoluteDay(int date, int month, int year)
    {
        int noOfDays = date;
        for (int i = month - 1; i > 0; i--)
        {
            if (i == 2)
            {
                noOfDays += 28;
            } else if (i == 4 || i == 6 || i == 9 || i == 11)
            {
                noOfDays += 30;
            } else
            {
                noOfDays += 31;
            }
        }
        if (leapYear(year) && month >= 3)
        {
            noOfDays++;
        }
        return noOfDays;
    }

    public boolean leapYear(int year)
    {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
        {
            return true;
        } else return false;
    }

    public int getFirstMonday(int year)
    {
        int monday = 1;
        for (int i = 1601; i <= year; i++)
        {
            if (leapYear(i - 1))
            {
                if (i != 1601)
                {
                    if (monday == 1)
                    {
                        monday = 6;
                    } else if (monday == 2)
                    {
                        monday = 7;
                    } else monday -= 2;
                }
            } else
            {
                if (monday == 1)
                {
                    monday = 7;
                } else monday--;
            }
        }
        if (monday <= 0)
        {
            throw new IllegalArgumentException();
        } else return monday;
    }

    public void printDayName(int dayOfWeek)
    {
        System.out.println(getDayName(dayOfWeek));
    }

    public String getDayName(int dayOfWeek)
    {
        if (dayOfWeek < 7 && dayOfWeek >= 0)
        {
            return weekDays[dayOfWeek];
        } else
        {
            return "Something went wrong.";
        }
    }

    public String calculateDayName(Date date)
    {
        int dayOfWeek = Math.abs(getAbsoluteDay(date.getDay(), date.getMonth(), date.getYear()) - getFirstMonday(date.getYear())) % 7;
        return weekDays[dayOfWeek];
    }

    public static void main(String[] args)
    {
        DayName obj = new DayName();
        Scanner console = new Scanner(System.in);
        String answer = "";
        do
        {
            String text = "Enter the day: -month: -year: ";
            int[] date = new int[3]; // 0 - day, 1 - month, 2 - year
            int i = 0;
            for (String retval : text.split("-"))
            {
                System.out.print(retval);
                date[i] = console.nextInt();
                i++;
            }
            System.out.print("The day falls on ");
            obj.printDayName(Math.abs(obj.getAbsoluteDay(date[0], date[1], date[2]) - obj.getFirstMonday(date[2])) % 7);
            System.out.print("Do you want to enter a new date? ");
            answer = console.next();
        } while (answer.equalsIgnoreCase("yes"));
    }
}