package com.globsyn.project;

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
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PrintBill extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;

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
		
		JLabel label = new JLabel("Enter customer details.....");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Lucida Fax", Font.BOLD, 18));
		label.setBounds(128, 0, 328, 42);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setForeground(new Color(51, 0, 153));
		label_1.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		label_1.setBounds(15, 55, 74, 29);
		panel.add(label_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		textField.setColumns(10);
		textField.setBounds(112, 55, 344, 33);
		panel.add(textField);
		
		JLabel label_3 = new JLabel("Address:");
		label_3.setForeground(new Color(51, 0, 153));
		label_3.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		label_3.setBounds(15, 110, 87, 20);
		panel.add(label_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		textArea.setBounds(112, 108, 344, 129);
		panel.add(textArea);
		
		JLabel label_5 = new JLabel("Pin Code:");
		label_5.setForeground(new Color(51, 0, 153));
		label_5.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		label_5.setBounds(493, 60, 87, 20);
		panel.add(label_5);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(605, 55, 148, 30);
		panel.add(textField_3);
		
		JLabel label_6 = new JLabel("Contact No:");
		label_6.setForeground(new Color(51, 0, 153));
		label_6.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		label_6.setBounds(493, 106, 107, 29);
		panel.add(label_6);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(605, 106, 227, 29);
		panel.add(textField_4);
		
		JButton button = new JButton("Print receipt");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button.setBackground(new Color(51, 153, 255));
		button.setBounds(695, 559, 159, 42);
		panel.add(button);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Order order= new Order();
				order.setVisible(true);
				dispose();
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button_1.setBackground(new Color(51, 153, 255));
		button_1.setBounds(695, 612, 159, 41);
		panel.add(button_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PrintBill.class.getResource("/assets/wallpaper1.jpg")));
		lblNewLabel.setBounds(0, 0, 884, 685);
		contentPane.add(lblNewLabel);
	}

}
