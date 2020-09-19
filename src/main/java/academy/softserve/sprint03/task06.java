package academy.softserve.sprint03;


/**
 * Create class hierarchy that represent Address Book, where can be save records in format: "(first name, last name) => address":
 *
 *     Records in the Addres Book should be represented as objects of the NameAddressPair type.
 *     The pair "(first name, last name)" is key for access to "address" in the Address Book.
 *     The key "(first name, last name)" should be immuteble and in Address Book cannot be two records with same key.
 *     The capacity of Address Book must grow twice when has no place for save the next record.
 *     The sortedBy(...) method should sorted records by ascending or descending using for this Arrays.sort(...) method.
 *     The Comparator should be implemented as an anonymous class.
 *     Sorting at first be by firstName field, and if the names match then by lastName field.
 *     The next() method from AddressBookIterator class should return record as String in next format: "First name: <first name>, Last name: <last name>, Address: <address>".
 *     Records in the Address Book must be ordered according to date of creation.
 *
 * A class hierarchy should be correspond the next class diagram:
 *
 * The next graphic notation means, that B is inner class and A is outer class:
 *
 * * If you see the next error: uses unchecked or unsafe operations, just put the next code line @SuppressWarnings("unchecked") over AddressBook and AddressBookIterator classes.
 *
 * * For correct passing of all tests don't use print and println methods in your code.
 */
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Objects;

enum SortOrder{
    ASC, DESC
}

class AddressBook implements Iterable{
    private NameAddressPair[] addressBook;
    private int counter = 0;

    public AddressBook(int capacity){
        addressBook = new NameAddressPair[capacity];
    }

    public boolean create(String firstName, String lastName, String address){
        NameAddressPair.Person person = new NameAddressPair.Person(firstName,
                lastName);
        for (NameAddressPair nameAddressPair : addressBook) {
            if (counter != 0 && nameAddressPair != null && nameAddressPair.
                    getPerson().equals(person)) {
                return false;
            }
        }

        if (addressBook.length == counter) {
            addressBook = Arrays.copyOf(addressBook, addressBook.length * 2);
        }
        addressBook[counter++] = new NameAddressPair(person, address);
        return true;
    }

    public String read(String firstName, String lastName){
        NameAddressPair.Person person = new NameAddressPair.Person(firstName,
                lastName);
        for (NameAddressPair pair: addressBook) {
            try {
                if (pair.getPerson().equals(person)) {
                    return pair.getAddress();
                }
            }catch (NullPointerException e){
                return null;
            }
        };
        return null;
    }

    public boolean update(String firstName, String lastName, String address){
        NameAddressPair.Person person = new NameAddressPair.Person(firstName,
                lastName);
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].getPerson().equals(person)) {
                addressBook[i] = new NameAddressPair(new NameAddressPair
                        .Person(firstName, lastName), address);
                return true;
            }
        }
        return false;
    }

    public boolean delete(String firstName, String lastName){
        NameAddressPair.Person person = new NameAddressPair.Person(firstName,
                lastName);
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].getPerson().equals(person)) {
                int step = counter - i - 1;
                addressBook[i] = null;
                System.arraycopy(addressBook, i + 1, addressBook, i, step);
                addressBook[--counter] = null;
                return true;
            }
        }
        return false;
    }

    public int size(){
        return counter;
    }

    public void sortedBy(SortOrder order){
        switch (order) {
            case ASC:
                Arrays.sort(addressBook,
                        (o1, o2) -> o1.getPerson().compareTo(o2.person));
            case DESC:
                Arrays.sort(addressBook, Collections.reverseOrder());
        }
    }

    @Override
    public Iterator iterator() {
        return new AddressBookIterator();
    }

    private class AddressBookIterator implements Iterator {
        private int counter = 0;

        @Override
        public boolean hasNext() {
            return counter < addressBook.length && addressBook[counter] != null;
        }

        @Override
        public String next() {
            String string =
                    "First name: " + addressBook[counter].getPerson().firstName
                    + ", Last name: " + addressBook[counter].getPerson().lastName
                    + ", Address: " + addressBook[counter].getAddress();
            counter++;
//            System.out.println(string);
            return string;
        }
    }

    private static class NameAddressPair{
        private final Person person;
        private String address;

        private NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }

        private static class Person implements Comparable<Person>{
            private String firstName;
            private String lastName;

            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            public String getFirstName() {
                return firstName;
            }

            public String getLastName() {
                return lastName;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Person person = (Person) o;
                return firstName.equals(person.firstName) &&
                        lastName.equals(person.lastName);
            }

            @Override
            public int hashCode() {
                return Objects.hash(firstName, lastName);
            }

            @Override
            public String toString() {
                return "Person{" +
                        "firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        '}';
            }

            @Override
            public int compareTo(Person o) {
                return toString().compareTo(o.toString());
            }
        }

        public Person getPerson() {
            return person;
        }

        public String getAddress() {
            return address;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NameAddressPair pair = (NameAddressPair) o;
            return person.equals(pair.person) &&
                    address.equals(pair.address);
        }

        @Override
        public int hashCode() {
            return Objects.hash(person, address);
        }
    }
}


public class task06 {
    public static void main(String[] args) {
//        AddressBook addressBook = new AddressBook(1);
//        addressBook.create("qwer", "rewq", "st1");
//        addressBook.create("asdf", "fdsa", "st2");
//        System.out.println(addressBook.iterator().toString());
//        AddressBook addressBook = new AddressBook(4);
//        addressBook.create("John", "Brown", "Address #1");
//        addressBook.create("Karen", "Davis", "Address #2");
//        addressBook.create("Steven", "Taylor", "Address #1");
//        System.out.println(addressBook.read("Susan", "Brown"));

//        System.out.println(task06.sortedByTest1());
        System.out.println(task06.iteratorTest());

    }

    static boolean sortedByTest1() {
        String[] expected = { "First name: John, Last name: Brown, Address: Address #1",
         "First name: John, Last name: Taylor, Address: Address #1",
         "First name: Karen, Last name: Davis, Address: Address #2",
         "First name: Susan, Last name: Brown, Address: Address #4" };
         String[] actual = new String[4];
         AddressBook addressBook = new AddressBook(4);
         addressBook.create("John", "Brown", "Address #1");
         addressBook.create("Susan", "Brown", "Address #4");
         addressBook.create("Karen", "Davis", "Address #2");
         addressBook.create("John", "Taylor", "Address #1");
         addressBook.sortedBy(SortOrder.ASC);
         int counter = 0;
         for (Object record : addressBook)
             actual[counter++] = record.toString();
         return Arrays.equals(expected, actual);
    }

    static boolean iteratorTest(){
         String[] expected = {"First name: Karen, Last name: Davis, Address: Address #2",
                 "First name: Steven, Last name: Taylor, Address: Address #3",
                 "First name: Susan, Last name: Brown, Address: Address #4"};
         String[] actual = new String[3];
         AddressBook addressBook = new AddressBook(4);
         addressBook.create("John", "Brown", "Address #1");
         addressBook.create("Karen", "Davis", "Address #2");
         addressBook.create("Steven", "Taylor", "Address #1");
         addressBook.create("Susan", "Brown", "Address #4");
         addressBook.update("Steven", "Taylor", "Address #3");
         addressBook.delete("John", "Brown");
         int counter = 0;
         for (Object record : addressBook)
             actual[counter++] = record.toString();
         return Arrays.equals(expected, actual);
    }
}
