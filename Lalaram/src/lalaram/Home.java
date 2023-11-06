package lalaram;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Font;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(475, 200, 650, 500);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBarLogin = new JMenuBar();
		menuBarLogin.setBackground(new Color(255, 250, 205));
		menuBarLogin.setBounds(0, 0, 634, 22);
		contentPane.add(menuBarLogin);
		
		JMenu menuLogin = new JMenu("Login");
		menuLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuLogin.setBackground(new Color(255, 250, 240));
		menuBarLogin.add(menuLogin);
		
		JMenuItem menuItemLogin = new JMenuItem("login");
		menuItemLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Login l=new Login();
				l.setVisible(true);
			}
		});
		menuItemLogin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_DOWN_MASK));
		menuItemLogin.setBackground(new Color(255, 250, 240));
		menuItemLogin.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuLogin.add(menuItemLogin);
		
		JMenu mnNewMenu = new JMenu("Courses");
		mnNewMenu.setBackground(new Color(128, 0, 128));
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBarLogin.add(mnNewMenu);
		
		JMenuItem menuItemCoursesAndFee = new JMenuItem("courses and fee");
		menuItemCoursesAndFee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				CoursesAndFeeShowUser caf=new CoursesAndFeeShowUser();
				caf.setVisible(true);
				
			}
		});
		menuItemCoursesAndFee.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
		menuItemCoursesAndFee.setForeground(new Color(128, 0, 0));
		menuItemCoursesAndFee.setBackground(new Color(255, 250, 240));
		menuItemCoursesAndFee.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu.add(menuItemCoursesAndFee);
		
		JMenu mnNewMenu_1 = new JMenu("About");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		menuBarLogin.add(mnNewMenu_1);
		
		JMenuItem menuItemAbout = new JMenuItem("about");
		menuItemAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				About about=new About();
				about.setVisible(true);
			}
		});
		menuItemAbout.setForeground(new Color(0, 255, 255));
		menuItemAbout.setBackground(new Color(255, 250, 240));
		menuItemAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK | InputEvent.SHIFT_DOWN_MASK));
		menuItemAbout.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mnNewMenu_1.add(menuItemAbout);
	}
}
