package com.globsyn.hostel.management;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class RoomsFinal extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static Vector<String> headers;
	private static Vector<Vector<String>> data;
	private static Vector<Vector<String>> dataRoomsAvailable;
	private JTextField roomNo;
	private JTextField roomType;
	private JTextField bedType;
	private JTextField tariff;
	public String a, b, c, d;
	public String roomNotxt, roomTypetxt, bedTypetxt, tarifftxt;
	private JButton book;
	private JTable table_available;
	private JScrollPane scrollPane;
	private JMenuBar menuBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RoomsFinal frame = new RoomsFinal();
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
	public RoomsFinal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets\\icon17.png"));
		setTitle("Hostel Management Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 812, 21);
		contentPane.add(menuBar);

		JMenu mnSupplier = new JMenu("Student");
		menuBar.add(mnSupplier);

		JMenuItem newStudent = new JMenuItem("New");
		newStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_MASK));
		mnSupplier.add(newStudent);

		JSeparator separator = new JSeparator();
		mnSupplier.add(separator);

		JMenuItem listStudent = new JMenuItem("List");
		listStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.ALT_MASK));
		mnSupplier.add(listStudent);

		JMenu mnRetailer = new JMenu("Supplier");
		menuBar.add(mnRetailer);

		JMenuItem newSupplier = new JMenuItem("New ");
		newSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewSupplier frmNewSupplier = new NewSupplier();
				frmNewSupplier.setVisible(true);
				dispose();
			}
		});
		newSupplier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		mnRetailer.add(newSupplier);

		JMenuItem listSupplier = new JMenuItem("List");
		listSupplier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mnRetailer.add(listSupplier);
		
		JMenu mnRoom = new JMenu("Room");
		menuBar.add(mnRoom);
		
		JMenuItem mntmAllocate = new JMenuItem("Allocate");
		mntmAllocate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RoomsFinal frame = new RoomsFinal();
				frame.setVisible(true);
				dispose();
				
			}
		});
		mnRoom.add(mntmAllocate);
		
		JSeparator separator1 = new JSeparator();
		mnRoom.add(separator1);
		
		JMenuItem mntmBooked = new JMenuItem("Booked");
		mntmBooked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookedList frame = new BookedList();
				frame.setVisible(true);
				dispose();

			}
		});
		mnRoom.add(mntmBooked);
		
		
		
		JMenu mnLogout = new JMenu("logout");
		menuBar.add(mnLogout);

		JMenuItem confirm = new JMenuItem("Confirm");
		confirm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.ALT_MASK));
		mnLogout.add(confirm);


		//
		newStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentDetails window = new StudentDetails();
				window.frmStudentDetails.setVisible(true);			
				dispose();}

		});




		listStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentList studentList = new StudentList();
				studentList.setVisible(true);
				dispose();}
		});





		newSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewSupplier window1 = new NewSupplier();
				window1.setVisible(true);
				dispose();
			}
		});



		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HostelAppLogin window = new HostelAppLogin();
				window.frmHostelAppLogin.setVisible(true);
				dispose();}
		});



		listSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SupplierList frmSupplierList = new SupplierList();
				frmSupplierList.setVisible(true);
				dispose();
			}
		});		







		roomType = new JTextField();
		roomType.setEditable(false);
		roomType.setBounds(227, 388, -10, 20);
		contentPane.add(roomType);
		roomType.setColumns(10);

		tariff = new JTextField();
		tariff.setEditable(false);
		tariff.setBounds(652, 388, 0, 20);
		contentPane.add(tariff);
		tariff.setColumns(10);

		bedType = new JTextField();
		bedType.setEditable(false);
		bedType.setBounds(422, 388, 0, 20);
		contentPane.add(bedType);
		bedType.setColumns(10);

		roomNo = new JTextField();
		roomNo.setEditable(false);
		roomNo.setBounds(38, 388, 0, 20);
		contentPane.add(roomNo);
		roomNo.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 0, 0);
		contentPane.add(panel_1);

		headers = new Vector<String>();
		headers.add("Room Number ");
		headers.add("Room Type ");
		headers.add("Bed Type ");
		headers.add("Tariff ");

		data = new Vector<Vector<String>>();

		try {
			File f = new File("assets/forms/rooms.txt");

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
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		JTable table = new JTable();

		table.setAutoCreateRowSorter(true);
		DefaultTableModel model = new DefaultTableModel(data, headers);
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(0, 95, 774, 98);

		getContentPane().add(scroll);

		book = new JButton("BOOK");
		book.setFont(new Font("Tahoma", Font.BOLD, 13));
		book.setForeground(Color.WHITE);
		book.setBackground(Color.BLACK);
		book.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomAllocation window = new RoomAllocation();
				window.frmRoomAllocation.setVisible(true);
				dispose();
			}
		});

		book.setBounds(685, 385, 89, 23);
		contentPane.add(book);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 217, 662, 191);
		contentPane.add(scrollPane);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		HashSet<String> bookedroomsnos = new HashSet<String>();

		try {

			File f = new File("assets/forms/bookedRooms.dat");

			if (f.exists()) {
				Scanner scanner = new Scanner(f);
				while (scanner.hasNext()) {

					String line = scanner.nextLine();
					String[] fields = line.split("[|]");

					String roomno = fields[0];
					bookedroomsnos.add(roomno);

				}
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		dataRoomsAvailable = new Vector<Vector<String>>();
		try {
			File f = new File("assets/forms/rooms.txt");

			if (f.exists()) {
				Scanner scanner = new Scanner(f);
				while (scanner.hasNext()) {
					Vector<String> row = new Vector<>();

					String line = scanner.nextLine();
					String[] fields = line.split("[|]");
					String roomno = fields[0];
					if (!bookedroomsnos.contains(roomno)) {

						for (int i = 0; i < fields.length; i++) {
							row.add(fields[i]);
						}

						dataRoomsAvailable.add(row);
					}
				}
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		table_available = new JTable();
		DefaultTableModel model1 = new DefaultTableModel(dataRoomsAvailable,headers);
		table_available.setAutoCreateRowSorter(true);
		table_available.setModel(model1);

		panel.add(table_available);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(30, 144, 255));
		panel_2.setBounds(0, 22, 801, 29);
		contentPane.add(panel_2);

		JLabel lblRoomAllocation = new JLabel("Room Allocation");
		lblRoomAllocation.setForeground(Color.WHITE);
		lblRoomAllocation.setFont(new Font("Tahoma", Font.BOLD, 22));
		panel_2.add(lblRoomAllocation);

		JLabel lblNewLabel = new JLabel("All Rooms(Select one available Room)");
		lblNewLabel.setForeground(new Color(250, 235, 215));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(253, 70, 399, 23);
		contentPane.add(lblNewLabel);

		JLabel lblAvailableRooms = new JLabel("Available Rooms");
		lblAvailableRooms.setForeground(new Color(250, 235, 215));
		lblAvailableRooms.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAvailableRooms.setBounds(306, 195, 190, 23);
		contentPane.add(lblAvailableRooms);
		
		JLabel background = new JLabel(new ImageIcon("assets//room.jpg"));
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		background.setBounds(0,0,d.width,d.height);
		contentPane.add(background);



		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				// i = the index of the selected row
				int i = table.getSelectedRow();

				roomNo.setText(model.getValueAt(i, 0).toString());
				roomType.setText(model.getValueAt(i, 1).toString());
				bedType.setText(model.getValueAt(i, 2).toString());
				tariff.setText(model.getValueAt(i, 3).toString());

				//File f = new File("assets//forms//bookedRooms.dat");
				File selected=new File("assets//forms//selectedRoom.dat"); 
				String rName = roomNo.getText().toString();
				String rType = roomType.getText().toString();
				String bType = bedType.getText().toString();
				String tRff = tariff.getText().toString();
				//


				











				if (selected.exists()) {
					String dataToWrite = rName + "|" + rType + "|" + bType + "|" + tRff + "\n";

					try {
						/*FileWriter fileWriter = new FileWriter(selected,true);
						BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);*/
						FileWriter fileWriter1 = new FileWriter(selected,false);
						BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);

						/*bufferedWriter.write(dataToWrite);
						bufferedWriter.flush();
						bufferedWriter.close();*/
						bufferedWriter1.write(dataToWrite);
						bufferedWriter1.flush();
						bufferedWriter1.close();

					} catch (IOException ei) {
						ei.printStackTrace();
						JOptionPane.showMessageDialog(contentPane, "Unable to save data.", "Save Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (Exception ej) {
						JOptionPane.showMessageDialog(contentPane, "Unable to save  data.", "Save Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Unable to save  data.", "Save Error",
							JOptionPane.ERROR_MESSAGE);
				}

			}

		});


		dataRoomsAvailable = new Vector<Vector<String>>();
		try {
			File f = new File("assets/forms/rooms.txt");

			if (f.exists()) {
				Scanner scanner = new Scanner(f);
				while (scanner.hasNext()) {
					Vector<String> row = new Vector<>();

					String line = scanner.nextLine();
					String[] fields = line.split("[|]");
					String roomno = fields[0];
					if (!bookedroomsnos.contains(roomno)) {

						for (int i = 0; i < fields.length; i++) {
							row.add(fields[i]);
						}

						dataRoomsAvailable.add(row);
					}
				}
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		//DefaultTableModel model1 = new DefaultTableModel(dataRoomsAvailable, headers);

		setSize(800, 458);
		setResizable(true);
		setVisible(true);

	}
}
