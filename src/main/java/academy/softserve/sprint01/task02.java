package academy.softserve.sprint01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Suppose we have the next class:
 * <p>
 * 1. Create an instances of Employee class named 'emp1' and 'emp2'.
 * 2. Set not null values for 'fullName' and 'salary' properties.
 * <p>
 * 3. Create array of Employee type with name 'employees' and add two objects created before.
 * 4. Create variable with name 'employeesInfo' of String type.
 * 5. Using a loop, iterrate across array and write to variable named 'employeesInfo' info about each employee in next fommat:
 * <p>
 * json
 * <p>
 * * You don't need to create any classes and describe the main(...) method. Just write the code!
 * <p>
 * * For correct passing of all tests don't use print and println methods in your code.
 */
public class task02 {
    public static void main(String[] args) {
//        Employee emp1 = new Employee("Name", 10.0F);
//        Employee emp2 = new Employee("Name1", 34.05f);
        Employee emp1 = new Employee();
        Employee emp2 = new Employee();
        Employee[] employees = new Employee[2];
        emp1.fullName = "Name";
        emp1.salary = 10.0F;
        emp2.fullName = "Name1";
        emp2.salary = 34.05f;
        employees[0]=emp1;
        employees[1]=emp2;
        String employeesInfo = "[";

        for (Employee e : employees) {
            employeesInfo = employeesInfo + "{fullName: " + "\"" + e.fullName +
                    "\"" + ", salary: " + e.salary + "}, ";
        }
        employeesInfo = employeesInfo.trim() + "]";
        employeesInfo = employeesInfo.replaceAll("},]", "}]");

        System.out.println(employeesInfo);
    }


}

class Employee {
    public String fullName;
    public float salary;

//    public Employee(String fullName, float salary) {
//        this.fullName = fullName;
//        this.salary = salary;
//    }

//    public void setFullName(String fullName) {
//        this.fullName = fullName;
//    }
//
//    public void setSalary(float salary) {
//        this.salary = salary;
//    }
}
