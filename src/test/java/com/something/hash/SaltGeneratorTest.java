package com.something.hash;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by alexeyzelenovsky on 8/5/15.
 */
public class SaltGeneratorTest {

    @Test
    public void compareTwoGeneratedSalts() throws Exception {
        byte[] salt1 = SaltGenerator.generate();
        byte[] salt2 = SaltGenerator.generate();
        assertNotEquals(salt1, salt2);
    }
}