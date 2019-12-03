package edu.neu.csye6200;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
	

}
