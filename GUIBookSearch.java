import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.ArrayList;


public class GUIBookSearch extends JFrame implements ActionListener {
    // Fix this up later
    JTextField nameTextField;
    JTextField authorTextField;
    JTextField IDTextField;
    JCheckBox adultCheck;
    JButton searchButton;
    JButton backButton;
    JButton addButton;

    boolean attemptBorrow;
    int storeMemberID;

    GUIBookSearch(boolean borrow, int memberId) {
    attemptBorrow = borrow;
    storeMemberID = memberId;

    searchButton = new JButton("Search");
        searchButton.setBounds(100,100,100,40);
        searchButton.setFocusable(false);
        searchButton.addActionListener(this);

        backButton = new JButton("Back");
		backButton.setBounds(100,100,100,40);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        adultCheck = new JCheckBox("Adult");
        adultCheck.setBounds(100,100,100,40);
        adultCheck.setFocusable(false);

        nameTextField = new JTextField();
        nameTextField.setPreferredSize(new Dimension(250,40));

        authorTextField = new JTextField();
        authorTextField.setPreferredSize(new Dimension(250,40));

        IDTextField = new JTextField();
        IDTextField.setPreferredSize(new Dimension(250,40));


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

        topPanel.add(backButton);
        this.add(topPanel);

        panel2.add(nameTextField);
        panel2.add(authorTextField);
        panel2.add(adultCheck);
        panel2.add(IDTextField);
        panel2.add(searchButton);
        this.add(panel2);

        this.setVisible(true);

    }

    GUIBookSearch() {

        searchButton = new JButton("Search");
        searchButton.setBounds(100,100,100,40);
        searchButton.setFocusable(false);
        searchButton.addActionListener(this);

        backButton = new JButton("Back");
		backButton.setBounds(100,100,100,40);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        addButton = new JButton("Add");
        addButton.setBounds(100,100,100,40);
        addButton.setFocusable(false);
        addButton.addActionListener(this);

        adultCheck = new JCheckBox("Adult");
        adultCheck.setBounds(100,100,100,40);
        adultCheck.setFocusable(false);

        nameTextField = new JTextField();
        nameTextField.setPreferredSize(new Dimension(250,40));

        authorTextField = new JTextField();
        authorTextField.setPreferredSize(new Dimension(250,40));

        IDTextField = new JTextField();
        IDTextField.setPreferredSize(new Dimension(250,40));


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

        topPanel.add(addButton);
        topPanel.add(backButton);
        this.add(topPanel);

        panel2.add(nameTextField);
        panel2.add(authorTextField);
        panel2.add(adultCheck);
        panel2.add(IDTextField);
        panel2.add(searchButton);
        this.add(panel2);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == searchButton) {
            if (attemptBorrow) {
                SearchAlgorithm.bookSearch(nameTextField.getText(),authorTextField.getText(),adultCheck.isSelected(),IDTextField.getText());
                ArrayList<Integer> holder = SearchAlgorithm.getResults();
                /*
                for (int i = 0; i < holder.size(); i++) {
                    if (LibraryManagementSystem.findMember(storeMemberID).getBorrowed() != null && !LibraryManagementSystem.findMember(storeMemberID).getBorrowed().isEmpty()) {
                        for (int j = 0; j < LibraryManagementSystem.findMember(storeMemberID).getBorrowed().size(); j++) {
                            if (LibraryManagementSystem.findMember(storeMemberID).getBorrowed().get(j).getID() == holder.get(i)) {
                                holder.remove(i);
                            }
                        }
                    }
                }
                for (int i = 0; i < holder.size(); i++) {
                    for (int j = 0; j < LibraryManagementSystem.getCurrentLibrary().getAllBooks().size(); j++) {
                        if (LibraryManagementSystem.getCurrentLibrary().getBook(j).getId() == holder.get(i)) {
                            if (LibraryManagementSystem.getCurrentLibrary().getBook(j).getAmount() - LibraryManagementSystem.getCurrentLibrary().getBook(j).getAmountBorrowed() >= 1) {
                                holder.remove(i);
                            }
                        }
                    }
                } */
                if (holder.size() == 1) {
                    this.dispose();
                    GUIBorrowedAdd add = new GUIBorrowedAdd(LibraryManagementSystem.getCurrentLibrary().findBook(holder.get(0)), LibraryManagementSystem.findMember(storeMemberID));
                } else if (holder.isEmpty() || holder.size() == 0 || holder == null) {
                    // Add error message
                    //this.dispose();
                    //GUIBookResults results = new GUIBookResults(holder);
                } else {
                    this.dispose();
                    GUIBookResults results = new GUIBookResults(attemptBorrow, storeMemberID, holder);
                }
            } else {
                SearchAlgorithm.bookSearch(nameTextField.getText(),authorTextField.getText(),adultCheck.isSelected(),IDTextField.getText());
                ArrayList<Integer> holder = SearchAlgorithm.getResults();
            
                if (holder.size() == 1) {
                    this.dispose();
                    GUIBookShow show = new GUIBookShow(LibraryManagementSystem.getCurrentLibrary().findBook(holder.get(0)));
                } else if (holder.isEmpty() || holder.size() == 0 || holder == null) {
                    // Add error message
                    //this.dispose();
                    //GUIBookResults results = new GUIBookResults(holder);
                } else {
                    this.dispose();
                    GUIBookResults results = new GUIBookResults(holder);
                }

            }  
        } else if (e.getSource() == addButton) {
            this.dispose();
            GUIBookAdd add = new GUIBookAdd();
        } else if (e.getSource() == backButton) {
            if (attemptBorrow) {
                this.dispose();
                GUIMemberShow show = new GUIMemberShow(LibraryManagementSystem.findMember(storeMemberID));
            } else {
                this.dispose();
                GUILibrarianChoice start = new GUILibrarianChoice();
            }
        }
        
	}
	
}