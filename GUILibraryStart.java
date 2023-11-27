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
<<<<<<< HEAD
		librarianButton.setBounds(168, 78, 89, 23);
=======
		librarianButton.setBounds(100,10,100,25);
>>>>>>> 2f31382e0d86d666782d44aaa9c858e0c0b2602e
        librarianButton.setFocusable(false);
        librarianButton.addActionListener(this);

        adminButton = new JButton("Admin");
<<<<<<< HEAD
        adminButton.setBounds(168, 148, 89, 23);
=======
        adminButton.setBounds(100,120,100,25);
>>>>>>> 2f31382e0d86d666782d44aaa9c858e0c0b2602e
        adminButton.setFocusable(false);
        adminButton.addActionListener(this);

        analyticsButton = new JButton("View Analytics");
        analyticsButton.setBounds(0, 0, 89, 23);
        analyticsButton.setFocusable(false);
        analyticsButton.addActionListener(this);
        

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
<<<<<<< HEAD
        this.setBounds(100, 100, 450, 300);
=======
        this.setSize(300, 350);
>>>>>>> 2f31382e0d86d666782d44aaa9c858e0c0b2602e
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
<<<<<<< HEAD
        } else if (e.getSource() == analyticsButton) {
            this.dispose();
            GUIAnalyticsSearch search = new GUIAnalyticsSearch();
=======
>>>>>>> 2f31382e0d86d666782d44aaa9c858e0c0b2602e
        }
	}
	
}
