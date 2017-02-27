package HelperClasses;

/**
 * Created by Cat Home on 12.01.2017.
 */
import java.util.Calendar;

public class Date implements Comparable<Date>
{
    public static final Date TODAY = new Date(Calendar.getInstance().get(5), Calendar.getInstance().get(2) + 1, Calendar.getInstance().get(1));

    private final int NUMBERS_OF_MONTHS_IN_YEAR = 12;

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year)
    {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    public Date(String date)
    {
        String[] temp = date.split("\\.");
        setYear(Integer.parseInt(temp[2]));
        setMonth(Integer.parseInt(temp[1]));
        setDay(Integer.parseInt(temp[0]));
    }

    public void setDay(int day)
    {
        if (day >= 1)
        {
            if (month == 2 && isLeapYear())
            {
                if (day > 29)
                {
                    throw new IllegalArgumentException("February can not have more than 29 days in a leap year");
                }
            } else if (month == 2 && !isLeapYear())
            {
                if (day > 29)
                {
                    throw new IllegalArgumentException("February can not have more than 28 days in a non-leap year");
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11)
            {
                if (day > 30)
                {
                    throw new IllegalArgumentException("More than 30 days in a month");
                } else if (day > 31)
                {
                    throw new IllegalArgumentException("More than 31 days in a month");
                }
            }
        } else
        {
            throw new IllegalArgumentException("Day should be greater or equal to 1");
        }
        this.day = day;
    }

    public void setMonth(int month)
    {
        if (month <= 0 || month > NUMBERS_OF_MONTHS_IN_YEAR)
        {
            throw new IllegalArgumentException("Wrong number of month");
        } else this.month = month;
    }

    public void setYear(int year)
    {
        if (year <= 0)
        {
            throw new IllegalArgumentException("Wrong year.");
        } else this.year = year;
    }

    // Moves this Date object forward in time by the given number of days.
    public void addDays(int days)
    {
        if (days < 0)
        {
            throw new IllegalArgumentException("The numbers of days can not be negative.");
        }
        this.day += days;

        adjustDate();
    }

    // Moves this Date object forward in time by the given number of seven-day weeks.
    public void addWeeks(int weeks)
    {
        while (weeks > 0)
        {
            addDays(7);
            //adjustDate();
            weeks--;
        }
    }

    // Returns the number of days that this Date must be adjusted to make it equal to the given other Date.
    public int daysTo(Date other)
    {
        return this.day - other.getDay();
    }

    // Returns the day from the date.
    public int getDay()
    {
        return this.day;
    }

    // Returns the month from the date.
    public int getMonth()
    {
        return this.month;
    }

    // Returns the year from the date.
    public int getYear()
    {
        return this.year;
    }

    // Check if the year of the date is a leap year or not.
    public boolean isLeapYear()
    {
        /*if ((this.year % 4 == 0 && this.year % 100 != 0) || (this.year % 400 == 0 && this.year % 100 == 0))
        {
            return true;
        }
        return false;*/
        if (this.year % 100 == 0) {

            if (this.year % 400 == 0) {
                return true;
            }
        } else if (this.year % 4 == 0) {
            return true;
        }
        return false;
    }

    public String toString()
    {
        return this.day + "." + this.month + "." + this.year;
    }

    // Makes so the day fits in the number of days in a month
    // And adds how many months are needed.
    private void adjustDate()
    {
        // Maybe make it constant?
        int daysInMonth;
        /*if (month == 0)
        {
            setMonth(1);
        }*/
        switch (this.month)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInMonth = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                daysInMonth = 30;
                break;
            case 2:
                if (isLeapYear())
                {
                    daysInMonth = 29;
                } else
                {
                    daysInMonth = 28;
                }
                break;
            default:
                daysInMonth = 0;
        }

        if (this.day > daysInMonth)
        {
            // Get the day value in range of 1 to how many days are in the month
            // And adds to month and year the correct value;
            this.month = this.day / daysInMonth + month;
            this.day = this.day - (this.day / daysInMonth) * daysInMonth;
        }
        if( this.month > NUMBERS_OF_MONTHS_IN_YEAR)
        {
            this.year = this.month / NUMBERS_OF_MONTHS_IN_YEAR + this.year;
            this.month = this.month - (this.month / NUMBERS_OF_MONTHS_IN_YEAR) * NUMBERS_OF_MONTHS_IN_YEAR;
        }
    }

    @Override
    public int compareTo(Date o)
    {
        if (this.year > o.getYear())
        {
            return 1;
        }
        if (this.year == o.getYear())
        {
            if (this.month > o.getMonth())
            {
                return 1;
            }
            if (this.month == o.getMonth())
            {
                return this.day - o.getDay();
            } else return -1;
        } else return -1;
    }
}
