package com.train;
import java.util.*;
public class Statistics {
    private static String[] integerStat = {"0", null, null, "0", "0"};
    private static String[] floatStat = {"0", null, null, "0", "0"};
    private static String[] stringStat = {"0", null, null};
    static void displayBriefStatistics(){
        System.out.println("Number of Integers: " + integerStat[0]);
        System.out.println("Number of Floats: " + floatStat[0]);
        System.out.println("Number of Strings: " + stringStat[0]);
    }

    static void displayFullStatistics(){

        System.out.println("Integers");
        System.out.println("\tNumber of integers: " + integerStat[0]);
        System.out.println("\tMax element: " + integerStat[1]);
        System.out.println("\tMin element: " + integerStat[2]);
        System.out.println("\tSum: " + integerStat[3]);
        System.out.println("\tMean value: " + integerStat[4]);

        System.out.println("Floats");
        System.out.println("\tNumber of floats: " + floatStat[0]);
        System.out.println("\tMax element: " + floatStat[1]);
        System.out.println("\tMin element: " + floatStat[2]);
        System.out.println("\tSum: " + floatStat[3]);
        System.out.println("\tMean value: " + floatStat[4]);

        System.out.println("Strings");
        System.out.println("\tNumber of strings: " + stringStat[0]);
        System.out.println("\tLongest element: " + stringStat[1]);
        System.out.println("\tShortest length: " + stringStat[2]);

    }

    static void collectStatisticsInteger(ArrayList<Integer> integers){

        int max = Collections.max(integers);
        int min = Collections.min(integers);

        integerStat[0] = String.valueOf(Integer.parseInt(integerStat[0]) + integers.size());

        if(integerStat[1] != null){
            integerStat[1] = max > Integer.parseInt(integerStat[1]) ? String.valueOf(max) : integerStat[1];
        }
        else integerStat[1] = String.valueOf(max);

        if(integerStat[2] != null){
            integerStat[2] = min < Integer.parseInt(integerStat[2]) ? String.valueOf(min) : integerStat[2];
        }
        else integerStat[2] = String.valueOf(min);

        integerStat[3] =  String.valueOf(Integer.parseInt(integerStat[3]) + sumInt(integers));

        integerStat[4] = String.valueOf(Float.parseFloat(integerStat[3]) / Integer.parseInt(integerStat[0]));
    }

    static void collectStatisticsFloat(ArrayList<Float> floats){

        float max = Collections.max(floats);
        float min = Collections.min(floats);

        floatStat[0] = String.valueOf(Integer.parseInt(floatStat[0]) + floats.size());

        if(floatStat[1] != null){
            floatStat[1] = max > Float.parseFloat(floatStat[1]) ? String.valueOf(max) : floatStat[1];
        }
        else floatStat[1] = String.valueOf(max);

        if(floatStat[2] != null){
            floatStat[2] = min < Float.parseFloat(floatStat[2]) ? String.valueOf(min) : floatStat[2];
        }
        else floatStat[2] = String.valueOf(min);

        floatStat[3] =  String.valueOf(Float.parseFloat(floatStat[3]) + sumFloat(floats));

        floatStat[4] = String.valueOf(Float.parseFloat(floatStat[3]) / Float.parseFloat(floatStat[0]));
    }

    static void collectStatisticsString(ArrayList<String> strings){

//        Sorting
        Collections.sort(strings, Comparator.comparing(String::length));

        int shortestString = strings.getFirst().length();
        int longestString = strings.getLast().length();

        stringStat[0] = String.valueOf(Integer.parseInt(stringStat[0]) + strings.size());
        if(stringStat[1] != null){
            stringStat[1] = longestString > Integer.parseInt(stringStat[1]) ? String.valueOf(longestString) : stringStat[1];
        }
        else stringStat[1] = String.valueOf(longestString);

        if(stringStat[2] != null){
            stringStat[2] = shortestString < Integer.parseInt(stringStat[2]) ? String.valueOf(shortestString) : stringStat[2];
        }
        else stringStat[2] = String.valueOf(shortestString);

    }

    private static int sumInt(ArrayList<Integer> integers){

        if(integers.isEmpty()) return 0;

        int sum = 0;
        for(int el : integers){
            sum += el;
        }
        return sum;
    }
    private static float sumFloat(ArrayList<Float> floats){

        if(floats.isEmpty()) return 0;

        float sum = 0;
        for(float el : floats){
            sum += el;
        }
        return sum;
    }

}
