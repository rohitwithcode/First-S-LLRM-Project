package lalaram;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class HomeStudent extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeStudent frame = new HomeStudent();
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
	public HomeStudent() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 255, 255));
		menuBar.setBounds(0, 0, 684, 22);
		contentPane.add(menuBar);
		
		JMenu menuCoursesAndFeeDetails = new JMenu("Courses and Fee Details");
		menuCoursesAndFeeDetails.setForeground(new Color(51, 0, 51));
		menuCoursesAndFeeDetails.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menuCoursesAndFeeDetails);
		
		JMenuItem mntmCourses = new JMenuItem("courses");
		mntmCourses.addActionListener(this);
		mntmCourses.setForeground(new Color(204, 102, 255));
		mntmCourses.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmCourses.setBackground(Color.WHITE);
		menuCoursesAndFeeDetails.add(mntmCourses);
		
		JMenu menuUtility = new JMenu("Utility");
		menuUtility.setForeground(new Color(102, 0, 51));
		menuUtility.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menuUtility);
		
		JMenuItem mntmNotepad = new JMenuItem("Notepad");
		mntmNotepad.addActionListener(this);
		mntmNotepad.setForeground(new Color(255, 153, 255));
		mntmNotepad.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNotepad.setBackground(Color.WHITE);
		menuUtility.add(mntmNotepad);
		
		JMenuItem mntmCalculator = new JMenuItem("Calculator");
		mntmCalculator.addActionListener(this);
		mntmCalculator.setForeground(new Color(0, 255, 153));
		mntmCalculator.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmCalculator.setBackground(Color.WHITE);
		menuUtility.add(mntmCalculator);
		
		JMenu menuResult = new JMenu("Result");
		menuResult.setForeground(new Color(255, 160, 122));
		menuResult.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menuResult);
		
		JMenuItem mntmViewResult = new JMenuItem("view result");
		mntmViewResult.addActionListener(this);
		mntmViewResult.setForeground(new Color(51, 204, 204));
		mntmViewResult.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuResult.add(mntmViewResult);
		
		JMenu menuExamination = new JMenu("Examination");
		menuExamination.setForeground(new Color(0, 204, 0));
		menuExamination.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menuExamination);
		
		JMenuItem mntmViewExaminationDate = new JMenuItem("view examination date and time");
		mntmViewExaminationDate.addActionListener(this);
		mntmViewExaminationDate.setForeground(Color.BLACK);
		mntmViewExaminationDate.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuExamination.add(mntmViewExaminationDate);
		
		JMenu menuLogout = new JMenu("Logout");
		menuLogout.setForeground(Color.RED);
		menuLogout.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menuLogout);
		
		JMenuItem mntmLogout = new JMenuItem("logout");
		mntmLogout.addActionListener(this);
		mntmLogout.setForeground(Color.BLUE);
		mntmLogout.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuLogout.add(mntmLogout);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String message=e.getActionCommand();
		
		if(message.equalsIgnoreCase("view course")) {
			dispose();
			CoursesAndFeeShowUser cafsu=new CoursesAndFeeShowUser();
			cafsu.setVisible(true);
		}
		 else if(message.equalsIgnoreCase("Calculator")){
	            try{
	                Runtime.getRuntime().exec("calc.exe");
	            }catch(IOException e1){
	                System.out.println(e1.getMessage()); 
	            }
	        }
	        else if(message.equalsIgnoreCase("notepad")){
	            try {
	                Runtime.getRuntime().exec("notepad.exe");
	            } catch (IOException ex) {
	                System.out.println(ex.getMessage());
	            }
	        }
	        else if(message.equalsIgnoreCase("view examination date and time")) {
	        	dispose();
	        	ViewExaminationDate ved=new ViewExaminationDate();
	        	ved.setVisible(true);
	        }
	        else if(message.equalsIgnoreCase("view result")) {
	        	dispose();
	        	ViewResult vr=new ViewResult();
	        	vr.setVisible(true);
	        }
	        else if(message.equalsIgnoreCase("logout")) {
	        	dispose();
	        	Login l=new Login();
	        	l.setVisible(true);
	        }
		else {
			JOptionPane.showMessageDialog(null, "Sorry!!! You entered wrong input.Please enter a valid input.Try agian.....", message, ABORT);
		}
		
	}
}
