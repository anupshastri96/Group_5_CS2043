import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUIBorrowedView extends JFrame implements ActionListener {

    JLabel test;
    JButton selectButton;
    JButton backButton;
    JComboBox<String> optionBox;

    boolean isBook;
    Book storeBook;
    Member storeMember;
    String[] storeString;

    GUIBorrowedView(boolean isBookIn, int ID) {
        isBook = isBookIn;

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 350);
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        backButton = new JButton("Back");
		backButton.setBounds(100,100,100,40);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        selectButton = new JButton("Select");
		selectButton.setBounds(100,100,100,40);
        selectButton.setFocusable(false);
        selectButton.addActionListener(this);

        if (isBookIn) {
            storeBook = LibraryManagementSystem.getCurrentLibrary().findBook(ID);
            if (!storeBook.getMemberIDs().isEmpty() && storeBook.getMemberIDs() != null) {
                storeString = new String[storeBook.getMemberIDs().size()];
                for (int i = 0; i < storeBook.getMemberIDs().size(); i++) {
                    storeString[i] = (LibraryManagementSystem.findMember(storeBook.getMemberIDs().get(i)).getFirstname() + " " + LibraryManagementSystem.findMember(storeBook.getMemberIDs().get(i)).getFirstname());
                    if (LibraryManagementSystem.findBorrowedBook(storeBook, LibraryManagementSystem.findMember(storeBook.getMemberIDs().get(i))).getActive()) {
                        storeString[i] += ("\nStatus: Active");
                    } else {
                        storeString[i] += ("\nStatus: Inactive");
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
                        storeString[i] += ("\nStatus: Active");
                    } else {
                        storeString[i] += ("\nStatus: Inactive");
                    }
                }
            }
        }

        optionBox = new JComboBox<>(storeString);

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(300,40));
        topPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(300,300));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        topPanel.add(backButton);
        this.add(topPanel);

        panel2.add(optionBox);
        panel2.add(selectButton);
        this.add(panel2);

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