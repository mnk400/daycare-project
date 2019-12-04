package edu.neu.csye6200;

public class TeacherFactory extends AbstractPersonFactory {
	private static TeacherFactory instance;
	private TeacherFactory() {
		instance = null;
	}
	public static TeacherFactory getInstance() {
		if(instance == null) {
			instance = new TeacherFactory();
		}
		
		return instance;
	}
	
	public AbstractPerson getObject() {
		return new Teacher();
	}
	public AbstractPerson getObject(String csvData) {
		return new Teacher(csvData);
	}
	
	
}
