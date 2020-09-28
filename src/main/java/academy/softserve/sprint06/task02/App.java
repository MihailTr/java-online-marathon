package academy.softserve.sprint06.task02;

/**
 * Create the static field cons of type Consumer and assign it the lambda
 * expression that takes an array of doubles as a parameter and changes it using
 * the next rule: all values that are greater than 2 should be multiplied by 0.8,
 * and other values should be multiplied by 0.9.
 *
 * Also implement a static method getChanged(...) that takes an array of doubles
 * as a first parameter and Consumer implementation as a second. The method
 * should return an array changed by the second parameter.
 *
 * The getChanged(...) method should not change initial array.
 *
 * import java.util.function.Consumer;
 * public class App {
 *
 *     public static double[] getChanged(double[] initialArray, /*place the second parameter here/) {
 *         // Code
 *     }
 * }
 *
 */
import java.util.Arrays;
import java.util.function.Consumer;
public class App {
    static Consumer<double[]> consumer = value ->{
        for (int i = 0; i < value.length; i++) {
            if (value[i]>2) {
                value[i]=value[i]*0.8;
            }else {
                value[i]=value[i]*0.9;
            }
        }
    };

    public static double[] getChanged(double[] initialArray,
                                      Consumer<double[]>consumer) {
        // Code
        double[] arrayChanged = Arrays.copyOf(initialArray,
                initialArray.length);
        consumer.accept(arrayChanged);
        return arrayChanged;
    }
}