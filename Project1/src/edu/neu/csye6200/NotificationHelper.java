package edu.neu.csye6200;

import java.util.Calendar;
import java.util.Timer;

public class NotificationHelper {
	public static Timer timer = new Timer();
	public static void configureTask() {
		
		Thread ICT = new Thread(new ImmunizationCheckThread()) ;
		
		Calendar date = Calendar.getInstance();
		date.set(Calendar.HOUR_OF_DAY, Calendar.MINUTE);
		date.set(Calendar.HOUR, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND,0);
		
		timer.schedule(new NotifyTask(ICT), date.getTime(), 1000*60*60);
	}
	
	
	
	public static void sendMessage() {
		
		
	}
	
	
	

}
