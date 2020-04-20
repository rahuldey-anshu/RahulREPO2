package com.globsyn.ticket.book;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.Vector;

import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JCheckBox;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;


public class MovieDetail3 extends JFrame {
	public String dt1;
	public String dt2;
	private JPanel contentPane;
	private JTextField textField3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieDetail3 frame = new MovieDetail3();
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
	public MovieDetail3() {
		setTitle("IMAX");
		setBackground(Color.BLACK);
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets\\images\\imax_icon.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ButtonGroup bg=new ButtonGroup();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(24, 98, 178, 99);
		contentPane.add(panel);
		
		JRadioButton morning = new JRadioButton("MORNING   12:45");
		morning.setBackground(new Color(222, 184, 135));
		morning.setForeground(new Color(0, 0, 0));
		morning.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		panel.add(morning);
		
		JRadioButton afternoon = new JRadioButton("AFTERNOON  3:45");
		afternoon.setBackground(new Color(222, 184, 135));
		afternoon.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		panel.add(afternoon);
		
		JRadioButton evening = new JRadioButton("EVENING  8:45");
		evening.setBackground(new Color(222, 184, 135));
		evening.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		panel.add(evening);
		
		JLabel label = new JLabel("TIMING");
		label.setForeground(new Color(240, 230, 140));
		label.setFont(new Font("Agency FB", Font.BOLD, 30));
		label.setBounds(10, 51, 73, 36);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("FOOD");
		label_2.setForeground(new Color(240, 230, 140));
		label_2.setFont(new Font("Agency FB", Font.BOLD, 30));
		label_2.setBounds(236, 51, 58, 36);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("CHOOSE DATE\r\n");
		label_3.setForeground(new Color(240, 230, 140));
		label_3.setFont(new Font("Agency FB", Font.BOLD, 30));
		label_3.setBounds(34, 208, 139, 29);
		contentPane.add(label_3);
		
		JDateChooser date = new JDateChooser();
		date.setBackground(new Color(222, 184, 135));
		date.setBounds(191, 208, 178, 29);
		contentPane.add(date);
		
		textField3 = new JTextField();
		textField3.setForeground(new Color(0, 0, 205));
		textField3.setFont(new Font("Algerian", Font.PLAIN, 20));
		textField3.setHorizontalAlignment(SwingConstants.CENTER);
		textField3.setEditable(false);
		textField3.setBounds(137, 11, 232, 39);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		try
		{
		File f= new File("assets/data/movie3details.dat");
		if(f.exists())
		{
			@SuppressWarnings("resource")
			Scanner scanner= new Scanner(f);
			while(scanner.hasNext())
			{ 
				Vector<String> row= new Vector();
				String line= scanner.nextLine();
				String[] field=line.split("[|]");
				textField3.setText(field[0].toString());
				
				String dt1= field[1];
				String dt2= field[2];
				date.setMinSelectableDate(new Date(dt1));
				date.setMaxSelectableDate(new Date(dt2));
				
				
			}
		}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(222, 184, 135));
		panel_1.setBounds(225, 102, 254, 91);
		contentPane.add(panel_1);
		
		JRadioButton combo100 = new JRadioButton("SANDWICH & COLD DRINK- Rs.100");
		combo100.setBackground(new Color(222, 184, 135));
		combo100.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		panel_1.add(combo100);
		
		JRadioButton combo80 = new JRadioButton("POPCORN & COLD DRINK- Rs.80");
		combo80.setBackground(new Color(222, 184, 135));
		combo80.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		panel_1.add(combo80);
		
		JRadioButton combo150 = new JRadioButton("COMBO BOX- Rs.150");
		combo150.setBackground(new Color(222, 184, 135));
		combo150.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		panel_1.add(combo150);
		JButton button = new JButton("BOOK SEAT");
		button.addActionListener(new ActionListener() {
			private DateFormat dateFormat;
			public void actionPerformed(ActionEvent arg0) {
				

                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				
				File f= new File("assets/data/ticketinfo.dat");
				
				String name= textField3.getText().toString();
				String date1 = df.format(date.getDate());
				String time= null;
				String food= null;
				
				
				if(morning.isSelected())
				{
					 time= "11:45";
				}
				else if(afternoon.isSelected())
				{
			         time= "2:45";	
				}
				else if(evening.isSelected())
				{
				    time= "7:45";
				}
				
				if(combo100.isSelected())
				{
					food= "100";
				}
						
				else if(combo80.isSelected())
				{
					food= "80";
				}
				
				else if(combo150.isSelected())
				{
					food= "150";
				}
						
				if(f.exists())	{
					String dataToWrite= name + "|" + date1 + "|" + time + "|" + food ; 
				                
				
				try       {
					FileWriter fileWriter = new FileWriter(f);
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
					bufferedWriter.write(dataToWrite);
					bufferedWriter.flush();
					bufferedWriter.close();
				          } 
				catch (IOException ei) {
					ei.printStackTrace();
					JOptionPane.showMessageDialog(null, "unable to save changes", "Save Error",
							JOptionPane.ERROR_MESSAGE);
				                      }
				}
			else
			{
				JOptionPane.showMessageDialog(null, "unable to save changes", "Save Error",
						JOptionPane.ERROR_MESSAGE);
			}

				
				SeatOrder seatorder=new SeatOrder();
				seatorder.setVisible(true);
				dispose();
				}
		});
		button.setFont(new Font("Agency FB", Font.BOLD, 23));
		button.setBounds(24, 276, 155, 36);
		contentPane.add(button);
		
		JButton button_2 = new JButton("BACK");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MovieList seatbook=new MovieList();
				seatbook.setVisible(true);
				dispose();
				
			}
		});
		button_2.setFont(new Font("Agency FB", Font.BOLD, 23));
		button_2.setBounds(371, 276, 123, 36);
		contentPane.add(button_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("assets\\images\\MovieListBackground.jpg"));
		lblNewLabel.setBounds(0, 0, 504, 331);
		contentPane.add(lblNewLabel);
	
		
	}
}
