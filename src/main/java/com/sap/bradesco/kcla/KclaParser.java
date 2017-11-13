package com.sap.bradesco.kcla;

import org.apache.commons.cli.*;

/**
 * Hello world!
 */
public class KclaParser {
    public static void main(String[] args) {

        CommandLine commandLine;
        Options options = new Options();
        options.addOption("file", true, "country code");
        CommandLineParser parser = new DefaultParser();

        try {
            commandLine = parser.parse(options, args);


            String filename = commandLine.getOptionValue("file");
            System.out.println(filename);

        } catch (ParseException exception) {
            System.out.print("Parse error: ");
            System.out.println(exception.getMessage());
        }

    }
}
