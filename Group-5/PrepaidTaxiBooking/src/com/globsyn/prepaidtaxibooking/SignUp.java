package com.globsyn.prepaidtaxibooking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*
;
import java.awt.Window.Type;
import java.awt.Toolkit;
import javax.swing.ImageIcon;public class SignUp {

	private JFrame frmSignUp;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp window = new SignUp();
					window.frmSignUp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignUp = new JFrame();
		frmSignUp.setTitle("Sign Up");
		frmSignUp.setIconImage(Toolkit.getDefaultToolkit().getImage(SignUp.class.getResource("/images/icon.jpg")));
		frmSignUp.setType(Type.POPUP);
		frmSignUp.getContentPane().setBackground(Color.BLACK);
		frmSignUp.getContentPane().setLayout(null);
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String path="assets/data/User.dat";
				File f=new File(path);
				FileWriter fr=null;
				try {
					fr = new FileWriter(f,true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BufferedWriter bw=new BufferedWriter(fr);
				try {
					bw.write(textField.getText()+"|"+textField_1.getText()+"\n");
					bw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(frmSignUp, "Sign Up successful ");
				/*Login login = new Login();
				login.setVisible(true);*/
				frmSignUp.dispose();
			}
		});
		btnNewButton.setBackground(new Color(50, 205, 50));
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 16));
		btnNewButton.setBounds(329, 227, 105, 23);
		frmSignUp.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Enter Your Details");
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setFont(new Font("Old English Text MT", Font.PLAIN, 18));
		lblNewLabel.setBounds(128, 11, 175, 28);
		frmSignUp.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Old English Text MT", Font.PLAIN, 16));
		lblUsername.setForeground(new Color(240, 248, 255));
		lblUsername.setBounds(10, 95, 78, 14);
		frmSignUp.getContentPane().add(lblUsername);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(new Color(240, 248, 255));
		lblNewLabel_1.setFont(new Font("Old English Text MT", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 149, 78, 14);
		frmSignUp.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(128, 89, 86, 20);
		frmSignUp.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 143, 86, 20);
		frmSignUp.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(SignUp.class.getResource("/images/SignUpPic.jpg")));
		lblNewLabel_2.setBounds(224, 50, 210, 133);
		frmSignUp.getContentPane().add(lblNewLabel_2);
		frmSignUp.setBounds(100, 100, 450, 300);
		frmSignUp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisible(boolean b) {
		frmSignUp.setVisible(b);
		// TODO Auto-generated method stub
		
	}
}
