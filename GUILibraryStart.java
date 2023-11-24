import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUILibraryStart extends JFrame implements ActionListener {

    private JButton adminButton;
    private JButton librarianButton;
    private JPanel contentPane;

    GUILibraryStart() {

        librarianButton = new JButton("Librarian");
		librarianButton.setBounds(168, 78, 89, 23);
        librarianButton.setFocusable(false);
        librarianButton.addActionListener(this);

        adminButton = new JButton("Admin");
        adminButton.setBounds(168, 148, 89, 23);
        adminButton.setFocusable(false);
        adminButton.addActionListener(this);
        

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 450, 300);
        this.setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

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
        }
	}
	
}
