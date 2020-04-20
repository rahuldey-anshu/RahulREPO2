package com.globsyn.hostel.management;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;


//import com.globsyn.wholesale.business.WholeSaleAppHome;

import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Enumeration;
import java.awt.event.KeyAdapter;
import java.awt.SystemColor;

public class NewSupplier extends JFrame {

	JFrame frmNewSupplier;
	private JPanel contentPane;
	private JTextField supplierName;
	private JTextField supplierPan;
	private JTextField supplierPin;


	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewSupplier frmNewSupplier = new NewSupplier();
					frmNewSupplier.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NewSupplier() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets\\icon17.png"));
		setTitle("Hostel Management Application");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 885, 620);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

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

			}
		});
		newSupplier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_MASK));
		mnRetailer.add(newSupplier);

		JMenuItem listSupplier = new JMenuItem("List");
		listSupplier.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mnRetailer.add(listSupplier);
		
		JMenu mnSupplier_1 = new JMenu("Room");
		menuBar.add(mnSupplier_1);
		
		JMenuItem mntmAllocate = new JMenuItem("Allocate");
		mntmAllocate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RoomsFinal frame = new RoomsFinal();
				frame.setVisible(true);
				dispose();
				}
		});
		mnSupplier_1.add(mntmAllocate);

		JSeparator separator1 = new JSeparator();
		mnSupplier_1.add(separator1);
		
		JMenuItem mntmBooked = new JMenuItem("Booked");
		mntmBooked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookedList frame = new BookedList();
				frame.setVisible(true);
				dispose();

			}
		});
		mnSupplier_1.add(mntmBooked);
		
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




		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(Color.BLACK);
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblAddNewRetailer = new JLabel("Add New Supplier");
		lblAddNewRetailer.setForeground(Color.WHITE);
		lblAddNewRetailer.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel.add(lblAddNewRetailer);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel lblPleaseEnterThe = new JLabel("Please enter the supplier details ");
		lblPleaseEnterThe.setForeground(new Color(250, 235, 215));
		lblPleaseEnterThe.setBounds(279, 11, 356, 21);
		lblPleaseEnterThe.setFont(new Font("Tahoma", Font.BOLD, 17));
		panel_1.add(lblPleaseEnterThe);

		JLabel lblRetailerName = new JLabel("Supplier Name");
		lblRetailerName.setForeground(new Color(250, 235, 215));
		lblRetailerName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRetailerName.setBounds(222, 84, 125, 21);
		panel_1.add(lblRetailerName);

		JLabel lblRetailerPanNumber = new JLabel("Supplier PAN Number");
		lblRetailerPanNumber.setForeground(new Color(250, 235, 215));
		lblRetailerPanNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRetailerPanNumber.setBounds(205, 131, 175, 21);
		panel_1.add(lblRetailerPanNumber);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 255), 2), UIManager.getBorder("CheckBoxMenuItem.border")), "SUPPLIER ADDRESS", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GREEN));
		panel_2.setBounds(256, 245, 406, 226);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblArea = new JLabel("Area");
		lblArea.setBounds(6, 32, 125, 21);
		panel_2.add(lblArea);
		lblArea.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblCity = new JLabel("City");
		lblCity.setBackground(new Color(255, 182, 193));
		lblCity.setBounds(6, 82, 125, 21);
		panel_2.add(lblCity);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblState = new JLabel("State");
		lblState.setBounds(6, 127, 125, 21);
		panel_2.add(lblState);
		lblState.setFont(new Font("Tahoma", Font.BOLD, 15));

		supplierPin = new JTextField();
		supplierPin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if((!Character.isDigit(c))||(supplierPin.getText().length()>=6)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))
				{
					e.consume();
				}
			}
		});
		supplierPin.setBounds(179, 180, 199, 20);
		panel_2.add(supplierPin);
		supplierPin.setColumns(10);

		JTextArea supplierArea = new JTextArea();
		supplierArea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(supplierArea.getText().length()>=50)
				{
					e.consume();
				}
			}
		});
		supplierArea.setBounds(179, 16, 199, 54);
		panel_2.add(supplierArea);



		JLabel label = new JLabel("PIN Code");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(6, 178, 125, 21);
		panel_2.add(label);

		supplierName = new JTextField();
		supplierName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if((Character.isDigit(c))||(supplierName.getText().length()>=20))
				{
					e.consume();
				}

			}
		});
		supplierName.setBounds(472, 86, 199, 20);
		panel_1.add(supplierName);
		supplierName.setColumns(10);

		supplierPan = new JTextField();
		supplierPan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(supplierPan.getText().length()>=10)
				{
					e.consume();
				}
				
			}
		});
		supplierPan.setColumns(10);
		supplierPan.setBounds(472, 133, 199, 20);
		panel_1.add(supplierPan);

		String[] cities = {"Hyderabad" ,"Itanagar","Dispur","Patna","Panaji","Gandhinagar","Chandigarh","Shimla","Srinagar ","Jammu","Bangalooru","Tirubanantapuram","Bhopal","Mumbai","Imphal","Shillong","Aizawl","Kohima","Bhubaneswar","Chandigarh","Jaipur","Gangtok","Chennai","Agartala","Lucknow","Kolkata","Raipur","Dehradun","Ranchi","Hyderabad","Howrah","Darjeeling","Kharagpur","Bardhaman","Asansol","Durgapur","Siliguri","Murshidabad","Raiganj","Purulia","Krishnanagar"};
		String[] states = {"Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujarat","Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand (JH)","Karnataka","Kerala","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};;
		JComboBox supplierCity = new JComboBox(cities);
		supplierCity.setBounds(179, 84, 117, 20);
		panel_2.add(supplierCity);
		String combo=(String)supplierCity.getSelectedItem();

		JComboBox supplierState = new JComboBox(states);
		supplierState.setBounds(179, 129, 117, 20);
		panel_2.add(supplierState);
		String combo1=(String)supplierState.getSelectedItem();
		JButton btnSave = new JButton("SAVE");
		JRadioButton supplierInd = new JRadioButton("Individual");
		buttonGroup.add(supplierInd);
		supplierInd.setFont(new Font("Tahoma", Font.BOLD, 14));
		supplierInd.setBounds(450, 177, 93, 23);
		panel_1.add(supplierInd);

		JRadioButton supplierCom = new JRadioButton("Company");
		buttonGroup.add(supplierCom);
		supplierCom.setFont(new Font("Tahoma", Font.BOLD, 15));
		supplierCom.setBounds(578, 177, 120, 23);
		panel_1.add(supplierCom);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rName = supplierName.getText().toString();
				String rPAN = supplierPan.getText().toString();
				String rType = null;
				if (supplierInd.isSelected()) {
					rType = "Individual";
				} else if (supplierCom.isSelected()) {
					rType = "Company";

				}


				String rArea = supplierArea.getText().toString();
				String rCity = supplierCity.getSelectedItem().toString();
				String rState =supplierState.getSelectedItem().toString();
				String rPin = supplierPin.getText().toString();
				if(rName!=null && rPAN!=null && rType!=null && rArea!=null && rCity!=null && rState!=null && rPin!=null)
				{
					File f = new File("assets//forms//Suppliers.dat");


					if (f.exists()) {
						String dataToWrite = rName + "|" + rPAN + "|" + rType + "|" + rArea + "|" + rCity + "|" + rState
								+ "|" + rPin + "\n";

						try {
							FileWriter fileWriter = new FileWriter(f,true);
							BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

							bufferedWriter.write(dataToWrite);
							bufferedWriter.flush();
							bufferedWriter.close();
							int yesNo = JOptionPane.showConfirmDialog(contentPane, "Supplier Data saved successfully.\n Do you want to add more????", "Supplier Confirmation!!!",
									JOptionPane.INFORMATION_MESSAGE);
							if(yesNo==JOptionPane.YES_OPTION){
								supplierArea.setText("");
								supplierName.setText("");
								supplierPan.setText("");
								supplierPin.setText("");

							}else if(yesNo==JOptionPane.CANCEL_OPTION){
								HomePage window = new HomePage();
								window.frmHomePage.setVisible(true);
								dispose();
							}else if(yesNo==JOptionPane.NO_OPTION){
								HomePage window = new HomePage();
								window.frmHomePage.setVisible(true);
								dispose();
							}
						} catch (IOException e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(contentPane, "Unable to save retailer data.", "Save Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(contentPane, "Unable to save retailer data.", "Save Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(contentPane, "Unable to save retailer data.", "Save Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				
				else
				{JOptionPane.showMessageDialog(contentPane, "Please enter all details!", "Error",
						JOptionPane.ERROR_MESSAGE);}
			}
			
		});


		btnSave.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSave.setBounds(331, 482, 89, 23);
		panel_1.add(btnSave);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				supplierArea.setText("");
				supplierName.setText("");
				supplierPan.setText("");
				supplierPin.setText("");
				buttonGroup.clearSelection();

			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCancel.setBounds(508, 482, 111, 23);
		panel_1.add(btnCancel);

		JLabel lblRetailerType = new JLabel("Supplier Type");
		lblRetailerType.setForeground(new Color(250, 235, 215));
		lblRetailerType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRetailerType.setBounds(222, 178, 125, 21);
		panel_1.add(lblRetailerType);
		
		JLabel background = new JLabel(new ImageIcon("assets//handshake.jpg"));
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		background.setBounds(0,0,d.width,d.height);
		//background.setBounds(0, 0, 472, 515);
		background.setLayout(new FlowLayout());
		panel_1.add(background);


	}
}
