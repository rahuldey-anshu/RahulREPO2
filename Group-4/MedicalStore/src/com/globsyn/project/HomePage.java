package com.globsyn.project;

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
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
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
	public HomePage(String name)
	{
		components();
		//labelnm.setText("You are logged in as "+name);

	}
	
	public HomePage() {
		setResizable(false);
		components();
	}
		public void components()
		{
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
		scrollPane.setBounds(255, 189, 879, 473);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine name", "Category", "Qty", "Price (Rs.)", "Supplier name","Mfg date","Exp date","Entry date"
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
		menuPanel.setBounds(0, 136, 224, 548);
		panel.add(menuPanel);
		
		JButton button = new JButton("Medicines");
		button.setIcon(new ImageIcon("/assets/medicine1.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Medicines med= new Medicines();
				med.setVisible(true);
				dispose();
			}
		});
		button.setForeground(new Color(51, 0, 102));
		button.setFont(new Font("Lucida Fax", Font.BOLD, 14));
		button.setBackground(Color.WHITE);
		button.setBounds(17, 56, 189, 39);
		menuPanel.add(button);
		
		JButton button_1 = new JButton("Inventory");
		button_1.setIcon(new ImageIcon("assets/images/inventory1.png"));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inventory inventory = new Inventory();
				inventory.setVisible(true);
				dispose();
			}
		});
		button_1.setForeground(new Color(51, 0, 102));
		button_1.setFont(new Font("Lucida Fax", Font.BOLD, 14));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(17, 105, 188, 39);
		menuPanel.add(button_1);
		
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
		button_2.setBounds(17, 205, 188, 39);
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
		button_3.setBounds(17, 155, 188, 39);
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
		button_4.setBounds(17, 255, 188, 39);
		menuPanel.add(button_4);
		
		JButton button_5 = new JButton("Unused stock");
		button_5.setIcon(new ImageIcon("assets/images/unused.png"));
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UnusedStock unusedStock= new UnusedStock();
				unusedStock.setVisible(true);
				dispose();
			}
		});
		button_5.setForeground(new Color(51, 0, 102));
		button_5.setFont(new Font("Lucida Fax", Font.BOLD, 14));
		button_5.setBackground(Color.WHITE);
		button_5.setBounds(17, 307, 188, 39);
		menuPanel.add(button_5);
		
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
		button_6.setBounds(17, 362, 189, 39);
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
		button_7.setBounds(17, 418, 189, 39);
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
		button_8.setBounds(17, 473, 189, 39);
		menuPanel.add(button_8);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(null);
		searchPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		searchPanel.setBackground(Color.WHITE);
		searchPanel.setBounds(438, 89, 514, 57);
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
		
		
			
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 1184, 699);
		panel.add(label);
		label.setIcon(new ImageIcon("/assets/wallpaper1.jpg"));
	}
}

