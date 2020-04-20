package globsyn.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

public class Order extends JFrame {

	private JPanel contentPane;
	private JTextField customerName;
	private JTextField customerContact;
	private JTable orderTable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order frame = new Order();
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
	public Order() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 887,724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(10, 46, 864, 603);
		contentPane.add(panel);
	
		JDateChooser dateToday = new JDateChooser();
		JButton btnGenerateInvoice = new JButton("Generate invoice");
		btnGenerateInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name, contact;
				name= customerName.getText();
				contact= customerContact.getText();
				Long c= Long.parseLong(contact);
				Date date = dateToday.getDate();
				String strDate = DateFormat.getDateInstance().format(date);
				DefaultTableModel oTable = (DefaultTableModel) orderTable.getModel();
				
				
				 String file="assets/data/generateInvoice.dat";
			        try {
			            BufferedWriter b = new BufferedWriter(new FileWriter(file));
			            int row= oTable.getRowCount();
			              int col= oTable.getColumnCount();
			             
			            	  for(int i=0; i<row; i++)
			            	  {
			            		  b.write(name +"|"+ c +"|"+ strDate +"|");
			              for(int j=0; j<col; j++)
			              {
			            	 b.write(oTable.getValueAt(i, j) + "|");
			              }
			              
			              b.newLine();
			            	  }
			            	  
			            b.close();
			            
			           for(int x=0; x<row; x++)
			           {
			        	   oTable.removeRow(x);
			           }
			           
			             
			}catch(Exception ee){
				ee.printStackTrace();
				
				
			       
				PrintBill printBill= new PrintBill();
				printBill.setVisible(true);
				dispose();
			}
			}
		});
		btnGenerateInvoice.setForeground(Color.WHITE);
		btnGenerateInvoice.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		btnGenerateInvoice.setBackground(new Color(102, 153, 255));
		btnGenerateInvoice.setBounds(586, 489, 202, 34);
		panel.add(btnGenerateInvoice);
		
		JButton button_2 = new JButton("Back");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage home= new HomePage();
				home.setVisible(true);
				dispose();
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button_2.setBackground(new Color(102, 153, 255));
		button_2.setBounds(691, 537, 97, 34);
		panel.add(button_2);
		
		JLabel lblCustomerName = new JLabel("Customer name :");
		lblCustomerName.setForeground(new Color(51, 0, 153));
		lblCustomerName.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		lblCustomerName.setBounds(28, 27, 145, 34);
		panel.add(lblCustomerName);
		
		JLabel lblContact = new JLabel("Contact :");
		lblContact.setForeground(new Color(51, 0, 153));
		lblContact.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		lblContact.setBounds(91, 81, 82, 28);
		panel.add(lblContact);
		
		customerName = new JTextField();
		customerName.setBounds(183, 30, 287, 29);
		panel.add(customerName);
		customerName.setColumns(10);
		
		customerContact = new JTextField();
		customerContact.setColumns(10);
		customerContact.setBounds(183, 83, 171, 29);
		panel.add(customerContact);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 141, 744, 325);
		panel.add(scrollPane);
		
	
		  Date date = new Date();
          dateToday.setDate(date);
		orderTable = new JTable();
		orderTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine name", "Price per unit (Rs.)", "Expiry date", "Quantity (in units)", "Total cost"
			}
		));
		orderTable.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		scrollPane.setViewportView(orderTable);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


          


				
				  DefaultTableModel dtm = (DefaultTableModel) orderTable.getModel();
				  while(dtm.getRowCount()>0)
				  {
					  for(int i=0; i<dtm.getRowCount(); i++)
					  {
						  dtm.removeRow(i);
					  }
				  }
			        String file="assets/data/addToCart.dat";
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
		btnRefresh.setBounds(572, 537, 108, 34);
		panel.add(btnRefresh);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setForeground(new Color(51, 0, 153));
		lblDate.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		lblDate.setBounds(518, 82, 63, 29);
		panel.add(lblDate);
		
		
		dateToday.setBounds(590, 82, 197, 30);
		panel.add(dateToday);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  DefaultTableModel dtmo = (DefaultTableModel) orderTable.getModel();
				  int i= orderTable.getSelectedRow();
				  dtmo.removeRow(i);
			}
		});
		btnRemove.setForeground(Color.WHITE);
		btnRemove.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		btnRemove.setBackground(new Color(102, 153, 255));
		btnRemove.setBounds(454, 537, 108, 34);
		panel.add(btnRemove);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Eclipse\\workspaces\\Newproject\\assets\\images\\wallpaper1.jpg"));
		lblNewLabel.setBounds(0,11,884,695);
		contentPane.add(lblNewLabel);
	}
}
