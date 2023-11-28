import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;


public class GUIBorrowedShow extends JFrame implements ActionListener{

    private JButton returnButton;
    private JButton backButton;
    private JButton extendButton;
    private JTextArea lateChargesArea;
    private BorrowedBook bookIn;
    private boolean bookStart;

    public GUIBorrowedShow(boolean bookStart, BorrowedBook bookIn) {
        this.bookIn = bookIn;
        
        this.bookStart = bookStart;

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 200);
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(350,200));
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel bookTitleLabel = new JLabel("Book title: " + bookIn.getBook().getName());
        bookTitleLabel.setBounds(10, 20, 350,25);
        

        JLabel memberNameLabel = new JLabel("Member first/last name: " + bookIn.getMember().getFirstname() + " " + bookIn.getMember().getLastname());
        memberNameLabel.setBounds(10, 50, 350, 25);
        
        mainPanel.add(bookTitleLabel);
        mainPanel.add(memberNameLabel);

        if (bookIn.getActive()) {
            returnButton = new JButton("Return Book");
            returnButton.setBounds(10, 90, 120, 25);
            returnButton.addActionListener(this);

            extendButton = new JButton("Extend");
            extendButton.setBounds(160,90,120,25);
            extendButton.addActionListener(this);

            mainPanel.add(returnButton);
            mainPanel.add(extendButton);
        } else {
            JLabel lateChargesLabel = new JLabel("Late Charges: " + bookIn.getLateFees());
            lateChargesLabel.setBounds(10, 120, 80, 25);

            mainPanel.add(lateChargesLabel);
        }
        this.add(mainPanel);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnButton) {
            LibraryManagementSystem.getCurrentLibrary().returnBook(bookIn);
            this.repaint();
            this.revalidate();
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
 /* 
    private void returnBook() {
        try{
            
             Check if bookId is within a library
             Library l = new Library("Library 7", "123 Reading Rd");
             if(l !=null){
                if it does check if its rented out to the member
                BorrowedBook borrowedBook = //figure out borrowedBooks storage
                if(borrowedBook !=null){
                    borrowedBook.returnBook(returnDate);

                    double lateFees = borrowedBook.getLateFees();

                    lateChargesArea.setText("Late Fee: $" + lateFees);

                    remove book from member
                    return book to library
                }
                else{ JOptionPane.showMessageDialog(null,"This book is not currently borrowed by this member")
                }
            }
            else{ JOptionPane.showMessageDialog(null, "Book not found in Library")
            }  
            
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please enter numerical bookID and MemberID.");
        } 
    } */
}

