package academy.softserve.sprint05;

/**
 * Create a class Plant, which includes private fields String name, Color color
 * and Type type, and constructor with three String parameters
 * (String type, String color, String name) where these fields are initialized.
 * Create getters for all fields.
 * Color and Type are Enum.
 * Color contains White, Red, Blue entries.
 * Type contains Rare and Ordinary entries.
 * Override the method toString( ) for Plant class which returns result formatted
 * like following: {type: Rare, color: Red, name: MyPlant}
 * Create classes ColorException and TypeException as derived from Exception.
 * Both classes should have a constructor with one String parameter and pass this
 * parameter to the base class.
 * The constructor of Plant should throw a corresponding exception whenever an
 * inappropriate parameter is passed.
 */

class Plant{
    private String name;
    private Color color;
    private Type type;

    public Plant(String type, String color, String name) throws TypeException, ColorException{
        try {
            this.type = Type.valueOf(type.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new TypeException("Invalid value Unknown type for field type");
        }

        try {
            this.color = Color.valueOf(color.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new ColorException("Invalid value " + color +" for field " +
                    "color");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "{type: " + type + ", color: " + color +", name: " + name +'}';
    }
}

enum Color{
    WHITE, RED, BLUE;
}

enum Type{
    RARE, ORDINARY;
}

class ColorException extends Exception{
    public ColorException(String message) {
        super(message);
    }
}

class TypeException extends Exception {
    public TypeException(String message) {
        super(message);
    }
}

public class task02 {
    public static void main(String[] args) throws ColorException, TypeException {
        Plant plant = new Plant("Rare", "Red", "test");
        Plant plant1 = new Plant("RarE1", "Red", "test");
//        Plant plant2 = new Plant("Unknown type", "Name");
        System.out.println(plant);
        System.out.println(plant1);
//        for (Type color: Type.values()) {
//            System.out.print(color.toString().toUpperCase()+", ");
//        }

    }
}
