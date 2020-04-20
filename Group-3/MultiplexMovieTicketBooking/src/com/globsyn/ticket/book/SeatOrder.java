package com.globsyn.ticket.book;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class SeatOrder extends JFrame {
	JToggleButton[] seats = new JToggleButton[60];
	String dataToWrite = "";

	 
	public void close() {
		WindowEvent winclosingevent = new WindowEvent(this, WindowEvent.WINDOW_CLOSED);
		Toolkit.getDefaultToolkit().getSystemEventQueue().getMostRecentEventTime();
	}

	private JPanel contentPane;

	public static void main(String[] args) {
		// String path="H:\\WORKSPACE\\SEAT BOOKING DETAILS.txt";

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeatOrder frame = new SeatOrder();
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
	public SeatOrder() {
		setBackground(Color.BLACK);
		setTitle("IMAX");
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets\\\\images\\\\icon"));
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 887, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblScreen = new JLabel("");
		lblScreen.setIcon(new ImageIcon("assets/images/screen.png"));
		lblScreen.setForeground(new Color(25, 25, 112));
		lblScreen.setBounds(115, 380, 634, 88);
		lblScreen.setFont(new Font("OCR A Extended", Font.BOLD, 24));
		contentPane.add(lblScreen);

		JButton ButtonBack = new JButton("<<BACK");
		ButtonBack.setForeground(new Color(25, 25, 112));
		ButtonBack.setBounds(759, 422, 102, 23);
		ButtonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MovieList seatbook = new MovieList();
				seatbook.setVisible(true);
				MovieDetail1 detail = new MovieDetail1();
				detail.setVisible(false);
				dispose();
			}
		});
		ButtonBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(ButtonBack);

		JLabel lblNewLabel = new JLabel("E\r\nX\r\nE\r\nC\r\nU\r\nT\r\nI\r\nV\r\nE");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(7, 168, 66, 42);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("E\r\nX\r\nE\r\nC\r\nU\r\nT\r\nI\r\nV\r\nE");
		label.setForeground(new Color(25, 25, 112));
		label.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label.setBounds(7, 238, 66, 42);
		contentPane.add(label);

		JLabel label_1 = new JLabel("E\r\nX\r\nE\r\nC\r\nU\r\nT\r\nI\r\nV\r\nE");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_1.setForeground(new Color(25, 25, 112));
		label_1.setBounds(7, 303, 66, 42);
		contentPane.add(label_1);

		JLabel lblRoyal = new JLabel("ROYAL");
		lblRoyal.setForeground(new Color(25, 25, 112));
		lblRoyal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRoyal.setBounds(7, 106, 46, 14);
		contentPane.add(lblRoyal);

		JLabel label_2 = new JLabel("ROYAL");
		label_2.setForeground(new Color(25, 25, 112));
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(7, 36, 46, 14);
		contentPane.add(label_2);
		JButton btnNext = new JButton("CONFIRM>>");

		btnNext.setForeground(new Color(25, 25, 112));
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNext.setBounds(759, 388, 102, 23);
		contentPane.add(btnNext);

		int i = 0;
		seats[i] = new JToggleButton("A1");
		seats[i].setBounds(83, 304, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("A2");
		seats[i].setBounds(137, 304, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("A3");
		seats[i].setBounds(192, 304, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("A4");
		seats[i].setBounds(247, 304, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("A5");
		seats[i].setBounds(302, 304, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("A6");
		seats[i].setBounds(356, 304, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("B1");
		seats[i].setBounds(83, 238, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("B2");
		seats[i].setBounds(137, 238, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("B3");
		seats[i].setBounds(192, 238, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("B4");
		seats[i].setBounds(247, 238, 56, 43);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("B5");
		seats[i].setBounds(303, 239, 55, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("B6");
		seats[i].setBounds(356, 239, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("C1");
		seats[i].setBounds(83, 168, 65, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("C2");
		seats[i].setBounds(147, 169, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("C3");
		seats[i].setBounds(192, 169, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("C4");
		seats[i].setBounds(247, 169, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("C5");
		seats[i].setBounds(295, 169, 54, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("C6");
		seats[i].setBounds(341, 169, 71, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("D1");
		seats[i].setBounds(83, 92, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("D2");
		seats[i].setBounds(137, 92, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("D3");
		seats[i].setBounds(192, 92, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("D4");
		seats[i].setBounds(247, 92, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("D5");
		seats[i].setBounds(302, 93, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("D6");
		seats[i].setBounds(356, 93, 56, 41);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("E1");
		seats[i].setBounds(83, 22, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("E2");
		seats[i].setBounds(137, 22, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("E3");
		seats[i].setBounds(192, 22, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("E4");
		seats[i].setBounds(247, 22, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("E5");
		seats[i].setBounds(302, 22, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("E6");
		seats[i].setBounds(356, 23, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("A7");
		seats[i].setBounds(487, 304, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("A8");
		seats[i].setBounds(541, 304, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("A9");
		seats[i].setBounds(593, 304, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("A10");
		seats[i].setBounds(648, 304, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("A11");
		seats[i].setBounds(704, 304, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("A12");
		seats[i].setBounds(759, 304, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("B7");
		seats[i].setBounds(487, 238, 57, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("B8");
		seats[i].setBounds(541, 238, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("B9");
		seats[i].setBounds(593, 238, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("C7");
		seats[i].setBounds(487, 168, 58, 43);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("C8");
		seats[i].setBounds(541, 168, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("C9");
		seats[i].setBounds(593, 168, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("D7");
		seats[i].setBounds(487, 92, 56, 43);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("D8");
		seats[i].setBounds(541, 92, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("D9");
		seats[i].setBounds(593, 92, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("E7");
		seats[i].setBounds(487, 22, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("E8");
		seats[i].setBounds(541, 22, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("E9");
		seats[i].setBounds(593, 22, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("B10");
		seats[i].setBounds(648, 238, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("B11");
		seats[i].setBounds(694, 238, 66, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("B12");
		seats[i].setBounds(759, 238, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("C10");
		seats[i].setBounds(648, 168, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("C11");
		seats[i].setBounds(694, 168, 66, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("C12");
		seats[i].setBounds(759, 168, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("D10");
		seats[i].setBounds(648, 92, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("D11");
		seats[i].setBounds(694, 92, 66, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("D12");
		seats[i].setBounds(759, 92, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("E10");
		seats[i].setBounds(648, 22, 56, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("E11");
		seats[i].setBounds(694, 22, 66, 42);
		contentPane.add(seats[i++]);

		seats[i] = new JToggleButton("E12");
		seats[i].setBounds(759, 22, 56, 42);
		contentPane.add(seats[i++]);
		
		JButton btnNext_1 = new JButton("NEXT>>");
		btnNext_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BookingSummary bookingsummary=new BookingSummary();
				bookingsummary.newScreen(true);
				dispose();
			}
		});
		btnNext_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNext_1.setForeground(new Color(25, 25, 112));
		btnNext_1.setBounds(759, 356, 102, 23);
		contentPane.add(btnNext_1);

		File f = new File("assets/data/bookedseats.dat");

		if (f.exists()) {

			try {
				Scanner scanner = new Scanner(f);

				while (scanner.hasNext()) {
					String line = scanner.nextLine();

					String[] fields = line.split("[|]");

					String seatno = fields[0];

					int index = Integer.parseInt(seatno);
					seats[index].setSelected(true);

				}
				
				scanner.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

		}

		File f1 = new File("assets/data/bookedseatsTemp.dat");
		File foriginal = new File("assets/data/bookedseats.dat");

		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				for (int i = 0; i < 60; i++) {

					if (seats[i].isSelected()) {
						dataToWrite += i + "|true\n";
						//System.out.println(i+ " selected");
					}
				}

				try {
					FileWriter fileWriter = new FileWriter(f1);
					BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

					bufferedWriter.write(dataToWrite);

					bufferedWriter.flush();
					bufferedWriter.close();
					// billing koro.
					
					if(foriginal.exists()){
						foriginal.delete();
						//System.out.println("deleted");
					}
					if(f1.exists()){
						f1.renameTo(foriginal);
						//System.out.println("renamed");
					}	
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		});

	}
}
