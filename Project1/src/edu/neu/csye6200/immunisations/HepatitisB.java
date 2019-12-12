package edu.neu.csye6200.immunisations;

import java.util.Date;
import java.util.List;
import edu.neu.csye6200.*;

public class HepatitisB extends AbstractImmunization{

	HepatitisB(String name, List<Date> immuDate, int age) {
		this.immunizationName = name;
		this.immuDate = immuDate;
		this.age = age;
	}
	
	@Override
	public void checkImmunization(Student s) {
		Mailer m = new Mailer(s.getGuardianEmail());
		if(immuDate.size() < 3 && s.getAge() >= 15) {	
			System.out.println(s.getAge());
			m.setVaccine(this.immunizationName);
			m.setDose("3");
			m.setStudName(s.getFirstName() + " " + s.getLastName());
			m.setRecpName(s.getGuardianName());
			m.setPhoneNum(s.getPhoneNumber());
			m.sendImmunizationNotificationMail();
		} else if(immuDate.size() < 3 && s.getAge() >= 18) {
			m.setVaccine(this.immunizationName);
			m.setDose("3");
			m.setStudName(s.getFirstName() + " " + s.getLastName());
			m.setRecpName(s.getGuardianName());
			m.setPhoneNum(s.getPhoneNumber());
			m.sendImmunizationWarning();
		
		} 
	}
	
public String printImmunization(Student s) {
		
		if(immuDate.size() < 3 && s.getAge() >= 15) {	
			return "Due: 3rd dose of Hepatitis B";
		} else if(immuDate.size() < 3 && s.getAge() >= 18) {
			return "Overdue: 3rd dose of Hepatitis B";
		} 
		return "Hepatitis B vaccine up to date";
	}

}
