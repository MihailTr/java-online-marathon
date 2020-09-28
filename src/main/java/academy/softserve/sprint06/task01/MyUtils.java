package academy.softserve.sprint06.task01;

/**
 * Implement a static method getCount(...) that takes an array of integers as
 * the first parameter. The second parameter is a functional interface that
 * works with integers and defines a some condition.
 *
 * The method should return the count of elements in the array that satisfy
 * the condition defined by the second argument.
 *
 * import java.util.Arrays;
 * import java.util.function.Predicate;
 * public class MyUtils {
 *
 *     public static int getCount( /* Place the parameters here / ){
 *
 *         // Write your code here
 *
 *     }
 *}
 *
 *
 *
 */


import java.util.Arrays;
import java.util.function.Predicate;
public class MyUtils {

    public static int getCount(int[] firstParameter, Predicate<Integer>condition) {
        int count = 0;
        // Write your code here
        for (int num: firstParameter) {
            if (condition.test(num)) {
                count++;
            }
        }
        return count;
    }
}
