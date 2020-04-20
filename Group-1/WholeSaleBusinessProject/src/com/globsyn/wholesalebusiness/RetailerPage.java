package com.globsyn.wholesalebusiness;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class RetailerPage extends JFrame {

	private JPanel contentPane;
	private String stateList[] = { "---SELECT---", "HIMACHAL PRADESH", "DELHI", "PUNJAB", "JHARKHAND", "BIHAR",
			"WEST BENGAL", "UTTARAKHAND", "UTTAR PRADESH", "MADHYA PRADESH", "GUJRAT", "KARNATAKA", "KERALA",
			"TAMIL NADU", "TELENGANA" };
	private String countryName[] = { "---SELECT---", "NEPAL", "CHINA", "BANGLADESH", "INDIA", "MYANMAR", "SRI LANKA" };
	private static Vector<String> headers;
	private static Vector<Vector<String>> data;
	private JTable tableSearch;
	private JTable tableRemove;
	private JTable tableUpdateRetailer;
	private JTabbedPane tabbedPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RetailerPage frame = new RetailerPage();
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
	public RetailerPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("icons//diamond-icon.png"));
		setTitle("Wholesale Business Application Manager");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 740, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 42, 701, 463);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		panel.setBackground(null);
		panel.setToolTipText("\r\n");
		tabbedPane.addTab("ADD", null, panel, null);
		panel.setLayout(null);

		JLabel lblEnterTheRetailer = new JLabel("Enter the Retailer details below ..");
		lblEnterTheRetailer.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterTheRetailer.setBounds(32, 11, 325, 20);
		panel.add(lblEnterTheRetailer);

		JLabel lblpersonalDetails = new JLabel("1.Personal Details");
		lblpersonalDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblpersonalDetails.setBounds(32, 55, 144, 14);
		panel.add(lblpersonalDetails);

		JLabel lblPhoneNo = new JLabel("Phone number :");
		lblPhoneNo.setBounds(368, 79, 103, 18);
		panel.add(lblPhoneNo);

		JLabel lblCompanyName = new JLabel("Company name :");
		lblCompanyName.setBounds(32, 176, 109, 20);
		panel.add(lblCompanyName);

		JLabel lblEmailId = new JLabel("Email id :");
		lblEmailId.setBounds(368, 104, 103, 14);
		panel.add(lblEmailId);

		JTextField textFieldRetailerName = new JTextField();
		textFieldRetailerName.setBounds(151, 77, 166, 20);
		panel.add(textFieldRetailerName);
		textFieldRetailerName.setColumns(10);

		JTextField textFieldPhone = new JTextField();
		textFieldPhone.setBounds(493, 77, 166, 20);
		panel.add(textFieldPhone);
		textFieldPhone.setColumns(10);

		JTextField textFieldEmail = new JTextField();
		textFieldEmail.setBounds(493, 101, 166, 20);
		panel.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JTextField textFieldCompanyName = new JTextField();
		textFieldCompanyName.setBounds(151, 176, 166, 20);
		panel.add(textFieldCompanyName);
		textFieldCompanyName.setColumns(10);

		JLabel lblAdress = new JLabel("Address :\r\n");
		lblAdress.setBounds(368, 129, 103, 19);
		panel.add(lblAdress);

		JTextField textFieldAddress = new JTextField();
		textFieldAddress.setBounds(493, 132, 166, 53);
		panel.add(textFieldAddress);
		textFieldAddress.setColumns(10);

		JLabel lblPanNumber = new JLabel("PAN number :");
		lblPanNumber.setBounds(32, 117, 86, 20);
		panel.add(lblPanNumber);

		JLabel lblCitytown = new JLabel("City/Town :");
		lblCitytown.setBounds(368, 196, 103, 17);
		panel.add(lblCitytown);

		JLabel lblPinCode = new JLabel("Pin code:");
		lblPinCode.setBounds(368, 224, 103, 14);
		panel.add(lblPinCode);

		JTextField textFieldPinCode = new JTextField();
		textFieldPinCode.setBounds(493, 221, 166, 20);
		panel.add(textFieldPinCode);
		textFieldPinCode.setColumns(10);

		JLabel lblProvincestate = new JLabel("Province/State :");
		lblProvincestate.setBounds(369, 249, 102, 21);
		panel.add(lblProvincestate);

		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setBounds(368, 277, 92, 23);
		panel.add(lblCountry);

		JLabel lblCompanyId = new JLabel("Company ID :");
		lblCompanyId.setBounds(32, 207, 109, 17);
		panel.add(lblCompanyId);

		JTextField textFieldCompanyID = new JTextField();
		textFieldCompanyID.setBounds(151, 207, 166, 20);
		panel.add(textFieldCompanyID);
		textFieldCompanyID.setColumns(10);

		JLabel lblcontactDetails = new JLabel("2.Contact Details");
		lblcontactDetails.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblcontactDetails.setBounds(368, 55, 138, 14);
		panel.add(lblcontactDetails);

		JRadioButton rdbtnIndividual = new JRadioButton("Individual");
		rdbtnIndividual.setBounds(151, 147, 91, 23);
		panel.add(rdbtnIndividual);

		JRadioButton rdbtnCompany = new JRadioButton("Company");
		rdbtnCompany.setBounds(242, 147, 87, 23);
		panel.add(rdbtnCompany);

		JComboBox comboBoxState = new JComboBox(stateList);
		comboBoxState.setBounds(495, 249, 164, 20);
		panel.add(comboBoxState);

		JComboBox comboBoxCountry = new JComboBox(countryName);
		comboBoxCountry.setBounds(493, 278, 166, 20);
		panel.add(comboBoxCountry);

		JTextField textFieldCity = new JTextField();
		textFieldCity.setBounds(493, 196, 166, 20);
		panel.add(textFieldCity);
		textFieldCity.setColumns(10);

		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(32, 80, 86, 20);
		panel.add(lblName);

		JTextField textFieldPanNumber = new JTextField();
		textFieldPanNumber.setBounds(151, 114, 166, 20);
		panel.add(textFieldPanNumber);
		textFieldPanNumber.setColumns(10);

		JLabel lblCompanyType = new JLabel("Company type :");
		lblCompanyType.setBounds(32, 148, 102, 20);
		panel.add(lblCompanyType);

		JButton btnSave = new JButton("Save and Generate Retailer ID");
		btnSave.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File f = new File("database/retailer.dat");

				String rName = textFieldRetailerName.getText().toString();
				String rPAN = textFieldPanNumber.getText().toString();
				String rType = null;
				if (rdbtnIndividual.isSelected()) {
					rType = "Individual";
				} else if (rdbtnCompany.isSelected()) {
					rType = "Company";
				}
				String rCompanyName = textFieldCompanyName.getText().toString();
				String rCompanyID = textFieldCompanyID.getText().toString();

				String rPhone = textFieldPhone.getText().toString();
				String rEmail = textFieldEmail.getText().toString();
				String rAddress = textFieldAddress.getText().toString();
				String rCity = textFieldCity.getText().toString();
				String rPin = textFieldPinCode.getText().toString();
				String rState = comboBoxState.getSelectedItem().toString();
				String rCountry = comboBoxCountry.getSelectedItem().toString();
				String name[] = rName.split("[ ]");
				String rRetailerID = name[0];

				if (rName != null && rEmail != null && rPhone != null && rPAN != null && rAddress != null
						&& rCity != null && rPin != null && !"".equals(rName.trim()) && !"".equals(rEmail.trim())
						&& !"".equals(rPhone.trim()) && !"".equals(rPAN.trim()) && !"".equals(rAddress.trim())
						&& !"".equals(rCity.trim()) && !"".equals(rPin.trim()) && !(rState.equals("---SELECT---"))
						&& !(rCountry.equals("---SELECT---"))) {
					if (f.exists()) {
						String dataToWrite = rRetailerID + "|" + rName + "|" + rPAN + "|" + rType + "|" + rCompanyName
								+ "|" + rCompanyID + "|" + rPhone + "|" + rEmail + "|" + rAddress + "|" + rCity + "|"
								+ rPin + "|" + rState + "|" + rCountry + "\n";

						try {
							FileWriter fw = new FileWriter(f, true);
							BufferedWriter bw = new BufferedWriter(fw);

							bw.write(dataToWrite);
							bw.flush();
							bw.close();
							int yesNo = JOptionPane.showConfirmDialog(contentPane, "Do you want to add more to it??",
									"Retailer Confirmation!!!", JOptionPane.INFORMATION_MESSAGE);

							if (yesNo == JOptionPane.YES_OPTION) {
								textFieldRetailerName.setText("");
								textFieldPhone.setText("");
								textFieldEmail.setText("");
								textFieldCompanyName.setText("");
								textFieldAddress.setText("");
								textFieldPinCode.setText("");
								textFieldPanNumber.setText("");
								textFieldCompanyID.setText("");
								textFieldCity.setText("");

							} else if (yesNo == JOptionPane.CANCEL_OPTION) {
								HomePage home = new HomePage();
								home.setVisible(true);
								dispose();

							} else if (yesNo == JOptionPane.NO_OPTION) {
								HomePage home = new HomePage();
								home.setVisible(true);
								dispose();
								JOptionPane.showMessageDialog(contentPane,
										"Your details have been saved and your retailer ID is :" + rRetailerID);
							}
						} catch (IOException e) {
							e.printStackTrace();
							JOptionPane.showMessageDialog(contentPane, "Unable to save retailer data.", "Save Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(contentPane, "Unable to save retailer data.", "Save Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(contentPane, "Unable to save retailer data.", "Save Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please, enter your credentials.", "No Input",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSave.setBounds(212, 340, 299, 53);
		panel.add(btnSave);

		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("SEARCH", null, panel_3, null);
		panel_3.setLayout(null);

		headers = new Vector<String>();
		headers.add("Retailer ID");
		headers.add("Name ");
		headers.add("PAN No.");
		headers.add("Company type");
		headers.add("Company name");
		headers.add("Company ID");
		headers.add("Phone no");
		headers.add("Email id");
		headers.add("Address");
		headers.add("City/town");
		headers.add("Pin code");
		headers.add("State");
		headers.add("Country");

		data = new Vector<Vector<String>>();

		try {
			File f = new File("database/retailer.dat");

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

		JTextField textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String rSearch = textFieldSearch.getText();
				if (rSearch != null) {
					searchTable(rSearch);
				}
			}

			private void searchTable(String rSearch) {

				final TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableSearch.getModel());
				tableSearch.setRowSorter(sorter);
				if (rSearch.length() != 0) {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + rSearch));
				} else {
					sorter.setRowFilter(null);
				}

			}
		});

		textFieldSearch.setBounds(213, 54, 194, 29);
		panel_3.add(textFieldSearch);
		textFieldSearch.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 111, 676, 313);
		panel_3.add(scrollPane);

		tableSearch = new JTable(data, headers);
		scrollPane.setViewportView(tableSearch);

		JLabel lblSearch = new JLabel("Search :");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSearch.setBounds(86, 54, 84, 29);
		panel_3.add(lblSearch);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("UPDATE", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblRetailerId = new JLabel("Search :");
		lblRetailerId.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRetailerId.setBounds(205, 50, 108, 25);
		panel_1.add(lblRetailerId);

		JTextField textFieldUpdateRetailer = new JTextField();
		textFieldUpdateRetailer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String pSearch = textFieldUpdateRetailer.getText();
				if (pSearch != null) {
					searchTable(pSearch);
				}
			}

			private void searchTable(String pSearch) {
				final TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableUpdateRetailer.getModel());
				tableUpdateRetailer.setRowSorter(sorter);
				if (pSearch.length() != 0) {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + pSearch));
				} else {
					sorter.setRowFilter(null);
				}

			}
		});
		textFieldUpdateRetailer.setBounds(323, 54, 199, 20);
		panel_1.add(textFieldUpdateRetailer);
		textFieldUpdateRetailer.setColumns(10);

		JButton btnNewButton = new JButton("UPDATE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel updateTable = (DefaultTableModel) tableUpdateRetailer.getModel();

				String file = "database/retailer.dat";
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
						JOptionPane.showMessageDialog(null, "Retailer details have been updated successfully");
						b.flush();
						b.close();
					} catch (Exception ee) {
						ee.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Unable to update retailer data.", "Save Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnNewButton.setBounds(302, 379, 99, 45);
		panel_1.add(btnNewButton);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 106, 676, 262);
		panel_1.add(scrollPane_2);

		tableUpdateRetailer = new JTable(data, headers);
		scrollPane_2.setViewportView(tableUpdateRetailer);

		headers = new Vector<String>();
		headers.add("Retailer ID");
		headers.add("Name ");
		headers.add("PAN No.");
		headers.add("Company type");
		headers.add("Company name");
		headers.add("Company ID");
		headers.add("Phone no");
		headers.add("Email id");
		headers.add("Address");
		headers.add("City/town");
		headers.add("Pin code");
		headers.add("State");
		headers.add("Country");

		data = new Vector<Vector<String>>();

		try {
			File f = new File("database/retailer.dat");

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

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("REMOVE", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblRetailerId_1 = new JLabel("Search :");
		lblRetailerId_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRetailerId_1.setBounds(173, 55, 141, 27);
		panel_2.add(lblRetailerId_1);

		JTextField textFieldRemoveRetailer = new JTextField();
		textFieldRemoveRetailer.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String rRemove = textFieldRemoveRetailer.getText();
				if (rRemove != null) {
					searchTable(rRemove);
				}
			}

			private void searchTable(String rRemove) {
				final TableRowSorter<TableModel> sorter = new TableRowSorter<>(tableRemove.getModel());
				tableRemove.setRowSorter(sorter);
				if (rRemove.length() != 0) {
					sorter.setRowFilter(RowFilter.regexFilter("(?i)" + rRemove));
				} else {
					sorter.setRowFilter(null);
				}
			}
		});
		textFieldRemoveRetailer.setBounds(324, 59, 171, 22);
		panel_2.add(textFieldRemoveRetailer);
		textFieldRemoveRetailer.setColumns(10);

		JButton btnRemove = new JButton("REMOVE");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int rowindex = tableRemove.getSelectedRow();

				data.remove(rowindex);

				retailerDeleteFromFile(data);

				File f1 = new File("database/retailer.dat");

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
				scrollPane_1.setBounds(10, 107, 676, 243);
				panel_2.add(scrollPane_1);

				tableRemove = new JTable(data, headers);
				scrollPane_1.setViewportView(tableRemove);

				RetailerPage frame = new RetailerPage();
				frame.setVisible(true);
				frame.tabbedPane.setSelectedIndex(3);
				dispose();

			}
		});

		btnRemove.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnRemove.setBounds(427, 368, 120, 56);
		panel_2.add(btnRemove);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 107, 676, 243);
		panel_2.add(scrollPane_1);

		tableRemove = new JTable(data, headers);
		scrollPane_1.setViewportView(tableRemove);
		
		JButton btnRefresh = new JButton("REFRESH");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RetailerPage frame = new RetailerPage();
				frame.setVisible(true);
				frame.tabbedPane.setSelectedIndex(3);
				dispose();

			}
		});
		btnRefresh.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnRefresh.setBounds(153, 368, 131, 56);
		panel_2.add(btnRefresh);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage frame = new HomePage();
				frame.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnBack.setBounds(594, 11, 89, 46);
		contentPane.add(btnBack);

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

		JMenuItem mntmAddRetailer = new JMenuItem("Add Retailer");
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
		label.setBounds(0, 0, 724, 516);
		contentPane.add(label);
	}

	public void retailerDeleteFromFile(Vector<Vector<String>> data) {
		try {
			File f = new File("database/retailer.dat");

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