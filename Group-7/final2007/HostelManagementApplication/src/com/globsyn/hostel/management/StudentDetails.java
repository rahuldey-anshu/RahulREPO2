package com.globsyn.hostel.management;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import java.awt.List;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.CharacterCodingException;
import java.util.Enumeration;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import javafx.scene.control.ComboBox;

import javax.swing.UIManager;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;

public class StudentDetails extends JFrame{
	private JPanel contentPane;
	JFrame frmStudentDetails;
	private JTable table;
	private JTextField studentPin;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField studentArea;
	private JTextField studentContact;
	private JTextField studentParentContact;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDetails window = new StudentDetails();
					window.frmStudentDetails.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public StudentDetails() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmStudentDetails = new JFrame();
		frmStudentDetails.setIconImage(Toolkit.getDefaultToolkit().getImage("assets\\icon17.png"));
		frmStudentDetails.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmStudentDetails.setTitle("Hostel Management Application");
		frmStudentDetails.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 13));
		frmStudentDetails.setBounds(100, 100, 970, 692);
		frmStudentDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStudentDetails.getContentPane().setLayout(null);

		table = new JTable();
		table.setBounds(130, 192, 211, -65);
		frmStudentDetails.getContentPane().add(table);

		JLabel lblName = new JLabel("NAME:");
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblName.setBounds(239, 89, 78, 22);
		frmStudentDetails.getContentPane().add(lblName);

		JTextArea studentName = new JTextArea();
		studentName.setBackground(new Color(250, 235, 215));
		studentName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if((Character.isDigit(c))||(studentName.getText().length()>=20))
				{
					e.consume();
				}
			}
		});
		studentName.setBounds(408, 90, 155, 22);
		frmStudentDetails.getContentPane().add(studentName);

		JLabel lblDepartment = new JLabel("DEPARTMENT:");
		lblDepartment.setForeground(new Color(0, 0, 0));
		lblDepartment.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblDepartment.setBounds(239, 333, 126, 22);
		frmStudentDetails.getContentPane().add(lblDepartment);

		JLabel lblYearOfPassing = new JLabel("YEAR OF PASSING:");
		lblYearOfPassing.setForeground(new Color(0, 0, 0));
		lblYearOfPassing.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblYearOfPassing.setBounds(239, 372, 148, 14);
		frmStudentDetails.getContentPane().add(lblYearOfPassing);

		JLabel lblGurdiansName = new JLabel("PARENT'S NAME:");
		lblGurdiansName.setForeground(new Color(0, 0, 0));
		lblGurdiansName.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblGurdiansName.setBounds(239, 412, 126, 14);
		frmStudentDetails.getContentPane().add(lblGurdiansName);

		JTextPane studentParent = new JTextPane();
		studentParent.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if((Character.isDigit(c))||(studentParent.getText().length()>=20))
				{
					e.consume();
				}
			}});
		studentParent.setBounds(408, 412, 278, 20);
		frmStudentDetails.getContentPane().add(studentParent);

		JLabel lblPhysicallyHan = new JLabel("Disabalities if Any:");
		lblPhysicallyHan.setForeground(new Color(250, 235, 215));
		lblPhysicallyHan.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPhysicallyHan.setBounds(239, 570, 155, 14);
		frmStudentDetails.getContentPane().add(lblPhysicallyHan);

		String[]year= {"2017","2018","2019","2020","2021","2022"};
		JComboBox studentYearOfPass = new JComboBox(year);
		studentYearOfPass.setBounds(408, 370, 81, 20);
		frmStudentDetails.getContentPane().add(studentYearOfPass);


		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 69, 0));
		panel_5.setBorder(new TitledBorder(null, "Address", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
		panel_5.setBounds(239, 122, 413, 147);
		frmStudentDetails.getContentPane().add(panel_5);
		panel_5.setLayout(null);

		String[]state={"Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand (JH)","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
		String[]city={"Hyderabad" ,"Itanagar","Dispur","Patna","Panaji","Gandhinagar","Chandigarh","Shimla","Srinagar ","Jammu","Bangalooru","Tirubanantapuram","Bhopal","Mumbai","Imphal","Shillong","Aizawl","Kohima","Bhubaneswar","Chandigarh","Jaipur","Gangtok","Chennai","Agartala","Lucknow","Kolkata","Raipur","Dehradun","Ranchi","Hyderabad","Howrah","Darjeeling","Kharagpur","Bardhaman","Asansol","Durgapur","Siliguri","Murshidabad","Raiganj","Purulia","Krishnanagar"};

		String[]str={"CSE","IT","EE","ME","ECE","CE","CHE","BT"};
		JComboBox studentDepartment = new JComboBox(str);
		studentDepartment.setBounds(408, 336, 195, 20);
		frmStudentDetails.getContentPane().add(studentDepartment);


		JComboBox studentState = new JComboBox(state);
		studentState.setBounds(168, 84, 155, 20);
		panel_5.add(studentState);
		String combo3=(String)studentState.getSelectedItem();

		JComboBox studentCity = new JComboBox(city);
		studentCity.setBounds(168, 61, 155, 20);
		panel_5.add(studentCity);
		JRadioButton studentMale = new JRadioButton("MALE");
		buttonGroup.add(studentMale);
		studentMale.setBounds(408, 287, 71, 23);
		frmStudentDetails.getContentPane().add(studentMale);

		JRadioButton studentFemale = new JRadioButton("FEMALE");
		buttonGroup.add(studentFemale);
		studentFemale.setBounds(520, 287, 90, 23);
		frmStudentDetails.getContentPane().add(studentFemale);
		JRadioButton studentDisabled = new JRadioButton("YES");
		buttonGroup_1.add(studentDisabled);
		studentDisabled.setBounds(408, 567, 71, 23);
		frmStudentDetails.getContentPane().add(studentDisabled);

		JRadioButton studentNotDisabled = new JRadioButton("NO");
		buttonGroup_1.add(studentNotDisabled);
		studentNotDisabled.setBounds(541, 567, 50, 23);
		frmStudentDetails.getContentPane().add(studentNotDisabled);


		JButton btnUpdateDetails = new JButton("SAVE");
		btnUpdateDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sName = studentName.getText().toString();
				String sArea = studentArea.getText().toString();
				String sCity = studentCity.getSelectedItem().toString();
				String sState =studentState.getSelectedItem().toString();
				String sPin = studentPin.getText().toString();
				String sSex = null;
				if (studentMale.isSelected()) {
					sSex = "Male";
				} else if (studentFemale.isSelected()) {
					sSex = "Female";

				}
				String sDepartment= studentDepartment.getSelectedItem().toString();
				String sYear= studentYearOfPass.getSelectedItem().toString();

				String sParent = studentParent.getText().toString();
				String sContact = studentContact.getText().toString();
				String sParentContact=studentParentContact.getText().toString();
				String sDisable = null;
				if (studentDisabled.isSelected()) {
					sDisable = "Disabled";
				} else if (studentNotDisabled.isSelected()) {
					sDisable = "Not Disabled";

				}
				if(sArea!=null && sName!=null && sCity!=null && sState!=null && sPin!=null && sSex!=null && sDepartment!=null && sYear!=null && sParent!=null && sContact!=null && sParentContact!=null && sDisable!=null)
				{

					File f = new File("assets//forms//Students.dat");


					if (f.exists()) 
					{
						String dataToWrite = sName + "|" + sArea + "|" + sCity + "|" + sState + "|" + sPin + "|" + sSex + "|" + sDepartment +"|"+ sYear +"|"+ sParent +"|"+ sContact +"|"+ sParentContact +"|"+ sDisable + "\n";

						try {
							FileWriter fileWriter = new FileWriter(f,true);
							BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

							bufferedWriter.write(dataToWrite);
							bufferedWriter.flush();
							bufferedWriter.close();
							int yesNo = JOptionPane.showConfirmDialog(contentPane, "Student data saved successfully.\n Do you want to add more????", "Student Confirmation!!!",
									JOptionPane.INFORMATION_MESSAGE);
							if(yesNo==JOptionPane.YES_OPTION){
								studentName.setText("");
								studentArea.setText("");
								studentPin.setText("");
								studentParent.setText("");
								studentContact.setText("");
								studentParentContact.setText("");

							}else if(yesNo==JOptionPane.CANCEL_OPTION){
								HomePage window = new HomePage();
								window.frmHomePage.setVisible(true);
								frmStudentDetails.dispose();
							}else if(yesNo==JOptionPane.NO_OPTION){
								RoomsFinal frame = new RoomsFinal();
								frame.setVisible(true);
								frmStudentDetails.dispose();
							}
						} catch (IOException e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(contentPane, "Unable to save student data.", "Save Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(contentPane, "Unable to save student data.", "Save Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(contentPane, "Unable to save student data.", "Save Error",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			
			else
			{
				JOptionPane.showMessageDialog(contentPane, "Please enter all details!", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			}

		});


		btnUpdateDetails.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnUpdateDetails.setBounds(274, 624, 161, 23);
		frmStudentDetails.getContentPane().add(btnUpdateDetails);

		JButton btnNewButton = new JButton("CLEAR");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				studentName.setText("");
				studentPin.setText("");
				studentArea.setText("");
				studentParent.setText("");	
				studentContact.setText("");
				studentParentContact.setText("");
				buttonGroup.clearSelection();
				buttonGroup_1.clearSelection();





			}
		});
		btnNewButton.setBounds(500, 624, 139, 23);
		frmStudentDetails.getContentPane().add(btnNewButton);








		JLabel lblSex = new JLabel("SEX:");
		lblSex.setHorizontalAlignment(SwingConstants.LEFT);
		lblSex.setForeground(new Color(0, 0, 0));
		lblSex.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSex.setBounds(239, 285, 126, 22);
		frmStudentDetails.getContentPane().add(lblSex);




		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 69, 0));
		panel.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Contact", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(239, 455, 397, 90);
		frmStudentDetails.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("PARENT'S CONTACT:");
		lblNewLabel.setBounds(20, 65, 148, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));

		JLabel lblContactstudent = new JLabel("CONTACT(STUDENT):");
		lblContactstudent.setBounds(20, 29, 148, 14);
		panel.add(lblContactstudent);
		lblContactstudent.setFont(new Font("Times New Roman", Font.BOLD, 14));

		studentContact = new JTextField();
		studentContact.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if((!Character.isDigit(c))||(studentContact.getText().length()>=10)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))
				{
					e.consume();
				}
			}
		});

		studentContact.setBounds(178, 27, 169, 20);
		panel.add(studentContact);
		studentContact.setColumns(10);

		studentParentContact = new JTextField();
		studentParentContact.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if((!Character.isDigit(c))||(studentParentContact.getText().length()>=10)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))
				{
					e.consume();
				}
			}
		});
		studentParentContact.setColumns(10);
		studentParentContact.setBounds(179, 58, 169, 20);
		panel.add(studentParentContact);



		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel_1.setBounds(433, 214, -425, -143);
		frmStudentDetails.getContentPane().add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Address", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.windowText));
		panel_2.setBounds(422, 63, -417, 147);
		frmStudentDetails.getContentPane().add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.RAISED, null, SystemColor.activeCaptionBorder, null, null));
		panel_3.setBounds(433, 69, -425, 138);
		frmStudentDetails.getContentPane().add(panel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Address", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.desktop));
		panel_4.setBackground(SystemColor.windowText);
		panel_4.setBounds(434, 72, -426, 138);
		frmStudentDetails.getContentPane().add(panel_4);



		studentArea = new JTextField();
		studentArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(studentArea.getText().length()>=50)
				{
					e.consume();
				}
			}
		});
		studentArea.setBounds(168, 27, 217, 23);
		panel_5.add(studentArea);
		studentArea.setColumns(10);

		JLabel lblStreetAndArea = new JLabel("AREA:");
		lblStreetAndArea.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblStreetAndArea.setBounds(10, 27, 126, 22);
		panel_5.add(lblStreetAndArea);

		JLabel lblCity = new JLabel("CITY:");
		lblCity.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCity.setBounds(10, 60, 126, 22);
		panel_5.add(lblCity);

		JLabel lblState = new JLabel("STATE:");
		lblState.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblState.setBounds(10, 81, 126, 22);
		panel_5.add(lblState);

		JLabel lblPincode = new JLabel("PINCODE:");
		lblPincode.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblPincode.setBounds(10, 113, 126, 22);
		panel_5.add(lblPincode);

		studentPin = new JTextField();
		studentPin.setBounds(168, 116, 148, 20);
		panel_5.add(studentPin);
		studentPin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if((!Character.isDigit(c))||(studentPin.getText().length()>=6)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))
				{
					e.consume();
				}
			}

		});
		studentPin.setColumns(10);



		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1094, 21);
		frmStudentDetails.getContentPane().add(menuBar);

		JMenu mnStudent = new JMenu("Student");
		menuBar.add(mnStudent);

		JMenuItem newStudent = new JMenuItem("New");
		newStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_MASK));
		mnStudent.add(newStudent);

		JSeparator separator = new JSeparator();
		mnStudent.add(separator);

		JMenuItem listStudent = new JMenuItem("List");
		listStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK));
		mnStudent.add(listStudent);

		JMenu mnSupplier = new JMenu("Supplier");
		menuBar.add(mnSupplier);

		JMenuItem newSupplier = new JMenuItem("New");
		newSupplier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));

		mnSupplier.add(newSupplier);

		JMenuItem listSupplier = new JMenuItem("List");
		listSupplier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mnSupplier.add(listSupplier);
		
		JMenu mnRoom = new JMenu("Room");
		menuBar.add(mnRoom);
		
		JMenuItem mntmAllocate = new JMenuItem("Allocate");
		mntmAllocate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RoomsFinal frame = new RoomsFinal();
				frame.setVisible(true);
				dispose();
			}
		});
		mnRoom.add(mntmAllocate);
		JSeparator separator1 = new JSeparator();
		mnRoom.add(separator1);
		
		JMenuItem mntmBooked = new JMenuItem("Booked");
		mntmBooked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookedList frame = new BookedList();
				frame.setVisible(true);
				dispose();

			}
		});
		mnRoom.add(mntmBooked);
		

		JMenu mnLogout = new JMenu("Logout");
		menuBar.add(mnLogout);

		JMenuItem confirm = new JMenuItem("Confirm");
		confirm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.ALT_MASK));
		mnLogout.add(confirm);
		newStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentDetails window = new StudentDetails();
				window.frmStudentDetails.setVisible(true);			
				frmStudentDetails.dispose();}

		});




		listStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentList studentList = new StudentList();
				studentList.setVisible(true);
				frmStudentDetails.dispose();}
		});





		newSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewSupplier window1 = new NewSupplier();
				window1.setVisible(true);
				frmStudentDetails.dispose();
			}
		});



		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HostelAppLogin window = new HostelAppLogin();
				window.frmHostelAppLogin.setVisible(true);
				frmStudentDetails.dispose();}
		});



		listSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierList frmSupplierList = new SupplierList();
				frmSupplierList.setVisible(true);
				frmStudentDetails.dispose();
			}
		});		

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 69, 0));
		panel_6.setBounds(0, 21, 1094, 57);
		frmStudentDetails.getContentPane().add(panel_6,BorderLayout.NORTH);


		JLabel lblStudentDetailForm = new JLabel("STUDENT DETAIL FORM");
		panel_6.add(lblStudentDetailForm);
		lblStudentDetailForm.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblStudentDetailForm.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel background = new JLabel(new ImageIcon("assets//student.jpg"));
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		background.setBounds(0,0,d.width,d.height);
		frmStudentDetails.getContentPane().add(background);




	}
}
