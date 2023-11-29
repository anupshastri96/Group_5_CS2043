import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class GUILibrarianChoice extends JFrame implements ActionListener {

    JButton bookButton;
    JButton memberButton;
    JButton backButton;
    JPanel contentPane;

    GUILibrarianChoice() {

        bookButton = new JButton("Books");
		bookButton.setBounds(10,75,340,100);
        bookButton.setFocusable(false);
        bookButton.addActionListener(this);

        memberButton = new JButton("Members");
        memberButton.setBounds(10,185,340,100);
        memberButton.setFocusable(false);
        memberButton.addActionListener(this);

        backButton = new JButton("Back");
		backButton.setBounds(10, 15, 68, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);

        bookButton.setFont(buttonFont);
        memberButton.setFont(buttonFont);
        backButton.setFont(buttonFont);
        

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 340);
        this.setResizable(false);

        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        contentPane.add(backButton);
        contentPane.add(bookButton);
        contentPane.add(memberButton);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookButton) {
            this.dispose();
            GUIBookSearch search = new GUIBookSearch();
        } else if (e.getSource() == memberButton) {
            this.dispose();
            GUIMemberSearch search = new GUIMemberSearch();
        } else if (e.getSource() == backButton) {
            this.dispose();
            GUILibraryStart start = new GUILibraryStart();
        }
	}
	
}
