package lalaram;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JSeparator;
import javax.swing.JTable;

public class ViewExaminationDate extends JFrame {

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
					ViewExaminationDate frame = new ViewExaminationDate();
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
	public ViewExaminationDate() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lalaram Shri Devi Mahavidhyalaya Atrauli");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel.setBounds(227, 0, 301, 34);
		contentPane.add(lblNewLabel);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 0, 784, 2);
		contentPane.add(separator_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 32, 784, 2);
		contentPane.add(separator);
		
		JLabel lblExaminationScheduleSession = new JLabel("Examination Schedule");
		lblExaminationScheduleSession.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblExaminationScheduleSession.setBounds(295, 32, 164, 34);
		contentPane.add(lblExaminationScheduleSession);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 64, 784, 2);
		contentPane.add(separator_2);
		
		table=new JTable();
		
		jsp=new JScrollPane(table);
		jsp.setBounds(0,70,800,430);;
		contentPane.add(jsp);
		
		try {
			
			Connection c=DBConnect.getConnection();
			
			String query="select * from examinationschedule";
			
			Statement s=c.createStatement();
			
			ResultSet set=s.executeQuery(query);
			
			table.setModel(DbUtils.resultSetToTableModel(set));
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}
}
