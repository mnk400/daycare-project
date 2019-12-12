package edu.neu.csye6200;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class NotificationHelper {
	public static Timer timer = new Timer();
	public static void configureTask() {
		
		//Thread ICT = new Thread(new ImmunizationCheckThread()) ;
		
		Calendar date = Calendar.getInstance();
		date.set(Calendar.HOUR_OF_DAY, Calendar.MINUTE);
		date.set(Calendar.HOUR, 00);
		date.set(Calendar.MINUTE, 20);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND,0);
		
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());
		timer.schedule(new NotifyTask(), date.getTime(), TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS));
		System.out.println(date.getTime());
		
	}
	
	
	
public static void configureTask(Date d) {
		Calendar avr = Calendar.getInstance();
		avr.setTime(d);
		//Thread ICT = new Thread(new ImmunizationCheckThread()) ;
		
//		Calendar date = Calendar.getInstance();
//		date.set(Calendar.HOUR_OF_DAY, Calendar.MINUTE);
//		date.set(Calendar.HOUR, 6);
//		date.set(Calendar.MINUTE, 56);
//		date.set(Calendar.SECOND, 0);
//		date.set(Calendar.MILLISECOND,0);
//		date.set(Calendar.MONTH, avr.);
		//date.set(Calendar.MONTH  
		
		avr.set(Calendar.HOUR, 9);
		avr.set(Calendar.MINUTE, 45);
		avr.set(Calendar.SECOND, 0);
		avr.set(Calendar.MILLISECOND,0);
		Calendar c = Calendar.getInstance();
		
		System.out.println(c.getTime());
		timer.schedule(new NotifyTask(), avr.getTime(), TimeUnit.MILLISECONDS.convert(365, TimeUnit.DAYS));
		System.out.println(avr.getTime());
		
	}
	
	

}
