package academy.softserve.sprint01;
/**
 * Create a Product class with fields name of type String and price of type double.
 *
 * The Product class must meet the following principles:
 *
 *     All class fields must be private.
 *     Get and set methods must be used to access the class fields.
 *     The class must have a constructors with and without parameters.
 *
 * In the Product class write count() static method that returns count of created objects of Product type.
 *
 * For example, next fragment of code:
 *
 * Will be print to console:
 *
 *
 * * For correct passing of all tests don't use print and println methods in your code.
 */
public class task06 {
    public static void main(String[] args) {
        Product product = new Product();
        Product product1 = new Product();
        Product product2 = new Product();
        System.out.println(Product.count());
    }
}

class Product{
    private String name;
    private double price;
    private static int counts;

    public Product(){
        counts++;
    }

    public Product(String name, double price){
        this.name = name;
        this.price = price;
        counts++;
    }

    public static int count(){
        return counts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
