import HelperClasses.NumberTriangle;

import java.io.File;

/**
 * Created by Chris on 29-Dec-16.
 */
public class Problem67
{
    public static void main(String[] args)
    {
        NumberTriangle triangleObj = new NumberTriangle(new File("Problem67Input.txt"));
        System.out.println(triangleObj.calculateSum());
    }
}
