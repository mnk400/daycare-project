package edu.neu.csye6200;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ConversionHelper {
	
	public static int StringToInt(String s) {
		int i=0;
		try {
			i = Integer.valueOf(s);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
	public static Date StringToDate(String s) {
		Date d = null;
		try {
			d = new SimpleDateFormat("dd/MM/yyyy").parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
	public static int DateToAge(Date d) { 
	    Calendar todayDate = new GregorianCalendar();
	    Calendar bday = new GregorianCalendar();
	    bday.setTime(d);
	    int yearsInBetween = todayDate.get(Calendar.YEAR) - bday.get(Calendar.YEAR);
	    int monthsDiff = todayDate.get(Calendar.MONTH) - bday.get(Calendar.MONTH);
	    int ageInMonths = yearsInBetween*12 + monthsDiff;
	    
	    return ageInMonths;
	}

}
