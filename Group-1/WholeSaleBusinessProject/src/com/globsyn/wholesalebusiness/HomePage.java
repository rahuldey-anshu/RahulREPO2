package com.globsyn.wholesalebusiness;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Toolkit;

public class HomePage extends JFrame {

	private JPanel contentPane;
	private static Vector<String> headers;
	private static Vector<Vector<String>> data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("icons//diamond-icon.png"));
		setTitle("Wholesale Business Application Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 748, 579);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 360, 34);
		contentPane.add(menuBar);

		JMenu mnRetailer = new JMenu("Retailer");
		menuBar.add(mnRetailer);

		JMenuItem mntmRetailerList = new JMenuItem("Retailer list");
		mntmRetailerList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RetailerList frame = new RetailerList();
				frame.setVisible(true);
				dispose();
			}
		});

		JMenuItem mntmNew = new JMenuItem("Add retailer ");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RetailerPage frame = new RetailerPage();
				frame.setVisible(true);
				dispose();
			}
		});
		mntmNew.setIcon(new ImageIcon("icons//new retailer.png"));
		mnRetailer.add(mntmNew);

		JSeparator separator_1 = new JSeparator();
		mnRetailer.add(separator_1);
		mntmRetailerList.setIcon(new ImageIcon("icons//ListIcon.png"));
		mnRetailer.add(mntmRetailerList);

		JMenu mnSupplier = new JMenu("Supplier");
		menuBar.add(mnSupplier);

		JMenuItem mntmAddSupplier = new JMenuItem("Add Supplier");
		mntmAddSupplier.setIcon(new ImageIcon("icons//new retailer.png"));
		mntmAddSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierPage frame = new SupplierPage();
				frame.setVisible(true);
				dispose();
			}
		});
		mnSupplier.add(mntmAddSupplier);

		JSeparator separator_2 = new JSeparator();
		mnSupplier.add(separator_2);

		JMenuItem mntmSupplierList = new JMenuItem("Supplier List");
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

		JMenuItem mntmProductList = new JMenuItem("Product List");
		mntmProductList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductList frame = new ProductList();
				frame.setVisible(true);
			}
		});

		JSeparator separator = new JSeparator();
		mnProduct.add(separator);

		JMenuItem mntmNew_1 = new JMenuItem("New product");
		mntmNew_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductPage frame = new ProductPage();
				frame.setVisible(true);
				dispose();
			}
		});
		mntmNew_1.setIcon(new ImageIcon("icons//new retailer.png"));
		mnProduct.add(mntmNew_1);

		JSeparator separator_3 = new JSeparator();
		mnProduct.add(separator_3);
		mntmProductList.setIcon(new ImageIcon("icons//ListIcon.png"));
		mnProduct.add(mntmProductList);

		JMenuItem mntmLogout = new JMenuItem("LogOut");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int yesNo = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to log out??",
						"Confirmation!!!", JOptionPane.INFORMATION_MESSAGE);
				if (yesNo == JOptionPane.YES_OPTION) {
					LoginPage window = new LoginPage();
					window.frmLoginForGalaxy.setVisible(true);
					dispose();

				} else if (yesNo == JOptionPane.CANCEL_OPTION) {
					HomePage home = new HomePage();
					home.setVisible(true);
					dispose();

				} else if (yesNo == JOptionPane.NO_OPTION) {
					HomePage home = new HomePage();
					home.setVisible(true);
					dispose();
				}

			}
		});

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
		mntmLogout.setIcon(new ImageIcon("icons//logout-icon1.png"));
		menuBar.add(mntmLogout);

		JButton btnRetailer = new JButton("RETAILER");
		btnRetailer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RetailerEntryPage frame = new RetailerEntryPage();
				frame.setVisible(true);
				dispose();
			}
		});

		btnRetailer.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btnRetailer.setBounds(31, 330, 111, 136);
		contentPane.add(btnRetailer);

		JButton btnStock = new JButton("STOCK");
		btnStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockPage frame = new StockPage();
				frame.setVisible(true);

				dispose();
			}
		});
		btnStock.setFont(new Font("Segoe UI", Font.BOLD, 17));
		btnStock.setBounds(459, 330, 111, 136);
		contentPane.add(btnStock);

		JButton btnNewButton = new JButton("Retailer list");
		btnNewButton.setBounds(31, 477, 225, 38);
		contentPane.add(btnNewButton);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RetailerList frame = new RetailerList();
				frame.setVisible(true);
			}
		});

		JButton btnSupplierList = new JButton("Supplier list");
		btnSupplierList.setBounds(255, 477, 231, 38);
		contentPane.add(btnSupplierList);
		btnSupplierList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierList frame = new SupplierList();
				frame.setVisible(true);
			}
		});
		btnSupplierList.setFont(new Font("Segoe UI", Font.BOLD, 15));

		JButton btnProductList = new JButton("Product list");
		btnProductList.setBounds(486, 477, 220, 38);
		contentPane.add(btnProductList);
		btnProductList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProductList frame = new ProductList();
				frame.setVisible(true);
			}
		});
		btnProductList.setFont(new Font("Segoe UI", Font.BOLD, 15));

		JButton btnOrder = new JButton("ORDER");
		btnOrder.setBounds(595, 331, 111, 135);
		contentPane.add(btnOrder);
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderUpdation frame = new OrderUpdation();
				frame.setVisible(true);

				dispose();
			}
		});

		btnOrder.setFont(new Font("Segoe UI", Font.BOLD, 17));

		JButton btnReport = new JButton("SUPPLIER");
		btnReport.setBounds(168, 331, 120, 135);
		contentPane.add(btnReport);
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierEntryPage frame = new SupplierEntryPage();
				frame.setVisible(true);

				dispose();
			}
		});

		btnReport.setFont(new Font("Segoe UI", Font.BOLD, 17));

		JButton btnProduct = new JButton("PRODUCT");
		btnProduct.setBounds(317, 330, 120, 136);
		contentPane.add(btnProduct);
		btnProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProductEntryPage frame = new ProductEntryPage();
				frame.setVisible(true);

				dispose();
			}
		});

		btnProduct.setFont(new Font("Segoe UI", Font.BOLD, 17));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(31, 45, 675, 136);
		contentPane.add(panel_1);
		panel_1.setBackground(new Color(255, 250, 205));
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("  WELCOME TO GALAXY ELECTRONICS");
		lblNewLabel.setFont(new Font("Adobe Caslon Pro Bold", Font.PLAIN, 25));
		lblNewLabel.setBounds(149, 0, 526, 67);
		panel_1.add(lblNewLabel);

		JLabel lblWholesalerServices = new JLabel(" WHOLESALER SERVICES");
		lblWholesalerServices.setHorizontalAlignment(SwingConstants.CENTER);
		lblWholesalerServices.setFont(new Font("Adobe Caslon Pro Bold", Font.PLAIN, 25));
		lblWholesalerServices.setBounds(161, 67, 514, 58);
		panel_1.add(lblWholesalerServices);

		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setIcon(new ImageIcon("icons//diamond-icon (2).png"));
		label_1.setBounds(10, 0, 141, 136);
		panel_1.add(label_1);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("icons//thumb (2).jpeg"));
		label.setBounds(0, 184, 733, 331);
		contentPane.add(label);
	}
}
