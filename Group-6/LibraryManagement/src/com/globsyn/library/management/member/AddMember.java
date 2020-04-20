package com.globsyn.library.management.member;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.globsyn.library.management.books.AddBooks;
import com.globsyn.library.management.books.BookList;
import com.globsyn.library.management.member.MemberList;
import com.globsyn.library.management.books.ReturnBooks;
import com.globsyn.library.management.user.Welcome;

import javafx.scene.control.RadioButton;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class AddMember extends JFrame 
{

	
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMember frame = new AddMember();
					frame.setTitle("ADD MEMBER");
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
	public AddMember() 
	{
		
		File f = new File("data/members.dat");
		FileWriter fw=null;
		try {
			fw = new FileWriter(f,true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BufferedWriter bw=new BufferedWriter(fw);
		
		
		JLabel label = new JLabel(new ImageIcon("src\\b.jpg"));
		setContentPane(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setTitle("ADD MEMBER");
		
		ImageIcon icon = new ImageIcon("src\\lib.png");
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Please Enter The Following Details  :");
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNewLabel.setBounds(35, 26, 464, 29);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Name  :");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		lblNewLabel_2.setBounds(35, 130, 149, 29);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Gender  :");
		lblNewLabel_3.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setBounds(35, 170, 149, 29);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Location  :");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_4.setBounds(35, 210, 149, 29);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address  :");
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		lblNewLabel_5.setBounds(35, 250, 149, 29);
		getContentPane().add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(236, 135, 174, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(236, 215, 174, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(235, 255, 175, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		
		JRadioButton maleRButton = new JRadioButton("Male");
		buttonGroup.add(maleRButton);
		maleRButton.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		maleRButton.setBounds(232, 174, 87, 23);
		getContentPane().add(maleRButton);
		
		JRadioButton femaleRButton = new JRadioButton("Female");
		buttonGroup.add(femaleRButton);
		femaleRButton.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		femaleRButton.setBounds(321, 174, 109, 23);
		getContentPane().add(femaleRButton);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setForeground(Color.MAGENTA);
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		btnNewButton.setBounds(58, 307, 89, 35);
		getContentPane().add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String value="";
					
					if(true)  
				     {  
				        Enumeration<AbstractButton> allRadioButton=buttonGroup.getElements();  
				        while(allRadioButton.hasMoreElements())  
				        {  
				           JRadioButton temp=(JRadioButton)allRadioButton.nextElement();  
				           if(temp.isSelected())  
				           {  
				        	   value= temp.getText();
				            //JOptionPane.showMessageDialog(null,"You select : "+temp.getText());  
				           }  
				        }            
				     }
					
					
					//String memberID=textField.getText();
					int memberID= getNewMemberID();
					String memberName=textField_1.getText();
					String location=textField_3.getText();
					String address=textField_4.getText();
					
					if(!memberName.equals("") && !location.equals("") && !address.equals("")) {
					
					if (f.exists()) {
						String dataToWrite = memberID + "|" + memberName + "|" + value + "|" + location + "|" + address + "\n";

						try {
							

							bw.write(dataToWrite);
							bw.flush();
							bw.close();
							
								MemberList memberList = new  MemberList();
								memberList.setVisible(true);
								dispose();
							
						} catch (IOException ioe) {
							ioe.printStackTrace();
							JOptionPane.showMessageDialog(contentPane, "Unable to save member details.", "Save Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (Exception ioe) {
							JOptionPane.showMessageDialog(contentPane, "Unable to save member details.", "Save Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(contentPane, "Unable to save member details.", "Save Error",
								JOptionPane.ERROR_MESSAGE);
					}
					
					}else {
						
						
						JOptionPane.showMessageDialog(null, "Please fill all the required fields.", "",
								JOptionPane.ERROR_MESSAGE);
					}

					
					
				}
			
		});
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
				textField_1.setText("");
				textField_3.setText("");
				textField_4.setText("");
				
				
			}
		});
		btnNewButton_1.setForeground(Color.MAGENTA);
		btnNewButton_1.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setBounds(190, 307, 89, 35);
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
		btnNewButton_2.setForeground(Color.MAGENTA);
		btnNewButton_2.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.setBounds(321, 307, 89, 35);
		getContentPane().add(btnNewButton_2);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add Books");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddBooks addBook = null;
				try {
					addBook = new AddBooks();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				addBook.setVisible(true);
				dispose();
				
			}
		});
		mnMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Book List");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookList bookList = new BookList();
				bookList.setVisible(true);
				dispose();
				
				
			}
		});
		mnMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Remove Books");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookList bookList = new BookList();
				bookList.setVisible(true);
				dispose();
				
			}
		});
		mnMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Return Books");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ReturnBooks returnBook = new ReturnBooks();
			    returnBook.setVisible(true);
				dispose();
			}
		});
		mnMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Remove Member");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MemberList removeMember = new MemberList();
				removeMember.setVisible(true);
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
		
		
	}
	
	private int getNewMemberID()
	{

		int lastMemberID = 0;
		try {
			File f = new File("data/members.dat");
			
			if(f.exists()){
				Scanner scanner = new Scanner(f);
				while(scanner.hasNext()){
					Vector<String> row = new Vector<>();
					
					String line = scanner.nextLine();
					String[] fields = line.split("[|]");
					for (int i = 0; i < fields.length; i++) {
						
						try {
							lastMemberID = Integer.parseInt(fields[0]);
						} catch (NumberFormatException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
					
				}
			}
			
			return lastMemberID+1;
			
		} catch (FileNotFoundException e) {
			 
			e.printStackTrace();
			return 1;
		}
	}
}
