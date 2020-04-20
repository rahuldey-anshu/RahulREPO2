package com.globsyn.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class ChangePassword extends JFrame {

	private JPanel contentPane;
	private JPasswordField oldPassword;
	private JPasswordField newPassword;
	private JPasswordField confirmPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePassword frame = new ChangePassword();
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
	public ChangePassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900,724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Change password", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(138, 118, 600, 476);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Old Password :");
		label.setForeground(new Color(51, 0, 153));
		label.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		label.setBounds(66, 91, 184, 32);
		panel.add(label);
		
		JLabel label_1 = new JLabel("New Password :");
		label_1.setForeground(new Color(51, 0, 153));
		label_1.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		label_1.setBounds(66, 156, 184, 32);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Confirm Password :");
		label_2.setForeground(new Color(51, 0, 153));
		label_2.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		label_2.setBounds(66, 213, 184, 32);
		panel.add(label_2);
		
		oldPassword = new JPasswordField();
		oldPassword.setToolTipText("Enter your current password.");
		oldPassword.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		oldPassword.setBounds(260, 91, 269, 32);
		panel.add(oldPassword);
		
		newPassword = new JPasswordField();
		newPassword.setToolTipText("Enter your new password.");
		newPassword.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		newPassword.setBounds(260, 150, 269, 32);
		panel.add(newPassword);
		
		confirmPassword = new JPasswordField();
		confirmPassword.setToolTipText("Re-type your new password again.");
		confirmPassword.setForeground(Color.BLACK);
		confirmPassword.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		confirmPassword.setBounds(260, 212, 269, 32);
		panel.add(confirmPassword);
		
		JButton savePassword = new JButton("Save");
		
		savePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		savePassword.setForeground(Color.WHITE);
		savePassword.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		savePassword.setBackground(new Color(102, 153, 255));
		savePassword.setBounds(143, 354, 133, 45);
		panel.add(savePassword);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage home= new HomePage();
				home.setVisible(true);
				dispose();
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button_1.setBackground(new Color(102, 153, 255));
		button_1.setBounds(323, 354, 139, 45);
		panel.add(button_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon( "assets/images/wallpaper1.jpg"));
		lblNewLabel.setBounds(0, 0, 884, 685);
		contentPane.add(lblNewLabel);
	}

}
