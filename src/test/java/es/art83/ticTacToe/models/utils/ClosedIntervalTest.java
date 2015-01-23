package es.art83.ticTacToe.models.utils;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class ClosedIntervalTest {

    private static final int[][] ENDPOINTS = { {-5, 5}, {0, 10}, {0, 0}, {3, 97}};

    private static final ClosedInterval[] CLOSED_INTERVALS = new ClosedInterval[ENDPOINTS.length];

    @BeforeClass
    static public void initialized() {
        for (int i = 0; i < CLOSED_INTERVALS.length; i++) {
            assert ENDPOINTS.length == CLOSED_INTERVALS.length;
            CLOSED_INTERVALS[i] = new ClosedInterval(ClosedIntervalTest.ENDPOINTS[i][0],
                    ClosedIntervalTest.ENDPOINTS[i][1]);
        }
    }

    @Test
    public void testClosedIntervalIntInt() {
        for (int[] endpoints : ClosedIntervalTest.ENDPOINTS) {
            ClosedInterval closedInterval = new ClosedInterval(endpoints[0], endpoints[1]);
            assertEquals(endpoints[0], closedInterval.getMinimum());
            assertEquals(endpoints[1], closedInterval.getMaximum());
        }
    }

    @Test
    public void testIncludedPositive() {
        final int[][] VALUES = { {-5, 0, 3, 5}, {0, 7, 10}, {0}, {3, 4, 44, 96, 97}};
        assert ENDPOINTS.length == VALUES.length;
        for (int i = 0; i < CLOSED_INTERVALS.length; i++) {
            for (int j = 0; j < VALUES[i].length; j++) {
                assertTrue(CLOSED_INTERVALS[i].include(VALUES[i][j]));
            }
        }
    }

    @Test
    public void testIncludedNegative() {
        final int[][] VALUES = { {-6, 6, 66}, {-2, -1, 100}, {-1, 1}, {0, 1, 2, 98, 99, 100}};
        assert ENDPOINTS.length == VALUES.length;
        for (int i = 0; i < CLOSED_INTERVALS.length; i++) {
            for (int j = 0; j < VALUES[i].length; j++) {
                assertFalse(CLOSED_INTERVALS[i].include(VALUES[i][j]));
            }
        }
    }

}
