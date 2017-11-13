package com.sap.bradesco.kcla;

import org.apache.commons.cli.*;

/**
 * Hello world!
 */
public class KclaParser {
    public static void main(String[] parameters) {

        CommandLine commandLine;
        Option option_r = Option.builder("file").required(true).desc("The file option").longOpt("opt1").build();
        Options options = new Options();
        CommandLineParser parser = new DefaultParser();

        String[] testArgs = { "-file", "opt1", };

        options.addOption(option_r);

        try {
            commandLine = parser.parse(options, parameters);

            if (commandLine.hasOption("file")) {
                System.out.print("Option file is present.  The value is: ");
                System.out.println(commandLine.getOptionValue("file"));
            }

        } catch (ParseException exception) {
            System.out.print("Parse error: ");
            System.out.println(exception.getMessage());
        }

    }
}
