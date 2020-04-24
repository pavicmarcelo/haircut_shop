package com.example.demo.time_services;

import com.example.demo.dto.HaircutShop;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Service
public class LocalTime {

    public long getCurrentTimeInMs() {

        Calendar calendar = Calendar.getInstance();


        long currentTime = calendar.getTimeInMillis();

        return currentTime;

    }

    public long getCurrentTime() {

        Calendar calendar = Calendar.getInstance();

        return calendar.getTimeInMillis();


    }
    public int getCurrentHours(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.HOUR_OF_DAY);

    }
    public int getCurrentMinutes(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MINUTE);

    }
    public boolean timeBiggerThenStartWorkTime(long checkHours){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(checkHours);
        cal.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        return (cal.get(Calendar.HOUR_OF_DAY)+1)  > getCurrentHours();

    }

    public boolean timeSmallerThenEndWorkTime(long checkHours){
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(checkHours);
        return (cal.get(Calendar.HOUR_OF_DAY) + 1) < getCurrentHours();
    }
}
