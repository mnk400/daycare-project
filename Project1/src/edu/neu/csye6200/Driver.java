package edu.neu.csye6200;

import java.awt.EventQueue;

public class Driver {

	public static void main(String[] args) {
		//Student s1 = new Student("1,Pallak,Singh,4/5/2019,3,9/5/2019,agafgsf,2351235");
		//System.out.println(s1);
		
		Daycare.demo();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
