package com.globsyn.library.management.books;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.globsyn.library.management.member.AddMember;
import com.globsyn.library.management.member.MemberList;
import com.globsyn.library.management.user.Welcome;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;

import org.joda.time.*;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class ReturnBooks extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField;
	public JDateChooser dateChooser_3;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBooks frame = new ReturnBooks();
					frame.setTitle("RETURN BOOKS");
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
	public ReturnBooks() 
	{
		
		
		JLabel label = new JLabel(new ImageIcon("src\\b.jpg"));
		setContentPane(label);
				
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add Books");
		mntmNewMenuItem.setSelected(true);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					AddBooks addBook = new AddBooks();
					addBook.setVisible(true);
					dispose();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		mnMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Remve Books");
		mntmNewMenuItem_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				BookList bookList = new BookList();
				bookList.setVisible(true);
				dispose();

			}
		});
		mnMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Add Member");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddMember addMember = new AddMember();
				addMember.setVisible(true);
				dispose();
				
			}
		});
		mnMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Remove Member");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MemberList removeMember = new MemberList();
				removeMember.setVisible(true);
				dispose();
				
			}
		});
		mnMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Return Book");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ReturnBooks returnBook = new ReturnBooks();
			    returnBook.setVisible(true);
				dispose();
				
			}
		});
		mnMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Home");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Welcome welcome = new Welcome();
				welcome.setVisible(true);
				dispose();
				
			}
		});
		mnMenu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Exit");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		mnMenu.add(mntmNewMenuItem_6);
		
	
	
		
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		        setExtendedState(JFrame.MAXIMIZED_BOTH);
		        
		        setTitle("RETURN BOOKS");
				
				ImageIcon icon = new ImageIcon("src\\lib.png");
				setIconImage(icon.getImage());
				getContentPane().setLayout(null);
				
				
				JLabel lblNewLabel = new JLabel("Please enter the following details  :");
				lblNewLabel.setForeground(Color.MAGENTA);
				lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
				lblNewLabel.setBounds(44, 36, 587, 36);
				getContentPane().add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("Issued Books  :");
				lblNewLabel_1.setForeground(Color.BLUE);
				lblNewLabel_1.setFont(new Font("Yu Gothic", Font.BOLD, 15));
				lblNewLabel_1.setBounds(58, 103, 219, 29);
				getContentPane().add(lblNewLabel_1);
				
				JLabel lblMemberId = new JLabel("Member's ID  :");
				lblMemberId.setForeground(Color.BLUE);
				lblMemberId.setFont(new Font("Yu Gothic", Font.BOLD, 14));
				lblMemberId.setBounds(58, 143, 216, 29);
				getContentPane().add(lblMemberId);
				
				JLabel lblNewLabel_2 = new JLabel("Date Of Issue  :");
				lblNewLabel_2.setFont(new Font("Yu Gothic", Font.BOLD, 15));
				lblNewLabel_2.setForeground(Color.BLUE);
				lblNewLabel_2.setBounds(58, 183, 219, 29);
				getContentPane().add(lblNewLabel_2);
				
				JLabel lblNewLabel_3 = new JLabel("Date Of Return  :");
				lblNewLabel_3.setFont(new Font("Yu Gothic", Font.BOLD, 14));
				lblNewLabel_3.setForeground(Color.BLUE);
				lblNewLabel_3.setBounds(58, 231, 219, 29);
				getContentPane().add(lblNewLabel_3);
				
				textField = new JTextField();
				textField.setBounds(303, 108, 145, 20);
				getContentPane().add(textField);
				textField.setColumns(10);
				
				textField_1 = new JTextField();
				textField_1.setBounds(303, 147, 145, 20);
				getContentPane().add(textField_1);
				textField_1.setColumns(10);
				
				textField_2 = new JTextField();
				textField_2.setBounds(303, 187, 145, 20);
				getContentPane().add(textField_2);
				textField_2.setColumns(10);
				
				textField_3 = new JTextField();
				textField_3.setBounds(303, 231, 145, 20);
				getContentPane().add(textField_3);
				textField_3.setColumns(10);
				
				JButton btnNewButton = new JButton("Return");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						DateFormat date = new SimpleDateFormat("dd-MM-yyyy");
						String returnOnDate = date.format(dateChooser_3.getDate());
					
					}
				});
				btnNewButton.setFont(new Font("Yu Gothic", Font.BOLD, 14));
				btnNewButton.setBackground(Color.CYAN);
				btnNewButton.setBounds(58, 368, 102, 36);
				getContentPane().add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("Reset");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						textField.setText("");
						textField_1.setText("");
						textField_2.setText("");
						textField_3.setText("");
						
						//textField_5.setText("");
						
						
					}
				});
				btnNewButton_1.setBackground(Color.CYAN);
				btnNewButton_1.setFont(new Font("Yu Gothic", Font.BOLD, 14));
				btnNewButton_1.setBounds(201, 368, 102, 36);
				getContentPane().add(btnNewButton_1);
				
				JButton btnNewButton_2 = new JButton("Home");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Welcome welcome = new Welcome();
						setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				        setExtendedState(JFrame.MAXIMIZED_BOTH);
						welcome.setVisible(true);
						dispose();
						
					}
				});
				btnNewButton_2.setBackground(Color.CYAN);
				btnNewButton_2.setFont(new Font("Yu Gothic", Font.BOLD, 14));
				btnNewButton_2.setBounds(346, 368, 102, 36);
				getContentPane().add(btnNewButton_2);
				
				JLabel lblNewLabel_4 = new JLabel("Returned On  :");
				lblNewLabel_4.setForeground(Color.BLUE);
				lblNewLabel_4.setFont(new Font("Yu Gothic", Font.BOLD, 14));
				lblNewLabel_4.setBounds(58, 276, 145, 29);
				getContentPane().add(lblNewLabel_4);
				
				JDateChooser dateChooser = new JDateChooser();
				dateChooser.setBounds(303, 276, 145, 20);
				getContentPane().add(dateChooser);
				
				
	}

	public ReturnBooks(String value1, String value2, String value3, String value4) 
	{
		JLabel label = new JLabel(new ImageIcon("src\\b.jpg"));
		setContentPane(label);
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setTitle("RETURN BOOKS");
		
		ImageIcon icon = new ImageIcon("src\\lib.png");
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);
		
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(303, 276, 145, 20);
		getContentPane().add(dateChooser);
		
		JLabel lblNewLabel = new JLabel(" PLEASE ENTER THE FOLLOWING DETAILS  :");
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNewLabel.setBounds(44, 36, 587, 36);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ISSUED BOOKS  :");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_1.setBounds(58, 103, 219, 29);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblMemberId = new JLabel("MEMBER ID  :");
		lblMemberId.setForeground(Color.BLUE);
		lblMemberId.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblMemberId.setBounds(58, 143, 216, 29);
		getContentPane().add(lblMemberId);
		
		JLabel lblNewLabel_2 = new JLabel("DATE OF ISSUE  :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBounds(58, 183, 219, 29);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DUE DATE  :");
		lblNewLabel_3.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setBounds(58, 231, 219, 29);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("RETURNED ON  :");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_4.setBounds(58, 276, 145, 29);
		getContentPane().add(lblNewLabel_4);
		
		
		
		textField = new JTextField();
		textField.setBounds(303, 108, 145, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		textField.setText(value1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(303, 147, 145, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(value2);
		
		
		textField_2 = new JTextField();
		textField_2.setBounds(303, 187, 145, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(value3);
		
		
		textField_3 = new JTextField();
		textField_3.setBounds(303, 236, 145, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		textField_3.setText(value4);
		
		/*
		textField_5 = new JTextField();
		textField_5.setBounds(303, 276, 145, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		*/
		JButton btnNewButton = new JButton("RETURN");
		btnNewButton.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setBounds(58, 368, 102, 36);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				/*DateFormat date = new SimpleDateFormat("dd-MM-yyyy");
				String returnOnDate = date.format(dateChooser_3.getDate());
				*/
				Component lblLibraryManagement = null;
				JOptionPane.showMessageDialog(lblLibraryManagement ,"Books returned Successfully");
				Welcome home = new Welcome();
				home.setVisible(true);
	           	dispose();

			}
		});
		
		JButton btnNewButton_1 = new JButton("RESET");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				
			}
		});
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		btnNewButton_1.setBounds(201, 368, 102, 36);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("HOME");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Welcome welcome = new Welcome();
				setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		        setExtendedState(JFrame.MAXIMIZED_BOTH);
				welcome.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		btnNewButton_2.setBounds(346, 368, 102, 36);
		getContentPane().add(btnNewButton_2);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("MENU");
		menuBar.add(mnMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("ADD BOOKS");
		mntmNewMenuItem.setSelected(true);
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					AddBooks addBook = new AddBooks();
					addBook.setVisible(true);
					dispose();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		mnMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("REMOVE BOOKS");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookList bookList = new BookList();
				bookList.setVisible(true);
				dispose();
				
			}
		});
		mnMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("ADD MEMBER");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddMember addMember = new AddMember();
				addMember.setVisible(true);
				dispose();
				
			}
		});
		mnMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("REMOVE MEMBER");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MemberList removeMember = new MemberList();
				removeMember.setVisible(true);
				dispose();
				
			}
		});
		mnMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("RETURN BOOK");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ReturnBooks returnBook = new ReturnBooks();
			    returnBook.setVisible(true);
				dispose();
				
			}
		});
		mnMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("HOME");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Welcome welcome = new Welcome();
				welcome.setVisible(true);
				dispose();
				
			}
		});
		mnMenu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("EXIT");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		mnMenu.add(mntmNewMenuItem_6);
		
	
	
	
	}
}
