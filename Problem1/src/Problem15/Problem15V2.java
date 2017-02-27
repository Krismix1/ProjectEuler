package Problem15;

/**
 * Created by Chris on 23.01.2017.
 */

/**
 * Where Ti is the total routes of a ixi grid
 * T1 ----> (1) * 2
 * T2 ----> (1 + T1) * 2
 * T3 ----> (2 + T1 + T2) * 2
 * T4 ----> (5 + 2T1 + T2 + T3) * 2
 * T5 ----> (14 + 5T1 + 2T2 + T3 + T4) * 2
 * T(i) = (C(i)*T(0)+...+C(0)*T(i))
 * Where C(i) represents the Catalan Number
 */
public class Problem15V2
{

}

/*

static void Main(string[] args)
        {
            int x = 20;
            long y = 1;
            for (int i = 0; i < x; i++)
            {
                y = y * ((2 * x) - i);
                y = y / (i + 1);
            }
            Console.Write(y);
            Console.ReadLine();
        }

class Program
{
    static void Main(string[] args)
    {

        Console.WriteLine( Program.LatticePaths(20, 20));

    }//end of main

    public static Int64 LatticePaths(int rows, int columns)
    {
        Int64[,] paths = new Int64[rows + 1, columns + 1];

        for (int row = 0; row <= rows; row++)
        {
            for (int column = 0; column <= columns; column++)
            {
                if (row == 0 || column == 0)
                    paths[row, column] = 1;
                else
                    paths[row, column] = paths[row - 1, column] + paths[row, column - 1];
            }
        }

        return paths[rows, columns];
    }

}

Pascal's triangle can solve this problem as well:
class Program
{
    static void Main(string[] args)
    {
        long row = 40, col = 40;
        long[,] p = new long[row, col];
        p[0, 0] = 1;
        p[0, 1] = 1;

        for (int i = 1; i < row; i++)
        {
            for (int j = 0; j <= i+1; j++)
            {
                if (j > row-1) break;
                if (j == 0)
                {
                    p[i, j] = 1;

                }
                else
                    p[i, j] = p[i - 1, j] + p[i - 1, j - 1];
            }

        }

        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < col; j++)
            {
                if(p[i, j]>0)Console.WriteLine(p[i, j]);
            }
            Console.WriteLine("");
        }
    }
}

ruby

require "memoize.rb"

def find_routes(x, y)
	routes = 0
	if y > 0
		routes+=find_routes(x, y - 1)
	end
	if x > 0
		routes+=find_routes(x - 1, y)
	end
	if x == 0 && y == 0
		routes+=1
	end
	routes
end
memoize :find_routes
t = Time.now
p find_routes(20, 20)
t = Time.now - t
p "elapsed time: %.2f" % t

// Note: this code isn't currently generalized but doing so wouldn't be too difficult.
#include <stdio.h>

int size = 20;

int main(void)
{
	//used long long to avoid overflow
	long long int grid [size][size];

	//initialization -- filling first rows with their respective numbers
	int i, j;
	for (i = 0; i < size; i++)
	{
		grid[0][i] = i + 2;
		grid[i][0] = i + 2;
	}

	//Filling in the rest of the grid
	for (i = 1; i < size; i++)
	{
		for (j = 1; j < size; j++)
		{
			grid [i][j] = grid[i][j-1] + grid[i-1][j];
		}
	}

	printf("The number of paths for a %dX%d grid is %lld\n", size, size, grid[size-1][size-1]);

	return 0;
}

*/
