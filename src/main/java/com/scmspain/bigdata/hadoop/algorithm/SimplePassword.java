package com.scmspain.bigdata.hadoop.algorithm;

import org.jasypt.util.text.StrongTextEncryptor;

public class SimplePassword implements EncryptionAlgorithm
{
    private String password;
    private String salt;

    public SimplePassword(String password, String salt)
    {
        this.password = password;
        this.salt = salt;
    }

    @Override
    public byte[] generatePassword() throws RuntimeException
    {
        StrongTextEncryptor textEncryptor = new StrongTextEncryptor();
        textEncryptor.setPassword(salt);

        return textEncryptor.encrypt(this.password).getBytes();
    }
}
