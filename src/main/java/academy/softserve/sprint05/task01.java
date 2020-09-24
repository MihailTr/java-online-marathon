package academy.softserve.sprint05;

/**
 * Create a method for calculating an area of a rectangle
 * <p>
 * int squareRectangle(int a, int b), which should throw an
 * IllegalArgumentException if at least one of its arguments is non positive.
 * <p>
 * Create trySquareRectangle method which takes two parameters and calls
 * squareRectangle to evaluate an area of a rectangle. Catch exceptions that can be generated.
 * <p>
 * trySquareRectangle shouldn't generate any exceptions. In case when one
 * or two parameters are non positive the method should return -1.
 */

public class task01 {
    public static void main(String[] args) {
        System.out.println(Operation.trySquareRectangle(1, -5));
        System.out.println(Operation.trySquareRectangle(2, 2));

    }
}

class Operation {
    public static int squareRectangle(int a, int b) {
        //your code
        if (a <= 0 || b <= 0) {
            throw new IllegalArgumentException("both arguments should be more than zero");
        } else {
            return a * b;
        }
    }

    public static int trySquareRectangle(int a, int b) {
        //your code
        try {
            return squareRectangle(a, b);
        } catch (IllegalArgumentException e) {
            //System.out.println("both arguments should be more than zero");
            return -1;
        }
    }
}

