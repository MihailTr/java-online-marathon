package academy.softserve.sprint04.task06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * Suppose we have the next class hierarchy:
 *
 * Create classes with name PersonComparator, EmployeeComparator, DeveloperComparator
 * that implenent the Comparator<Type> generic interface.
 *
 * In the Utility class create public static method named sortPeople(...)
 * that takes an array of Person type and derivative from it types,
 * and comparator as input, and returns the value of void type.
 *
 * Also, as second argument the method sortPeople(...) can takes generic
 * comparator for elements of Object type.
 *
 * The sortPeople(...) method should sorted records by ascending. At first by name,
 * then by age, then by salary, and then by Level (JUNIOR < MIDDLE < SENIOR)
 *
 * As implementation of sortPeople(...) method use the next code:
 *
 * * For correct passing of all tests don't use print and println methods in your code
 *
 * // Write PersonComparator, EmployeeComparator and DeveloperComparator here
 *
 * class Utility {
 *
 *     // Write sortPeople mentod here
 *
 * }
 *
 */

class Person {
    protected String name;
    protected int age;
    public Person(String name, int age) {
        this.name = name; this.age = age;
    }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

class Employee extends Person {
    private double salary;
    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }
    public double getSalary() { return salary; }
    public String toString() {
            return super.toString() + ", Salary: " + salary;
    }
}

class Developer extends Employee {
    private Level level;
    public Developer(String name, int age, double salary, Level level) {
        super(name, age, salary);
        this.level = level;
    }
    public Level getLevel() { return level;}
    public String toString() {
        return super.toString() + ", Level: " + level.name();
    }
}

enum Level {
    JUNIOR, MIDDLE, SENIOR
}

// Write PersonComparator, EmployeeComparator and DeveloperComparator here
class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        int name = o1.getName().compareTo(o2.getName());
        int age = o1.getAge() - o2.getAge();

        if (name == 0) {
            return age;
        }
        return name;
    }
}

class EmployeeComparator implements Comparator<Employee> {
    static final PersonComparator personComparator = new PersonComparator();

    @Override
    public int compare(Employee o1, Employee o2) {
        if (personComparator.compare(o1, o2) != 0) {
            return personComparator.compare(o1, o2);
        }
        return Double.compare(o1.getSalary(), o2.getSalary());
    }
}

class DeveloperComparator implements Comparator<Developer> {
    static final EmployeeComparator employeeComparator = new EmployeeComparator();

    @Override
    public int compare(Developer o1, Developer o2) {
        if (employeeComparator.compare(o1, o2) != 0) {
            return employeeComparator.compare(o1, o2);
        }
        return o1.getLevel().toString().compareTo(o2.getLevel().toString());
    }
}


class Utility {

    // Write sortPeople mentod here
    /* /return type/ sortPcoplc( /people/, /comparator/ ) {
            Arrays.sort( /people/, /comparator/ );
        }
    * */
    public static <T extends Person> void sortPeople(T[] personArray, Comparator<? super T> comparator) {
        Arrays.sort(personArray, comparator);
    }
}



public class task06 {

}
