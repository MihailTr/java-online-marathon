package academy.softserve.sprint06.task04;

/**
 * Suppose, we have the Person class with fields name and goShopping.
 * <p>
 * The goShopping field defines if Person will do shopping based on product
 * name and discount that come as parameters. You should define the next
 * default behavior for goShopping:
 * <p>
 * return true if product name = "product1"  and discount > 10, otherwise return false.
 * <p>
 * Define the type for goShopping field and name it DecisionMethod and define
 * a method decide in it.
 * <p>
 * Also, we have the class Shop with method sale(). This method informs users
 * about a discount product and a percentage of discount by using
 * their goShopping values (which are stored in clients field).
 * The method should return the count of users that will go shopping.
 * <p>
 * import java.util.ArrayList;
 * import java.util.List;
 * <p>
 * class Person{
 * String name;
 * <p>
 * Person(String name){
 * this.name = name;
 * }
 * <p>
 * DecisionMethod goShopping // Write lambda here
 * }
 * <p>
 * // Create DecisionMethod interface here
 * <p>
 * class Shop{
 * public List<DecisionMethod> clients = new ArrayList<>();
 * <p>
 * public int sale(String product, int percent) {
 * <p>
 * // Write your code here
 * <p>
 * }
 * }
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    //    DecisionMethod goShopping // Write lambda here
    DecisionMethod goShopping = (name, discount) -> {
        if (name.equals("product1") && discount > 10) {
            return true;
        } else {
            return false;
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(goShopping, person.goShopping);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, goShopping);
    }
}

// Create DecisionMethod interface here
interface DecisionMethod {
    boolean decide(String product, int percent);
}

class Shop {
    public List<DecisionMethod> clients = new ArrayList<>();

    public int sale(String product, int percent) {
        int count =0;
        // Write your code here
        for (DecisionMethod clent: clients) {
            if (clent.decide(product, percent)) {
                count++;
            }
        }
        return count;
    }
}


public class task04 {

}
