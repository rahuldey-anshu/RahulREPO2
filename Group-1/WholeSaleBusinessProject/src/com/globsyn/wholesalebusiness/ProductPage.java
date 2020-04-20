package com.globsyn.wholesalebusiness;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Toolkit;

public class ProductPage extends JFrame {

	private JPanel contentPane;
	private final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JTextField textFieldProductName;
	private JTextField textFieldProductId;
	private JTextField textFieldProductType;
	private JTextField textFieldProductPrice;
	private JTextField textFieldUpdateProduct;
	private JTextField textFieldSearchProduct;
	private JTextField textFieldRemoveProduct;
	private static Vector<String> headers;
	private static Vector<Vector<String>> data;
	private JTable tablepRemove;
	private JTextField textFieldpSearch;
	private JTable tableUpdateProduct;
	private JTable tablepSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductPage frame = new ProductPage();
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
	public ProductPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("icons//diamond-icon.png"));
		setTitle("Wholesale Business Application Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		tabbedPane.setBounds(10, 45, 715, 468);
		contentPane.add(tabbedPane);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("ADD", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblEnterProductDetails = new JLabel("Enter product details below..");
		lblEnterProductDetails.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterProductDetails.setBounds(21, 22, 266, 22);
		panel_1.add(lblEnterProductDetails);

		JLabel lblNameOfProduct = new JLabel("Name of Product :");
		lblNameOfProduct.setBounds(21, 77, 115, 14);
		panel_1.add(lblNameOfProduct);

		JLabel lblProductId = new JLabel("Product ID :");
		lblProductId.setBounds(21, 122, 95, 14);
		panel_1.add(lblProductId);

		JLabel lblProductType = new JLabel("Product type :");
		lblProductType.setBounds(21, 170, 95, 14);
		panel_1.add(lblProductType);

		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setBounds(411, 77, 46, 14);
		panel_1.add(lblPrice);

		JLabel lblUnitOfMeasurement = new JLabel("Unit of measurement :");
		lblUnitOfMeasurement.setBounds(411, 122, 140, 14);
		panel_1.add(lblUnitOfMeasurement);

		JLabel lblQuantity = new JLabel("Quantity :");
		lblQuantity.setBounds(411, 170, 86, 14);
		panel_1.add(lblQuantity);

		textFieldProductName = new JTextField();
		textFieldProductName.setBounds(126, 74, 161, 20);
		panel_1.add(textFieldProductName);
		textFieldProductName.setColumns(10);

		textFieldProductId = new JTextField();
		textFieldProductId.setBounds(126, 119, 161, 20);
		panel_1.add(textFieldProductId);
		textFieldProductId.setColumns(10);

		textFieldProductType = new JTextField();
		textFieldProductType.setBounds(126, 167, 161, 20);
		panel_1.add(textFieldProductType);
		textFieldProductType.setColumns(10);

		textFieldProductPrice = new JTextField();
		textFieldProductPrice.setBounds(534, 74, 115, 20);
		panel_1.add(textFieldProductPrice);
		textFieldProductPrice.setColumns(10);

		JSpinner spinnerQuantity = new JSpinner();
		spinnerQuantity.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerQuantity.setBounds(534, 167, 68, 20);
		panel_1.add(spinnerQuantity);

		JComboBox comboBoxMeasurement;
		String unitOfMeasurement[] = { "--SELECT--", "Pcs", "Kg", "g", "Metre", "Inch" };
		comboBoxMeasurement = new JComboBox(unitOfMeasurement);

		comboBoxMeasurement.setBounds(534, 119, 115, 20);
		panel_1.add(comboBoxMeasurement);

		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = new File("database/product.dat");

				String pName = textFieldProductName.getText().toString();
				String pID = textFieldProductId.getText().toString();
				String pType = textFieldProductType.getText().toString();
				String pPrice = textFieldProductPrice.getText().toString();
				String pUnit = comboBoxMeasurement.getSelectedItem().toString();
				int pQuantity = spinnerQuantity.getComponentCount();

				if (pName != null && pID != null && pPrice != null && pUnit != null && pQuantity != 0
						&&!"".equals(pName.trim()) && !"".equals(pID.trim())
						&& !"".equals(pPrice.trim()) && !"".equals(pUnit.trim())) {
					if (f.exists()) {
						String dataToWrite = pName + "|" + pID + "|" + pType + "|" + pPrice + "|" + pUnit + "|"
								+ pQuantity + "\n";

						try {
							FileWriter fw = new FileWriter(f, true);
							BufferedWriter bw = new BufferedWriter(fw);

							bw.write(dataToWrite);
							bw.flush();
							bw.close();
							int yesNo = JOptionPane.showConfirmDialog(contentPane,
									"Product Data saved successfully.\n Do you want to add more????",
									"Product Confirmation!!!", JOptionPane.INFORMATION_MESSAGE);
							if (yesNo == JOptionPane.YES_OPTION) {
								textFieldProductName.setText("");
								textFieldProductId.setText("");
								textFieldProductType.setText("");
								textFieldProductPrice.setText("");
							} else if (yesNo == JOptionPane.CANCEL_OPTION) {
								ProductEntryPage frame = new ProductEntryPage();
								frame.setVisible(true);
								dispose();

							} else if (yesNo == JOptionPane.NO_OPTION) {
								ProductEntryPage frame = new ProductEntryPage();
								frame.setVisible(true);
								dispose();

							}
						} catch (IOException e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(contentPane, "Unable to save product data.", "Save Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(contentPane, "Unable to save product data.", "Save Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(contentPane, "Unable to save product data.", "Save Error",
								JOptionPane.ERROR_MESSAGE);
					} 
				}
				else{
					JOptionPane.showMessageDialog(null, "Please, enter your credentials.","No Input",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnNewButton.setBounds(308, 232, 89, 52);
		panel_1.add(btnNewButton);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("SEARCH", null, panel_3, null);
		panel_3.setLayout(null);

		textFieldpSearch = new JTextField();

		headers = new Vector<String>();
		headers.add("Name ");
		headers.add("Product ID");
		headers.add("Product type");
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
					for (int i = 0; i < fields.length; i++) {
						row.add(fields[i]);
					}

					data.add(row);
				}
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		textFieldpSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String pSearch = textFieldpSearch.getText();
				if (pSearch != null) {
					searchTable(pSearch);
				}
			}

			private void searchTable(String pSearch) {

				final TableRowSorter<TableModel> sorter = new TableRowSorter<>(tablepSearch.getModel());
				tablepSearch.setRowSorter(sorter);
				if (pSearch.length() != 0) {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + pSearch));
				} else {
					sorter.setRowFilter(null);
				}

			}
		});

		textFieldpSearch.setBounds(289, 51, 149, 20);
		panel_3.add(textFieldpSearch);
		textFieldpSearch.setColumns(10);

		JLabel lblSearchBy = new JLabel("Search :");
		lblSearchBy.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSearchBy.setBounds(179, 47, 100, 25);
		panel_3.add(lblSearchBy);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 107, 690, 271);
		panel_3.add(scrollPane);
		
		tablepSearch = new JTable(data,headers);
		scrollPane.setViewportView(tablepSearch);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("UPDATE", null, panel_2, null);
		panel_2.setLayout(null);

		textFieldUpdateProduct = new JTextField();
		textFieldUpdateProduct.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String pRemove = textFieldUpdateProduct.getText();
				if (pRemove != null) {
					searchTable(pRemove);
				}
			}

			private void searchTable(String pRemove) {
				final TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableUpdateProduct.getModel());
				tableUpdateProduct.setRowSorter(sorter);
				if (pRemove.length() != 0) {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + pRemove));
				} else {
					sorter.setRowFilter(null);
				}
			}
		});
		textFieldUpdateProduct.setBounds(323, 62, 193, 20);
		panel_2.add(textFieldUpdateProduct);
		textFieldUpdateProduct.setColumns(10);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel updateTable = (DefaultTableModel) tableUpdateProduct.getModel();

				String file = "database/product.dat";
				File f = new File(file);

				if (f.exists()) {
					try {
						BufferedWriter b = new BufferedWriter(new FileWriter(file));
						int row = updateTable.getRowCount();
						int col = updateTable.getColumnCount();

						for (int i = 0; i < row; i++) {
							for (int j = 0; j < col; j++) {
								b.write(updateTable.getValueAt(i, j) + "|");
							}
							b.newLine();
						}
						JOptionPane.showMessageDialog(null, "Product details have been updated successfully");
						b.flush();
						b.close();
					} catch (Exception ee) {
						ee.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Unable to update product data.", "Save Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnUpdate.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnUpdate.setBounds(306, 374, 104, 55);
		panel_2.add(btnUpdate);

		JLabel lblNewLabel = new JLabel("Search :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(172, 59, 97, 20);
		panel_2.add(lblNewLabel);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 112, 690, 248);
		panel_2.add(scrollPane_2);

		tableUpdateProduct = new JTable(data, headers);
		scrollPane_2.setViewportView(tableUpdateProduct);

		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("REMOVE", null, panel_4, null);
		panel_4.setLayout(null);

		JLabel lblProductId_2 = new JLabel("Search :");
		lblProductId_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblProductId_2.setBounds(157, 53, 110, 26);
		panel_4.add(lblProductId_2);

		textFieldRemoveProduct = new JTextField();
		textFieldRemoveProduct.setBounds(358, 58, 166, 20);
		panel_4.add(textFieldRemoveProduct);
		textFieldRemoveProduct.setColumns(10);

		headers = new Vector<String>();
		headers.add("Name ");
		headers.add("Product ID");
		headers.add("Product type");
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
					for (int i = 0; i < fields.length; i++) {
						row.add(fields[i]);
					}

					data.add(row);
				}
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		JTextField textFieldRemoveProduct = new JTextField();
		textFieldRemoveProduct.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String pRemove = textFieldRemoveProduct.getText();
				if (pRemove != null) {
					searchTable(pRemove);
				}
			}

			private void searchTable(String pRemove) {
				final TableRowSorter<TableModel> sorter = new TableRowSorter<>(tablepRemove.getModel());
				tablepRemove.setRowSorter(sorter);
				if (pRemove.length() != 0) {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + pRemove));
				} else {
					sorter.setRowFilter(null);
				}
			}
		});

		JButton btnRemove = new JButton("REMOVE");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int rowindex = tablepRemove.getSelectedRow();

				data.remove(rowindex);

				System.out.println(data.size());

				productDeleteFromFile(data);
				File f1 = new File("database/retailer.txt");

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

						e1.printStackTrace();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}

				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(10, 103, 690, 261);
				panel_4.add(scrollPane_1);

				tablepRemove = new JTable(data, headers);
				scrollPane_1.setViewportView(tablepRemove);
				
				ProductPage frame = new ProductPage();
				frame.setVisible(true);
				frame.tabbedPane.setSelectedIndex(3);
				dispose();

			}
		});
		btnRemove.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnRemove.setBounds(418, 373, 124, 56);
		panel_4.add(btnRemove);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 103, 690, 261);
		panel_4.add(scrollPane_1);

		tablepRemove = new JTable(data, headers);
		scrollPane_1.setViewportView(tablepRemove);
		
		JButton btnRefresh = new JButton("REFRESH");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProductPage frame = new ProductPage();
				frame.setVisible(true);
				frame.tabbedPane.setSelectedIndex(3);
				dispose();
			}
		});
		btnRefresh.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnRefresh.setBounds(143, 374, 124, 55);
		panel_4.add(btnRefresh);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				HomePage frame = new HomePage();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnNewButton_1.setBounds(621, 11, 89, 44);
		contentPane.add(btnNewButton_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 394, 31);
		contentPane.add(menuBar);
		
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
		
		JMenuItem mntmLogOut = new JMenuItem("Log out");
		mntmLogOut.setIcon(new ImageIcon("icons//logout-icon1.png"));
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Are you sure you want to log out?");
				dispose();
				LoginPage window = new LoginPage();
				window.frmLoginForGalaxy.setVisible(true);
			}
		});
		menuBar.add(mntmLogOut);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("icons//blue.png"));
		label.setBounds(0, 0, 735, 524);
		contentPane.add(label);
	}

	protected void productDeleteFromFile(Vector<Vector<String>> data2) {
		try {
			File f = new File("database/product.dat");

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
			e.printStackTrace();
		}

	}
}
