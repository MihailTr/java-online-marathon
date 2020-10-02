package academy.softserve.sprint07.task04;

/**
 * Create the method readFile(String filename) that read from file a sequence
 * of bytes in binary format from previous task and return ridable string.
 *
 * For example, the sequence of 7-bit bytes
 *
 *
 * should be represented as text fragment:
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class task04 {
    public static void main(String[] args) {
        String test = "test";
        System.out.println(readFile(test));
    }

    public static String readFile(String filename) {
        String str="";
        // Write your code here
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            str = reader.readLine();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String strConvert = "";
        for(int index = 0; index < str.length(); index+=7) {
            String temp = str.substring(index, index+7);
            char letter = (char) Integer.parseInt(temp,2);
            strConvert = strConvert+letter;
        }

        return strConvert;
    }
}
