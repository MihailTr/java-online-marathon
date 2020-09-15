package academy.softserve.sprint02.task04;

/**
 * Create classes Employee (fields String name, int experience and
 * BigDecimal basePayment) and Manager (field double coefficient) with methods
 * which return the general working experience and payment for work done.
 * A getter methods of class Employee return value of all fields: getName(),
 * getExperience() and getPayment().
 * Classes Manager is derived from class Employee and override getPayment()
 * method to return multiplication of a coefficient and base payment.
 * Create a largestEmployees() method of the MyUtils class to return a List of
 * unique employees with maximal working experience and payment without duplicate objects.
 * The original list must be unchanged.
 * For example, for a given list
 * [Employee [name=Ivan, experience=10, basePayment=3000.00],
 * Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5],
 * Employee [name=Stepan, experience=8, basePayment=4000.00],
 * Employee [name=Andriy, experience=7, basePayment=3500.00],
 * Employee [name=Ihor, experience=5, basePayment=4500.00],
 * Manager [name=Vasyl, experience=8, basePayment=2000.00, coefficient=2.0]]
 * you should get
 * [Employee [name=Ivan, experience=10, basePayment=3000.00],
 * Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5],
 * Employee [name=Ihor, experience=5, basePayment=4500.00]].
 * <p>
 * import java.math.BigDecimal;
 * import java.util.ArrayList;
 * import java.util.Collections;
 * import java.util.Comparator;
 * import java.util.List;
 * class Employee {
 * // Code
 * }
 * class Manager extends Employee {
 * // Code
 * }
 * public class MyUtils {
 * public List<Employee> largestEmployees(List<Employee> workers) {
 * // Code
 * }
 * }
 */

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    // Code
    private String name;
    private int experience;
    private BigDecimal basePayment;

    public Employee(String name, int experience, BigDecimal basePayment) {
        this.name = name;
        this.experience = experience;
        this.basePayment = basePayment;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public BigDecimal getPayment() {
        return basePayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return experience == employee.experience &&
                Objects.equals(name, employee.name) &&
                Objects.equals(basePayment, employee.basePayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, experience, basePayment);
    }
}

class Manager extends Employee {
    // Code
    private double coefficient;

    public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
        super(name, experience, basePayment);
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }

    @Override
    public BigDecimal getPayment() {
        BigDecimal bigDecimal = super.getPayment();
        return bigDecimal.multiply(BigDecimal.valueOf(coefficient));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Manager)) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Double.compare(manager.coefficient, coefficient) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coefficient);
    }
}

public class MyUtils {
    public List<Employee> largestEmployees(List<Employee> workers) {
        // Code
        Integer maxExp = workers.stream()
                .filter(Objects::nonNull)
                .map(worker -> worker.getExperience())
                .max(Integer::compareTo)
                .get();

        List<Employee> expList = workers.stream()
                .filter(Objects::nonNull)
                .filter(worker -> worker.getExperience() == maxExp)
                .collect(Collectors.toList());

        BigDecimal maxPay = workers.stream()
                .filter(Objects::nonNull)
                .map(worker -> worker.getPayment())
                .max(BigDecimal::compareTo)
                .get();

        List<Employee> payList = workers.stream()
                .filter(Objects::nonNull)
                .filter(worker -> worker.getPayment().equals(maxPay))
                .collect(Collectors.toList());

        expList.addAll(payList);
        return expList;
    }
}


class task04 {
    public static void main(String[] args) {
        List<Employee> workers = new ArrayList<>();
        workers.add(new Employee("Ivan", 10, BigDecimal.valueOf(3000.00)));
        workers.add(new Manager("Petro", 9, BigDecimal.valueOf(3000.00), 1.5));
        workers.add(new Employee("Stepan", 8, BigDecimal.valueOf(4000.00)));
        workers.add(new Employee("Andriy", 7, BigDecimal.valueOf(3500.00)));
        workers.add(new Employee("Ihor", 5, BigDecimal.valueOf(4500.00)));
        workers.add(new Manager("Vasyl", 8, BigDecimal.valueOf(2000.00), 2.0));

        MyUtils myUtils = new MyUtils();
        myUtils.largestEmployees(workers);
        System.out.println(myUtils.largestEmployees(workers));
    }
}
