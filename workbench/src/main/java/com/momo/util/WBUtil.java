package com.momo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class WBUtil {
    public static final String SIMPLE_DATE_PATTERN = "dd/MM/yyyy";

    public static Date parseDate(String srcDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(SIMPLE_DATE_PATTERN);
        Date date = null;
        LocalDate localDate = LocalDate.now();
        try {
            date = formatter.parse(srcDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
