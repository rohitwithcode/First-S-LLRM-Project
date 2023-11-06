package lalaram;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class UpdateCourse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCourseName;
	private JTextField textFieldSemester1Fee;
	private JTextField textFieldSemester2Fee;
	private JTextField textFieldSemester3Fee;
	private JTextField textFieldSemester4Fee;
	private JTextField textFieldSemester5Fee;
	private JTextField textFieldSemester6Fee;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateCourse frame = new UpdateCourse();
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
	public UpdateCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(425, 175, 750, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Course and Fee Semesterwise");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 11, 579, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblCourseName = new JLabel("Enter Course Name");
		lblCourseName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCourseName.setBounds(40, 102, 131, 20);
		contentPane.add(lblCourseName);
		
		JLabel lblSemesterFee = new JLabel("Semester1 Fee");
		lblSemesterFee.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSemesterFee.setBounds(40, 143, 104, 20);
		contentPane.add(lblSemesterFee);
		
		JLabel lblSemesterFee_1 = new JLabel("Semester2 Fee");
		lblSemesterFee_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSemesterFee_1.setBounds(40, 189, 104, 20);
		contentPane.add(lblSemesterFee_1);
		
		JLabel lblSemesterFee_1_1 = new JLabel("Semester3 Fee");
		lblSemesterFee_1_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSemesterFee_1_1.setBounds(40, 238, 104, 20);
		contentPane.add(lblSemesterFee_1_1);
		
		JLabel lblSemesterFee_1_2 = new JLabel("Semester4 Fee");
		lblSemesterFee_1_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSemesterFee_1_2.setBounds(40, 287, 104, 20);
		contentPane.add(lblSemesterFee_1_2);
		
		JLabel lblSemesterFee_1_3 = new JLabel("Semester5 Fee");
		lblSemesterFee_1_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSemesterFee_1_3.setBounds(40, 333, 104, 20);
		contentPane.add(lblSemesterFee_1_3);
		
		JLabel lblSemesterFee_1_4 = new JLabel("Semester6 Fee");
		lblSemesterFee_1_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSemesterFee_1_4.setBounds(40, 381, 104, 20);
		contentPane.add(lblSemesterFee_1_4);
		
		textFieldCourseName = new JTextField();
		textFieldCourseName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String courseName=textFieldCourseName.getText();
				
				try {
					
					Connection c=DBConnect.getConnection();
					
					String query="select * from feestructure where course =?";
					
					PreparedStatement s=c.prepareStatement(query);
					
					s.setString(1, courseName);
					
					ResultSet set=s.executeQuery();
					
					if(set.next()) {
						textFieldSemester1Fee.setText(set.getString("semester1"));
						textFieldSemester2Fee.setText(set.getString("semester2"));
						textFieldSemester3Fee.setText(set.getString("semester3"));
						textFieldSemester4Fee.setText(set.getString("semester4"));
						textFieldSemester5Fee.setText(set.getString("semester6"));
						textFieldSemester6Fee.setText(set.getString("semester6"));
						textFieldCourseName.setEditable(false);	
					}
					else {
						JOptionPane.showMessageDialog(null,"This course is not provide by the college.Please enter the name of the course which is taught in the college.","ERROR",JOptionPane.ERROR_MESSAGE);
						textFieldCourseName.setEditable(true);
					}	
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			}
		});
		textFieldCourseName.setBounds(188, 104, 247, 20);
		contentPane.add(textFieldCourseName);
		textFieldCourseName.setColumns(10);
		
		textFieldSemester1Fee = new JTextField();
		textFieldSemester1Fee.setColumns(10);
		textFieldSemester1Fee.setBounds(188, 145, 247, 20);
		contentPane.add(textFieldSemester1Fee);
		
		textFieldSemester2Fee = new JTextField();
		textFieldSemester2Fee.setColumns(10);
		textFieldSemester2Fee.setBounds(188, 191, 247, 20);
		contentPane.add(textFieldSemester2Fee);
		
		textFieldSemester3Fee = new JTextField();
		textFieldSemester3Fee.setColumns(10);
		textFieldSemester3Fee.setBounds(188, 240, 247, 20);
		contentPane.add(textFieldSemester3Fee);
		
		textFieldSemester4Fee = new JTextField();
		textFieldSemester4Fee.setColumns(10);
		textFieldSemester4Fee.setBounds(188, 289, 247, 20);
		contentPane.add(textFieldSemester4Fee);
		
		textFieldSemester5Fee = new JTextField();
		textFieldSemester5Fee.setColumns(10);
		textFieldSemester5Fee.setBounds(188, 335, 247, 20);
		contentPane.add(textFieldSemester5Fee);
		
		textFieldSemester6Fee = new JTextField();
		textFieldSemester6Fee.setColumns(10);
		textFieldSemester6Fee.setBounds(188, 383, 247, 20);
		contentPane.add(textFieldSemester6Fee);
		
		JButton btnUpdateCourse = new JButton("Update Course");
		btnUpdateCourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String course=textFieldCourseName.getText();
				String s1=textFieldSemester1Fee.getText();
				String s2=textFieldSemester2Fee.getText();
				String s3=textFieldSemester3Fee.getText();
				String s4=textFieldSemester4Fee.getText();
				String s5=textFieldSemester5Fee.getText();
				String s6=textFieldSemester6Fee.getText();
				
				
				if(course.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter course name", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(s1.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter semester1 fee", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(s2.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter semester2 fee", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(s3.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter semester3 fee", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(s4.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter semester4 fee", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
				else {
					
					
					try {
						Connection c=DBConnect.getConnection();
						
						String query= "UPDATE feestructure SET semester1 = ?, semester2 = ?, semester3 = ?, semester4 = ?, semester5 = ?, semester6 = ? WHERE course = ?";;
						
						PreparedStatement s=c.prepareStatement(query);
						
						
						s.setString(1, s1);
						s.setString(2, s2);
						s.setString(3, s3);
						s.setString(4, s4);
						s.setString(5, s5);
						s.setString(6, s6);
						s.setString(7, course);
						
					int insert=s.executeUpdate();
					
					if(insert>0) {
						JOptionPane.showMessageDialog(null, "course updated successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
						textFieldCourseName.setEditable(true);
						textFieldCourseName.setText("");
						textFieldSemester1Fee.setText("");
						textFieldSemester2Fee.setText("");
						textFieldSemester3Fee.setText("");
						textFieldSemester4Fee.setText("");
						textFieldSemester5Fee.setText("");
						textFieldSemester6Fee.setText("");
					}
					else {
						JOptionPane.showMessageDialog(null,"course not updated.");
//						textFieldCourseName.setText("");
//						textFieldSemester1Fee.setText("");
//						textFieldSemester2Fee.setText("");
//						textFieldSemester3Fee.setText("");
//						textFieldSemester4Fee.setText("");
//						textFieldSemester5Fee.setText("");
//						textFieldSemester6Fee.setText("");
					}
						
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null,ex.getMessage());
					}
				}
				
			}
		});
		btnUpdateCourse.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnUpdateCourse.setBounds(40, 445, 145, 23);
		contentPane.add(btnUpdateCourse);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCancel.setBounds(223, 445, 111, 23);
		contentPane.add(btnCancel);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldCourseName.setText("");
				textFieldSemester1Fee.setText("");
				textFieldSemester2Fee.setText("");
				textFieldSemester3Fee.setText("");
				textFieldSemester4Fee.setText("");
				textFieldSemester5Fee.setText("");
				textFieldSemester6Fee.setText("");
			}
		});
		btnReset.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnReset.setBounds(390, 445, 111, 23);
		contentPane.add(btnReset);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l=new Login();
				l.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnLogout.setBounds(557, 445, 111, 23);
		contentPane.add(btnLogout);
	}
}
