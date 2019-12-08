package edu.neu.csye6200;

public class ClassroomFactory {
	
	private static ClassroomFactory instance;
	private ClassroomFactory() {
		instance = null;
	}
	public static ClassroomFactory getInstance() {
		if(instance == null) {
			instance = new ClassroomFactory();
		}
		
		return instance;
	}
	
	public Classroom getObject() {
		return new Classroom();
	}

}
