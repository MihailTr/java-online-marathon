package academy.softserve.sprint02;
/**
 * Create interface DrinkReceipt with methods String getName() and
 * DrinkReceipt addComponent(String componentName, int componentCount).
 * Create interface DrinkPreparation with method Map<String, Integer> makeDrink()
 * to return a drink components. Create interface Rating with method int getRating().
 * Class Caffee contains fields String name, int rating, Map of ingredients
 * and implements interfaces DrinkReceipt, DrinkPreparation and Rating.
 * Method makeDrink() prepare coffee with typically components: {Water=100, Arabica=20}.
 * Espresso and Cappuccino classes extends the Caffee Class and override method makeDrink().
 * Espresso caffee has 50 g. of Water. Cappuccino caffee has an additional of 50 g. of Milk.
 * Create a averageRating() method of the MyUtils class to return a Map with
 * coffee name as key and coffee average rating as value.
 * For example, for a given list
 * [Espresso [name=Espresso, rating=8], Cappuccino [name=Cappuccino, rating=10],
 * Espresso [name=Espresso, rating=10], Cappuccino [name=Cappuccino, rating=6],
 * Caffee [name=Caffee, rating=6]]
 * you should get
 * {Espresso=9.00, Cappuccino=8.00, Caffee=6.00}
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

interface DrinkReceipt {
    // Code
    String getName();

    DrinkReceipt addComponent(String componentName, int componentCount);
}

interface DrinkPreparation {
    // Code
    Map<String, Integer> makeDrink();
}

interface Rating {
    // Code
    int getRating();
}

class Caffee implements DrinkReceipt, DrinkPreparation, Rating {
    // Code
    private String name;
    private int rating;
    private Map<String, Integer> ingredients = new HashMap<>();

    public Caffee(String name, int rating) {
        this.name = name;
        this.rating = rating;
        addComponent("Water", 100);
        addComponent("Arabica", 20);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public DrinkReceipt addComponent(String componentName, int componentCount) {
        ingredients.put(componentName, componentCount);
        return this;
    }

    @Override
    public Map<String, Integer> makeDrink() {
        return ingredients;
    }

    @Override
    public int getRating() {
        return this.rating;
    }
}

class Espresso extends Caffee {
    // Code
    public Espresso(String name, int rating) {
        super(name, rating);
        addComponent("Water", 50);
        addComponent("Arabica", 20);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        return super.makeDrink();
    }
}

class Cappuccino extends Caffee {
    // Code
    public Cappuccino(String name, int rating) {
        super(name, rating);
    }

    @Override
    public Map<String, Integer> makeDrink() {
        addComponent("Milk", 50);
        return super.makeDrink();
    }
}

public class MyUtils {
    Map<String, ArrayList<Integer>> mapList = new HashMap<>();
    Map<String, Double> average = new HashMap<>();

    public Map<String, Double> averageRating(List<Caffee> coffees) {
        average.clear();
        if (coffees.isEmpty()) {
            return average;

        }else {
            for (Caffee cof : coffees) {
                ArrayList<Integer> cofReit = new ArrayList<>();
                String coffeeName = cof.getName();
                int coffValue = cof.getRating();
                if (!mapList.containsKey(coffeeName)) {
                    cofReit.add(coffValue);
                    mapList.put(coffeeName, cofReit);
                } else {
                    ArrayList<Integer> current = mapList.get(coffeeName);
                    current.add(coffValue);
                    mapList.put(coffeeName, current);
                }
            }

            for (Map.Entry<String, ArrayList<Integer>> sumList : mapList.entrySet()) {
                int sumVal = 0;
                ArrayList<Integer> sumCurr = sumList.getValue();
                for (Object s : sumCurr) {
                    sumVal += (int)s;
                }
                double valSum = (double) sumVal / sumCurr.size();
                average.put(sumList.getKey(), valSum);
            }
        }
        return average;
    }
}

/**
 * Create a averageRating() method of the MyUtils class to return a Map with
 * coffee name as key and coffee average rating as value.
 * For example, for a given list
 * [Espresso [name=Espresso, rating=8], Cappuccino [name=Cappuccino, rating=10],
 * Espresso [name=Espresso, rating=10], Cappuccino [name=Cappuccino, rating=6],
 * Caffee [name=Caffee, rating=6]]
 * you should get
 * {Espresso=9.00, Cappuccino=8.00, Caffee=6.00}
 */

class task02 {
    public static void main(String[] args) {
        List<Caffee> testList = new ArrayList<>();
        List<Caffee> testList1 = new ArrayList<>();
        testList.add(new Espresso("Espresso", 7));
        testList.add(new Cappuccino("Cappuccino", 10));
        testList.add(new Espresso("Espresso", 8));
        testList.add(new Cappuccino("Cappuccino", 10));
        testList.add(new Caffee("Caffee", 6));
        testList.add(new Caffee("Caffee", 6));

        MyUtils myUtils = new MyUtils();
//        System.out.println(testList.toString());
        System.out.println(myUtils.averageRating(testList));
        System.out.println(myUtils.averageRating(testList1));
    }
}
