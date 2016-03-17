package com.scmspain.bigdata.hadoop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArgumentsTest
{
    private static final String ARG_FILENAME = "password.pwd";
    private static final String ARG_PASSWORD = "t3sTp@ss";
    private static final String ARG_PASSPHRASE = "p4sSphrase";
    private static final String ARG_SALT = "s4lT";
    private static final String ARG_ALGORITHM = "algorithm";

    Arguments arguments;

    @Before
    public void setUp() throws Exception
    {
        String[] args = new String[10];
        args[0] = "--filename";
        args[1] = ARG_FILENAME;
        args[2] = "--password";
        args[3] = ARG_PASSWORD;
        args[4] = "--passphrase";
        args[5] = ARG_PASSPHRASE;
        args[6] = "--salt";
        args[7] = ARG_SALT;
        args[8] = "--algorithm";
        args[9] = ARG_ALGORITHM;

        arguments = new Arguments(args);
    }

    @After
    public void tearDown()
    {
        arguments = null;
    }

    @Test
    public void testGetArgFilename() throws Exception
    {
        assertEquals(
                "Get the filename provided",
                ARG_FILENAME,
                arguments.getArgFilename()
        );
    }

    @Test
    public void testArgGetPassword() throws Exception
    {
        assertEquals(
                "Get the password provided",
                ARG_PASSWORD,
                arguments.getArgPassword()
        );
    }

    @Test
    public void testGetArgPassphrase() throws Exception
    {
        assertEquals(
                "Get the passphrase provided",
                ARG_PASSPHRASE,
                arguments.getArgPassphrase()
        );
    }

    @Test
    public void testGetArgSalt() throws Exception
    {
        assertEquals(
                "Get the salt provided",
                ARG_SALT,
                arguments.getArgSalt()
        );
    }

    @Test
    public void testGetAlgorithm() throws Exception
    {
        assertEquals(
                "Get the algorithm provided",
                ARG_ALGORITHM,
                arguments.getArgAlgorithm()
        );
    }
}