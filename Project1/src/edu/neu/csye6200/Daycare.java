package edu.neu.csye6200;

import java.util.*;

public class Daycare {
		private static List<Classroom> classList;
		
		public static void add(Classroom c) {
			classList.add(c);
		}
		
		public static void show() {
			classList.forEach(c -> {System.out.println(); System.out.println(c);});
		}
		
		
		public static void demo() {
			GroupHelper.groupMe();
			Daycare.show();
			
		}
}
