package com.something.hash;

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

    private byte[] salt;
    private Integer size;
    private MessageDigest digest;

    public IntHashGenerator(Integer size, byte[] salt, String algorithm) throws NoSuchAlgorithmException {
        this.salt = salt;
        this.size = size;
        digest = MessageDigest.getInstance(algorithm);
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
