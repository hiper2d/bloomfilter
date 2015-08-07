package com.something.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by alexeyzelenovsky on 8/7/15.
 */
public class LocalDictionary extends Dictionary {

    private final File file;

    public LocalDictionary(String filePath) {
        file = new File(filePath);
    }

    public LocalDictionary(URL fileUrl) {
        file = new File(fileUrl.getPath());
    }

    @Override
    Scanner getScanner() throws IOException {
        try {
            return new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new IOException(e);
        }
    }
}
