package com.globsyn.wholesalebusiness;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class BillPage extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTable tableOrder;
	private static Vector<String> headers;
	private static Vector<Vector<String>> data;
	private JLabel lblShowPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillPage frame = new BillPage();
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

	public BillPage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("icons//diamond-icon.png"));
		setTitle("Wholesale Business Application Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnPrint = new JButton("Print");
		btnPrint.setIcon(new ImageIcon("icons//print-icon.png"));
		btnPrint.setFont(new Font("Hobo Std", Font.PLAIN, 14));
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = new File("database/order.dat");
				f.delete();
				try {
					f.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Thank you for ordering from us \n Your bill is being printed..");
				HomePage frame = new HomePage();
				frame.setVisible(true);
				dispose();
			}
		});
		btnPrint.setBounds(735, 563, 96, 43);
		contentPane.add(btnPrint);

		JLabel lblInvoiceCum = new JLabel("INVOICE CUM CHALLAN VIDE RUE 5 U/S 31 OF CGST ACT,2017");
		lblInvoiceCum.setBounds(257, 48, 315, 23);
		contentPane.add(lblInvoiceCum);

		JLabel lblThePrecisionProcessing = new JLabel("The Precision Processing Equipment Co.");
		lblThePrecisionProcessing.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblThePrecisionProcessing.setBounds(314, 65, 234, 14);
		contentPane.add(lblThePrecisionProcessing);

		JLabel lblShedNozhowrahIndustrial = new JLabel("Shed No.Z59,Howrah Industrial Estate");
		lblShedNozhowrahIndustrial.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblShedNozhowrahIndustrial.setBounds(314, 82, 193, 14);
		contentPane.add(lblShedNozhowrahIndustrial);

		JLabel lblBalitikurihowrah = new JLabel("Balitikuri,Howrah-711113");
		lblBalitikurihowrah.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblBalitikurihowrah.setBounds(335, 96, 134, 14);
		contentPane.add(lblBalitikurihowrah);

		JLabel lblOfficechandneyChowkStreetrd = new JLabel("Office:-14,Chandney Chowk Street,3rd floor,Kolkata-700001");
		lblOfficechandneyChowkStreetrd.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblOfficechandneyChowkStreetrd.setBounds(268, 111, 315, 14);
		contentPane.add(lblOfficechandneyChowkStreetrd);

		JLabel lblPhoneNoEmail = new JLabel("Phone no.:-033_2212_6001,7208    Email No.:-galaxy.kolkata@gmail.com");
		lblPhoneNoEmail.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPhoneNoEmail.setBounds(246, 127, 361, 14);
		contentPane.add(lblPhoneNoEmail);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Our Details", TitledBorder.CENTER,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(22, 152, 182, 136);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblPanNoaabftpStatewest = new JLabel("PAN NO:-AABFT7261P\r\n\r\n");
		lblPanNoaabftpStatewest.setBounds(6, 22, 170, 14);
		panel.add(lblPanNoaabftpStatewest);

		JLabel lblStatewestBengal = new JLabel("State:-West Bengal");
		lblStatewestBengal.setBounds(6, 47, 170, 14);
		panel.add(lblStatewestBengal);

		JLabel lblStateCode = new JLabel("State Code:-19");
		lblStateCode.setBounds(6, 67, 166, 14);
		panel.add(lblStateCode);

		JLabel lblInvoiceNo = new JLabel("Invoice No.:-");
		lblInvoiceNo.setBounds(6, 86, 96, 14);
		panel.add(lblInvoiceNo);

		JLabel lblInvoiceDate = new JLabel("Invoice Date:-");
		lblInvoiceDate.setBounds(6, 111, 78, 14);
		panel.add(lblInvoiceDate);

		textField_6 = new JTextField();
		textField_6.setBounds(90, 83, 86, 20);
		panel.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setBounds(90, 108, 86, 20);
		panel.add(textField_7);
		textField_7.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Details of Receiver(Billed to)",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(223, 152, 284, 136);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(6, 19, 81, 14);
		panel_1.add(lblName);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(6, 44, 81, 14);
		panel_1.add(lblAddress);

		JLabel lblState = new JLabel("State:");
		lblState.setBounds(6, 86, 81, 14);
		panel_1.add(lblState);

		JLabel lblGstnNo = new JLabel("State Code:\r\n");
		lblGstnNo.setBounds(6, 111, 81, 14);
		panel_1.add(lblGstnNo);

		textField = new JTextField();
		textField.setBounds(87, 16, 175, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		JTextPane textPane = new JTextPane();
		textPane.setBounds(87, 44, 175, 35);
		panel_1.add(textPane);

		textField_1 = new JTextField();
		textField_1.setBounds(87, 83, 175, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(87, 108, 175, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Details of Receiver/Consignee(Bill to/Shipped to)", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_2.setBounds(513, 152, 284, 136);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setBounds(6, 19, 77, 14);
		panel_2.add(lblName_1);

		JLabel lblAddress_1 = new JLabel("Address:");
		lblAddress_1.setBounds(6, 44, 77, 14);
		panel_2.add(lblAddress_1);

		JLabel lblState_1 = new JLabel("State:");
		lblState_1.setBounds(6, 86, 77, 14);
		panel_2.add(lblState_1);

		JLabel lblStateCode_1 = new JLabel("State Code:");
		lblStateCode_1.setBounds(6, 111, 77, 14);
		panel_2.add(lblStateCode_1);

		textField_3 = new JTextField();
		textField_3.setBounds(93, 16, 181, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(93, 44, 181, 34);
		panel_2.add(textPane_1);

		textField_4 = new JTextField();
		textField_4.setBounds(93, 83, 181, 20);
		panel_2.add(textField_4);
		textField_4.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(93, 108, 181, 20);
		panel_2.add(textField_5);
		textField_5.setColumns(10);

		headers = new Vector<String>();
		headers.add("Product Name ");
		headers.add("Product ID");
		headers.add("Quantity");
		headers.add("Price");
		headers.add("Total price");
		headers.add("Discount");
		headers.add("Tax");
		headers.add("Amount");

		data = new Vector<Vector<String>>();

		try {
			File f = new File("database/order.dat");

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

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 299, 597, 230);
		contentPane.add(scrollPane);

		tableOrder = new JTable(data, headers);
		scrollPane.setViewportView(tableOrder);

		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(22, 295, 6, -7);
		contentPane.add(textPane_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Payment option :",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(657, 360, 134, 124);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Cash ");
		rdbtnNewRadioButton.setBounds(7, 24, 109, 23);
		panel_3.add(rdbtnNewRadioButton);

		JRadioButton rdbtnDebitCard = new JRadioButton("Debit Card");
		rdbtnDebitCard.setBounds(7, 50, 109, 23);
		panel_3.add(rdbtnDebitCard);

		JRadioButton rdbtnCreditCard = new JRadioButton("Credit Card");
		rdbtnCreditCard.setBounds(7, 76, 109, 23);
		panel_3.add(rdbtnCreditCard);

		JLabel lblNewLabel_1 = new JLabel("Galaxy Electronics Wholesaler Services");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel_1.setBounds(223, 14, 382, 23);
		contentPane.add(lblNewLabel_1);

		JLabel lblRupees = new JLabel("Total payable amount in      Rupees");
		lblRupees.setBounds(203, 540, 228, 26);
		contentPane.add(lblRupees);

		lblShowPrice = new JLabel("-----");
		lblShowPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShowPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowPrice.setBounds(441, 539, 166, 29);
		contentPane.add(lblShowPrice);
	}

	public void setTotal(String total) {
		this.lblShowPrice.setText(total);

	}
}
