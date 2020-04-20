package com.globsyn.project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class Login {

	private JFrame frmWelcomeToMed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmWelcomeToMed.setVisible(true);
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
		frmWelcomeToMed = new JFrame();
		frmWelcomeToMed.setResizable(false);
		frmWelcomeToMed.setTitle("Welcome to Med Care World");
		frmWelcomeToMed.setBounds(100, 100, 900,724);
		frmWelcomeToMed.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcomeToMed.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(216, 0, 443, 674);
		frmWelcomeToMed.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(248, 248, 255));
		
		JButton button = new JButton("Next");
		button.setIcon(new ImageIcon("assets/images/admin logo.png"));
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				    frmWelcomeToMed.dispose();
				    UsernamePassword user= new UsernamePassword();
				    user.setVisible(true);
			
			}
				
			
		});
		
		button.setForeground(new Color(51, 0, 153));
		button.setFont(new Font("Lucida Fax", Font.BOLD, 22));
		button.setBackground(Color.WHITE);
		button.setBounds(29, 446, 383, 160);
		panel_1.add(button);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setForeground(new Color(51, 0, 153));
		lblWelcome.setFont(new Font("Lucida Fax", Font.BOLD, 35));
		lblWelcome.setBounds(126, 67, 180, 84);
		panel_1.add(lblWelcome);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setForeground(new Color(51, 0, 153));
		lblTo.setFont(new Font("Lucida Fax", Font.BOLD, 35));
		lblTo.setBounds(188, 162, 180, 84);
		panel_1.add(lblTo);
		
		JLabel lblMedCareWorld = new JLabel("Med Care World");
		lblMedCareWorld.setForeground(new Color(51, 0, 153));
		lblMedCareWorld.setFont(new Font("Lucida Fax", Font.BOLD, 35));
		lblMedCareWorld.setBounds(74, 257, 359, 84);
		panel_1.add(lblMedCareWorld);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("assets/images/wallpaper1.jpg"));
		label_3.setBounds(0, 0, 894, 685);
		frmWelcomeToMed.getContentPane().add(label_3);
	}
}
