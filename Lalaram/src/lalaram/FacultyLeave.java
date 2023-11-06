package lalaram;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class FacultyLeave extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldFacultyId;
	private JTextField textFieldFatherName;
	private JDateChooser dateChooser;
	private Choice choice; 
	private JTextField textFieldName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FacultyLeave frame = new FacultyLeave();
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
	public FacultyLeave() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 175, 700, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Apply Leave(Faculty)");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(10, 11, 305, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Faculty Id");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1.setBounds(57, 113, 85, 20);
		contentPane.add(lblNewLabel_1);
		
		textFieldFacultyId = new JTextField();
		textFieldFacultyId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id=textFieldFacultyId.getText();
				boolean idFound=false;
				
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter faculty id for leave", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
				try {
					Connection c=DBConnect.getConnection();
					
					String query="select * from faculty where id=?";
					
					PreparedStatement s=c.prepareStatement(query);
					
					s.setString(1, id);
					
					ResultSet set=s.executeQuery();
					
					while(set.next()) {
						idFound=true;
						textFieldName.setEditable(true);
						textFieldFatherName.setEditable(true);
						dateChooser.setEnabled(true);
						choice.setEnabled(true);
						textFieldName.setText(set.getString("name"));
						textFieldFatherName.setText(set.getString("fathername"));
					}
					
					if(!idFound) {
						JOptionPane.showMessageDialog(null, "faculty id not found in our database.Please input valid faculty id");
					}
					
					s.close();
					c.close();
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				}
			}
		});
		textFieldFacultyId.setBounds(166, 115, 172, 20);
		contentPane.add(textFieldFacultyId);
		textFieldFacultyId.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Father Name");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(57, 213, 94, 20);
		contentPane.add(lblNewLabel_1_1);
		
		textFieldFatherName = new JTextField();
		textFieldFatherName.setEditable(false);
		textFieldFatherName.setColumns(10);
		textFieldFatherName.setBounds(166, 215, 172, 20);
		contentPane.add(textFieldFatherName);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Leave Date");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_1_1.setBounds(57, 264, 94, 20);
		contentPane.add(lblNewLabel_1_1_1);
		
		dateChooser = new JDateChooser();
		dateChooser.setEnabled(false);
		dateChooser.setBounds(166, 264, 172, 20);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Time Duration");
		lblNewLabel_1_1_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_1_2.setBounds(57, 317, 105, 20);
		contentPane.add(lblNewLabel_1_1_2);
		
		choice = new Choice();
		choice.setBounds(166, 317, 172, 20);
		choice.add("");
		choice.add("Half Day");
		choice.add("Full Day");
		choice.select(0);
		choice.setEnabled(false);
		contentPane.add(choice);
		
		JButton btnLeave = new JButton("Granted");
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id=textFieldFacultyId.getText();
				String name=textFieldName.getText();
				String fathername=textFieldFatherName.getText();
				java.util.Date leaveDate=dateChooser.getDate();
				String leaveDuration=choice.getSelectedItem();
				
				
				if(id.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter facult id for leave", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						Connection connection=DBConnect.getConnection();
						
						//String query="insert into studentleave values(id,name,fathername,leavedate,leaveduration)";
						
			            String insertQuery = "INSERT INTO facultyleave (id, name, fathername, leavedate, leaveduration) VALUES (?, ?, ?, ?, ?)";
			            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

			            preparedStatement.setString(1, id);
			            preparedStatement.setString(2, name);
			            preparedStatement.setString(3, fathername);
			            preparedStatement.setDate(4, new java.sql.Date(leaveDate.getTime()));
			            preparedStatement.setString(5, leaveDuration);

			            // Execute the prepared statement
			            int rowsInserted = preparedStatement.executeUpdate();

			            if (rowsInserted > 0) {
			                JOptionPane.showMessageDialog(null, "Leave Granted Successfully");
			                textFieldFacultyId.setText("");
			                textFieldName.setText("");
			                textFieldFatherName.setText("");
			                dateChooser.setDate(null);
			                choice.select(0);
			            } else {
			                JOptionPane.showMessageDialog(null, "Leave not granted some problem occured!!!");
			            }
						
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}
				
			}
		});
		btnLeave.setBackground(new Color(173, 255, 47));
		btnLeave.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnLeave.setBounds(57, 369, 89, 23);
		contentPane.add(btnLeave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBackground(new Color(255, 0, 0));
		btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCancel.setBounds(236, 369, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Faculty Name");
		lblNewLabel_1_1_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_1_3.setBounds(57, 164, 105, 20);
		contentPane.add(lblNewLabel_1_1_3);
		
		textFieldName = new JTextField();
		textFieldName.setEditable(false);
		textFieldName.setColumns(10);
		textFieldName.setBounds(166, 166, 172, 20);
		contentPane.add(textFieldName);
	}
}
