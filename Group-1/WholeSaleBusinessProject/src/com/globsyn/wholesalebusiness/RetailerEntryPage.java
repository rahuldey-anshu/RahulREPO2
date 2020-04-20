package com.globsyn.wholesalebusiness;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Toolkit;

public class RetailerEntryPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RetailerEntryPage frame = new RetailerEntryPage();
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
	public RetailerEntryPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("icons//diamond-icon.png"));
		setTitle("Wholesale Business Application Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 544);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblThisIsThe = new JLabel("This is the retailer section");
		lblThisIsThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblThisIsThe.setFont(new Font("Adobe Caslon Pro Bold", Font.PLAIN, 52));
		lblThisIsThe.setBounds(71, 91, 620, 135);
		contentPane.add(lblThisIsThe);
		
		JLabel lblAddupdatesearchOr = new JLabel("Add,update ,search or remove any retailer's details here. ");
		lblAddupdatesearchOr.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddupdatesearchOr.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddupdatesearchOr.setBounds(81, 282, 610, 48);
		contentPane.add(lblAddupdatesearchOr);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RetailerPage frame = new RetailerPage();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNext.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnNext.setBounds(589, 398, 101, 48);
		contentPane.add(btnNext);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 453, 31);
		contentPane.add(menuBar);
		
		JMenuItem mntmHome = new JMenuItem("Home");
		mntmHome.setIcon(new ImageIcon("icons//home-icon.png"));
		menuBar.add(mntmHome);
		
		JMenu mnRetailer = new JMenu("Retailer");
		menuBar.add(mnRetailer);
		
		JMenuItem mntmAddRetailer = new JMenuItem("Add retailer");
		mntmAddRetailer.setIcon(new ImageIcon("icons//new retailer.png"));
		mntmAddRetailer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RetailerPage frame = new RetailerPage();
				frame.setVisible(true);
				dispose();
			}
		});
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
		
		JMenuItem mntmBack = new JMenuItem("Back");
		mntmBack.setIcon(new ImageIcon("icons//Arrow-Back-3-icon (2).png"));
		mntmBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage frame = new HomePage();
				frame.setVisible(true);
				dispose();
			}
		});
		menuBar.add(mntmBack);
		
		JMenuItem mntmLogOut = new JMenuItem("Log out");
		mntmLogOut.setIcon(new ImageIcon("icons//logout-icon1.png"));
		menuBar.add(mntmLogOut);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("icons//pattern.jpg"));
		label.setBounds(0, 0, 756, 506);
		contentPane.add(label);
	}
}
