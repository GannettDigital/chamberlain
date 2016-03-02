package com.scmspain.bigdata.hadoop;

import com.scmspain.bigdata.hadoop.algorithm.EncryptionAlgorithm;
import com.scmspain.bigdata.hadoop.algorithm.SimplePassword;
import com.scmspain.bigdata.hadoop.algorithm.Sqoop;

import java.io.File;
import java.io.FileOutputStream;

public class Chamberlain
{
    public static void main(String[] args) throws Exception
    {
        Arguments arguments = new Arguments(args);
        EncryptionAlgorithm algorithm;

        switch (arguments.getArgAlgorithm()) {
            case "password":
                algorithm = new SimplePassword(
                        arguments.getArgPassword(),
                        arguments.getArgSalt()
                );
                break;
            default:
                algorithm = new Sqoop(
                        arguments.getArgPassword(),
                        arguments.getArgPassphrase(),
                        arguments.getArgSalt()
                );
                break;
        }

        byte[] password = algorithm.generatePassword();
        if (arguments.getArgFilename().equals("")) {
            System.out.println("Encrypted password: " + new String(password));
        } else {
            FileOutputStream output = new FileOutputStream(new File(arguments.getArgFilename()));
            output.write(password);
            output.close();
        }
    }
}
