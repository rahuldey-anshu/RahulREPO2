package com.globsyn.library.management.member;


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
import com.globsyn.library.management.books.BookList;
import com.globsyn.library.management.books.ReturnBooks;
import com.globsyn.library.management.member.AddMember;
import com.globsyn.library.management.user.Welcome;

import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
import javax.swing.JButton;

public class MemberList extends JFrame {

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
					MemberList frame = new MemberList();
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
	public MemberList() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\lib.png"));
		setTitle("ADDED USERS LIST");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 358);
		
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
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Remove Books");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
            	
				
				
		JLabel memberList = new JLabel("MEMBERS LIST ");
		memberList.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(memberList);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Search Members : ");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(695, 8, 141, 20);
		
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
		
		JButton btnNewButton = new JButton("Click to Remove Members");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int rowindex = table.getSelectedRow();

				data.remove(rowindex);

				deleteFromFile(data);
				File f1 = new File("data/members.dat");

				if (f1.exists()) {
					Scanner scanner;
					try {
						scanner = new Scanner(f1);

						while (scanner.hasNext()) {
							Vector<String> row = new Vector<>();

							String line = scanner.nextLine();
							String[] fields = line.split("[|]");
							for (int i = 0; i < fields.length; i++) {
								row.add(fields[i]);
							}

							data.add(row);
						}

						scanner.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e2) {
						e2.printStackTrace();
					}

					DefaultTableModel model = new DefaultTableModel(data, headers);
					table.setModel(model);
					table.setRowSelectionAllowed(true);
					table.setAutoCreateRowSorter(true);
					model = new DefaultTableModel(data, headers);
					table.setModel(model);
					JScrollPane scroll = new JScrollPane(table);
					scroll.setBounds(5, 5, 1352, 471);

					getContentPane().add(scroll);

				}
				
				MemberList memberList = new MemberList();
				memberList.setVisible(true);
				 setExtendedState(JFrame.MAXIMIZED_BOTH);
				dispose();
				
				

			}
		});
		panel_1.add(btnNewButton);
		String value = textField.getText();
		
		
		// 4. Add the mouse listner to it
		table.addMouseListener(new MouseAdapter() 
		{
		    @Override
		    public void mouseReleased(final MouseEvent e) 
		    {
		        
		        if (e.getClickCount() == 1)
		        {
		        
		        	int rowindex = table.getSelectedRow();
				
		        }
		        
		    }
		});
		
		
		createTable("",table);
		
	}
	
	private void createTable( String value, JTable table ) 
	{

		headers = new Vector<String>();
		headers.add("Member ID");
		headers.add("Member Name");
		headers.add("Gender");
		headers.add("Location");
		headers.add("Address");
		
		data = new Vector<   Vector<String>  >();
		
		try {
			File f = new File("data/members.dat");
			
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

	
	public void deleteFromFile(Vector<Vector<String>> data) 
	{

		try {
			File f = new File("data/members.dat");

			if (f.exists()) {
				FileWriter fileWriter = new FileWriter(f);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				for (int i = 0; i < data.size(); i++) {
					Vector<String> vector = (Vector<String>) data.get(i);

					String line = "";
					for (int j = 0; j < vector.size(); j++) {
						line += vector.get(j) + "|";
					}
					line = line.substring(0, line.length() - 1);
					bufferedWriter.write(line + "\n");
				}

				bufferedWriter.flush();
				bufferedWriter.close();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
