package com.globsyn.library.management.user;

import com.globsyn.library.management.books.*;
import com.globsyn.library.management.member.AddMember;
import com.globsyn.library.management.member.MemberList;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

public class Welcome extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcome win = new Welcome();
							win.setExtendedState(JFrame.MAXIMIZED_BOTH);
					       win.setVisible(true);
		                   win.setTitle("WELCOME TO TREATISE LIBRARY");
		                   
		                   
		               
		                   
		                   ImageIcon icon = new ImageIcon("G:\\lib.png");
		           		win.setIconImage(icon.getImage());
		           		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Welcome() {
		
		JLabel label = new JLabel(new ImageIcon("src\\b.jpg"));
		setContentPane(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setTitle("WELCOME TO TREATISE LIBRARY");
		
		getContentPane().setLayout(null);
		ImageIcon icon = new ImageIcon("src\\lib.png");
		setIconImage(icon.getImage());
		
		
		
		JButton btnNewButton_1 = new JButton("Add Books");
		btnNewButton_1.setBackground(new Color(95, 158, 160));
		btnNewButton_1.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddBooks add=null;
				try {
					add = new AddBooks();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                setContentPane(new JLabel(new ImageIcon("F:\\b.jpg")));
                add.setVisible(true);
                dispose();
                
			}
		});
		btnNewButton_1.setBounds(47, 154, 162, 39);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Remove Books");
		btnNewButton_2.setBackground(new Color(95, 158, 160));
		btnNewButton_2.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				BookList bookList = new BookList();
				bookList.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(47, 218, 162, 39);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add Member");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddMember addMember = new AddMember();
				addMember.setVisible(true);
				dispose();
			}
			
		});
		btnNewButton_3.setBackground(new Color(95, 158, 160));
		btnNewButton_3.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		btnNewButton_3.setBounds(47, 284, 162, 39);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Remove Member");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MemberList removeMember = new MemberList();
				removeMember.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_4.setBackground(new Color(95, 158, 160));
		btnNewButton_4.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		btnNewButton_4.setBounds(357, 154, 162, 39);
		getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("Search & Issue");
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookList bookList = new BookList();
				setExtendedState(JFrame.MAXIMIZED_BOTH);
				bookList.setVisible(true);
				
				dispose();
				
			
			}
		});
		btnNewButton.setBounds(357, 218, 162, 39);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_5 = new JButton("Return Book");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				IssuedBookList issuedBookList =  new IssuedBookList();
				issuedBookList.setVisible(true);
				dispose();
			
			}
		});
		btnNewButton_5.setBackground(new Color(95, 158, 160));
		btnNewButton_5.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		btnNewButton_5.setBounds(357, 284, 162, 39);
		getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel = new JLabel("Welcome To The Treatise Library");
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setFont(new Font("Corbel", Font.BOLD, 23));
		lblNewLabel.setBounds(87, 68, 410, 39);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_6 = new JButton("Logout");
		btnNewButton_6.setBackground(new Color(95, 158, 160));
		btnNewButton_6.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginPage logi = new LoginPage();
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        setExtendedState(JFrame.MAXIMIZED_BOTH);
			    logi.setVisible(true);
				dispose();
				
			}

		});
		btnNewButton_6.setBounds(203, 367, 162, 39);
		getContentPane().add(btnNewButton_6);
	}
}
