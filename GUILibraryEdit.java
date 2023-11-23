 import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.ArrayList;


public class GUILibraryEdit extends JFrame implements ActionListener {

    JTextField nameTextField;
    JTextField addressTextField;
    JButton submitButton;
    JButton backButton;
    Library storeLibrary;

    GUILibraryEdit(Library libraryIn) {

        storeLibrary = libraryIn;

        submitButton = new JButton("Submit Changes");
        submitButton.setBounds(100,100,100,40);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);

        backButton = new JButton("Back");
		backButton.setBounds(100,100,100,40);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        nameTextField = new JTextField();
        nameTextField.setPreferredSize(new Dimension(250,40));

        addressTextField = new JTextField();
        addressTextField.setPreferredSize(new Dimension(250,40));


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
        panel2.add(addressTextField);
        panel2.add(submitButton);
        this.add(panel2);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == submitButton) {
            storeLibrary.changeName(nameTextField.getText());
            storeLibrary.changeAddress(addressTextField.getText());
            LibraryManagementSystem.libraryWriteFile();
            this.dispose();
            GUILibraryShow show = new GUILibraryShow(storeLibrary);
        }  else if (e.getSource() == backButton) {
            this.dispose();
            GUILibraryShow show = new GUILibraryShow(storeLibrary);
        }
	}
	
}       
        
        
        