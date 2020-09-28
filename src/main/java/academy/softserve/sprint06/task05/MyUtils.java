package academy.softserve.sprint06.task05;

/**
 * Implement a static method getPredicateFromSet(...) in MyUtils class.
 * <p>
 * The getPredicateFromSet method should take a Set of predicates working
 * with integers as a parameter and return a predicate with the functionality
 * of all predicates in the set invoked and connected by logical AND.
 * <p>
 * import java.util.function.Predicate;
 * import java.util.Set;
 * <p>
 * class MyUtils{
 * <p>
 * // Write your code here
 * <p>
 * }
 */


import java.util.function.Predicate;
import java.util.Set;

class MyUtils {

    // Write your code here
    static Predicate getPredicateFromSet(Set<Predicate<Integer>> predicates) {
        return predicates.stream()
                .reduce(x -> true, Predicate::and);
    }
}
