package com.something.hash;

import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

/**
 * Created by alexeyzelenovsky on 8/4/15.
 */
public class IntHashGenerator {

    private final static Logger logger = Logger.getLogger(IntHashGenerator.class);
    public static final String DEFAULT_HASH_ALGORITHM = "MD5";

    private byte[] salt;
    private Integer size;
    private MessageDigest digest;

    public IntHashGenerator(Integer size, byte[] salt) {
        this.salt = salt;
        this.size = size;
        try {
            digest = MessageDigest.getInstance(DEFAULT_HASH_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            // This catch will never be called as we use the MD5 algorithm which is a part of any JVM.
            logger.error("The MD5 algorithm can not be found in the current JVM with is impossible.");
            e.printStackTrace();
        }
    }

    public Integer generateIntHash(String input) {
        digest.reset();
        digest.update(salt);
        digest.update((input).getBytes(StandardCharsets.UTF_8));
        byte[] byteHash = digest.digest();
        return convertByteHashToIntegerHash(byteHash);
    }

    private Integer convertByteHashToIntegerHash(byte[] byteHash) {
        Integer hash;BigInteger bigIntHash = new BigInteger(1, byteHash);
        BigInteger bigIntSize = BigInteger.valueOf(size);
        hash = bigIntHash.mod(bigIntSize).intValue();
        return hash;
    }
}
