package academy.softserve.sprint01;

/**
 * Create the Point class that correspond next class diagram:
 *
 * Point class
 *
 * A Point class, which models a 2D point with x and y coordinates should contains:
 *
 *     Two private instance variables x and y  of int type.
 *     A constructor that constructs a point with the given x and y coordinates.
 *     A method getXYPair() which returns the x and y in a 2-element int array.
 *     A method called distance(int x, int y) that returns the distance from this point to another point at the given (x, y) coordinates.
 *     An overloaded distance(Point point) method that returns the distance from this point to the given Point instance.
 *     Another overloaded distance() method that returns the distance from this point to the origin (0, 0)
 *
 * * For correct passing of all tests don't use print and println methods in your code.
 */
public class task05 {
    public static void main(String[] args) {

    }
}

class Point{
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int[] getXYPair(){
        int[] arr = {x, y};
        return arr;
    }

    public double distance(int х, int у) {
        int dx = this.x - х;
        int dy = this.y - у;
        return Math.sqrt(dx*dx + dy*dy);
    }

    public double distance(Point point) {
        return distance(point.getXYPair()[0], point.getXYPair()[1]);
    }

    public double distance() {
        int dx = this.x - 0;
        int dy = this.y - 0;
        return Math.sqrt(dx*dx + dy*dy);
    }
}
