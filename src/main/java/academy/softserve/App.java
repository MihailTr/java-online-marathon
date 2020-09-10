package academy.softserve;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = reader.readLine();
            System.out.println("Input "+ str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
