
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
	private JButton borrowButton;
	private JButton backButton;
	private JTextField retdatetxt;
	private Book bookIn;
	private Member memberIn;
	private boolean bookStart;


	public GUIBorrowedAdd(boolean bookStart, Book bookIn, Member memberIn) {
		this.memberIn = memberIn;
		this.bookIn = bookIn;
		this.bookStart = bookStart;

		this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 340);
        this.setResizable(false);

        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Font buttonFont = new Font("Arial", Font.PLAIN, 16);

		borrowButton = new JButton("Borrow");
        borrowButton.setBounds(140,240,85,50);
        borrowButton.setFocusable(false);
		borrowButton.setFont(buttonFont);
        borrowButton.addActionListener(this);
		contentPane.add(borrowButton);

		backButton = new JButton("Back");
		backButton.setBounds(10, 15, 68, 50);
        backButton.setFocusable(false);
		backButton.setFont(buttonFont);
        backButton.addActionListener(this);
		contentPane.add(backButton);
		
		JLabel lblNewLabel_1 = new JLabel("Book title: " + bookIn.getName());
		lblNewLabel_1.setFont(buttonFont);
		lblNewLabel_1.setBounds(10, 75, 340, 35);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Member name: " + memberIn.getFirstname() + " " + memberIn.getLastname());
		lblNewLabel_1_1.setFont(buttonFont);
		lblNewLabel_1_1.setBounds(10,115,340,35);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Return by:");
		lblNewLabel_1_3.setFont(buttonFont);
		lblNewLabel_1_3.setBounds(10,155,200,35);
		contentPane.add(lblNewLabel_1_3);
		
		retdatetxt = new JTextField();
		retdatetxt.setColumns(10);
		retdatetxt.setFont(buttonFont);
		retdatetxt.setBounds(100, 155, 200, 35);
		contentPane.add(retdatetxt);

		this.setVisible(true);
	}
	

	public void actionPerformed(ActionEvent e) {
		boolean canBeCreated = true;
        if (e.getSource() == borrowButton) {
            Date convertedReturnDate = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
             convertedReturnDate = dateFormat.parse(retdatetxt.getText());
        } catch (ParseException pe) {
            
            JOptionPane.showMessageDialog(null, "Error: Unable to parse the string as a date. Please Retry",
                    "Error", JOptionPane.ERROR_MESSAGE);
					canBeCreated = false;
            retdatetxt.setText("");
            pe.printStackTrace();
        }
		if (canBeCreated) {
			LibraryManagementSystem.getCurrentLibrary().borrowBook(memberIn, bookIn, convertedReturnDate);
			if (bookStart) {
				this.dispose();
				GUIBookShow show = new GUIBookShow(bookIn);
			} else {
				this.dispose();
				GUIMemberShow show = new GUIMemberShow(memberIn);
			}
		}
        } else if (e.getSource() == backButton) {
			if (bookStart) {
				this.dispose();
				GUIMemberSearch search = new GUIMemberSearch(bookStart, bookIn.getId());
			} else {
				this.dispose();
				GUIBookSearch search = new GUIBookSearch(bookStart, memberIn.getID());
			}
		}
	}

}
