package com.globsyn.ticket.book;

import java.awt.Component;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import java.awt.Toolkit;
import java.awt.Color;

public class BookingSummary {

	private JFrame frmImax;
	private JTextField NoOfSeats;
	private JTextField seatCost;
	private JTextField foodCost;
	private JTextField gross;
	private JTextField tax;
	private JTextField SubAmt;
	private JTextField AmtPayable;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textField;
	private JTextField date;
	private JTextField time;

	/**
	 * Launch the application.
	 */
	public static void newScreen(boolean args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingSummary window = new BookingSummary();
					window.frmImax.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				class Addition extends JFrame 
				{
					
					Addition obj=new Addition();
					
					public Addition(){
						JTextField seatCost=new JTextField();

						JTextField foodCost=new JTextField();


					  add(seatCost);
					add(foodCost);
					
					
									}
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookingSummary() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImax = new JFrame();
		frmImax.setIconImage(Toolkit.getDefaultToolkit().getImage("assets\\images\\imax_icon.jpg"));
		frmImax.setTitle("IMAX");
		frmImax.setBounds(100, 100, 632, 505);
		frmImax.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmImax.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Booking Summary");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(193, 11, 200, 42);
		frmImax.getContentPane().add(lblNewLabel);
		
		JLabel lblMovieNameScreen = new JLabel("MOVIE NAME");
		lblMovieNameScreen.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblMovieNameScreen.setBounds(82, 50, 110, 30);
		frmImax.getContentPane().add(lblMovieNameScreen);
		
		JLabel lblSeatType = new JLabel("SEAT TYPE");
		lblSeatType.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblSeatType.setBounds(82, 86, 86, 21);
		frmImax.getContentPane().add(lblSeatType);
		
		
		JLabel lblNoOfSeats = new JLabel("NO. OF SEATS");
		lblNoOfSeats.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNoOfSeats.setBounds(82, 115, 140, 21);
		frmImax.getContentPane().add(lblNoOfSeats);
		
		NoOfSeats = new JTextField();
		NoOfSeats.setBounds(216, 115, 74, 20);
		frmImax.getContentPane().add(NoOfSeats);
		NoOfSeats.setColumns(10);
		
		seatCost = new JTextField();
		seatCost.setBounds(216, 145, 74, 21);
		frmImax.getContentPane().add(seatCost);
		seatCost.setColumns(10);
		
		JLabel label2 = new JLabel("FOOD COST");
		label2.setFont(new Font("Sitka Text", Font.BOLD, 15));
		label2.setBounds(82, 176, 89, 22);
		frmImax.getContentPane().add(label2);
		
		foodCost = new JTextField();
		foodCost.setBounds(216, 177, 74, 20);
		frmImax.getContentPane().add(foodCost);
		foodCost.setColumns(10);
		
		JButton btnGross = new JButton("GROSS");
		btnGross.setFont(new Font("Sitka Text", Font.BOLD, 13));
		btnGross.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				try {
					String cost1 = seatCost.getText();
					String cost2 = foodCost.getText();
					if (cost1!=null && !"".equals(cost1.trim())
						&& cost2!=null && !"".equals(cost2.trim())) {
						double num1 = Double.parseDouble(cost1);
						double num2 = Double.parseDouble(cost2);
						double total = num1 + num2;
						gross.setText(total + " ");
					}else{
						JOptionPane.showMessageDialog(frmImax, "Please enter seat cost and/or food cost.");
					}
					
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Please enter a valid number");
					e1.printStackTrace();
				}
				 
				
			}
		});
		btnGross.setBounds(82, 211, 110, 30);
		frmImax.getContentPane().add(btnGross);
		
		gross = new JTextField();
		gross.setBounds(243, 208, 253, 25);
		frmImax.getContentPane().add(gross);
		gross.setColumns(10);
		
		JButton btnTax = new JButton("Tax 18%");
		btnTax.setFont(new Font("Sitka Text", Font.BOLD, 13));
		btnTax.addActionListener(new ActionListener() {
			
			 
			//l=gross.getText();
			public void actionPerformed(ActionEvent e) {
			 
				String cost1 = seatCost.getText();
				String cost2 = foodCost.getText();
				
				if(cost1!=null && !"".equals(cost1.trim())
						&& cost2!=null && !"".equals(cost2.trim())){
					
					double num1 = Double.parseDouble(cost1);
					double num2 = Double.parseDouble(cost2);
					double total = (num1 + num2)*0.18f;
					
					tax.setText(new Double(total).toString());
					
					
				}else{
					JOptionPane.showMessageDialog(frmImax, "Please, enter foodcost and/or seat cost.");
				}
				 
				
				
			}
		});
		btnTax.setBounds(82, 252, 110, 30);
		frmImax.getContentPane().add(btnTax);
		
		tax = new JTextField();
		tax.setBounds(243, 250, 253, 30);
		frmImax.getContentPane().add(tax);
		tax.setColumns(10);
		
		JButton btnSubAmount = new JButton("SUB AMOUNT");
		btnSubAmount.setFont(new Font("Sitka Text", Font.BOLD, 13));
		btnSubAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cost1 = seatCost.getText();
				String cost2 = foodCost.getText();
			
				double num1 = Double.parseDouble(cost1);
				double num2 = Double.parseDouble(cost2);
				double total = num1 + num2;
				gross.setText(total + " ");
				double total1 = (num1 + num2)*0.18f;
				
				 
				double total2=((num1 + num2)*0.18f)+( num1 + num2);
				SubAmt.setText(total2+"");
			
			}
		});
		btnSubAmount.setBounds(82, 293, 140, 30);
		frmImax.getContentPane().add(btnSubAmount);
		
		SubAmt = new JTextField();
		SubAmt.setBounds(243, 291, 253, 32);
		frmImax.getContentPane().add(SubAmt);
		SubAmt.setColumns(10);
		
		JButton btnAmountPayable = new JButton("AMOUNT PAYABLE");
		btnAmountPayable.setFont(new Font("Sitka Text", Font.BOLD, 13));
		btnAmountPayable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cost1 = seatCost.getText();
				String cost2 = foodCost.getText();
			
				double num1 = Double.parseDouble(cost1);
				double num2 = Double.parseDouble(cost2);
				double total = num1 + num2;
				gross.setText(total + " ");
				double total1 = (num1 + num2)*0.18f;
				
				 
				double total2=((num1 + num2)*0.18f)+( num1 + num2);
				 
			double total3=((num1 + num2)*0.18f)+( num1 + num2);
				AmtPayable.setText(total3+"");
 
			}
		});
		btnAmountPayable.setBounds(82, 334, 160, 30);
		frmImax.getContentPane().add(btnAmountPayable);
		
		AmtPayable = new JTextField();
		AmtPayable.setBounds(253, 334, 243, 30);
		frmImax.getContentPane().add(AmtPayable);
		AmtPayable.setColumns(10);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnPrint.setFont(new Font("Sitka Text", Font.BOLD, 15));
		btnPrint.setBounds(351, 391, 110, 42);
		frmImax.getContentPane().add(btnPrint);
		
		
		
		
		JButton btnSeatCost = new JButton("SEAT COST");
		btnSeatCost.setFont(new Font("Sitka Text", Font.BOLD, 13));
		btnSeatCost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//String cost=seatCost.getText().toString();
		    //String seats=NoOfSeats.getText().toString();
		    try {
		    	File f=new File("assets/data/bookedseatsTemp.dat");
		    	if(f.exists()) {
		    		Scanner sc=new Scanner(f);
		    		while(sc.hasNext()){
		    			String seats=NoOfSeats.getText().toString();
		    			//String[] fields=line.split("[|]");
		    			NoOfSeats.getText().toString();
		    		}
		    	}
		    }catch(FileNotFoundException e) {
		    	e.printStackTrace();
		    }
		    
		    
		    
			}
		});
		btnSeatCost.setBounds(82, 138, 110, 30);
		frmImax.getContentPane().add(btnSeatCost);
		
		JCheckBox Royal = new JCheckBox("       ROYAL");
		Royal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Royal.setBounds(253, 82, 97, 23);
		frmImax.getContentPane().add(Royal);
		
		JCheckBox Executive = new JCheckBox("   EXECUTIVE");
		Executive.setFont(new Font("Tahoma", Font.PLAIN, 13));
		Executive.setBounds(382, 82, 123, 23);
		frmImax.getContentPane().add(Executive);
		
		if(Royal.isSelected()) {
			seatCost.setText("200");
		}else if(Executive.isSelected()) {
			seatCost.setText("120");
		}
		
		textField = new JTextField();
		textField.setBounds(243, 55, 253, 20);
		frmImax.getContentPane().add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(243, 82, 253, 25);
		frmImax.getContentPane().add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("MOVIE DATE");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel_1.setBounds(332, 116, 110, 18);
		frmImax.getContentPane().add(lblNewLabel_1);
		
		date = new JTextField();
		date.setBounds(439, 115, 115, 21);
		frmImax.getContentPane().add(date);
		date.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("MOVIE TIME");
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel_2.setBounds(332, 147, 97, 17);
		frmImax.getContentPane().add(lblNewLabel_2);
		
		time = new JTextField();
		time.setBounds(439, 143, 115, 20);
		frmImax.getContentPane().add(time);
		time.setColumns(10);
		JButton btnExit = new JButton("BACK TO HOME");
		btnExit.setFont(new Font("Sitka Text", Font.BOLD, 15));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HomePage homePage = new HomePage();
				homePage.setVisible(true);
				frmImax.dispose();	
			}
		});
			btnExit.setBounds(82, 391, 160, 42);
			frmImax.getContentPane().add(btnExit);
			
			JLabel lblNewLabel_4 = new JLabel("");
			lblNewLabel_4.setBackground(new Color(255, 255, 255));
			lblNewLabel_4.setBounds(0, 0, 616, 466);
			frmImax.getContentPane().add(lblNewLabel_4);
			
		try
		{
		File f= new File("assets/data/ticketinfo.dat");
		if(f.exists())
		{
			@SuppressWarnings("resource")
			Scanner scanner= new Scanner(f);
			while(scanner.hasNext())
			{
				String line= scanner.nextLine();
				String[] field=line.split("[|]");
				textField.setText(field[0].toString());
			    date.setText(field[1].toString());	
			    time.setText(field[2].toString());
			    foodCost.setText(field[3].toString());
			}
		}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}

	
}
