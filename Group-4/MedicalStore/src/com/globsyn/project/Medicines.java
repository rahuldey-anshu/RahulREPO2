package com.globsyn.project;

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
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import com.toedter.calendar.JDateChooser;
import javax.swing.DefaultComboBoxModel;

public class Medicines extends JFrame {

	private JPanel contentPane;
	private JTextField medPriceAdd;
	private JTextField medQtyAdd;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField medNameAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medicines frame = new Medicines();
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
	public Medicines() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 889, 712);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 57, 859, 524);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Add medicines", null, panel, null);
		panel.setLayout(null);
		panel.setBackground(new Color(248, 248, 255));
		
		JLabel label = new JLabel("Product name :");
		label.setForeground(new Color(51, 0, 153));
		label.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label.setBounds(66, 76, 123, 29);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Supplier name :");
		label_1.setForeground(new Color(51, 0, 153));
		label_1.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_1.setBounds(66, 140, 135, 29);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Quantity :");
		label_2.setForeground(new Color(51, 0, 153));
		label_2.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_2.setBounds(66, 202, 111, 29);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Price (Rs.)  :");
		label_3.setForeground(new Color(51, 0, 153));
		label_3.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_3.setBounds(66, 263, 135, 29);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Mfg date :");
		label_4.setForeground(new Color(51, 0, 153));
		label_4.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_4.setBounds(517, 76, 111, 29);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Exp date :");
		label_5.setForeground(new Color(51, 0, 153));
		label_5.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_5.setBounds(517, 140, 111, 29);
		panel.add(label_5);
		
		medPriceAdd = new JTextField();
		medPriceAdd.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		medPriceAdd.setColumns(10);
		medPriceAdd.setBounds(211, 263, 135, 30);
		panel.add(medPriceAdd);
		
		medQtyAdd = new JTextField();
		medQtyAdd.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		medQtyAdd.setColumns(10);
		medQtyAdd.setBounds(211, 202, 135, 30);
		panel.add(medQtyAdd);
		
		JComboBox suppNameAdd = new JComboBox();
		suppNameAdd.setModel(new DefaultComboBoxModel(new String[] {"", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu & Kashmir", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa ", "Punjab", "Rajasthan", "Sikkim ", "Tamil Nadu", "Tripura ", "Uttar Pradesh", "West Bengal ", "Chhattisgarh", "Uttarakhand", "Jharkhand", "Telangana"}));
		suppNameAdd.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		suppNameAdd.setBackground(Color.WHITE);
		suppNameAdd.setBounds(211, 141, 244, 30);
		panel.add(suppNameAdd);
		
		JLabel label_6 = new JLabel("per unit");
		label_6.setForeground(new Color(51, 0, 153));
		label_6.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_6.setBounds(358, 266, 77, 29);
		panel.add(label_6);
		
		
		
		JLabel label_7 = new JLabel("Category :");
		label_7.setForeground(new Color(51, 0, 153));
		label_7.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_7.setBounds(517, 202, 111, 29);
		panel.add(label_7);
		
		JComboBox medCategoryAdd = new JComboBox();
		medCategoryAdd.setModel(new DefaultComboBoxModel(new String[] {"", "Capsule", "Cough syrup", "Cream", "Eye drop", "Health supplement", "Tablet"}));
		medCategoryAdd.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		medCategoryAdd.setBackground(Color.WHITE);
		medCategoryAdd.setBounds(625, 202, 197, 30);
		panel.add(medCategoryAdd);
		
		medNameAdd = new JTextField();
		medNameAdd.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		medNameAdd.setColumns(10);
		medNameAdd.setBounds(211, 77, 244, 30);
		panel.add(medNameAdd);
		
		JLabel lblEntryDate = new JLabel("Entry date :");
		lblEntryDate.setForeground(new Color(51, 0, 153));
		lblEntryDate.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		lblEntryDate.setBounds(517, 266, 111, 29);
		panel.add(lblEntryDate);
		
		JDateChooser medMfgAdd = new JDateChooser();
		medMfgAdd.setBounds(625, 76, 197, 30);
		panel.add(medMfgAdd);
		
		JDateChooser medExpAdd = new JDateChooser();
		medExpAdd.setBounds(625, 139, 197, 30);
		panel.add(medExpAdd);
		
		JDateChooser medEntryAdd = new JDateChooser();
		medEntryAdd.setBounds(625, 263, 197, 30);
		panel.add(medEntryAdd);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(248, 248, 255));
		tabbedPane.addTab("Update medicines", null, panel_1, null);
		
		JLabel label_8 = new JLabel("Product name :");
		label_8.setForeground(new Color(51, 0, 153));
		label_8.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_8.setBounds(66, 76, 123, 29);
		panel_1.add(label_8);
		
		JLabel label_9 = new JLabel("Supplier name :");
		label_9.setForeground(new Color(51, 0, 153));
		label_9.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_9.setBounds(66, 132, 135, 29);
		panel_1.add(label_9);
		
		JLabel label_10 = new JLabel("Quantity :");
		label_10.setForeground(new Color(51, 0, 153));
		label_10.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_10.setBounds(66, 190, 111, 29);
		panel_1.add(label_10);
		
		JLabel label_11 = new JLabel("Price (Rs.)  :");
		label_11.setForeground(new Color(51, 0, 153));
		label_11.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_11.setBounds(66, 241, 135, 29);
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("Mfg date :");
		label_12.setForeground(new Color(51, 0, 153));
		label_12.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_12.setBounds(515, 76, 111, 29);
		panel_1.add(label_12);
		
		JLabel label_13 = new JLabel("Exp date :");
		label_13.setForeground(new Color(51, 0, 153));
		label_13.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_13.setBounds(515, 140, 111, 29);
		panel_1.add(label_13);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		textField_2.setColumns(10);
		textField_2.setBounds(211, 242, 135, 30);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		textField_3.setColumns(10);
		textField_3.setBounds(211, 191, 135, 30);
		panel_1.add(textField_3);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		comboBox_3.setBackground(new Color(255, 255, 255));
		comboBox_3.setBounds(211, 78, 244, 30);
		panel_1.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		comboBox_4.setBackground(new Color(255, 255, 255));
		comboBox_4.setBounds(211, 133, 244, 30);
		panel_1.add(comboBox_4);
		
		JLabel label_14 = new JLabel("per unit");
		label_14.setForeground(new Color(51, 0, 153));
		label_14.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_14.setBounds(360, 241, 77, 29);
		panel_1.add(label_14);
		
		JButton button_1 = new JButton("Update medicines");
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button_1.setBackground(new Color(102, 153, 255));
		button_1.setBounds(211, 414, 199, 38);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("Remove medicines");
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button_2.setBackground(new Color(102, 153, 255));
		button_2.setBounds(455, 414, 199, 38);
		panel_1.add(button_2);
		
		JLabel label_15 = new JLabel("Category :");
		label_15.setForeground(new Color(51, 0, 153));
		label_15.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_15.setBounds(515, 200, 111, 29);
		panel_1.add(label_15);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"", "Capsule", "Cough syrup", "Cream", "Eye drop", "Health supplement", "Tablet"}));
		comboBox_5.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		comboBox_5.setBackground(new Color(255, 255, 255));
		comboBox_5.setBounds(625, 201, 197, 30);
		panel_1.add(comboBox_5);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(625, 75, 197, 30);
		panel_1.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(625, 139, 197, 30);
		panel_1.add(dateChooser_1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage home= new HomePage();
				home.setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		btnBack.setBackground(new Color(51, 153, 255));
		btnBack.setBounds(755, 617, 111, 37);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("assets/images/wallpaper1.jpg"));
		lblNewLabel.setBounds(0, 0, 883, 683);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("Add medicines");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name, entryDate, category, qty, suppName, price;
				name= medNameAdd.getText();
				price= medPriceAdd.getText();
				float medPrice= Float.parseFloat(price);
		 		category= (String) medCategoryAdd.getSelectedItem();
		 		suppName= (String) suppNameAdd.getSelectedItem();
		 		name= medNameAdd.getText();
		 		qty = medQtyAdd.getText();
		 		  DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		 	       String mfg = dt.format(medMfgAdd.getDate());	
		 	      DateFormat dte = new SimpleDateFormat("dd/MM/yyyy");
		 	       String exp = dte.format(medExpAdd.getDate());
		 	      DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		 	       String entry = d.format(medEntryAdd.getDate());
		 		
			 			//if(name!=null && price!=null && qty!=null && suppName!=null && !"".equals(name.trim()) && !"".equals(price.trim()) && !"".equals(qty.trim()) && !"".equals(suppName.trim()) ){
			     try{			    				 		
			    	 String line=null;
			 		   File file = new File("assets/data/medicines.dat");
		                   if (!file.exists()) {
		                   file.createNewFile();
		               }

		               FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		               BufferedWriter bw = new BufferedWriter(fw);
		             bw.write(name + "|" + category + "|" + qty + "|" + price + "|" + suppName + "|" + mfg + "|" + exp+ "|" + entry );
			              bw.newLine();
		              

		              bw.flush();
		               
		               fw.flush();
		               
		               JOptionPane.showMessageDialog(null, "Medicine added successfully.");
		               medNameAdd.setText("");
		               medPriceAdd.setText("");
		               medCategoryAdd.setSelectedItem("");
		               suppNameAdd.setSelectedItem("");	
		               }catch(Exception ex){
		            	   ex.printStackTrace();
		            	   JOptionPane.showMessageDialog(null, "Please give valid input.");
		              }
			 		
			 		/*	else
			 			{
			 				 JOptionPane.showMessageDialog(null, "Please fill all the fields.");
			 			} */
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button.setBackground(new Color(102, 153, 255));
		button.setBounds(327, 412, 202, 38);
		panel.add(button);
	}
}
