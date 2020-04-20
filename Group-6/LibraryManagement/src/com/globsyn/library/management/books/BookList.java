package com.globsyn.library.management.books;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.regex.PatternSyntaxException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import com.globsyn.library.management.member.AddMember;
import com.globsyn.library.management.member.MemberList;
//import com.globsyn.library.management.user.ReturnBooks;
import com.globsyn.library.management.user.Welcome;

import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class BookList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static Vector<String> headers;
	private static Vector<Vector<String>> data;
	private JTextField textField;
	private int counterClick;
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookList frame = new BookList();
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
	public BookList() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\lib.png"));
		setTitle("ADDED BOOKS LIST");
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
		
		/*JMenuItem mntmNewMenuItem_1 = new JMenuItem("REMOVE BOOKS");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				BookList bookList = new BookList();
				bookList.setVisible(true);
				dispose();
				
			}
		});
		mnMenu.add(mntmNewMenuItem_1);
		*/
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
            	
				
				
		JLabel bookList = new JLabel("BOOK LIST ");
		bookList.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(bookList);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Book Name or Book ID  :");
		lblNewLabel.setBounds(455, 5, 235, 27);
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
		
		textField.addKeyListener(new KeyAdapter() {
			//search
			public void keyReleased(KeyEvent arg0) 
			{
					String value = textField.getText();
					createTable(value, table);					
			}
			
			
		});
		
		/////////////////////////////////////////////
		
		
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnClickToRemove = new JButton("Click to remove Books");
		btnClickToRemove.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnClickToRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				int rowindex = table.getSelectedRow();

				data.remove(rowindex);

				//System.out.println(data.size());

				deleteFromFile(data);
				File f1 = new File("data/new book.dat");

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
					
					BookList bookList = new BookList();
					bookList.setVisible(true);
					 setExtendedState(JFrame.MAXIMIZED_BOTH);
					 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					 dispose();

				}
				
				
			
				
			}
		});
		btnClickToRemove.setBounds(570, 130, 173, 41);
		panel_1.add(btnClickToRemove);
		String value = textField.getText();
		
		counterClick = 0;
		// 4. Add the mouse listner to it
		table.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(final MouseEvent e) {
		    	
		    	counterClick++;
		    
		        if (counterClick == 1)
		        {
		        	int rowindex = table.getSelectedRow();			
		        }
		        else if (counterClick == 2) 
		        {
		            final JTable target = (JTable)e.getSource();
		            final int row = target.getSelectedRow();
		            final int column = target.getSelectedColumn();
		         
		            //pass value of selected row to next frame 
		            String value1 = (String)target.getValueAt(row, 0);
		            String value2 = (String)target.getValueAt(row, 1);
		            String value3 = (String)target.getValueAt(row, 2);
		            String value4 = (String)target.getValueAt(row, 3);
		            
		            IssueBooks issue = new IssueBooks(value1, value2, value3, value4);
		            issue.setVisible(true);
		            setExtendedState(JFrame.MAXIMIZED_BOTH);
		            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		            counterClick = 0;
		            dispose();
		        }
		    }
		});
		
		
		createTable("",table);
		
	}
	
	private void createTable( String value, JTable table ) 
	{
		
		//DefaultTableModel dm = new DefaultTableModel(data, headers);
		//int rowCount = dm.getRowCount();
		//Remove rows one by one from the end of the table
		//for (int i = rowCount - 1; i >= 0; i--) {
		  //  dm.removeRow(i);
		//}
		
		headers = new Vector<String>();
		headers.add("Book Number ");
		headers.add("Book Name ");
		headers.add("Author ");
		headers.add("Category ");
		headers.add("Quantity ");
		
		data = new Vector<   Vector<String>  >();
		
		try {
			File f = new File("data/new book.dat");
			
			if(f.exists()){
				Scanner scanner = new Scanner(f);
				while(scanner.hasNext()){
					Vector<String> row = new Vector<>();
					
					String line = scanner.nextLine();
					String[] fields = line.split("[|]");
					for (int i = 0; i < fields.length; i++) {
						
						
						row.add(fields[i]);
					}
					if( fields[1].toLowerCase().contains(value.toLowerCase()) || fields[0].toLowerCase().contains(value.toLowerCase()))
					{
						data.add(row);
					
						//JOptionPane.showMessageDialog(null, "value: "+data.size());
					}
				}
			}
		} catch (FileNotFoundException e) {
			 
			e.printStackTrace();
		}
		
		
		
		DefaultTableModel model = new DefaultTableModel(data, headers);
		table.setModel(model);
		
		//int rowCount = model.getRowCount();
		//Remove rows one by one from the end of the table
		//for (int i = rowCount - 1; i >= 0; i--) {
		//	model.removeRow(i);
		//}
		//table.setAutoCreateRowSorter(true);
		//model = new DefaultTableModel(data, headers);
		//model.table.setModel(model);
	}

	public void deleteFromFile(Vector<Vector<String>> data) 
	{

		try {
			File f = new File("data/new book.dat");

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
