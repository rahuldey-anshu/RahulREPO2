package com.globsyn.library.management.user;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.globsyn.library.management.books.BookList;

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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class AddUser extends JFrame {

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
					AddUser frame = new AddUser();
					frame.setVisible(true);
					//frame.setTitle("ADD USERS");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddUser() 
	{
		
		
		File f = new File("data/users.dat");
		FileWriter fw=null;
		try {
			fw = new FileWriter(f,true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		BufferedWriter bw=new BufferedWriter(fw);
		
		
		JLabel label = new JLabel(new ImageIcon("src\\b.jpg"));
		label.setForeground(Color.PINK);
		setContentPane(label);
		
		ImageIcon icon = new ImageIcon("src\\lib.png");
		setIconImage(icon.getImage());
		
		setTitle("ADD USERS");
		
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 468);
		setContentPane(getContentPane());
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please enter the following details  :");
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		lblNewLabel.setBounds(40, 27, 433, 27);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username  :");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		lblNewLabel_1.setBounds(40, 112, 171, 27);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password  :");
		lblNewLabel_2.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBounds(40, 173, 171, 27);
		getContentPane().add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(259, 115, 137, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(259, 176, 137, 20);
		getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(40, 258, 125, 33);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String userName=textField.getText();
				String password = passwordField.getText();
				if(f.exists())
				{
					String dataToWrite = userName+ "|" +password+ "\n";
					
					try 
					{
						bw.write(dataToWrite);
						bw.flush();
						bw.close();
						
						
						
						Component lblLibraryManagement = null;
						JOptionPane.showMessageDialog(lblLibraryManagement, userName + " Added Successfully ");	
					LoginPage loginPage = new LoginPage();
					setVisible(true);
					setExtendedState(JFrame.MAXIMIZED_BOTH);
					dispose();
						
						
						
							//ListOfUsers userList = new  ListOfUsers();
							//userList.setVisible(true);
							//dispose();
						//}
					} catch (IOException ioe) 
					{
						ioe.printStackTrace();
						JOptionPane.showMessageDialog(getContentPane(), "Unable to save retailer data.", "Save Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (Exception ioe) 
					{
						JOptionPane.showMessageDialog(getContentPane(), "Unable to save retailer data.", "Save Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(getContentPane(), "Unable to save retailer data.", "Save Error",
							JOptionPane.ERROR_MESSAGE);
				}
				
				LoginPage loginPage = new LoginPage();
				loginPage.setVisible(true);
				setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
			}
		});
		
		
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginPage loginPage = new LoginPage();
				loginPage.setVisible(true);
				setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
				
			}
		});
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton_1.setBounds(298, 258, 98, 33);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textField.setText("");
				passwordField.setText("");
				
			}
		});
		btnNewButton_2.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.setBounds(186, 258, 89, 33);
		getContentPane().add(btnNewButton_2);
	}
}
