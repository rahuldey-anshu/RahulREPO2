package com.globsyn.hostel.management;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

public class HomePage {

	JFrame frmHomePage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frmHomePage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHomePage = new JFrame();
		frmHomePage.setTitle("Hostel Management Application");
		frmHomePage.setIconImage(Toolkit.getDefaultToolkit().getImage("assets\\icon17.png"));
		frmHomePage.setBounds(100, 100, 932, 774);
		frmHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomePage.getContentPane().setLayout(null);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(0, 0, 936, 47);
		frmHomePage.getContentPane().add(panel);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 480, 784, 1);
		panel_1.setBackground(Color.BLACK);
		frmHomePage.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		//JPanel panel = new JPanel());
		
		
		final JLabel lblWholeSaleApplication = new JLabel("Welcome to Hostel Management Application Homepage"
				+ "");
		lblWholeSaleApplication.setForeground(new Color(230, 230, 250));
		lblWholeSaleApplication.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblWholeSaleApplication.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblWholeSaleApplication);
		
		JLabel background = new JLabel(new ImageIcon("assets\\hostelHome.png"));
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		background.setBounds(0,0,d.width,d.height);
		frmHomePage.getContentPane().add(background);
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		frmHomePage.setJMenuBar(menuBar);
		
		JMenu mnNew = new JMenu("Student");
		menuBar.add(mnNew);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.ALT_MASK));
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentDetails window = new StudentDetails();
				window.frmStudentDetails.setVisible(true);			
			frmHomePage.dispose();}
		});
		
		mnNew.add(mntmNew);
		
		JSeparator separator_2 = new JSeparator();
		mnNew.add(separator_2);
		
		JMenuItem mntmList = new JMenuItem("List");
		mntmList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentList studentList = new StudentList();
				studentList.setVisible(true);
				frmHomePage.dispose();}
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
			frmHomePage.dispose();
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
				frmHomePage.dispose();
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
				frmHomePage.dispose();
			}
		});
		mnRoom.add(mntmAllocateRoom);
		
		JSeparator separator = new JSeparator();
		mnRoom.add(separator);
		
		JMenuItem mntmBooked = new JMenuItem("Booked");
		mntmBooked.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookedList frame = new BookedList();
				frame.setVisible(true);
				frmHomePage.dispose();

			}
		});
		mnRoom.add(mntmBooked);
		
		JMenu mnLogout = new JMenu("Logout");
		menuBar.add(mnLogout);
		
		JMenuItem mntmConfirm = new JMenuItem("Confirm");
		mntmConfirm.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, InputEvent.ALT_MASK));
		mntmConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HostelAppLogin window = new HostelAppLogin();
				window.frmHostelAppLogin.setVisible(true);
				frmHomePage.dispose();}
		});
		mnLogout.add(mntmConfirm);
		
		/*JMenu mnSearch = new JMenu("Search/Delete");
		menuBar.add(mnSearch);
		
		JMenuItem mntmStudent = new JMenuItem("Student");
		mnSearch.add(mntmStudent);
		
		JSeparator separator = new JSeparator();
		mnSearch.add(separator);
		
		JMenuItem mntmSupplier = new JMenuItem("Supplier");
		mnSearch.add(mntmSupplier);*/
	}
}
