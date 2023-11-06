package lalaram;

import java.awt.EventQueue;
import javax.swing.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import java.sql.*;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CoursesAndFeeShowUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoursesAndFeeShowUser frame = new CoursesAndFeeShowUser();
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
	public CoursesAndFeeShowUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 1000, 700);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Courses and Fee Structure");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 50));
		lblNewLabel.setBounds(10, 11, 616, 67);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
//		table.setBounds(10, 110, 964, 540);
//		contentPane.add(table);
		
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(10,110,964,540);
		contentPane.add(jsp);
		
		try {
			String driver1="com.mysql.cj.jdbc.Driver";
			Class.forName(driver1);
			
			String url="jdbc:mysql://localhost:3306/lalaramsoftware";
			String username="CoderRohit";
			String password="Radhey@725386";
			Connection c=DriverManager.getConnection(url,username,password);
			
			String query="select * from feestructure";
			
			Statement s=c.createStatement();
			
			ResultSet set=s.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(set));
			
			JButton btnBack = new JButton("Back");
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
					Home home=new Home();
					home.setVisible(true);
				}
			});
			btnBack.setForeground(new Color(0, 0, 0));
			btnBack.setBackground(new Color(255, 228, 181));
			btnBack.setFont(new Font("Segoe UI", Font.BOLD, 16));
			btnBack.setBounds(678, 35, 107, 38);
			contentPane.add(btnBack);
			
			s.close();
			c.close();
			
		}catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
			
		}catch(SQLException e1) {
			System.out.println(e1.getMessage());
			
		}
	}
}
