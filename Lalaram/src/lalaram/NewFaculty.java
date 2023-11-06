package lalaram;

import java.awt.EventQueue;
import javax.swing.*;
import java.sql.*;

import javax.swing.border.EmptyBorder;

import java.awt.Font;

import com.toedter.calendar.JDateChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.Random;
import java.awt.event.InputEvent;


public class NewFaculty extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel lblSetEmployeeId;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldEmailId;
	private JTextField textFieldFatherName;
	private JTextField textFieldMobileNumber;
	private JTextField textFieldClass10;
	private JTextField textFieldAdhaarNumber;
	private JTextField textFieldClass12;
	private JTextField textFieldUsername;
	private JPasswordField passwordFieldPassword;
	private JDateChooser dateChooserDob,dateChooserDoj ;
	private JComboBox comboBoxQualification,comboBoxExperience;
	private JRadioButton rdbtnMale,rdbtnFemale,rdbtnOthers;
	private JTextArea textAreaAddress;
	ButtonGroup group;
	private JCheckBox checkBoxShowPassword;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewFaculty frame = new NewFaculty();
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
	
	Random random=new Random();
    long firstFour=Math.abs((random.nextLong()%9000L)+1000L);
	public NewFaculty() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 125, 1000, 650);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New Faculty");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(370, 36, 186, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmployeeId = new JLabel("Employee id");
		lblEmployeeId.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmployeeId.setBounds(100, 104, 83, 30);
		contentPane.add(lblEmployeeId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblName.setBounds(100, 145, 83, 21);
		contentPane.add(lblName);
		
		JLabel lblFathersName = new JLabel("Father's Name");
		lblFathersName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblFathersName.setBounds(557, 143, 96, 25);
		contentPane.add(lblFathersName);
		
		JLabel lblDob = new JLabel("DOB");
		lblDob.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDob.setBounds(100, 177, 83, 21);
		contentPane.add(lblDob);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblGender.setBounds(557, 209, 83, 21);
		contentPane.add(lblGender);
		
		JLabel lblMobileNo = new JLabel("Mobile No");
		lblMobileNo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMobileNo.setBounds(100, 241, 83, 21);
		contentPane.add(lblMobileNo);
		
		JLabel lblAdhaarNo = new JLabel("Adhaar No");
		lblAdhaarNo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblAdhaarNo.setBounds(557, 241, 83, 21);
		contentPane.add(lblAdhaarNo);
		
		JLabel lblClassTenth = new JLabel("Class 10th%");
		lblClassTenth.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblClassTenth.setBounds(100, 273, 83, 21);
		contentPane.add(lblClassTenth);
		
		JLabel lblClassTwelth = new JLabel("Class 12th%");
		lblClassTwelth.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblClassTwelth.setBounds(557, 273, 83, 21);
		contentPane.add(lblClassTwelth);
		
		JLabel lblDoj = new JLabel("DOJ");
		lblDoj.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDoj.setBounds(557, 177, 83, 21);
		contentPane.add(lblDoj);
		
		JLabel lblQualification = new JLabel("Qualification");
		lblQualification.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblQualification.setBounds(100, 337, 96, 21);
		contentPane.add(lblQualification);
		
		JLabel lblEmail = new JLabel("Email ID");
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmail.setBounds(100, 209, 83, 21);
		contentPane.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblPassword.setBounds(557, 305, 83, 21);
		contentPane.add(lblPassword);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblUsername.setBounds(100, 305, 83, 21);
		contentPane.add(lblUsername);
		
		JLabel lblExperience = new JLabel("Experience");
		lblExperience.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblExperience.setBounds(557, 367, 83, 21);
		contentPane.add(lblExperience);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			String employeeId=lblSetEmployeeId.getText();
			String name=textFieldName.getText();
			String fatherName=textFieldFatherName.getText();
			java.util.Date dateDob=dateChooserDob.getDate();
			java.util.Date dateDoj=dateChooserDoj.getDate();
			String emailId=	textFieldEmailId.getText();
			String gender="Male";
			if(rdbtnFemale.isSelected()) {
				gender="Female";
			}
			if(rdbtnOthers.isSelected()) {
				gender="Others";
			}
			String mobileNumber=textFieldMobileNumber.getText();
			String adhaarNumber=textFieldAdhaarNumber.getText();
			String class10=textFieldClass10.getText();
			String class12=textFieldClass12.getText();
			String username=textFieldUsername.getText();
			String password=passwordFieldPassword.getText();
			String qualification=(String)comboBoxQualification.getSelectedItem();
			String experience=(String)comboBoxExperience.getSelectedItem();
			String address=textAreaAddress.getText();
			
			
			if(name.isEmpty()) {
				JOptionPane.showMessageDialog(null, "please enter your good name", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if(fatherName.isEmpty()) {
				JOptionPane.showMessageDialog(null, "please enter your father good name", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if(dateDob==null) {
				JOptionPane.showMessageDialog(null, "please select your Date of Birth", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if(dateDoj==null) {
				JOptionPane.showMessageDialog(null, "please select your Date of Joining", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if(emailId.isEmpty()) {
				JOptionPane.showMessageDialog(null, "please enter your email id", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if(gender.isEmpty()) {
				JOptionPane.showMessageDialog(null, "please select your gender", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if(mobileNumber.isEmpty()) {
				JOptionPane.showMessageDialog(null, "please enter your Mobile Number", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if(adhaarNumber.isEmpty()) {
				JOptionPane.showMessageDialog(null, "please enter your Adhaar Number", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if(class10.isEmpty()) {
				JOptionPane.showMessageDialog(null, "please enter your class 10th percentage", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if(class12.isEmpty()) {
				JOptionPane.showMessageDialog(null, "please enter your class 12th percentage", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if(username.isEmpty()) {
				JOptionPane.showMessageDialog(null, "please enter your username", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if(password.isEmpty()) {
				JOptionPane.showMessageDialog(null, "please enter your password", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if(qualification.isEmpty()) {
				JOptionPane.showMessageDialog(null, "please select your  qualification", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if(experience.isEmpty()) {
				JOptionPane.showMessageDialog(null, "please select your experience", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if(address.isEmpty()) {
				JOptionPane.showMessageDialog(null, "please enter your address", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/lalaramsoftware","CoderRohit","Radhey@725386");
					
					String query="insert into faculty(id,name,fathername,dob,doj,emailid,gender,mobilenumber,adhaarnumber,classtenth,classtwelth,username,password,qualification,experience,address) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
					
					PreparedStatement s=c.prepareStatement(query);
					
					s.setString(1, employeeId);
					s.setString(2, name);
					s.setString(3, fatherName);
					s.setDate(4, new java.sql.Date(dateDob.getTime()));
					s.setDate(5, new java.sql.Date(dateDoj.getTime()));
					s.setString(6, emailId);
					s.setString(7, gender);
					s.setString(8, mobileNumber);
					s.setString(9, adhaarNumber);
					s.setString(10, class10);
					s.setString(11, class12);
					s.setString(12, username);
					s.setString(13, password);
					s.setString(14, qualification);
					s.setString(15, experience);
					s.setString(16, address);
					
					int insert=s.executeUpdate();
					
					if(insert>0) {
						JOptionPane.showMessageDialog(null, "Teacher added successfully", "INSERT",JOptionPane.INFORMATION_MESSAGE);
						textFieldName.setText("");
						textFieldFatherName.setText("");
						dateChooserDob.setDate(null);
						dateChooserDoj.setDate(null);
						textFieldEmailId.setText("");
						group.clearSelection();
						textFieldMobileNumber.setText("");
						textFieldAdhaarNumber.setText("");
						textFieldClass10.setText("");
						textFieldClass12.setText("");
						textFieldUsername.setText("");
						passwordFieldPassword.setText("");
						checkBoxShowPassword.setSelected(false);
						comboBoxQualification.setSelectedIndex(-1);
						comboBoxExperience.setSelectedIndex(-1);
						textAreaAddress.setText("");
					}
					else {
						JOptionPane.showMessageDialog(null, "Teacher not added", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
					s.close();
					c.close();
					
				}catch(ClassNotFoundException | SQLException ex) {
					System.out.println(ex.getMessage());
				}
			}
			
			
			}
		});
		btnRegister.setBackground(new Color(124, 252, 0));
		btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnRegister.setBounds(100, 487, 89, 23);
		contentPane.add(btnRegister);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(255, 0, 0));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCancel.setBounds(255, 487, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(135, 206, 250));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				HomePrinciple hp=new HomePrinciple();
				hp.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnBack.setBounds(403, 487, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(255, 235, 205));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldName.setText("");
				textFieldFatherName.setText("");
				dateChooserDob.setDate(null);
				dateChooserDoj.setDate(null);
				textFieldEmailId.setText("");
				group.clearSelection();
				textFieldMobileNumber.setText("");
				textFieldAdhaarNumber.setText("");
				textFieldClass10.setText("");
				textFieldClass12.setText("");
				textFieldUsername.setText("");
				passwordFieldPassword.setText("");
				comboBoxQualification.setSelectedIndex(-1);
				comboBoxExperience.setSelectedIndex(-1);
				textAreaAddress.setText("");
				
			}
		});
		btnReset.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnReset.setBounds(551, 487, 89, 23);
		contentPane.add(btnReset);
		
		lblSetEmployeeId = new JLabel("1000"+firstFour);
		lblSetEmployeeId.setFont(new Font("Segoe UI", Font.BOLD, 12));
		lblSetEmployeeId.setBounds(233, 104, 224, 30);
		contentPane.add(lblSetEmployeeId);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(233, 145, 224, 23);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldEmailId = new JTextField();
		textFieldEmailId.setColumns(10);
		textFieldEmailId.setBounds(233, 209, 224, 21);
		contentPane.add(textFieldEmailId);
		
		dateChooserDob = new JDateChooser();
		dateChooserDob.setBounds(233, 177, 224, 20);
		contentPane.add(dateChooserDob);
		
		dateChooserDoj = new JDateChooser();
		dateChooserDoj.setBounds(686, 177, 224, 20);
		contentPane.add(dateChooserDoj);
		
		textFieldFatherName = new JTextField();
		textFieldFatherName.setColumns(10);
		textFieldFatherName.setBounds(686, 146, 224, 23);
		contentPane.add(textFieldFatherName);
		
		textFieldMobileNumber = new JTextField();
		textFieldMobileNumber.setColumns(10);
		textFieldMobileNumber.setBounds(233, 241, 224, 21);
		contentPane.add(textFieldMobileNumber);
		
		rdbtnMale = new JRadioButton(" Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnMale.setBounds(686, 210, 65, 23);
		contentPane.add(rdbtnMale);
		rdbtnMale.setSelected(true);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnFemale.setBounds(757, 210, 72, 23);
		contentPane.add(rdbtnFemale);
		
		rdbtnOthers = new JRadioButton("Others");
		rdbtnOthers.setFont(new Font("Tahoma", Font.BOLD, 12));
		rdbtnOthers.setBounds(834, 210, 76, 23);
		contentPane.add(rdbtnOthers);
		
		group=new ButtonGroup();
		group.add(rdbtnMale);
		group.add(rdbtnFemale);
		group.add(rdbtnOthers);
		
		
		textFieldClass10 = new JTextField();
		textFieldClass10.setColumns(10);
		textFieldClass10.setBounds(233, 275, 224, 21);
		contentPane.add(textFieldClass10);
		
		textFieldAdhaarNumber = new JTextField();
		textFieldAdhaarNumber.setColumns(10);
		textFieldAdhaarNumber.setBounds(686, 243, 224, 21);
		contentPane.add(textFieldAdhaarNumber);
		
		textFieldClass12 = new JTextField();
		textFieldClass12.setColumns(10);
		textFieldClass12.setBounds(686, 275, 224, 21);
		contentPane.add(textFieldClass12);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(233, 307, 224, 21);
		contentPane.add(textFieldUsername);
		
		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.setBounds(686, 307, 224, 20);
		contentPane.add(passwordFieldPassword);
		
		comboBoxQualification = new JComboBox();
		comboBoxQualification.setFont(new Font("Segoe UI", Font.BOLD, 11));
		comboBoxQualification.setModel(new DefaultComboBoxModel(new String[] {"BA", "B.Ed", "B.Tech", "BBA", "BCA", "B.Pharma", "B.Sc", "MA", "M.Ed", "M.Tech", "MBA", "D.Pharma", "M.Sc", "MCA"}));
		comboBoxQualification.setBounds(233, 338, 224, 22);
		comboBoxQualification.setSelectedIndex(-1);
		contentPane.add(comboBoxQualification);
		
		comboBoxExperience = new JComboBox();
		comboBoxExperience.setModel(new DefaultComboBoxModel(new String[] {"Fresher", "1 Year", "2 Years", "3 Years", "4 Years", "5 Years", "6 Years", "7 Years", "8 Years", "9 Years", "10 Years", "11 Years", "12 Years", "13 Years", "14 Years", "15 Years"}));
		comboBoxExperience.setFont(new Font("Segoe UI", Font.BOLD, 11));
		comboBoxExperience.setBounds(686, 368, 224, 22);
//		comboBoxExperience.setSelectedIndex(-1);
		contentPane.add(comboBoxExperience);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblAddress.setBounds(100, 369, 96, 21);
		contentPane.add(lblAddress);
		
		textAreaAddress = new JTextArea();
		textAreaAddress.setFont(new Font("Segoe UI", Font.BOLD, 11));
		textAreaAddress.setWrapStyleWord(true);
		textAreaAddress.setLineWrap(true);
		textAreaAddress.setBounds(233, 371, 224, 82);
		contentPane.add(textAreaAddress);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 182, 193));
		menuBar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.setBounds(0, 0, 984, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Logout");
		mnNewMenu.setForeground(new Color(30, 144, 255));
		mnNewMenu.setBackground(new Color(240, 240, 240));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("logout");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l=new Login();
				l.setVisible(true);
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
		mntmNewMenuItem.setForeground(new Color(255, 0, 0));
		mntmNewMenuItem.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu.add(mntmNewMenuItem);
		
		checkBoxShowPassword = new JCheckBox("show password");
		checkBoxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBoxShowPassword.isSelected()) {
					passwordFieldPassword.setEchoChar((char)0);
				}
				else {
					passwordFieldPassword.setEchoChar((char)'*');
				}
			}
		});
		checkBoxShowPassword.setForeground(new Color(255, 0, 255));
		checkBoxShowPassword.setFont(new Font("Segoe UI", Font.BOLD, 12));
		checkBoxShowPassword.setBounds(801, 338, 109, 23);
		contentPane.add(checkBoxShowPassword);
	}
}
