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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;

import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;

public class Window{

	public JFrame frame;
	JLabel lblDefault;
	private JTable table_1;
	static int studint;
	DefaultTableModel m2;


	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}
	
	public void createClassroomTable() {
		
	}
	
	public void createStudentDetailsTable(JScrollPane s2) {
		DefaultTableModel m2 = new DefaultTableModel();
		m2.setColumnCount(3);
		String[] colm2 = {"Student ID", "First Name", "Last Name"};
		m2.setColumnIdentifiers(colm2);
		for(Student s:GroupHelper.students) {
			m2.addRow(new Object[] {s.getStudentId(),s.getFirstName(),s.lastName});
		}
		
		table_1 = new JTable(m2);
		s2.setViewportView(table_1);
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
		
//		DefaultTableModel m2 = new DefaultTableModel();
//		m2.setColumnCount(3);
//		for(Student s:GroupHelper.students) {
//			m2.addRow(new Object[] {s.getStudentId(),s.getFirstName(),s.lastName});
//		}

		//table_1 = new JTable(m2);
		createStudentDetailsTable(scrollPane_2);
		//scrollPane_2.setViewportView(table_1);

		
		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
				studint = table_1.getSelectedRow();		
			}	
		});
		
//START// 	Get Details Students Button		
		JButton btnNewButton = new JButton("Get Details");
		btnNewButton.setBounds(306, 197, 117, 29);
		immun.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//WindowSubViews view2 = new WindowSubViews();
				//view2.initializeDetails();
				JDialog dd = new JDialog(frame, GroupHelper.students.get(studint).getFirstName() + " " + GroupHelper.students.get(studint).getLastName()); 
				dd.setSize(270,330);
				JPanel pan = new JPanel();
				pan.setLayout(null);
				
	            JLabel lname = new JLabel(GroupHelper.students.get(studint).getLastName()); 
	            JLabel fname = new JLabel(GroupHelper.students.get(studint).getFirstName());
	            JLabel ddate = new JLabel(ConversionHelper.DateToString(GroupHelper.students.get(studint).getDob()));
	        
	            JLabel id = new JLabel("Student ID:");
	            JLabel fn = new JLabel("First Name");
	            JLabel ln = new JLabel("Last Name");
	            JLabel dob = new JLabel("Date of Birth");
	            Font f = id.getFont();
	            id.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
	            fn.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
	            ln.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
	            dob.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
	            JLabel idame = new JLabel(Integer.toString(GroupHelper.students.get(studint).getStudentId()));
	            fn.setBounds(20,20,100,15);
	            ln.setBounds(20,40,100,15);
	            id.setBounds(20,60,100,15);
	            dob.setBounds(20,80,100,15);
	            fname.setBounds(115,20,100,15);
	            lname.setBounds(115,40,100,15);
	            idame.setBounds(115,60,100,15);
	            ddate.setBounds(115,80,100,15);

	        
            
	            pan.add(fn);
	            pan.add(fname);
            	pan.add(ln);
            	pan.add(lname);
            	pan.add(id);
            	pan.add(idame);
            	pan.add(dob);
            	pan.add(ddate);
            	
            
            	dd.add(pan);
            	dd.setVisible(true);	
			}
			
		});
//END//
		
//START// Immunizations Details button		
		JButton btnNewButton_1 = new JButton("Immunization Details");
		btnNewButton_1.setBounds(126, 197, 174, 29);
		immun.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog ap = new JDialog(frame, "Immunization Details");
				ap.setSize(340,180);
				JPanel pab = new JPanel();
				pab.setLayout(null);
				String temp="";
				for(int i=0;i<4;i++) {
				temp = temp + GroupHelper.students.get(studint).getImmunisations().get(i).printImmunization(GroupHelper.students.get(studint)) + "\n";
				}
				JLabel text = new JLabel("Immunization Alerts");
				Font f = text.getFont();
				text.setBounds(100, 25, 150, 15);
				text.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
				JTextArea messages = new JTextArea(temp);
				messages.setBounds(10,60,400,200);
				messages.setBackground(SystemColor.window);
				messages.setEditable(false);
				pab.add(messages);
				pab.add(text);
				ap.add(pab);
				ap.setVisible(true);
				
			}
			
		});
		

//END//		
		
//START//	Add Students Button Action		
		JButton btnNewButton_stud = new JButton("Add Students");
		btnNewButton_stud.setBounds(6, 197, 116, 29);
		immun.add(btnNewButton_stud);
		
		btnNewButton_stud.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialog dd = new JDialog(frame, "Add Student"); 
				dd.setSize(290, 605);
				JPanel pan = new JPanel();
				pan.setLayout(null);
				
				JButton addStudent = new JButton("Add Student");
				
				 JTextField lname = new JTextField(); 
				 JTextField fname = new JTextField();
				 JTextField ddate = new JTextField();
				 JTextField idT = new JTextField();
				 JTextField addT = new JTextField();
				 JTextField phoneNum = new JTextField();
				 JTextField emailT = new JTextField();
				 JTextField gT = new JTextField();
				 
				 lname.setEditable(true);
				 fname.setEditable(true);
				 ddate.setEditable(true);
				 idT.setEditable(true);
				 addT.setEditable(true);
				 phoneNum.setEditable(true);
				 
				 JLabel id = new JLabel("Student ID:");
		         JLabel fn = new JLabel("First Name:");
		         JLabel ln = new JLabel("Last Name:");
		         JLabel dob = new JLabel("Date of Birth:");
		         JLabel address = new JLabel("Address:");
		         JLabel phoneNumber = new JLabel("Phone No.:");
		         JLabel pname = new JLabel("Gaurdian Name:");
		         JLabel email = new JLabel("E-Mail");
		         JLabel alert = new JLabel();
		         
		         
		         Font f = id.getFont();
		         id.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		         fn.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		         ln.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		         dob.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		         address.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		         phoneNumber.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		         pname.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		         email.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		         
		         fn.setBounds(20,20,100,15);
		         ln.setBounds(20,40,100,15);
		         id.setBounds(20,60,100,15);
		         dob.setBounds(20,80,100,15);
		         address.setBounds(20,100,120,15);
		         phoneNumber.setBounds(20,120,120,15);
		         pname.setBounds(20,140,120,15);
		         email.setBounds(20,160,120,15);
		         fname.setBounds(135,20,120,15);
		         lname.setBounds(135,40,120,15);
		         idT.setBounds(135,60,120,15);
		         ddate.setBounds(135,80,120,15);
		         addT.setBounds(135,100,120,15);
		         phoneNum.setBounds(135,120,120,15);
		         gT.setBounds(135,140,120,15);
		         emailT.setBounds(135,160,120,15);
		         alert.setBounds(110, 523, 180, 15);
		         alert.setForeground(Color.red);
		         
		         addStudent.setBounds(135,542,120,25);
		        
		         JLabel vac1 = new JLabel("Hepatitis-B:");
		         vac1.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		         JTextField vact1 = new JTextField();
		         JTextField vact2 = new JTextField();
		         JTextField vact3 = new JTextField();
		         vac1.setBounds(20,200,120,15);
		         vact1.setBounds(135,200,120,15);
		         vact2.setBounds(135,220,120,15);
		         vact3.setBounds(135,240,120,15);
		         
		         JLabel vac2 = new JLabel("DTaP:");
		         vac2.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		         JTextField vactt1 = new JTextField();
		         JTextField vactt2 = new JTextField();
		         JTextField vactt3 = new JTextField();
		         JTextField vactt4 = new JTextField();
		         vac2.setBounds(20,270,120,15);
		         vactt1.setBounds(135,270,120,15);
		         vactt2.setBounds(135,290,120,15);
		         vactt3.setBounds(135,310,120,15);
		         vactt4.setBounds(135,330,120,15);
		         
		         JLabel vac3 = new JLabel("Rotavirus:");
		         vac3.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		         JTextField vacttt1 = new JTextField();
		         JTextField vacttt2 = new JTextField();
		         JTextField vacttt3 = new JTextField();
		         JTextField vacttt4 = new JTextField();
		         vac3.setBounds(20,360,120,15);
		         vacttt1.setBounds(135,360,120,15);
		         vacttt2.setBounds(135,380,120,15);
		         vacttt3.setBounds(135,400,120,15);
		         vacttt4.setBounds(135,420,120,15);
		         
		         JLabel vac4 = new JLabel("Pneumococcal");
		         JLabel vac41 = new JLabel("Conjugate:");
		         vac4.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		         vac41.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
		         JTextField vactttt1 = new JTextField();
		         JTextField vactttt2 = new JTextField();
		         JTextField vactttt3 = new JTextField();
		         JTextField vactttt4 = new JTextField();
		         vac4.setBounds(20,440,120,15);
		         vac41.setBounds(20,460,80,15);
		         vactttt1.setBounds(135,440,120,15);
		         vactttt2.setBounds(135,460,120,15);
		         vactttt3.setBounds(135,480,120,15);
		         vactttt4.setBounds(135,500,120,15);
		         
		         pan.add(alert);
		         pan.add(vac41);
		         pan.add(id);
		         pan.add(idT);
		         pan.add(fn);
		         pan.add(fname);
		         pan.add(ln);
		         pan.add(lname);
		         pan.add(dob);
		         pan.add(ddate);
		         pan.add(address);
		         pan.add(addT);
		         pan.add(gT);
		         pan.add(email);
		         pan.add(emailT);
		         pan.add(pname);
		         pan.add(phoneNumber);
		         pan.add(phoneNum);
		         pan.add(addStudent);
		         pan.add(vac1);
		         pan.add(vact1);
		         pan.add(vact2);
		         pan.add(vact3);
		         pan.add(vac2);
		         pan.add(vactt1);
		         pan.add(vactt2);
		         pan.add(vactt3);
		         pan.add(vactt4);
		         pan.add(vac3);
		         pan.add(vacttt1);
		         pan.add(vacttt2);
		         pan.add(vacttt3);	         
		         pan.add(vac4);
		         pan.add(vactttt1);
		         pan.add(vactttt2);
		         pan.add(vactttt3);
		         pan.add(vactttt4);
		         
		         List<JTextField> vacList = new ArrayList<>();
		         vacList.add(vact1);
		         vacList.add(vact2);
		         vacList.add(vact3);
		         vacList.add(vactt1);
		         vacList.add(vactt2);
		         vacList.add(vactt3);
		         vacList.add(vactt4);
		         vacList.add(vacttt1);
		         vacList.add(vacttt2);
		         vacList.add(vacttt3);
		         vacList.add(vactttt1);
		         vacList.add(vactttt2);
		         vacList.add(vactttt3);
		         vacList.add(vactttt4);
		       
		         
					

	            
		         dd.add(pan);
		         dd.setVisible(true);
		         
		         addStudent.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Calendar todayDate = new GregorianCalendar();
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						Date td = todayDate.getTime();
						StringBuilder csvSb = new StringBuilder();
						csvSb.append(fname.getText());
						csvSb.append(",");
						csvSb.append(lname.getText());
						csvSb.append(",");
						csvSb.append(ddate.getText());
						csvSb.append(",");
						csvSb.append(idT.getText());
						csvSb.append(",");
						csvSb.append(dateFormat.format(td));
						csvSb.append(",");
						csvSb.append(addT.getText());
						csvSb.append(",");
						csvSb.append(phoneNum.getText());
						csvSb.append(",");
						csvSb.append(gT.getText());
						csvSb.append(",");
						csvSb.append(emailT.getText());
						for(JTextField j : vacList) {
							csvSb.append(",");
							if(j.getText().contentEquals("")) {
								csvSb.append("0");
							}
							csvSb.append(j.getText());
							
							
							
						}
						Date dob = ConversionHelper.StringToDate(ddate.getText());
						int age = ConversionHelper.DateToAge(dob);
						if((age > 1 && vacList.get(0).getText().isEmpty() == true) || 
								(age > 3 && vacList.get(1).getText().isEmpty() == true) || 
								(age > 18 && vacList.get(2).getText().isEmpty() == true) || (age > 4 && vacList.get(3).getText().isEmpty()) 
								|| (age > 6 && vacList.get(4).getText().isEmpty() == true) || (age > 9 && vacList.get(5).getText().isEmpty()) || 
								(age > 18 && vacList.get(6).getText().isEmpty() == true) || (age > 4 && vacList.get(7).getText().isEmpty()) || 
								(age > 6 && vacList.get(8).getText().isEmpty() == true) || (age > 9 && vacList.get(9).getText().isEmpty()) ||
								(age > 4 && vacList.get(10).getText().isEmpty() == true) || (age > 6 && vacList.get(11).getText().isEmpty()) 
								|| (age > 9 && vacList.get(12).getText().isEmpty() == true) || (age > 15 && vacList.get(13).getText().isEmpty())) { 
							System.out.println("I am in the loop");
							String message = "Insufficient vaccinations";
//							JDialog jfem = new JDialog();
//							JOptionPane.showMessageDialog(jfem, message, "Dialog",
//							    JOptionPane.ERROR_MESSAGE);
//						
//							jfem.setVisible(false);
//							jfem.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
////							    
							alert.setText(message);
							fname.setText(" ");
							lname.setText(" ");
							ddate.setText(" ");
							idT.setText(" ");
							addT.setText(" ");
							phoneNum.setText(" ");
							gT.setText(" ");
							emailT.setText(" ");
							for(JTextField j : vacList) {
								j.setText(" ");		
								
							}
							
							
							
//							    
							    
							    
			
						} else {
							
							

							String csvStudent = csvSb.toString();
							FileUtil.writeTextFile(csvStudent, GroupHelper.teachersfile);
							GroupHelper.groupMe();	
							//m2.fireTableDataChanged();
							createStudentDetailsTable(scrollPane_2);
							dd.setVisible(false);
						}
						
						dd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						
					}
		        	 
		         });
		         
				
			}
			
		});
//END//		
		
		
		
		JPanel settings = new JPanel();
		tabbedPane.addTab("Settings", null, settings, null);
		settings.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student CSV Location");
		lblNewLabel.setBounds(19, 17, 144, 16);
		settings.add(lblNewLabel);
		
		JLabel lblTeacherCsvLocation = new JLabel("Teacher CSV Location");
		lblTeacherCsvLocation.setBounds(19, 45, 144, 16);
		settings.add(lblTeacherCsvLocation);
		
		JTextField textField = new JTextField(GroupHelper.studentfile);
		textField.setBounds(176, 40, 211, 26);
		settings.add(textField);
		textField.setColumns(10);
		
		JTextField textField_1 = new JTextField(GroupHelper.teachersfile);
		textField_1.setBounds(175, 12, 211, 26);
		settings.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSet = new JButton("Set");
		btnSet.setBounds(312, 68, 75, 29);
		settings.add(btnSet);
		
		JButton btnResetToDefault = new JButton("Default");
		btnResetToDefault.setBounds(186, 68, 117, 29);
		settings.add(btnResetToDefault);
		
		btnResetToDefault.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GroupHelper.studentfile="students.csv";
				GroupHelper.teachersfile="teachers.csv";
				
			}
			
		});
		
		JButton btnNewButton_2 = new JButton("Add a Teacher");
		btnNewButton_2.setBounds(19, 125, 125, 29);
		settings.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				GroupHelper.studentfile=textField.getText();
				GroupHelper.teachersfile=textField_1.getText();
			}
			
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialog dd = new JDialog(frame, "Add Teacher"); 
				dd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dd.setSize(290, 190);
				JPanel pan = new JPanel();
				pan.setLayout(null);
				
				JButton addTeacher = new JButton("Add Teacher");
				
				 JTextField lname = new JTextField(); 
				 JTextField fname = new JTextField();
				 JTextField ddate = new JTextField();
				 JTextField idT = new JTextField();
				 JTextField emailT = new JTextField();

				 
				 lname.setEditable(true);
				 fname.setEditable(true);
				 ddate.setEditable(true);
				 idT.setEditable(true);
				 emailT.setEditable(true);
				 
				 JLabel id = new JLabel("Teacher ID:");
		         JLabel fn = new JLabel("First Name:");
		         JLabel ln = new JLabel("Last Name:");
		         JLabel dob = new JLabel("Date of Birth:");
		         JLabel email = new JLabel("E-Mail");
		         
		         fn.setBounds(20,20,100,15);
		         ln.setBounds(20,40,100,15);
		         id.setBounds(20,60,100,15);
		         dob.setBounds(20,80,100,15);
		         email.setBounds(20,100,120,15);
		         fname.setBounds(135,20,120,15);
		         lname.setBounds(135,40,120,15);
		         idT.setBounds(135,60,120,15);
		         ddate.setBounds(135,80,120,15);
		         emailT.setBounds(135,100,120,15);
		         
		         addTeacher.setBounds(135, 120, 120, 25);

		        
		         pan.add(lname);
		         pan.add(id);
		         pan.add(fn);
		         pan.add(ln);
		         pan.add(dob);
		         pan.add(email);
		         pan.add(emailT);
		         pan.add(fname);
		         pan.add(ddate);
		         pan.add(idT);
		         pan.add(addTeacher);
		         
		         dd.add(pan);
		         dd.setVisible(true);
		         
		         addTeacher.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Calendar todayDate = new GregorianCalendar();
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						Date td = todayDate.getTime();
						String teacherCSV = fname.getText() + "," + lname.getText() + "," + ddate.getText() + "," + 
						idT.getText() + "," + ConversionHelper.DateToString(td) + "," + emailT.getText();
						FileUtil.writeTextFile(teacherCSV, GroupHelper.teachersfile);
						GroupHelper.groupMe();
						dd.setVisible(false);
					}
		        	 
		         });
			}
			
		});			
		JButton btnNewButton_3 = new JButton("Reload Program");
		btnNewButton_3.setBounds(262, 180, 125, 29);
		settings.add(btnNewButton_3);
		
		btnNewButton_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Driver.main(null);
				
			}
			
		});
		
		JButton btnNewButton_4 = new JButton("Force Send Email");
		btnNewButton_4.setBounds(19, 180, 155, 29);
		settings.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				NotificationHelper.configureTask();
			}
			
		});
		
		JButton btnViewTeacherList = new JButton("View Teacher List");
		btnViewTeacherList.setBounds(19, 153, 155, 29);
		settings.add(btnViewTeacherList);
		
		btnViewTeacherList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog teed = new JDialog(frame, "Teacher List");
				teed.setSize(300,230);
				JScrollPane tp = new JScrollPane();
				DefaultTableModel m3 = new DefaultTableModel();
				m3.setColumnCount(5);
				m3.setColumnIdentifiers(new String[] {"ID","First Name","Last Name","Joining Date","Email"});
				for(Teacher t:GroupHelper.teachers) {
					m3.addRow(new Object[] {t.getEmployeeId(),t.getFirstName(),t.getLastName(),ConversionHelper.DateToString(t.getJoiningDate()),t.getEmailID()});
				}
				
				JTable tt = new JTable(m3);
				tp.setViewportView(tt);
				teed.add(tp);
				teed.setVisible(true);
				teed.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			}
			
		});
		
		
		
	}
}


