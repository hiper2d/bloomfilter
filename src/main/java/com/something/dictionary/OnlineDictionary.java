package com.something.dictionary;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by alexeyzelenovsky on 8/7/15.
 */
public class OnlineDictionary extends Dictionary {

    private final String urlString;

    public OnlineDictionary(String urlString) {
        this.urlString = urlString;
    }

    @Override
    public Scanner getScanner() throws IOException {
        URL url = null;
        try {
            url = new URL(urlString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new IOException(e);
        }
        return new Scanner(url.openStream());
    }
}
