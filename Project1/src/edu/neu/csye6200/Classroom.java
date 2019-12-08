package edu.neu.csye6200;

import java.util.*;

public class Classroom {
		private List<Group> groups = new ArrayList<>();
		static int id = 0;
		private int idC = 0;
		public Classroom() {
			id++;
			idC = id;
		}
		public int getId() {
			return idC;
		}
		public void addGroups(Group g) {
			groups.add(g);
		}
		public List<Group> getGroups() {
			return this.groups;
		}
		@Override
		public String toString() {
			String temp="";
			for(int i=0;i<groups.size();i++) {
				temp = temp + " " +  groups.get(i).getTeacher().getFirstName();
			}	
			return temp;
		}
}
