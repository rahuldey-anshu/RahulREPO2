package com.globsyn.prepaidtaxibooking;




import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;


import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class AddCar {

	private JFrame frmAddCar;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCar window = new AddCar();
					window.frmAddCar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddCar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddCar = new JFrame();
		frmAddCar.setType(Type.POPUP);
		frmAddCar.setTitle("Add Driver");
		frmAddCar.setIconImage(Toolkit.getDefaultToolkit().getImage(AddCar.class.getResource("/images/icon.jpg")));
		frmAddCar.setBounds(0, 0, 800, 500);
		frmAddCar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddCar.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Driver Details");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Old English Text MT", Font.PLAIN, 33));
		lblNewLabel.setBounds(195, 11, 337, 30);
		frmAddCar.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Car Name :");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("SimSun", Font.BOLD, 22));
		lblNewLabel_1.setBounds(10, 92, 655, 20);
		frmAddCar.getContentPane().add(lblNewLabel_1);
		
		JLabel lblCarNo = new JLabel("Car No :");
		lblCarNo.setForeground(Color.RED);
		lblCarNo.setFont(new Font("SimSun", Font.BOLD, 22));
		lblCarNo.setBounds(530, 96, 135, 20);
		frmAddCar.getContentPane().add(lblCarNo);
		
		JLabel lblDriverName = new JLabel("Driver Name :");
		lblDriverName.setForeground(Color.RED);
		lblDriverName.setFont(new Font("SimSun", Font.BOLD, 22));
		lblDriverName.setBounds(10, 148, 655, 20);
		frmAddCar.getContentPane().add(lblDriverName);
		
		JLabel lblDriverPhoneNo = new JLabel("Driver Phone No :");
		lblDriverPhoneNo.setForeground(Color.RED);
		lblDriverPhoneNo.setFont(new Font("SimSun", Font.BOLD, 22));
		lblDriverPhoneNo.setBounds(10, 249, 655, 20);
		frmAddCar.getContentPane().add(lblDriverPhoneNo);
		
		JLabel lblDriverLisence = new JLabel("Driver License :");
		lblDriverLisence.setForeground(Color.RED);
		lblDriverLisence.setFont(new Font("SimSun", Font.BOLD, 22));
		lblDriverLisence.setBounds(10, 199, 655, 20);
		frmAddCar.getContentPane().add(lblDriverLisence);
		
		textField = new JTextField();
		textField.setBounds(234, 96, 128, 20);
		frmAddCar.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(654, 96, 108, 20);
		frmAddCar.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(234, 253, 128, 20);
		frmAddCar.getContentPane().add(textField_2);
		
		final int p=9;
		textField_2.addKeyListener(new KeyAdapter() {
			    public void keyTyped(KeyEvent e) {
			      char c = e.getKeyChar();
			      
			      int i=textField_2.getText().length();
			      
			     
			      if (!((c >= '0') && (c <= '9') && (i<=p) ||
			         (c == KeyEvent.VK_BACK_SPACE) ||
			         (c == KeyEvent.VK_DELETE))) {
			         e.consume();
			         textField_2.setBackground(Color.white);
			      }
			      else {
			    	  textField_2.setBackground(Color.red);
			      }
			    }
			  });
	
		
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(234, 152, 128, 20);
		frmAddCar.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(234, 203, 128, 20);
		frmAddCar.getContentPane().add(textField_4);
		
		JButton btnNewButton = new JButton("Add Driver");
		btnNewButton.setForeground(Color.ORANGE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String p1="assets/data/taxiname.dat";
				String Info=textField.getText()+"|"+textField_1.getText()+"|"+textField_3.getText()+"|"+textField_4.getText()+"|"+textField_2.getText();
				
				File f=new File(p1);
				FileWriter fw=null;
				try{
					
					fw=new FileWriter(f,true);
				}catch(IOException e)
				{
					e.printStackTrace();
				}
				
				BufferedWriter bw=null;
				try{
					bw= new BufferedWriter(fw);
					bw.write(Info+"\n");
					
					
				}catch(IOException e)
				{
					e.printStackTrace();
				}
				try{
				bw.close();
				}catch(IOException e)
				{
					e.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, 
                        "New Car Details Added Sucessfully", 
                        "Message", 
                        JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 15));
		btnNewButton.setBounds(10, 414, 137, 23);
		frmAddCar.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Cancel");
		btnBack.setForeground(Color.ORANGE);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmAddCar.dispose();
			}
		});
		btnBack.setBackground(Color.BLACK);
		btnBack.setFont(new Font("Georgia", Font.PLAIN, 15));
		btnBack.setBounds(673, 414, 89, 23);
		frmAddCar.getContentPane().add(btnBack);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(Color.ORANGE);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField.setText("");
			}
		});
		btnReset.setFont(new Font("Georgia", Font.PLAIN, 15));
		btnReset.setBackground(Color.BLACK);
		btnReset.setBounds(382, 414, 89, 23);
		frmAddCar.getContentPane().add(btnReset);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(AddCar.class.getResource("/images/addRemove.jpg")));
		lblNewLabel_2.setBounds(-338, 0, 1122, 461);
		frmAddCar.getContentPane().add(lblNewLabel_2);
		
	
	}

	public void setVisible(boolean b) {
		frmAddCar.setVisible(b);
		// TODO Auto-generated method stub
		
	}
}
