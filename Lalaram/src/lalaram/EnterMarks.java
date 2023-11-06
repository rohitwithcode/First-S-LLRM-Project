package lalaram;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import java.awt.Choice;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EnterMarks extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldClass;
	private JTextField textFieldFatherName;
	private Choice choice;
	private JLabel lblSubjects;
	private JLabel lblMarks;
	private JTextField textFieldSubject1;
	private JTextField textFieldSubject2;
	private JTextField textFieldSubject3;
	private JTextField textFieldSubject4;
	private JTextField textFieldSubject5;
	private JTextField textFieldMark1;
	private JTextField textFieldMark2;
	private JTextField textFieldMark3;
	private JTextField textFieldMark4;
	private JTextField textFieldMark5;
	private JLabel lblSemester;
	private JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnterMarks frame = new EnterMarks();
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
	public EnterMarks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(475, 115, 650,670);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStudentName = new JLabel("Enter Student Name");
		lblStudentName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblStudentName.setBounds(67, 45, 133, 20);
		contentPane.add(lblStudentName);
		
		JLabel lblEnterStudentClass = new JLabel("Enter Student Class");
		lblEnterStudentClass.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEnterStudentClass.setBounds(67, 93, 133, 20);
		contentPane.add(lblEnterStudentClass);
		
		textFieldName = new JTextField();
		textFieldName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name=textFieldName.getText();
				String classs=textFieldClass.getText();
				
				if(name.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter name");
				}
				else if(classs.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter class");
				}
				else {
					try {
						Connection c=DBConnect.getConnection();
						
						String query="select * from student where name=? and course=?";
						
						PreparedStatement s=c.prepareStatement(query);
						
						s.setString(1, name);
						s.setString(2, classs);
						
						ResultSet set=s.executeQuery();
						if (set.next()) {
		                    textFieldFatherName.setText(set.getString("fathername"));
		                    choice.removeAll(); // Clear the choice component
		                } else {
		                    JOptionPane.showMessageDialog(null, "Oops!!! Please provide valid information");
		                    return; // Exit the method if no matching records were found
		                }

		                do {
		                    choice.add(set.getString("rollno"));
		                } while (set.next());
						if(!(choice.getItemCount()>0)) {
							JOptionPane.showMessageDialog(null, "Oops!!! please provide valid information");
						}
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null,ex.getMessage());
					}
				}
			}
		});
		textFieldName.setBounds(210, 45, 169, 22);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldClass = new JTextField();
		textFieldClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name=textFieldName.getText();
				String classs=textFieldClass.getText();
				
				if(name.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter name");
				}
				else if(classs.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter class");
				}
				else {
					try {
						Connection c=DBConnect.getConnection();
						
						String query="select * from student where name=? and course=?";
						
						PreparedStatement s=c.prepareStatement(query);
						
						s.setString(1, name);
						s.setString(2, classs);
						
						ResultSet set=s.executeQuery();
						
						if (set.next()) {
		                    textFieldFatherName.setText(set.getString("fathername"));
		                    choice.removeAll(); // Clear the choice component
		                } else {
		                    JOptionPane.showMessageDialog(null, "Oops!!! Please provide valid information");
		                    return; // Exit the method if no matching records were found
		                }

		                do {
		                    choice.add(set.getString("rollno"));
		                } while (set.next());
						
						if(!(choice.getItemCount()>0)) {
							JOptionPane.showMessageDialog(null, "Oops!!! please provide valid information");
						}
						
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null,ex.getMessage());
					}
				}
			}
		});
		textFieldClass.setColumns(10);
		textFieldClass.setBounds(210, 93, 169, 20);
		contentPane.add(textFieldClass);
		
		JLabel lblFatherName = new JLabel("Father Name");
		lblFatherName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblFatherName.setBounds(67, 147, 133, 20);
		contentPane.add(lblFatherName);
		
		textFieldFatherName = new JTextField();
		textFieldFatherName.setColumns(10);
		textFieldFatherName.setBounds(210, 147, 169, 20);
		contentPane.add(textFieldFatherName);
		
		choice = new Choice();
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				String rollNumber=choice.getSelectedItem();
				
				try {
					Connection c=DBConnect.getConnection();
					
					String query="select * from student where rollno=?";
					
					PreparedStatement s=c.prepareStatement(query);
					
					s.setString(1, rollNumber);
					
					ResultSet set=s.executeQuery();
					
					if(set.next()) {
						textFieldName.setText(set.getString("name"));
						textFieldClass.setText(set.getString("course"));
						textFieldFatherName.setText(set.getString("fathername"));
					}
					else {
						JOptionPane.showMessageDialog(null, "roll number not found");
					}
					
					
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
				
			}
		});
		choice.setBounds(478, 10, 133, 20);
		contentPane.add(choice);
		
		JLabel lblRollNumber = new JLabel("Roll Number");
		lblRollNumber.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblRollNumber.setBounds(382, 10, 90, 20);
		contentPane.add(lblRollNumber);
		
		lblSubjects = new JLabel("Subjects");
		lblSubjects.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSubjects.setBounds(105, 231, 68, 20);
		contentPane.add(lblSubjects);
		
		lblMarks = new JLabel("Marks");
		lblMarks.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMarks.setBounds(478, 231, 68, 20);
		contentPane.add(lblMarks);
		
		textFieldSubject1 = new JTextField();
		textFieldSubject1.setColumns(10);
		textFieldSubject1.setBounds(26, 276, 215, 20);
		contentPane.add(textFieldSubject1);
		
		textFieldSubject2 = new JTextField();
		textFieldSubject2.setColumns(10);
		textFieldSubject2.setBounds(26, 330, 215, 20);
		contentPane.add(textFieldSubject2);
		
		textFieldSubject3 = new JTextField();
		textFieldSubject3.setColumns(10);
		textFieldSubject3.setBounds(26, 386, 215, 20);
		contentPane.add(textFieldSubject3);
		
		textFieldSubject4 = new JTextField();
		textFieldSubject4.setColumns(10);
		textFieldSubject4.setBounds(26, 441, 215, 20);
		contentPane.add(textFieldSubject4);
		
		textFieldSubject5 = new JTextField();
		textFieldSubject5.setColumns(10);
		textFieldSubject5.setBounds(26, 494, 215, 20);
		contentPane.add(textFieldSubject5);
		
		textFieldMark1 = new JTextField();
		textFieldMark1.setColumns(10);
		textFieldMark1.setBounds(421, 276, 169, 20);
		contentPane.add(textFieldMark1);
		
		textFieldMark2 = new JTextField();
		textFieldMark2.setColumns(10);
		textFieldMark2.setBounds(421, 330, 169, 20);
		contentPane.add(textFieldMark2);
		
		textFieldMark3 = new JTextField();
		textFieldMark3.setColumns(10);
		textFieldMark3.setBounds(421, 386, 169, 20);
		contentPane.add(textFieldMark3);
		
		textFieldMark4 = new JTextField();
		textFieldMark4.setColumns(10);
		textFieldMark4.setBounds(421, 441, 169, 20);
		contentPane.add(textFieldMark4);
		
		textFieldMark5 = new JTextField();
		textFieldMark5.setColumns(10);
		textFieldMark5.setBounds(421, 494, 169, 20);
		contentPane.add(textFieldMark5);
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String rollNumber=choice.getSelectedItem();
				String name=textFieldName.getText();
				String classs=textFieldClass.getText();
				String fathername=textFieldFatherName.getText();
				String semester=(String)comboBox.getSelectedItem();
				String subject1=textFieldSubject1.getText();
				String subject2=textFieldSubject2.getText();
				String subject3=textFieldSubject3.getText();
				String subject4=textFieldSubject4.getText();
				String subject5=textFieldSubject5.getText();
				String marks1=textFieldMark1.getText();
				String marks2=textFieldMark2.getText();
				String marks3=textFieldMark3.getText();
				String marks4=textFieldMark4.getText();
				String marks5=textFieldMark5.getText();
				
				if(choice.getSelectedIndex()==-1) {
					JOptionPane.showMessageDialog(null, "please enter rollNumber", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(name.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter name", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(fathername.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter father name", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(comboBox.getSelectedIndex()==-1) {
					JOptionPane.showMessageDialog(null, "please select semester ", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(subject1.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter name of subject one", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(marks1.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter marks of subject one", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(subject2.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter name of subject two", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(marks2.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter marks of subject two", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(subject3.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter name of subject three", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(marks3.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter marks of subject three", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(subject4.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter name of subject four", "ERROR", JOptionPane.ERROR_MESSAGE);
				}

				else if(marks4.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter marks of subject four", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(subject5.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter name of subject five", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else if(marks5.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter marks of subject five", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						Connection connection=DBConnect.getConnection();
						
						String insertQueryMarks="INSERT INTO studentmarks (rollno, name, class, fathername,semester, marks1, marks2, marks3, marks4, marks5) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
						String insertQuerySubjects = "INSERT INTO studentsubjects (rollno, name, class, fathername, semester ,subject1, subject2, subject3, subject4, subject5) VALUES (?, ?, ?, ? ,?, ?, ?, ?, ?, ?)";
						
						
						PreparedStatement preparedStatement = connection.prepareStatement(insertQueryMarks);
						PreparedStatement preparedStatement1 = connection.prepareStatement(insertQuerySubjects);
					    
					    preparedStatement.setString(1, rollNumber);
					    preparedStatement.setString(2, name);
					    preparedStatement.setString(3, classs);
					    preparedStatement.setString(4, fathername);
					    preparedStatement.setString(5, semester);
					    preparedStatement.setString(6, marks1);
					    preparedStatement.setString(7, marks2);
					    preparedStatement.setString(8, marks3);
					    preparedStatement.setString(9, marks4);
					    preparedStatement.setString(10, marks5);
					    
					    preparedStatement1.setString(1, rollNumber);
			            preparedStatement1.setString(2, name);
			            preparedStatement1.setString(3, classs);
			            preparedStatement1.setString(4, fathername);
			            preparedStatement1.setString(5, semester);
			            preparedStatement1.setString(6, subject1);
			            preparedStatement1.setString(7, subject2);
			            preparedStatement1.setString(8, subject3);
			            preparedStatement1.setString(9, subject4);
			            preparedStatement1.setString(10, subject5);

			            // Execute the prepared statement

						int rowsInsertMarks=preparedStatement.executeUpdate();
						 int rowsInsertedSubjects = preparedStatement1.executeUpdate();
						
						if(rowsInsertMarks>0   && rowsInsertedSubjects>0) {
							JOptionPane.showMessageDialog(null, "data upload successfully");
							textFieldName.setText("");
							textFieldClass.setText("");
							textFieldFatherName.setText("");
							comboBox.setSelectedIndex(-1);
							textFieldMark1.setText("");
							textFieldMark2.setText("");
							textFieldMark3.setText("");
							textFieldMark4.setText("");
							textFieldMark5.setText("");
							textFieldSubject1.setText("");
							textFieldSubject2.setText("");
							textFieldSubject3.setText("");
							textFieldSubject4.setText("");
							textFieldSubject5.setText("");
							choice.removeAll();
						}
						else {
							JOptionPane.showMessageDialog(null,"data upload failed");
						}
						
						preparedStatement.close();
						preparedStatement1.close();
						connection.close();
						
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}
				
			}
		});
		btnUpload.setBackground(new Color(173, 255, 47));
		btnUpload.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnUpload.setBounds(44, 566, 89, 23);
		contentPane.add(btnUpload);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBackground(new Color(220, 20, 60));
		btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCancel.setBounds(183, 566, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l=new Login();
				l.setVisible(true);
			}
		});
		btnLogout.setBackground(new Color(255, 0, 0));
		btnLogout.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnLogout.setBounds(324, 566, 89, 23);
		contentPane.add(btnLogout);
		
		lblSemester = new JLabel("Semester");
		lblSemester.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSemester.setBounds(67, 192, 133, 20);
		contentPane.add(lblSemester);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Segoe UI", Font.BOLD, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"semester1", "semester2", "semester3", "semester4", "semester5", "semester6"}));
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(210, 193, 169, 22);
		contentPane.add(comboBox);
	}
}
