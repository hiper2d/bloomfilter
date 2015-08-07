package com.something.hash;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

/**
 * Created by alexeyzelenovsky on 8/7/15.
 */
public class IntHashGeneratorTest {

    public static final int DEFAULT_SIZE = 1_000;

    IntHashGenerator intHashGenerator;

    @Before
    public void init() {
        byte[] randomSalt = new SaltGenerator().generate();
        intHashGenerator = new IntHashGenerator(DEFAULT_SIZE, randomSalt);
    }

    /**
     * Generates DEFAULT_SIZE hashes using one intHashGenerator and makes sure that all hashes are greater then 0 but less then DEFAULT_SIZE.
     * @throws Exception
     */
    @Test
    public void validateIntHashesRange() throws Exception {
        List<Integer> hashes = generateHashesForRandomStrings();
        assertFalse(hashes.stream().anyMatch(i -> i < 0 || i > DEFAULT_SIZE));
    }

    private List<Integer> generateHashesForRandomStrings() {
        List<Integer> hashes = new ArrayList<>();
        IntStream.range(0, DEFAULT_SIZE).forEach(i -> hashes.add(intHashGenerator.generateIntHash(UUID.randomUUID().toString())));
        return hashes;
    }
}