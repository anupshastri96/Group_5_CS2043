
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BorrowedBookGUI extends JFrame {

	private JPanel contentPane;
	private static JTextField Bookid;
	private static JTextField memtxt;
	private static JTextField datetxt;
	private static JTextField retdatetxt;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowedBookGUI frame = new BorrowedBookGUI();
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
	public BorrowedBookGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BORROW BOOK");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(274, 11, 130, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BOOKID:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(176, 87, 81, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("MEMBER ID:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(176, 126, 81, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("CURRENT DATE:");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(176, 168, 103, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("RETURN DATE:");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(176, 216, 103, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("EXTEND:");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(176, 250, 81, 14);
		contentPane.add(lblNewLabel_1_4);
		
		Bookid = new JTextField();
		Bookid.setColumns(10);
		Bookid.setBounds(327, 84, 146, 20);
		contentPane.add(Bookid);
		
		memtxt = new JTextField();
		memtxt.setColumns(10);
		memtxt.setBounds(327, 123, 146, 20);
		contentPane.add(memtxt);
		
		datetxt = new JTextField();
		datetxt.setColumns(10);
		datetxt.setBounds(327, 165, 146, 20);
		contentPane.add(datetxt);
		
		retdatetxt = new JTextField();
		retdatetxt.setColumns(10);
		retdatetxt.setBounds(327, 213, 146, 20);
		contentPane.add(retdatetxt);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(327, 247, 146, 20);
		contentPane.add(textField_4);
		
		JButton genmem = new JButton("ID GENERERATE");
		genmem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		genmem.setBounds(356, 295, 111, 23);
		contentPane.add(genmem);
	}
	
	private static void borrowgen() {
		Date convertedBorrowDate = null;
		Date convertedReturnDate = null;
		int bookid = Integer.parseInt(Bookid.getText());
		int memid = Integer.parseInt(memtxt.getText());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
            // Parse the string to obtain a Date object
             convertedBorrowDate = dateFormat.parse(datetxt.getText());
             convertedReturnDate = dateFormat.parse(retdatetxt.getText());
            //JOptionPane.showMessageDialog(null, "Converted Date: " + convertedDate);
        } catch (ParseException e) {
            // Display an error message using JOptionPane
            JOptionPane.showMessageDialog(null, "Error: Unable to parse the string as a date. Please Retry",
                    "Error", JOptionPane.ERROR_MESSAGE);
            datetxt.setText("");
            retdatetxt.setText("");
            e.printStackTrace();
        }
		
		//BorrowedBook book = new BorrowedBook(bookid,memid,convertedBorrowDate,convertedReturnDate);
		
	}

}
