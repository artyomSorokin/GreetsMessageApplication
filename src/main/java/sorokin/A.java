package sorokin;


import sun.util.calendar.LocalGregorianCalendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class A {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        LocalTime localTime = LocalTime.now();

        Date da = simpleDateFormat.parse("06:00:00");

        LocalTime date5 = LocalTime.parse("23:00:00");
        LocalTime date4 = LocalTime.parse("23:00:00");
        System.out.println(date4.equals(date5));


    }
}
