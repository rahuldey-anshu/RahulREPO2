package globsyn.project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class CreateUser extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;
	private JPasswordField conpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateUser frame = new CreateUser();
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
	public CreateUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900,724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(114, 120, 647, 412);
		contentPane.add(panel);
		
		JLabel label_6 = new JLabel("Username :");
		label_6.setForeground(new Color(51, 0, 153));
		label_6.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_6.setBounds(95, 66, 150, 32);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Password :");
		label_7.setForeground(new Color(51, 0, 153));
		label_7.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_7.setBounds(95, 117, 150, 32);
		panel.add(label_7);
		
		user = new JTextField();
		user.setToolTipText("choose a user name.");
		user.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		user.setColumns(10);
		user.setBounds(282, 69, 216, 32);
		panel.add(user);
		
		pass = new JPasswordField();
		pass.setToolTipText("password should contain upper case and lower case leter and atleast one number and special charecter.");
		pass.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		pass.setBounds(282, 119, 216, 32);
		panel.add(pass);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage home= new HomePage();
				home.setVisible(true);
				dispose();
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button.setBackground(new Color(102, 153, 255));
		button.setBounds(333, 298, 133, 38);
		panel.add(button);
		
		JButton button_1 = new JButton("Save");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username= user.getText();
				String password= pass.getText();
				String conpassword= conpass.getText();
				if(password.equals(conpassword))
				{
				try{
				 File file = new File("assets/data/login.dat");
                 if (!file.exists()) {
                 file.createNewFile();
             }
                
             FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
             BufferedWriter bw = new BufferedWriter(fw);
             bw.write(username +"|"+ conpassword);
	              bw.newLine();
            

            bw.flush();
             
             fw.flush();
             JOptionPane.showMessageDialog(null, "User added successfully.");
			user.setText("");
			pass.setText("");
			conpass.setText("");
			}catch(Exception eee)
			{
				JOptionPane.showMessageDialog(null, "Try again.");
			}
				}
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Lucida Fax", Font.BOLD, 16));
		button_1.setBackground(new Color(102, 153, 255));
		button_1.setBounds(143, 298, 133, 38);
		panel.add(button_1);
		
		JLabel label_8 = new JLabel("Confirm password :");
		label_8.setForeground(new Color(51, 0, 153));
		label_8.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		label_8.setBounds(95, 173, 177, 32);
		panel.add(label_8);
		
		conpass = new JPasswordField();
		conpass.setToolTipText("password should contain upper case and lower case leter and atleast one number and special charecter.");
		conpass.setFont(new Font("Lucida Fax", Font.PLAIN, 15));
		conpass.setBounds(282, 172, 216, 32);
		panel.add(conpass);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("assets/images/wallpaper1.jpg"));
		lblNewLabel.setBounds(10, 0, 884, 685);
		contentPane.add(lblNewLabel);
	}
}
