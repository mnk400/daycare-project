package edu.neu.csye6200;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
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
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		JPanel classSch = new JPanel();
		tabbedPane.addTab("Classroom Schedule", null, classSch, null);
		classSch.setLayout(null);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Class 1");
        listModel.addElement("Class 2");
        listModel.addElement("Class 3");
        listModel.addElement("Class 4");
        listModel.addElement("Class 5");

        
		JList<String> list = new JList<>(listModel);
		list.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		list.setBackground(SystemColor.window);
		list.setForeground(Color.BLACK);
		list.setBounds(308, 6, 115, 220);
		classSch.add(list);
		list.setSelectedIndex(1);
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				lblDefault.setText(list.getSelectedValue());
			}
				
		});
		
		lblDefault = new JLabel();
		lblDefault.setBounds(42, 35, 61, 16);
		classSch.add(lblDefault);
		lblDefault.setText(list.getSelectedValue());
		
		JPanel immun = new JPanel();
		tabbedPane.addTab("Immunizations", null, immun, null);
		
		JPanel settings = new JPanel();
		tabbedPane.addTab("Settings", null, settings, null);
	}


}
