package com.something;

import com.something.console.CommandLineHandler;
import com.something.dictionary.Dictionary;
import com.something.dictionary.OnlineDictionary;
import com.something.hash.IntHashGenerator;
import com.something.hash.SaltGenerator;
import org.apache.log4j.Logger;

/**
 * Created by alexeyzelenovsky on 8/4/15.
 */
public class Main {

    private final static Logger logger = Logger.getLogger(Main.class);
    public static final String ONLINE_DICTIONARY_LINK = "http://codekata.com/data/wordlist.txt";
    public static final String LOCAL_DICTIONARY_PATH = "\\usr\\share\\dict\\words";

    public static void main(String[] args) {
        new Main().begin();
    }

    private void begin() {
        Dictionary dictionary = new OnlineDictionary(ONLINE_DICTIONARY_LINK);
        CommandLineHandler commandLine = new CommandLineHandler(dictionary);
        try {
            commandLine.startProgram();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
    }

    @Deprecated
    private void printHello() {
        IntHashGenerator generator = new IntHashGenerator(100, SaltGenerator.generate());
        System.out.println(generator.generateIntHash("asdasdsadad"));
        System.out.println(generator.generateIntHash("asdasdsadad123"));
        System.out.println(generator.generateIntHash("asdasdsadad2"));
        System.out.println(generator.generateIntHash("asdasdsadadd2"));
        System.out.println(generator.generateIntHash("asdasdsa123dad2"));
        System.out.println(generator.generateIntHash("asdasqewqdsadad26"));
        System.out.println(generator.generateIntHash("asdasqewqdsadad26"));
    }
}
