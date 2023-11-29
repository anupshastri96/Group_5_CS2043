import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.ArrayList;


public class GUIBookSearch extends JFrame implements ActionListener {
    
    JPanel contentPane;
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

    JLabel nameText = new JLabel("Name:");
        nameText.setBounds(65, 75, 200, 35);
        JLabel authorText = new JLabel("Author:");
        authorText.setBounds(65, 115, 200, 35);
        JLabel adultText = new JLabel("Adult:");
        adultText.setBounds(65, 155, 200, 35);
        JLabel IDText = new JLabel("ID:");
        IDText.setBounds(65, 195, 200, 35);
        JLabel titleText = new JLabel("Book Search");
        titleText.setBounds(135, 15, 200, 50);

        searchButton = new JButton("Search");
        searchButton.setBounds(140,240,85,50);
        searchButton.setFocusable(false);
        searchButton.addActionListener(this);

        backButton = new JButton("Back");
		backButton.setBounds(10, 15, 68, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        nameTextField = new JTextField();
        nameTextField.setBounds(130, 75, 200, 35);

        authorTextField = new JTextField();
        authorTextField.setBounds(130, 115, 200, 35);

        adultCheck = new JCheckBox();
        adultCheck.setBounds(130, 155, 200, 35);
        adultCheck.setFocusable(false);;

        IDTextField = new JTextField();
        IDTextField.setPreferredSize(new Dimension(250,40));
        IDTextField.setBounds(130, 195, 200, 35);

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Font titleFont = new Font("Arial", Font.BOLD, 18);

        searchButton.setFont(buttonFont);
        backButton.setFont(buttonFont);
        nameText.setFont(buttonFont);
        authorText.setFont(buttonFont);
        adultText.setFont(buttonFont);
        IDText.setFont(buttonFont);
        nameTextField.setFont(buttonFont);
        authorTextField.setFont(buttonFont);
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
        contentPane.add(nameText);
        contentPane.add(authorText);
        contentPane.add(adultText);
        contentPane.add(IDText);
        contentPane.add(backButton);
        contentPane.add(nameTextField);
        contentPane.add(authorTextField);
        contentPane.add(adultCheck);
        contentPane.add(IDTextField);
        contentPane.add(searchButton);

        this.setVisible(true);

    }

    GUIBookSearch() {

        JLabel nameText = new JLabel("Title:");
        nameText.setBounds(65, 75, 200, 35);
        JLabel authorText = new JLabel("Author:");
        authorText.setBounds(65, 115, 200, 35);
        JLabel adultText = new JLabel("Adult:");
        adultText.setBounds(65, 155, 200, 35);
        JLabel IDText = new JLabel("ID:");
        IDText.setBounds(65, 195, 200, 35);
        JLabel titleText = new JLabel("Book Search");
        titleText.setBounds(135, 15, 200, 50);

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

        nameTextField = new JTextField();
        nameTextField.setBounds(130, 75, 200, 35);

        authorTextField = new JTextField();
        authorTextField.setBounds(130, 115, 200, 35);

        adultCheck = new JCheckBox();
        adultCheck.setBounds(130, 155, 200, 35);
        adultCheck.setFocusable(false);;

        IDTextField = new JTextField();
        IDTextField.setPreferredSize(new Dimension(250,40));
        IDTextField.setBounds(130, 195, 200, 35);

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Font titleFont = new Font("Arial", Font.BOLD, 18);

        searchButton.setFont(buttonFont);
        backButton.setFont(buttonFont);
        addButton.setFont(buttonFont);
        nameText.setFont(buttonFont);
        authorText.setFont(buttonFont);
        adultText.setFont(buttonFont);
        IDText.setFont(buttonFont);
        nameTextField.setFont(buttonFont);
        authorTextField.setFont(buttonFont);
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
        contentPane.add(nameText);
        contentPane.add(authorText);
        contentPane.add(adultText);
        contentPane.add(IDText);
        contentPane.add(backButton);
        contentPane.add(addButton);
        contentPane.add(nameTextField);
        contentPane.add(authorTextField);
        contentPane.add(adultCheck);
        contentPane.add(IDTextField);
        contentPane.add(searchButton);

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