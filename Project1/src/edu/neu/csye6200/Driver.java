package edu.neu.csye6200;

import java.awt.EventQueue;

public class Driver {

	public static void main(String[] args) {

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
