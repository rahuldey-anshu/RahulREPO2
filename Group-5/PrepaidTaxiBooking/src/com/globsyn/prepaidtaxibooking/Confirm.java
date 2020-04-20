package com.globsyn.prepaidtaxibooking;

import java.awt.EventQueue;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Confirm {

	private JFrame frmConfirmBooking;

	/**
	 * Launch the application.
	 */
	public static void main(String args[]) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Confirm window = new Confirm();
					window.frmConfirmBooking.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Confirm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConfirmBooking = new JFrame();
		frmConfirmBooking.setTitle("CONFIRM BOOKING");
		frmConfirmBooking
				.setIconImage(Toolkit.getDefaultToolkit().getImage(Confirm.class.getResource("/images/icon.jpg")));
		frmConfirmBooking.setBounds(0, 0, 800, 500);
		frmConfirmBooking.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConfirmBooking.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("DATE:");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel.setBounds(23, 35, 59, 15);
		frmConfirmBooking.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("CUSTOMER NAME:");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_1.setBounds(23, 73, 159, 14);
		frmConfirmBooking.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("NO. OF PASSENGERS:");
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_3.setBounds(450, 123, 191, 15);
		frmConfirmBooking.getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("DESTINATION:");
		lblNewLabel_4.setForeground(Color.ORANGE);
		lblNewLabel_4.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_4.setBounds(23, 123, 126, 14);
		frmConfirmBooking.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("DRIVER NAME:");
		lblNewLabel_5.setForeground(Color.ORANGE);
		lblNewLabel_5.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_5.setBounds(23, 175, 136, 14);
		frmConfirmBooking.getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("DRIVER PHONE NO:");
		lblNewLabel_6.setForeground(Color.ORANGE);
		lblNewLabel_6.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_6.setBounds(450, 175, 179, 14);
		frmConfirmBooking.getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("DRIVER LICENCE:");
		lblNewLabel_7.setForeground(Color.ORANGE);
		lblNewLabel_7.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_7.setBounds(23, 223, 159, 14);
		frmConfirmBooking.getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("CAR DETAILS:");
		lblNewLabel_8.setForeground(Color.ORANGE);
		lblNewLabel_8.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_8.setBounds(450, 223, 152, 14);
		frmConfirmBooking.getContentPane().add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("CAR NO:");
		lblNewLabel_9.setForeground(Color.ORANGE);
		lblNewLabel_9.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_9.setBounds(23, 273, 85, 14);
		frmConfirmBooking.getContentPane().add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("AMOUNT:");
		lblNewLabel_10.setForeground(Color.ORANGE);
		lblNewLabel_10.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_10.setBounds(23, 343, 105, 14);
		frmConfirmBooking.getContentPane().add(lblNewLabel_10);
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		String d = dateFormat.format(date);
		JLabel lblNewLabel_11 = new JLabel(d);
		lblNewLabel_11.setForeground(Color.ORANGE);
		lblNewLabel_11.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_11.setBounds(120, 35, 179, 14);
		frmConfirmBooking.getContentPane().add(lblNewLabel_11);

		ArrayList<String> customername = new ArrayList<>();
		ArrayList<String> contact = new ArrayList<>();
		ArrayList<String> dest = new ArrayList<>();
		ArrayList<String> passengerno = new ArrayList<>();
		ArrayList<String> cartype = new ArrayList<>();
		ArrayList<String> carname = new ArrayList<>();
		ArrayList<String> carno = new ArrayList<>();
		ArrayList<String> drivername = new ArrayList<>();
		ArrayList<String> driverlisence = new ArrayList<>();
		ArrayList<String> driverph = new ArrayList<>();
		String d1 = null;
		String ac=null;
		try {
			File de = new File("assets/data/Customer.dat");

			if (de.exists()) {
				Scanner scanner = new Scanner(de);
				while (scanner.hasNext()) {
					String line = scanner.nextLine();
					String[] fields = line.split("[|]");
					customername.add(fields[0]);
					contact.add(fields[1]);
					dest.add(fields[2]);
					d1 = fields[2];
					passengerno.add(fields[3]);
					cartype.add(fields[4]);
					ac=fields[4];
					carname.add(fields[5]);
					carno.add(fields[6]);
					drivername.add(fields[7]);
					driverlisence.add(fields[8]);
					driverph.add(fields[9]);

				}

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		JLabel lblNewLabel_12 = new JLabel();
		lblNewLabel_12.setForeground(Color.ORANGE);

		StringBuilder s1 = new StringBuilder();
		for (String i : customername) {
			s1.append(i == null ? "" : i.toString());
		}

		lblNewLabel_12.setText(s1.toString());
		lblNewLabel_12.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_12.setBounds(192, 73, 179, 15);
		frmConfirmBooking.getContentPane().add(lblNewLabel_12);

		JLabel lblNewLabel_2 = new JLabel("CONTACT NO:");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_2.setBounds(450, 73, 126, 15);
		frmConfirmBooking.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_13 = new JLabel();
		lblNewLabel_13.setForeground(Color.ORANGE);

		StringBuilder s2 = new StringBuilder();
		for (String i : contact) {
			s2.append(i == null ? "" : i.toString());
		}

		lblNewLabel_13.setText(s2.toString());
		lblNewLabel_13.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_13.setBounds(586, 73, 198, 14);
		frmConfirmBooking.getContentPane().add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel();
		lblNewLabel_14.setForeground(Color.ORANGE);
		StringBuilder s3 = new StringBuilder();
		for (String i : dest) {
			s3.append(i == null ? "" : i.toString());
		}

		lblNewLabel_14.setText(s3.toString());
		lblNewLabel_14.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_14.setBounds(156, 123, 176, 15);
		frmConfirmBooking.getContentPane().add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel();
		lblNewLabel_15.setForeground(Color.ORANGE);
		StringBuilder s4 = new StringBuilder();
		for (String i : passengerno) {
			s4.append(i == null ? "" : i.toString());
		}

		lblNewLabel_15.setText(s4.toString());
		lblNewLabel_15.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_15.setBounds(641, 123, 85, 14);
		frmConfirmBooking.getContentPane().add(lblNewLabel_15);

		JLabel lblNewLabel_16 = new JLabel();
		lblNewLabel_16.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_16.setForeground(Color.ORANGE);
		StringBuilder s5 = new StringBuilder();
		for (String i : drivername) {
			s5.append(i == null ? "" : i.toString());
		}

		lblNewLabel_16.setText(s5.toString());
		lblNewLabel_16.setBounds(182, 175, 120, 14);
		frmConfirmBooking.getContentPane().add(lblNewLabel_16);

		JLabel lblNewLabel_17 = new JLabel();
		lblNewLabel_17.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_17.setForeground(Color.ORANGE);
		StringBuilder s6 = new StringBuilder();
		for (String i : driverph) {
			s6.append(i == null ? "" : i.toString());
		}

		lblNewLabel_17.setText(s6.toString());
		lblNewLabel_17.setBounds(622, 177, 152, 14);
		frmConfirmBooking.getContentPane().add(lblNewLabel_17);

		JLabel lblNewLabel_18 = new JLabel();
		lblNewLabel_18.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_18.setForeground(Color.ORANGE);
		StringBuilder s7 = new StringBuilder();
		for (String i : driverlisence) {
			s7.append(i == null ? "" : i.toString());
		}

		lblNewLabel_18.setText(s7.toString());
		lblNewLabel_18.setBounds(185, 223, 99, 14);
		frmConfirmBooking.getContentPane().add(lblNewLabel_18);

		JLabel lblNewLabel_19 = new JLabel();
		lblNewLabel_19.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_19.setForeground(Color.ORANGE);
		StringBuilder s8 = new StringBuilder();
		for (String i : carname) {
			s8.append(i == null ? "" : i.toString());
		}

		StringBuilder s11 = new StringBuilder();
		for (String i : cartype) {
			s11.append(i == null ? "" : i.toString());
		}

		lblNewLabel_19.setText(s8.toString() + " " + s11.toString());
		lblNewLabel_19.setBounds(575, 223, 105, 14);
		frmConfirmBooking.getContentPane().add(lblNewLabel_19);

		JLabel lblNewLabel_20 = new JLabel();
		lblNewLabel_20.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_20.setForeground(Color.ORANGE);
		StringBuilder s9 = new StringBuilder();
		for (String i : carno) {
			s9.append(i == null ? "" : i.toString());
		}

		lblNewLabel_20.setText(s9.toString());
		lblNewLabel_20.setBounds(120, 273, 120, 14);
		frmConfirmBooking.getContentPane().add(lblNewLabel_20);

		JLabel lblNewLabel_21 = new JLabel("New label");
		lblNewLabel_21.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_21.setForeground(Color.ORANGE);
		lblNewLabel_21.setBounds(138, 343, 72, 14);
		frmConfirmBooking.getContentPane().add(lblNewLabel_21);
		ArrayList<String> prise = new ArrayList<>();

		try {
			File f = new File("assets/data/Destinationdb.dat");

			if (f.exists()) {
				Scanner scanner = new Scanner(f);
				while (scanner.hasNext()) {
					String line = scanner.nextLine();
					String[] fields = line.split("[|]");
					if (d1.equals(fields[0]))	
					{if(ac.equals("AC"))
					{ String rate=fields[1];
					int number = Integer.parseInt(rate)+100;
					String numberAsString = Integer.toString(number);
						fields[1]=numberAsString;
						prise.add(fields[1]);
					}
					else
						prise.add(fields[1]);
				}
			}
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		StringBuilder s10 = new StringBuilder();
		for (String i : prise) {
			s10.append(i == null ? "" : i.toString());
		}
		lblNewLabel_21.setText(s10.toString());
		System.out.println(lblNewLabel_12.getText());

		JButton btnNewButton = new JButton("CONFIRM");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.ORANGE);
		btnNewButton.setFont(new Font("Georgia", Font.BOLD, 15));
		btnNewButton.setBounds(192, 428, 166, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File f = new File("assets/data/Bookingdetails.dat");
				FileWriter fr = null;
				BufferedWriter bw = null;
				try {
					fr = new FileWriter(f, true);

					bw = new BufferedWriter(fr);
					bw.write(lblNewLabel_11.getText() + "|" + lblNewLabel_12.getText() + "|" + lblNewLabel_13.getText()
							+ "|" + lblNewLabel_14.getText() + "|" + lblNewLabel_15.getText() + "|"
							+ lblNewLabel_16.getText() + "|" + lblNewLabel_18.getText() + "|" + lblNewLabel_17.getText()
							+ "|" + lblNewLabel_19.getText() + "|" + lblNewLabel_20.getText() + "|"
							+ lblNewLabel_21.getText() +"\n");

					bw.close();
				} catch (Exception e) {
					e.printStackTrace();
				}

				JOptionPane.showMessageDialog(null, "Cab Booking Successful");
				Home hp = new Home();
				hp.setVisible(true);
				frmConfirmBooking.dispose();

			}
		});
		frmConfirmBooking.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.setForeground(Color.ORANGE);
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Home h2 = new Home();
				h2.setVisible(true);
				frmConfirmBooking.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Georgia", Font.BOLD, 15));
		btnNewButton_1.setBounds(450, 428, 169, 23);
		frmConfirmBooking.getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setFont(new Font("SimSun", Font.BOLD, 17));
		lblNewLabel_22.setIcon(new ImageIcon(Confirm.class.getResource("/images/TaxiHood.jpg")));
		lblNewLabel_22.setBounds(0, 0, 784, 472);
		frmConfirmBooking.getContentPane().add(lblNewLabel_22);
	}

	public void setVisible(boolean b) {
		frmConfirmBooking.setVisible(b);

	}
}
