import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUILibraryShow extends JFrame implements ActionListener {

    JButton editButton;
    JButton backButton;
    JButton currentButton;
    Library storeLibrary;
    JPanel contentPane;

    GUILibraryShow(Library libraryIn) {

        storeLibrary = libraryIn;


        JLabel nameText = new JLabel("Name: " + libraryIn.getName());
        nameText.setBounds(10, 75, 200, 35);
        JLabel addressText = new JLabel("Address: " + libraryIn.getAddress());
        addressText.setBounds(10, 115, 200, 35);
        JLabel IDText = new JLabel("ID: " + libraryIn.getID());
        IDText.setBounds(10, 155, 200, 35);

        backButton = new JButton("Back");
		backButton.setBounds(10, 15, 68, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        editButton = new JButton("Edit");
		editButton.setBounds(260, 65, 100, 50);
        editButton.setFocusable(false);
        editButton.addActionListener(this);

        currentButton = new JButton("Set as current");
		currentButton.setBounds(220, 15, 140, 50);
        currentButton.setFocusable(false);
        currentButton.addActionListener(this);

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Font titleFont = new Font("Arial", Font.BOLD, 18);

        backButton.setFont(buttonFont);
        editButton.setFont(buttonFont);
        currentButton.setFont(buttonFont);
        nameText.setFont(buttonFont);
        addressText.setFont(buttonFont);
        IDText.setFont(buttonFont);
        
        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 340);
        this.setResizable(false);

        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        contentPane.add(nameText);
        contentPane.add(addressText);
        contentPane.add(IDText);
        contentPane.add(IDText);
        contentPane.add(editButton);
        contentPane.add(currentButton);
        contentPane.add(backButton);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editButton) {
            this.dispose();
            GUILibraryEdit edit = new GUILibraryEdit(storeLibrary);
        } else if (e.getSource() == currentButton) {
            LibraryManagementSystem.changeCurrentLibrary(storeLibrary);
            this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        } else if (e.getSource() == backButton) {
            this.dispose();
            GUILibrarySearch search = new GUILibrarySearch();

        }
	}
	
}