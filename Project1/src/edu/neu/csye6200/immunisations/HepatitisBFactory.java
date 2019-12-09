package edu.neu.csye6200.immunisations;

import java.util.Date;
import java.util.List;

import edu.neu.csye6200.AbstractPerson;
import edu.neu.csye6200.Student;
import edu.neu.csye6200.StudentFactory;

public class HepatitisBFactory extends AbstractImmunizationFactory {

	private static HepatitisBFactory instance;
	private HepatitisBFactory() {
		instance = null;
	}
	public static HepatitisBFactory getInstance() {
		if(instance == null) {
			instance = new HepatitisBFactory();
		}
		
		return instance;
	}

	@Override
	public AbstractImmunization getObject(String name, List<Date> d, int age) {
		// TODO Auto-generated method stub
		return new HepatitisB(name, d, age);
	}

}
