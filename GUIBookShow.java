import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUIBookShow extends JFrame implements ActionListener {

    JLabel title;
    JLabel author;
    JLabel subject;
    JButton removeLibraryButton;
    JButton backButton;
    JButton viewBorrowedButton;
    JButton borrowButton;
    Book storeBook;

    GUIBookShow(Book bookIn) {

        storeBook = bookIn;
        
        title = new JLabel(bookIn.getName());
        author = new JLabel(bookIn.getAuthor());
        subject = new JLabel(bookIn.getSubject());

        backButton = new JButton("Back");
		backButton.setBounds(100,100,100,40);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        removeLibraryButton = new JButton("Remove from library");
        removeLibraryButton.setBounds(100,100,100,40);
        removeLibraryButton.setFocusable(false);
        removeLibraryButton.addActionListener(this);

        viewBorrowedButton = new JButton("View Borrowed Log");
		viewBorrowedButton.setBounds(100,100,100,40);
        viewBorrowedButton.setFocusable(false);
        viewBorrowedButton.addActionListener(this);

        borrowButton = new JButton("Borrow Book");
		borrowButton.setBounds(100,100,100,40);
        borrowButton.setFocusable(false);
        borrowButton.addActionListener(this);

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 350);
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(300,40));
        topPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(300,300));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        topPanel.add(removeLibraryButton);
        topPanel.add(viewBorrowedButton);
        topPanel.add(borrowButton);
        topPanel.add(backButton);
        this.add(topPanel);

        panel2.add(title);
        panel2.add(author);
        //panel2.add(title);
        this.add(panel2);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == removeLibraryButton) {
            //this.dispose();
           // GUIBookEdit edit = new GUIBookEdit(storeBook);
        } else if (e.getSource() == borrowButton) {
            // add check if can be borrowed
            this.dispose();
            GUIMemberSearch search = new GUIMemberSearch(true, storeBook.getId());
        } else if (e.getSource() == viewBorrowedButton) {
            this.dispose();
            GUIBorrowedView search = new GUIBorrowedView(true, storeBook.getId());
        } else if (e.getSource() == backButton) {
            this.dispose();
            GUIBookSearch search = new GUIBookSearch();

        }
	}
	
}