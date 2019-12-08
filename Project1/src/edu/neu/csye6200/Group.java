package edu.neu.csye6200;

import java.util.ArrayList;
import java.util.List;

public class Group {
	private Teacher teacher;
	private List<Student> students = new ArrayList<>();
	private int groupSize;
	
	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}
	
	public int getGroupSize() {
		return this.groupSize;
	}
	
	public void addStudents(Student s) {
		students.add(s);
	}
	
	public void assignTeacher(Teacher t) {
		teacher = t;
	}
	
	public Teacher getTeacher() {
		return this.teacher;
	}
	
	public List<Student> getStudents() {
		return this.students;
	}

	@Override
	public String toString() {
		return students.toString();
	}
	
	
	
}

