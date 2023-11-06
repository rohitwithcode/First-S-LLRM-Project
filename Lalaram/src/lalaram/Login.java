package lalaram;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.sql.*;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel.setBounds(364, 221, 84, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_1.setBounds(366, 262, 82, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBoxMode = new JComboBox();
		comboBoxMode.setFont(new Font("Tahoma", Font.BOLD, 12));
		comboBoxMode.setModel(new DefaultComboBoxModel(new String[] {"Teacher Login", "Student Login", "Principle Login"}));
		comboBoxMode.setBounds(499, 165, 158, 22);
		contentPane.add(comboBoxMode);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String mode=(String) comboBoxMode.getSelectedItem();
				String username=textFieldUsername.getText();
				String pass=passwordField.getText();
				
				if(username.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter username", "USERNAME ERROR",JOptionPane.ERROR_MESSAGE );
				}
				else if(pass.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter password", "PASSWORD ERROR",JOptionPane.ERROR_MESSAGE );
				}
				else {
				
				try {
				
				if(mode.equalsIgnoreCase("principle login")) {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/lalaramsoftware","CoderRohit","Radhey@725386");
					
					String query="select * from principle where username=? and password=?";
					
					PreparedStatement s=c.prepareStatement(query);
					
					s.setString(1, username);
					s.setString(2, pass);
					
					ResultSet set=s.executeQuery();
					
					if(set.next()) {
						JOptionPane.showMessageDialog(null, "Login Successful", "Login",JOptionPane.INFORMATION_MESSAGE);
						
						
						dispose();
				
						HomePrinciple h=new HomePrinciple();
						h.setVisible(true);
						
						
					}
					else {
						JOptionPane.showMessageDialog(null, "wrong username or password", "Login Error",JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(mode.equalsIgnoreCase("teacher login")){
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/lalaramsoftware","CoderRohit","Radhey@725386");
					
					String query="select * from faculty where username=? and password=?";
					
					PreparedStatement s=c.prepareStatement(query);
					
					s.setString(1, username);
					s.setString(2, pass);
					
					ResultSet set=s.executeQuery();
					
					if(set.next()) {
						JOptionPane.showMessageDialog(null, "Login Successful", "Login",JOptionPane.INFORMATION_MESSAGE);
						
						
						dispose();
						
						HomeTeacher ht=new HomeTeacher();
						ht.setVisible(true);
						
						
					}
					else {
						JOptionPane.showMessageDialog(null, "wrong username or password", "Login Error",JOptionPane.ERROR_MESSAGE);
					}
				}
				else if(mode.equalsIgnoreCase("student login")) {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/lalaramsoftware","CoderRohit","Radhey@725386");
					
					String query="select * from student where username=? and password=?";
					
					PreparedStatement s=c.prepareStatement(query);
					
					s.setString(1, username);
					s.setString(2, pass);
					
					ResultSet set=s.executeQuery();
					
					if(set.next()) {
						JOptionPane.showMessageDialog(null, "Login Successful", "Login",JOptionPane.INFORMATION_MESSAGE);
						
						
						dispose();
						
						
						HomeStudent hs=new HomeStudent();
						hs.setVisible(true);
					
						
					}
					else {
						JOptionPane.showMessageDialog(null, "wrong username or password", "Login Error",JOptionPane.ERROR_MESSAGE);
					}
				}
				}catch(Exception e1) {
					System.out.println(e1.getMessage());
				}
				}
			}
		});
		btnLogin.setBackground(Color.GREEN);
		btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnLogin.setBounds(396, 336, 89, 31);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBackground(Color.RED);
		btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnCancel.setBounds(535, 336, 89, 31);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_2 = new JLabel("Select Mode");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblNewLabel_2.setBounds(364, 167, 103, 14);
		contentPane.add(lblNewLabel_2);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		textFieldUsername.setBounds(499, 221, 158, 20);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 12));
		passwordField.setBounds(499, 262, 158, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("Login");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 50));
		lblNewLabel_3.setBounds(287, 0, 162, 82);
		contentPane.add(lblNewLabel_3);
		
		JCheckBox checkBoxShowPassword = new JCheckBox("show password");
		checkBoxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBoxShowPassword.isSelected()) {
					passwordField.setEchoChar((char)0);
				}
				else {
					passwordField.setEchoChar((char)'*');
				}
				
			}
		});
		checkBoxShowPassword.setForeground(new Color(255, 0, 255));
		checkBoxShowPassword.setFont(new Font("Segoe UI", Font.BOLD, 12));
		checkBoxShowPassword.setBounds(547, 286, 110, 23);
		contentPane.add(checkBoxShowPassword);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Home home=new Home();
				home.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Segoe UI", Font.BOLD, 16));
		btnBack.setBackground(new Color(0, 191, 255));
		btnBack.setBounds(239, 336, 89, 31);
		contentPane.add(btnBack);
	}
}
