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

import java.util.ArrayList;


public class GUILibraryEdit extends JFrame implements ActionListener {

    JTextField nameTextField;
    JTextField addressTextField;
    JPanel contentPane;
    JButton submitButton;
    JButton backButton;
    Library storeLibrary;

    GUILibraryEdit(Library libraryIn) {

        storeLibrary = libraryIn;

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 340);
        this.setResizable(false);

        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        backButton = new JButton("Back");
		backButton.setBounds(10, 15, 68, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        submitButton = new JButton("Submit");
        submitButton.setBounds(140,240,85,50);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);

        JLabel nameLabel = new JLabel("Change name:");
        nameLabel.setBounds(10, 100, 200, 35);

        nameTextField = new JTextField();
        nameTextField.setBounds(130, 100, 200, 35);

        JLabel addressLabel = new JLabel("Change address:");
        addressLabel.setBounds(10, 150, 200, 35);

        addressTextField = new JTextField();
        addressTextField.setBounds(130, 150, 200, 35);

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Font titleFont = new Font("Arial", Font.BOLD, 18);

        backButton.setFont(buttonFont);
        nameLabel.setFont(buttonFont);
        nameTextField.setFont(buttonFont);
        addressLabel.setFont(buttonFont);
        addressTextField.setFont(buttonFont);
        submitButton.setFont(buttonFont);

        contentPane.add(nameLabel);
        contentPane.add(nameTextField);
        contentPane.add(addressLabel);
        contentPane.add(addressTextField);
        contentPane.add(submitButton);
        contentPane.add(backButton);
        
        this.setVisible(true);
        
    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == submitButton) {
            if (!nameTextField.getText().equals("")) {
                storeLibrary.changeName(nameTextField.getText());
            } 
            if (!addressTextField.getText().equals("")) {
                storeLibrary.changeAddress(addressTextField.getText());
            }
            LibraryManagementSystem.libraryWriteFile();
            this.dispose();
            GUILibraryShow show = new GUILibraryShow(storeLibrary);
        }  else if (e.getSource() == backButton) {
            this.dispose();
            GUILibraryShow show = new GUILibraryShow(storeLibrary);
        }
	}
	
}       
        
        
        