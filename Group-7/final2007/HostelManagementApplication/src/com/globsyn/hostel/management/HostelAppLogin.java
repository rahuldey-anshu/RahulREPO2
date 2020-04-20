package com.globsyn.hostel.management;

import java.awt.EventQueue;
import java.io.*;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Scanner;

public class HostelAppLogin {

	JFrame frmHostelAppLogin;
	private JTextField userName;
	private JPasswordField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HostelAppLogin window = new HostelAppLogin();
					window.frmHostelAppLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HostelAppLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHostelAppLogin = new JFrame();
		frmHostelAppLogin.setIconImage(Toolkit.getDefaultToolkit().getImage("assets\\icon17.png"));
		frmHostelAppLogin.setTitle("Hostel Management Application");
		frmHostelAppLogin.setBounds(100, 100, 856, 524);
		frmHostelAppLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHostelAppLogin.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLUE);
		panel.setBackground(Color.BLUE);
		frmHostelAppLogin.getContentPane().add(panel, BorderLayout.NORTH);

		final JLabel lblHostelApplication = new JLabel("Hostel Management Application");
		lblHostelApplication.setForeground(Color.WHITE);
		lblHostelApplication.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblHostelApplication.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblHostelApplication);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		frmHostelAppLogin.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(null);
		
		JLabel lblEnterUserName = new JLabel("Username:");
		lblEnterUserName.setForeground(Color.WHITE);
		lblEnterUserName.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterUserName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterUserName.setBounds(200, 129, 199, 32);
		panel_2.add(lblEnterUserName);

		JLabel lblEnterPassword = new JLabel("Password:");
		lblEnterPassword.setForeground(Color.WHITE);
		lblEnterPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEnterPassword.setBounds(200, 209, 199, 32);
		panel_2.add(lblEnterPassword);

		userName = new JTextField();
		userName.setHorizontalAlignment(SwingConstants.CENTER);
		userName.setBounds(477, 133, 148, 32);
		panel_2.add(userName);
		userName.setColumns(10);

		Password = new JPasswordField();
		Password.setHorizontalAlignment(SwingConstants.CENTER);
		Password.setBounds(476, 213, 149, 32);
		panel_2.add(Password);

		JLabel lblPlaseEnterThe = new JLabel("Please enter the credentials to login!");
		lblPlaseEnterThe.setForeground(Color.WHITE);
		lblPlaseEnterThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaseEnterThe.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPlaseEnterThe.setBounds(150, 24, 533, 41);
		panel_2.add(lblPlaseEnterThe);

		JButton btnLogIn = new JButton("");

		frmHostelAppLogin.getRootPane().setDefaultButton(btnLogIn);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String user = userName.getText();
				String password = Password.getText();

				if(user!=null && password!=null
						&& !"".equals(user.trim()) && !"".equals(password.trim())){

					File f = new File("assets\\forms\\password.txt");

					boolean e = f.exists();

					System.out.println(e);
					Scanner scanner;
					try {
						scanner = new Scanner(f);
						boolean userFound=false;
						while (scanner.hasNext()) {
							String line = (String) scanner.next();

							System.out.println(line);

							if(line.toLowerCase().contains(user.toLowerCase())){
								userFound= true;

								String tokens[] = line.split("[|]");

								String passcode = tokens[1];

								if(passcode.trim().equals(password)){
									JOptionPane.showMessageDialog(lblHostelApplication, "Welcome " + user);
									HomePage home = new HomePage();
									home.main(tokens);
									//home.setVisible(true);

									frmHostelAppLogin.dispose();
								}else{
									JOptionPane.showMessageDialog(lblHostelApplication, "Password does not match. Please, enter correct password.","Incorrect Password",JOptionPane.ERROR_MESSAGE);
								}
								break;
							}

						}


						if(!userFound){
							JOptionPane.showMessageDialog(lblHostelApplication, "User Id does not exist. Please, enter correct user id.","Incorrect User Id",JOptionPane.ERROR_MESSAGE);
						}


					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}


				}else{
					JOptionPane.showMessageDialog(lblHostelApplication, "Please, enter your credentials.","No Input",JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnLogIn.setForeground(new Color(153, 102, 0));
		btnLogIn.setBackground(Color.BLACK);
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogIn.setIcon(new ImageIcon("assets\\login-button-png-18019.jpg"));
		btnLogIn.setBounds(498, 319, 170, 40);
		panel_2.add(btnLogIn);

		JButton btnCreateNew = new JButton("");
		btnCreateNew.setIcon(new ImageIcon("assets\\register-button-pilll-red-hi.png"));
		btnCreateNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = userName.getText();
				String password = Password.getText();
				if(user!=null && password!=null
						&& !"".equals(user.trim()) && !"".equals(password.trim()))
				{

					
					File f=new File("assets\\forms\\password.txt");
					FileWriter fw = null;


					try {
						fw = new FileWriter(f,true);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					BufferedWriter bw=new BufferedWriter(fw);
					try {
							
						bw.write(user);
						bw.write("|");
						bw.write(password);
						bw.newLine();
						bw.close();
						userName.setText("");
						Password.setText("");
						
						JOptionPane.showMessageDialog(lblHostelApplication, "Your account has been created");
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("cannot write into file!");
						e.printStackTrace();
					}



				}
				else
					JOptionPane.showMessageDialog(lblHostelApplication, "Please, enter your credentials.","No Input",JOptionPane.ERROR_MESSAGE);	

			}
		});
		btnCreateNew.setForeground(Color.RED);
		btnCreateNew.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCreateNew.setBackground(Color.RED);
		btnCreateNew.setBounds(217, 319, 170, 40);
		panel_2.add(btnCreateNew);
		
		JLabel background = new JLabel(new ImageIcon("assets\\loginPage.jpg"));
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		background.setBounds(0,0,d.width,d.height);
		//frmHostelAppLogin.getContentPane().add(background);
		//panel_2.add(background);
		panel_2.add(background);
		
		
		
		JLabel picLabel = new JLabel("");
		
	}
}