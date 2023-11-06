package lalaram;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

public class ViewResult extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JSeparator separator;
	private JLabel lblViewName;
	private JLabel lblViewFatherName;
	private JLabel lblClass;
	private JLabel lblNewLabel_4;
	private JTextField textFieldRollNumber;
	 JLabel labelName = new JLabel();
	    JLabel labelFatherName = new JLabel();
	    JLabel labelClass = new JLabel();
	    JLabel labelSemester = new JLabel();
	    JLabel labelS1 = new JLabel();
	    JLabel labelS2 = new JLabel();
	    JLabel labelS3 = new JLabel();
	    JLabel labelS4 = new JLabel();
	    JLabel labelS5 = new JLabel();
	    JLabel labelM1 = new JLabel();
	    JLabel labelM2 = new JLabel();
	    JLabel labelM3 = new JLabel();
	    JLabel labelM4 = new JLabel();
	    JLabel labelM5 = new JLabel();

	private JButton btnPrint;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewResult frame = new ViewResult();
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
	public void printFrame() {
	    PrinterJob job = PrinterJob.getPrinterJob();

	    if (job.printDialog()) {
	        try {
	            job.print();
	        } catch (PrinterException e) {
	            e.printStackTrace();
	        }
	    }
	}

	private BufferedImage captureContent() {
	    int width = contentPane.getWidth();
	    int height = contentPane.getHeight();
	    BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2d = image.createGraphics();
	    contentPane.paint(g2d);
	    g2d.dispose();
	    return image;
	}
	
	private void printImage(BufferedImage image) {
	    PrinterJob job = PrinterJob.getPrinterJob();
	    job.setPrintable(new Printable() {
	        @Override
	        public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
	            if (page > 0) {
	                return Printable.NO_SUCH_PAGE;
	            }

	            Graphics2D g2d = (Graphics2D) g;
	            double scaleX = pf.getImageableWidth() / image.getWidth();
	            double scaleY = pf.getImageableHeight() / image.getHeight();
	            double scale = Math.min(scaleX, scaleY);
	            g2d.scale(scale, scale);
	            g2d.drawImage(image, 0, 0, null);

	            return Printable.PAGE_EXISTS;
	        }
	    });

	    if (job.printDialog()) {
	        try {
	            job.print();
	        } catch (PrinterException e) {
	            e.printStackTrace();
	        }
	    }
	}


	public ViewResult() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Exmination Result");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNewLabel.setBounds(10, 11, 212, 34);
		contentPane.add(lblNewLabel);
		
		separator = new JSeparator();
		separator.setBounds(0, 47, 884, 2);
		contentPane.add(separator);
		
		lblViewName = new JLabel("Name");
		lblViewName.setVisible(false);
		lblViewName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblViewName.setBounds(31, 108, 46, 14);
		contentPane.add(lblViewName);
		
		lblViewFatherName = new JLabel("Father Name");
		lblViewFatherName.setVisible(false);
		lblViewFatherName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblViewFatherName.setBounds(31, 142, 86, 20);
		contentPane.add(lblViewFatherName);
		
		lblClass = new JLabel("Class");
		lblClass.setVisible(false);
		lblClass.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblClass.setBounds(31, 182, 46, 14);
		contentPane.add(lblClass);
		
		lblNewLabel_4 = new JLabel("Roll Number");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel_4.setBounds(31, 74, 103, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblSemester = new JLabel("Semester");
		lblSemester.setVisible(false);
		lblSemester.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSemester.setBounds(31, 218, 68, 14);
		contentPane.add(lblSemester);
		
		JLabel lblSubjects = new JLabel("Subjects");
		lblSubjects.setVisible(false);
		lblSubjects.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSubjects.setBounds(144, 259, 68, 20);
		contentPane.add(lblSubjects);
		
		JLabel lblMarks = new JLabel("Marks");
		lblMarks.setVisible(false);
		lblMarks.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblMarks.setBounds(586, 259, 68, 20);
		contentPane.add(lblMarks);
		
		
		textFieldRollNumber = new JTextField();
		textFieldRollNumber.setFont(new Font("Segoe UI", Font.BOLD, 12));
		textFieldRollNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String rollNumber=textFieldRollNumber.getText();
				
				try {
					Connection c=DBConnect.getConnection();
					
					String querySubject="select * from studentsubjects where rollno=?";
					String queryMark="select * from studentmarks where rollno=?";
					
					
					PreparedStatement s2=c.prepareStatement(querySubject);
					PreparedStatement s1=c.prepareStatement(queryMark);
					
					s1.setString(1, rollNumber);
					s2.setString(1, rollNumber);
					
					ResultSet set1=s1.executeQuery();
					ResultSet set2=s2.executeQuery();
					
					if(set1.next() && set2.next()) {
						//textFieldRollNumber.setEditable(false);
						btnPrint.setVisible(true);
						lblMarks.setVisible(true);
						lblSemester.setVisible(true);
						lblViewFatherName.setVisible(true);
						lblViewName.setVisible(true);
						lblSubjects.setVisible(true);
						lblClass.setVisible(true);
						
						labelName.setText(set1.getString("name"));
					    labelFatherName.setText(set1.getString("fathername"));
					    labelClass.setText(set1.getString("class"));
					    labelSemester.setText(set1.getString("semester"));
					    labelS1.setText(set2.getString("subject1"));
					    labelS2.setText(set2.getString("subject2"));
					    labelS3.setText(set2.getString("subject3"));
					    labelS4.setText(set2.getString("subject4"));
					    labelS5.setText(set2.getString("subject5"));
					    labelM1.setText(set1.getString("marks1"));
					    labelM2.setText(set1.getString("marks2"));
					    labelM3.setText(set1.getString("marks3"));
					    labelM4.setText(set1.getString("marks4"));
					    labelM5.setText(set1.getString("marks5"));

					}
					else {
						btnPrint.setVisible(false);
						JOptionPane.showMessageDialog(null, "roll number not found our database,Enter valid roll number", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				
			}
		});
		textFieldRollNumber.setBounds(144, 73, 217, 20);
		contentPane.add(textFieldRollNumber);
		textFieldRollNumber.setColumns(10);
		
		
		
		
		labelM1.setBounds(598, 304, 169, 20);
		contentPane.add(labelM1);
		
		
		labelS1.setBounds(146, 304, 215, 20);
		contentPane.add(labelS1);
		
		
		labelS2.setBounds(146, 358, 215, 20);
		contentPane.add(labelS2);
		
		labelM2.setBounds(598, 358, 169, 20);
		contentPane.add(labelM2);
		
		
		labelM3.setBounds(598, 414, 169, 20);
		contentPane.add(labelM3);
		
		
		labelS3.setBounds(146, 414, 215, 20);
		contentPane.add(labelS3);
		
	
		labelS4.setBounds(146, 469, 215, 20);
		contentPane.add(labelS4);
		
		labelM4.setBounds(598, 469, 169, 20);
		contentPane.add(labelM4);
		
		labelS5.setBounds(146, 522, 215, 20);
		contentPane.add(labelS5);
		
		labelM5.setBounds(598, 522, 169, 20);
		contentPane.add(labelM5);
		
		
		labelName.setBounds(146, 107, 215, 20);
		contentPane.add(labelName);
		
		
		labelFatherName.setBounds(146, 144, 215, 20);
		contentPane.add(labelFatherName);
		
		
		labelClass.setBounds(146, 181, 215, 20);
		contentPane.add(labelClass);
		
		
		labelSemester.setBounds(146, 217, 215, 20);
		contentPane.add(labelSemester);
		
		btnPrint = new JButton("Print");
		btnPrint.setVisible(false);
		btnPrint.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	btnPrint.setVisible(false);
		    	textFieldRollNumber.setEditable(false);
		        BufferedImage contentImage = captureContent();
		        printImage(contentImage);
		        textFieldRollNumber.setEditable(true);
		        btnPrint.setVisible(true);
		    }
		});
		btnPrint.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnPrint.setBackground(new Color(250, 128, 114));
		btnPrint.setBounds(415, 70, 89, 23);
		contentPane.add(btnPrint);
		
		
	}
}
