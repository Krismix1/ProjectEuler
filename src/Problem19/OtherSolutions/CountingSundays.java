package Problem19.OtherSolutions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author HakkiYavuz
 */
public class CountingSundays
{

    private static final String startDate = "1 January 1901";
    private static final DateFormat format = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
    private static Calendar startDateObj;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException
    {
        int result = 0;
        try
        {
            startDateObj = new GregorianCalendar();
            startDateObj.setTime(format.parse(startDate));

            for (int i = 1901; i < 2001; i++)
            {
                startDateObj.set(Calendar.YEAR, i);
                for (int j = 0; j < 12; j++)
                {
                    startDateObj.set(Calendar.MONTH, j);

                    if (startDateObj.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
                    {
                        result++;
                    }
                }
            }
            System.out.println("RESULT : " + result);
        } catch (ParseException ex)
        {
            Logger.getLogger(CountingSundays.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}