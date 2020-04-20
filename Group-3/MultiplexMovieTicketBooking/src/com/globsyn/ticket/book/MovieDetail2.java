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

public class MovieDetail2 extends JFrame {
	public String dt1;
	public String dt2;
	private JPanel contentPane;
	private JTextField textField2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieDetail2 frame = new MovieDetail2();
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
	public MovieDetail2() {
		setBackground(Color.BLACK);
		setTitle("IMAX");
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets\\images\\imax_icon.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JDateChooser date = new JDateChooser();
		date.setDateFormatString("yyyy/MM/dd");
		date.setBackground(new Color(222, 184, 135));
		date.setBounds(194, 199, 153, 29);
		contentPane.add(date);
		
		textField2 = new JTextField();
		textField2.setForeground(new Color(0, 0, 128));
		textField2.setHorizontalAlignment(SwingConstants.CENTER);
		textField2.setBackground(new Color(255, 255, 255));
		textField2.setFont(new Font("Algerian", Font.PLAIN, 20));
		textField2.setEditable(false);
		textField2.setBounds(158, 11, 200, 29);
		contentPane.add(textField2);
		textField2.setColumns(10);
		
		try
		{
		File f= new File("assets/data/movie2details.dat");
		if(f.exists())
		{
			@SuppressWarnings("resource")
			Scanner scanner= new Scanner(f);
			while(scanner.hasNext())
			{ 
				Vector<String> row= new Vector();
				String line= scanner.nextLine();
				String[] field=line.split("[|]");
				textField2.setText(field[0].toString());
				
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
		
		
		
		class RadioButton extends JFrame {
			JRadioButton RBMorning = new JRadioButton("MORNING\t   11:45  ");
			JRadioButton RBAfternoon = new JRadioButton("AFTERNOON  2:45  ");
			JRadioButton RBEvening = new JRadioButton("EVENING    7:45   ");
		}
		ButtonGroup bg = new ButtonGroup();
		JRadioButton morning = new JRadioButton("MORNING    11:45   ");
		morning.setBackground(new Color(222, 184, 135));
		morning.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		morning.setBounds(26, 78, 177, 23);
		bg.add(morning);
		contentPane.add(morning);

		JRadioButton afternoon = new JRadioButton("AFTERNOON  2:45  ");
		afternoon.setBackground(new Color(222, 184, 135));
		afternoon.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		afternoon.setBounds(26, 104, 177, 23);
		bg.add(afternoon);
		contentPane.add(afternoon);

		JRadioButton evening = new JRadioButton("EVENING    7:45  ");
		evening.setBackground(new Color(222, 184, 135));
		evening.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		evening.setBounds(26, 130, 177, 23);
		bg.add(evening);
		contentPane.add(evening);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(22, 71, 193, 97);
		contentPane.add(panel);

		JLabel Timing = new JLabel("TIMING");
		Timing.setForeground(new Color(240, 230, 140));
		Timing.setFont(new Font("Agency FB", Font.BOLD, 30));
		Timing.setBounds(71, 31, 67, 29);
		contentPane.add(Timing);

		JLabel labelFood = new JLabel("FOOD");
		labelFood.setForeground(new Color(240, 230, 140));
		labelFood.setFont(new Font("Agency FB", Font.BOLD, 30));
		labelFood.setBounds(391, 31, 57, 29);
		contentPane.add(labelFood);
	
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
			public void actionPerformed(ActionEvent e) {
				
                DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				
				File f= new File("assets/data/ticketinfo.dat");
				
				String name= textField2.getText().toString();
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

				
				
				SeatOrder seatorder = new SeatOrder();
				seatorder.setVisible(true);
				dispose();

			}
		});
		button.setFont(new Font("Agency FB", Font.BOLD, 23));
		button.setBounds(26, 278, 155, 29);
		contentPane.add(button);

		JButton button_2 = new JButton("BACK");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				MovieList seatbook = new MovieList();
				seatbook.setVisible(true);
				dispose();

			}
		});
		button_2.setFont(new Font("Agency FB", Font.BOLD, 23));
		button_2.setBounds(336, 278, 155, 29);
		contentPane.add(button_2);

		
		JLabel label = new JLabel("CHOOSE DATE\r\n");
		label.setForeground(new Color(240, 230, 140));
		label.setFont(new Font("Agency FB", Font.BOLD, 25));
		label.setBounds(41, 196, 122, 32);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("assets\\images\\MovieListBackground.jpg"));
		lblNewLabel.setBounds(0, 0, 518, 331);
		contentPane.add(lblNewLabel);
		
		
		
	}	
}
