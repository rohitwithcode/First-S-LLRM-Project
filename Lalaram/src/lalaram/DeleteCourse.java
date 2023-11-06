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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class DeleteCourse extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCourse frame = new DeleteCourse();
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
	public DeleteCourse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(475, 200, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterCourseName = new JLabel("Enter Course Name");
		lblEnterCourseName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblEnterCourseName.setBounds(95, 62, 138, 22);
		contentPane.add(lblEnterCourseName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(243, 61, 231, 29);
		contentPane.add(textField);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String course=textField.getText();
				
				if(course.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter course name", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					try {
						Connection c=DBConnect.getConnection();
						
						String query="delete from feestructure where course=?";
						
						PreparedStatement s=c.prepareStatement(query);
						
						s.setString(1, course);
						
						int delete=s.executeUpdate();
						
						if(delete>0) {
							JOptionPane.showMessageDialog(null, "course deleted successfully", "INFOROMATION", JOptionPane.INFORMATION_MESSAGE);
							textField.setText("");
						}
						else {
							JOptionPane.showMessageDialog(null, "course not found in college", "ERROR", JOptionPane.ERROR_MESSAGE);
//							textField.setText("");
						}
						
						
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(146, 242, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBackground(new Color(255, 140, 0));
		btnCancel.setBounds(275, 242, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l=new Login();
				l.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogout.setBackground(new Color(240, 128, 128));
		btnLogout.setBounds(413, 242, 89, 23);
		contentPane.add(btnLogout);
	}

}
