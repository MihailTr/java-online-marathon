package academy.softserve.sprint02.task01;

/**
 * Please, make refactoring of the code:
 *
 * class Person {
 *     String childIDNumber;
 * }
 *
 *
 * class Child {
 *     int age;
 *     String healthInfo;
 *     String name;
 *     String getHealthStatus(){ return name +" " + healthInfo; }
 * }
 *
 *
 * class Adult {
 *     int age;
 *     String healthInfo;
 *     String passportNumber;
 *     String name;
 *     String getHealthStatus(){ return name +" " + healthInfo; }
 * }
 *
 * We know that adult  doesn't have childIDNumber.
 * Child doesn't have passportNumber.
 * Create a public constructor in each class to initialize all their fields
 * (make the first parameter of type int).
 */

public class task01 {
}

class PersonT {
    int age;
    String healthInfo;
    String name;

    public PersonT(int age, String healthInfo, String name) {
        this.age = age;
        this.healthInfo = healthInfo;
        this.name = name;
    }
    String getHealthStatus(){ return name +" " + healthInfo; }

}

class Child extends PersonT{
    String childIDNumber;

    public Child(int age, String healthInfo, String name, String childIDNumber) {
        super(age, healthInfo, name);
        this.childIDNumber = childIDNumber;
    }
}

class Adult extends PersonT{
    String passportNumber;

    public Adult(int age, String healthInfo, String name, String passportNumber) {
        super(age, healthInfo, name);
        this.passportNumber= passportNumber;
    }
}
