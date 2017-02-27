package Problem18;

import HelperClasses.NumberTriangle;

import java.io.File;

/**
 * Created by Chris on 29-Dec-16.
 */
public class Problem18Main
{

    public static void main(String[] args)
    {
        NumberTriangle triangle = new NumberTriangle(new File("Problem18.txt"));
        System.out.println(triangle.calculateSum());
    }
}
