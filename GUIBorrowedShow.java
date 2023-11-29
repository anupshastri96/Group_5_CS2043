import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;


public class GUIBorrowedShow extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JButton backButton;
    private JButton returnButton;
    private JButton extendButton;
    private JLabel lateChargesLabel;
    private JLabel dueLabel;
    private BorrowedBook bookIn;
    private boolean bookStart;

    public GUIBorrowedShow(boolean bookStart, BorrowedBook bookIn) {
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

        backButton = new JButton("Back");
		backButton.setBounds(10, 15, 68, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        JLabel bookTitleLabel = new JLabel("Book title: " + bookIn.getBook().getName());
        bookTitleLabel.setBounds(10, 75, 200, 35);
        
        JLabel memberNameLabel = new JLabel("Member name: " + bookIn.getMember().getFirstname() + " " + bookIn.getMember().getLastname());
        memberNameLabel.setBounds(10, 115, 340, 35);

        JLabel libraryLabel = new JLabel("Borrowed from: " + bookIn.getLibrary().getName());
        libraryLabel.setBounds(10, 155, 200, 35);

        JLabel IDLabel = new JLabel("ID: " + bookIn.getID());
        IDLabel.setBounds(10, 235, 200, 35);

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Font titleFont = new Font("Arial", Font.BOLD, 18);

        backButton.setFont(buttonFont);
        memberNameLabel.setFont(buttonFont);
        libraryLabel.setFont(buttonFont);
        IDLabel.setFont(buttonFont);
        bookTitleLabel.setFont(buttonFont);

        if (bookIn.getActive()) {
            returnButton = new JButton("Return Book");
            returnButton.setBounds(220, 15, 140, 50);
            returnButton.addActionListener(this);

            extendButton = new JButton("Extend");
            extendButton.setBounds(260, 65, 100, 50);
            extendButton.addActionListener(this);

            dueLabel = new JLabel("Due date: " + bookIn.getDueDate());
            dueLabel.setBounds(10, 195, 200, 35);

            extendButton.setFont(buttonFont);
            returnButton.setFont(buttonFont);
            dueLabel.setFont(buttonFont);

            contentPane.add(returnButton);
            contentPane.add(dueLabel);
            contentPane.add(extendButton);
        } else {
            if (bookIn.getLateFees() > 0) {
                lateChargesLabel = new JLabel("Late Charges: " + bookIn.getLateFees());
                lateChargesLabel.setBounds(10, 195, 200, 35);
            } else {
                lateChargesLabel = new JLabel("No late fees");
                lateChargesLabel.setBounds(10, 195, 200, 35);
            }

            IDLabel.setBounds(10, 235, 200, 35);

            lateChargesLabel.setFont(buttonFont);

            contentPane.add(lateChargesLabel);
        }

        contentPane.add(bookTitleLabel);
        contentPane.add(memberNameLabel);
        contentPane.add(libraryLabel);
        contentPane.add(memberNameLabel);
        contentPane.add(IDLabel);
        contentPane.add(backButton);
        
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnButton) {
            LibraryManagementSystem.getCurrentLibrary().returnBook(bookIn);
            this.dispose();
            GUIBorrowedShow show = new GUIBorrowedShow(bookStart, bookIn);
        } else if (e.getSource() == extendButton) {
            this.dispose();
            GUIBorrowedExtend extend = new GUIBorrowedExtend(bookStart, bookIn);
        } else if (e.getSource() == backButton) {
            if (bookStart) {
                this.dispose();
                GUIBorrowedView view = new GUIBorrowedView(bookStart, bookIn.getBook().getId());
            } else {
                this.dispose();
                GUIBorrowedView view = new GUIBorrowedView(bookStart, bookIn.getMember().getID());

            }
        } 
	}
}

