package lalaram;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EnterExaminationDate extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldSession;
	private JTextField textFieldSemester;
	private JTextField textFieldShift;
	private JTextField textFieldTime;
	private JTextField textFieldSubject;
	private JTextField textFieldTitle;
	private JComboBox comboBox;
	private JDateChooser dateChooser;
	private JTextField textFieldClass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EnterExaminationDate frame = new EnterExaminationDate();
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
	public EnterExaminationDate() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 150, 800,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lalaram Shri Devi Mahavidhyalaya Atrauli");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNewLabel.setBounds(227, 0, 301, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Examination Session ");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1.setBounds(36, 73, 185, 21);
		contentPane.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 32, 784, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 0, 784, 2);
		contentPane.add(separator_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter Examination Semester ");
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(36, 119, 197, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Enter Examination Shift");
		lblNewLabel_1_2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(36, 167, 185, 21);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Enter Examination Time");
		lblNewLabel_1_3.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_3.setBounds(36, 211, 185, 21);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Enter Examination Date");
		lblNewLabel_1_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_4.setBounds(36, 261, 185, 21);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Enter Subject");
		lblNewLabel_1_5.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_5.setBounds(36, 359, 185, 21);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Enter Paper Title");
		lblNewLabel_1_6.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_6.setBounds(36, 404, 185, 21);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Enter Examination Day");
		lblNewLabel_1_7.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_7.setBounds(36, 309, 185, 21);
		contentPane.add(lblNewLabel_1_7);
		
		textFieldSession = new JTextField();
		textFieldSession.setBounds(266, 75, 276, 20);
		contentPane.add(textFieldSession);
		textFieldSession.setColumns(10);
		
		textFieldSemester = new JTextField();
		textFieldSemester.setColumns(10);
		textFieldSemester.setBounds(266, 121, 276, 20);
		contentPane.add(textFieldSemester);
		
		textFieldShift = new JTextField();
		textFieldShift.setColumns(10);
		textFieldShift.setBounds(266, 169, 276, 20);
		contentPane.add(textFieldShift);
		
		 dateChooser = new JDateChooser();
		dateChooser.setBounds(266, 262, 276, 20);
		contentPane.add(dateChooser);
		
		textFieldTime = new JTextField();
		textFieldTime.setColumns(10);
		textFieldTime.setBounds(266, 213, 276, 20);
		contentPane.add(textFieldTime);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}));
		comboBox.setBounds(266, 310, 276, 22);
		comboBox.setSelectedIndex(-1);
		contentPane.add(comboBox);
		
		textFieldSubject = new JTextField();
		textFieldSubject.setColumns(10);
		textFieldSubject.setBounds(266, 361, 276, 20);
		contentPane.add(textFieldSubject);
		
		textFieldTitle = new JTextField();
		textFieldTitle.setColumns(10);
		textFieldTitle.setBounds(266, 406, 276, 20);
		contentPane.add(textFieldTitle);
		
		JButton btnAdd = new JButton("Addd Schedule");
		btnAdd.setBackground(new Color(127, 255, 0));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String session=textFieldSession.getText();
				String semester=textFieldSemester.getText();
				String shift=textFieldShift.getText();
				String t=textFieldTime.getText();
				String subject=textFieldSubject.getText();
				String title=textFieldTitle.getText();
				String day=(String)comboBox.getSelectedItem();
				java.util.Date date=dateChooser.getDate();
				String classs=textFieldClass.getText();
				
				if(session.isEmpty()) {
					JOptionPane.showMessageDialog(null, "please enter examination session", "ERROR", JOptionPane.ERROR_MESSAGE);
					textFieldSession.requestFocus();
				}
				else if(semester.isEmpty()){
					JOptionPane.showMessageDialog(null, "please enter examination semester", "ERROR", JOptionPane.ERROR_MESSAGE);
					textFieldSemester.requestFocus();
				}
				else if(shift.isEmpty()){
					JOptionPane.showMessageDialog(null, "please enter examination shift", "ERROR", JOptionPane.ERROR_MESSAGE);
					textFieldShift.requestFocus();
				}
				else if(t.isEmpty()){
					JOptionPane.showMessageDialog(null, "please enter examination time", "ERROR", JOptionPane.ERROR_MESSAGE);
					textFieldTime.requestFocus();
				}
				else if(date==null){
					JOptionPane.showMessageDialog(null, "please enter examination date", "ERROR", JOptionPane.ERROR_MESSAGE);
					dateChooser.requestFocus();
				}
				else if(comboBox.getSelectedIndex()==-1){
					JOptionPane.showMessageDialog(null, "please enter examination day", "ERROR", JOptionPane.ERROR_MESSAGE);
					comboBox.requestFocus();
				}
				else if(subject.isEmpty()){
					JOptionPane.showMessageDialog(null, "please enter examination subject", "ERROR", JOptionPane.ERROR_MESSAGE);
					textFieldSubject.requestFocus();
				}
				else if(title.isEmpty()){
					JOptionPane.showMessageDialog(null, "please enter subject title", "ERROR", JOptionPane.ERROR_MESSAGE);
					textFieldTitle.requestFocus();
				}
				else if(classs.isEmpty()){
					JOptionPane.showMessageDialog(null, "please enter class", "ERROR", JOptionPane.ERROR_MESSAGE);
					textFieldClass.requestFocus();
				}
				else {
				try {
					Connection c=DBConnect.getConnection();
					
					String query="insert into examinationschedule(session,semester,shift,time,subject,title,day,date,class) values(?,?,?,?,?,?,?,?,?)";
					
					
					PreparedStatement s=c.prepareStatement(query);
					
					s.setString(1, session);
					s.setString(2, semester);
					s.setString(3, shift);
					s.setString(4, t);
					s.setString(5, subject);
					s.setString(6, title);
					s.setString(7, day);
					s.setDate(8,new java.sql.Date(date.getTime()));
					s.setString(9, classs);
					int insert=s.executeUpdate();
					
					if(insert>0) {
						JOptionPane.showMessageDialog(null, "Data inserted ");
					}
					
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				}
			}
		});
		btnAdd.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnAdd.setBounds(96, 527, 138, 23);
		contentPane.add(btnAdd);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(new Color(255, 0, 0));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCancel.setBounds(293, 527, 89, 23);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_1_6_1 = new JLabel("Enter Class");
		lblNewLabel_1_6_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_1_6_1.setBounds(36, 450, 185, 21);
		contentPane.add(lblNewLabel_1_6_1);
		
		textFieldClass = new JTextField();
		textFieldClass.setColumns(10);
		textFieldClass.setBounds(266, 452, 276, 20);
		contentPane.add(textFieldClass);
	}
}
