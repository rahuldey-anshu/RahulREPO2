package globsyn.project;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Medicines extends JFrame {

	private JPanel contentPane;
	private JTextField medPriceAdd;
	private JTextField medQtyAdd;
	private JTextField medNameAdd;
	private JTextField suppNameAdd;

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
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage home= new HomePage();
				home.setVisible(true);
				dispose();
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 87, 854, 496);
		contentPane.add(panel);
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
		medPriceAdd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				
			String quantity= medQtyAdd.getText();
			 int qnnty= Integer.parseInt(quantity);
			 String price= medPriceAdd.getText();
			 float prce= Float.parseFloat(price);
			 
			}
		});
		medPriceAdd.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		medPriceAdd.setColumns(10);
		medPriceAdd.setBounds(211, 263, 135, 30);
		panel.add(medPriceAdd);
		
		medQtyAdd = new JTextField();
		medQtyAdd.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		medQtyAdd.setColumns(10);
		medQtyAdd.setBounds(211, 202, 135, 30);
		panel.add(medQtyAdd);
		
		JLabel label_6 = new JLabel("per unit");
		label_6.setForeground(new Color(51, 0, 153));
		label_6.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_6.setBounds(378, 263, 77, 29);
		panel.add(label_6);
		
		
		
		JLabel label_7 = new JLabel("Category :");
		label_7.setForeground(new Color(51, 0, 153));
		label_7.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_7.setBounds(517, 202, 111, 29);
		panel.add(label_7);
		
		JComboBox medCategoryAdd = new JComboBox();
		medCategoryAdd.setModel(new DefaultComboBoxModel(new String[] {"--Select--", "Capsule", "Cream", "Drops", "Serum", "Supplement", "Syrup", "Tablet", "Tonic", "Vaccine"}));
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
		
		JLabel tp = new JLabel("");
		JButton button = new JButton("Add medicines");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name, entryDate, category, qty, suppName, price;
				name= medNameAdd.getText();
				price= medPriceAdd.getText();
				try{
				float medPrice= Float.parseFloat(price);
		 		category= (String) medCategoryAdd.getSelectedItem();
		 		suppName= suppNameAdd.getText();
		 		name= medNameAdd.getText();
		 		qty = medQtyAdd.getText();
		 		int qnty= Integer.parseInt(qty);
		 		String totalp= tp.getText();
		 		
		 		  DateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
		 	       String mfg = dt.format(medMfgAdd.getDate());	
		 	      DateFormat dte = new SimpleDateFormat("dd/MM/yyyy");
		 	       String exp = dte.format(medExpAdd.getDate());
		 	      DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		 	       String entry = d.format(medEntryAdd.getDate());
		 		
			 	if(tp!=null && name!=null && category!="--Select--" && price!=null && qty!=null && suppName!=null && mfg!=null && exp!=null && entry!=null && !"".equals(category.trim()) && !"".equals(mfg.trim()) && !"".equals(exp.trim()) && !"".equals(entry.trim()) && !"".equals(name.trim()) && !"".equals(price.trim()) && !"".equals(qty.trim()) && !"".equals(suppName.trim()) ){
			     			    				 		
			    	 String line=null;
			 		   File file = new File("assets/data/medicines.dat");
		                   if (!file.exists()) {
		                   file.createNewFile();
		               }

		               FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		               BufferedWriter bw = new BufferedWriter(fw);
		             bw.write(name + "|" + category + "|" + qty + "|" + price + "|" + totalp +"|" + suppName + "|" + mfg + "|" + exp+ "|" + entry );
			              bw.newLine();
		              

		              bw.flush();
		               
		               fw.flush();
		               
		               JOptionPane.showMessageDialog(null, "Medicine added successfully.");
		               medNameAdd.setText("");
		               medPriceAdd.setText("");
		               medCategoryAdd.setSelectedItem("--Select--");
		               suppNameAdd.setText("");	
		               tp.setText("");
		               medQtyAdd.setText("");
		               medMfgAdd.setDate(null);
		               medExpAdd.setDate(null);
		               medEntryAdd.setDate(null);
		               tp.setText("");
			 	
			 	}
			 	
			 		
			 			else
			 			
			 				 JOptionPane.showMessageDialog(null, "Please fill all the fields.");
				}catch(Exception ex){
	            	   ex.printStackTrace();
	            	   JOptionPane.showMessageDialog(null, "Please give valid input.");
		 	}
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button.setBackground(new Color(102, 153, 255));
		button.setBounds(331, 431, 202, 38);
		panel.add(button);
		
		JLabel lblTotalCost = new JLabel("Total cost (Rs.) :");
		lblTotalCost.setForeground(new Color(51, 0, 153));
		lblTotalCost.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		lblTotalCost.setBounds(66, 328, 135, 29);
		panel.add(lblTotalCost);
		
		JButton btnShow = new JButton("Show");
		
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				String qty, price;
				qty= medQtyAdd.getText();
				price= medPriceAdd.getText();
				int qnty= Integer.parseInt(qty);
				float prce= Float.parseFloat(price);
				Float result= new Float (qnty*prce);
				tp.setText(result.toString());
				}catch(NumberFormatException exe)
				{
					JOptionPane.showMessageDialog(null, "Please enter valid input value.");
				}
				
			}
		});
		btnShow.setForeground(Color.WHITE);
		btnShow.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		btnShow.setBackground(new Color(102, 153, 255));
		btnShow.setBounds(376, 328, 101, 29);
		panel.add(btnShow);
		
		
		tp.setForeground(new Color(51, 0, 153));
		tp.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		tp.setBounds(211, 328, 135, 29);
		panel.add(tp);
		
		suppNameAdd = new JTextField();
		suppNameAdd.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		suppNameAdd.setColumns(10);
		suppNameAdd.setBounds(211, 139, 244, 30);
		panel.add(suppNameAdd);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		btnBack.setBackground(new Color(51, 153, 255));
		btnBack.setBounds(755, 617, 111, 37);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("assets//images//wallpaper1.jpg"));
		lblNewLabel.setBounds(0, 0, 883, 683);
		contentPane.add(lblNewLabel);
	}
}
