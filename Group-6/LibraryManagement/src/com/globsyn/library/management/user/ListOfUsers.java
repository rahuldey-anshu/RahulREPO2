package com.globsyn.library.management.user;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.regex.PatternSyntaxException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.globsyn.library.management.books.AddBooks;
import com.globsyn.library.management.books.IssueBooks;
import com.globsyn.library.management.books.ReturnBooks;
import com.globsyn.library.management.member.AddMember;
import com.globsyn.library.management.user.Welcome;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListOfUsers extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static Vector<String> headers;
	private static Vector<Vector<String>> data;
	private JTextField textField;
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListOfUsers frame = new ListOfUsers();
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
	public ListOfUsers() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\lib.png"));
		setTitle("ADDED USERS LIST");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 358);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("MENU");
		menuBar.add(mnMenu);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("EXIT");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		mnMenu.add(mntmNewMenuItem_6);
		
		JMenuItem mntmLogin = new JMenuItem("LOGIN");
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				LoginPage loginPage = new LoginPage();
				loginPage.setVisible(true);
				setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
				
				
			}
		});
		mnMenu.add(mntmLogin);
		
	
		
	
	
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		
		JLabel search = new JLabel("SEARCH  : ");
				search.setFont(new Font("Arial", Font.BOLD, 25));
               // panel.add(search);
                contentPane.add(search);
            	
				
				
		JLabel bookList = new JLabel("LIST OF USERS");
		bookList.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(bookList);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("SEARCH USERS : ");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		
		///////////////////////////////////////////////
		
		JTable table = new JTable();
		JScrollPane scroll = new JScrollPane(table);
		 
		getContentPane().add(scroll, BorderLayout.SOUTH);
		setSize(1370, 661);
		setResizable(true);
		setVisible(true);
		
		textField.addKeyListener(new KeyAdapter() 
		{
			public void keyReleased(KeyEvent arg0) 
			{
				String value = textField.getText();
				createTable(value, table);
			}
		});
		
		///////////////////////////////////////////
		
		
		panel_1.add(textField);
		textField.setColumns(17);
		String value = textField.getText();
		
		
		// 4. Add the mouse listner to it
		/*	table.addMouseListener(new MouseAdapter() 
		{
		    @Override
		    public void mouseReleased(final MouseEvent e) 
		    {
		        if (e.getClickCount() == 1) {
		            final JTable target = (JTable)e.getSource();
		            final int row = target.getSelectedRow();
		            final int column = target.getSelectedColumn();
		         
		            
		            String value1 = (String)target.getValueAt(row, 0);
		            String value2 = (String)target.getValueAt(row, 1);
		            String value3 = (String)target.getValueAt(row, 2);
		            String value4 = (String)target.getValueAt(row, 3);
		            
		            IssueBooks issue = new IssueBooks(value1, value2, value3, value4);
		           issue.setVisible(true);

		        }
		    }
		});*/
		
		
		createTable("",table);
		
	}
	
	private void createTable( String value, JTable table ) 
	{

		headers = new Vector<String>();
		headers.add("Users Number ");
		headers.add("Users Password ");
		
		data = new Vector<   Vector<String>  >();
		
		try {
			File f = new File("data/users.dat");
			
			if(f.exists()){
				Scanner scanner = new Scanner(f);
				while(scanner.hasNext()){
					Vector<String> row = new Vector<>();
					
					String line = scanner.nextLine();
					String[] fields = line.split("[|]");
					for (int i = 0; i < fields.length; i++) {
						
						
						row.add(fields[i]);
					}
					if( fields[1].toLowerCase().contains(value.toLowerCase()))
					{
					data.add(row);
										}
				}
			}
		} catch (FileNotFoundException e) {
			 
			e.printStackTrace();
		}
		
		
		DefaultTableModel model = new DefaultTableModel(data, headers);
		table.setModel(model);
	
	}

}
