package com.train;
import org.apache.commons.cli.*;


public class Main {
    public static void main(String[] args) {

        String PATH = "";
        String PREFIX = "";
        boolean APPEND = false;
        boolean BRIEF_STAT = false;
        boolean FULL_STAT = false;

        Options options = new Options();
        options.addOption("o", true,"File saving path");
        options.addOption("p", true,"Prefix of output file names");
        options.addOption("a", false,"Add to file");
        options.addOption("s", false,"Brief statistics");
        options.addOption("f", false,"Full statistics");

        CommandLineParser parser = new DefaultParser();

        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
            if(cmd.hasOption('o')){
                PATH = cmd.getOptionValue('o') + "/";
            }
            if(cmd.hasOption('p')){
                PREFIX = cmd.getOptionValue('p');
            }
            if(cmd.hasOption('a')){
                APPEND = true;
            }
            if(cmd.hasOption('s')){
                BRIEF_STAT = true;
            }
            if(cmd.hasOption('f')){
                FULL_STAT = true;
            }

        } catch (ParseException pe){
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp( "File Filter", options);
            System.out.println(pe.getMessage());
            System.exit(-1);
        }


        for (String file : cmd.getArgList()){

            FileHandler fh = new FileHandler();
            fh.readFile(file);
            fh.writeToFile(PATH, PREFIX, APPEND);
//           Collecting statistics
            if(!fh.getIntegers().isEmpty()){
                Statistics.collectStatisticsInteger(fh.getIntegers());
            }
            if(!fh.getFloats().isEmpty()){
                Statistics.collectStatisticsFloat(fh.getFloats());
            }
            if(!fh.getStrings().isEmpty()){
                Statistics.collectStatisticsString(fh.getStrings());
            }
//           We change it to the true, otherwise only the last one
//           will be recorded from all the files
            APPEND = true;

        }

        if(BRIEF_STAT){
            Statistics.displayBriefStatistics();
        }
        if(FULL_STAT){
            Statistics.displayFullStatistics();
        }
    }

}