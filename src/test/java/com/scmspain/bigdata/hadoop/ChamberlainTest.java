package com.scmspain.bigdata.hadoop;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ChamberlainTest
{
    private Chamberlain chamberlain;

    @Before
    public void setUp()
    {
        chamberlain = new Chamberlain();
    }

    @Test
    public void testEncrypterThrowsExceptionWhenMissingParams()
    {
        String[] args = new String[2];
        args[0] = "password_file.pwd";
        args[1] = "Passw0rd";

        try {
            chamberlain.main(args);
            fail("Expected an IOException to be thrown");
        } catch (Exception exception) {
            assertThat(exception.getMessage(), is("Incorrect number of parameters, usage is:\n" +
                    "java EncryptedPasswordGenerator filename password passphrase salt"));
        }
    }
}