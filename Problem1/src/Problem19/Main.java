package Problem19;

import HelperClasses.Date;

/**
 * Created by Cat Home on 12.01.2017.
 */
public class Main
{
    public static void main(String[] args)
    {
        Date startingPoint = new Date(1, 1, 1901);
        Date endingPoint = new Date(31, 12, 2000);
        DayName dayComputer = new DayName();
        while (!dayComputer.calculateDayName(startingPoint).equalsIgnoreCase("sunday"))
        {
            startingPoint.addDays(1);
        }
        int numberOfDays = 0;
        while (startingPoint.compareTo(endingPoint) <=0)
        {
            if (dayComputer.calculateDayName(startingPoint).equalsIgnoreCase("sunday") &&
                    startingPoint.getDay() == 1)
            {
                numberOfDays++;
                System.out.println("In if: " + startingPoint.toString());
            }
            startingPoint.addDays(1);
            //System.out.println("Outside if: " + startingPoint.toString());
        }
        System.out.println(numberOfDays);

    }
}
