package Problem19.OtherSolutions;

/**
 * Created by Cat Home on 13.01.2017.
 */
import java.time.temporal.ChronoUnit;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.time.DayOfWeek;
import java.time.LocalDate;
public class Sundays
{
    public static void main(String[] args)
    {
        LocalDate startDate = LocalDate.parse("1901-01-01");
        LocalDate endDate = LocalDate.parse("2000-12-31");
        Predicate<LocalDate> dateTester = (date) -> (date.getDayOfMonth() == 1) && (date.getDayOfWeek() == DayOfWeek.SUNDAY) && (date.getYear() <= 2000);
        System.out.println(Stream.iterate(startDate, s -> s.plusMonths(1)).limit(ChronoUnit.DAYS.between(startDate, endDate)).filter(dateTester).count());
    }
}
