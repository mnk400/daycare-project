package edu.neu.csye6200;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

public class Window{

	public JFrame frame;
	JLabel lblDefault;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		JPanel classSch = new JPanel();
		tabbedPane.addTab("Classroom Schedule", null, classSch, null);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Class 1");
        listModel.addElement("Class 2");
        listModel.addElement("Class 3");
        listModel.addElement("Class 4");
        listModel.addElement("Class 5");
        listModel.addElement("Class 5");
        listModel.addElement("Class 6");
        listModel.addElement("Class 7");
        listModel.addElement("Class 8");
        listModel.addElement("Class 9");
        listModel.addElement("Class 10");
        listModel.addElement("Class 10");
        listModel.addElement("Class 10");
        listModel.addElement("Class 10");
		classSch.setLayout(null);
		
		lblDefault = new JLabel();
		lblDefault.setBounds(42, 35, 61, 16);
		classSch.add(lblDefault);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(306, 16, 108, 198);
		classSch.add(scrollPane);
		
		JList list = new JList(listModel);
		scrollPane.setViewportView(list);
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				lblDefault.setText((String) list.getSelectedValue());				
			}
			
		});
		
		JPanel immun = new JPanel();
		tabbedPane.addTab("Immunizations", null, immun, null);
		
		JPanel settings = new JPanel();
		tabbedPane.addTab("Settings", null, settings, null);
	}
}
