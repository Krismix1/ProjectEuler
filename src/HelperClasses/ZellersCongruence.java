package HelperClasses;

/**
 * Created by Cat Home on 13.01.2017.
 */
public class ZellersCongruence
{
    public static void main(String[] args) {

        int count = 0;
        //loop for the year counter 1901-2000
        for (int i = 1901; i < 2001; i++) {
            //loop for each month
            for (int j = 1; j < 13; j++) {

                if (dayOfWeek(j, 1, i) == true) {
                    count++;
                }
            }
        }
        System.out.println("Number of Sundays: " + count);
    }

    /**
     * Returns true if the date entered is a Sunday.
     *
     */
    private static boolean dayOfWeek(int month, int day, int year) {
        // The day of the week is calculated using Zeller's congruence,
        // The formula requires that January and February be counted as the
        // 13th and 14th months of the previous year.
        int a = month;
        if (month < 3) {
            a += 12;
            year--;
        }
        int b = year % 100;
        int c = year / 100;

        //Zeller's congruence;
        int dayOfWeek = (day + 26 * (a + 1) / 10 + b + b / 4 + c / 4 + 5 * c) % 7;

        //Saturday
        if (dayOfWeek == 0) {
            return false;
        }
        //Sunday
        if (dayOfWeek == 1) {
            return true;
        }
        //Monday
        if (dayOfWeek == 2) {
            return false;
        }
        if (dayOfWeek == 3) {
            return false;
        }
        if (dayOfWeek == 4) {
            return false;
        }
        if (dayOfWeek == 5) {
            return false;
        }
        if (dayOfWeek == 6) {
            return false;
        }

        return false;     //unreachable
    }
}
