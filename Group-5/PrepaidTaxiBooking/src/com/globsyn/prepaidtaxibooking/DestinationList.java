package com.globsyn.prepaidtaxibooking;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import java.awt.Color;

public class DestinationList extends JFrame {
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
					DestinationList frame = new DestinationList();
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
	public DestinationList() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DestinationList.class.getResource("/images/icon.jpg")));
		setTitle("Rate Chart");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 0, 0);
		contentPane.add(panel_1);

		headers = new Vector<String>();
		headers.add("Destination");
		headers.add("Rate");
		data = new Vector<Vector<String>>();

		try {
			File f = new File("assets/data/Destinationdb.dat");

			if (f.exists()) {
				Scanner scanner = new Scanner(f);
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
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		JTable table = new JTable();

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int rowindex = table.getSelectedRow();
				System.out.println(table.getModel().getValueAt(rowindex, 0));
				System.out.println(table.getModel().getValueAt(rowindex, 1));
				//System.out.println(table.getModel().getValueAt(rowindex, 2));

			}
		});
		DefaultTableModel model = new DefaultTableModel(data, headers);
		table.setModel(model);
		table.setAutoCreateRowSorter(true);
		
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 64, 1357, 342);

		getContentPane().add(scroll);
		 

		
		JMenuBar menuBar = new JMenuBar();
		scroll.setColumnHeaderView(menuBar);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 0, 1357, 21);
		contentPane.add(menuBar_1);
		
		JMenu mnNewMenu = new JMenu("NEW");
		mnNewMenu.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 18));
		menuBar_1.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("BOOKING");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Booking book=new Booking();
			book.setVisible(true);
			dispose();
			}
		});
		mntmNewMenuItem.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem);
		KeyStroke ctrlB = KeyStroke.getKeyStroke(KeyEvent.VK_B, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());
		mntmNewMenuItem.setAccelerator(ctrlB);
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("DESTINATION");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewDestination nDL=new NewDestination();
				nDL.setVisible(true);
			
				
			}
		});
		KeyStroke ctrlD = KeyStroke.getKeyStroke(KeyEvent.VK_D, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());
		mntmNewMenuItem_1.setAccelerator(ctrlD);
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		mntmNewMenuItem_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("DRIVER");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DriverList dL=new DriverList();
				dL.setVisible(true);
				AddCar aDC=new AddCar();
				aDC.setVisible(true);
				dispose();
			}
		});
		KeyStroke ctrlT = KeyStroke.getKeyStroke(KeyEvent.VK_T, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());
		mntmNewMenuItem_2.setAccelerator(ctrlT);
		JSeparator separator_2 = new JSeparator();
		mnNewMenu.add(separator_2);
		mntmNewMenuItem_2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_3 = new JMenu("LIST");
		mnNewMenu_3.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 18));
		menuBar_1.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("DRIVER LIST");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DriverList dList=new DriverList();
				dList.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem_5.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("RATE CHART");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DestinationList dList=new DestinationList();
				dList.setVisible(true);
				dispose();
			}
		});
		
		JSeparator separator_3 = new JSeparator();
		mnNewMenu_3.add(separator_3);
		mntmNewMenuItem_6.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("CUSTOMER DATABASE");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerList customer=new CustomerList();
				customer.setVisible(true);
				dispose();
			}
		});
		
		JSeparator separator_4 = new JSeparator();
		mnNewMenu_3.add(separator_4);
		mntmNewMenuItem_7.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_2 = new JMenu("RETURN");
		mnNewMenu_2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 18));
		menuBar_1.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("HOME");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home=new Home();
				home.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		mnNewMenu_2.add(mntmNewMenuItem_3);
		KeyStroke ctrlH = KeyStroke.getKeyStroke(KeyEvent.VK_H, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());
		mntmNewMenuItem_3.setAccelerator(ctrlH);
		textField = new JTextField();
		textField.setBounds(162, 444, 151, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setForeground(Color.ORANGE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Georgia", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i=table.getSelectedRow();
				if(i>=0)
				{
					model.setValueAt(textField.getText(),i,1);
				}
				customerUpdateFile(data);
				File f1 = new File("assets/data/Destinationdb.dat");

				if (f1.exists()) {
					Scanner scanner;
					try {
						scanner = new Scanner(f1);

						while (scanner.hasNext()) {
							Vector<String> row = new Vector<>();

							String line = scanner.nextLine();
							String[] fields = line.split("[|]");
							for (int j = 0; j < fields.length; j++) {
								row.add(fields[j]);
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
				}
			}
		});
		btnNewButton.setBounds(227, 490, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("NEW PRICE:");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 447, 207, 17);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBackground(Color.BLACK);
		separator.setBounds(0, 444, 1357, -18);
		contentPane.add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("RATE CHART");
		lblNewLabel_1.setFont(new Font("Old English Text MT", Font.PLAIN, 40));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(486, 32, 310, 32);
		contentPane.add(lblNewLabel_1);
		setSize(1378, 563);
		setResizable(true);
		setVisible(true);
	}

	
	public void customerUpdateFile(Vector<Vector<String>> data) {

		try {
			File f = new File("assets/data/Destinationdb.dat");

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

