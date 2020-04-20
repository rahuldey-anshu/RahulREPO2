package com.globsyn.wholesalebusiness;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class NewUser extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNewName;
	private JTextField textFieldNewEmail;
	private JTextField textFieldNewPhone;
	private JTextField textFieldNewPAN;
	private JTextField textFieldNewAddress;
	private JTextField textFieldNewCity;
	private JTextField textFieldNewPin;
	private JPasswordField passwordField;
	private JPasswordField RepasswordField_1;
	private String stateList[] = { "---SELECT---", "HIMACHAL PRADESH", "DELHI", "PUNJAB", "JHARKHAND", "BIHAR",
			"WEST BENGAL", "UTTARAKHAND", "UTTAR PRADESH", "MADHYA PRADESH", "GUJRAT", "KARNATAKA", "KERALA",
			"TAMIL NADU", "TELENGANA" };
	private String countryName[] = { "---SELECT---", "NEPAL", "CHINA", "BANGLADESH", "INDIA", "MYANMAR", "SRI LANKA" };

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewUser frame = new NewUser();
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
	public NewUser() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("icons//diamond-icon.png"));
		setTitle("New user log in");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 205));
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Personal details",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(43, 77, 246, 174);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblName.setBounds(6, 16, 109, 23);
		panel.add(lblName);

		JLabel lblEmailId = new JLabel("Email id :");
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmailId.setBounds(6, 51, 109, 23);
		panel.add(lblEmailId);

		JLabel lblPhoneNo = new JLabel("Phone number :");
		lblPhoneNo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPhoneNo.setBounds(6, 85, 109, 23);
		panel.add(lblPhoneNo);

		JLabel lblPanNumber = new JLabel("PAN number :");
		lblPanNumber.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPanNumber.setBounds(6, 127, 109, 23);
		panel.add(lblPanNumber);

		textFieldNewName = new JTextField();
		textFieldNewName.setBounds(125, 17, 111, 20);
		panel.add(textFieldNewName);
		textFieldNewName.setColumns(10);

		textFieldNewEmail = new JTextField();
		textFieldNewEmail.setBounds(125, 52, 111, 20);
		panel.add(textFieldNewEmail);
		textFieldNewEmail.setColumns(10);

		textFieldNewPhone = new JTextField();
		textFieldNewPhone.setBounds(125, 86, 111, 20);
		panel.add(textFieldNewPhone);
		textFieldNewPhone.setColumns(10);

		textFieldNewPAN = new JTextField();
		textFieldNewPAN.setBounds(125, 128, 111, 20);
		panel.add(textFieldNewPAN);
		textFieldNewPAN.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 250, 205));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mailing details",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(313, 78, 251, 171);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAddress.setBounds(6, 16, 100, 23);
		panel_1.add(lblAddress);

		JLabel lblCity = new JLabel("City :");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCity.setBounds(6, 64, 100, 14);
		panel_1.add(lblCity);

		JLabel lblPinCode = new JLabel("Pin code :");
		lblPinCode.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPinCode.setBounds(6, 89, 100, 14);
		panel_1.add(lblPinCode);

		JLabel lblState = new JLabel("State :");
		lblState.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblState.setBounds(6, 114, 100, 14);
		panel_1.add(lblState);

		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCountry.setBounds(6, 139, 100, 14);
		panel_1.add(lblCountry);

		textFieldNewAddress = new JTextField();
		textFieldNewAddress.setBounds(116, 11, 125, 33);
		panel_1.add(textFieldNewAddress);
		textFieldNewAddress.setColumns(10);

		textFieldNewCity = new JTextField();
		textFieldNewCity.setBounds(116, 61, 125, 20);
		panel_1.add(textFieldNewCity);
		textFieldNewCity.setColumns(10);

		textFieldNewPin = new JTextField();
		textFieldNewPin.setBounds(116, 86, 125, 20);
		panel_1.add(textFieldNewPin);
		textFieldNewPin.setColumns(10);

		JComboBox comboBoxState = new JComboBox(stateList);
		comboBoxState.setBounds(116, 111, 125, 20);
		panel_1.add(comboBoxState);

		JComboBox comboBoxCountry = new JComboBox(countryName);
		comboBoxCountry.setBounds(116, 136, 125, 20);
		panel_1.add(comboBoxCountry);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 250, 205));
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Set password",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(159, 264, 271, 87);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblEnterPassword = new JLabel("Enter password :");
		lblEnterPassword.setBounds(6, 25, 114, 14);
		panel_3.add(lblEnterPassword);
		lblEnterPassword.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblReeterPassword = new JLabel("Confirm password :");
		lblReeterPassword.setBounds(6, 61, 114, 14);
		panel_3.add(lblReeterPassword);
		lblReeterPassword.setFont(new Font("Tahoma", Font.BOLD, 11));

		passwordField = new JPasswordField();
		passwordField.setBounds(140, 16, 125, 23);
		panel_3.add(passwordField);

		RepasswordField_1 = new JPasswordField();
		RepasswordField_1.setBounds(140, 57, 125, 23);
		panel_3.add(RepasswordField_1);

		JButton btnSave = new JButton("Save");
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = new File("database/user.dat");

				String nName = textFieldNewName.getText().toString();
				String nEmail = textFieldNewEmail.getText().toString();
				String nPhone = textFieldNewPhone.getText().toString();
				String nPAN = textFieldNewPAN.getText().toString();
				String nAddress = textFieldNewAddress.getText().toString();
				String nCity = textFieldNewCity.getText().toString();
				String nPin = textFieldNewPin.getText().toString();
				String nState = comboBoxState.getSelectedItem().toString();
				String nCountry = comboBoxCountry.getSelectedItem().toString();
				String name[] = nName.split("[ ]");
				String userName = name[0];
				String nPass = passwordField.getText().toString();
				String nRePass = RepasswordField_1.getText().toString();
				if (!(nPass.equals(nRePass))) {
					JOptionPane.showMessageDialog(contentPane, "Passwords does not match...Please enter again.",
							"Save Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{

				if (nName != null && nEmail != null && nPhone != null && nPAN != null && nAddress != null
						&& nCity != null && nPin != null && !"".equals(nName.trim()) && !"".equals(nEmail.trim())
						&& !"".equals(nPhone.trim()) && !"".equals(nPAN.trim()) && !"".equals(nAddress.trim())
						&& !"".equals(nCity.trim()) && !"".equals(nPin.trim())&&!(nState.equals("---SELECT---"))&&!(nCountry.equals("---SELECT---"))) {
					
					if (f.exists()) {
						String dataToWrite = userName + "|" + nRePass + "|" + nEmail + "|" + nPhone + "|" + nPAN + "|"
								+ nAddress + "|" + nCity + "|" + nPin + "|" + nState + "|" + nCountry + "\n";

						try {
							FileWriter fw = new FileWriter(f, true);
							BufferedWriter bw = new BufferedWriter(fw);

							bw.write(dataToWrite);
							bw.flush();
							bw.close();
							int yesNo = JOptionPane.showConfirmDialog(contentPane, "Do you want to add more to it??",
									"User Confirmation!!!", JOptionPane.INFORMATION_MESSAGE);

							if (yesNo == JOptionPane.YES_OPTION) {
								textFieldNewName.setText("");
								textFieldNewEmail.setText("");
								textFieldNewPhone.setText("");
								textFieldNewPAN.setText("");
								textFieldNewAddress.setText("");
								textFieldNewCity.setText("");
								textFieldNewPin.setText("");
								passwordField.setText("");
								RepasswordField_1.setText("");

							} else if (yesNo == JOptionPane.CANCEL_OPTION) {

								dispose();

							} else if (yesNo == JOptionPane.NO_OPTION) {

								dispose();
								JOptionPane.showMessageDialog(null,
										"Welcome " + nName + " Your username is :" + userName);
							}
						} catch (IOException e1) {
							e1.printStackTrace();
							JOptionPane.showMessageDialog(contentPane, "Unable to save new user data.", "Save Error",
									JOptionPane.ERROR_MESSAGE);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(contentPane, "Unable to save new user data.", "Save Error",
									JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(contentPane, "Unable to save new user data.", "Save Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Please, enter your credentials.","No Input",JOptionPane.ERROR_MESSAGE);
				}
				
				}
				
			}
		});
		btnSave.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnSave.setBounds(475, 375, 89, 42);
		contentPane.add(btnSave);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 250, 205));
		panel_2.setBounds(6, 11, 585, 42);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblPleaseEnterYour = new JLabel("Please enter your details below");
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPleaseEnterYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterYour.setBounds(94, 0, 404, 42);
		panel_2.add(lblPleaseEnterYour);

		JButton btnBack = new JButton("Cancel");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnBack.setBounds(22, 375, 89, 42);
		contentPane.add(btnBack);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("icons//blue.png"));
		label.setBounds(0, 0, 601, 428);
		contentPane.add(label);
	}
}
