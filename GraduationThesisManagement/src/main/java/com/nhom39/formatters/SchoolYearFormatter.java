package com.nhom39.formatters;

import com.nhom39.pojo.SchoolYear;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class SchoolYearFormatter implements Formatter<SchoolYear> {
    @Override
    public SchoolYear parse(String schoolYearId, Locale locale) throws ParseException {
        SchoolYear schoolYear = new SchoolYear();
        schoolYear.setId(Integer.parseInt(schoolYearId));

        return schoolYear;
    }

    @Override
    public String print(SchoolYear schoolYear, Locale locale) {
        return String.valueOf(schoolYear.getId());
    }
}
