package edu.neu.csye6200.immunisations;

import java.util.Date;
import java.util.List;

import edu.neu.csye6200.AbstractPerson;
import edu.neu.csye6200.Student;
import edu.neu.csye6200.StudentFactory;

public class DTaPFactory extends AbstractImmunizationFactory {

	private static DTaPFactory instance;
	private DTaPFactory() {
		instance = null;
	}
	public static DTaPFactory getInstance() {
		if(instance == null) {
			instance = new DTaPFactory();
		}
		
		return instance;
	}
	@Override
	public AbstractImmunization getObject(String name, List<Date> d, int age) {
		// TODO Auto-generated method stub
		return new DTaP(name, d, age);
	}

}
