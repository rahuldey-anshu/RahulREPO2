package com.globsyn.ticket.book;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.*;
import java.awt.*;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtEnterAdminId;
	private JPasswordField passwordField;
	protected Component temporaryLostComponent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}
	
	
	public void close(){

		WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);

		}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("IMAX");
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets\\images\\imax_icon.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 367);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtEnterAdminId = new JTextField();
		txtEnterAdminId.setToolTipText("Enter Admin ID");
		txtEnterAdminId.setForeground(Color.BLACK);
		txtEnterAdminId.setBackground(Color.WHITE);
		txtEnterAdminId.setBounds(177, 113, 157, 20);
		contentPane.add(txtEnterAdminId);
		txtEnterAdminId.setColumns(10);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		lblId.setForeground(new Color(255, 215, 0));
		lblId.setBounds(87, 102, 80, 40);
		contentPane.add(lblId);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Monotype Corsiva", Font.PLAIN, 25));
		lblPassword.setForeground(new Color(255, 215, 0));
		lblPassword.setBounds(69, 150, 98, 46);
		contentPane.add(lblPassword);
		
		JLabel NoMatch = new JLabel("");
		NoMatch.setForeground(Color.RED);
		NoMatch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		NoMatch.setBounds(177, 66, 157, 36);
		contentPane.add(NoMatch);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Enter Admin Password");
		passwordField.setForeground(Color.BLACK);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		passwordField.setBackground(Color.WHITE);
		passwordField.setBounds(177, 166, 157, 20);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String record = null;
			    FileReader in = null;
			    try {
			        in = new FileReader("assets/data/logininfo.dat");
			        @SuppressWarnings("resource")
					BufferedReader br = new BufferedReader(in);
			   

			        String username = txtEnterAdminId.getText();
			        @SuppressWarnings("deprecation")
					String password = passwordField.getText();
			        HomePage menu = null;

			        while ((record = br.readLine()) !=null) {

			          
			            String[] split = record.split("[|]");

			            if (username.equals(split[0]) && password.equals(split[1])) {

			                //JOptionPane.showMessageDialog(null, "Welcome " +split[0]);
			                HomePage nw = new HomePage();
			                nw.setVisible(true);
			                dispose();

			                break;
			            }

			        }

			        if (menu == null) {
			        	NoMatch.setText("**Incorrect Credentials**");
	        }
			    } catch (IOException e) {
			        e.getCause();
			    }
		    }
		});
		btnLogin.setIcon(null);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
		btnLogin.setBackground(new Color(218, 165, 32));
		btnLogin.setBounds(243, 209, 91, 31);
		contentPane.add(btnLogin);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtEnterAdminId.setText("");
				passwordField.setText("");
				NoMatch.setText("");
			}
		});
		btnNewButton.setBackground(new Color(218, 165, 32));
		btnNewButton.setFont(new Font("Monotype Corsiva", Font.PLAIN, 18));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(142, 209, 91, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblBg = new JLabel("");
		lblBg.setForeground(new Color(0, 0, 255));
		lblBg.setIcon(new ImageIcon("assets/images/background_small.jpg"));
		lblBg.setBounds(65, 0, 326, 94);
		contentPane.add(lblBg);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("assets/images/loginbackground.jpg"));
		lblNewLabel.setBounds(0, 0, 448, 328);
		contentPane.add(lblNewLabel);
	}
}
