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

        backButton = new JButton("BACK");
		backButton.setBounds(498, 19, 89, 23);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        usernameField = new JTextField();
        usernameField.setColumns(10);
		usernameField.setBounds(305, 81, 146, 20);

        passwordField = new JTextField();
        passwordField.setColumns(10);
		passwordField.setBounds(305, 120, 146, 20);


        submitButton = new JButton("LOGIN");
		submitButton.setBounds(261, 191, 89, 23);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);

        JLabel user = new JLabel("USERNAME:");
		user.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		user.setBounds(154, 84, 81, 14);
		
		JLabel pass = new JLabel("PASSWORD:");
		pass.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		pass.setBounds(154, 123, 81, 14);

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 613, 411);
        this.setResizable(false);
    
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