package lib;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class MembershipGUI extends JFrame {

	private JPanel contentPane;
	private static JTextField Nametxt;
	private static JTextField lasttxt;
	private static JTextField DOBtxt;
	private static JTextField addtxt;
	private static JTextField gentxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MembershipGUI frame = new MembershipGUI();
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
	public MembershipGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MEMBERSHIP");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(287, 11, 111, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("FIRST NAME:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(129, 107, 81, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("LAST NAME:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(129, 146, 81, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("DATE OF BIRTH:");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(129, 188, 103, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("ADDRESS:");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(129, 236, 81, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("GENDER:");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(129, 270, 81, 14);
		contentPane.add(lblNewLabel_1_4);
		
		Nametxt = new JTextField();
		Nametxt.setBounds(280, 104, 146, 20);
		contentPane.add(Nametxt);
		Nametxt.setColumns(10);
		
		lasttxt = new JTextField();
		lasttxt.setColumns(10);
		lasttxt.setBounds(280, 143, 146, 20);
		contentPane.add(lasttxt);
		
		DOBtxt = new JTextField();
		DOBtxt.setColumns(10);
		DOBtxt.setBounds(280, 185, 146, 20);
		contentPane.add(DOBtxt);
		
		addtxt = new JTextField();
		addtxt.setColumns(10);
		addtxt.setBounds(280, 233, 146, 20);
		contentPane.add(addtxt);
		
		gentxt = new JTextField();
		gentxt.setColumns(10);
		gentxt.setBounds(280, 267, 146, 20);
		contentPane.add(gentxt);
		
		JButton genmem = new JButton("ID GENERERATE");
		genmem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				membergen();
			}
		});
		genmem.setBounds(309, 315, 111, 23);
		contentPane.add(genmem);
	}
	
	private static void membergen() {
		String gender = gentxt.getText();
		String address = addtxt.getText();
		String DOB = DOBtxt.getText();
		String Fname = Nametxt.getText();
		String Lname = lasttxt.getText();
		
		 Random random = new Random();

	        // Generate a random number between 10,000 and 99,999
	        int memberid = random.nextInt(90000) + 10000;
	    member membernew = new member(Integer.parseInt(DOB),Fname,Lname,gender,memberid);
	}
}
