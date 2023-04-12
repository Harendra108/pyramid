package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

import java.util.Arrays;

/**
 * TASK: This is your 3rd task.
 * Please implement the class to satisfy the interface. *
 *
 * Harendra Singh
 * Implemented the recursive algo with the dynamic programming approach.
 */
public class YourSolver implements PyramidSolver {

    @Override
    public long pyramidMaximumTotal(Pyramid pyramid) {
        int rows = pyramid.getRows();
        long[][] dp = new long[rows][rows]; //This dp matrix will store the result of the computations. So that we don't need to compute the same thing again and again
        for(int i = 0; i < rows; i++) {
            Arrays.fill(dp[i], -1); // Fill all the entries with -1 initially
        }
        return getTotalMaxPath(rows - 1, 0, pyramid, dp);

    }

    private long getTotalMaxPath(int row, int column, Pyramid pyramid, long[][] dp) {
        if (row == 0) return pyramid.get(row, column);//for 1st row - there won;t be 2 choices. So just return the entry
        if(dp[row][column] != -1) {
            return dp[row][column];//No need to compute again and again
        }

        int myValue = pyramid.get(row, column);
        long left  = myValue + getTotalMaxPath(row - 1, column, pyramid, dp);
        long right = myValue + getTotalMaxPath(row - 1, column + 1, pyramid, dp);
        dp[row][column] = Math.max(left, right);

        return dp[row][column];

    }
    
}
