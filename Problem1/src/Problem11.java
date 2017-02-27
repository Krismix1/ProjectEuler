import java.io.File;
import java.util.Scanner;

public class Problem11
{
    public static int[][] grid = new int[20][20];

    private static void initializegrid()
    {
        File file = new File("Ex11.txt");
        try
        {
            Scanner input = new Scanner(file);
            int i = 0;
            while (input.hasNextLine())
            {
                int j = 0;
                Scanner line = new Scanner(input.nextLine());
                while (line.hasNext())
                {
                    String temp = line.next();
                    int number = Integer.parseInt(temp);
                    grid[i][j] = number;
                    j++;
                }
                i++;
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private static void printgrid()
    {
        for (int i = 0; i < 20; i++)
        {
            for (int j = 0; j < 20; j++)
            {
                System.out.print(grid[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private static boolean hasUp(int i, int j)
    {
        return i - 3 >= 0;
    }

    private static boolean hasDown(int i, int j)
    {
        return i + 3 <= 19;
    }

    private static boolean hasLeft(int i, int j)
    {
        return j - 3 >= 0;
    }

    private static boolean hasRight(int i, int j)
    {
        return j + 3 <= 19;
    }

    private static boolean hasDiagonallyLeft(int i, int j)
    {
        return hasLeft(i, j) && hasDown(i, j);
    }

    private static boolean hasDiagonallyRight(int i, int j)
    {
        return hasDown(i,j) && hasRight(i,j);
    }

    private static int multiplyUp(int i, int j)
    {
        if (hasUp(i, j))
        {
            return grid[i][j] * grid[i - 1][j] * grid[i - 2][j] * grid[i - 3][j];
        } else return 0;
    }

    private static int multiplyDown(int i, int j)
    {
        if (hasDown(i, j))
        {
            return grid[i][j] * grid[i + 1][j] * grid[i + 2][j] * grid[i + 3][j];
        } else return 0;
    }

    private static int multiplyLeft(int i, int j)
    {
        if (hasLeft(i, j))
        {
            return grid[i][j] * grid[i][j - 1] * grid[i][j - 2] * grid[i][j - 3];
        } else return 0;
    }

    private static int multiplyRight(int i, int j)
    {
        if (hasRight(i, j))
        {
            return grid[i][j] * grid[i][j + 1] * grid[i][j + 2] * grid[i][j + 3];
        } else return 0;
    }

    private static int multiplyDiagonallyRight(int i, int j)
    {
        if (hasDiagonallyRight(i, j))
        {
            return grid[i][j] * grid[i + 1][j + 1] * grid[i + 2][j + 2] * grid[i + 3][j + 3];
        } else return 0;
    }

    private static int multiplyDiagonallyLeft(int i, int j)
    {
        if (hasDiagonallyLeft(i, j))
        {
            return grid[i][j] * grid[i + 1][j - 1] * grid[i + 2][j  - 2] * grid[i + 3][j - 3];
        }else return 0;
    }

    private static int findMaximum(int a, int b, int c, int d, int e, int f)
    {
        return Math.max(Math.max(Math.max(Math.max(Math.max(a, b), c), d), e), f);
    }

    private static int findMultiplication()
    {
        int lastMaximum = 0;
        for (int i = 0; i < 19; i++)
        {
            for (int j = 0; j < 19; j++)
            {
                int number = grid[i][j];
                if (number != 0)
                {
                    int a = multiplyUp(i, j);
                    int b = multiplyDown(i, j);
                    int c = multiplyLeft(i, j);
                    int d = multiplyRight(i, j);
                    int e = multiplyDiagonallyRight(i, j);
                    int f = multiplyDiagonallyLeft(i,j);
                    int currentMaximum = findMaximum(a, b, c, d, e,f);
                    if (currentMaximum >= lastMaximum)
                    {
                        lastMaximum = currentMaximum;
                    }
                }
            }
        }
        return lastMaximum;
    }

    public static void main(String[] args)
    {
        initializegrid();
        int maximum;
        maximum = findMultiplication();
        System.out.println(maximum);
    }
}
