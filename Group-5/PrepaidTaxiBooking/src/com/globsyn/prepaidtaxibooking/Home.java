package com.globsyn.prepaidtaxibooking;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;

public class Home {

	private JFrame frmHomePage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHomePage = new JFrame();
		frmHomePage.setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/images/icon.jpg")));
		frmHomePage.setTitle("Home");
		frmHomePage.setBounds(0, 0, 800, 500);
		frmHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHomePage.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("LOGOUT");
		btnNewButton.setForeground(Color.ORANGE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login l=new Login();
				l.setVisible(true);
				frmHomePage.dispose();
			}
		});
		btnNewButton.setBounds(657, 439, 127, 23);
		frmHomePage.getContentPane().add(btnNewButton);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setBounds(0, 0, 784, 21);
		frmHomePage.getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("NEW");
		mnNewMenu.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("BOOKING");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Booking b1=new Booking();
				b1.setVisible(true);
				frmHomePage.dispose();
			}
		});
		mntmNewMenuItem.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem);
		KeyStroke ctrlB = KeyStroke.getKeyStroke(KeyEvent.VK_B, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());
		mntmNewMenuItem.setAccelerator(ctrlB);
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("DESTINATION");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DestinationList dL=new DestinationList();
				dL.setVisible(true);
				NewDestination nDL=new NewDestination();
				nDL.setVisible(true);
				frmHomePage.dispose();
			}
		});
		KeyStroke ctrlD = KeyStroke.getKeyStroke(KeyEvent.VK_D, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());
		mntmNewMenuItem_2.setAccelerator(ctrlD);
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		mntmNewMenuItem_2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("DRIVER");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DriverList driver=new DriverList();
				driver.setVisible(true);
				AddCar aDC=new AddCar();
				aDC.setVisible(true);
				frmHomePage.dispose();
			}
		});
		KeyStroke ctrlT = KeyStroke.getKeyStroke(KeyEvent.VK_T, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());
		mntmNewMenuItem_5.setAccelerator(ctrlT);
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		mntmNewMenuItem_5.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_3 = new JMenu(" LIST");
		mnNewMenu_3.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("DRIVER LIST");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DriverList dL=new DriverList();
				dL.setVisible(true);
				frmHomePage.dispose();
			}
		});
		mntmNewMenuItem_3.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("RATE CHART");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DestinationList dList=new DestinationList();
				dList.setVisible(true);
				frmHomePage.dispose();
				
			}
		});
		
		JSeparator separator_2 = new JSeparator();
		mnNewMenu_3.add(separator_2);
		mntmNewMenuItem_4.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("CUSTOMER DATABASE");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerList customer=new CustomerList();
				customer.setVisible(true);
				frmHomePage.dispose();
			}
		});
		
		JSeparator separator_3 = new JSeparator();
		mnNewMenu_3.add(separator_3);
		mntmNewMenuItem_1.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		mnNewMenu_3.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_2 = new JMenu("RETURN");
		mnNewMenu_2.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 18));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("HOME");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home home=new Home();
				home.setVisible(true);
				frmHomePage.dispose();
			}
		});
		mntmNewMenuItem_7.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 16));
		mnNewMenu_2.add(mntmNewMenuItem_7);
		KeyStroke ctrlH = KeyStroke.getKeyStroke(KeyEvent.VK_H, Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask());
		mntmNewMenuItem_7.setAccelerator(ctrlH);
		JLabel lblNewLabel_1 = new JLabel("ZENO TAXI BOOKING\r\n");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Old English Text MT", Font.BOLD, 40));
		lblNewLabel_1.setBounds(115, 110, 721, 54);
		frmHomePage.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/images/taxifleet.jpg")));
		
		lblNewLabel.setBounds(0, 21, 884, 451);
		frmHomePage.getContentPane().add(lblNewLabel);
		
		JMenuItem menuItem = new JMenuItem("");
		menuItem.setBounds(10, 68, 129, 22);
		frmHomePage.getContentPane().add(menuItem);
	}

	public void setVisible(boolean b) {
		
		frmHomePage.setVisible(b);
		// TODO Auto-generated method stub
		
	}
}
