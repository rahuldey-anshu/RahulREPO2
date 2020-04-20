package com.globsyn.ticket.book;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Window;

public class HomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
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
	public HomePage() {
		setBackground(Color.BLACK);
		setTitle("IMAX");
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets\\images\\imax_icon.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton BookTicket = new JButton("BOOK TICKET");
		BookTicket.setIcon(new ImageIcon("assets\\images\\BookTicketIcon.jpg"));
		BookTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MovieList seatbook = new MovieList();
				seatbook.setVisible(true);
				dispose();
				}
		});
		BookTicket.setBounds(22, 114, 200, 136);
		contentPane.add(BookTicket);
		
		JButton ChangeMovieDetails = new JButton("CHANGE MOVIE DETAILS");
		ChangeMovieDetails.setFont(new Font("Vrinda", Font.BOLD | Font.ITALIC, 11));
		ChangeMovieDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddMovie x=new AddMovie();
				x.setVisible(true);
				dispose();
			}
		});
		ChangeMovieDetails.setIcon(new ImageIcon("assets\\images\\ChangeDetailIcon.jpg"));
		ChangeMovieDetails.setBounds(266, 115, 194, 135);
		contentPane.add(ChangeMovieDetails);
		
		JLabel LabelBT = new JLabel("BOOK TICKET");
		LabelBT.setForeground(new Color(176, 196, 222));
		LabelBT.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 16));
		LabelBT.setBounds(54, 261, 151, 24);
		contentPane.add(LabelBT);
		
		JLabel LabelCMD = new JLabel("CHANGE MOVIE DETAILS");
		LabelCMD.setBackground(new Color(176, 196, 222));
		LabelCMD.setForeground(new Color(176, 196, 222));
		LabelCMD.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 16));
		LabelCMD.setBounds(252, 256, 235, 35);
		contentPane.add(LabelCMD);
		
		JLabel labeltitle = new JLabel("");
		labeltitle.setIcon(new ImageIcon("assets\\images\\background_small.jpg"));
		labeltitle.setForeground(new Color(255, 182, 193));
		labeltitle.setFont(new Font("Segoe Marker", Font.BOLD, 40));
		labeltitle.setBounds(111, 11, 302, 44);
		contentPane.add(labeltitle);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setBounds(202, 302, 89, 23);
		contentPane.add(btnExit);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("assets\\images\\HomePageBackground.jpg"));
		label.setBounds(0, 0, 515, 341);
		contentPane.add(label);
	}
}
