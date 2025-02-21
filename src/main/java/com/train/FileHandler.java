package com.train;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {

    private ArrayList<Integer> integers = new ArrayList<Integer>();
    private ArrayList<Float> floats = new ArrayList<Float>();
    private ArrayList<String> strings = new ArrayList<String>();

    public ArrayList<Integer> getIntegers(){
        return integers;
    }
    public ArrayList<String> getStrings(){
        return strings;
    }
    public ArrayList<Float> getFloats(){
        return floats;
    }
    public void readFile(String path){
        try (BufferedReader bis = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = bis.readLine()) != null){
                if (DataType.isInteger(line)){

                    integers.add(Integer.parseInt(line));

                } else if (DataType.isFloat(line)) {

                    floats.add(Float.parseFloat(line));

                } else if (!line.isEmpty()){
                    strings.add(line);
                }
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void writeToFile(String path, String prefix, boolean append){
        write(integers, path + prefix + "integers.txt", append);
        write(floats, path  + prefix + "floats.txt", append);
        write(strings, path  + prefix + "strings.txt", append);

    }

    private void write(ArrayList<?> list, String path, boolean append){
        if(!list.isEmpty()){
            try(BufferedWriter bf = new BufferedWriter(new java.io.FileWriter(path, append))) {
                for(int i = 0; i < list.size(); i++){
                    bf.write(list.get(i).toString());
                    bf.write("\n");
                }
            }
            catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
    }

}
