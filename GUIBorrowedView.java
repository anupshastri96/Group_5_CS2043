import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUIBorrowedView extends JFrame implements ActionListener {

    JButton selectButton;
    JButton backButton;
    JComboBox<String> optionBox;
    JPanel contentPane;

    boolean isBook;
    Book storeBook;
    Member storeMember;
    String[] storeString;

    GUIBorrowedView(boolean isBookIn, int ID) {
        isBook = isBookIn;

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 340);
        this.setResizable(false);

        backButton = new JButton("Back");
		backButton.setBounds(10, 15, 68, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        selectButton = new JButton("Select");
		selectButton.setBounds(130,240,110,50);
        selectButton.setFocusable(false);
        selectButton.addActionListener(this);

        JLabel resultLabel = new JLabel("Results:");
        resultLabel.setBounds(35, 120, 200, 35);

        if (isBookIn) {
            storeBook = LibraryManagementSystem.getCurrentLibrary().findBook(ID);
            if (!storeBook.getMemberIDs().isEmpty() && storeBook.getMemberIDs() != null) {
                storeString = new String[storeBook.getMemberIDs().size()];
                for (int i = 0; i < storeBook.getMemberIDs().size(); i++) {
                    storeString[i] = (LibraryManagementSystem.findMember(storeBook.getMemberIDs().get(i)).getFirstname() + " " + LibraryManagementSystem.findMember(storeBook.getMemberIDs().get(i)).getFirstname());
                    if (LibraryManagementSystem.findBorrowedBook(storeBook, LibraryManagementSystem.findMember(storeBook.getMemberIDs().get(i))).getActive()) {
                        storeString[i] += (" Status: Active");
                    } else {
                        storeString[i] += (" Status: Inactive");
                    }
                    
                }
            }


        } else {
            storeMember = LibraryManagementSystem.findMember(ID);
            if (!storeMember.getBorrowed().isEmpty() && storeMember.getBorrowed() != null) {
                storeString = new String[storeMember.getBorrowed().size()];
                for (int i = 0; i < storeMember.getBorrowed().size(); i++) {
                    storeString[i] = (storeMember.getBorrowed().get(i).getBook().getName() + "," + storeMember.getBorrowed().get(i).getBook().getAuthor());
                    if (storeMember.getBorrowed().get(i).getActive()) {
                        storeString[i] += (" Status: Active");
                    } else {
                        storeString[i] += (" Status: Inactive");
                    }
                }
            }
        }

        optionBox = new JComboBox<>(storeString);
        optionBox.setBounds(100, 120, 230, 35);
        optionBox.setFocusable(false);
        optionBox.addActionListener(this);

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Font titleFont = new Font("Arial", Font.BOLD, 18);

        backButton.setFont(buttonFont);
        optionBox.setFont(buttonFont);
        resultLabel.setFont(buttonFont);
        selectButton.setFont(buttonFont);

        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        contentPane.add(resultLabel);
        contentPane.add(optionBox);
        contentPane.add(selectButton);
        contentPane.add(backButton);
        
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == selectButton) {
            if (isBook) {
                this.dispose();
                GUIBorrowedShow show = new GUIBorrowedShow(isBook, LibraryManagementSystem.findBorrowedBook(storeBook, LibraryManagementSystem.findMember(storeBook.getMemberIDs().get(optionBox.getSelectedIndex()))));
            } else {
                this.dispose();
                GUIBorrowedShow show = new GUIBorrowedShow(isBook, LibraryManagementSystem.findBorrowedBook(storeMember.getBorrowed().get(optionBox.getSelectedIndex()).getBook(), storeMember));
            }
        } else if (e.getSource() == backButton) {
            if (isBook) {
                this.dispose();
                GUIBookShow show = new GUIBookShow(storeBook);
            } else {
                this.dispose();
                GUIMemberShow show = new GUIMemberShow(storeMember);
            }
        }
	}
	
}