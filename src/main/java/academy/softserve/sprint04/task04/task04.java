package academy.softserve.sprint04.task04;


/**
 * In the class ArrayUtil write a public static generic method named "setAndReturn(...)"
 * to modify and return the element in an array from the given position.
 *
 * Examples of usage:
 *
 * * For correct passing of all tests don't use print and println methods in your code.
 *
 * class ArrayUtil {
 *
 *     // Write static method setAndReturn(...) here
 *
 * }
 *
 */


public class task04 {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[3];
        int numberFromSecondPosition =
                ArrayUtil.<Integer>setAndReturn(numbers, 52, 1);
        System.out.println(numberFromSecondPosition);

        String [] words = new String[3];
        String wordFromSecondPosition = ArrayUtil.<String>setAndReturn(words,
                "Hello", 1);
        System.out.println(wordFromSecondPosition);
    }
}

class ArrayUtil<T> {
    // Write static method setAndReturn(...) here
    public static <T> T  setAndReturn(T[] num, T s1, int s2){
        num[s2] = s1;
        return num[s2];
    }
}
