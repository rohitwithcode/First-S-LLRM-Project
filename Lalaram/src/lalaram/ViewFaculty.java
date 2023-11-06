package lalaram;

import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Choice;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewFaculty extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Choice choiceEmployeeId;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewFaculty frame = new ViewFaculty();
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
	public ViewFaculty() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 150, 1600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Seach by Employee Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 11, 153, 24);
		contentPane.add(lblNewLabel);
		
		choiceEmployeeId = new Choice();
		choiceEmployeeId.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				try {
					String id=choiceEmployeeId.getSelectedItem();
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/lalaramsoftware","CoderRohit","Radhey@725386");
					
					String query="select * from faculty where id=?";
					
					PreparedStatement s=c.prepareStatement(query);
					
					s.setString(1, id);
					
					ResultSet set=s.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(set));
					
					
					s.close();
					c.close();
					
				}catch(ClassNotFoundException | SQLException ex) {
					System.out.println(ex.getMessage());
				}
				
			}
		});
		choiceEmployeeId.setFont(new Font("Dialog", Font.BOLD, 12));
		choiceEmployeeId.setBounds(187, 10, 176, 20);
		contentPane.add(choiceEmployeeId);
		
		
		try {
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/lalaramsoftware","CoderRohit","Radhey@725386");
			
			String query="select * from faculty";
			
			Statement s=c.createStatement();
			
			ResultSet set=s.executeQuery(query);
			
			while(set.next()) {
				choiceEmployeeId.add(set.getString("id"));
			}
			
			
			s.close();
			c.close();
			
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		table =new JTable();
		
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(0,90,1600,510);
		contentPane.add(jsp);
		
		
		try {
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/lalaramsoftware","CoderRohit","Radhey@725386");
			
			
			String query="select * from faculty ";
			
			PreparedStatement s=c.prepareStatement(query);
			
			//s.setString(1, id);
			
			ResultSet set=s.executeQuery();
			
			table.setModel(DbUtils.resultSetToTableModel(set));
			
			s.close();
			c.close();
			
		}catch(ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		}
		
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
		btnLogout.setBounds(20, 46, 89, 23);
		contentPane.add(btnLogout);
	}
}
