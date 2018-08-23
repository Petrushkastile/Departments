package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateParser {

    public static Date parseDate(String dateBirth) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern( "dd.MM.yyyy" );
        return format.parse( dateBirth );
    }
}
