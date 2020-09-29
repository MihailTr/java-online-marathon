package academy.softserve.sprint06;

/**
 * Implement a static method findMaxByCondition(...) of MyUtils class that
 * takes List of integers as a first parameter and predicate as a second
 * and returns the max value from the list that satisfies the condition
 * of the predicate.
 *
 * Also, implement getFilterdValue(...) method of User class. The getFilteredValue(...)
 * method should be able to take MyUtils.findMaxByCondition(...) as a first
 * parameter and Predicate as a second. This method should return an integer
 * value, evaluated from User's field values using the first and second
 * parameters of getFilterdValue(...) method.
 *
 * One more method that needs to be implemented in User class
 * is getMaxValueByCondition(...). This method has one Predicate parameter.
 * The implementation should call getFilterdValue(...) method
 * with MyUtils.findMaxByCondition(...) as a first parameter and passed
 * along Predicate as a second.
 *
 * import java.util.function.Predicate;
 * import java.util.function.BiFunction;
 * import java.util.ArrayList;
 * import java.util.List;
 *
 * class MyUtils{
 *     public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {
 *
 *         // Write your code here
 *
 *     }
 * }
 *
 * class User {
 *     public final List<Integer> values = new ArrayList<Integer>();
 *
 *     int getFilterdValue( / arguments / ){
 *
 *         // Write your code here
 *
 *     }
 *
 *     int getMaxValueByCondition(Predicate<Integer> predicate) {
 *
 *         // Write your code here
 *
 *     }
 * }
 *
 */


import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.List;

class MyUtils{
    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {
        // Write your code here
        int numMax = 0;
        for (Integer num:numbers) {
            if (numMax<num && pr.test(num)) {
                numMax = num;
            }
        }
        return numMax;
    }
}

class User {
    public final List<Integer> values = new ArrayList<Integer>();

    int getFilterdValue(BiFunction<List<Integer>,Predicate<Integer>, Integer> num, Predicate<Integer> predicate) {
        // Write your code here

        return num.apply(values, predicate);
    }

    int getMaxValueByCondition(Predicate<Integer> predicate) {

        // Write your code here
        return getFilterdValue(MyUtils::findMaxByCondition, predicate);
    }
}

public class task06 {
}
