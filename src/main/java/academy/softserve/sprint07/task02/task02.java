package academy.softserve.sprint07.task02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Write a method to get the date n-years m-months and k-days after today using new DateTime API.
 *
 * Return the obtained date in the format ISO_LOCAL_DATE.
 *
 * public static String getDateAfterToday(int years, int months, int days) {
 *
 *     // Write your code here
 *
 * }
 */

public class task02 {
    public static void main(String[] args) {
        System.out.println(getDateAfterToday(20, 1, 10));
        System.out.println(getDateAfterToday(3, 18, 27));
    }

    public static String getDateAfterToday(int years, int months, int days) {

        // Write your code here
        LocalDate localDate = LocalDate.now();
        LocalDate newlocalDate =
                localDate.plusYears(years).plusMonths(months).plusDays(days);

//        return newlocalDate.toString();
        return DateTimeFormatter.ISO_LOCAL_DATE.format(newlocalDate);
    }
}
