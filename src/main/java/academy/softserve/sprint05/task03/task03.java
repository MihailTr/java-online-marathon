package academy.softserve.sprint05.task03;

/**
 *Suppose, we class Plant from the task2, which includes private fields
 * String name, Color color and Type type, and constructor with three String
 * parameters where these fields are initialized. Color and Type are Enum.
 * Color contains White, Red, Blue entries.
 * Type contains Rare and Ordinary entries.
 *
 * And we have classes ColorException and TypeException as derived from Exception.
 *
 * The constructor of Plant throws a corresponding exception whenever an
 * inappropriate parameter is passed: String type, String color, String name.
 * Write a static tryCreatePlant method that takes 3 string parameters - type,
 * color and name and returns an instance of Plant, created based on passed params.
 * (Don't create any classes, write as if you are already inside a class.)
 * The tryCreatePlant method should catch exceptions that can be thrown
 * by Plant constructor. If inappropriate type passed as a parameter, a Plant
 * object should be returned anyway, with Ordinary type. If an inappropriate
 * color is passed, set Red color for created instance.
 */


class Plant{
    private String name;
    private Color color;
    private Type type;

    public Plant(String type, String color, String name) throws TypeException, ColorException {
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

    static Plant tryCreatePlant(String type, String color, String name) throws
            ColorException, TypeException {

        try {
            try {
                return new Plant(type, color, name);
            } catch (TypeException e) {
                return new Plant("ORDINARY", color, name);
            } catch (ColorException e) {
                return new Plant(type, "RED", name);
            }
        } catch (TypeException | ColorException e) {
            return new Plant("ORDINARY", "RED", name);
        }
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


public class task03 {
    public static void main(String[] args) throws ColorException, TypeException {
        System.out.println(Plant.tryCreatePlant("RarE", "Red", "test"));
        System.out.println(Plant.tryCreatePlant("RarE", "Blue", "test"));
        System.out.println(Plant.tryCreatePlant("RarE1", "Blue1", "test"));
    }
}



