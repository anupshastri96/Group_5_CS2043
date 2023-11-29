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
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.ArrayList;


public class GUILibrarySearch extends JFrame implements ActionListener {

    JTextField nameTextField;
    JTextField addressTextField;
    JTextField IDTextField;
    JButton searchButton;
    JButton backButton;
    JButton addButton;

    JPanel contentPane;

    

    GUILibrarySearch() {

        JLabel nameText = new JLabel("Name:");
        nameText.setBounds(65, 75, 200, 35);
        JLabel addressText = new JLabel("Address:");
        addressText.setBounds(65, 115, 200, 35);
        JLabel IDText = new JLabel("ID:");
        IDText.setBounds(65, 155, 200, 35);
        JLabel titleText = new JLabel("Library Search");
        titleText.setBounds(125, 15, 200, 50);

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

        addressTextField = new JTextField();
        addressTextField.setBounds(130, 115, 200, 35);

        IDTextField = new JTextField();
        IDTextField.setPreferredSize(new Dimension(250,40));
        IDTextField.setBounds(130, 155, 200, 35);

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Font titleFont = new Font("Arial", Font.BOLD, 18);

        searchButton.setFont(buttonFont);
        backButton.setFont(buttonFont);
        addButton.setFont(buttonFont);
        nameText.setFont(buttonFont);
        addressText.setFont(buttonFont);
        IDText.setFont(buttonFont);
        nameTextField.setFont(buttonFont);
        addressTextField.setFont(buttonFont);
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
        contentPane.add(addressText);
        contentPane.add(IDText);
        contentPane.add(backButton);
        contentPane.add(addButton);
        contentPane.add(nameTextField);
        contentPane.add(addressTextField);
        contentPane.add(IDTextField);
        contentPane.add(searchButton);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == searchButton) {
            
            SearchAlgorithm.librarySearch(nameTextField.getText(),addressTextField.getText(),IDTextField.getText());
            ArrayList<Integer> holder = SearchAlgorithm.getResults();
            
            if (holder.size() == 1) {
                this.dispose();
                GUILibraryShow show = new GUILibraryShow(LibraryManagementSystem.findLibrary(holder.get(0)));
            } else {
                this.dispose();
                GUILibraryResults results = new GUILibraryResults(holder);
            }

        }  else if (e.getSource() == addButton) {
            this.dispose();
            GUILibraryAdd add = new GUILibraryAdd();
        } else if (e.getSource() == backButton) {
            
            this.dispose();
            GUILibraryStart start = new GUILibraryStart();
        }
	}
	
}