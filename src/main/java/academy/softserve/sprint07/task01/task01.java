package academy.softserve.sprint07.task01;

import java.time.LocalDate;

/**
 * Write a method to check if a year is a leap year or not, using for this the LocalDate class.
 *
 * If a year is leap then method should return true, otherwise - false.
 *
 * public static boolean isLeapYear(int year) {
 *
 *     // Write your code here
 *
 * }
 */
public class task01 {
    public static void main(String[] args) {
        System.out.println(isLeapYear(2020));
    }

    public static boolean isLeapYear(int year) {

        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            return true;
        } else {
            return false;
        }
    }
}
