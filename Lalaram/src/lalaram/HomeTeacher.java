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
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.InputEvent;

public class HomeTeacher extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeTeacher frame = new HomeTeacher();
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
	public HomeTeacher() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 150, 1230, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(127, 255, 212));
		menuBar.setBounds(0, 0, 1214, 22);
		contentPane.add(menuBar);
		
		JMenu menuNewInformation = new JMenu("New Information");
		menuNewInformation.setForeground(new Color(139, 0, 0));
		menuNewInformation.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menuNewInformation);
		
		JMenuItem mntmNewStudent = new JMenuItem("New Student");
		mntmNewStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
		mntmNewStudent.addActionListener(this);
		mntmNewStudent.setForeground(new Color(255, 0, 0));
		mntmNewStudent.setBackground(Color.WHITE);
		mntmNewStudent.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuNewInformation.add(mntmNewStudent);
		
		JMenuItem mntmNewCourse = new JMenuItem("New Course");
		mntmNewCourse.addActionListener(this);
		mntmNewCourse.setForeground(new Color(51, 0, 204));
		mntmNewCourse.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmNewCourse.setBackground(Color.WHITE);
		menuNewInformation.add(mntmNewCourse);
		
		JMenu menuViewInformation = new JMenu("View Information");
		menuViewInformation.setBackground(new Color(255, 255, 255));
		menuViewInformation.setForeground(new Color(255, 51, 51));
		menuViewInformation.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menuViewInformation);
		
		JMenuItem mntmViewStudent = new JMenuItem("View Student");
		mntmViewStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));
		mntmViewStudent.addActionListener(this);
		mntmViewStudent.setForeground(new Color(255, 153, 255));
		mntmViewStudent.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmViewStudent.setBackground(Color.WHITE);
		menuViewInformation.add(mntmViewStudent);
		
		JMenuItem mntmViewCourse = new JMenuItem("view course");
		mntmViewCourse.addActionListener(this);
		mntmViewCourse.setForeground(new Color(51, 0, 204));
		mntmViewCourse.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmViewCourse.setBackground(Color.WHITE);
		menuViewInformation.add(mntmViewCourse);
		
		JMenu menuUpdateInformation = new JMenu("Update Information");
		menuUpdateInformation.setForeground(new Color(204, 51, 102));
		menuUpdateInformation.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menuUpdateInformation);
		
		JMenuItem mntmUpdateStudent = new JMenuItem("update student");
		mntmUpdateStudent.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
		mntmUpdateStudent.addActionListener(this);
		mntmUpdateStudent.setForeground(new Color(139, 0, 139));
		mntmUpdateStudent.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmUpdateStudent.setBackground(Color.WHITE);
		menuUpdateInformation.add(mntmUpdateStudent);
		
		JMenuItem mntmUpdateCourse = new JMenuItem("update course");
		mntmUpdateCourse.setForeground(new Color(51, 0, 204));
		mntmUpdateCourse.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmUpdateCourse.setBackground(Color.WHITE);
		menuUpdateInformation.add(mntmUpdateCourse);
		
		JMenu menuDeleteInformation = new JMenu("Delete Information");
		menuDeleteInformation.setForeground(new Color(255, 0, 0));
		menuDeleteInformation.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menuDeleteInformation);
		
		JMenuItem mntmDeleteStudent = new JMenuItem("delete student");
		mntmDeleteStudent.addActionListener(this);
		mntmDeleteStudent.setForeground(new Color(0, 0, 255));
		mntmDeleteStudent.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmDeleteStudent.setBackground(Color.WHITE);
		menuDeleteInformation.add(mntmDeleteStudent);
		
		JMenuItem mntmDeleteCourse = new JMenuItem("delete course");
		mntmDeleteCourse.addActionListener(this);
		mntmDeleteCourse.setForeground(new Color(51, 0, 204));
		mntmDeleteCourse.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmDeleteCourse.setBackground(Color.WHITE);
		menuDeleteInformation.add(mntmDeleteCourse);
		
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
		
		JMenuItem mntmStudentFeeForm = new JMenuItem("student fee form");
		mntmStudentFeeForm.addActionListener(this);
		mntmStudentFeeForm.setForeground(new Color(102, 204, 51));
		mntmStudentFeeForm.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmStudentFeeForm.setBackground(Color.WHITE);
		menuCoursesAndFeeDetails.add(mntmStudentFeeForm);
		
		JMenu menuMarks = new JMenu("Marks");
		menuMarks.setForeground(new Color(0, 0, 102));
		menuMarks.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menuMarks);
		
		JMenuItem mntmEnterMarks = new JMenuItem("Enter Marks");
		mntmEnterMarks.addActionListener(this);
		mntmEnterMarks.setForeground(new Color(102, 0, 51));
		mntmEnterMarks.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuMarks.add(mntmEnterMarks);
		
		JMenu menuLeave = new JMenu("Leave");
		menuLeave.setForeground(new Color(255, 102, 153));
		menuLeave.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menuLeave);
		
		JMenuItem mntmLeaveStudent = new JMenuItem("leave student");
		mntmLeaveStudent.addActionListener(this);
		mntmLeaveStudent.setForeground(new Color(51, 0, 204));
		mntmLeaveStudent.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmLeaveStudent.setBackground(Color.WHITE);
		menuLeave.add(mntmLeaveStudent);
		
		JMenu menuLeaveDetails = new JMenu("Leave Details");
		menuLeaveDetails.setForeground(new Color(51, 0, 102));
		menuLeaveDetails.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menuLeaveDetails);
		
		JMenuItem mntmViewStudentLeave = new JMenuItem("view student leave");
		mntmViewStudentLeave.addActionListener(this);
		mntmViewStudentLeave.setForeground(new Color(0, 0, 51));
		mntmViewStudentLeave.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmViewStudentLeave.setBackground(Color.WHITE);
		menuLeaveDetails.add(mntmViewStudentLeave);
		
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
		
		JMenu menuExamination = new JMenu("Examination");
		menuExamination.setForeground(new Color(0, 204, 0));
		menuExamination.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menuExamination);
		
		JMenuItem mntmEnterExaminationDate = new JMenuItem("enter examination date and time");
		mntmEnterExaminationDate.addActionListener(this);
		mntmEnterExaminationDate.setForeground(new Color(0, 204, 255));
		mntmEnterExaminationDate.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuExamination.add(mntmEnterExaminationDate);
		
		JMenuItem mntmViewExaminationDate = new JMenuItem("view examination date and time");
		mntmViewExaminationDate.addActionListener(this);
		mntmViewExaminationDate.setForeground(new Color(0, 0, 0));
		mntmViewExaminationDate.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuExamination.add(mntmViewExaminationDate);
		
		JMenu menuResult = new JMenu("Result");
		menuResult.setForeground(new Color(255, 160, 122));
		menuResult.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBar.add(menuResult);
		
		JMenuItem mntmViewResult = new JMenuItem("view result");
		
		mntmViewResult.setForeground(new Color(51, 204, 204));
		mntmViewResult.addActionListener(this);
		mntmViewResult.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuResult.add(mntmViewResult);
		
		JMenu menuLogout = new JMenu("Logout");
		menuLogout.setForeground(new Color(255, 0, 0));
		menuBar.add(menuLogout);
		menuLogout.setFont(new Font("Segoe UI", Font.BOLD, 14));
		
		JMenuItem mntmLogout = new JMenuItem("logout");
		mntmLogout.addActionListener(this);
		mntmLogout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
		mntmLogout.setForeground(new Color(0, 0, 255));
		mntmLogout.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuLogout.add(mntmLogout);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String message=e.getActionCommand(); // it retrieve the button's label text
		
		if(message.equalsIgnoreCase("new student")) {
			dispose();
			NewStudent ns= new NewStudent();
			ns.setVisible(true);
		}
		else if(message.equalsIgnoreCase("new faculty")) {
			dispose();
			NewFaculty nf= new NewFaculty();
			nf.setVisible(true);
		}
		else if(message.equalsIgnoreCase("new course")) {
			dispose();
			NewCourse nc= new NewCourse();
			nc.setVisible(true);
		}
		else if(message.equalsIgnoreCase("view student")) {
			dispose();
			ViewStudent vs=new ViewStudent();
			vs.setVisible(true);
		}
		else if(message.equalsIgnoreCase("view faculty")) {
			dispose();
			ViewFaculty vf=new ViewFaculty();
			vf.setVisible(true);
		}
		else if(message.equalsIgnoreCase("view course")) {
			dispose();
			CoursesAndFeeShowUser cafsu=new CoursesAndFeeShowUser();
			cafsu.setVisible(true);
		}
		else if(message.equalsIgnoreCase("update student")) {
			dispose();
			UpdateStudent up=new UpdateStudent();
			up.setVisible(true);
		}
		else if(message.equalsIgnoreCase("update faculty")) {
			dispose();
			UpdateFaculty uf=new UpdateFaculty();
			uf.setVisible(true);
		}
		else if(message.equalsIgnoreCase("delete student")) {
			dispose();
			DeleteStudent ds=new DeleteStudent();
			ds.setVisible(true);
		}
		else if(message.equalsIgnoreCase("delete faculty")) {
			dispose();
			DeleteFaculty df=new DeleteFaculty();
			df.setVisible(true);
		}
		else if(message.equalsIgnoreCase("delete course")) {
			dispose();
			DeleteCourse dc=new DeleteCourse();
			dc.setVisible(true);
		}
		else if(message.equalsIgnoreCase("courses")) {
			dispose();
			CoursesAndFeeShowUser cafsu=new CoursesAndFeeShowUser();
			cafsu.setVisible(true);
		}
		else if(message.equalsIgnoreCase("logout")){
			dispose();
			Login l=new Login();
			l.setVisible(true);
		}
		else if(message.equalsIgnoreCase("student fee form")){
			dispose();
			StudentFeeForm sff=new StudentFeeForm();
			sff.setVisible(true);
		}
		else if(message.equalsIgnoreCase("enter marks")){
			dispose();
			EnterMarks em=new EnterMarks();
			em.setVisible(true);
		}
		else if(message.equalsIgnoreCase("leave Student")){
			dispose();
			LeaveStudent ls=new LeaveStudent();
			ls.setVisible(true);
		}
		else if(message.equalsIgnoreCase("leave Faculty")){
			dispose();
			FacultyLeave fl=new FacultyLeave();
			fl.setVisible(true);
		}
		else if(message.equalsIgnoreCase("View Student leave")){
			dispose();
			ViewStudentLeaveDetails vsld=new ViewStudentLeaveDetails();
			vsld.setVisible(true);
		}
		else if(message.equalsIgnoreCase("View faculty leave")){
			dispose();
			ViewFacultyLeaveDetails vfld=new ViewFacultyLeaveDetails();
			vfld.setVisible(true);
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
	        else if(message.equalsIgnoreCase("enter examination date and time")){
				dispose();
				EnterExaminationDate eed=new EnterExaminationDate();
				eed.setVisible(true);
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
		else {
			JOptionPane.showMessageDialog(null, "Sorry!!! You entered wrong input.Please enter a valid input.Try agian.....", message, ABORT);
		}
	}
}
