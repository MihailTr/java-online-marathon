package academy.softserve.sprint07.task03;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Create the method writeFile(String filename, String text) that write the
 * text to file as sequence of bytes in binary format.
 * <p>
 * For example, the text fragment
 * <p>
 * <p>
 * should be represented in the file as a sequence of 7-bit bytes without
 * spaces between them:
 * <p>
 * If less than 7 bits are required to represent the character then add
 * to binary sequence leading zeros '0'.
 * <p>
 * public static void writeFile(String filename, String text) {
 * <p>
 * // Write your code here
 * <p>
 * }
 */
public class task03 {

    public static void main(String[] args) {
//        String text = "Example of text for test case #1";
//        String text1 = "10001011111000110000111011011110000110110011001010100000110111111001100100000111010011001011111000111010001000001100110110111111100100100000111010011001011110011111010001000001100011110000111100111100101010000001000110110001";
        String text = "Example of text\nfor test case #2";
        String text1 = "10001011111000110000111011011110000110110011001010100000110111111001100100000111010011001011111000111010000010101100110110111111100100100000111010011001011110011111010001000001100011110000111100111100101010000001000110110010";
        String file = "test";
        System.out.println(text1);
        writeFile(file, text);

    }

    public static void writeFile(String filename, String text) {

        // Write your code here
        byte[] bytes = text.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes) {
            String str = Integer.toBinaryString(b);
            if (str.length() < 7) {
                while (!(str.length()==7)){
                    str = "0" + str;
                }
            }
            binary.append(str);
        }

        try {
            File file = new File(filename);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(binary.toString().getBytes());
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(binary);
    }
}
