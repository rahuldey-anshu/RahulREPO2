package com.globsyn.hostel.management;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.KeyStroke;

import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.SwingConstants;

public class BookedList extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static Vector<String> headers;
	private static Vector<Vector<String>> data;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookedList frame = new BookedList();
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
	public BookedList() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets\\icon17.png"));
		setTitle("Hostel Management Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 0, 0);
		contentPane.add(panel_1);

		headers = new Vector<String>();
		headers.add("Room Number");
		headers.add("Room Type");
		headers.add("Bed No");
		headers.add("Tariff");
		headers.add("Name ");
		headers.add("Payment Method ");
		
		/*headers.add("Room No");
		headers.add("Room TYpe");
		headers.add("Bed Number");
		headers.add("Paid");
		*/
		data = new Vector<Vector<String>>();

		try {
			File f = new File("assets/forms/bookedRooms.dat");

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

				scanner.close();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		JTable table = new JTable();

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int rowindex = table.getSelectedRow();
				System.out.println(table.getModel().getValueAt(rowindex, 0));
				System.out.println(table.getModel().getValueAt(rowindex, 1));
				System.out.println(table.getModel().getValueAt(rowindex, 2));

			}
		});
		DefaultTableModel model = new DefaultTableModel(data, headers);
		table.setModel(model);
		table.setAutoCreateRowSorter(true);
		model = new DefaultTableModel(data, headers);
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(5, 86, 1352, 390);

		getContentPane().add(scroll);

		JButton btnGoBack = new JButton("Go back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage window = new HomePage();
				window.frmHomePage.setVisible(true);
				dispose();
			}
		});
		btnGoBack.setBounds(15, 490, 89, 23);
		contentPane.add(btnGoBack);

		JButton btnDeleteRow = new JButton("Delete Row");
		btnDeleteRow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int rowindex = table.getSelectedRow();

				data.remove(rowindex);

				System.out.println(data.size());

				studentDeleteFromFile(data);
				
				File f1 = new File("assets/forms/bookedRooms.dat");

				if (f1.exists()) {
					Scanner scanner;
					try {
						scanner = new Scanner(f1);

						while (scanner.hasNext()) {
							Vector<String> row = new Vector<>();

							String line = scanner.nextLine();
							String[] fields = line.split("[|]");
							for (int i = 0; i < fields.length; i++) {
								row.add(fields[i]);
							}

							data.add(row);
						}

						scanner.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (Exception e2) {
						e2.printStackTrace();
					}

					DefaultTableModel model = new DefaultTableModel(data, headers);
					table.setModel(model);
					table.setRowSelectionAllowed(true);
					table.setAutoCreateRowSorter(true);
					model = new DefaultTableModel(data, headers);
					table.setModel(model);
					JScrollPane scroll = new JScrollPane(table);
					scroll.setBounds(5, 5, 1352, 471);

					getContentPane().add(scroll);
					BookedList frame = new BookedList();
					frame.setVisible(true);
					dispose();
				}
			}
		});
		btnDeleteRow.setBounds(143, 490, 131, 23);
		contentPane.add(btnDeleteRow);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1419, 21);
		contentPane.add(menuBar);
		JMenu mnNew = new JMenu("Student");
		menuBar.add(mnNew);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_MASK));
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentDetails window = new StudentDetails();
				window.frmStudentDetails.setVisible(true);			
			dispose();}
		});
		
		mnNew.add(mntmNew);
		
		JSeparator separator_2 = new JSeparator();
		mnNew.add(separator_2);
		
		JMenuItem mntmList = new JMenuItem("List");
		mntmList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentList frame = new StudentList();
				frame.setVisible(true);
				dispose();}
		});
		
		mntmList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK));
		mnNew.add(mntmList);
		
		JMenu mnSupplier = new JMenu("Supplier");
		menuBar.add(mnSupplier);
		
		JMenuItem mntmAdd = new JMenuItem("New");
		mntmAdd.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewSupplier window1 = new NewSupplier();
				window1.setVisible(true);
			dispose();
			}
		});
		mnSupplier.add(mntmAdd);
		
		JSeparator separator_1 = new JSeparator();
		mnSupplier.add(separator_1);
		
		JMenuItem mntmList_1 = new JMenuItem("List");
		mntmList_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierList frmSupplierList = new SupplierList();
				frmSupplierList.setVisible(true);
				dispose();
			}
		});
		mntmList_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mnSupplier.add(mntmList_1);
		
		JMenu mnRoom = new JMenu("Room");
		menuBar.add(mnRoom);
		
		JMenuItem mntmAllocateRoom = new JMenuItem("Allocate");
		mntmAllocateRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RoomsFinal frame = new RoomsFinal();
				frame.setVisible(true);
				dispose();
			}
		});
		JSeparator separator = new JSeparator();
		mnRoom.add(separator);
		
		JMenuItem mntmBooked = new JMenuItem("Booked");
		mntmBooked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookedList frame = new BookedList();
				frame.setVisible(true);
				dispose();

			}
		});
		mnRoom.add(mntmBooked);
		
		mnRoom.add(mntmAllocateRoom);
		
		JMenu mnLogout = new JMenu("Logout");
		menuBar.add(mnLogout);
		
		JMenuItem mntmConfirm = new JMenuItem("Confirm");
		mntmConfirm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.ALT_MASK));
		mntmConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HostelAppLogin window = new HostelAppLogin();
				window.frmHostelAppLogin.setVisible(true);
				dispose();}
		});
		mnLogout.add(mntmConfirm);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(139, 0, 0));
		panel.setBounds(0, 21, 1419, 54);
		contentPane.add(panel);
		
		JLabel lblStudentList = new JLabel("Booked Rooms List");
		lblStudentList.setForeground(new Color(250, 235, 215));
		lblStudentList.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudentList.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblStudentList);
		
		setSize(1254, 563);
		setResizable(true);
		setVisible(true);
	}

	public void studentDeleteFromFile(Vector<Vector<String>> data) {

		try {
			File f = new File("assets/forms/bookedRooms.dat");

			if (f.exists()) {
				FileWriter fileWriter = new FileWriter(f);
				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
				for (int i = 0; i < data.size(); i++) {
					Vector<String> vector = (Vector<String>) data.get(i);

					String line = "";
					for (int j = 0; j < vector.size(); j++) {
						line += vector.get(j) + "|";
					}
					line = line.substring(0, line.length() - 1);
					bufferedWriter.write(line + "\n");
				}

				bufferedWriter.flush();
				bufferedWriter.close();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
