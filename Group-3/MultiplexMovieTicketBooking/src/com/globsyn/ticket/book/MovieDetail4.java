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

public class MovieDetail4 extends JFrame {
	public String dt1;
	public String dt2;
	private JPanel contentPane;
	private JTextField textField4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieDetail4 frame = new MovieDetail4();
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
	public MovieDetail4() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets\\images\\imax_icon.jpg"));
		setBackground(Color.BLACK);
		setTitle("IMAX");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		ButtonGroup bg=new ButtonGroup();
		
		JLabel label = new JLabel("TIMING");
		label.setForeground(new Color(240, 230, 140));
		label.setFont(new Font("Agency FB", Font.BOLD, 30));
		label.setBounds(31, 41, 68, 27);
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("FOOD");
		label_2.setForeground(new Color(240, 230, 140));
		label_2.setFont(new Font("Agency FB", Font.BOLD, 30));
		label_2.setBounds(225, 54, 53, 37);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("CHOOSE DATE\r\n");
		label_3.setBackground(new Color(240, 255, 255));
		label_3.setForeground(new Color(240, 230, 140));
		label_3.setFont(new Font("Agency FB", Font.BOLD, 30));
		label_3.setBounds(28, 188, 142, 36);
		contentPane.add(label_3);
		
		textField4 = new JTextField();
		textField4.setFont(new Font("Algerian", Font.PLAIN, 20));
		textField4.setForeground(new Color(0, 0, 139));
		textField4.setHorizontalAlignment(SwingConstants.CENTER);
		textField4.setEditable(false);
		textField4.setBounds(160, 11, 203, 32);
		contentPane.add(textField4);
		textField4.setColumns(10);
		
		JDateChooser date = new JDateChooser();
		date.setBackground(new Color(222, 184, 135));
		date.setBounds(204, 188, 189, 36);
		contentPane.add(date);
		try
		{
		File f= new File("assets/data/movie4details.dat");
		if(f.exists())
		{
			@SuppressWarnings("resource")
			Scanner scanner= new Scanner(f);
			while(scanner.hasNext())
			{ 
				Vector<String> row= new Vector();
				String line= scanner.nextLine();
				String[] field=line.split("[|]");
				textField4.setText(field[0].toString());
				
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBounds(31, 79, 165, 90);
		contentPane.add(panel);
		
		JRadioButton morning = new JRadioButton("MORNING  12:45");
		morning.setBackground(new Color(222, 184, 135));
		morning.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		panel.add(morning);
		
		JRadioButton afternoon = new JRadioButton("AFTERNOON  4:45");
		afternoon.setBackground(new Color(222, 184, 135));
		afternoon.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		panel.add(afternoon);
		
		JRadioButton evening = new JRadioButton("EVENING  9:45");
		evening.setBackground(new Color(222, 184, 135));
		evening.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		panel.add(evening);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(222, 184, 135));
		panel_1.setBounds(225, 90, 254, 90);
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
		button.setBounds(31, 277, 126, 37);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			private DateFormat dateFormat;
			public void actionPerformed(ActionEvent e) {
				
				 DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					
					File f= new File("assets/data/ticketinfo.dat");
					
					String name= textField4.getText().toString();
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
		
		JButton button_2 = new JButton("BACK");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MovieList seatbook=new MovieList();
				seatbook.setVisible(true);
				dispose();
				
			}
		});
		button_2.setFont(new Font("Agency FB", Font.BOLD, 23));
		button_2.setBounds(340, 277, 135, 37);
		contentPane.add(button_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("assets\\images\\MovieListBackground.jpg"));
		lblNewLabel.setBounds(0, 0, 504, 331);
		contentPane.add(lblNewLabel);
	
		
	}
}
