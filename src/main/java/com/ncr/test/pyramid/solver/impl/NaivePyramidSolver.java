package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

/**
 * TASK: There is something wrong here. A few things actually...
 *
 * Harendra Singh -Please see my below comments.
 *
 * 1. When the row is 0, it was returning 0 - This shouldn't be done. When we have reached end, it should have returned the element at that pos.
 * 2. Time complexity is 2^n (For each entry - we are exploring two paths) - Exponential and some results are recalculated several times. It can give time exceeded for large values of the number of rows.
 * 3. Should have used dynamic programming approach rather than using only recursion to speed up the program.
 */
public class NaivePyramidSolver implements PyramidSolver {
    @Override
    public long pyramidMaximumTotal(Pyramid pyramid) {
        return getTotalAbove(pyramid.getRows() - 1, 0, pyramid);
    }

    private long getTotalAbove(int row, int column, Pyramid pyramid) {
        if (row == 0) return 0; // Fix should be --> pyramid.get(row, column);

        int myValue = pyramid.get(row, column);
        long left  = myValue + getTotalAbove(row - 1, column, pyramid);
        long right = myValue + getTotalAbove(row - 1, column + 1, pyramid);
        return Math.max(left, right);
    }
}