import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUIBookShow extends JFrame implements ActionListener {

    JPanel contentPane;
 
    JButton removeLibraryButton;
    JButton removeSingleAmountButton;
    JButton backButton;
    JButton viewBorrowedButton;
    JButton borrowButton;
    JLabel amountText;
    JLabel adultText;
    Book storeBook;

    GUIBookShow(Book bookIn) {
        storeBook = bookIn;
        
        JLabel nameText = new JLabel("Title: " + bookIn.getName());
        nameText.setBounds(10, 75, 200, 35);
        JLabel authorText = new JLabel("Author: " + bookIn.getAuthor());
        authorText.setBounds(10, 115, 200, 35);
        JLabel subjectText = new JLabel("Subject: " + bookIn.getSubject());
        subjectText.setBounds(10, 155, 200, 35);
        if ((bookIn.getAmount() - bookIn.getAmountBorrowed()) >= 1) {
            amountText = new JLabel("Amount available: " + (bookIn.getAmount() - bookIn.getAmountBorrowed()));
            amountText.setBounds(10, 195, 200, 35);
        } else {
            amountText = new JLabel("None available");
            amountText.setBounds(10, 195, 200, 35);
        }
        if (storeBook.getAdult().equals("T")) {
            adultText = new JLabel("Meant for adults");
            adultText.setBounds(10, 235, 200, 35);
        } else {
            adultText = new JLabel("Not meant for adults");
            adultText.setBounds(10, 235, 200, 35);
        }
        JLabel IDText = new JLabel("ID: " + bookIn.getId());
        IDText.setBounds(10, 275, 200, 35);

        backButton = new JButton("Back");
		backButton.setBounds(10, 15, 68, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        borrowButton = new JButton("Borrow");
		borrowButton.setBounds(260, 65, 100, 50);
        borrowButton.setFocusable(false);
        borrowButton.addActionListener(this);

        viewBorrowedButton = new JButton("Borrowed Log");
		viewBorrowedButton.setBounds(220, 15, 140, 50);
        viewBorrowedButton.setFocusable(false);
        viewBorrowedButton.addActionListener(this);

        removeLibraryButton = new JButton("Remove from Library");
		removeLibraryButton.setBounds(170, 250, 190, 50);
        removeLibraryButton.setFocusable(false);
        removeLibraryButton.addActionListener(this);

        removeSingleAmountButton = new JButton("Remove One");
		removeSingleAmountButton.setBounds(230, 200, 130, 50);
        removeSingleAmountButton.setFocusable(false);
        removeSingleAmountButton.addActionListener(this);

        

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Font titleFont = new Font("Arial", Font.BOLD, 18);

        backButton.setFont(buttonFont);
        borrowButton.setFont(buttonFont);
        viewBorrowedButton.setFont(buttonFont);
        removeLibraryButton.setFont(buttonFont);
        removeSingleAmountButton.setFont(buttonFont);
        nameText.setFont(buttonFont);
        subjectText.setFont(buttonFont);
        adultText.setFont(buttonFont);
        authorText.setFont(buttonFont);
        amountText.setFont(buttonFont);
        IDText.setFont(buttonFont);
        


        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 340);
        this.setResizable(false);

        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        contentPane.add(nameText);
        contentPane.add(authorText);
        contentPane.add(subjectText);
        contentPane.add(amountText);
        contentPane.add(adultText);
        contentPane.add(IDText);
        contentPane.add(backButton);
        contentPane.add(borrowButton);
        contentPane.add(viewBorrowedButton);
        contentPane.add(removeLibraryButton);
        contentPane.add(removeSingleAmountButton);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == removeLibraryButton) {
            if (!storeBook.getLibraryIDs().isEmpty() && storeBook.getLibraryIDs() != null) {
                if (storeBook.getLibraryIDs().size() > 1) {
                    storeBook.removeLibrary(LibraryManagementSystem.getCurrentLibrary());
                    LibraryManagementSystem.getCurrentLibrary().removeBook(storeBook);
                    LibraryManagementSystem.bookWriteFile();
                    LibraryManagementSystem.libraryWriteFile();
                    this.dispose();
                    GUIBookSearch search = new GUIBookSearch();
                }
            }
            JOptionPane.showMessageDialog(null, "Could not remove from library");
        } else if (e.getSource() == removeSingleAmountButton) {
            boolean toRefresh = false;
            if (storeBook.getAmount() - storeBook.getAmountBorrowed() == 1) {
                toRefresh = true;
            }
            storeBook.decAmount();
            LibraryManagementSystem.bookWriteFile();
            LibraryManagementSystem.libraryWriteFile();
            if (toRefresh) {
                this.dispose();
                GUIBookShow show = new GUIBookShow(storeBook);
            }
        } else if (e.getSource() == borrowButton) {
            if ((storeBook.getAmount() - storeBook.getAmountBorrowed()) >= 1) {
                this.dispose();
                GUIMemberSearch search = new GUIMemberSearch(true, storeBook.getId());
            } else {
                JOptionPane.showMessageDialog(null, "Book is not able to be borrowed");
            }
            
        } else if (e.getSource() == viewBorrowedButton) {
            if (!storeBook.getMemberIDs().isEmpty() && storeBook.getMemberIDs() != null) {
                this.dispose();
                GUIBorrowedView search = new GUIBorrowedView(true, storeBook.getId());
            } else {
                JOptionPane.showMessageDialog(null, "Book has no borrowing history");
            }
            
        } else if (e.getSource() == backButton) {
            this.dispose();
            GUIBookSearch search = new GUIBookSearch();

        }
	}
	
}