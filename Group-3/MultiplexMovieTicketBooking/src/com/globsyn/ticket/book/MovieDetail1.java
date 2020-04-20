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
public class MovieDetail1 extends JFrame {
    public String dt1;
    public String dt2;
	private JPanel contentPane;
	private JButton btnBack;
	private JTextField textField;
	public void close() {
		WindowEvent winclosingevent=new WindowEvent(this,WindowEvent.WINDOW_CLOSED);
		Toolkit.getDefaultToolkit().getSystemEventQueue().getMostRecentEventTime();
	}



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MovieDetail1 frame = new MovieDetail1();
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
	public MovieDetail1() {
		setBackground(new Color(0, 0, 0));
		setTitle("IMAX");
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets/images/imax_icon.jpg"));
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 517, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
				
		JDateChooser datechooser = new JDateChooser();	
		datechooser.setBackground(new Color(222, 184, 135));
		datechooser.setDateFormatString("yyyy/MM/dd");
		datechooser.setBounds(195, 198, 155, 31);
		contentPane.add(datechooser);	
		
		textField = new JTextField();
		textField.setForeground(new Color(0, 0, 128));
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setEditable(false);
		textField.setFont(new Font("Algerian", Font.PLAIN, 20));
		textField.setBounds(182, 11, 168, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		try
		{
		File f= new File("assets/data/movie1details.dat");
		if(f.exists())
		{
			@SuppressWarnings("resource")
			Scanner scanner= new Scanner(f);
			while(scanner.hasNext())
			{ 
				Vector<String> row= new Vector();
				String line= scanner.nextLine();
				String[] field=line.split("[|]");
				textField.setText(field[0].toString());
				
				String dt1= field[1];
				String dt2= field[2];
				datechooser.setMinSelectableDate(new Date(dt1));
				datechooser.setMaxSelectableDate(new Date(dt2));
				
				
			}
		}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		
		JLabel lblTiming = new JLabel("TIMING");
		lblTiming.setForeground(new Color(240, 230, 140));
		lblTiming.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblTiming.setBounds(10, 60, 68, 31);
		contentPane.add(lblTiming);
		
        class RadioButton extends JFrame{
			
			JRadioButton MorningRad = new JRadioButton("MORNING     10:45 ");
			JRadioButton AfternoonRad = new JRadioButton("AFTERNOON  1:45 ");
			JRadioButton EveningRad = new JRadioButton("EVENING        6:45 ");
			//ButtonGroup bg=new ButtonGroup();
			}
		ButtonGroup bg=new ButtonGroup();
		
		
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(222, 184, 135));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(20, 102, 186, 91);
		contentPane.add(panel);
		JRadioButton morning = new JRadioButton("MORNING     10:45 ");
		morning.setBackground(new Color(222, 184, 135));
		panel.add(morning);
		morning.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		bg.add(morning);
		
		JRadioButton afternoon = new JRadioButton("AFTERNOON    1:45  ");
		afternoon.setBackground(new Color(222, 184, 135));
		panel.add(afternoon);
		afternoon.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		bg.add(afternoon);
		
		JRadioButton evening = new JRadioButton("EVENING     6:45  ");
		evening.setBackground(new Color(222, 184, 135));
		panel.add(evening);
		evening.setFont(new Font("OCR A Extended", Font.PLAIN, 13));
		bg.add(evening);
		
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
		
		JButton btnBookSeat = new JButton("BOOK SEAT");
		btnBookSeat.setBackground(new Color(222, 184, 135));
		btnBookSeat.addActionListener(new ActionListener() {
			
			private DateFormat dateFormat;
			
			public void actionPerformed(ActionEvent e) {
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				
				File f= new File("assets/data/ticketinfo.dat");
				
				String name= textField.getText().toString();
				String date1 = df.format(datechooser.getDate());
				String time= null;
				String food= null;
				
				
				if(morning.isSelected())
				{
					 time= "10:45";
				}
				else if(afternoon.isSelected())
				{
			         time= "1:45";	
				}
				else if(evening.isSelected())
				{
				    time= "6:45";
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
		
		
		btnBookSeat.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnBookSeat.setBounds(28, 254, 155, 29);
		contentPane.add(btnBookSeat);
		
		btnBack = new JButton("BACK");
		btnBack.setBackground(new Color(222, 184, 135));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MovieList seatbook=new MovieList();
				seatbook.setVisible(true);
				
				dispose();
				
				}
		});
		btnBack.setFont(new Font("Agency FB", Font.BOLD, 20));
		btnBack.setBounds(339, 254, 152, 29);
		contentPane.add(btnBack);
		
		
		
		JLabel LabelOut = new JLabel("");
		LabelOut.setBounds(28, 155, 178, 14);
		contentPane.add(LabelOut);
		
		JLabel lblFood = new JLabel("FOOD");
		lblFood.setForeground(new Color(238, 232, 170));
		lblFood.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblFood.setBounds(214, 61, 55, 29);
		contentPane.add(lblFood);
		
		
		
		JLabel lblCh = new JLabel("CHOOSE DATE\r\n");
		lblCh.setForeground(new Color(240, 230, 140));
		lblCh.setFont(new Font("Agency FB", Font.BOLD, 30));
		lblCh.setBounds(38, 200, 133, 29);
		contentPane.add(lblCh);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("assets\\images\\MovieListBackground.jpg"));
		lblNewLabel.setBounds(0, 0, 501, 331);
		contentPane.add(lblNewLabel);
		
		
		
	
		
	}
}
