package edu.neu.csye6200;

public class TeacherFactory {
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
	
	public static AbstractPerson getObject() {
		return new Teacher();
	}
	public static AbstractPerson getObject(String csvData) {
		return new Teacher(csvData);
	}
	
	
}
