package edu.neu.csye6200;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JTable;

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
        for(Classroom c:Daycare.getClassroom()) {
        	listModel.addElement("Class " + c.getId());
        }
		classSch.setLayout(null);
		
		lblDefault = new JLabel();
		lblDefault.setBounds(42, 35, 61, 16);
		classSch.add(lblDefault);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(306, 16, 108, 198);
		classSch.add(scrollPane);
		
		JList list = new JList(listModel);
		list.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setViewportView(list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		JScrollBar scrollBar = new JScrollBar(JScrollBar.VERTICAL) {
             @Override
             public boolean isVisible() {
                 return true;
             }
         };
        scrollPane_1.setVerticalScrollBar(scrollBar);
		scrollPane_1.setViewportBorder(null);
		scrollPane_1.setBounds(6, 6, 288, 220);
		scrollPane_1.setBorder(BorderFactory.createEmptyBorder());
		scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		classSch.add(scrollPane_1);
		
		
		
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				//lblDefault.setText(Daycare.getClassroom().get(list.getSelectedIndex()).toString());
				List<JTable> table = new ArrayList<>();
				JPanel jp = new JPanel();
				jp.setLayout(new BoxLayout(jp, BoxLayout.Y_AXIS));
				int f = 0;
				for(Group g : Daycare.getClassroom().get((list.getSelectedIndex())).getGroups()) {
						f = f + 1;
						//lblDefault.setText("Group" + f);
						DefaultTableModel m1 = new DefaultTableModel();
						m1.setColumnCount(3);
						for(Student s: g.getStudents()) {
							m1.addRow(new Object[] {s.getStudentId(),s.getFirstName(),s.getLastName()});
						}
						table.add(new JTable(m1));
						table.get(f-1).setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
						//table.get(f-1).setBackground(SystemColor.window);
						
					}
				int ctr = 0;
				for(JTable t : table) {
					JLabel labelTeacher = new JLabel(Daycare.getClassroom().get((list.getSelectedIndex())).getGroups().get(ctr).getTeacher().toString());
					Font fnt = labelTeacher.getFont();
					labelTeacher.setFont(fnt.deriveFont(fnt.getStyle() | Font.BOLD));
					ctr = ctr + 1;
					JLabel jl = new JLabel("Group" + ctr);
					jp.setBounds(10, 10, 40, 15);
					jp.add(jl);
					jp.add(labelTeacher);
					jp.add(t);
				}
				
				scrollPane_1.setViewportView(jp);

			}
			
		});
		
		JPanel immun = new JPanel();
		tabbedPane.addTab("Immunizations", null, immun, null);
		
		JPanel settings = new JPanel();
		tabbedPane.addTab("Settings", null, settings, null);
	}
}
