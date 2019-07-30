package com.example.Restaurant.utils;

public class FilterUtils {

    public static String removeLikeCharacter(String value){
        String ret = "";
        if(value.length()==0)
            return "";
        if(value.charAt(0) == '%')
            ret = value.substring(1, value.length());
        else
            ret = value;
        if(ret.length()==0)
            return "";
        if(ret.charAt(ret.length()-1) == '%'){
            ret = ret.substring(0, ret.length()-1);
        }
        return ret;
    }
}