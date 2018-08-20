package service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateParser {
    public static Date parseDate(String dateBirth) {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern( "dd.MM.yyyy" );
        Date date = null;
        try {
            date = format.parse( dateBirth );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    public static String parsesql(Date date){
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        String birth = formatter.format(date);
        return birth;
    }

}
