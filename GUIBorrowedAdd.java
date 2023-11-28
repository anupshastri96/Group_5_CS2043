
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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

public class GUIBorrowedAdd extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton genmem;
	private JTextField Bookid;
	private JTextField memtxt;
	private JTextField datetxt;
	private JTextField retdatetxt;
	private Book bookIn;
	private Member memberIn;


	public GUIBorrowedAdd(Book bookIn, Member memberIn) {
		this.memberIn = memberIn;
		this.bookIn = bookIn;
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
		
		JLabel lblNewLabel_1 = new JLabel("BOOK TITLE: " + bookIn.getName());
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(176, 87, 270, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("MEMBER FIRST/LAST NAME: " + memberIn.getFirstname() + " " + memberIn.getLastname());
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(176, 126, 270, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("EXPECTED RETURN DATE:");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(176, 216, 103, 14);
		contentPane.add(lblNewLabel_1_3);
		
		retdatetxt = new JTextField();
		retdatetxt.setColumns(10);
		retdatetxt.setBounds(327, 213, 146, 20);
		contentPane.add(retdatetxt);
		
		genmem = new JButton("ID GENERERATE");
		genmem.addActionListener(this);
			
		genmem.setBounds(356, 295, 111, 23);
		contentPane.add(genmem);

		this.setVisible(true);
	}
	

	public void actionPerformed(ActionEvent e) {
		// Add checks for if it can be made or not
        if (e.getSource() == genmem) {
            Date convertedReturnDate = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
            // Parse the string to obtain a Date object
             convertedReturnDate = dateFormat.parse(retdatetxt.getText());
            //JOptionPane.showMessageDialog(null, "Converted Date: " + convertedDate);
        } catch (ParseException pe) {
            // Display an error message using JOptionPane
            JOptionPane.showMessageDialog(null, "Error: Unable to parse the string as a date. Please Retry",
                    "Error", JOptionPane.ERROR_MESSAGE);
            retdatetxt.setText("");
            pe.printStackTrace();
        }
		LibraryManagementSystem.getCurrentLibrary().borrowBook(memberIn, bookIn, convertedReturnDate);
        } 
	}

}
