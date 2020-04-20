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
import javax.swing.KeyStroke;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class CustomerList extends JFrame {
	private JPanel contentPane;
	private JTable table;
	private static Vector<String> headers;
	private static Vector<Vector<String>> data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerList frame = new CustomerList();
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
	public CustomerList() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(CustomerList.class.getResource("/images/icon.jpg")));
		setTitle("Customer Database");
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
		headers.add("Date and Time");
		headers.add("Customer Name ");
		headers.add("Contact No.(Customer)");
		headers.add("Destination");
		headers.add("No. of Passengers");
		headers.add("Driver Name");
		headers.add("License No.");
		headers.add("Contact No.(Driver)");
		headers.add("Car Details");
		headers.add("Plate No.");
		headers.add("Amount");
		data = new Vector<Vector<String>>();

		try {
			File f = new File("assets/data/BookingDetails.dat");

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
				System.out.println(table.getModel().getValueAt(rowindex, 2));

			}
		});
		DefaultTableModel model = new DefaultTableModel(data, headers);
		table.setModel(model);
		table.setAutoCreateRowSorter(true);
		//model = new DefaultTableModel(data, headers);
		//table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 64, 1357, 412);

		getContentPane().add(scroll);

		JButton btnDeleteRow = new JButton("Cancel Booking");
		btnDeleteRow.setForeground(Color.ORANGE);
		btnDeleteRow.setBackground(Color.BLACK);
		btnDeleteRow.setFont(new Font("Georgia", Font.PLAIN, 15));
		btnDeleteRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int rowindex = table.getSelectedRow();

				data.remove(rowindex);

				System.out.println(data.size());

				customerDeleteFromFile(data);
				CustomerList customer = new CustomerList();
				customer.setVisible(true);
				dispose();
			}
		});
		btnDeleteRow.setBounds(10, 490, 147, 23);
		contentPane.add(btnDeleteRow);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1357, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("NEW");
		mnNewMenu.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("BOOKING");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Booking book=new Booking();
				book.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem_5.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_5);
		KeyStroke ctrlB = KeyStroke.getKeyStroke(KeyEvent.VK_B, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());
		mntmNewMenuItem_5.setAccelerator(ctrlB);
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("DESTINATION");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DestinationList destination=new DestinationList();
				destination.setVisible(true);
				NewDestination nDL=new NewDestination();
				nDL.setVisible(true);
				dispose();
			}
		});
		KeyStroke ctrlD = KeyStroke.getKeyStroke(KeyEvent.VK_D, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());
		mntmNewMenuItem_6.setAccelerator(ctrlD);
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		mntmNewMenuItem_6.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_6);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("DRIVER");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DriverList driver=new DriverList();
				driver.setVisible(true);
				AddCar aDC=new AddCar();
				aDC.setVisible(true);
				dispose();
			}
		});
		KeyStroke ctrlT = KeyStroke.getKeyStroke(KeyEvent.VK_T, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());
		mntmNewMenuItem_7.setAccelerator(ctrlT);
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		mntmNewMenuItem_7.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_7);
		
		JMenu mnNewMenu_2 = new JMenu("LIST");
		mnNewMenu_2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("DRIVER LIST");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DriverList dList=new DriverList();
				dList.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem_2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("RATE CHART");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DestinationList dList=new DestinationList();
				dList.setVisible(true);
				dispose();
			}
		});
		
		JSeparator separator_2 = new JSeparator();
		mnNewMenu_2.add(separator_2);
		mntmNewMenuItem_3.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("CUSTOMER DATABASE");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerList customer = new CustomerList();
				customer.setVisible(true);
				dispose();
			}
		});
		
		JSeparator separator_3 = new JSeparator();
		mnNewMenu_2.add(separator_3);
		mntmNewMenuItem_4.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("RETURN");
		mnNewMenu_3.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("HOME");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Home home=new Home();
				home.setVisible(true);
				dispose();
			}
		});
		mntmNewMenuItem.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem);
		KeyStroke ctrlH = KeyStroke.getKeyStroke(KeyEvent.VK_H, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());
		mntmNewMenuItem.setAccelerator(ctrlH);
		
		JLabel lblNewLabel = new JLabel("CUSTOMER DATABASE");
		lblNewLabel.setFont(new Font("Old English Text MT", Font.PLAIN, 40));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(549, 24, 570, 41);
		contentPane.add(lblNewLabel);
		setSize(1378, 563);
		setResizable(true);
		setVisible(true);
	}

	public void customerDeleteFromFile(Vector<Vector<String>> data) {

		try {
			File f = new File("assets/data/BookingDetails.dat");

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
