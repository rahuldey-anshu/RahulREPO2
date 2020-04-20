package com.globsyn.wholesalebusiness;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
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
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class SupplierList extends JFrame {

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
					SupplierList frame = new SupplierList();
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
	public SupplierList() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("icons//diamond-icon.png"));

		setTitle("Wholesale Business Application Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 718, 512);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenuItem mntmBack = new JMenuItem("Back");
		mntmBack.setIcon(new ImageIcon("icons//Arrow-Back-3-icon (2).png"));
		mntmBack.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage frame = new HomePage();
				frame.setVisible(true);
				dispose();
			}
		});
		
		JMenuItem mntmHome = new JMenuItem("Home");
		mntmHome.setIcon(new ImageIcon("icons//home-icon.png"));
		mntmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage frame = new HomePage();
				frame.setVisible(true);
				dispose();
			}
		});
		menuBar.add(mntmHome);
		
		JMenu mnRetailer = new JMenu("Retailer");
		menuBar.add(mnRetailer);
		
		JMenuItem mntmAddRetailer = new JMenuItem("Add retailer");
		mntmAddRetailer.setIcon(new ImageIcon("icons//new retailer.png"));
		mnRetailer.add(mntmAddRetailer);
		
		JMenuItem mntmRetailerList = new JMenuItem("Retailer list");
		mntmRetailerList.setIcon(new ImageIcon("icons//ListIcon.png"));
		mntmRetailerList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RetailerList frame = new RetailerList();
				frame.setVisible(true);
				dispose();
			}
		});
		mnRetailer.add(mntmRetailerList);
		
		JMenu mnSupplier = new JMenu("Supplier");
		menuBar.add(mnSupplier);
		
		JMenuItem mntmAddSupplier = new JMenuItem("Add supplier");
		mntmAddSupplier.setIcon(new ImageIcon("icons//new retailer.png"));
		mntmAddSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierPage frame = new SupplierPage();
				frame.setVisible(true);
				dispose();
			}
		});
		mnSupplier.add(mntmAddSupplier);
		
		JMenuItem mntmSupplierList = new JMenuItem("Supplier list");
		mntmSupplierList.setIcon(new ImageIcon("icons//ListIcon.png"));
		mntmSupplierList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierList frame = new SupplierList();
				frame.setVisible(true);
				dispose();
			}
		});
		mnSupplier.add(mntmSupplierList);
		
		JMenu mnProduct = new JMenu("Product");
		menuBar.add(mnProduct);
		
		JMenuItem mntmNewProduct = new JMenuItem("New product");
		mntmNewProduct.setIcon(new ImageIcon("icons//new retailer.png"));
		mntmNewProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductPage frame = new ProductPage();
				frame.setVisible(true);
				dispose();
			}
		});
		mnProduct.add(mntmNewProduct);
		
		JMenuItem mntmProductList = new JMenuItem("Product list");
		mntmProductList.setIcon(new ImageIcon("icons//ListIcon.png"));
		mntmProductList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductList frame = new ProductList();
				frame.setVisible(true);
				dispose();
			}
		});
		mnProduct.add(mntmProductList);
		
		JMenuItem mntmStock = new JMenuItem("Stock");
		mntmStock.setIcon(new ImageIcon("icons//stock.png"));
		mntmStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockPage frame = new StockPage();
				frame.setVisible(true);
				dispose();
			}
		});
		menuBar.add(mntmStock);
		menuBar.add(mntmBack);

		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mntmLogout);
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Are you sure you want to log out?");
				LoginPage window = new LoginPage();
				window.frmLoginForGalaxy.setVisible(true);
				dispose();
			}
		});
		mntmLogout.setIcon(new ImageIcon("icons//logout-icon1.png"));
		
		JMenuItem menuItem_1 = new JMenuItem("");
		menuBar.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("");
		menuBar.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("");
		menuBar.add(menuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblRetailersList = new JLabel("Suppliers List ");
		lblRetailersList.setFont(new Font("Tahoma", Font.BOLD, 25));
		panel.add(lblRetailersList);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);

		headers = new Vector<String>();
		headers.add("Name ");
		headers.add("PAN No.");
		headers.add("Company type");
		headers.add("Company name");
		headers.add("Company ID");
		headers.add("Phone no");
		headers.add("Email id");
		headers.add("Address");
		headers.add("City/town");
		headers.add("Pin Code");
		headers.add("State");
		headers.add("Country");
		

		data = new Vector<Vector<String>>();

		try {
			File f = new File("database/supplier.dat");

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
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel(data, headers);
		table.setModel(model);
		table.setAutoCreateRowSorter(true);
		model = new DefaultTableModel(data, headers);
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);

		getContentPane().add(scroll);

		setResizable(true);
		setVisible(true);
	}

}
