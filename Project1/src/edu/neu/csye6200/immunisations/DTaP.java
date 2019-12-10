package edu.neu.csye6200.immunisations;

import java.util.Date;
import java.util.List;

import edu.neu.csye6200.*;

public class DTaP extends AbstractImmunization {

	DTaP(String name, List<Date> immuDate, int age) {
		this.immunizationName = name;
		this.immuDate = immuDate;
		this.age = age;
	}
	@Override
	public void checkImmunization(Student s) {
		// TODO Auto-generated method stub
		if(immuDate.get(2) == null && this.age >= 6 && this.age <= 8) {
			System.out.println("Time for your third dose");
			Mailer m = new Mailer("daycarecsye6200pmv@gmail.com", s.getGuardianEmail());
			m.setVaccine(this.immunizationName);
			m.setDose("3");
			m.setStudName(s.getFirstName() + s.getLastName());
		} else if(immuDate.get(2) == null && this.age > 8) {
			System.out.println("You must take your third dose");
		} else if(immuDate.get(2) !=null && immuDate.get(3) == null && this.age >=15 && this.age<=18) {
			System.out.println("Time for your forth dose bru");
		} else if(immuDate.get(2) !=null && immuDate.get(3) == null && this.age >=18) {
			System.out.println("bru pls, ur late, take ur 4th dose");
		}
	}

	
}
