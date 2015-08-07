package com.something.dictionary;

import com.something.hash.IntHashGenerator;
import com.something.hash.IntHashGeneratorsPool;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by alexeyzelenovsky on 8/7/15.
 */
public class DictionaryBitmapHandler {

    private int loadingCount;
    private final Boolean[] bitmap;
    private IntHashGeneratorsPool intHashFunctionsPool;

    public DictionaryBitmapHandler(Integer bitmapSize, Dictionary dictionary, IntHashGeneratorsPool hashPool) throws IOException {
        this.intHashFunctionsPool = hashPool;
        loadingCount = 0;
        bitmap = buildBitMap(bitmapSize, dictionary);
    }

    public Boolean[] getBitmap() {
        return bitmap;
    }

    public boolean searchInBitmap(String word) {
        Integer hash;
        for(IntHashGenerator generator : intHashFunctionsPool.getIntHashGeneratorsList()) {
            hash = generator.generateIntHash(word);
            if(!bitmap[hash]) {
                return false;
            }
        }
        return true;
    }

    private Boolean[] buildBitMap(Integer bitmapSize, Dictionary dictionary) throws IOException {
        Scanner dictionaryScanner = dictionary.getScanner();
        Boolean[] bitmap = new Boolean[bitmapSize];
        Arrays.fill(bitmap, Boolean.FALSE);
        loadingCount = 0;
        String word;
        System.out.printf("Scanning online dictionary");
        while(dictionaryScanner.hasNext()) {
            word = dictionaryScanner.next();
            int positionInBitmap;
            for(IntHashGenerator generator : intHashFunctionsPool.getIntHashGeneratorsList()) {
                positionInBitmap = generator.generateIntHash(word);
                bitmap[positionInBitmap] = true;
            }
            supportLoadingBar();
        }
        System.out.println();
        System.out.println("A bitmap was built.");
        return bitmap;
    }

    private void supportLoadingBar() {
        if(loadingCount++ % 10_000 == 0) {
            System.out.printf(".");
        }
    }
}
