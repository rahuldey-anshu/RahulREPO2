package com.globsyn.project;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Suppliers extends JFrame {

	private JPanel contentPane;
	private JTextField supplierNameAdd;
	private JTextField emailSupplierAdd;
	private JTextField contactSupplierAdd;
	private JTextField pincodeSupplierAdd;
	private JTextField gstSupplierAdd;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField searchSupplier;
	private JTable supplierTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Suppliers frame = new Suppliers();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 public void searchTable(String input) {
         final TableRowSorter<TableModel> sorter = new TableRowSorter<>(supplierTable.getModel());
         supplierTable.setRowSorter(sorter);
         if (input.length() != 0) {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + input));

         } else {
                sorter.setRowFilter(null);
         }
         }

	/**
	 * Create the frame.
	 */
	public Suppliers() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 900,715);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 34, 863, 563);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Add suppliers", null, panel, null);
		panel.setLayout(null);
		panel.setBackground(new Color(248, 248, 255));
		
		JLabel label = new JLabel("Supplier name :");
		label.setForeground(new Color(51, 0, 153));
		label.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label.setBounds(56, 32, 150, 20);
		panel.add(label);
		
		supplierNameAdd = new JTextField();
		supplierNameAdd.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		supplierNameAdd.setColumns(10);
		supplierNameAdd.setBounds(208, 29, 310, 30);
		panel.add(supplierNameAdd);
		
		JLabel label_1 = new JLabel("Country :");
		label_1.setForeground(new Color(51, 0, 153));
		label_1.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_1.setBounds(56, 92, 150, 20);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Email :");
		label_2.setForeground(new Color(51, 0, 153));
		label_2.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_2.setBounds(56, 143, 150, 20);
		panel.add(label_2);
		
		emailSupplierAdd = new JTextField();
		emailSupplierAdd.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		emailSupplierAdd.setColumns(10);
		emailSupplierAdd.setBounds(208, 140, 412, 30);
		panel.add(emailSupplierAdd);
		
		JLabel label_3 = new JLabel("Address :");
		label_3.setForeground(new Color(51, 0, 153));
		label_3.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_3.setBounds(56, 204, 150, 20);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Contact no. (+91) :");
		label_4.setForeground(new Color(51, 0, 153));
		label_4.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_4.setBounds(411, 293, 150, 20);
		panel.add(label_4);
		
		contactSupplierAdd = new JTextField();
		contactSupplierAdd.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		contactSupplierAdd.setColumns(10);
		contactSupplierAdd.setBounds(585, 293, 181, 30);
		panel.add(contactSupplierAdd);
		
		JComboBox stateAddSupplier = new JComboBox();
		stateAddSupplier.setBackground(Color.WHITE);
		stateAddSupplier.setMaximumRowCount(15);
		stateAddSupplier.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		stateAddSupplier.setBounds(208, 89, 181, 25);
		panel.add(stateAddSupplier);
		
		pincodeSupplierAdd = new JTextField();
		pincodeSupplierAdd.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		pincodeSupplierAdd.setColumns(10);
		pincodeSupplierAdd.setBounds(208, 293, 181, 30);
		panel.add(pincodeSupplierAdd);
		
		gstSupplierAdd = new JTextField();
		gstSupplierAdd.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		gstSupplierAdd.setColumns(10);
		gstSupplierAdd.setBounds(208, 346, 181, 30);
		panel.add(gstSupplierAdd);
		
		JComboBox citySupplierAdd = new JComboBox();
		citySupplierAdd.setModel(new DefaultComboBoxModel(new String[] {"", "Agra", "Ahmedabad", "Bangalore", "Bhopal", "Chennai", "Hyderabad", "Kolkata", "Mumbai", "New Delhi", "Pune", "Surat"}));
		citySupplierAdd.setBackground(Color.WHITE);
		citySupplierAdd.setMaximumRowCount(15);
		citySupplierAdd.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		citySupplierAdd.setBounds(585, 87, 181, 25);
		panel.add(citySupplierAdd);
		
		JTextArea addressSupplierAdd = new JTextArea();
		addressSupplierAdd.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		addressSupplierAdd.setBounds(208, 194, 412, 66);
		panel.add(addressSupplierAdd);
		
		JButton addSupplier = new JButton("Add supplier");			
		addSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name, country, city, email, address;
				name= supplierNameAdd.getText();
				long contact, gst, pincode;
		 		country= (String) stateAddSupplier.getSelectedItem();
		 		city= (String) citySupplierAdd.getSelectedItem();
		 		email= emailSupplierAdd.getText();
		 		address = addressSupplierAdd.getText();
			 			if(name!=null && address!=null && email!=null &&  !"".equals(name.trim()) && !"".equals(address.trim()) && !"".equals(email.trim())){
			     try{
			    	 
			 		
			 		String pin=pincodeSupplierAdd.getText();
			 		pincode=Long.parseLong(pin);
			 		String con= contactSupplierAdd.getText();
			 		contact= Long.parseLong(con);
			 		String gST=gstSupplierAdd.getText();
			 		gst=Long.parseLong(gST);
			 		
			 		
			 		String line=null;
			 		   File file = new File("assets/data/supplierInfo.dat");
		                   if (!file.exists()) {
		                   file.createNewFile();
		               }

		               FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		               BufferedWriter bw = new BufferedWriter(fw);
		               bw.write(name + "|" + country + "|" + city + "|" + email + "|" + address + "|" + pincode + "|" + contact + "|" + gst );
			              bw.newLine();
		              

		              bw.flush();
		               
		               fw.flush();
		               JOptionPane.showMessageDialog(null, "Supplier added successfully.");
		               supplierNameAdd.setText("");
		               emailSupplierAdd.setText("");
		               gstSupplierAdd.setText("");
		               pincodeSupplierAdd.setText("");
		               addressSupplierAdd.setText("");
		               citySupplierAdd.setSelectedItem("");
		               stateAddSupplier.setSelectedItem("");
		               contactSupplierAdd.setText("");
			 		
		              
		          
		               }catch(Exception ex){
		            	   ex.printStackTrace();
		            	   //JOptionPane.showMessageDialog(null, "Please give valid input.");
		            	   ex.printStackTrace();
		               }
			 		}  
			 			else
			 			{
			 				 JOptionPane.showMessageDialog(null, "Please fill all the fields.");
			 			}
			}
		});
		
		
		addSupplier.setForeground(Color.WHITE);
		addSupplier.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		addSupplier.setBackground(new Color(102, 153, 255));
		addSupplier.setBounds(356, 448, 193, 38);
		panel.add(addSupplier);
		
		JLabel label_5 = new JLabel("Pin code :");
		label_5.setForeground(new Color(51, 0, 153));
		label_5.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_5.setBounds(56, 296, 106, 20);
		panel.add(label_5);
		
		
		JLabel label_6 = new JLabel("City :");
		label_6.setForeground(new Color(51, 0, 153));
		label_6.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_6.setBounds(527, 92, 65, 20);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("GST no. :");
		label_7.setForeground(new Color(51, 0, 153));
		label_7.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_7.setBounds(56, 351, 150, 20);
		panel.add(label_7);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(248, 248, 255));
		tabbedPane.addTab("Update suppliers", null, panel_1, null);
		
		JLabel label_8 = new JLabel("Supplier name :");
		label_8.setForeground(new Color(51, 0, 153));
		label_8.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_8.setBounds(54, 22, 150, 20);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("Email :");
		label_9.setForeground(new Color(51, 0, 153));
		label_9.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_9.setBounds(54, 141, 150, 20);
		panel_1.add(label_9);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		textField_7.setColumns(10);
		textField_7.setBounds(228, 141, 379, 32);
		panel_1.add(textField_7);
		
		JLabel label_10 = new JLabel("Address :");
		label_10.setForeground(new Color(51, 0, 153));
		label_10.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_10.setBounds(54, 202, 150, 20);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("Pin code :");
		label_11.setForeground(new Color(51, 0, 153));
		label_11.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_11.setBounds(54, 317, 106, 20);
		panel_1.add(label_11);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		textField_8.setColumns(10);
		textField_8.setBounds(228, 314, 181, 35);
		panel_1.add(textField_8);
		
		JLabel label_12 = new JLabel("Contact no. (+91) :");
		label_12.setForeground(new Color(51, 0, 153));
		label_12.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_12.setBounds(54, 384, 150, 20);
		panel_1.add(label_12);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		textField_9.setColumns(10);
		textField_9.setBounds(228, 379, 181, 32);
		panel_1.add(textField_9);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(228, 22, 275, 32);
		panel_1.add(comboBox_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(228, 200, 379, 78);
		panel_1.add(textField_10);
		
		JButton button_1 = new JButton("Update supplier");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button_1.setBackground(new Color(102, 153, 255));
		button_1.setBounds(228, 472, 198, 38);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("Remove supplier");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button_2.setBackground(new Color(102, 153, 255));
		button_2.setBounds(475, 472, 198, 38);
		panel_1.add(button_2);
		
		JLabel label_13 = new JLabel("GST no. :");
		label_13.setForeground(new Color(51, 0, 153));
		label_13.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_13.setBounds(463, 319, 150, 20);
		panel_1.add(label_13);
		
		textField_11 = new JTextField();
		textField_11.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		textField_11.setColumns(10);
		textField_11.setBounds(608, 317, 181, 32);
		panel_1.add(textField_11);
		
		JLabel label_14 = new JLabel("Country :");
		label_14.setForeground(new Color(51, 0, 153));
		label_14.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_14.setBounds(54, 85, 150, 20);
		panel_1.add(label_14);
		
		JLabel label_15 = new JLabel("City :");
		label_15.setForeground(new Color(51, 0, 153));
		label_15.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_15.setBounds(463, 90, 150, 20);
		panel_1.add(label_15);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(567, 85, 181, 25);
		panel_1.add(comboBox_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(228, 85, 181, 25);
		panel_1.add(comboBox);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(248, 248, 255));
		tabbedPane.addTab("View suppliers", null, panel_2, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 115, 827, 397);
		panel_2.add(scrollPane);
		
		supplierTable = new JTable();
		supplierTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "State", "City", "Email", "Address", "Pincode", "Contact","GST number"
			}
					));
		supplierTable.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		scrollPane.setViewportView(supplierTable);
		
		searchSupplier = new JTextField();
		scrollPane.setViewportView(supplierTable);
		searchSupplier.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String input= searchSupplier.getText().toLowerCase();
			      searchTable(input);
			}
		});
		searchSupplier.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		searchSupplier.setColumns(10);
		searchSupplier.setBounds(346, 30, 274, 32);
		panel_2.add(searchSupplier);
		
		JLabel lblSearchHere = new JLabel("Search here :");
		lblSearchHere.setForeground(new Color(51, 0, 153));
		lblSearchHere.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		lblSearchHere.setBounds(211, 39, 150, 20);
		panel_2.add(lblSearchHere);
		
		JButton button_3 = new JButton("Back");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage home= new HomePage();
				home.setVisible(true);
				dispose();
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button_3.setBackground(new Color(102, 153, 255));
		button_3.setBounds(740, 624, 133, 38);
		contentPane.add(button_3);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  DefaultTableModel dtm = (DefaultTableModel) supplierTable.getModel();
				  while(dtm.getRowCount()>0)
				  {
					  for(int i=0; i<dtm.getRowCount(); i++)
					  {
						  dtm.removeRow(i);
					  }
				  }
			        String file="assets/data/supplierInfo.dat";
			        try {
			            BufferedReader br = new BufferedReader(new FileReader(file));
                        String line=null;
			            while ((line = br.readLine()) != null) {
			                Vector data = new Vector();
			                StringTokenizer st1 = new StringTokenizer(line, "|");
			                while (st1.hasMoreTokens()) {
			                    String nextToken = st1.nextToken();
			                    data.add(nextToken);
			                    System.out.println(nextToken);

			                }
			                System.out.println(data);
			                dtm.addRow(data);
			            }

			            br.close();

			        } catch (Exception ex) {
			            ex.printStackTrace();
			        }
			}
		});
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		btnRefresh.setBackground(new Color(102, 153, 255));
		btnRefresh.setBounds(566, 624, 133, 38);
		contentPane.add(btnRefresh);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("assets/images/wallpaper1.jpg"));
		lblNewLabel.setBounds(0, 0, 894, 685);
		contentPane.add(lblNewLabel); String line = null;
      
		
		
	}
}
