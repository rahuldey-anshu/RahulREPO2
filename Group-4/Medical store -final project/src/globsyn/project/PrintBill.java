package globsyn.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

public class PrintBill extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrintBill frame = new PrintBill();
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
	public PrintBill() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900,724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 11, 864, 663);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(36, 11, 752, 134);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMedCare = new JLabel("Med Care");
		lblMedCare.setBounds(271, 11, 257, 42);
		panel_1.add(lblMedCare);
		lblMedCare.setForeground(new Color(51, 0, 102));
		lblMedCare.setFont(new Font("Lucida Fax", Font.BOLD, 32));
		
		JLabel lblNoa = new JLabel("No. 18, 1A Sandal Estate, Park Street, Kolkata - 700016");
		lblNoa.setBounds(121, 59, 507, 42);
		panel_1.add(lblNoa);
		lblNoa.setForeground(new Color(51, 0, 102));
		lblNoa.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		
		JLabel lblPhoneNo = new JLabel("Phone no : (033) 22695563, (+91) 9763124580");
		lblPhoneNo.setBounds(173, 92, 507, 42);
		panel_1.add(lblPhoneNo);
		lblPhoneNo.setForeground(new Color(51, 0, 102));
		lblPhoneNo.setFont(new Font("Lucida Fax", Font.BOLD, 15));
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		btnPrint.setBackground(new Color(51, 153, 255));
		btnPrint.setBounds(415, 583, 159, 42);
		panel.add(btnPrint);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage hp= new HomePage();
				hp.setVisible(true);
				dispose();
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button_1.setBackground(new Color(51, 153, 255));
		button_1.setBounds(629, 584, 159, 41);
		panel.add(button_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(36, 145, 752, 366);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(45, 30, 61, 42);
		panel_2.add(lblName);
		lblName.setForeground(new Color(51, 0, 102));
		lblName.setFont(new Font("Lucida Fax", Font.BOLD, 15));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 83, 680, 252);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(248, 248, 255));
		table.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Medicine name", "Price per unit (Rs.)", "Exp date", "Quanity (in units)", "Total cost"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel Cname = new JLabel("");
		Cname.setForeground(new Color(51, 0, 102));
		Cname.setFont(new Font("Lucida Fax", Font.BOLD, 15));
		Cname.setBounds(127, 30, 61, 42);
		panel_2.add(Cname);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/assets/wallpaper1.jpg"));
		lblNewLabel.setBounds(0, 0, 884, 685);
		contentPane.add(lblNewLabel);
	}

}
