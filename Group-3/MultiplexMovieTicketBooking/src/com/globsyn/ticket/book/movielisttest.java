package com.globsyn.ticket.book;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.File;
import java.io.File.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class movielisttest extends JFrame {
	public void close() {
		WindowEvent winclosingevent=new WindowEvent(this,WindowEvent.WINDOW_CLOSED);
		Toolkit.getDefaultToolkit().getSystemEventQueue().getMostRecentEventTime();
	}

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					movielisttest frame = new movielisttest();
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
	public movielisttest() {
		setBackground(Color.BLACK);
		setTitle("IMAX");
		setIconImage(Toolkit.getDefaultToolkit().getImage("assets\\\\images\\\\icon"));
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton movie4 = new JButton();
		//try {
			
			//Image img= ImageIO.read(getClass().getResource(filetoWrite));
		//}
		movie4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
				
				MovieDetail4 detail=new MovieDetail4();
				detail.setVisible(true);
				dispose();
				
			}
		});
		// File file = null;
		//ImageIcon icon4= new ImageIcon( new File("assets/images/"+file.getName()).getName());
		JButton movie1 = new JButton("");
		movie1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					File f= new File("assets/data/movie1details.dat");
					
					if(f.exists()) {
						Scanner scanner= new Scanner(f);
						while(scanner.hasNext()) {
							String line= scanner.nextLine();
							String[] field=line.split("[|]");
							// BufferedImage image = ImageIO.read(new File(movie1.setText(field[1])));
							
						 //movie1.setText(field[1].toString());
						//movie1.setText(field[1].)
						}
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				
				
				
				
				MovieDetail1 detail1=new MovieDetail1();
				detail1.setVisible(true);
				dispose();
				}
			
		});
	              //	movie1.setIcon( movie1.setText(field[1].toString()));
		movie1.setBounds(28, 64, 124, 201);
		contentPane.add(movie1);
		
		JButton movie2 = new JButton("");
		movie2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					File f= new File("assets/data/movie2details.dat");
					if(f.exists()) {
						Scanner scanner= new Scanner(f);
						while(scanner.hasNext()) {
							String line= scanner.nextLine();
							String[] field=line.split("[|]");
							
						}
					}
				} catch (FileNotFoundException ei) {
					ei.printStackTrace();
				}
				
				MovieDetail2 detail2=new MovieDetail2();
				detail2.setVisible(true);
				dispose();
				}
		});
		
		String movie3path = null;
		try {
			File f= new File("assets/data/movie3details.dat");
			if(f.exists()) {
				Scanner scanner= new Scanner(f);
				while(scanner.hasNext()) {
					String line= scanner.nextLine();
					String[] field=line.split("[|]");
					movie3path = field[3];
				}
			}
		} catch (FileNotFoundException ei) {
			ei.printStackTrace();
		}
		
		movie2.setIcon(new ImageIcon("assets\\images\\Movie3Button.jpg"));
		movie2.setBounds(192, 64, 124, 201);
		contentPane.add(movie2);
		
		JButton movie3 = new JButton("");
		movie3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					File f= new File("assets/data/movie3details.dat");
					if(f.exists()) {
						Scanner scanner= new Scanner(f);
						while(scanner.hasNext()) {
							String line= scanner.nextLine();
							String[] field=line.split("[|]");
							
						}
					}
				} catch (FileNotFoundException ei) {
					ei.printStackTrace();
				}
				
				MovieDetail3 detail3=new MovieDetail3();
				detail3.setVisible(true);
				dispose();
				
			}
		});
		
		movie3.setIcon(new ImageIcon(movie3path));
		movie3.setBounds(353, 64, 129, 201);
		contentPane.add(movie3);
		movie4.setIcon(new ImageIcon("assets\\images\\Movie1Button.jpg"));
		movie4.setBounds(518, 64, 135, 201);
		contentPane.add(movie4);
		
		JLabel lblMovies = new JLabel("MOVIES");
		lblMovies.setForeground(new Color(230, 230, 250));
		lblMovies.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMovies.setBounds(280, 11, 124, 25);
		contentPane.add(lblMovies);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExit.setBounds(484, 286, 89, 31);
		contentPane.add(btnExit);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage homepage=new HomePage();
				homepage.setVisible(true);
				dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setBounds(118, 286, 99, 31);
		contentPane.add(btnBack);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("assets\\images\\MovieListBackground.jpg"));
		label.setBounds(0, 0, 683, 328);
		contentPane.add(label);
	}
}
