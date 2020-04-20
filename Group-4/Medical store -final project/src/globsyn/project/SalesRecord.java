package globsyn.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SalesRecord extends JFrame {

	private JPanel contentPane;
	private JTextField search;
	private JTable table;

	/**
	 * Launch the application.
	 */
	 public void searchTable(String input) {
         final TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
         table.setRowSorter(sorter);
         if (input.length() != 0) {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + input));

         } else {
                sorter.setRowFilter(null);

         }

}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesRecord frame = new SalesRecord();
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
	public SalesRecord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900,724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(10, 41, 864, 613);
		contentPane.add(panel);
		
		JLabel lblSearchHere = new JLabel("Search here :");
		lblSearchHere.setForeground(new Color(51, 0, 153));
		lblSearchHere.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		lblSearchHere.setBounds(187, 49, 117, 29);
		panel.add(lblSearchHere);
		
		search = new JTextField();
		search.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String input= search.getText().toLowerCase();
			      searchTable(input);
			}
		});
		search.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		search.setColumns(10);
		search.setBounds(319, 46, 353, 34);
		panel.add(search);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage home= new HomePage();
				home.setVisible(true);
				dispose();
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button_1.setBackground(new Color(102, 153, 255));
		button_1.setBounds(721, 560, 133, 38);
		panel.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 844, 438);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer name","Contact","Date","Medicine name", "Price (per unit)", "Exp date", "Qty","Total cost"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 DefaultTableModel d = (DefaultTableModel) table.getModel();
				  while(d.getRowCount()>0)
				  {
					  for(int i=0; i<d.getRowCount(); i++)
					  {
						  d.removeRow(i);
					  }
				  }
			        String file="assets/data/generateInvoice.dat";
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
			                d.addRow(data);
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
		btnRefresh.setBounds(553, 560, 133, 38);
		panel.add(btnRefresh);
		
		 String line = null;
	        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
         String file="assets/data/generateInvoice.dat";
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

		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("assets//images//wallpaper1.jpg"));
		lblNewLabel.setBounds(0, 0, 884, 685);
		contentPane.add(lblNewLabel);
	}

}
