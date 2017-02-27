package Problem15;

import HelperClasses.MyConsole;

/**
 * Not working
 */

public class Problem15
{

    public static void main(String[] args)
    {
        solution();
    }

    public static void solution()
    {
        Problem15 obj = new Problem15();
        System.out.println(obj.countPaths());
    }

    private int columns;
    private int rows;

    public Problem15()
    {
        columns = readColumns();
        rows = readRows();
    }

    private int readColumns()
    {
        MyConsole console = new MyConsole();
        System.out.println("Enter the number of columns of the grid");
        int columns = console.readInt();
        while (columns <= 0)
        {
            System.out.println("The number of columns must be bigger than 0.");
            System.out.println("Enter the number of columns of the grid");
            columns = console.readInt();
        }
        return columns;
    }

    private int readRows()
    {
        MyConsole console = new MyConsole();
        System.out.println("Enter the number of rows of the grid");
        int rows = console.readInt();
        while (rows <= 0)
        {
            System.out.println("The number of rows must be bigger than 0.");
            System.out.println("Enter the number of rows of the grid");
            rows = console.readInt();
        }
        return rows;
    }

    public void setColumns(int columns)
    {
        this.columns = columns;
    }

    public void setRows(int rows)
    {
        this.rows = rows;
    }

    public int getColumns()
    {
        return this.columns;
    }

    public int getRows()
    {
        return this.rows;
    }

    public int tryEachPath()
    {
        int paths = 0;
        for (int i = 0; i <= rows; i++)
        {
            int tempRow = i;
            for (int j = 0; j <= columns; j++)
            {
                int tempColumn = j;
                while (tempRow <= rows)
                {
                    while (hasPathToRight(tempColumn))
                    {
                        tempColumn++;
                    }
                    paths++;
                    tempRow++;
                    tempColumn--;
                }
                tempRow = i + 1;
            }
        }
        return paths;
    }

    private boolean hasPathToRight(int column)
    {
        return column < columns;
    }

    private boolean hasPathDown(int row)
    {
        return row < rows;
    }

    private boolean hasPathUp(int row)
    {
        return row > 0;
    }

    private boolean hasPathToLeft(int column)
    {
        return column > 0;
    }

    public int countPaths()
    {
        int paths = 0;
        for (int i = 0; i <= rows; i++)
        {
            for (int j = 0; j <= columns; j++)
            {
                if (hasPathToRight(j) && hasPathDown(i))
                {
                    System.out.println(i + " " + j + " +1");
                    paths++;
                    if (hasPathUp(i) && hasPathToLeft(j))
                    {
                        System.out.println(i + " " + j  + " +2");
                        paths++;
                    }
                }
            }
        }
        return paths;
    }
}
