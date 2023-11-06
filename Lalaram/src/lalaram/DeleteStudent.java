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
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;
public class DeleteStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldRollOrName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteStudent frame = new DeleteStudent();
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
	public DeleteStudent() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 275, 500, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Roll Number or Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(43, 58, 190, 22);
		contentPane.add(lblNewLabel);
		
		textFieldRollOrName = new JTextField();
		textFieldRollOrName.setBounds(258, 61, 183, 20);
		contentPane.add(textFieldRollOrName);
		textFieldRollOrName.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String value=textFieldRollOrName.getText();
				boolean found=false;
				
				if(value.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter rollno or name", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
				try {
					
					
					Connection c=DBConnect.getConnection();
					String query="select * from student";
					Statement s=c.createStatement();
					ResultSet set=s.executeQuery(query);
					while(set.next()) {
						String rollNumber=set.getString("rollno");
						String name=set.getString("name");
						
						if(rollNumber.equalsIgnoreCase(value)) {
							found=true;
							String queryDeleteByRollNumber="delete from student  where rollno =?" ;
							
							PreparedStatement st=c.prepareStatement(queryDeleteByRollNumber);
							
							st.setString(1, rollNumber);
							
							int deletebyRoll=st.executeUpdate();
							if(deletebyRoll>0) {
								JOptionPane.showMessageDialog(null, "Student deleted successfully", "DELETE", JOptionPane.INFORMATION_MESSAGE);
								textFieldRollOrName.setText("");
							}    
						}
						
						else if(name.equalsIgnoreCase(value)) {
							found=true;
							String queryDeleteByName="delete from student where name = ?";
							
							PreparedStatement statment=c.prepareStatement(queryDeleteByName);
							
							statment.setString(1, name);
							
							int deleteByName=statment.executeUpdate();
							
							if(deleteByName>0) {
								JOptionPane.showMessageDialog(null, "Student deleted successfully", "DELETE", JOptionPane.INFORMATION_MESSAGE);
								textFieldRollOrName.setText("");
							}
						}
					}
					if(!found) {
						JOptionPane.showMessageDialog(null, "Invalid student rollno or name","ERROR" ,JOptionPane.ERROR_MESSAGE);
						textFieldRollOrName.setText("");
					}
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
			}
		});
		btnDelete.setBounds(85, 159, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setBackground(new Color(255, 140, 0));
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBounds(214, 159, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l=new Login();
				l.setVisible(true);
			}
		});
		btnLogout.setBackground(new Color(240, 128, 128));
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnLogout.setBounds(352, 159, 89, 23);
		contentPane.add(btnLogout);
	}

}
