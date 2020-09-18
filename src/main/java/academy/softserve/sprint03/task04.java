package academy.softserve.sprint03;

/**
 * Create a LineType enum that contains different kind of lines as constants SOLID, DOTTED, DASHED and DOUBLE.
 *
 * Write a method that takes the constant of LineType type as input, and returns the message “The line is <LineType> type”.
 *
 * Where <LineType>  is name of type wrote in lower case.
 *
 * For example: The line is dotted type.
 *
 * * For correct passing of all tests don't use print and println methods in your code.
 *
 * // Describe LineType enum here
 *
 * public static String drawLine(LineType lineType) {
 *
 *     // Write method code here
 *
 * }
 */


public class task04 {
    // Describe LineType enum here
    enum LineType{
        SOLID, DOTTED, DASHED, DOUBLE
    }

    public static String drawLine(LineType lineType) {
        // Write method code here
        String str1 = lineType.toString();
        String str= "The line is "+str1.toLowerCase()+" type";
        return str;
    }

    public static void main(String[] args) {
        System.out.println(drawLine(LineType.SOLID));

    }

}
