package globsyn.project;
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
import java.awt.Frame;

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
		
		JLabel lblState = new JLabel("State :");
		lblState.setForeground(new Color(51, 0, 153));
		lblState.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		lblState.setBounds(56, 92, 150, 20);
		panel.add(lblState);
		
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
		
		JComboBox stateSupplierAdd = new JComboBox();
		stateSupplierAdd.setModel(new DefaultComboBoxModel(new String[] {"", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu & Kashmir", "Karnataka", "Kerala", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa ", "Punjab", "Rajasthan", "Sikkim ", "Tamil Nadu", "Tripura ", "Uttar Pradesh", "West Bengal ", "Chhattisgarh", "Uttarakhand", "Jharkhand", "Telangana"}));
		stateSupplierAdd.setBackground(Color.WHITE);
		stateSupplierAdd.setMaximumRowCount(15);
		stateSupplierAdd.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		stateSupplierAdd.setBounds(208, 89, 181, 25);
		panel.add(stateSupplierAdd);
		
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
				String name, state, city, email, address;
				name= supplierNameAdd.getText();
				long contact, gst, pincode;
		 		state= (String) stateSupplierAdd.getSelectedItem();
		 		city= (String) citySupplierAdd.getSelectedItem();
		 		email= emailSupplierAdd.getText();
		 		address = addressSupplierAdd.getText();
		 		String gST=gstSupplierAdd.getText();
			 			if(name!=null && address!=null && email!=null && state!="" && city!="" && gST!=null &&   !"".equals(name.trim()) && !"".equals(address.trim()) && !"".equals(email.trim()) && !"".equals(gST.trim()) && !"".equals(state.trim()) && !"".equals(city.trim())){
			     try{
			    	 
			 		
			 		String pin=pincodeSupplierAdd.getText();
			 		pincode=Long.parseLong(pin);
			 		String con= contactSupplierAdd.getText();
			 		contact= Long.parseLong(con);
			 		
			 		
			 		
			 		String line=null;
			 		   File file = new File("assets/data/supplierInfo.dat");
		                   if (!file.exists()) {
		                   file.createNewFile();
		               }
		                  

		               FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
		               BufferedWriter bw = new BufferedWriter(fw);
		               bw.write(name + "|" + state + "|" + city + "|" + email + "|" + address + "|" + pincode + "|" + contact + "|" + gST );
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
		               stateSupplierAdd.setSelectedItem("");
		               contactSupplierAdd.setText("");
			 		
		              
		          
		               }catch(Exception ex){
		            	   ex.printStackTrace();
		            	   JOptionPane.showMessageDialog(null, "Please give valid input.");
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
		addSupplier.setBounds(229, 464, 193, 38);
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
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 supplierNameAdd.setText("");
	               emailSupplierAdd.setText("");
	               gstSupplierAdd.setText("");
	               pincodeSupplierAdd.setText("");
	               addressSupplierAdd.setText("");
	               citySupplierAdd.setSelectedItem("");
	               stateSupplierAdd.setSelectedItem("");
	               contactSupplierAdd.setText("");
			}
		});
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		btnClear.setBackground(new Color(102, 153, 255));
		btnClear.setBounds(471, 464, 133, 38);
		panel.add(btnClear);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(248, 248, 255));
		tabbedPane.addTab("View suppliers", null, panel_2, null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 82, 827, 397);
		panel_2.add(scrollPane);
		
		supplierTable = new JTable();
		supplierTable.setBackground(new Color(248, 248, 255));
		supplierTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "State", "City", "Email", "Address", "Pincode", "Contact","GST number"
			}
					));
		supplierTable.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		scrollPane.setViewportView(supplierTable);
		
		 String line = null;
	        DefaultTableModel dtm = (DefaultTableModel) supplierTable.getModel();
         String file="assets/data/supplierInfo.dat";
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(file));

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

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

		
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
		searchSupplier.setBounds(313, 31, 274, 32);
		panel_2.add(searchSupplier);
		
		JLabel lblSearchHere = new JLabel("Search here :");
		lblSearchHere.setForeground(new Color(51, 0, 153));
		lblSearchHere.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		lblSearchHere.setBounds(194, 36, 133, 20);
		panel_2.add(lblSearchHere);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.setBounds(704, 490, 133, 38);
		panel_2.add(btnRefresh);
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
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel dta = (DefaultTableModel) supplierTable.getModel();
				  int sRow= supplierTable.getSelectedRow();
					  if(sRow!=-1)
					  {
						  dta.removeRow(sRow);
					        String file="assets/data/supplierInfo.dat";
					        try {
					            BufferedWriter b = new BufferedWriter(new FileWriter(file));
					            int row= dta.getRowCount();
					              int col= dta.getColumnCount();
					             
					            	  for(int i=0; i<row; i++)
					            	  {
					              for(int j=0; j<col; j++)
					              {
					            	  b.write(dta.getValueAt(i, j) + "|");
					              }
					              b.newLine();
					            	  }
					            	  JOptionPane.showMessageDialog(null, "Supplier has been removed successfully.");

					            b.close();
					            

					        } catch (Exception ex) {
					        	
					            ex.printStackTrace();
					        }
					  }
					  else
						  JOptionPane.showMessageDialog(null,"Please select a row.");
				  
		
			        
			}
		});
		btnRemove.setForeground(Color.WHITE);
		btnRemove.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		btnRemove.setBackground(new Color(102, 153, 255));
		btnRemove.setBounds(538, 490, 133, 38);
		panel_2.add(btnRemove);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel updateTable = (DefaultTableModel) supplierTable.getModel();
			
				
					 String file="assets/data/supplierInfo.dat";
				        try {
				            BufferedWriter b = new BufferedWriter(new FileWriter(file));
				            int row= updateTable.getRowCount();
				              int col= updateTable.getColumnCount();
				             
				            	  for(int i=0; i<row; i++)
				            	  {
				              for(int j=0; j<col; j++)
				              {
				            	  b.write(updateTable.getValueAt(i, j) + "|");
				              }
				              b.newLine();
				            	  }
				            	  JOptionPane.showMessageDialog(null, "Supplier has been updated successfully.");

				            b.close();
				             
				}catch(Exception ee){
					ee.printStackTrace();
				}
				
				}
		});
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		btnUpdate.setBackground(new Color(102, 153, 255));
		btnUpdate.setBounds(373, 490, 133, 38);
		panel_2.add(btnUpdate);
		
		JButton button_3 = new JButton("Back");
		button_3.setBounds(719, 608, 133, 38);
		contentPane.add(button_3);
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Eclipse\\workspaces\\MedicalStorenew\\assets\\images\\wallpaper1.jpg"));
		lblNewLabel.setBounds(0, 0, 894, 685);
		contentPane.add(lblNewLabel); 
      
		
		
	}
}
