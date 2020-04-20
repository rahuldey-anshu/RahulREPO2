package com.globsyn.wholesalebusiness;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

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
import java.awt.HeadlessException;

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
import java.awt.Color;
import javax.swing.JTextField;

public class OrderUpdation extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static Vector<String> headers;
	private static Vector<Vector<String>> data;
	private JTextField textFieldQuantity;
	private JTextField textFieldDiscount;
	private JTextField textFieldGST;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderUpdation frame = new OrderUpdation();
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
	public OrderUpdation() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("icons//diamond-icon.png"));

		setTitle("Wholesale Business Application Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 560);

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

		JMenuItem menuItem = new JMenuItem("");
		menuBar.add(menuItem);

		JMenuItem menuItem_3 = new JMenuItem("");
		menuBar.add(menuItem_3);

		JMenuItem menuItem_2 = new JMenuItem("");
		menuBar.add(menuItem_2);

		JMenuItem menuItem_1 = new JMenuItem("");
		menuBar.add(menuItem_1);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		headers = new Vector<String>();
		headers.add("Name ");
		headers.add("Product ID");
		headers.add("Product Type");
		headers.add("Price");
		headers.add("Unit of measurement");
		headers.add("Quantity");

		data = new Vector<Vector<String>>();

		try {
			File f = new File("database/product.dat");

			if (f.exists()) {
				Scanner scanner = new Scanner(f);
				while (scanner.hasNext()) {
					Vector<String> row = new Vector<>();

					String line = scanner.nextLine();
					String[] fields = line.split("[|]");
					String ProName = fields[0];
					String ProID = fields[1];
					String ProType = fields[2];
					String ProPrice = fields[3];
					String ProUnit = fields[4];
					String ProQuantity = fields[5];
					row.add(ProName);
					row.add(ProID);
					row.add(ProType);
					row.add(ProPrice);
					row.add(ProUnit);
					row.add(ProQuantity);
					data.add(row);
				}
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		JTable table = new JTable();
		model = new DefaultTableModel(data, headers);
		table.setModel(model);
		table.setAutoCreateRowSorter(true);
		model = new DefaultTableModel(data, headers);
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(72, 116, 623, 237);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				String proName = table.getValueAt(table.getSelectedRow(), 0).toString();
				String proID = table.getValueAt(table.getSelectedRow(), 1).toString();
				String price = table.getValueAt(table.getSelectedRow(), 3).toString();
				// int quan = Integer.parseInt(quantity);

			}
		});

		getContentPane().add(scroll);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 205));
		panel.setBounds(10, 11, 732, 62);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblThisIsThe = new JLabel("This is the order page..");
		lblThisIsThe.setFont(new Font("Segoe UI", Font.BOLD, 19));
		lblThisIsThe.setBounds(23, 7, 319, 40);
		panel.add(lblThisIsThe);

		JLabel lblYouCanCheck = new JLabel("You can place your orders here");
		lblYouCanCheck.setFont(new Font("Baskerville Old Face", Font.PLAIN, 14));
		lblYouCanCheck.setBounds(369, 11, 341, 40);
		panel.add(lblYouCanCheck);

		JLabel lblProductStock = new JLabel("Product list:");
		lblProductStock.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProductStock.setBounds(72, 84, 131, 21);
		contentPane.add(lblProductStock);

		JButton btnOrder = new JButton("Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String proName = table.getValueAt(table.getSelectedRow(), 0).toString();
					String proID = table.getValueAt(table.getSelectedRow(), 1).toString();
					String price = table.getValueAt(table.getSelectedRow(), 3).toString();
					String stock = table.getValueAt(table.getSelectedRow(), 5).toString();
					String quantity = textFieldQuantity.getText();
					String discount = textFieldDiscount.getText().toString();
					String tax = textFieldGST.getText().toString();
					int stock1 = Integer.parseInt(stock);
					int quantity1 = Integer.parseInt(quantity);
					String amount;
					if (quantity != null && !"".equals(quantity.trim()) && discount != null
							&& !"".equals(discount.trim()) && tax != null && !"".equals(tax.trim())) {
						if (quantity1 < stock1) {

							double a, b, c;
							a = Double.parseDouble(price);
							b = Double.parseDouble(quantity);

							c = a * b;
							amount = Double.toString(c);

							double d = Double.parseDouble(discount);
							double t = Double.parseDouble(tax);

							double d1 = (d / 100) * c;
							String discount1 = Double.toString(d1);

							double t1 = (t / 100) * c;
							String tax1 = Double.toString(t1);

							double totalAmount = c - (d1 + t1);
							String total = Double.toString(totalAmount);

							File f = new File("database/order.dat");

							if (f.exists()) {
								String dataToWrite = proName + "|" + proID + "|" + price + "|" + quantity + "|" + amount
										+ "|" + discount1 + "|" + tax1 + "|" + total + "\n";

								try {
									FileWriter fw = new FileWriter(f, true);
									BufferedWriter bw = new BufferedWriter(fw);
									bw.write(dataToWrite);
									bw.flush();
									bw.close();

								} catch (IOException e2) {
									e2.printStackTrace();
									JOptionPane.showMessageDialog(contentPane, "Unable to save order details",
											"Save Error", JOptionPane.ERROR_MESSAGE);
								} catch (Exception e2) {
									JOptionPane.showMessageDialog(contentPane, "Unable to save order details",
											"Save Error", JOptionPane.ERROR_MESSAGE);
								}

							}

							stock1 = stock1 - quantity1;
							String newStock = Integer.toString(stock1);
							try {
								int i = table.getSelectedRow();

								if (i >= 0) {
									model.setValueAt(newStock, i, 5);
								}
								orderUpdateFile(data);
								File f1 = new File("database/product.dat");

								if (f1.exists()) {
									Scanner scanner = null;
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
								}
							} catch (Exception e1) {
								
								e1.printStackTrace();
							}

							int yesNo = JOptionPane.showConfirmDialog(contentPane, "Do you want to order more??",
									"Confirmation!!!", JOptionPane.INFORMATION_MESSAGE);
							if (yesNo == JOptionPane.YES_OPTION) {
								OrderUpdation frame = new OrderUpdation();
								frame.setVisible(true);
								total += total;
								dispose();

							} else if (yesNo == JOptionPane.CANCEL_OPTION) {
								HomePage home = new HomePage();
								home.setVisible(true);
								dispose();

							} else if (yesNo == JOptionPane.NO_OPTION) {
								BillPage b1 = new BillPage();
								b1.setTotal(total);

								b1.setVisible(true);
								dispose();
							} else {
								JOptionPane.showMessageDialog(contentPane, "Please enter quantity", " Error",
										JOptionPane.ERROR_MESSAGE);
							}
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"Cant place order!!!\nPlease enter a lesser quantity than the stock available");

					}
				} catch (ArrayIndexOutOfBoundsException e1) {
					JOptionPane.showMessageDialog(contentPane, "Select product to order", " Error",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPane, "Select product to order", " Error",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}

			}
		});
		btnOrder.setFont(new Font("Hobo Std", Font.PLAIN, 14));
		btnOrder.setBounds(328, 435, 89, 52);
		contentPane.add(btnOrder);

		textFieldQuantity = new JTextField();
		textFieldQuantity.setBounds(72, 393, 115, 20);
		contentPane.add(textFieldQuantity);
		textFieldQuantity.setColumns(10);

		JLabel lblEnterQuantity = new JLabel("Enter quantity :");
		lblEnterQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterQuantity.setBounds(72, 353, 125, 28);
		contentPane.add(lblEnterQuantity);

		JLabel lblNewLabel = new JLabel("Enter discount in % :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(296, 353, 189, 25);
		contentPane.add(lblNewLabel);

		textFieldDiscount = new JTextField();
		textFieldDiscount.setBounds(296, 393, 102, 20);
		contentPane.add(textFieldDiscount);
		textFieldDiscount.setColumns(10);

		JLabel lblEnterGstIn = new JLabel("Enter GST in % :");
		lblEnterGstIn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEnterGstIn.setBounds(534, 354, 161, 23);
		contentPane.add(lblEnterGstIn);

		textFieldGST = new JTextField();
		textFieldGST.setBounds(531, 393, 115, 20);
		contentPane.add(textFieldGST);
		textFieldGST.setColumns(10);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("icons//blue.png"));
		label.setBounds(0, 0, 752, 498);
		contentPane.add(label);

		setResizable(true);
		setVisible(true);
	}

	public void orderUpdateFile(Vector<Vector<String>> data) {

		try {
			File f = new File("database/product.dat");

			if (f.exists()) {
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				for (int i = 0; i < data.size(); i++) {
					Vector<String> vector = (Vector<String>) data.get(i);

					String line = "";
					for (int j = 0; j < vector.size(); j++) {
						line += vector.get(j) + "|";

					}
					line = line.substring(0, line.length() - 1);
					bw.write(line + "\n");
				}
				bw.flush();
				bw.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
