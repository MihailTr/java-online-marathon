package academy.softserve.sprint02.task05;

/**
 * Create classes Square and Rectang with method (double getPerimeter()) for
 * calculating of perimeter.
 * Find solution for avoiding of duplicate code.
 * Create a double sumPerimeter(List<?> firures) method of the MyUtils class
 * to return a sum perimeters of all figures.
 * For example, for a given list
 * [[Square [width=4.00], Square [width=5.00], Rectang [height=2.00, width=3.00]]
 * you should get 46
 *
 * import java.util.ArrayList;
 * import java.util.List;
 *
 * class Rectang {
 *     // Code
 * }
 * class Square {
 *     // Code
 * }
 * public class MyUtils {
 *     public double sumPerimeter(List<?> firures) {
 *         // Code
 *     }
 * }
 *
 */

import java.util.ArrayList;
import java.util.List;

abstract class Shape{
    private double width;
    private double height;

    public Shape(double width) {
        this.width = width;
    }

    public Shape(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public double getPerimeter(){
        double sum =0.0;
        if (this.getClass().getSimpleName().equals("Rectang")) {
            sum = (double) height * width;
        }else if (this.getClass().getSimpleName().equals("Square")){
            sum = (double) width * width;
        }
        return sum;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

class Rectang extends Shape{
    // Code

    public Rectang(double height, double width) {
        super(height, width);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}

class Square extends Shape {
    // Code
    public Square(double width) {
        super(width);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
public class MyUtils {
    public double sumPerimeter(List<?> firures) {
        // Code
        double sumPer = 0.0;
        if (firures == null) {
            return 0.0;
        }
        if (firures.size() == 0) {
            return 0.0;
        } else {
            for (Object o : firures) {
                if (o.getClass().getSimpleName().equals("Rectang")) {
                    sumPer = sumPer + ((Rectang) o).getPerimeter();
                } else if (o.getClass().getSimpleName().equals("Square")){
                    sumPer = sumPer + ((Square) o).getPerimeter();
                }
            }
            return sumPer;
        }
    }
}


class task05 {
    public static void main(String[] args) {
//        Rectang rectang = new Rectang(2, 5);
//        Square square = new Square(4);
//        Square square1 = new Square(4.5);
//        System.out.println(rectang.getPerimeter());
//        System.out.println(square.getPerimeter());
//        System.out.println(square1.getPerimeter());
        List<Object> firuresTest = new ArrayList<>();
        firuresTest.add(new Square (4.00));
        firuresTest.add(new Square (5.00));
        firuresTest.add(new Rectang (2.00, 3.00));
        System.out.println(new MyUtils().sumPerimeter(firuresTest));

    }
}
