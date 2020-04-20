package globsyn.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HomePage extends JFrame {

	private JPanel contentPane;
	private JTextField search;
	private JTable table;
		
	 public void searchTable(String input) {
         final TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
         table.setRowSorter(sorter);
         if (input.length() != 0) {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + input));

         } else {
                sorter.setRowFilter(null);

         }

}

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
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 1170,724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1184, 741);
		contentPane.add(panel);
		
		JLabel labelnm = new JLabel("");
		labelnm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelnm.setBounds(922, 25, 236, 23);
		panel.add(labelnm);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(235, 136, 915, 459);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine name", "Category", "Qty", "Price per unit (Rs.)", "Total cost", "Supplier name","Mfg date","Exp date","Entry date"
			}
		));
		table.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		
		 String line = null;
	        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            String file="assets/data/medicines.dat";
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
		
		
		JPanel menuPanel = new JPanel();
		menuPanel.setLayout(null);
		menuPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		menuPanel.setBackground(Color.WHITE);
		menuPanel.setBounds(0, 136, 210, 548);
		panel.add(menuPanel);
		
		JButton btnProducts = new JButton("Stock entry");
		btnProducts.setIcon(new ImageIcon("/assets/medicine1.png"));
		btnProducts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Medicines med= new Medicines();
				med.setVisible(true);
				dispose();
			}
		});
		btnProducts.setForeground(new Color(51, 0, 102));
		btnProducts.setFont(new Font("Lucida Fax", Font.BOLD, 14));
		btnProducts.setBackground(Color.WHITE);
		btnProducts.setBounds(10, 52, 189, 39);
		menuPanel.add(btnProducts);
		
		JButton button_2 = new JButton("Sales record");
		button_2.setIcon(new ImageIcon("assets/images/order.png"));
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SalesRecord salesRecord= new SalesRecord();
				salesRecord.setVisible(true);
				dispose();
			}
		});
		button_2.setForeground(new Color(51, 0, 102));
		button_2.setFont(new Font("Lucida Fax", Font.BOLD, 14));
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(10, 152, 188, 39);
		menuPanel.add(button_2);
		
		JButton button_3 = new JButton("Suppliers");
		button_3.setIcon(new ImageIcon("assets/images/supplier.png"));
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Suppliers suppliers= new Suppliers();
				suppliers.setVisible(true);
				dispose();
			};
		});
		button_3.setForeground(new Color(51, 0, 102));
		button_3.setFont(new Font("Lucida Fax", Font.BOLD, 14));
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(10, 102, 188, 39);
		menuPanel.add(button_3);
		
		JButton button_4 = new JButton("Order         ");
		button_4.setIcon(new ImageIcon("assets/images/billing.png"));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Order order= new Order();
				order.setVisible(true);
				dispose();
			}
		});
		button_4.setForeground(new Color(51, 0, 102));
		button_4.setFont(new Font("Lucida Fax", Font.BOLD, 14));
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(10, 202, 188, 39);
		menuPanel.add(button_4);
		
		JButton button_6 = new JButton("Create new user");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateUser createUser= new CreateUser();
				createUser.setVisible(true);
				dispose();
			}
		});
		button_6.setForeground(new Color(51, 0, 102));
		button_6.setFont(new Font("Lucida Fax", Font.BOLD, 14));
		button_6.setBackground(Color.WHITE);
		button_6.setBounds(10, 252, 189, 39);
		menuPanel.add(button_6);
		
		JButton button_7 = new JButton("Change password");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword changePassword= new ChangePassword();
				changePassword.setVisible(true);
				dispose();
			}
		});
		button_7.setForeground(new Color(51, 0, 102));
		button_7.setFont(new Font("Lucida Fax", Font.BOLD, 14));
		button_7.setBackground(Color.WHITE);
		button_7.setBounds(10, 308, 189, 39);
		menuPanel.add(button_7);
		
		JButton button_8 = new JButton("Logout");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button_8.setForeground(new Color(51, 0, 102));
		button_8.setFont(new Font("Lucida Fax", Font.BOLD, 14));
		button_8.setBackground(Color.WHITE);
		button_8.setBounds(10, 363, 189, 39);
		menuPanel.add(button_8);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(null);
		searchPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		searchPanel.setBackground(Color.WHITE);
		searchPanel.setBounds(436, 56, 514, 57);
		panel.add(searchPanel);
		
		search = new JTextField();
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String input= search.getText().toLowerCase();
      searchTable(input);
			}
		});
		
		
		
		search.setFont(new Font("Lucida Fax", Font.PLAIN, 17));
		search.setColumns(10);
		search.setBounds(137, 11, 353, 34);
		searchPanel.add(search);
		
		JLabel lblSearchHere = new JLabel("Search here :");
		lblSearchHere.setForeground(new Color(51, 0, 153));
		lblSearchHere.setFont(new Font("Lucida Fax", Font.BOLD, 15));
		lblSearchHere.setBounds(22, 17, 111, 22);
		searchPanel.add(lblSearchHere);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DefaultTableModel d = (DefaultTableModel) table.getModel();
				d.setRowCount(0);
				 String file="assets/data/medicines.dat";
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
		btnRefresh.setForeground(new Color(51, 0, 102));
		btnRefresh.setFont(new Font("Lucida Fax", Font.BOLD, 14));
		btnRefresh.setBackground(Color.WHITE);
		btnRefresh.setBounds(945, 632, 189, 39);
		panel.add(btnRefresh);
		
		JButton btnAddToCart = new JButton("Add to cart");
		btnAddToCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
				  File file = new File("assets/data/addToCart.dat");
                  if (!file.exists()) {
                  file.createNewFile();
              }
                 

              FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
              BufferedWriter bw = new BufferedWriter(fw);
              DefaultTableModel dt= (DefaultTableModel) table.getModel();
              int row= table.getSelectedRow();
              int col= table.getColumnCount();
             
            	  for(int j=0; j<col; j++)
            	  {
              if(j==0 || j==3 || j==7)
              {
            	  bw.write(dt.getValueAt(row, j) + "|");
              }
            	  }
              bw.newLine();
              JOptionPane.showMessageDialog(null, "Item added successfully to the cart");

             bw.close();
              
              fw.close();
				}catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, "Please select an item.");
				}
			}
		});
		btnAddToCart.setForeground(new Color(51, 0, 102));
		btnAddToCart.setFont(new Font("Lucida Fax", Font.BOLD, 14));
		btnAddToCart.setBackground(Color.WHITE);
		btnAddToCart.setBounds(525, 632, 189, 39);
		panel.add(btnAddToCart);
		
		JButton updateStock = new JButton("Update stock");
		updateStock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel updateTable = (DefaultTableModel) table.getModel();
				
				
				 String file="assets/data/medicines.dat";
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
			            	  JOptionPane.showMessageDialog(null, "Medicine has been updated successfully.");

			            b.close();
			             
			}catch(Exception ee){
				ee.printStackTrace();
			}
			
			}
		});
		updateStock.setForeground(new Color(51, 0, 102));
		updateStock.setFont(new Font("Lucida Fax", Font.BOLD, 14));
		updateStock.setBackground(Color.WHITE);
		updateStock.setBounds(735, 632, 189, 39);
		panel.add(updateStock);
		
		
			
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 1184, 699);
		panel.add(label);
		label.setIcon(new ImageIcon("assets//images//wallpaper1.jpg"));
	}
}

