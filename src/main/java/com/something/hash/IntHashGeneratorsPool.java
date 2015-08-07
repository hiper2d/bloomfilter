package com.something.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexeyzelenovsky on 8/7/15.
 */
public class IntHashGeneratorsPool {

    private List<IntHashGenerator> intHashGeneratorsList;

    public IntHashGeneratorsPool(Integer bitmapSize, Integer generatorAmount) {
        createListOfIntHashGenerators(bitmapSize, generatorAmount);
    }

    public List<IntHashGenerator> getIntHashGeneratorsList() {
        return intHashGeneratorsList;
    }

    private void createListOfIntHashGenerators(Integer bitmapSize, Integer generatorAmount) {
        intHashGeneratorsList = new ArrayList<>();
        for(int i=0; i<generatorAmount; i++) {
            byte[] randomSalt = SaltGenerator .generate();
            intHashGeneratorsList.add(new IntHashGenerator(bitmapSize, randomSalt));
        }
    }
}
