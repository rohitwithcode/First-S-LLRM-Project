package lalaram;

import java.awt.EventQueue;
import javax.swing.*;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.util.Random;
import java.awt.event.InputEvent;


public class UpdateStudent extends JFrame {

	private static final long serialVersionUID = 1L;
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
	private JComboBox comboBoxCourse;
	private JRadioButton rdbtnMale,rdbtnFemale,rdbtnOthers;
	private JTextArea textAreaAddress;
	ButtonGroup group;
	private JTextField textFieldRollNumber;
	private JCheckBox checkBoxShowPassword;
	private JLabel lblAdmissionFee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStudent frame = new UpdateStudent();
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
	
//	Random random=new Random();
//    long firstFour=Math.abs((random.nextLong()%9000L)+1000L);
    
    
	public UpdateStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 125, 1000, 650);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Student");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(370, 22, 249, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmployeeId = new JLabel("Enter Roll Number");
		lblEmployeeId.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEmployeeId.setBounds(10, 71, 138, 30);
		contentPane.add(lblEmployeeId);
		
		JLabel lblName = new JLabel("Enter Name");
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
		
		JLabel lblDoj = new JLabel("Admission Date");
		lblDoj.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDoj.setBounds(557, 177, 109, 21);
		contentPane.add(lblDoj);
		
		JLabel lblQualification = new JLabel("Course");
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
		
		JLabel lblExperience = new JLabel("Admission Fee");
		lblExperience.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblExperience.setBounds(557, 367, 96, 21);
		contentPane.add(lblExperience);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			String rollNumber=textFieldRollNumber.getText();
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
			String course=(String)comboBoxCourse.getSelectedItem();
			String admissionFees=lblAdmissionFee.getText();
			String address=textAreaAddress.getText();
			
			
			if(rollNumber.isEmpty()) {
				JOptionPane.showMessageDialog(null, "please enter your roll number", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else if(name.isEmpty()) {
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
			else if(course.isEmpty()) {
				JOptionPane.showMessageDialog(null, "please select your  qualification", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
//			else if(admissionFees.isEmpty()) {
//				JOptionPane.showMessageDialog(null, "please enter admission fee", "ERROR", JOptionPane.ERROR_MESSAGE);
//			}
			else if(address.isEmpty()) {
				JOptionPane.showMessageDialog(null, "please enter your address", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			else {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/lalaramsoftware","CoderRohit","Radhey@725386");
					
						String query = "UPDATE student SET name = ?, fathername = ?,dob = ?, admissiondate = ?, emailid = ?, gender = ?, mobilenumber = ?, adhaarnumber = ?, classtenth = ?, classtwelth = ?, username = ?, password = ?, course = ?, admissionfee = ?, address = ? WHERE rollno= ?";

					
					 	PreparedStatement preparedStatement=	c.prepareStatement(query);

				            preparedStatement.setString(1, name);
				            preparedStatement.setString(2, fatherName);
				            preparedStatement.setDate(3, new java.sql.Date(dateDob.getTime()));
				            preparedStatement.setDate(4, new java.sql.Date(dateDoj.getTime()));
				            preparedStatement.setString(5, emailId);
				            preparedStatement.setString(6, gender);
				            preparedStatement.setString(7, mobileNumber);
				            preparedStatement.setString(8, adhaarNumber);
				            preparedStatement.setString(9, class10);
				            preparedStatement.setString(10, class12);
				            preparedStatement.setString(11, username);
				            preparedStatement.setString(12, password);
				            preparedStatement.setString(13, course);
				            preparedStatement.setString(14,admissionFees);
				            preparedStatement.setString(15, address);
				            preparedStatement.setString(16, rollNumber);

				            int rowsUpdated = preparedStatement.executeUpdate();

					
				         if(rowsUpdated>0) {
						JOptionPane.showMessageDialog(null, "student Updated successfully", "INSERT",JOptionPane.INFORMATION_MESSAGE);
						
							textFieldRollNumber.setText("");
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
							comboBoxCourse.setSelectedIndex(-1);
							lblAdmissionFee.setText("");
							textAreaAddress.setText("");
					}
					else {
						JOptionPane.showMessageDialog(null, "student not Updated roll number not found", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
				    preparedStatement.close();
					c.close();
					
				}catch(ClassNotFoundException | SQLException ex) {
					System.out.println(ex.getMessage());
					ex.printStackTrace();
				}
			}
			
			
			}
		});
		btnUpdate.setBackground(new Color(124, 252, 0));
		btnUpdate.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnUpdate.setBounds(100, 487, 89, 23);
		contentPane.add(btnUpdate);
		
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
				comboBoxCourse.setSelectedIndex(-1);
				lblAdmissionFee.setText("");
				textAreaAddress.setText("");
				
			}
		});
		btnReset.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnReset.setBounds(551, 487, 89, 23);
		contentPane.add(btnReset);
		
		textFieldName = new JTextField();
		textFieldName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  
					String name=textFieldName.getText();
					Connection c=DBConnect.getConnection();
					
					String query="select * from student where name=?";
					
					PreparedStatement s=c.prepareStatement(query);
					
					s.setString(1, name);
					
					ResultSet set=s.executeQuery();
					
					if(set.next()) {
						textFieldRollNumber.setText(set.getString("rollno"));
						textFieldFatherName.setText(set.getString("fathername"));
						dateChooserDob.setDate(set.getDate("dob"));
						dateChooserDoj.setDate(set.getDate("admissiondate"));
						textFieldEmailId.setText(set.getString("emailid"));
						
						String gender=set.getString("gender");
						if(gender.equalsIgnoreCase("Male")) {
							rdbtnMale.setSelected(true);
						}
						else if(gender.equalsIgnoreCase("Female")) {
							rdbtnFemale.setSelected(true);
						}
						else {
							rdbtnOthers.setSelected(true);
						}
						
						textFieldMobileNumber.setText(set.getString("mobilenumber"));
						textFieldAdhaarNumber.setText(set.getString("adhaarnumber"));
						textFieldClass10.setText(set.getString("classtenth"));
						textFieldClass12.setText(set.getString("classtwelth"));
						textFieldUsername.setText(set.getString("username"));
						passwordFieldPassword.setText(set.getString("password"));
						comboBoxCourse.setSelectedItem(set.getString("course"));
						lblAdmissionFee.setText(set.getString("admissionfee"));
						textAreaAddress.setText(set.getString("address"));
						
					}
					else {
						JOptionPane.showMessageDialog(null, "student name is not found", "ID ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
				}catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
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
		
		comboBoxCourse = new JComboBox();
		comboBoxCourse.setFont(new Font("Segoe UI", Font.BOLD, 11));
		comboBoxCourse.setModel(new DefaultComboBoxModel(new String[] {"BA", "B.Ed", "B.Tech", "BBA", "BCA", "B.Pharma", "B.Sc", "MA", "M.Ed", "M.Tech", "MBA", "D.Pharma", "M.Sc", "MCA"}));
		comboBoxCourse.setBounds(233, 338, 224, 22);
		comboBoxCourse.setSelectedIndex(-1);
		contentPane.add(comboBoxCourse);
		
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
		
		textFieldRollNumber = new JTextField();
		textFieldRollNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					  
					String rollNumber=textFieldRollNumber.getText();
					Connection c=DBConnect.getConnection();
					
					String query="select * from student where rollno=?";
					
					PreparedStatement s=c.prepareStatement(query);
					
					s.setString(1, rollNumber);
					
					ResultSet set=s.executeQuery();
					
					if(set.next()) {
						textFieldName.setText(set.getString("name"));
						textFieldFatherName.setText(set.getString("fathername"));
						dateChooserDob.setDate(set.getDate("dob"));
						dateChooserDoj.setDate(set.getDate("admissiondate"));
						textFieldEmailId.setText(set.getString("emailid"));
						
						String gender=set.getString("gender");
						if(gender.equalsIgnoreCase("Male")) {
							rdbtnMale.setSelected(true);
						}
						else if(gender.equalsIgnoreCase("Female")) {
							rdbtnFemale.setSelected(true);
						}
						else {
							rdbtnOthers.setSelected(true);
						}
						
						textFieldMobileNumber.setText(set.getString("mobilenumber"));
						textFieldAdhaarNumber.setText(set.getString("adhaarnumber"));
						textFieldClass10.setText(set.getString("classtenth"));
						textFieldClass12.setText(set.getString("classtwelth"));
						textFieldUsername.setText(set.getString("username"));
						passwordFieldPassword.setText(set.getString("password"));
						comboBoxCourse.setSelectedItem(set.getString("course"));
						lblAdmissionFee.setText(set.getString("admissionfee"));
						textAreaAddress.setText(set.getString("address"));
						
					}
					else {
						JOptionPane.showMessageDialog(null, "student roll number is not found", "ID ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
				}catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
			}
		});
		textFieldRollNumber.setBounds(143, 73, 224, 31);
		contentPane.add(textFieldRollNumber);
		textFieldRollNumber.setColumns(10);
		
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
		checkBoxShowPassword.setForeground(Color.MAGENTA);
		checkBoxShowPassword.setFont(new Font("Segoe UI", Font.BOLD, 12));
		checkBoxShowPassword.setBounds(803, 335, 109, 23);
		contentPane.add(checkBoxShowPassword);
		
		lblAdmissionFee = new JLabel("");
		lblAdmissionFee.setBounds(686, 367, 224, 21);
		contentPane.add(lblAdmissionFee);
	}
}
