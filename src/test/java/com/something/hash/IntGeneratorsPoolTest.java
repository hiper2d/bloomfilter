package com.something.hash;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alexeyzelenovsky on 8/7/15.
 */
public class IntGeneratorsPoolTest {

    public static final int DEFAULT_BITMAP_SIZE = 1_000_000;
    public static final int DEFAULT_HASH_FUNCTIONS_AMOUNT = 10;

    private IntHashGeneratorsPool pool;

    @Before
    public void init() {
        pool = new IntHashGeneratorsPool(DEFAULT_BITMAP_SIZE, DEFAULT_HASH_FUNCTIONS_AMOUNT);
    }

    @Test
    public void validateAmountOfHashesInPool() {
        assertEquals(pool.getIntHashGeneratorsList().size(), DEFAULT_HASH_FUNCTIONS_AMOUNT);
    }

}