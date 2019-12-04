package edu.neu.csye6200;

public class StudentFactory extends AbstractPersonFactory {
	private static StudentFactory instance;
	private StudentFactory() {
		instance = null;
	}
	public static StudentFactory getInstance() {
		if(instance == null) {
			instance = new StudentFactory();
		}
		
		return instance;
	}
	
	public AbstractPerson getObject(String csvData) {
		return new Student(csvData);
	}
	@Override
	public AbstractPerson getObject() {
		// TODO Auto-generated method stub
		return null;
	}

}
