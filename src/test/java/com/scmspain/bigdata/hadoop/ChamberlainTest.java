package com.scmspain.bigdata.hadoop;

import org.junit.Before;
import org.junit.Test;

public class ChamberlainTest
{
    private Chamberlain chamberlain;

    @Before
    public void setUp()
    {
        chamberlain = new Chamberlain();
    }

    @Test(expected=IllegalArgumentException.class)
    public void testEncrypterThrowsExceptionWhenMissingParams() throws Exception
    {
        String[] args = new String[2];
        args[0] = "--filename";
        args[1] = "password.pwd";

        chamberlain.main(args);
    }
}