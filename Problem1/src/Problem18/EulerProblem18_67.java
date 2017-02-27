package Problem18;

/**
        \* Copyright (c) 2010-2020 Malkit S. Bhasin. All rights reserved.
        \*
        \* All source code and material on this Blog site is the copyright of Malkit S.
        \* Bhasin, 2010 and is protected under copyright laws of the United States. This
        \* source code may not be hosted on any other site without my express, prior,
        \* written permission. Application to host any of the material elsewhere can be
        \* made by contacting me at mbhasin at gmail dot com
        \*
        \* I have made every effort and taken great care in making sure that the source
        \* code and other content included on my web site is technically accurate, but I
        \* disclaim any and all responsibility for any loss, damage or destruction of
        \* data or any other property which may arise from relying on it. I will in no
        \* case be liable for any monetary damages arising from such loss, damage or
        \* destruction.
        \*
        \* I further grant you ("Licensee") a non-exclusive, royalty free, license to
        \* use, modify and redistribute this software in source and binary code form,
        \* provided that i) this copyright notice and license appear on all copies of
        \* the software;
        \*
        \* As with any code, ensure to test this code in a development environment
        \* before attempting to run it in production.
        \*
        \* @author Malkit S. Bhasin
        \*
        \*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class EulerProblem18_67 {

    /*
     * the logic is that starting from second last row, find the max
     * of two adjacent values (of next row that) can be reached. Once we find the max,
     * for each item of the row, add the max value to the row value. This will
     * eliminate the last row.
     * Now, we can work our way backwards, i.e to the top. Note that as we move
     * upwards the triangles, the number of rows reduces, till we reach the top.
     * Once we reach 2nd row from top, adding the top value to the max of two values,
     * of the 2nd row, we get our answer.
     */
    private static void findMax(int[][] triangle, int depth) {
        int[] previous = null;
        for(int i = 1; i < depth; i++) {
            int[] last = triangle[depth - i];
            previous = calculateRowMaximal(triangle[(depth - i) - 1], last);
            //printValues(previous);
        }
        System.out.println("result = " + previous[0]);
    }

    private static int[] calculateRowMaximal(int[] previous, int[] last) {
        for (int i = 0; i < previous.length; i++) {
            previous[i] = previous[i] + (Math.max(last[i], last[i + 1]));
        }
        return previous;
    }

    private static void printValues(int[] values) {
        System.out.println();
        for (int i : values) {
            System.out.print("\t" + i);
        }
    }

    private static int[][] getTriangle(String fileName, int depth) throws Exception {
        int[][] triangle = new int[depth][];
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        String s;
        int i = 0;
        while ((s = br.readLine()) != null) {
            triangle[i] = new int[i + 1];
            int j = 0;
            Scanner tokens = new Scanner(s);
            while (tokens.hasNext()) {
                int value = tokens.nextInt();
                triangle[i][j++] = value;
            }
            i++;
        }

        return triangle;
    }

    public static void main(String args[]) throws Throwable {
        String fileName = "Problem18.txt";
        int depth = 15;
        int[][] triangle = getTriangle(fileName, depth);
        //System.out.println(Arrays.deepToString(triangle));
        findMax(triangle, depth);
    }
}
