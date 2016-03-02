package com.scmspain.bigdata.hadoop.algorithm;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

public class Sqoop implements EncryptionAlgorithm
{
    private static final String SECRET_KEY_FACTORY = "PBKDF2WithHmacSHA1";
    private static final Integer ITERATIONS = 10000;
    private static final Integer KEY_LENGTH = 128;

    private static final String ALGORITHM = "AES/ECB/PKCS5Padding";

    private String password;
    private String passphrase;
    private String salt;

    public Sqoop(String password, String passphrase, String salt)
    {
        this.password = password;
        this.passphrase = passphrase;
        this.salt = salt;
    }

    @Override
    public byte[] generatePassword() throws RuntimeException
    {
        String algOnly = ALGORITHM.split("/")[0];
        byte[] encryptedBytes;
        SecretKeyFactory factory = null;
        SecretKeySpec key = null;
        Cipher crypto = null;

        try {
            factory = SecretKeyFactory.getInstance(SECRET_KEY_FACTORY);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Can't load SecretKeyFactory", e);
        }

        try {
            key = new SecretKeySpec(
                    factory.generateSecret(
                            new PBEKeySpec(
                                    passphrase.toCharArray(),
                                    salt.getBytes(),
                                    ITERATIONS,
                                    KEY_LENGTH
                            )
                    ).getEncoded(),
                    algOnly
            );
        } catch (Exception e) {
            throw new RuntimeException("Can't generate secret key", e);
        }

        try {
            crypto = Cipher.getInstance(ALGORITHM);
        } catch (Exception e) {
            throw new RuntimeException("Can't initialize the cipher", e);
        }

        try {
            crypto.init(Cipher.ENCRYPT_MODE, key);
            encryptedBytes = crypto.doFinal(password.getBytes());
        } catch (Exception e) {
            throw new RuntimeException("Can't encrypt the password", e);
        }

        return encryptedBytes;
    }
}
