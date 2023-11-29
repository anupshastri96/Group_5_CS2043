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

public class GUIAdminLogin extends JFrame implements ActionListener {

    private JTextField usernameField;
    private JTextField passwordField;
    private JButton submitButton;
    private JButton backButton;
    private JPanel contentPane;

    GUIAdminLogin() {

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 340);
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        Font font = new Font("Arial", Font.PLAIN, 16); // Change the font, size, and style here

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        backButton = new JButton("Back");
        backButton.setBounds(10, 15, 68, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setFont(font);

        JLabel user = new JLabel("Username:");
        user.setFont(font);
        user.setBounds(10, 80, 100, 25);

        usernameField = new JTextField();
        usernameField.setColumns(10);
        usernameField.setBounds(125, 80, 225, 25);
        usernameField.setFont(font);

        JLabel pass = new JLabel("Password:");
        pass.setFont(font);
        pass.setBounds(10, 120, 100, 25);

        passwordField = new JTextField();
        passwordField.setColumns(10);
        passwordField.setBounds(125, 120, 225, 25);
        passwordField.setFont(font);

        submitButton = new JButton("Login");
        submitButton.setBounds(130, 165, 125, 25);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);
        submitButton.setFont(font);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        contentPane.add(backButton);
        contentPane.add(usernameField);
        contentPane.add(passwordField);
        contentPane.add(submitButton);
        contentPane.add(user);
        contentPane.add(pass);
    
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            if (LibraryManagementSystem.checkAdmin(usernameField.getText(),passwordField.getText())) {
                this.dispose();
                GUILibrarySearch search = new GUILibrarySearch();
            }
        } else if (e.getSource() == backButton) {
            this.dispose();
            GUILibraryStart start = new GUILibraryStart();
        }
    }
    
}