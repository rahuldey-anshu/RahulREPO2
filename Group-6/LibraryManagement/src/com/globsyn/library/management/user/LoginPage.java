package com.globsyn.library.management.user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPage() 
	{
		
		JLabel label = new JLabel(new ImageIcon("src\\b.jpg"));
		setContentPane(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 ImageIcon icon = new ImageIcon("G:\\lib.png");
    	 setIconImage(icon.getImage());
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//setgetContentPane()(getContentPane());
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please enter the following details  :");
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lblNewLabel.setBounds(140, 48, 579, 29);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User name  :");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		lblNewLabel_1.setBounds(140, 141, 212, 29);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password  :");
		lblNewLabel_2.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBounds(140, 202, 212, 29);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(401, 141, 181, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(401, 208, 181, 20);
		getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String user = textField.getText();
				String password = passwordField.getText();
				
				Component lblLibraryManagement = null;
				if(user!=null && password!=null
						&& !"".equals(user.trim()) && !"".equals(password.trim())){
					
					File f = new File("data/users.dat");

					boolean be = f.exists();

					Scanner scanner;
					try {
						scanner = new Scanner(f);
						boolean userFound=false;
						while (scanner.hasNext()) {
							String line = (String) scanner.next();

							if(line.toLowerCase().contains(user.toLowerCase())){
								userFound= true;
								
								String tokens[] = line.split("[|]");
								
								String passcode = tokens[1];
								
								if(passcode.trim().equals(password)){
									JOptionPane.showMessageDialog(lblLibraryManagement, "Welcome " + user);
									Welcome home = new Welcome();
									home.setVisible(true);
						           			dispose();
								}else{
									JOptionPane.showMessageDialog(lblLibraryManagement, "Password does not match. Please, enter correct password.","Incorrect Password",JOptionPane.ERROR_MESSAGE);
								}
								break;
							}

						}
						
						
						if(!userFound){
							JOptionPane.showMessageDialog(lblLibraryManagement, "User Id does not exist. Please, enter correct user id.","Incorrect User Id",JOptionPane.ERROR_MESSAGE);
						}
						
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}else{
					JOptionPane.showMessageDialog(lblLibraryManagement, "Please, enter your credentials.","No Input",JOptionPane.ERROR_MESSAGE);
				}

				
			
				
			}
		});
		btnNewButton.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(140, 297, 116, 42);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add User");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddUser addUser =  new AddUser();
				addUser.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		btnNewButton_1.setBounds(300, 297, 123, 42);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
				
			}
		});
		btnNewButton_2.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		btnNewButton_2.setBounds(466, 297, 116, 42);
		getContentPane().add(btnNewButton_2);
	}
}
