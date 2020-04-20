package com.globsyn.wholesalebusiness;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Toolkit;

public class LoginPage {

	JFrame frmLoginForGalaxy;
	private JTextField textFieldUN;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frmLoginForGalaxy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginForGalaxy = new JFrame();
		frmLoginForGalaxy.setIconImage(Toolkit.getDefaultToolkit().getImage("icons//diamond-icon.png"));
		frmLoginForGalaxy.setTitle("Login for Galaxy Electronics Wholesaler Services");
		frmLoginForGalaxy.setBounds(100, 100, 584, 392);
		frmLoginForGalaxy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginForGalaxy.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(160, 42, 244, 172);
		frmLoginForGalaxy.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 107, 96, 22);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("User name :");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 41, 96, 22);
		panel.add(lblNewLabel_1);

		textFieldUN = new JTextField();
		textFieldUN.setBounds(101, 43, 116, 20);
		panel.add(textFieldUN);
		textFieldUN.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(101, 110, 116, 20);
		panel.add(passwordField);

		JButton btnLogin = new JButton("Log in");
		

		frmLoginForGalaxy.getRootPane().setDefaultButton(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			String userName, passWord;

			public void actionPerformed(ActionEvent arg0) {
				String user = textFieldUN.getText();
				String password = passwordField.getText();

				if(user!=null && password!=null
						&& !"".equals(user.trim()) && !"".equals(password.trim())){
					
					File f = new File("database/user.dat");

					boolean e = f.exists();

					System.out.println(e);
					Scanner scanner;
					try {
						scanner = new Scanner(f);
						boolean userFound=false;
						while (scanner.hasNext()) {
							String line = (String) scanner.nextLine();

							System.out.println(line);
							
							if(line.toLowerCase().contains(user.toLowerCase())){
								userFound= true;
								
								String tokens[] = line.split("[|]");
								
								String passcode = tokens[1];
								
								if(passcode.trim().equals(password)){
									HomePage home = new HomePage();
									home.setVisible(true);
									
									frmLoginForGalaxy.dispose();
								}else{
									JOptionPane.showMessageDialog(null, "Password does not match. Please, enter correct password.","Incorrect Password",JOptionPane.ERROR_MESSAGE);
								}
								break;
							}

						}
						
						
						if(!userFound){
							JOptionPane.showMessageDialog(null, "User Id does not exist. Please, enter correct user id.","Incorrect User Id",JOptionPane.ERROR_MESSAGE);
						}
						
						
					} catch (FileNotFoundException e1) {
						
						e1.printStackTrace();
					}
					
					
				}else{
					JOptionPane.showMessageDialog(null, "Please, enter your credentials.","No Input",JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnLogin.setBackground(null);
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnLogin.setBounds(391, 253, 89, 54);
		frmLoginForGalaxy.getContentPane().add(btnLogin);

		JButton btnExit1 = new JButton("Exit");
		btnExit1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnExit1.setBackground(null);
		btnExit1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnExit1.setBounds(102, 253, 89, 54);
		frmLoginForGalaxy.getContentPane().add(btnExit1);
		
		JButton btnNewButton = new JButton("New user?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewUser frame = new NewUser();
				frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnNewButton.setBounds(233, 253, 113, 54);
		frmLoginForGalaxy.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("icons//business.jpg"));
		label.setBounds(0, 0, 568, 354);
		frmLoginForGalaxy.getContentPane().add(label);
	}
}
