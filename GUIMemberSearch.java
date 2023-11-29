import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

    JPanel contentPane;

    GUIMemberSearch(boolean borrow, int bookId) {
        attemptBorrow = borrow;
        storeBookID = bookId;

        JLabel firstNameText = new JLabel("Firstname:");
        firstNameText.setBounds(50, 75, 200, 35);
        JLabel lastNameText = new JLabel("Lastname:");
        lastNameText.setBounds(50, 115, 200, 35);
        JLabel genderText = new JLabel("Gender:");
        genderText.setBounds(50, 155, 200, 35);
        JLabel IDText = new JLabel("ID:");
        IDText.setBounds(50, 195, 200, 35);
        JLabel titleText = new JLabel("Member Search");
        titleText.setBounds(115, 15, 200, 50);

        searchButton = new JButton("Search");
        searchButton.setBounds(140,240,85,50);
        searchButton.setFocusable(false);
        searchButton.addActionListener(this);

        backButton = new JButton("Back");
		backButton.setBounds(10, 15, 68, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        firstNameTextField = new JTextField();
        firstNameTextField.setBounds(130, 75, 200, 35);

        lastNameTextField = new JTextField();
        lastNameTextField.setBounds(130, 115, 200, 35);

        genderField = new JComboBox<>(genders);
        genderField.setFocusable(false);
        genderField.setBounds(130, 155, 200, 35);

        IDTextField = new JTextField();
        IDTextField.setPreferredSize(new Dimension(250,40));
        IDTextField.setBounds(130, 195, 200, 35);

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Font titleFont = new Font("Arial", Font.BOLD, 18);

        searchButton.setFont(buttonFont);
        backButton.setFont(buttonFont);
        firstNameText.setFont(buttonFont);
        lastNameText.setFont(buttonFont);
        genderText.setFont(buttonFont);
        IDText.setFont(buttonFont);
        firstNameTextField.setFont(buttonFont);
        lastNameTextField.setFont(buttonFont);
        genderField.setFont(buttonFont);
        IDTextField.setFont(buttonFont);
        titleText.setFont(titleFont);

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 340);
        this.setResizable(false);

        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        contentPane.add(titleText);
        contentPane.add(firstNameText);
        contentPane.add(lastNameText);
        contentPane.add(genderText);
        contentPane.add(IDText);
        contentPane.add(backButton);
        contentPane.add(firstNameTextField);
        contentPane.add(lastNameTextField);
        contentPane.add(genderField);
        contentPane.add(IDTextField);
        contentPane.add(searchButton);

        this.setVisible(true);
    }

    GUIMemberSearch() {

        JLabel firstNameText = new JLabel("Firstname:");
        firstNameText.setBounds(50, 75, 200, 35);
        JLabel lastNameText = new JLabel("Lastname:");
        lastNameText.setBounds(50, 115, 200, 35);
        JLabel genderText = new JLabel("Gender:");
        genderText.setBounds(50, 155, 200, 35);
        JLabel IDText = new JLabel("ID:");
        IDText.setBounds(50, 195, 200, 35);
        JLabel titleText = new JLabel("Member Search");
        titleText.setBounds(115, 15, 200, 50);

        searchButton = new JButton("Search");
        searchButton.setBounds(140,240,85,50);
        searchButton.setFocusable(false);
        searchButton.addActionListener(this);

        backButton = new JButton("Back");
		backButton.setBounds(10, 15, 68, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        addButton = new JButton("Add");
        addButton.setBounds(290, 15, 68, 50);
        addButton.setFocusable(false);
        addButton.addActionListener(this);

        firstNameTextField = new JTextField();
        firstNameTextField.setBounds(130, 75, 200, 35);

        lastNameTextField = new JTextField();
        lastNameTextField.setBounds(130, 115, 200, 35);

        genderField = new JComboBox<>(genders);
        genderField.setFocusable(false);
        genderField.setBounds(130, 155, 200, 35);

        IDTextField = new JTextField();
        IDTextField.setPreferredSize(new Dimension(250,40));
        IDTextField.setBounds(130, 195, 200, 35);

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Font titleFont = new Font("Arial", Font.BOLD, 18);

        searchButton.setFont(buttonFont);
        backButton.setFont(buttonFont);
        addButton.setFont(buttonFont);
        firstNameText.setFont(buttonFont);
        lastNameText.setFont(buttonFont);
        genderText.setFont(buttonFont);
        IDText.setFont(buttonFont);
        firstNameTextField.setFont(buttonFont);
        lastNameTextField.setFont(buttonFont);
        genderField.setFont(buttonFont);
        IDTextField.setFont(buttonFont);
        titleText.setFont(titleFont);




        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 340);
        this.setResizable(false);

        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        contentPane.add(titleText);
        contentPane.add(firstNameText);
        contentPane.add(lastNameText);
        contentPane.add(genderText);
        contentPane.add(IDText);
        contentPane.add(backButton);
        contentPane.add(addButton);
        contentPane.add(firstNameTextField);
        contentPane.add(lastNameTextField);
        contentPane.add(genderField);
        contentPane.add(IDTextField);
        contentPane.add(searchButton);

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
                } else if (holder.isEmpty() || holder.size() == 0 || holder == null) {
                    JOptionPane.showMessageDialog(null, "No results");
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
                } else if (holder.isEmpty() || holder.size() == 0 || holder == null) {
                    JOptionPane.showMessageDialog(null, "No results");
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