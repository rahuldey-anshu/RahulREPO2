package com.globsyn.library.management.books;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.globsyn.library.management.member.AddMember;
import com.globsyn.library.management.member.MemberList;
import com.globsyn.library.management.user.Welcome;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

public class IssueBooks extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	ArrayList<String> mList = new ArrayList<>();
	
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField authorTextField;
	private JTextField textField_3;
	private JComboBox textField_4;
	public JDateChooser dateChooser,dateChooser_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBooks frame = new IssueBooks();
					frame.setTitle("ISSUE BOOKS");
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
	public IssueBooks() {
		
		File f = new File("data/IssuedBookList.dat");
		FileWriter fw=null;
		try {
			fw = new FileWriter(f,true);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		File members = new File("data/members.dat");
		
		Scanner msScanner;
		mList.add("Select member name");
		try {
			msScanner = new Scanner(members);
			
		
			while (msScanner.hasNext()) {
				
				String line = msScanner.nextLine();
				
				String fields[] = line.split("[|]");
				
				mList.add(fields[1]);
				
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}																
		
		
		BufferedWriter bw=new BufferedWriter(fw);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
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
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Remove Books");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookList bookList = new BookList();
				bookList.setVisible(true);
				dispose();
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Add Member");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddMember addMember = new AddMember();
				addMember.setVisible(true);
				dispose();
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Remove Member");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MemberList memberList = new MemberList();
				memberList.setVisible(true);
				dispose();
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Return Books");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ReturnBooks returnBook = new ReturnBooks();
			    returnBook.setVisible(true);
				dispose();
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Home");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Welcome welcome = new Welcome();
				welcome.setVisible(true);
				dispose();
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Exit");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JLabel label = new JLabel(new ImageIcon("src\\b.jpg"));
		label.setForeground(Color.BLUE);
		setContentPane(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setTitle("ISSUE BOOKS");
		
		ImageIcon icon = new ImageIcon("src\\lib.png");
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please enter the following details  :");
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNewLabel.setBounds(53, 48, 561, 36);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Book Number  :");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_1.setBounds(53, 113, 232, 36);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Book Name  :");
		lblNewLabel_2.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBounds(53, 160, 232, 36);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Author  :");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_3.setBounds(53, 207, 232, 36);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Quantity  :");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_4.setBounds(53, 260, 232, 32);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Member's Name  :");
		lblNewLabel_5.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setBounds(53, 309, 232, 32);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Date Of Issue  :");
		lblNewLabel_6.setForeground(Color.BLUE);
		lblNewLabel_6.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_6.setBounds(53, 360, 232, 32);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Date Of Return  :");
		lblNewLabel_7.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_7.setForeground(Color.BLUE);
		lblNewLabel_7.setBounds(53, 414, 232, 32);
		getContentPane().add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setBounds(377, 113, 172, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(377, 160, 172, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		authorTextField = new JTextField();
		authorTextField.setBounds(377, 207, 172, 20);
		getContentPane().add(authorTextField);
		authorTextField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(377, 254, 172, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JComboBox(mList.toArray(new String[mList.size()]));
		textField_4.setBounds(377, 309, 172, 20);
		getContentPane().add(textField_4);
		 
		
		JButton issueBookButton = new JButton("Issue");
		issueBookButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				DateFormat date = new SimpleDateFormat("dd-MM-yyyy");
				String issueDate = date.format(dateChooser.getDate());
				//System.out.println(issueDate);
				String returnDate = date.format(dateChooser_2.getDate());
				//System.out.println(returnDate);
				ReturnBooks rt=new ReturnBooks();
				
				String bookNumber = textField.getText();
				String bookName = textField_1.getText();
				String author = authorTextField.getText();
				String quantity = textField_3.getText();
				String memberID = textField_4.getSelectedItem().toString();
				
				
				if(!bookNumber.equals("") && !bookName.equals("") && !author.equals("")&& !quantity.equals("")&& !memberID.equals("")&& !issueDate.equals("")&& !returnDate.equals("")) 
				{
					if (f.exists()) {
					
						String dataToWrite = bookNumber + "|" + bookName + "|" + author + "|" + quantity + "|" + memberID + "|"+issueDate+"|"+returnDate+"\n";

					try {
						

						bw.write(dataToWrite);
						bw.flush();
						bw.close();
						
							IssuedBookList issuedBookList = new  IssuedBookList();
							issuedBookList.setVisible(true);
							setExtendedState(JFrame.MAXIMIZED_BOTH);
							dispose();
						
					} catch (IOException ioe) {
						ioe.printStackTrace();
						JOptionPane.showMessageDialog(contentPane, "Unable to issue books.", "Save Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (Exception ioe) {
						JOptionPane.showMessageDialog(contentPane, "Unable to issue books.", "Save Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Unable to issue books.", "Save Error",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}

			}
		});
		issueBookButton.setBackground(Color.CYAN);
		issueBookButton.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		issueBookButton.setBounds(53, 493, 126, 49);
		getContentPane().add(issueBookButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				textField.setText("");
				textField_1.setText("");
				authorTextField.setText("");
				textField_3.setText("");
				textField_4.setSelectedIndex(0);
				dateChooser.setDate(null);
				dateChooser_2.setDate(null);
				
			}
		});
		btnNewButton_1.setBounds(238, 496, 126, 43);
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
		btnNewButton_2.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.setBounds(423, 496, 126, 43);
		getContentPane().add(btnNewButton_2);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(376, 360, 173, 20);
		getContentPane().add(dateChooser);
		
		dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(376, 414, 173, 20);
		getContentPane().add(dateChooser_2);
	}

	
	
	
public IssueBooks(String value1, String value2, String value3, String value4) 
{
	
	File f = new File("data/IssuedBookList.dat");
	FileWriter fw=null;
	try {
		fw = new FileWriter(f,true);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	BufferedWriter bw=new BufferedWriter(fw);
	File members = new File("data/members.dat");
	
	Scanner msScanner;
	mList.add("Select member name");
	try {
		msScanner = new Scanner(members);
		
	
		while (msScanner.hasNext()) {
			
			String line = msScanner.nextLine();
			
			String fields[] = line.split("[|]");
			
			mList.add(fields[1]);
			
		}
	} catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
	
	JMenu mnNewMenu = new JMenu("MENU");
	menuBar.add(mnNewMenu);
	
	JMenuItem mntmNewMenuItem = new JMenuItem("ADD BOOKS");
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
	mnNewMenu.add(mntmNewMenuItem);
	
	JMenuItem mntmNewMenuItem_1 = new JMenuItem("REMOVE BOOKS");
	mntmNewMenuItem_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			BookList bookList = new BookList();
			bookList.setVisible(true);
			dispose();
			
		}
	});
	mnNewMenu.add(mntmNewMenuItem_1);
	
	JMenuItem mntmNewMenuItem_2 = new JMenuItem("ADD MEMBER");
	mntmNewMenuItem_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			AddMember addMember = new AddMember();
			addMember.setVisible(true);
			dispose();
			
		}
	});
	mnNewMenu.add(mntmNewMenuItem_2);
	
	JMenuItem mntmNewMenuItem_3 = new JMenuItem("REMOVE MEMBER");
	mntmNewMenuItem_3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			MemberList memberList = new MemberList();
			memberList.setVisible(true);
			dispose();
			
		}
	});
	mnNewMenu.add(mntmNewMenuItem_3);
	
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("RETURN BOOKS");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ReturnBooks returnBook = new ReturnBooks();
		    	returnBook.setVisible(true);
				dispose();
			
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
	
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("HOME");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				Welcome welcome = new Welcome();
				welcome.setVisible(true);
				dispose();
			
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
	
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("EXIT");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				System.exit(0);
			
			}
		});
		mnNewMenu.add(mntmNewMenuItem_6);
	
		
		JLabel label = new JLabel(new ImageIcon("src\\b.jpg"));
		label.setForeground(Color.BLUE);
		setContentPane(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setTitle("ISSUE BOOKS");
		
		ImageIcon icon = new ImageIcon("src\\lib.png");
		setIconImage(icon.getImage());
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PLEASE ENTER THE FOLLOWING DETAILS :");
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNewLabel.setBounds(53, 48, 561, 36);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BOOK NUMBER  :");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_1.setBounds(53, 113, 232, 36);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TITLE  :");
		lblNewLabel_2.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setBounds(53, 160, 232, 36);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("AUTHOR  :");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_3.setBounds(53, 207, 232, 36);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("QUANTITY  :");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_4.setBounds(53, 260, 232, 32);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("MEMBER'S ID  :");
		lblNewLabel_5.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setBounds(53, 309, 232, 32);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("DATE OF ISSUE  :");
		lblNewLabel_6.setForeground(Color.BLUE);
		lblNewLabel_6.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_6.setBounds(53, 360, 232, 32);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("DATE OF RETURN  :");
		lblNewLabel_7.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_7.setForeground(Color.BLUE);
		lblNewLabel_7.setBounds(53, 414, 232, 32);
		getContentPane().add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setBounds(377, 113, 172, 20);
		textField.setText(value1);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(377, 160, 172, 20);
		textField_1.setText(value2);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		authorTextField = new JTextField();
		authorTextField.setBounds(377, 207, 172, 20);
		authorTextField.setText(value3);
		getContentPane().add(authorTextField);
		authorTextField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(377, 254, 172, 20);
		textField_3.setText(value4);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JComboBox<>(mList.toArray(new String[mList.size()]));
		textField_4.setBounds(377, 309, 172, 20);
		getContentPane().add(textField_4);
		 
		JButton issueBookButton = new JButton("ISSUE");
		issueBookButton.setBackground(Color.CYAN);
		issueBookButton.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		issueBookButton.setBounds(53, 493, 126, 49);
		getContentPane().add(issueBookButton);
		
		
		issueBookButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				DateFormat date = new SimpleDateFormat("dd-MM-yyyy");
				String issueDate = date.format(dateChooser.getDate());
				//System.out.println(issueDate);
				String returnDate = date.format(dateChooser_2.getDate());
				//System.out.println(returnDate);
				
				
				
				String bookNumber = textField.getText();
				String bookName = textField_1.getText();
				String author = authorTextField.getText();
				String quantity = textField_3.getText();
				String memberID = textField_4.getSelectedItem().toString();
				
			/*	ReturnBooks rt=new ReturnBooks(String value1, String value2, String value3, String value4);*/
				
				
				if(!bookNumber.equals("") && !bookName.equals("") && !author.equals("")&& !quantity.equals("")&& !memberID.equals("")&& !issueDate.equals("")&& !returnDate.equals("")) 
				{
					if (f.exists()) {
					
						String dataToWrite = bookNumber + "|" + bookName + "|" + author + "|" + quantity + "|" + memberID + "|"+issueDate+"|"+returnDate+"\n";

					try {
						

						bw.write(dataToWrite);
						bw.flush();
						bw.close();
						
							IssuedBookList issuedBookList = new  IssuedBookList();
							issuedBookList.setVisible(true);
							setExtendedState(JFrame.MAXIMIZED_BOTH);
							dispose();
						
					} catch (IOException ioe) {
						ioe.printStackTrace();
						JOptionPane.showMessageDialog(contentPane, "Unable to issue books.", "Save Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (Exception ioe) {
						JOptionPane.showMessageDialog(contentPane, "Unable to issue books.", "Save Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Unable to issue books.", "Save Error",
							JOptionPane.ERROR_MESSAGE);
				}
				
			}

			}
		});

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
		btnNewButton_2.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		btnNewButton_2.setBackground(Color.CYAN);
		btnNewButton_2.setBounds(423, 496, 126, 43);
		getContentPane().add(btnNewButton_2);
		
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(376, 360, 173, 20);
		getContentPane().add(dateChooser);
		
		
		dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(376, 414, 173, 20);
		getContentPane().add(dateChooser_2);
	}
}