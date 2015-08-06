package com.something.hash;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

/**
 * Created by alexeyzelenovsky on 8/5/15.
 */
public class SaltGenerator {
    public static final int DEFAULT_LENGTH = 10;

    public static byte[] generate(Integer length) {
        byte[] byteSalt = new byte[length];
        Random r = new SecureRandom();
        r.nextBytes(byteSalt);
        return byteSalt;
        //return Base64.encodeBase64String(byteSalt);
    }

    public static byte[] generate() {
        return generate(DEFAULT_LENGTH);
    }
}
