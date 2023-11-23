import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnBookGUI {

    private JTextField bookIdField;
    private JTextField memberIdField;
    private JButton returnButton;
    private JButton extendButton;
    private JTextArea lateChargesArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ReturnBookGUI returnBookGUI = new ReturnBookGUI();
            returnBookGUI.createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Return Book");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);

        JLabel bookIdLabel = new JLabel("Book ID:");
        bookIdLabel.setBounds(10, 20, 80,25);

        bookIdField = new JTextField();
        bookIdField.setBounds(100, 20, 165, 25);

        JLabel memberIdLabel = new JLabel("Member ID:");
        memberIdLabel.setBounds(10, 50, 80, 25);

        memberIdField = new JTextField();
        memberIdField.setBounds(100,50,165,25);

        returnButton = new JButton("Return Book");
        returnButton.setBounds(10, 90, 120, 25);
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement the logic to return the book and calculate late charges
                returnBook();
            }
        });

        
        extendButton = new JButton("Extend");
        extendButton.setBounds(160,90,120,25);
        extendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {
                // extend reservation of book
               // extend();
            }
        });
        
        JLabel lateChargesLabel = new JLabel("Late Charges:");
        lateChargesLabel.setBounds(10, 120, 80, 25);
        lateChargesArea = new JTextArea();
        lateChargesArea.setBounds(100, 120, 165, 25);
        lateChargesArea.setEditable(false);

        mainPanel.add(bookIdLabel);
        mainPanel.add(bookIdField);
        mainPanel.add(memberIdLabel);
        mainPanel.add(memberIdField);
        mainPanel.add(returnButton);
        mainPanel.add(extendButton);
        mainPanel.add(lateChargesLabel);
        mainPanel.add(lateChargesArea);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void returnBook() {
        try{
            int bookId = Integer.parseInt(bookIdField.getText());
            int memberId = Integer.parseInt(memberIdField.getText());
            /*
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
            */
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Please enter numerical bookID and MemberID.");
        }
    } 
}

