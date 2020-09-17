package academy.softserve.sprint03;

//import java.util.Objects;

/**
 * Suppose we have the next class:
 * Pizza class
 *
 * Create public static inner class named PizzaBuilder inside Pizza class that correspond the next class diagram:
 *
 * Inside the cook method create and return an instance of Pizza class with your at least three favorite ingredients.
 *
 * * For correct passing of all tests don't use print and println methods in your code.
 *
 * class Pizza {
 *     private String cheese;
 *     private String meat;
 *     private String seafood;
 *     private String vegetable;
 *     private String mushroom;
 *
 *     private Pizza() { }
 *
 *     public String getCheese() {
 *         return cheese;
 *     }
 *     public String getMeat() {
 *         return meat;
 *     }
 *     public String getSeafood() {
 *         return seafood;
 *     }
 *     public String getVegetable() {
 *         return vegetable;
 *     }
 *     public String getMushroom() {
 *         return mushroom;
 *     }
 *
 *     public static PizzaBuilder base() {
 *         return new PizzaBuilder();
 *     }
 *
 *     // Describe PizzaBuilder class here
 *
 * }
 *
 * class Oven {
 *     public static Pizza cook() {
 *
 *         // Create and return instance of Pizza class here
 *
 *     }
 * }
 */

import java.util.Objects;

class Pizza {
    private String cheese;
    private String meat;
    private String seafood;
    private String vegetable;
    private String mushroom;

    private Pizza() { }

    public String getCheese() {
        return cheese;
    }
    public String getMeat() {
        return meat;
    }
    public String getSeafood() {
        return seafood;
    }
    public String getVegetable() {
        return vegetable;
    }
    public String getMushroom() {
        return mushroom;
    }

    public static PizzaBuilder base() {
        return new PizzaBuilder();
    }

    // Describe PizzaBuilder class here
    public static class PizzaBuilder{
        private Pizza pizza;

        private PizzaBuilder() {
            pizza = new Pizza();
        }

        public PizzaBuilder addCheese(String cheese){
            pizza.cheese=cheese;
            return this;
        }

        public PizzaBuilder addMeat(String meat){
            pizza.meat=meat;
            return this;
        }

        public PizzaBuilder addSeafood(String seafood){
            pizza.seafood=seafood;
            return this;
        }

        public PizzaBuilder addVegetable(String vegetable){
            pizza.vegetable=vegetable;
            return this;
        }

        public PizzaBuilder addMushroom(String mushroom){
            pizza.mushroom=mushroom;
            return this;
        }

        public Pizza build(){
            return pizza;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pizza pizza = (Pizza) o;
        return cheese.equals(pizza.cheese) &&
                meat.equals(pizza.meat) &&
                seafood.equals(pizza.seafood) &&
                vegetable.equals(pizza.vegetable) &&
                mushroom.equals(pizza.mushroom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cheese, meat, seafood, vegetable, mushroom);
    }
}

class Oven {
    public static Pizza cook() {

        // Create and return instance of Pizza class here
        Pizza pizza = Pizza.base()
                .addCheese("Chees")
                .addMeat("Meat")
                .addVegetable("Vegetable")
                .build();
        return pizza;
    }
}





public class task01 {
    public static void main(String[] args) {
        System.out.println(Oven.cook().toString());
    }
}
