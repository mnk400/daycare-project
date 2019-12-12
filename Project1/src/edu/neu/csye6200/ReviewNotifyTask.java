package edu.neu.csye6200;

import java.util.Calendar;
import java.util.Date;


public class ReviewNotifyTask extends Thread{

	public static void teacherReg() {
		Calendar curDate = Calendar.getInstance();
		curDate.set(Calendar.HOUR_OF_DAY, 0);
		curDate.set(Calendar.HOUR, -12);
		curDate.set(Calendar.MINUTE, 0);
		curDate.set(Calendar.SECOND, 0);
		curDate.set(Calendar.MILLISECOND,0);
		Calendar tDay = Calendar.getInstance();
		System.out.println("in teacher");
		for(Teacher s :GroupHelper.teachers) {

			tDay.setTime(s.getAnnualReviewDate());
			tDay.set(Calendar.HOUR_OF_DAY, 0);
			tDay.set(Calendar.HOUR, 0);
			tDay.set(Calendar.MINUTE, 0);
			tDay.set(Calendar.SECOND, 0);
			tDay.set(Calendar.MILLISECOND,0);
			System.out.println(tDay.getTime());
			System.out.println(curDate.getTime());
			
			if( tDay.getTime().compareTo(curDate.getTime()) == 0 ) {
				System.out.println("Re-registration required");
				Mailer m = new Mailer(s.getEmailID());
				m.setRecpName(s.getFirstName() + " " + s.getLastName());
				m.setStudName(s.getFirstName() + " " + s.getLastName());
				m.setRevDate(ConversionHelper.DateToString(s.getAnnualReviewDate()));
				
				m.sendAnnualReviewMessage();
			}

		}

	}
	public static void studentReg() {
		Calendar curDate = Calendar.getInstance();
		curDate.set(Calendar.HOUR_OF_DAY, 0);
		curDate.set(Calendar.HOUR, -12);
		curDate.set(Calendar.MINUTE, 0);
		curDate.set(Calendar.SECOND, 0);
		curDate.set(Calendar.MILLISECOND,0);
		Calendar tDay = Calendar.getInstance();
		System.out.println("in student");
		for(Student s :GroupHelper.students) {

			tDay.setTime(s.getAnnualRegistrationDate());
			tDay.set(Calendar.HOUR_OF_DAY, 0);
			tDay.set(Calendar.HOUR, 0);
			tDay.set(Calendar.MINUTE, 0);
			tDay.set(Calendar.SECOND, 0);
			tDay.set(Calendar.MILLISECOND,0);
			System.out.println(tDay.getTime());
			System.out.println(curDate.getTime());
			
			if( tDay.getTime().compareTo(curDate.getTime()) == 0 ) {
				System.out.println("Re-registration required");
	
				Mailer m = new Mailer(s.getGuardianEmail());
				m.setRecpName(s.getGuardianName());
				m.setStudName(s.getFirstName() + " " + s.getLastName());
				m.setRevDate(ConversionHelper.DateToString(s.getAnnualRegistrationDate()));
				m.setPhoneNum(s.getPhoneNumber());
				m.sendAnnualRegistrationMessage();
			}
			

		}

	}
	@Override
	public void run() {
		System.out.println("inside review thread");
		// TODO Auto-generated method stub
		try {
			ReviewNotifyTask.teacherReg();
			ReviewNotifyTask.studentReg();
			sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
