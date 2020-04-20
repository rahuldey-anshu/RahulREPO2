package globsyn.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class UsernamePassword extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UsernamePassword frame = new UsernamePassword();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param user 
	 */
	
	public UsernamePassword() {
		setTitle("Welcome to Med Care World");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 900, 724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 884, 741);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(248, 248, 255));
		panel_1.setBounds(221, 87, 430, 508);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 0, 102)));
		panel_2.setBounds(21, 169, 386, 190);
		panel_1.add(panel_2);
		
		JLabel label = new JLabel("Username:");
		label.setForeground(new Color(51, 0, 153));
		label.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		label.setBounds(21, 29, 109, 45);
		panel_2.add(label);
		
		userName = new JTextField();
		userName.setFont(new Font("Lucida Fax", Font.PLAIN, 14));
		userName.setColumns(10);
		userName.setBounds(143, 32, 214, 39);
		panel_2.add(userName);
		
		JLabel label_1 = new JLabel("Password:");
		label_1.setForeground(new Color(51, 0, 153));
		label_1.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		label_1.setBounds(21, 118, 93, 39);
		panel_2.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(143, 118, 214, 39);
		panel_2.add(passwordField);
		
		JLabel label_2 = new JLabel("MED CARE WORLD...");
		label_2.setForeground(new Color(51, 0, 153));
		label_2.setFont(new Font("Lucida Fax", Font.BOLD, 32));
		label_2.setBounds(47, 11, 342, 105);
		panel_1.add(label_2);
		
		JButton button = new JButton("Log In");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String user = userName.getText();
				String password = passwordField.getText();
				
				if(user!=null && password!=null
						&& !"".equals(user.trim()) && !"".equals(password.trim())){
					
					File f = new File("assets/data/login.dat");

					boolean e = f.exists();

					System.out.println(e);
					Scanner scanner;
					try {
						scanner = new Scanner(f);
						boolean userFound=false;
						while (scanner.hasNext()) {
							String line = (String) scanner.nextLine();

							System.out.println(line);
							
							if(line.toLowerCase().contains(user.toLowerCase())){
								userFound= true;
								
								String tokens[] = line.split("[|]");
								
								String passcode = tokens[1];
								
								if(passcode.trim().equals(password)){
									JOptionPane.showMessageDialog(null, "Welcome " + user);
									HomePage hp= new HomePage();
									hp.setVisible(true);;
									dispose();
									
							
								}else{
									JOptionPane.showMessageDialog(null, "Password does not match. Please, enter correct password.","Incorrect Password",JOptionPane.ERROR_MESSAGE);
								}
								break;
							}

						}
						
						
						if(!userFound){
							JOptionPane.showMessageDialog(null, "User Id does not exist. Please, enter correct user id.","Incorrect User Id",JOptionPane.ERROR_MESSAGE);
						}
						
						
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}else{
					JOptionPane.showMessageDialog(null, "Please, enter your credentials.","No Input",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(166, 440, 89, 37);
		panel_1.add(button);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("assets\\images\\wallpaper1.jpg"));
		lblNewLabel.setBounds(0, 0, 884, 685);
		panel.add(lblNewLabel);
		
		
	}
} 
