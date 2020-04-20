package com.globsyn.prepaidtaxibooking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.io.*;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.ImageIcon;
public class NewDestination extends JFrame {

	private JPanel contentPane;
	private JTextField destination;
	private JTextField rate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewDestination frame = new NewDestination();
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
	public NewDestination() {
		setType(Type.POPUP);
		setIconImage(Toolkit.getDefaultToolkit().getImage(NewDestination.class.getResource("/images/icon.jpg")));
		
		setTitle("Add Destination");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 0));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		JLabel lblPleaseEnterThe = new JLabel("Please enter the destination details ");
		lblPleaseEnterThe.setForeground(Color.ORANGE);
		lblPleaseEnterThe.setBounds(116, 0, 474, 21);
		lblPleaseEnterThe.setFont(new Font("Old English Text MT", Font.BOLD, 25));
		panel_1.add(lblPleaseEnterThe);

		JLabel lblDestination = new JLabel("DESTINATION");
		lblDestination.setForeground(Color.ORANGE);
		lblDestination.setFont(new Font("SimSun", Font.BOLD, 20));
		lblDestination.setBounds(49, 84, 125, 21);
		panel_1.add(lblDestination);

		JLabel lblRate = new JLabel("RATE");
		lblRate.setForeground(Color.ORANGE);
		lblRate.setFont(new Font("SimSun", Font.BOLD, 20));
		lblRate.setBounds(49, 131, 160, 21);
		panel_1.add(lblRate);

		destination = new JTextField();
		destination.setBounds(222, 86, 199, 20);
		panel_1.add(destination);
		destination.setColumns(10);

		rate = new JTextField();
		rate.setColumns(10);
		rate.setBounds(222, 133, 199, 20);
		panel_1.add(rate);

		JButton btnSave = new JButton("SAVE");
		btnSave.setBackground(Color.BLACK);
		btnSave.setForeground(Color.ORANGE);

		btnSave.setFont(new Font("Georgia", Font.BOLD, 16));
		btnSave.setBounds(84, 210, 89, 23);
		panel_1.add(btnSave);

		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setForeground(Color.ORANGE);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setFont(new Font("Georgia", Font.BOLD, 16));
		btnCancel.setBounds(283, 210, 111, 23);
		panel_1.add(btnCancel);

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				File f = new File("assets/data/Destinationdb.dat");

				String cDestination = destination.getText().toString();
				String cRate = rate.getText().toString();
				if (f.exists()) {
					String dataToWrite = "\n"+cDestination + "|" + cRate ;

					try {
						FileWriter fileWriter = new FileWriter(f,true);
						BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

						bufferedWriter.write(dataToWrite);
						bufferedWriter.flush();
						bufferedWriter.close();
						int yesNo = JOptionPane.showConfirmDialog(contentPane, "Destination Data saved successfully.\n Do you want to add more????", "Retailer Confirmation!!!",
								JOptionPane.INFORMATION_MESSAGE);
						if(yesNo==JOptionPane.YES_OPTION){
							destination.setText("");
							rate.setText("");
						}/*else if(yesNo==JOptionPane.CANCEL_OPTION){
							DestinationList dL = new  DestinationList();
							dL.setVisible(true);
							dispose();
						}*/else if(yesNo==JOptionPane.NO_OPTION){
							dispose();
						}
					} catch (IOException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(contentPane, "Unable to save data.", "Save Error",
								JOptionPane.ERROR_MESSAGE);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(contentPane, "Unable to save data.", "Save Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(contentPane, "Unable to save  data.", "Save Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
