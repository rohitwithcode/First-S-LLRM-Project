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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Choice;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Choice choiceRollNumber;
	private JTable table;
	private JScrollPane jsp;
	private JButton btnLogout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStudent frame = new ViewStudent();
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
	public ViewStudent() {
		setTitle("View Student");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 150, 1600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeachByRoll = new JLabel("Seach by Roll Number");
		lblSeachByRoll.setBounds(10, 11, 153, 22);
		lblSeachByRoll.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblSeachByRoll);
		
		choiceRollNumber = new Choice();
		choiceRollNumber.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				try {
					String rollno=choiceRollNumber.getSelectedItem();	
					
					Connection c=DBConnect.getConnection();
					
					String query="select * from student where rollno=?";
					
					PreparedStatement s=c.prepareStatement(query);
					
					s.setString(1, rollno);
					
					ResultSet set=s.executeQuery();
					
					table.setModel(DbUtils.resultSetToTableModel(set));
					
					s.close();
					c.close();
					
				}catch(Exception ex) {
					System.out.println(ex.getMessage());
				}
				
			}
		});
		choiceRollNumber.setBounds(180, 11, 167, 22);
		choiceRollNumber.setFont(new Font("Dialog", Font.BOLD, 12));
		contentPane.add(choiceRollNumber);
		
		try {
			Connection c=DBConnect.getConnection();
			
			String query="select * from student";
			
			Statement s=c.createStatement();
			
			ResultSet set=s.executeQuery(query);
			
			while(set.next()) {
				choiceRollNumber.add(set.getString("rollno"));
			}
			
			s.close();
			c.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		table=new JTable();
		
		jsp=new JScrollPane(table);
		jsp.setBounds(0,90,1600,510);
		contentPane.add(jsp);
		
		
		try {
			Connection c=DBConnect.getConnection();
			
			String query="select * from student";
			
			Statement s=c.createStatement();
			
			ResultSet set=s.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(set));
			
			
			
			s.close();
			c.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l=new Login();
				l.setVisible(true);
			}
		});
		btnLogout.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnLogout.setBackground(Color.RED);
		btnLogout.setBounds(20, 44, 89, 23);
		contentPane.add(btnLogout);
	}

}
