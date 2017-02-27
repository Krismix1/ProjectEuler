package Problem24;

/**
 * Created by Cristian Betivu on 30-Jan-17.
 */

import HelperClasses.Permutation;

import java.util.Collections;
import java.util.List;

/**A permutation is an ordered arrangement of objects.
 * For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
 * If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
 * The lexicographic permutations of 0, 1 and 2 are:
 *      012   021   102   120   201   210
 *      What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
*/

public class Problem24Main
{
    public static void solution()
    {
        Permutation permutation = new Permutation("0123456789");
    }

    public static void test()
    {
        Permutation permutation = new Permutation("1323");
        permutation.permutation();
        System.out.println(permutation);
        List<String> list = permutation.getPermutationList();
        Collections.sort(list);
        System.out.println(list.toString());
    }

    public static void main(String[] args)
    {
        //solution();
        test();
    }
}
