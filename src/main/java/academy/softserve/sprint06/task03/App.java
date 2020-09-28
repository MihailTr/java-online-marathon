package academy.softserve.sprint06.task03;

/**
 * Suppose, we have the next class Person:
 * <p>
 * class Person{
 * String name;
 * String surname;
 * Person(String name, String surname){ this.name = name; this.surname = surname; } }
 * <p>
 * Add to App class static field greetingOperator of type BinaryOperator .
 * <p>
 * The greetingOperator should create a new string as a result by the
 * rule: "Hello " + parameter1 + " " + parameter2 + "!!!"
 * <p>
 * Create a static method createGreetings(...) that takes two parameters:
 * List<Person> and BinaryOperator and generates List<String> as a result.
 * We should be able to pass greetingOperator as a parameter here.
 * <p>
 * Please, use the second parameter in creating the result.
 * <p>
 * import java.util.function.BinaryOperator;
 * import java.util.ArrayList;
 * import java.util.List;
 * public class App {
 * <p>
 * // Write your code here
 * <p>
 * public static List<String> createGreetings(List<Person> people,
 * /* Second parameter here /){
 * <p>
 * // Write your code here
 * <p>
 * }
 * }
 */

import java.util.function.BinaryOperator;
import java.util.ArrayList;
import java.util.List;

public class App {
    static BinaryOperator<String> greetingOperator = (
            parameter1, parameter2) -> "Hello " + parameter1 + " " + parameter2 + "!!!";

    // Write your code here

    public static List<String> createGreetings(
            List<Person> people, BinaryOperator<String> greetingOperator) {
        // Write your code here
        List<String> newList = new ArrayList<>();
        for (Person person : people) {
            newList.add(greetingOperator.apply(person.name, person.surname));
        }
        return newList;
    }
}

class Person {
    String name;
    String surname;

    Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
