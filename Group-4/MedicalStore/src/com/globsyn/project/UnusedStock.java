package com.globsyn.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class UnusedStock extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UnusedStock frame = new UnusedStock();
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
	public UnusedStock() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900,724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 52, 856, 529);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(248, 248, 255));
		tabbedPane.addTab("Damaged medicines", null, panel_1, null);
		
		JLabel label_3 = new JLabel("Medicine category :");
		label_3.setForeground(new Color(51, 0, 153));
		label_3.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_3.setBounds(207, 34, 178, 20);
		panel_1.add(label_3);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		comboBox_3.setBackground(Color.WHITE);
		comboBox_3.setBounds(395, 30, 254, 28);
		panel_1.add(comboBox_3);
		
		JLabel label_4 = new JLabel("Medicine name :");
		label_4.setForeground(new Color(51, 0, 153));
		label_4.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_4.setBounds(207, 73, 178, 20);
		panel_1.add(label_4);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		comboBox_4.setBackground(Color.WHITE);
		comboBox_4.setBounds(395, 69, 254, 28);
		panel_1.add(comboBox_4);
		
		JLabel label_5 = new JLabel("Supplier name :");
		label_5.setForeground(new Color(51, 0, 153));
		label_5.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_5.setBounds(207, 112, 178, 20);
		panel_1.add(label_5);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		comboBox_5.setBackground(Color.WHITE);
		comboBox_5.setBounds(395, 108, 254, 28);
		panel_1.add(comboBox_5);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Expired medicines", null, panel, null);
		panel.setLayout(null);
		panel.setBackground(new Color(248, 248, 255));
		
		JLabel label = new JLabel("Medicine category :");
		label.setForeground(new Color(51, 0, 153));
		label.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label.setBounds(207, 34, 178, 20);
		panel.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(395, 30, 254, 28);
		panel.add(comboBox);
		
		JLabel label_1 = new JLabel("Medicine name :");
		label_1.setForeground(new Color(51, 0, 153));
		label_1.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_1.setBounds(207, 73, 178, 20);
		panel.add(label_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(395, 69, 254, 28);
		panel.add(comboBox_1);
		
		JLabel label_2 = new JLabel("Supplier name :");
		label_2.setForeground(new Color(51, 0, 153));
		label_2.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_2.setBounds(207, 112, 178, 20);
		panel.add(label_2);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		comboBox_2.setBackground(Color.WHITE);
		comboBox_2.setBounds(395, 108, 254, 28);
		panel.add(comboBox_2);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage home= new HomePage();
				home.setVisible(true);
				dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button.setBackground(new Color(102, 153, 255));
		button.setBounds(729, 619, 133, 38);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("assets/images/wallpaper1.jpg"));
		lblNewLabel.setBounds(0, 0, 884, 685);
		contentPane.add(lblNewLabel);
	}

}
