package com.globsyn.prepaidtaxibooking;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Toolkit;

import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;



import javax.swing.UIManager;
import java.awt.Window.Type;
import java.io.*;
import java.util.Scanner;
public class Login {

	private JFrame PrepaidTaxiBookingApplication;
	private JTextField Username;
	private JPasswordField Password;
	protected Component frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.PrepaidTaxiBookingApplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		PrepaidTaxiBookingApplication = new JFrame();
		PrepaidTaxiBookingApplication.getContentPane().setForeground(Color.WHITE);
		PrepaidTaxiBookingApplication.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/images/icon.jpg")));
		PrepaidTaxiBookingApplication.setForeground(new Color(255, 69, 0));
		PrepaidTaxiBookingApplication.setTitle("Login");
		PrepaidTaxiBookingApplication.setFont(new Font("Algerian", Font.BOLD, 34));
		PrepaidTaxiBookingApplication.getContentPane().setBackground(Color.BLACK);
		//PrepaidTaxiBookingApplication.setIconImage(Toolkit.getDefaultToolkit().getImage(LoginPage.class.getResource("/com/car/booking/117.jpg")));
		PrepaidTaxiBookingApplication.setBackground(new Color(51, 255, 153));
		PrepaidTaxiBookingApplication.setBounds(0, 0, 900,500);
		PrepaidTaxiBookingApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PrepaidTaxiBookingApplication.getContentPane().setLayout(null);
		
		
	
		JButton Login = new JButton("LOGIN");
		Login.setBackground(new Color(95, 158, 160));
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = Username.getText();
				String password = Password.getText();
				
				if(user!=null && password!=null
						&& !"".equals(user.trim()) && !"".equals(password.trim())){
					
					File f = new File("assets/data/User.dat");

					if(f.exists())
					System.out.println("Exists");
					Scanner scanner;
					try {
						scanner = new Scanner(f);
						boolean userFound=false;
						while (scanner.hasNextLine()) {
							String line = (String) scanner.nextLine();

							System.out.println(line);
							
							if(line.toLowerCase().contains(user.toLowerCase())){
								userFound= true;
								
								String tokens[] = line.split("[|]");
								
								String passcode = tokens[1];
								
								if(passcode.trim().equals(password)){
									JOptionPane.showMessageDialog(frame, "Welcome ");
									Home home = new Home();
									home.setVisible(true);
									PrepaidTaxiBookingApplication.dispose();
								}else{
									JOptionPane.showMessageDialog(frame, "Password does not match. Please, enter correct password.","Incorrect Password",JOptionPane.ERROR_MESSAGE);
								}
								break;
							}

						}
						
						
						if(!userFound){
							JOptionPane.showMessageDialog(frame, "User Id does not exist. Please, enter correct user id.","Incorrect User Id",JOptionPane.ERROR_MESSAGE);
						}
						
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}else{
					JOptionPane.showMessageDialog(frame, "Please, enter your credentials.","No Input",JOptionPane.ERROR_MESSAGE);
				}
						
				}
								
				
	});
		
		Login.setFont(new Font("Georgia", Font.BOLD, 18));
		Login.setForeground(SystemColor.activeCaptionText);
	
		
		Login.setBounds(112, 374, 171, 37);
		PrepaidTaxiBookingApplication.getContentPane().add(Login);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(75, 324, 823, 15);
		PrepaidTaxiBookingApplication.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("USERNAME:");
		lblNewLabel.setBounds(95, 98, 304, 67);
		PrepaidTaxiBookingApplication.getContentPane().add(lblNewLabel);
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 40));
		
		Username = new JTextField();
		Username.setBounds(469, 100, 271, 65);
		PrepaidTaxiBookingApplication.getContentPane().add(Username);
		Username.setFont(new Font("Arial", Font.PLAIN, 32));
		Username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		Username.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD:");
		lblNewLabel_1.setBounds(95, 211, 250, 73);
		PrepaidTaxiBookingApplication.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("SimSun", Font.BOLD, 40));
		lblNewLabel_1.setForeground(Color.ORANGE);
		
		Password = new JPasswordField();
		Password.setBounds(469, 213, 271, 71);
		PrepaidTaxiBookingApplication.getContentPane().add(Password);
		Password.setFont(new Font("Arial", Font.PLAIN, 32));
		
		JButton btnNewButton = new JButton("SIGN UP");
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignUp sp=new SignUp();
				sp.setVisible(true);
			}
		});
		btnNewButton.setBounds(618, 374, 141, 37);
		PrepaidTaxiBookingApplication.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Old English Text MT", Font.PLAIN, 36));
		lblNewLabel_2.setBounds(359, 11, 184, 27);
		PrepaidTaxiBookingApplication.getContentPane().add(lblNewLabel_2);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		PrepaidTaxiBookingApplication.setVisible(b);
	}


	
	
	
		
	
}

