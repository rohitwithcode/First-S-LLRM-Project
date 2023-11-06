package lalaram;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Choice;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;

public class StudentFeeForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	Choice choiceName;
	private JLabel lblFathersName;
	private JTextField textFieldFatherName;
	private JLabel lblClass;
	private JLabel lblSemester;
	private JLabel lblDate;
	private JTextField textFieldClass;
	private JTextField textFieldEnterFee;
	private JComboBox comboBoxSemester;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFeeForm frame = new StudentFeeForm();
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
	public StudentFeeForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(375, 150, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRollNumber = new JLabel("Roll Number");
		lblRollNumber.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblRollNumber.setBounds(408, 10, 91, 20);
		contentPane.add(lblRollNumber);
		
		choiceName = new Choice();
		choiceName.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				String rollNumber=choiceName.getSelectedItem();
				try {
					Connection c=DBConnect.getConnection();
					
					String query="select * from student where rollno=?";
					
					
					PreparedStatement s=c.prepareStatement(query);
					
					s.setString(1, rollNumber);
					
					ResultSet set=s.executeQuery();
					
					while(set.next()) {
						textFieldName.setText(set.getString("name"));
						textFieldFatherName.setText(set.getString("fathername"));
						textFieldClass.setText(set.getString("course"));
					}
					
					
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			}
		});
		
		choiceName.setBounds(505, 10, 164, 20);
		contentPane.add(choiceName);
	
		
		JLabel lblEnterName = new JLabel("Enter Name");
		lblEnterName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEnterName.setBounds(40, 110, 91, 20);
		contentPane.add(lblEnterName);
		
		textFieldName = new JTextField();
		textFieldName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textFieldName.getText();
				String class1=textFieldClass.getText();
				if(name.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter your good name", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(class1.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter your class", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
				try {
					Connection c=DBConnect.getConnection();
					
					String query="select * from student where name=? and course=?";
					
					PreparedStatement s=c.prepareStatement(query);
					
					s.setString(1,name);
					s.setString(2, class1);
					
					ResultSet set=s.executeQuery();

					if (set.next()) {
	                    textFieldFatherName.setText(set.getString("fathername"));
	                    choiceName.removeAll(); // Clear the choice component
	                } else {
	                    JOptionPane.showMessageDialog(null, "Oops!!! Please provide valid information");
	                    return; // Exit the method if no matching records were found
	                }

	                do {
	                    choiceName.add(set.getString("rollno"));
	                } while (set.next());
					if(!(choiceName.getItemCount()>0)) {
						JOptionPane.showMessageDialog(null, "Oops Sorry!!! Please provide valid information");
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				}
				
			}
		});
		textFieldName.setBounds(179, 112, 223, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		lblFathersName = new JLabel("Father's Name");
		lblFathersName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblFathersName.setBounds(40, 204, 116, 20);
		contentPane.add(lblFathersName);
		
		textFieldFatherName = new JTextField();
		textFieldFatherName.setColumns(10);
		textFieldFatherName.setBounds(179, 206, 223, 20);
		contentPane.add(textFieldFatherName);
		
		lblClass = new JLabel("Enter Class");
		lblClass.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblClass.setBounds(40, 158, 116, 20);
		contentPane.add(lblClass);
		
		lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSemester.setBounds(40, 250, 116, 20);
		contentPane.add(lblSemester);
		
		lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDate.setBounds(40, 294, 116, 20);
		contentPane.add(lblDate);
		
		textFieldClass = new JTextField();
		textFieldClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textFieldName.getText();
				String class1=textFieldClass.getText();
				if(name.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter your good name", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(class1.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter your class", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
				try {
					Connection c=DBConnect.getConnection();
					
					String query="select * from student where name=? and course=?";
					
					PreparedStatement s=c.prepareStatement(query);
					
					s.setString(1,name);
					s.setString(2, class1);
					
					ResultSet set=s.executeQuery();

					if (set.next()) {
	                    textFieldFatherName.setText(set.getString("fathername"));
	                    choiceName.removeAll(); // Clear the choice component
	                } else {
	                    JOptionPane.showMessageDialog(null, "Oops!!! Please provide valid information");
	                    return; // Exit the method if no matching records were found
	                }

	                do {
	                    choiceName.add(set.getString("rollno"));
	                } while (set.next());
					
					if(!(choiceName.getItemCount()>0)) {
						JOptionPane.showMessageDialog(null, "Oops Sorry!!! Please provide valid information");
					}
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				}
				
			}
		});
		textFieldClass.setColumns(10);
		textFieldClass.setBounds(179, 160, 223, 20);
		contentPane.add(textFieldClass);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(179, 294, 223, 20);
		contentPane.add(dateChooser);
		
		comboBoxSemester = new JComboBox();
		comboBoxSemester.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		comboBoxSemester.setModel(new DefaultComboBoxModel(new String[] {"Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6"}));
		comboBoxSemester.setBounds(179, 251, 223, 22);
		comboBoxSemester.setSelectedIndex(-1);
		contentPane.add(comboBoxSemester);
		
		JButton btnPayFee = new JButton("Pay Fee");
		btnPayFee.setBackground(new Color(34, 139, 34));
		btnPayFee.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnPayFee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String rollNumber=choiceName.getSelectedItem();
				String name=textFieldName.getText();
				String classs=textFieldClass.getText();
				String fatherName=textFieldFatherName.getText();
				String semester=(String)comboBoxSemester.getSelectedItem();
				java.util.Date date=dateChooser.getDate();
				String enterFee=textFieldEnterFee.getText();
				
				 if(choiceName.getSelectedIndex()==-1) {
						JOptionPane.showMessageDialog(null, "please enter the student roll number");
					}
				else if(name.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter the student name");
				}
				else if(classs.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter the student class");
				}
				else if(fatherName.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter the student father name");
				}
				else if(comboBoxSemester.getSelectedIndex()==-1) {
						JOptionPane.showMessageDialog(null, "please select the student semester");
					}
				else if(date==null) {
					JOptionPane.showMessageDialog(null, "please select pay fee date");
				}
				else if(enterFee.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter the fee amount");
				}
				else {
					try {
						Connection c=DBConnect.getConnection();
						
						String query="insert into studentfee values(?,?,?,?,?,?,?)";
						
						PreparedStatement s=c.prepareStatement(query);
						
						s.setString(1, rollNumber);
						s.setString(2, name);
						s.setString(3, classs);
						s.setString(4, fatherName);
						s.setString(5, semester);
						s.setDate(6, new java.sql.Date(date.getTime()));
						s.setString(7, enterFee);
						
						int insertFee=s.executeUpdate();
						
						if(insertFee>0) {
							JOptionPane.showMessageDialog(null, "fee pay successful", "", JOptionPane.INFORMATION_MESSAGE);
							textFieldName.setText("");
							textFieldClass.setText("");
							textFieldFatherName.setText("");
							comboBoxSemester.setSelectedIndex(-1);
							dateChooser.setDate(null);
							textFieldEnterFee.setText("");
						}
						
						s.close();
						c.close();
						
						
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}
			}
		});
		btnPayFee.setBounds(40, 431, 89, 23);
		contentPane.add(btnPayFee);
		
		JLabel lblEnterFee = new JLabel("Enter Fee");
		lblEnterFee.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEnterFee.setBounds(40, 347, 116, 20);
		contentPane.add(lblEnterFee);
		
		textFieldEnterFee = new JTextField();
		textFieldEnterFee.setColumns(10);
		textFieldEnterFee.setBounds(179, 349, 223, 20);
		contentPane.add(textFieldEnterFee);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(255, 0, 0));
		btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBounds(179, 431, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBackground(new Color(255, 127, 80));
		btnLogout.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l=new Login();
				l.setVisible(true);
			}
		});
		btnLogout.setBounds(313, 431, 89, 23);
		contentPane.add(btnLogout);
		
		JLabel lblStudentFeeForm = new JLabel("Student Fee Form");
		lblStudentFeeForm.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblStudentFeeForm.setBounds(10, 0, 292, 47);
		contentPane.add(lblStudentFeeForm);
	}
}
