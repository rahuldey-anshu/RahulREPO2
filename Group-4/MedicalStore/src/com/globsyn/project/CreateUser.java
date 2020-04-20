package com.globsyn.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CreateUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	private JTextField textField_5;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateUser frame = new CreateUser();
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
	public CreateUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900,724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(134, 24, 647, 650);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Name :");
		label.setForeground(new Color(51, 0, 153));
		label.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label.setBounds(46, 36, 144, 32);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Contact no. :");
		label_1.setForeground(new Color(51, 0, 153));
		label_1.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_1.setBounds(46, 88, 144, 32);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("AD no. :");
		label_2.setForeground(new Color(51, 0, 153));
		label_2.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_2.setBounds(46, 140, 144, 32);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Address :");
		label_3.setForeground(new Color(51, 0, 153));
		label_3.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_3.setBounds(46, 200, 144, 32);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Pin code :");
		label_4.setForeground(new Color(51, 0, 153));
		label_4.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_4.setBounds(46, 304, 150, 32);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Email  :");
		label_5.setForeground(new Color(51, 0, 153));
		label_5.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_5.setBounds(46, 356, 150, 32);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Username :");
		label_6.setForeground(new Color(51, 0, 153));
		label_6.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_6.setBounds(46, 399, 150, 32);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Password :");
		label_7.setForeground(new Color(51, 0, 153));
		label_7.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_7.setBounds(46, 450, 150, 32);
		panel.add(label_7);
		
		textField = new JTextField();
		textField.setToolTipText("only 10 digit mobile number");
		textField.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(233, 87, 269, 32);
		panel.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Enter 12 digit aadhaar number.");
		textField_1.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(233, 139, 269, 32);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("6 digit postal code");
		textField_2.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(233, 298, 216, 32);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Enter your valid email address.");
		textField_3.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		textField_3.setColumns(10);
		textField_3.setBounds(233, 352, 355, 32);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("choose a user name.");
		textField_4.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		textField_4.setColumns(10);
		textField_4.setBounds(233, 402, 216, 32);
		panel.add(textField_4);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("password should contain upper case and lower case leter and atleast one number and special charecter.");
		passwordField.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		passwordField.setBounds(233, 452, 216, 32);
		panel.add(passwordField);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage home= new HomePage();
				home.setVisible(true);
				dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button.setBackground(new Color(102, 153, 255));
		button.setBounds(330, 589, 133, 38);
		panel.add(button);
		
		JButton button_1 = new JButton("Save");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button_1.setBackground(new Color(102, 153, 255));
		button_1.setBounds(149, 589, 133, 38);
		panel.add(button_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		textArea.setBounds(233, 192, 355, 84);
		panel.add(textArea);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("only 10 digit mobile number");
		textField_5.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		textField_5.setColumns(10);
		textField_5.setBounds(233, 36, 269, 32);
		panel.add(textField_5);
		
		JLabel label_8 = new JLabel("Confirm password :");
		label_8.setForeground(new Color(51, 0, 153));
		label_8.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_8.setBounds(46, 506, 177, 32);
		panel.add(label_8);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setToolTipText("password should contain upper case and lower case leter and atleast one number and special charecter.");
		passwordField_1.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		passwordField_1.setBounds(233, 505, 216, 32);
		panel.add(passwordField_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CreateUser.class.getResource("assets/images/wallpaper1.jpg")));
		lblNewLabel.setBounds(0, 0, 884, 685);
		contentPane.add(lblNewLabel);
	}

}
