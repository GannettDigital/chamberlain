package com.scmspain.bigdata.hadoop.algorithm;

import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface EncryptionAlgorithm
{
    public byte[] generatePassword() throws RuntimeException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException;
}