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
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class DeleteFaculty extends JFrame {

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
					DeleteFaculty frame = new DeleteFaculty();
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
	public DeleteFaculty() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 225, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" Enter employee id or Name");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(43, 74, 189, 22);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(242, 77, 231, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String value=textField.getText();
				boolean found=false;
				
				if(value.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter faculty id or name", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				else {
					try {
						Connection c=DBConnect.getConnection();
						
						String query="select * from faculty";
						
						Statement st1=c.createStatement();
						
						ResultSet set=st1.executeQuery(query);
						
						while(set.next()) {
							
							String id=set.getString("id");
							String name=set.getString("name");
							
							
							if(id.equalsIgnoreCase(value)) {
								found=true;
								try {
									
									Connection c1=DBConnect.getConnection();
									
									String queryDeleteById="delete from faculty where id=?";
									
									PreparedStatement ps1=c1.prepareStatement(queryDeleteById);
									
									ps1.setString(1, id);
									
									int deleteById=ps1.executeUpdate();
									
									if(deleteById>0) {
										JOptionPane.showMessageDialog(null, "faculty delete successfully", "DELETE", JOptionPane.INFORMATION_MESSAGE);
										textField.setText("");
									}
									
								}catch(Exception ex) {
									JOptionPane.showMessageDialog(null, ex.getMessage());
								}
							}
							else if(name.equalsIgnoreCase(value)){
								found=true;
								try {
									Connection c2=DBConnect.getConnection();
									
									String queryDeleteByName="delete from faculty where name=?";
									
									PreparedStatement ps2=c2.prepareStatement(queryDeleteByName);
									ps2.setString(1, name);
									
									int deleteByName=ps2.executeUpdate();
									
									if(deleteByName>0) {
										JOptionPane.showMessageDialog(null, "faculty delete successfully", "DELETE", JOptionPane.INFORMATION_MESSAGE);
										textField.setText("");
									}
								}catch(Exception ex) {
									JOptionPane.showMessageDialog(null, ex.getMessage());
								}
							}
						}
						if(!found) {
							JOptionPane.showMessageDialog(null, "Invalid faculty id or name","ERROR" ,JOptionPane.ERROR_MESSAGE);
							textField.setText("");
						}
						
					}catch(Exception ex){
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(94, 254, 89, 23);
		contentPane.add(btnDelete);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCancel.setBackground(new Color(255, 140, 0));
		btnCancel.setBounds(223, 254, 89, 23);
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
		btnLogout.setBounds(361, 254, 89, 23);
		contentPane.add(btnLogout);
	}
}
