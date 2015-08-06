package com.something;

import com.something.hash.IntHashGenerator;
import com.something.hash.SaltGenerator;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by alexeyzelenovsky on 8/4/15.
 */
public class Main {
    public static final String DEFAULT_HASH_ALGORITHM = "MD5";

    public static void main(String[] args) {
        new Main().printHello();
    }

    private void printHello() {
        IntHashGenerator generator = null;
        try {
            generator = new IntHashGenerator(100, SaltGenerator.generate(), DEFAULT_HASH_ALGORITHM);
            System.out.println(generator.generateIntHash("asdasdsadad"));
            System.out.println(generator.generateIntHash("asdasdsadad123"));
            System.out.println(generator.generateIntHash("asdasdsadad2"));
            System.out.println(generator.generateIntHash("asdasdsadadd2"));
            System.out.println(generator.generateIntHash("asdasdsa123dad2"));
            System.out.println(generator.generateIntHash("asdasqewqdsadad26"));
            System.out.println(generator.generateIntHash("asdasqewqdsadad26"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
