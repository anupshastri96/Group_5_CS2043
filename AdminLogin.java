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


public class AdminLogin extends JFrame implements ActionListener {

    JTextField usernameField;
    JTextField passwordField;
    JButton submitButton;
    JButton backButton;

    AdminLogin() {

        backButton = new JButton("Back");
		backButton.setBounds(100,100,100,40);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        usernameField = new JTextField();
        usernameField.setPreferredSize(new Dimension(250,40));

        passwordField = new JTextField();
        passwordField.setPreferredSize(new Dimension(250,40));


        submitButton = new JButton("Submit");
		submitButton.setBounds(100,100,100,40);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 350);
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        JPanel backPanel = new JPanel();
        backPanel.setPreferredSize(new Dimension(300,40));
        backPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(300,300));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        backPanel.add(backButton);
        this.add(backPanel);

        panel2.add(usernameField);
        panel2.add(passwordField);
        panel2.add(submitButton);
        this.add(panel2);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            if (LibraryManagementSystem.checkAdmin(usernameField.getText(),passwordField.getText())) {
                this.dispose();
                AdminChoice Choice = new AdminChoice();
                System.out.print("Hi");
            }
        } else if (e.getSource() == backButton) {
            this.dispose();
            LibraryStart start = new LibraryStart();
        }
	}
	
}