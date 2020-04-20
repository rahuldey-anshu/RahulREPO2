package com.globsyn.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Order extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Order frame = new Order();
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
	public Order() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 887,724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(10, 16, 864, 654);
		contentPane.add(panel);
		
		JButton button = new JButton("Add to cart");
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button.setBackground(new Color(102, 153, 255));
		button.setBounds(496, 80, 175, 34);
		panel.add(button);
		
		JButton button_1 = new JButton("Print");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrintBill printBill= new PrintBill();
				printBill.setVisible(true);;
				dispose();
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button_1.setBackground(new Color(102, 153, 255));
		button_1.setBounds(746, 532, 108, 34);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Back");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage home= new HomePage();
				home.setVisible(true);
				dispose();
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button_2.setBackground(new Color(102, 153, 255));
		button_2.setBounds(746, 599, 108, 34);
		panel.add(button_2);
		
		JLabel label = new JLabel("Product name :");
		label.setForeground(new Color(51, 0, 153));
		label.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label.setBounds(102, 25, 145, 34);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Enter quantity :");
		label_1.setForeground(new Color(51, 0, 153));
		label_1.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_1.setBounds(102, 83, 155, 28);
		panel.add(label_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		comboBox.setBounds(257, 29, 217, 28);
		panel.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		comboBox_1.setBounds(257, 83, 107, 28);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Order.class.getResource("/assets/wallpaper1.jpg")));
		lblNewLabel.setBounds(0,0,884,695);
		contentPane.add(lblNewLabel);
	}

}
