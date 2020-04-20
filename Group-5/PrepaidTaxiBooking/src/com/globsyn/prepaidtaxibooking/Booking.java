package com.globsyn.prepaidtaxibooking;

import java.awt.EventQueue;
import java.io.*;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Booking {
	private JFrame frmBooking;
	 JTextField textField;
	 JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)throws IOException {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Booking window = new Booking();
					window.frmBooking.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Booking() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBooking = new JFrame();
		frmBooking.setTitle("BOOKING");
		frmBooking.getContentPane().setBackground(Color.WHITE);
		frmBooking.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CUSTOMER NAME:");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 21));
		lblNewLabel.setBounds(22, 32, 179, 24);
		frmBooking.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial Black", Font.PLAIN, 15));
		textField.setBounds(250, 34, 171, 20);
		frmBooking.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("CONTACT NO.:");
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1.setFont(new Font("SimSun", Font.BOLD, 21));
		lblNewLabel_1.setBounds(22, 88, 179, 24);
		frmBooking.getContentPane().add(lblNewLabel_1);
		
			
		textField_1 = new JTextField();
        textField_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		textField_1.setBounds(250, 91, 171, 20);
		frmBooking.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		final int p=9;
		textField_1.addKeyListener(new KeyAdapter() {
			    public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      
			      int i=textField_1.getText().length();
			      
			     
			      if (!((c >= '0') && (c <= '9') && (i<=p) ||
			         (c == KeyEvent.VK_BACK_SPACE) ||
			         (c == KeyEvent.VK_DELETE))) {
			         e.consume();
			         textField_1.setBackground(Color.white);
			      }
			      else {
			    	  textField_1.setBackground(Color.red);
			      }
			    }
			  });
		
		
		
		JLabel lblNewLabel_2 = new JLabel("NO. OF PASSENGERS:");
		lblNewLabel_2.setBackground(new Color(240, 248, 255));
		lblNewLabel_2.setForeground(new Color(240, 248, 255));
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 21));
		lblNewLabel_2.setBounds(22, 221, 218, 24);
		frmBooking.getContentPane().add(lblNewLabel_2);
		
		ArrayList<String> destinations=new ArrayList<>();
		destinations.add("Select");
		try {
			File f = new File("assets/data/Destinationdb.dat");
			
			if(f.exists()){
				Scanner scanner = new Scanner(f);
				while(scanner.hasNext()){
					String line = scanner.nextLine();
					String[] fields = line.split("[|]");
					
					destinations.add(fields[0]);
				}
			}
		} catch (FileNotFoundException e) {
			 
			e.printStackTrace();
		}
		String[] listofdest = destinations.toArray(new String[destinations.size()]);
		JComboBox comboBox = new JComboBox(listofdest);
		
		comboBox.setFont(new Font("Arial Black", Font.PLAIN, 11));
		comboBox.setBounds(250, 162, 171, 20);
		frmBooking.getContentPane().add(comboBox);
		
		
		
		
		JLabel lblNewLabel_3 = new JLabel("DESTINATION:");
		lblNewLabel_3.setBackground(Color.BLACK);
		lblNewLabel_3.setForeground(new Color(240, 248, 255));
		lblNewLabel_3.setFont(new Font("SimSun", Font.BOLD, 21));
		lblNewLabel_3.setBounds(22, 159, 195, 24);
		frmBooking.getContentPane().add(lblNewLabel_3);
		String[] passengerNumber={"Select","1","2","3","4","5","6"};
		JComboBox comboBox_1 = new JComboBox(passengerNumber);
		comboBox_1.setFont(new Font("Arial Black", Font.PLAIN, 11));
		comboBox_1.setBounds(250, 224, 171, 20);
		frmBooking.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_4 = new JLabel("CAR TYPE:");
		lblNewLabel_4.setBackground(Color.BLACK);
		lblNewLabel_4.setForeground(new Color(240, 248, 255));
		lblNewLabel_4.setFont(new Font("SimSun", Font.BOLD, 21));
		lblNewLabel_4.setBounds(22, 277, 179, 24);
		frmBooking.getContentPane().add(lblNewLabel_4);
		String[] carType={"Select","AC","NON AC"};
		JComboBox comboBox_2 = new JComboBox(carType);
		comboBox_2.setFont(new Font("Arial Black", Font.PLAIN, 11));
		comboBox_2.setBounds(250, 280, 171, 20);
		frmBooking.getContentPane().add(comboBox_2);
		
		
		ArrayList<String> caravail=new ArrayList<>();
		
		caravail.add("Select");
		try {
			File f = new File("assets/data/taxiname.dat");
			
			if(f.exists()){
				Scanner scanner = new Scanner(f);
				while(scanner.hasNext()){
					String line = scanner.nextLine();
					String[] fields = line.split("[|]");
					
					caravail.add(fields[0]);
					
				}
			}
		} catch (FileNotFoundException e) {
			 
			e.printStackTrace();
		}
		String[] listofcar = caravail.toArray(new String[caravail.size()]);
		
		JComboBox comboBox_3 = new JComboBox( listofcar);
		comboBox_3.setFont(new Font("Arial Black", Font.PLAIN, 11));
		comboBox_3.setBounds(253, 343, 168, 20);
		frmBooking.getContentPane().add(comboBox_3);
		
		JLabel lblNewLabel_5 = new JLabel("CARS AVAILABLE:");
		lblNewLabel_5.setBackground(Color.BLACK);
		lblNewLabel_5.setForeground(new Color(240, 248, 255));
		lblNewLabel_5.setFont(new Font("SimSun", Font.BOLD, 21));
		lblNewLabel_5.setBounds(22, 340, 218, 24);
		frmBooking.getContentPane().add(lblNewLabel_5);
		
		
		
		JButton btnNewButton = new JButton("PREVIEW");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(new Color(255, 215, 0));
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 12));
		btnNewButton.setBounds(309, 419, 135, 31);
		frmBooking.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener()
				{
			        //Override
					
			public void actionPerformed(ActionEvent arg0) {
						 
				
				String cn=(String)comboBox_3.getSelectedItem();
				String carno=null;
				String drivername=null;
				String driverlisence=null;
				String driverph=null;
				try {
					File f = new File("assets/data/taxiname.dat");
					
					if(f.exists()){
						Scanner scanner = new Scanner(f);
						while(scanner.hasNext()){
							String line = scanner.nextLine();
							String[] fields = line.split("[|]");
							if(cn.equals(fields[0]))
							{
								carno=fields[1];
								drivername=fields[2];
								driverlisence=fields[3];
								driverph=fields[4];
							}
							
							
						}
					}
				} catch (FileNotFoundException e) {
					 
					e.printStackTrace();
				}
				
				      		String path="assets/data/Customer.dat";
				      		
				      		File f=new File(path);
				      		
				      		if(f.exists())
				      		{
				      		FileWriter fr=null;
				      		
							try {
								fr = new FileWriter(f);
								
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				      		BufferedWriter bw=new BufferedWriter(fr);
				      		
				      		
				      		try {
								bw.write(textField.getText()+"|"+textField_1.getText()+"|"+(String)comboBox.getSelectedItem()+"|"+(String)comboBox_1.getSelectedItem()+"|"+(String)comboBox_2.getSelectedItem()+"|"+(String)comboBox_3.getSelectedItem()+"|"+carno+"|"+drivername+"|"+driverlisence+"|"+driverph);
								
								
								
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				      		
				      		try {
								bw.close();
								
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				      		}
				    				
				    	
				      		Confirm c1=new Confirm();
				      		c1.setVisible(true);
			
				      		frmBooking.dispose();
				      		
				     
						// TODO Auto-generated method stub
						 				
					}
				});
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home home=new Home();
				home.setVisible(true);
				frmBooking.dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setForeground(new Color(255, 215, 0));
		btnNewButton_1.setFont(new Font("Georgia", Font.BOLD, 12));
		btnNewButton_1.setBounds(525, 419, 120, 29);
		frmBooking.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon(Booking.class.getResource("/images/taxisign.jpg")));
		lblNewLabel_6.setBounds(0, 0, 784, 461);
		frmBooking.getContentPane().add(lblNewLabel_6);
		frmBooking.setIconImage(Toolkit.getDefaultToolkit().getImage(Booking.class.getResource("/images/icon.jpg")));
		frmBooking.setBounds(0, 0, 800, 500);
		frmBooking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisible(boolean b) {
		frmBooking.setVisible(b);
		// TODO Auto-generated method stub
		
	}
	}
