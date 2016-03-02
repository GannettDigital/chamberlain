package com.scmspain.bigdata.hadoop;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.util.HashMap;

class Arguments
{
    private static final String ARG_FILENAME = "filename";
    private static final String ARG_PASSWORD = "password";
    private static final String ARG_PASSPHRASE = "passphrase";
    private static final String ARG_SALT = "salt";
    private static final String ARG_ALGORITHM = "algorithm";

    private static final String DEFAULT_ALGORITHM = "sqoop";

    private String[] args;
    private HashMap<String, String> arguments = new HashMap<>();

    public Arguments(String[] args) throws Exception
    {
        this.args = args;
        parseArguments();
    }

    private void parseArguments() throws Exception
    {
        Options opt = new Options();

        opt.addOption("f", ARG_FILENAME, true, "Filename to store the password encrypted");
        opt.addOption("p", ARG_PASSWORD, true, "Password to encrypt");
        opt.addOption("h", ARG_PASSPHRASE, true, "Passphrase to encrypt the password");
        opt.addOption("s", ARG_SALT, true, "Salt to encrypt the password");
        opt.addOption("a", ARG_ALGORITHM, true, "Algorithm to encrypt the password");

        try {
            CommandLine cl = new DefaultParser().parse(opt, this.args);

            if (!cl.hasOption("p")) {
                throw new ParseException("Argument password is mandatory to run the script");
            }
            arguments.put(ARG_PASSWORD, cl.getOptionValue("p"));

            if (!cl.hasOption("s")) {
                throw new ParseException("Argument salt is mandatory to run the script");
            }
            arguments.put(ARG_SALT, cl.getOptionValue("s"));

            arguments.put(ARG_FILENAME, cl.hasOption("f") ? cl.getOptionValue("f") : "");
            arguments.put(ARG_ALGORITHM, cl.hasOption("a") ? cl.getOptionValue("a") : DEFAULT_ALGORITHM);
            arguments.put(ARG_PASSPHRASE, cl.hasOption("h") ? cl.getOptionValue("h") : "");
        } catch (ParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public String getArgFilename()
    {
        return arguments.get(ARG_FILENAME);
    }

    public String getArgPassword()
    {
        return arguments.get(ARG_PASSWORD);
    }

    public String getArgPassphrase()
    {
        return arguments.get(ARG_PASSPHRASE);
    }

    public String getArgSalt()
    {
        return arguments.get(ARG_SALT);
    }

    public String getArgAlgorithm()
    {
        return arguments.get(ARG_ALGORITHM);
    }
}
