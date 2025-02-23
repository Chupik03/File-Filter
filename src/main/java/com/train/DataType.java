package com.train;

public class DataType {
    public static boolean isInteger(String str){
        try{
            Integer.parseInt(str);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    public static boolean isFloat(String str){
        try{
            Float.parseFloat(str);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
}
