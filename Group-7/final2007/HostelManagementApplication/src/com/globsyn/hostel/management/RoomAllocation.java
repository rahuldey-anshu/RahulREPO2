package com.globsyn.hostel.management;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import java.awt.SystemColor;

public class RoomAllocation {

	JFrame frmRoomAllocation;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField roomNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomAllocation window = new RoomAllocation();
					window.frmRoomAllocation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RoomAllocation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRoomAllocation = new JFrame();
		frmRoomAllocation.setTitle("Hostel Management Application");
		frmRoomAllocation.setIconImage(Toolkit.getDefaultToolkit().getImage("assets\\icon17.png"));
		frmRoomAllocation.setBounds(100, 100, 802, 819);
		frmRoomAllocation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		frmRoomAllocation.getContentPane().add(panel, BorderLayout.NORTH);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.scrollbar);
		frmRoomAllocation.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblRoomNumber = new JLabel("Type of Room:");
		lblRoomNumber.setForeground(Color.WHITE);
		lblRoomNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRoomNumber.setBounds(93, 205, 130, 28);
		panel_1.add(lblRoomNumber);
		
		JLabel label_1 = new JLabel("Room Number:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(93, 132, 130, 28);
		panel_1.add(label_1);
		
		JLabel lblRoomFee = new JLabel("Room Fee:");
		lblRoomFee.setForeground(Color.WHITE);
		lblRoomFee.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRoomFee.setBounds(93, 407, 130, 28);
		panel_1.add(lblRoomFee);
		
		JRadioButton rs7000 = new JRadioButton(" Rs 7000 per month");
		buttonGroup_1.add(rs7000);
		rs7000.setBounds(452, 412, 130, 23);
		panel_1.add(rs7000);
		
		JRadioButton rs8000 = new JRadioButton("Rs 8000 per month");
		buttonGroup_1.add(rs8000);
		rs8000.setBounds(452, 438, 130, 23);
		panel_1.add(rs8000);
		
		
		
		
		
		
		JRadioButton bed2 = new JRadioButton("2 Bed");
		buttonGroup.add(bed2);
		bed2.setBounds(437, 205, 130, 23);
		panel_1.add(bed2);
		
		JRadioButton bed3 = new JRadioButton("3 Bed");
		buttonGroup.add(bed3);
		bed3.setBounds(437, 231, 130, 23);
		panel_1.add(bed3);
		
		JLabel lblBedNumber = new JLabel("Bed Number:");
		lblBedNumber.setForeground(Color.WHITE);
		lblBedNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBedNumber.setBounds(93, 309, 130, 28);
		panel_1.add(lblBedNumber);
		String filePath="assets//forms//selectedRoom.dat";
		BufferedReader input = null;
		try {
			input = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<String> strings = new ArrayList<String>();
		try {
		  String line = null;
		  while (( line = input.readLine()) != null)
		  {
			  String[] fields=line.split("[|]");
			  
			for(int i=0;i<fields.length-3;i++)
			{	  
		    strings.add(fields[i]);
			}
		  }
		}

		catch (IOException e) {
		    System.err.println("Error, file " + filePath + " didn't exist.");
		}
		

		String[] lineArray = strings.toArray(new String[] {});

		JComboBox comboBox = new JComboBox(lineArray);
		comboBox.setBounds(437, 124, 145, 20);
		panel_1.add(comboBox);
	
		JRadioButton A = new JRadioButton("A");
		A.setBounds(441, 314, 42, 23);
		panel_1.add(A);
		
		JRadioButton B = new JRadioButton("B");
		B.setBounds(497, 314, 42, 23);
		panel_1.add(B);
		
		JRadioButton C = new JRadioButton("C");
		C.setBounds(557, 314, 42, 23);
		panel_1.add(C);
		



		
		



String filePath1="assets//forms//selectedRoom.dat";
		BufferedReader input1 = null;
		String first=null,second=null,third=null,fourth=null;
		try {
			input1 = new BufferedReader(new FileReader(filePath1));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<String> strings1 = new ArrayList<String>();
		try {
		  String line = null;
		  while (( line = input1.readLine()) != null)
		  {
			  String[] fields=line.split("[|]");
			  first=fields[0];
			  second=fields[1];
			  third=fields[2];
			  fourth=fields[3];
		  }
		}

		catch (IOException e) {
		    System.err.println("Error, file " + filePath1+ " didn't exist.");
		}
		//comboBox.setSelectedItem(first);
		String lineArray1 = second.toString();
		if(lineArray1.equals("2 BED"))
		{
			bed2.setSelected(true);}
		else if(lineArray1.equals("3 BED"))
		{
			bed3.setSelected(true);
		}
		
		if(fourth.equals("7000"))
		{
			rs7000.setSelected(true);
		}
		else if(fourth.equals("8000"))
		{
			rs8000.setSelected(true);
		}
		
		if(third.equals("BED A"))
		{
			A.setSelected(true);
		}
		else if(third.equals("BED B"))
		{
			B.setSelected(true);
		}
		else
		{
			C.setSelected(true);
		}
			
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(93, 39, 130, 28);
		panel_1.add(lblName);
		
		JTextField studentName = new JTextField();
		studentName.setBounds(437, 45, 162, 20);
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
		panel_1.add(studentName);
		studentName.setColumns(10);

		
		
		
				
		
		
		
		
		
		final JLabel lblWholeSaleApplication = new JLabel(" Room Allocation Confirmation");
		lblWholeSaleApplication.setForeground(Color.LIGHT_GRAY);
		lblWholeSaleApplication.setBackground(Color.BLACK);
		lblWholeSaleApplication.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblWholeSaleApplication.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblWholeSaleApplication);
		
		JMenuBar menuBar = new JMenuBar();
		frmRoomAllocation.setJMenuBar(menuBar);
		
		JMenu mnNew = new JMenu("Student");
		menuBar.add(mnNew);
		
		JMenuItem newStudent = new JMenuItem("New");
		newStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_MASK));
		
		
		mnNew.add(newStudent);
		
		JSeparator separator = new JSeparator();
		mnNew.add(separator);
		
		JMenuItem listStudent = new JMenuItem("List");
		mnNew.add(listStudent);
		
		JSeparator separator_2 = new JSeparator();
		mnNew.add(separator_2);
		
		JMenu mnSupplier = new JMenu("Supplier");
		menuBar.add(mnSupplier);
		
		JMenuItem newSupplier = new JMenuItem("New");
		newSupplier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		
		mnSupplier.add(newSupplier);
		
		JSeparator separator_1 = new JSeparator();
		mnSupplier.add(separator_1);
		
		JMenuItem listSupplier = new JMenuItem("list");
		mnSupplier.add(listSupplier);
		
		JMenu mnRoom = new JMenu("Room");
		menuBar.add(mnRoom);
		
		JMenuItem mntmAllocate = new JMenuItem("Allocate");
		mntmAllocate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomsFinal frame = new RoomsFinal();
				frame.setVisible(true);
				frmRoomAllocation.dispose();
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
				frmRoomAllocation.dispose();

			}
		});
		mnRoom.add(mntmBooked);
		
		
		JMenu mnLogout = new JMenu("Logout");
		menuBar.add(mnLogout);
		
		JMenuItem confirm = new JMenuItem("Confirm");
		
		mnLogout.add(confirm);
		
		newStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentDetails window = new StudentDetails();
				window.frmStudentDetails.setVisible(true);			
			frmRoomAllocation.dispose();}

		});




listStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentList studentList = new StudentList();
				studentList.setVisible(true);
				frmRoomAllocation.dispose();}
		});



		
		
newSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewSupplier window1 = new NewSupplier();
				window1.setVisible(true);
				frmRoomAllocation.dispose();
			}
		});



confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HostelAppLogin window = new HostelAppLogin();
				window.frmHostelAppLogin.setVisible(true);
				frmRoomAllocation.dispose();}
		});



listSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierList frmSupplierList = new SupplierList();
				frmSupplierList.setVisible(true);
				frmRoomAllocation.dispose();
			}
		});		
JButton btnNewButton = new JButton("");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
		String name=studentName.getText();
		String combo=comboBox.getSelectedItem().toString();
		String bedNo=null,bedType=null,cost=null;
		if(bed2.isSelected())
		{
			bedType="2 BED";}
		else if(bed3.isSelected())
		{
			bedType="3 BED";
		}
		if(A.isSelected())
		{
			bedNo="BED A";
			
		}
		else if(B.isSelected())
		{
			bedNo="BED B";
			
		}
		else if(C.isSelected())
		{
			bedNo="BED C";
		}
		
		
		
		if(rs7000.isSelected())
		{
			cost="7000";
		}
		else if(rs8000.isSelected())
		{
			cost="8000";
		}
		
		File f1=new File("assets//forms//bookedRooms.dat");
		File f2=new File("assets//forms//selectedRoom.dat");
		if(f1.exists())
		{
			String data=combo + "|" + bedType + "|" + bedNo + "|" + cost + "|" + name + "\n";
			
		
		try {
			FileWriter fw=new FileWriter(f1,true);
			FileWriter fw1=new FileWriter(f2,false);
			BufferedWriter bw=new BufferedWriter(fw);
			BufferedWriter bw1=new BufferedWriter(fw1);
			bw.write(data);
			
			bw.flush();
			bw.close();
			bw1.write(data);
			
			bw1.flush();
			bw1.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}
		
	
		
		FeePayment window = new FeePayment();
		window.frmFeePayment.setVisible(true);
		frmRoomAllocation.dispose();
	}
});
btnNewButton.setIcon(new ImageIcon("assets\\payment.png"));
btnNewButton.setBounds(294, 549, 170, 50);
panel_1.add(btnNewButton);
JLabel background = new JLabel(new ImageIcon("assets\\hostelRoom.jpg"));
Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
background.setBounds(0,0,d.width,d.height);
panel_1.add(background);
	}
}
