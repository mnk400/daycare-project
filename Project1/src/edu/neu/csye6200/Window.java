package edu.neu.csye6200;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JLabel;

public class Window {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Classroom Schedule", null, panel, null);
		panel.setLayout(null);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Class 1");
        listModel.addElement("Class 2");
        listModel.addElement("Class 3");
        listModel.addElement("Class 4");
        listModel.addElement("Class 5");

        
		JList<String> list = new JList<>(listModel);
		list.setBounds(322, 35, 96, 136);
		panel.add(list);
		
		JButton btnNewButton = new JButton("Select");
		btnNewButton.setBounds(330, 181, 83, 29);
		panel.add(btnNewButton);
		
		JLabel lblSelectClass = new JLabel("Select Class");
		lblSelectClass.setBounds(330, 7, 75, 16);
		panel.add(lblSelectClass);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Immunizations", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Settings", null, panel_2, null);
	}
}
