package com.globsyn.library.management.books;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.globsyn.library.management.member.AddMember;
import com.globsyn.library.management.member.MemberList;
import com.globsyn.library.management.user.*;

//import com.globsyn.wholesale.business.Welcome;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;

public class AddBooks extends JFrame 
{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;

	String arrCategory[]={"Education","Frictional","Religion","Philosophy","Self Help","Hobbies & Interest"};
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBooks frame = new AddBooks();
					frame.setTitle("ADD BOOKS");
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public AddBooks() throws IOException {
		
		File f = new File("data/new book.dat");
		FileWriter fw = new FileWriter(f,true);
	
		BufferedWriter bw=new BufferedWriter(fw);
		
		JFrame frame = new JFrame();
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu file = new JMenu("FILE");
		menuBar.add(file);
		
		JMenuItem exit = new JMenuItem("EXIT");
		file.add(exit);
		
		JMenuBar menuBar_1 = new JMenuBar();
		setJMenuBar(menuBar_1);
		
		JMenu mnMenu = new JMenu("Menu");
		mnMenu.setFont(new Font("Yu Gothic", Font.BOLD, 12));
		menuBar_1.add(mnMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Remove Books");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookList bookList = new BookList();
				bookList.setVisible(true);
				dispose();
				
			}
			
			
		});
		mnMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmAddMember = new JMenuItem("Add Member");
		mntmAddMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddMember addMember = new AddMember();
				addMember.setVisible(true);
				dispose();
			}
		});
		mnMenu.add(mntmAddMember);
		
		JMenuItem mntmRemoveMember = new JMenuItem("Remove Member");
		mntmRemoveMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MemberList removeMember = new MemberList();
				removeMember.setVisible(true);
				dispose();
				
			}
		});
		mnMenu.add(mntmRemoveMember);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Search Books");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 BookList bookList = new BookList();
				bookList.setVisible(true);
				setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
				
			}
		});
		mnMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Return Books");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ReturnBooks returnBooks = new ReturnBooks();
				returnBooks.setVisible(true);
				
			}
		});
		mnMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Exit");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		mnMenu.add(mntmNewMenuItem_3);
		
		JLabel label = new JLabel(new ImageIcon("src\\b.jpg"));
		label.setForeground(Color.PINK);
		setContentPane(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		setTitle("ADD BOOKS");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		
		
		ImageIcon icon = new ImageIcon("src\\lib.png");
		setIconImage(icon.getImage());
		
		
		JLabel lblNewLabel = new JLabel("Please enter the following details  :");
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNewLabel.setBounds(27, 76, 425, 26);
		getContentPane().add(lblNewLabel);
	
		JLabel lblNewLabel_1 = new JLabel("Book Number  :");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_1.setBounds(27, 130, 150, 26);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Title Of Book  :");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_2.setBounds(27, 167, 150, 31);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Author  :");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_3.setBounds(27, 205, 150, 26);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Category  :");
		lblNewLabel_4.setForeground(Color.BLUE);
		lblNewLabel_4.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_4.setBounds(27, 238, 150, 31);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Quantity  :");
		lblNewLabel_5.setForeground(Color.BLUE);
		lblNewLabel_5.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		lblNewLabel_5.setBounds(27, 271, 150, 34);
		getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(259, 134, 165, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(259, 173, 165, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(259, 209, 165, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox comboBox = new JComboBox(arrCategory);
		comboBox.setBounds(259, 244, 165, 20);
		getContentPane().add(comboBox);
		
		textField_4 = new JTextField();
		textField_4.setBounds(259, 279, 165, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(37, 264, 343, -5);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(37, 280, 268, -15);
		getContentPane().add(separator_1);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
					String bookNumber=textField.getText();
					String bookTitle=textField_1.getText();
					String author=textField_2.getText();
					String category=(String)comboBox.getSelectedItem();
					String sQuantity=textField_4.getText();
					
					
					if (f.exists()) {
						String dataToWrite = bookNumber + "|" + bookTitle + "|" + author + "|" + category + "|" + sQuantity + "\n";

						try {
							

							bw.write(dataToWrite);
							bw.flush();
							bw.close();
							
								BookList bookList = new  BookList();
								bookList.setVisible(true);
								setExtendedState(JFrame.MAXIMIZED_BOTH);
								dispose();
							//}
						} catch (IOException ioe) {
							ioe.printStackTrace();
							JOptionPane.showMessageDialog(contentPane, "Unable to save book data.", "Save Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (Exception ioe) {
							JOptionPane.showMessageDialog(contentPane, "Unable to save book data.", "Save Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(contentPane, "Unable to save book data.", "Save Error",
								JOptionPane.ERROR_MESSAGE);
					}

					
					
				}
			
		});
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.setForeground(Color.MAGENTA);
		btnNewButton.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		btnNewButton.setBounds(104, 333, 107, 39);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Home");
		btnNewButton_1.setFont(new Font("Yu Gothic", Font.BOLD, 14));
		btnNewButton_1.setForeground(Color.MAGENTA);
		btnNewButton_1.setBackground(Color.CYAN);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Welcome welcome = new Welcome();
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        setExtendedState(JFrame.MAXIMIZED_BOTH);
				welcome.setVisible(true);
				dispose();
	
				
			}
		});
		btnNewButton_1.setBounds(289, 333, 107, 39);
		getContentPane().add(btnNewButton_1); 
		
		
	}
}
