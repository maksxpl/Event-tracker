package com.nukeops.other;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Time {

    public static String current(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static String difference(String[] eventHours) {
        // String[] eventHours = {"17:00:00","20:00:00","22:00:00"};
        List<String> timeLeft = new ArrayList<>();

        for (String eventHour : eventHours) {
            String toAdd = until(eventHour);
            timeLeft.add(toAdd);
        }
        return timeLeft.get(0);
    }

    public static String until(String time) {
        String returnMsg = null;
        try {
            SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
            Date now = new Date();
            java.text.DateFormat df = new java.text.SimpleDateFormat("HH:mm:ss");
            Date date1 = df.parse(sdfDate.format(now));
            Date date2 = df.parse(time);
            long diff = date2.getTime() - date1.getTime();
            int timeInSeconds = (int) (diff / 1000);
            int preHours, preMinutes;

            preHours = timeInSeconds / 3600;
            timeInSeconds = timeInSeconds - (preHours * 3600);
            preMinutes = timeInSeconds / 60;

            String hours;
            String minutes;
            // if(preHours < 10){
            //     hours = "0"+preHours;
            // }else{hours = String.valueOf(preHours);}
            // if(preMinutes < 10){
            //     minutes = "0"+preMinutes;
            // }else{minutes = String.valueOf(preMinutes);}
            hours = String.valueOf(preHours);
            minutes = String.valueOf(preMinutes);


            if (preHours != 0) {
                returnMsg = hours+":"+minutes;
            } else {
                returnMsg = minutes+"m";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnMsg;
    }
}
