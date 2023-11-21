import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class LibraryStart extends JFrame implements ActionListener {

    JButton adminButton;
    JButton librarianButton;

    LibraryStart() {

        librarianButton = new JButton("Librarian");
		librarianButton.setBounds(100,100,100,40);
        librarianButton.setFocusable(false);
        librarianButton.addActionListener(this);

        adminButton = new JButton("Admin");
        adminButton.setBounds(100,200,100,40);
        adminButton.setFocusable(false);
        adminButton.addActionListener(this);
        

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 350);
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(200,330));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER,100,75));

        panel2.add(librarianButton);
        panel2.add(adminButton);
        this.add(panel2);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == adminButton) {
            this.dispose();
            AdminLogin login = new AdminLogin();
        } else if (e.getSource() == librarianButton) {
            System.out.println("Librarian button clicked");
        }
	}
	
}
