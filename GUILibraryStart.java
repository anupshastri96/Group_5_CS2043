import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUILibraryStart extends JFrame implements ActionListener {

    private JButton adminButton;
    private JButton librarianButton;
    private JButton analyticsButton;
    private JPanel contentPane;

    GUILibraryStart() {

        analyticsButton = new JButton("View Analytics");
        analyticsButton.setBounds(10, 15, 340, 50);
        analyticsButton.setFocusable(false);
        analyticsButton.addActionListener(this);

        librarianButton = new JButton("Librarian");
	    librarianButton.setBounds(10,75,340,100);
        librarianButton.setFocusable(false);
        librarianButton.addActionListener(this);

        adminButton = new JButton("Admin");
        adminButton.setBounds(10,185,340,100);
        adminButton.setFocusable(false);
        adminButton.addActionListener(this);

        Font buttonFont = new Font("Arial", Font.PLAIN, 16); // Change the font, size, and style here

        librarianButton.setFont(buttonFont);
        adminButton.setFont(buttonFont);
        analyticsButton.setFont(buttonFont);

        Font titleFont = new Font("Arial", Font.BOLD, 18);
        
        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 340);
        this.setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        contentPane.add(analyticsButton);
        contentPane.add(librarianButton);
        contentPane.add(adminButton);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminButton) {
            this.dispose();
            GUIAdminLogin login = new GUIAdminLogin();
        } else if (e.getSource() == librarianButton) {
            if (LibraryManagementSystem.getCurrentLibrary().getID() == -1) {
                JOptionPane.showMessageDialog(null, "Failsafe was activated, cannot access library, get admin to change the current library");
            } else {
                this.dispose();
                GUILibrarianChoice choice = new GUILibrarianChoice();
            }

        } else if (e.getSource() == analyticsButton) {
            if (LibraryManagementSystem.getCurrentLibrary().getID() == -1) {
                JOptionPane.showMessageDialog(null, "Failsafe was activated, cannot access analytics, get admin to change the current library");
            } else {
                this.dispose();
                GUIAnalyticsSearch search = new GUIAnalyticsSearch();
            }
        }
	}
}
