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

import java.util.ArrayList;


public class GUIMemberSearch extends JFrame implements ActionListener {
    // Borrowedbook GUI will be very similar
    // Fix this up later
    JTextField firstNameTextField;
    JTextField lastNameTextField;
    JTextField IDTextField;
    JComboBox genderField;
    JButton searchButton;
    JButton backButton;
    JButton addButton;

    boolean attemptBorrow;
    int storeBookID;
    String[] genders = {" ", "Male", "Female", "Other"};

    GUIMemberSearch(boolean borrow, int bookId) {
        attemptBorrow = borrow;
        storeBookID = bookId;

        searchButton = new JButton("Search");
        searchButton.setBounds(100,100,100,40);
        searchButton.setFocusable(false);
        searchButton.addActionListener(this);

        backButton = new JButton("Back");
		backButton.setBounds(100,100,100,40);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        firstNameTextField = new JTextField();
        firstNameTextField.setPreferredSize(new Dimension(250,40));

        lastNameTextField = new JTextField();
        lastNameTextField.setPreferredSize(new Dimension(250,40));

        genderField = new JComboBox<>(genders);

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

        panel2.add(firstNameTextField);
        panel2.add(lastNameTextField);
        panel2.add(genderField);
        panel2.add(IDTextField);
        panel2.add(searchButton);
        this.add(panel2);

        this.setVisible(true);
    }

    GUIMemberSearch() {

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

        firstNameTextField = new JTextField();
        firstNameTextField.setPreferredSize(new Dimension(250,40));

        lastNameTextField = new JTextField();
        lastNameTextField.setPreferredSize(new Dimension(250,40));

        genderField = new JComboBox<>(genders);

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

        panel2.add(firstNameTextField);
        panel2.add(lastNameTextField);
        panel2.add(genderField);
        panel2.add(IDTextField);
        panel2.add(searchButton);
        this.add(panel2);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == searchButton) {
            if (attemptBorrow) {

                SearchAlgorithm.memberSearch(firstNameTextField.getText(),lastNameTextField.getText(),genderField.getSelectedIndex(),IDTextField.getText());
                ArrayList<Integer> holder = SearchAlgorithm.getResults();

                // Add checks to make sure holder cant contain memberIDs that have an active borrowing on that book

                if (holder.size() == 1) {
                    this.dispose();
                    GUIBorrowedAdd add = new GUIBorrowedAdd(LibraryManagementSystem.getCurrentLibrary().findBook(storeBookID),LibraryManagementSystem.findMember(holder.get(0)));
                } else {
                    this.dispose();
                    GUIMemberResults results = new GUIMemberResults(holder);
                }

            } else {
                SearchAlgorithm.memberSearch(firstNameTextField.getText(),lastNameTextField.getText(),genderField.getSelectedIndex(),IDTextField.getText());
                ArrayList<Integer> holder = SearchAlgorithm.getResults();

                if (holder.size() == 1) {
                    this.dispose();
                    GUIMemberShow show = new GUIMemberShow(LibraryManagementSystem.findMember(holder.get(0)));
                } else {
                    this.dispose();
                    GUIMemberResults results = new GUIMemberResults(holder);
                }
            }
            
        }  else if (e.getSource() == addButton) {
            
            this.dispose();
            GUIMemberAdd add = new GUIMemberAdd();
        } else if (e.getSource() == backButton) {
            this.dispose();
            GUILibrarianChoice start = new GUILibrarianChoice();
        }
	}
	
}