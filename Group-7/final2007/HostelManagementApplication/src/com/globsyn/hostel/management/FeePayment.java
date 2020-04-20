package com.globsyn.hostel.management;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import com.sun.javafx.font.Disposer;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;

public class FeePayment {

	JFrame frmFeePayment;
	private JTextField fee;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField name;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeePayment window = new FeePayment();
					window.frmFeePayment.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FeePayment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFeePayment = new JFrame();
		frmFeePayment.setTitle("Hostel Management Application");
		frmFeePayment.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmFeePayment.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 18));
		frmFeePayment.setIconImage(Toolkit.getDefaultToolkit().getImage("assets\\icon17.png"));
		frmFeePayment.setBounds(100, 100, 791, 885);
		frmFeePayment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFeePayment.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setBounds(0, 0, 809, 47);
		frmFeePayment.getContentPane().add(panel);
		
		
		final JLabel lblWholeSaleApplication = new JLabel("Payment Page");
		lblWholeSaleApplication.setForeground(new Color(250, 240, 230));
		lblWholeSaleApplication.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblWholeSaleApplication.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblWholeSaleApplication);
		
		JLabel lblTotalAmountPayable = new JLabel("Total Amount Payable:");
		lblTotalAmountPayable.setForeground(new Color(240, 248, 255));
		lblTotalAmountPayable.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTotalAmountPayable.setBounds(152, 150, 178, 23);
		frmFeePayment.getContentPane().add(lblTotalAmountPayable);
		
		JLabel lblPaymentMethod = new JLabel("Payment Method:");
		lblPaymentMethod.setForeground(new Color(250, 250, 210));
		lblPaymentMethod.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPaymentMethod.setBounds(165, 238, 144, 14);
		frmFeePayment.getContentPane().add(lblPaymentMethod);
		
		JRadioButton cash = new JRadioButton("Cash");
		buttonGroup.add(cash);
		cash.setFont(new Font("Tahoma", Font.BOLD, 15));
		cash.setBounds(396, 234, 109, 23);
		frmFeePayment.getContentPane().add(cash);
		
		JRadioButton cheque = new JRadioButton("Cheque");
		buttonGroup.add(cheque);
		cheque.setFont(new Font("Tahoma", Font.BOLD, 15));
		cheque.setBounds(396, 260, 109, 23);
		frmFeePayment.getContentPane().add(cheque);
		JLabel pay = new JLabel("");
		pay.setBounds(615, 292, 46, 14);
		frmFeePayment.getContentPane().add(pay);
		
		JRadioButton Dd = new JRadioButton("DD");
		buttonGroup.add(Dd);
		Dd.setFont(new Font("Tahoma", Font.BOLD, 15));
		Dd.setBounds(396, 286, 109, 23);
		frmFeePayment.getContentPane().add(Dd);
		
		JRadioButton Neft = new JRadioButton("NEFT");
		buttonGroup.add(Neft);
		Neft.setFont(new Font("Tahoma", Font.BOLD, 15));
		Neft.setBounds(396, 312, 109, 23);
		frmFeePayment.getContentPane().add(Neft);
		fee = new JTextField();
		fee.setEditable(false);
		fee.setBounds(396, 153, 109, 20);
		frmFeePayment.getContentPane().add(fee);
		fee.setColumns(10);
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(new Color(240, 248, 255));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(152, 91, 178, 23);
		frmFeePayment.getContentPane().add(lblName);
		
		name = new JTextField();
		name.setEditable(false);
		name.setBounds(396, 93, 109, 20);
		frmFeePayment.getContentPane().add(name);
		name.setColumns(10);
		
		
		String filePath1="assets//forms//selectedRoom.dat";
		BufferedReader input1 = null;
		String fourth=null,fifth=null;
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
			  fourth=fields[3];
			  fifth=fields[4];
		  }
		}

		catch (IOException e) {
		    System.err.println("Error, file " + filePath1+ " didn't exist.");
		}
		if(fourth.equals("7000"))
		{
			fee.setText("7000");
		}
		else if(fourth.equals("8000"))
		{
			fee.setText("8000");
		}
		name.setText(fifth);
			
		
		
		
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setIcon(new ImageIcon("assets\\paynow.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(fee.getText()!=null && buttonGroup.getSelection()!=null && lblName.getText()!=null )
				{
					JOptionPane.showMessageDialog(lblTotalAmountPayable, "Thank you for paying fee!");
					File f1=new File("assets//forms//bookedRooms.dat");
					File f2=new File("assets//forms//temp.dat");
					String choice;
					String nameOfStudent=name.getText().toString();
					
					try {
						f2.createNewFile();
						FileWriter fw=new FileWriter(f2);
						Scanner f1scanner=new Scanner(f1);
						BufferedWriter bw=new BufferedWriter(fw);
						
						while(f1scanner.hasNext())
						{
						String line=f1scanner.nextLine();
							   
						 String [] deli = line.split("[|]");
						 System.out.println(deli[4]);
						 if(cash.isSelected())
							{
								pay.setText("cash");
								System.out.println("cash");
							}
							else if(cheque.isSelected())
							{
								pay.setText("cheque");;
								System.out.println("cheque");
							}
							else if(Dd.isSelected())
							{
								pay.setText("DD");
								System.out.println("dd");
							}
							else if(Neft.isSelected())
							{
								pay.setText("NEFT");;
								System.out.println("neft");
							}
							    if(deli[4].equals(nameOfStudent))
							    {	
							    	System.out.println("success");
							    	line=line + "|" + pay.getText().toString() ;
							    	
							    }
							    
							    	
							    
							    	
						bw.write(line);
						bw.newLine();
						
						
						}
						
						bw.flush();
						bw.close();
						f1scanner.close();
							
							f1.delete();
							f2.renameTo(f1);
							
														
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					HomePage window = new HomePage();
					window.frmHomePage.setVisible(true);
					frmFeePayment.dispose();
					
				}
				else
					JOptionPane.showMessageDialog(lblPaymentMethod, "Please fillup all the details", "Error",
							JOptionPane.ERROR_MESSAGE);
			}
		});
		btnNewButton.setBounds(333, 415, 109, 29);
		frmFeePayment.getContentPane().add(btnNewButton);
		
		JLabel background = new JLabel(new ImageIcon("assets\\money.jpg"));
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		background.setBounds(0,0,d.width,d.height);
		
				
		frmFeePayment.getContentPane().add(background);
		
		
		
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frmFeePayment.setJMenuBar(menuBar);
		
		JMenu mnNew = new JMenu("Student");
		menuBar.add(mnNew);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_MASK));
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentDetails window = new StudentDetails();
				window.frmStudentDetails.setVisible(true);			
				frmFeePayment.dispose();}
		});
		
		mnNew.add(mntmNew);
		
		JSeparator separator_2 = new JSeparator();
		mnNew.add(separator_2);
		
		JMenuItem mntmList = new JMenuItem("List");
		mntmList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentList studentList = new StudentList();
				studentList.setVisible(true);
				frmFeePayment.dispose();}
		});
		
		mntmList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK));
		mnNew.add(mntmList);
		
		JMenu mnSupplier = new JMenu("Supplier");
		menuBar.add(mnSupplier);
		
		JMenuItem mntmAdd = new JMenuItem("New");
		mntmAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewSupplier window1 = new NewSupplier();
				window1.setVisible(true);
				frmFeePayment.dispose();
			}
		});
		mnSupplier.add(mntmAdd);
		
		JSeparator separator_1 = new JSeparator();
		mnSupplier.add(separator_1);
		
		JMenuItem mntmList_1 = new JMenuItem("List");
		mntmList_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierList frmSupplierList = new SupplierList();
				frmSupplierList.setVisible(true);
				frmFeePayment.dispose();
			}
		});
		mntmList_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mnSupplier.add(mntmList_1);
		
		JMenu mnRoom = new JMenu("Room");
		menuBar.add(mnRoom);
		
		JMenuItem mntmAllocate = new JMenuItem("Allocate");
		mntmAllocate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RoomsFinal frame = new RoomsFinal();
				frame.setVisible(true);
				frmFeePayment.dispose();
			}
		});
		mnRoom.add(mntmAllocate);
		
		JSeparator separator = new JSeparator();
		mnRoom.add(separator);
		
		JMenuItem mntmBooked = new JMenuItem("Booked");
		mntmBooked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookedList frame = new BookedList();
				frame.setVisible(true);
				frmFeePayment.dispose();

			}
		});
		mnRoom.add(mntmBooked);
		
		
		JMenu mnLogout = new JMenu("Logout");
		menuBar.add(mnLogout);
		
		JMenuItem mntmConfirm = new JMenuItem("Confirm");
		mntmConfirm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.ALT_MASK));
		mntmConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HostelAppLogin window = new HostelAppLogin();
				window.frmHostelAppLogin.setVisible(true);
				frmFeePayment.dispose();}
		});
		mnLogout.add(mntmConfirm);
	}
}
