package com.ncr.test.pyramid.solver;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.data.PyramidGenerator;
import com.ncr.test.pyramid.data.impl.RandomPyramidGenerator;
import com.ncr.test.pyramid.solver.impl.YourSolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(JUnit4.class)
public class YourSolverTest {
    private static final int MAX_DEPTH = 100;

    private static final int[][] SAMPLE_DATA = {
            { 5, 9, 8, 4 },
            { 6, 4, 5, 0 },
            { 6, 7, 0, 0 },
            { 3, 0, 0, 0 }
    };
    private static final int[][] DEMO_DATA = {
            { 59, 207, 98, 95 },
            { 87,   1, 70,  0 },
            { 36,  41,  0,  0 },
            { 23,   0,  0,  0 }
    };

    protected PyramidSolver solver;

    @BeforeEach
    public void setUp() {
        solver = new YourSolver();
    }

    @Test
    public void solverHandlesSampleData() {
        Pyramid pyramid = new Pyramid(SAMPLE_DATA);
        long maxFromMySolver = solver.pyramidMaximumTotal(pyramid);
        System.out.println("Max Value from My Solver = " + maxFromMySolver);
        assertEquals( 24, maxFromMySolver);
    }

    @Test
    public void solverHandlesDemoData() {
        Pyramid pyramid = new Pyramid(DEMO_DATA);
        long maxFromMySolver = solver.pyramidMaximumTotal(pyramid);
        System.out.println("Max Value from My Solver = " + maxFromMySolver);
        assertEquals( 353, maxFromMySolver);
    }

    @Test
    public void solverSurvivesLargeData() {
        PyramidGenerator generator = new RandomPyramidGenerator(MAX_DEPTH, 1000);
        Pyramid pyramid = generator.generatePyramid();
        assertTrue( solver.pyramidMaximumTotal(pyramid) > 0L);
    }

    @Test
    public void solverHandlesRandomData() {
        RandomPyramidGenerator.setRandSeed(25321L);  // ensure pyramid contents
        final PyramidGenerator generator = new RandomPyramidGenerator(5, 99);
        final Pyramid pyramid = generator.generatePyramid();

        long maxFromMySolver = solver.pyramidMaximumTotal(pyramid);
        System.out.println("Max Value from My Solver = " + maxFromMySolver);

        assertEquals( 398, maxFromMySolver);
    }
}
