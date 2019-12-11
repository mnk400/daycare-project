package edu.neu.csye6200.immunisations;
import java.util.Date;
import java.util.List;

import edu.neu.csye6200.*;
public class PneumococcalConjugate extends AbstractImmunization {

	PneumococcalConjugate(String name, List<Date> immuDate, int age) {
		this.immunizationName = name;
		this.immuDate = immuDate;
		this.age = age;
	}
	@Override
	public void checkImmunization(Student s) {
		// TODO Auto-generated method stub
		Mailer m = new Mailer( s.getGuardianEmail());
		if(immuDate.size() < 3 && this.age >= 6 && this.age <= 8) {
			m.setVaccine(this.immunizationName);
			m.setDose("3");
			m.setStudName(s.getFirstName() + " " + s.getLastName());
			m.setRecpName(s.getGuardianName());
			m.sendImmunizationNotificationMail();
		} else if(immuDate.size() < 3 && this.age > 8) {
			m.setVaccine(this.immunizationName);
			m.setDose("3");
			m.setStudName(s.getFirstName() + " " + s.getLastName());
			m.setRecpName(s.getGuardianName());
			m.sendImmunizationWarning();
		} else if(immuDate.size() == 3 && this.age >=12 && this.age <=18) {
			m.setVaccine(this.immunizationName);
			m.setDose("4");
			m.setStudName(s.getFirstName() + " " + s.getLastName());
			m.setRecpName(s.getGuardianName());
			m.sendImmunizationNotificationMail();
		} else if(immuDate.size() == 3 && this.age >=18) {
			m.setVaccine(this.immunizationName);
			m.setDose("3");
			m.setStudName(s.getFirstName() + " " +s.getLastName());
			m.setRecpName(s.getGuardianName());
			m.sendImmunizationWarning();
		} else if(immuDate.size() < 3 && this.age >= 12) {
			m.setVaccine(this.immunizationName);
			m.setDose("3 and 4");
			m.setStudName(s.getFirstName() + " " + s.getLastName());
			m.setRecpName(s.getGuardianName());
			m.sendImmunizationWarning();
		}


	}
	
	public String printImmunization(Student s) {
		// TODO Auto-generated method stub
		if(immuDate.size() < 3 && this.age >= 6 && this.age <= 8) {
			return "Third Dose for Pneumococcal Conjucate";
		} else if(immuDate.size() < 3 && this.age > 8) {
			return "Late for third dose";
		} else if(immuDate.size() == 3 && this.age >=12 && this.age <=18) {
			return "Fourth Dose for Pneumococcal Conjucate";
		} else if(immuDate.size() == 3 && this.age >=18) {
			return "Fourth Pneumococcal Conjucate Dose overdue";
		} else if(immuDate.size() < 3 && this.age >= 12) {
			return "Third and Fourth Pneumococcal Conjucate Dose overdue";
		}
		
		return "";
		
	}

}
