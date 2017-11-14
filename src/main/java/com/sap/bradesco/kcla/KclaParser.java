package com.sap.bradesco.kcla;

import org.apache.commons.cli.*;

import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 */
public class KclaParser {

    public static void main(String[] args) {
        String filename;
        List<KclaBean> parsedFile;
        try {
            filename = readArgument(args);
            Processor processor = new Processor();
            parsedFile = processor.parseToKclaBean(filename);
            System.out.println("File size: " + parsedFile.size());

            List<Set<KclaBean>> fileBreakdown = processor.clearLocks(parsedFile);

            int i = 1;
            for(Set<KclaBean> breakdown: fileBreakdown){
                System.out.println("File: " + i + " - " + breakdown.size() + " records");
                i++;
            }

        } catch (ParseException | IOException exception) {
            System.out.print("Parse error: ");
            System.out.println(exception.getMessage());
        }
    }

    private static String readArgument(String[] args) throws ParseException {
        CommandLine commandLine;
        CommandLineParser parser = new DefaultParser();

        Options options = new Options();
        Option fileOption = new Option("file", (String) null, true, "KCLA file path");
        fileOption.setRequired(true);
        options.addOption(fileOption);

        commandLine = parser.parse(options, args);
        return commandLine.getOptionValue("file");
    }

}
