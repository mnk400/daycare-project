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
import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Window{

	public JFrame frame;
	JLabel lblDefault;
	private JTable table_1;
	private int studint;

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
		
// ~~~~ CLASSROOM TAB ~~~~~
		
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
		
// ~~~~ IMMUNIZATION TAB ~~~~~
		
		JPanel immun = new JPanel();
		tabbedPane.addTab("Student Records", null, immun, null);
		immun.setLayout(null);

		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 0, 429, 195);
		immun.add(scrollPane_2);	
		
		DefaultTableModel m2 = new DefaultTableModel();
		m2.setColumnCount(3);
		for(Student s:GroupHelper.students) {
			m2.addRow(new Object[] {s.getId(),s.getFirstName(),s.lastName});
		}
		
		table_1 = new JTable(m2);
		scrollPane_2.setViewportView(table_1);

		
		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				studint = table_1.getSelectedRow();		
			}	
		});
		
		JButton btnNewButton = new JButton("Get Details");
		btnNewButton.setBounds(306, 197, 117, 29);
		immun.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Immunization Details");
		btnNewButton_1.setBounds(126, 197, 174, 29);
		immun.add(btnNewButton_1);
		
		btnNewButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {				
				JDialog dd = new JDialog();
				dd.setTitle(GroupHelper.students.get(studint).getFirstName() + " " + GroupHelper.students.get(studint).getLastName());
				dd.setBounds(0, 0, 330, 175);
	            dd.setSize(330, 175);
	            dd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	            
				JPanel pan = new JPanel();
				pan.setLayout(null);
				
				
				JLabel fn = new JLabel("First Name:"); 
				Font f = fn.getFont();
				fn.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
	            JLabel fname = new JLabel(GroupHelper.students.get(studint).getFirstName());             
	            JLabel ln = new JLabel("Last Name:"); 
	            ln.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
	            JLabel lname = new JLabel(GroupHelper.students.get(studint).getLastName()); 
	            JLabel id = new JLabel("Student ID:");
	            id.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
	            JLabel idame = new JLabel(Integer.toString(GroupHelper.students.get(studint).getStudentId()));
	            fn.setBounds(20,20,100,15);
	            ln.setBounds(20,40,100,15);
	            id.setBounds(20,60,100,15);
	            fname.setBounds(100,20,100,15);
	            lname.setBounds(100,40,100,15);
	            idame.setBounds(100,60,100,15);
	            
	            pan.add(fn);
	            pan.add(fname);
	            pan.add(ln);
	            pan.add(lname);
	            pan.add(id);
	            pan.add(idame);
	            
	            dd.add(pan);
	            dd.setVisible(true);
			}
			
		});
		
		JPanel settings = new JPanel();
		tabbedPane.addTab("Settings", null, settings, null);
	}
}

