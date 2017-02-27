package HelperClasses;
/**
 * Created by Chris on 12.01.2017.
 * This class will provide useful methods to read input from user
 */
import java.util.Scanner;

public class MyConsole
{
    Scanner console = new Scanner(System.in);

    //reads an integer from System.in
    /**
     * Reads a valid integer.
     * If wrong input is passed, it keeps asking
     * until the user enters correct number.
     *
     * @return a valid integer
     */
    public int readInt()
    {
        while (!console.hasNextInt())
        {
            console.nextLine(); // to discard the input
            System.out.println("Not an integer. Try again.");
        }
        int input = console.nextInt();
        String discard = console.nextLine();
        //console.close();
        return input;
    }

    /**
     * Reads a valid double.
     * If wrong input is passed, it keeps asking
     * until the user enters correct number.
     *
     * @return double
     */
    public double readDouble()
    {
        while (!console.hasNextDouble())
        {
            console.nextLine(); // to discard the input
            System.out.println("Not a double. Try again.");
        }
        double input = console.nextDouble();
        String discard = console.nextLine();
        //console.close();
        return input;
    }

    public String readString()
    {
        return console.nextLine();
    }
}
