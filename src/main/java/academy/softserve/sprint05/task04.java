package academy.softserve.sprint05;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Create class Person with private fields firstName,  lastName, idCode. Create
 * two classes inherited from RuntimeException: NameException and CodeException.
 * NameException will be thrown if the first name or last name is invalid
 * (doesn't start from uppercase or contains not only letters and symbols "-" and " ").
 * CodeException will be thrown if idCode is invalid (valid idCode contains
 * exactly 10 digits). In class Person create setters methods that
 * throw NameException or CodeException if appropriate arguments are not valid.
 * Create static method buildPerson(String firstName, String lastName, String idCode)
 * that returns Person if all arguments are valid otherwise it thrown
 * IllegalArgumentException with message about all invalid arguments.  Override
 * method toString() for Person class that returns representation of Person in
 * form: firstName lastName: idCode. Override equals and hashCode methods for Person class.
 * <p>
 * For example
 * Person p = new Person();
 * p.setFirstName("joe") throw NameException with message “Incorrect value joe
 * for firstName (should start from upper case and contains only alphabetic
 * characters and -, space symbol;)”
 * p.setIdCode("2") throw CodeException with message "Incorrect value 2 for code
 * (should contains exactly 10 digits)"
 * Person.buildPerson("Joe", "KlarK2", "AS-2") throw IllegalArgumentException
 * with message "Incorrect value KlarK2 for lastName (should start from upper
 * case and contains only alphabetic characters and -, _;); Incorrect value AS-2
 * for code (should contains exactly 10 digits)"
 */

class Person {
    private String firstName;
    private String lastName;
    private String idCode;

    public Person() {
    }

    public Person(String firstName, String lastName, String idCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCode = idCode;
    }

    static Person buildPerson(String firstName, String lastName,
                               String idCode)  {
        Person person = new Person();
        List<RuntimeException> error = new ArrayList<>();
        try {
            person.setFirstName(firstName);
        } catch (NameException e) {
            error.add(e);
        }
        try {
            person.setLastName(lastName);
        } catch (NameException e) {
            error.add(e);
        }
        try {
            person.setIdCode(idCode);
        } catch (CodeException e) {
            error.add(e);
        }
        if (!(error.size()==0)) {
            String str = "";
            for (RuntimeException re: error) {
                str += re.getMessage()+"; ";
            }
            str = str.substring(0, str.length()-2);
            throw new IllegalArgumentException(str);
        }else {
            return person;
        }
    }

    public void setFirstName(String firstName) throws NameException {
        if (firstName.matches("^[A-Z][a-z\\s\\-]*$")) {
            this.firstName = firstName;
        } else {
            throw new NameException("Incorrect value " + firstName + " for firstName " +
                    "(should start from upper case and contains only alphabetic characters and symbols -, _)");
        }
    }

    public void setLastName(String lastName) throws NameException{
        if (lastName.matches("^[A-Z][a-z\\s\\-]*$")) {
            this.lastName = lastName;
        } else {
            throw new NameException("Incorrect value "+lastName+" for lastName " +
                    "(should start from upper case and contains only alphabetic characters and -, _;)");
        }
    }

    public void setIdCode(String idCode) throws CodeException {
        if (idCode.matches("\\d{10}")) {
            this.idCode = idCode;
        } else {
            throw new CodeException("Incorrect value " + idCode + " for code " +
                    "(should contains exactly 10 digits)");
        }
    }

    @Override
    public String toString() {
        return firstName +" "+lastName+": "+ idCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(idCode, person.idCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, idCode);
    }
}

class NameException extends RuntimeException {
    public NameException(String message) {
        super(message);
    }
}

class CodeException extends RuntimeException {
    public CodeException(String message) {
        super(message);
    }
}

public class task04 {
    public static void main(String[] args) throws CodeException, NameException {
        Person p = new Person();
//        p.setIdCode("1111111111");
//        p.setFirstName("Joe");
        Person.buildPerson("joe", "KlarK2","AS-2");
        System.out.println(Person.buildPerson("Joe", "Klar","1111111111"));
        System.out.println(Person.buildPerson("joe", "KlarK2","AS-2"));
//        Person.buildPerson("Joe", "Klar","1111111111");
    }
}
