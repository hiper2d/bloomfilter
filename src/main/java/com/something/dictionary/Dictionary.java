package com.something.dictionary;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

/**
 * Created by alexeyzelenovsky on 8/7/15.
 */
public abstract class Dictionary {
    abstract Scanner getScanner() throws IOException;
}
