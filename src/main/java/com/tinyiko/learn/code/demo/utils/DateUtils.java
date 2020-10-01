package com.tinyiko.learn.code.demo.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyy-m-dd");

    public static Date createDateFromDateSting(String dateString){
        Date date = null;
        if(null != dateString){
            try{
                date = DATE_FORMAT.parse(dateString);
            }catch (ParseException pe){
               date = new Date();
            }
        }else{ // allowing date to be a valid date or null
            date = new Date();
        }
        return date;
    }

}
