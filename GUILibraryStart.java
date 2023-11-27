import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUILibraryStart extends JFrame implements ActionListener {

    private JButton adminButton;
    private JButton librarianButton;
    private JButton analyticsButton;
    private JPanel contentPane;

    GUILibraryStart() {

        librarianButton = new JButton("Librarian");
	   librarianButton.setBounds(100,10,100,25);
        librarianButton.setFocusable(false);
        librarianButton.addActionListener(this);

        adminButton = new JButton("Admin");
        adminButton.setBounds(100,120,100,25);
        adminButton.setFocusable(false);
        adminButton.addActionListener(this);

        analyticsButton = new JButton("View Analytics");
        analyticsButton.setBounds(0, 0, 89, 23);
        analyticsButton.setFocusable(false);
        analyticsButton.addActionListener(this);
        

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 350);
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
            this.dispose();
            GUILibrarianChoice choice = new GUILibrarianChoice();

        } else if (e.getSource() == analyticsButton) {
            this.dispose();
            GUIAnalyticsSearch search = new GUIAnalyticsSearch();
        }
	}
	
}
