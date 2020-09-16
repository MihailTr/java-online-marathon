package academy.softserve.sprint02.tast06;

/**
 * Please create class Shape with abstract method to calculate area of figure and field name. Replace code in method getArea() according to principles of polymorphism i.e. Circle and Rectangle classes extends Shape class and override double getArea() method. Develop maxAreas() method of the MyUtils class to return a List with instances of maximum area.
 * The original list must be unchanged.
 * For example, for a given list
 * [Circle [radius=2.00], Rectangle [height=2.00, width=3.00], Circle [radius=1.00], Rectangle [height=3.00, width=2.00],  Circle [radius=0.50], Rectangle [height=1.00, width=2.00]]
 * you should get
 * [Circle [radius=2.00], Rectangle [height=2.00, width=3.00], Rectangle [height=3.00, width=2.00]]
 *
 * import java.util.ArrayList;
 * import java.util.Collections;
 * import java.util.Comparator;
 * import java.util.HashMap;
 * import java.util.List;
 * import java.util.Map;
 *
 * abstract class Shape {
 *     // Code
 * }
 * class Circle extends Shape {
 *     // Code
 * }
 * class Rectangle extends Shape {
 *     // Code
 * }
 * public class MyUtils {
 *     public List<Shape> maxAreas(List<Shape> shapes) {
 *         // Code
 *     }
 * }
 */


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class Shape {
    // Code
    private String name;
    public Shape() {

    }

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public abstract double getArea();

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
class Circle extends Shape {
    private double radius;
    private double sum = 0;
    private static final double pi = 3.14;

    public Circle(String name,double radius) {
        super(name);
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        sum =  radius * radius * pi;
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
    // Code
}
class Rectangle extends Shape {
    private double width;
    private double height;
    private double sum = 0;


    public Rectangle(String name, double width, double height) {
        super(name);
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        sum = height * width;
        return sum;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    // Code
}
public class MyUtils {
    public List<Shape> maxAreas(List<Shape> shapes) {
        // Code
        List<Shape> rectangleList = new ArrayList<>();
        List<Shape> circleList = new ArrayList<>();
        List<Shape> mapPers= new ArrayList<>();
        Map<Object, Double> valCir = new HashMap<>();
        Map<Object, Double> valRet = new HashMap<>();
        mapPers.clear();

        for (Shape o:shapes) {
            if (o==null) return mapPers;
        }
        if (shapes == null) {
            return null;
        }
        if (shapes.size() == 0) {
            return shapes;
        }
        if (shapes.isEmpty()) {
            return mapPers;
        } else {
            for (Shape list : shapes) {
                String clPr = String.valueOf(list.getClass().getSimpleName());
                if (clPr.equals("Rectangle")) {
                    rectangleList.add(list);
                } else if (clPr.equals("Circle")) {
                    circleList.add(list);
                }
            }

            for (Shape person: rectangleList){
                double maxRec= ((Rectangle)person).getArea();
                valRet.put(person,maxRec);
            }

            double maxValR = 0.0;
            if (valRet.size()==0) {
                maxValR = 0.0;
            }else {
                maxValR = (Collections.max(valRet.values()));
            }

            for (Shape person: circleList){
                double maxRec= ((Circle)person).getArea();
                valCir.put(person,maxRec);
            }
            double maxValC = 0.0;
            if (valCir.size()==0) {
                maxValC = 0.0;
            }else {
                maxValC = (Collections.max(valCir.values()));
            }

            for (Map.Entry<Object, Double> s: valCir.entrySet()) {
                if (maxValC==s.getValue()) {
                    mapPers.add((Shape) s.getKey());
                }
            }
            for (Map.Entry<Object, Double> s: valRet.entrySet()) {
                if (maxValR==s.getValue()) {
                    mapPers.add((Shape) s.getKey());
                }
            }
            return mapPers;
        }
    }
}




class task06 {
    public static void main(String[] args) {
        List<Shape> testList=new ArrayList<>();
//        testList.add(new Circle(2.00));
//        testList.add(new Rectangle (2.00, 3.00));
//        testList.add(new Circle(1.00));
//        testList.add(new Rectangle (3.00, 2.00));
        testList.add(new Circle(0.50));
//        testList.add(new Rectangle (1.00, 2.00));

        System.out.println(new MyUtils().maxAreas(testList));


    }
}
