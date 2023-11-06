package lalaram;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import java.awt.Font;

public class ViewStudentLeaveDetails extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JScrollPane jsp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewStudentLeaveDetails frame = new ViewStudentLeaveDetails();
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
	public ViewStudentLeaveDetails() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(475, 200, 650, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		
		table=new JTable();
//		
		jsp=new JScrollPane(table);
		jsp.setBounds(0,60,650,440);
		contentPane.add(jsp);
		
		try {
			Connection c=DBConnect.getConnection();
			
			String query="select * from studentleave";
			
			Statement s=c.createStatement();
			
			ResultSet set=s.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(set));
			
			s.close();
			c.close();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Leave Details");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblNewLabel.setBounds(10, 10, 361, 45);
		contentPane.add(lblNewLabel);
	}

}
