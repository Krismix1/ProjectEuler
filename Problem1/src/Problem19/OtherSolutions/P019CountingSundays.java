package Problem19.OtherSolutions;

// In Java, without using date or calender classes.
/**
 * <pre>
 * You are given the following information, but you may prefer to do some research for yourself.
 *
 *     1 Jan 1900 was a Monday.
 *
 *     Thirty days has September,
 *     April, June and November.
 *     All the rest have thirty-one,
 *     Saving February alone,
 *     Which has twenty-eight, rain or shine.
 *     And on leap years, twenty-nine.
 *
 *     A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 *
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 * </pre>
 *
 * @author anil bharadia
 *
 *
 *
 */
public class P019CountingSundays {

    private static final int FEB = 1;

    static int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {

        int result = 0;

        long days = 1;

        for (int year = 1900; year <= 2000; year++) {

            for (int month = 0; month < 12; month++) {

                if (year > 1900 && isSunday(days)) {
                    result++;
                }

                days += months[month];

                if (month == FEB && isLeapYear(year)) {

                    days = days + 1;
                }
            }
        }
        System.out.println(result);
    }

    private static boolean isLeapYear(int year) {

        if (isCentury(year)) {

            if (year % 400 == 0) {
                return true;
            }
        } else if (year % 4 == 0) {
            return true;
        }
        return false;
    }

    private static boolean isCentury(int year) {
        return year % 100 == 0;
    }

    private static boolean isSunday(long days) {
        return days % 7 == 0;
    }

}
