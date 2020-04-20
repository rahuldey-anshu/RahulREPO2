package com.globsyn.ticket.book;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;

public class AddMovie extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	JFileChooser chooser = new JFileChooser();
	String fileName = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMovie frame = new AddMovie();
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
	public AddMovie() {
		setType(Type.POPUP);
		setBackground(new Color(0, 0, 0));
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets\\images\\imax_icon.jpg"));
		setTitle("IMAX");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddMovie = new JLabel("ADD MOVIE");
		lblAddMovie.setBackground(new Color(253, 245, 230));
		lblAddMovie.setForeground(new Color(102, 205, 170));
		lblAddMovie.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 22));
		lblAddMovie.setBounds(146, 0, 136, 35);
		contentPane.add(lblAddMovie);

		JLabel lblNewLabel_1 = new JLabel("AUDITORIUM");
		lblNewLabel_1.setForeground(new Color(240, 230, 140));
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblNewLabel_1.setBounds(27, 79, 123, 34);
		contentPane.add(lblNewLabel_1);

		JButton btnBrowsePhoto = new JButton("Browse Photo");
		btnBrowsePhoto.setBackground(new Color(222, 184, 135));

		btnBrowsePhoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int result = chooser.showOpenDialog(contentPane);

				if (result == JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();

					fileName = file.getName();
					File filetoWrite = new File("assets/images/" + file.getName());

					try {
						FileInputStream fis = new FileInputStream(file);
						FileOutputStream fos = new FileOutputStream(filetoWrite);

						int data = fis.read();

						while (data != -1) {
							fos.write(data);

							data = fis.read();
						}

						fis.close();
						fos.close();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});
		btnBrowsePhoto.setBounds(197, 162, 156, 23);
		contentPane.add(btnBrowsePhoto);

		JRadioButton screen1 = new JRadioButton("SCREEN1");
		screen1.setBackground(new Color(222, 184, 135));
		screen1.setBounds(197, 70, 109, 23);
		contentPane.add(screen1);

		JRadioButton screen2 = new JRadioButton("SCREEN2");
		screen2.setBackground(new Color(222, 184, 135));
		screen2.setBounds(308, 70, 109, 23);
		contentPane.add(screen2);

		JRadioButton screen3 = new JRadioButton("SCREEN3");
		screen3.setBackground(new Color(222, 184, 135));
		screen3.setBounds(197, 91, 109, 23);
		contentPane.add(screen3);

		JRadioButton screen4 = new JRadioButton("SCREEN4");
		screen4.setBackground(new Color(222, 184, 135));
		screen4.setBounds(308, 91, 109, 23);
		contentPane.add(screen4);

		JLabel lblNewLabel = new JLabel("MOVIE NAME");
		lblNewLabel.setForeground(new Color(240, 230, 140));
		lblNewLabel.setFont(new Font("Bodoni MT", Font.BOLD, 18));
		lblNewLabel.setBounds(27, 30, 137, 35);
		contentPane.add(lblNewLabel);

		textField = new JTextField();
		textField.setBackground(new Color(222, 184, 135));
		textField.setBounds(197, 34, 196, 29);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("FROM DATE");
		lblNewLabel_2.setForeground(new Color(240, 230, 140));
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblNewLabel_2.setBounds(10, 124, 123, 24);
		contentPane.add(lblNewLabel_2);

		JDateChooser fromdate = new JDateChooser();
		fromdate.setBackground(new Color(222, 184, 135));
		fromdate.setDateFormatString("dd/MM/yyyy");
		fromdate.setBounds(128, 124, 109, 27);
		contentPane.add(fromdate);

		JLabel lblNewLabel_3 = new JLabel("TO DATE");
		lblNewLabel_3.setForeground(new Color(240, 230, 140));
		lblNewLabel_3.setFont(new Font("Sitka Text", Font.BOLD, 18));
		lblNewLabel_3.setBounds(238, 121, 89, 29);
		contentPane.add(lblNewLabel_3);

		JDateChooser todate = new JDateChooser();
		todate.setBackground(new Color(222, 184, 135));
		todate.setDateFormatString("yyyy/MM/dd");
		todate.setBounds(318, 124, 116, 27);
		contentPane.add(todate);

		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBackground(new Color(222, 184, 135));
		btnNewButton.addActionListener(new ActionListener() {
			private DateFormat dateFormat;

			public void actionPerformed(ActionEvent arg0) {

				DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

				File f = new File("assets/data/movie4details.dat");

				if (screen1.isSelected()) {
					f = new File("assets/data/movie1details.dat");

				} else if (screen2.isSelected()) {
					f = new File("assets/data/movie2details.dat");

				} else if (screen3.isSelected()) {
					f = new File("assets/data/movie3details.dat");

				}
				else if (screen3.isSelected()) {
					f = new File("assets/data/movie3details.dat");

				}

				String movieName = textField.getText().toString();
				String from = df.format(fromdate.getDate());
				String to = df.format(todate.getDate());
				String iconpath = "assets/images/" + fileName;
				if (f.exists()) {
					String dataToWrite = movieName + "|" + from + "|" + to + "|" + iconpath;
					try {
						FileWriter fileWriter = new FileWriter(f);
						BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
						bufferedWriter.write(dataToWrite);
						bufferedWriter.flush();
						bufferedWriter.close();
					} catch (IOException e) {
						e.printStackTrace();
						JOptionPane.showMessageDialog(null, "unable to save changes", "Save Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "unable to save changes", "Save Error",
							JOptionPane.ERROR_MESSAGE);
				}

				HomePage homePage = new HomePage();
				homePage.setVisible(true);
				dispose();
			}

		});
		btnNewButton.setFont(new Font("Sitka Text", Font.BOLD, 20));
		btnNewButton.setBounds(159, 213, 123, 37);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_4 = new JLabel("BACKGROUND");
		lblNewLabel_4.setForeground(new Color(240, 230, 140));
		lblNewLabel_4.setFont(new Font("Sitka Text", Font.BOLD, 17));
		lblNewLabel_4.setBounds(27, 165, 123, 29);
		contentPane.add(lblNewLabel_4);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(197, 70, 220, 43);
		contentPane.add(horizontalBox);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("assets\\images\\MovieListBackground.jpg"));
		lblNewLabel_5.setBounds(0, 0, 434, 261);
		contentPane.add(lblNewLabel_5);
	}
}