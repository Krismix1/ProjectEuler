package Problem28;

/**
 * Created by Chris on 05-Feb-17.
 */
public class Problem28Main
{
    public static void solution()
    {
        long start = System.nanoTime();
        int size = 1001;
        int sum = 1;
        for (int i = size; i > 1; i = i-2)
        {
            //int topRight = i*i;
            //int topLeft = topRight - (i - 1);
            //int bottomLeft = topLeft - (i - 1);
            //int bottomRight = bottomLeft - (i - 1);
            //sum += topLeft + topRight + bottomLeft + bottomRight;
            sum += 4 * i*i - 6 * i + 6;
            //System.out.printf("Top right %d, top left %d, bottom left %d, bottom right %d\n", topRight, topLeft, bottomLeft, bottomRight);
        }
        System.out.println("Sum is " + sum);
        long time = System.nanoTime() - start;
        System.out.println("Solution found in " + time / 1000000000.0 + " sec");
    }

    public static void main(String[] args)
    {
        solution();
    }
}
