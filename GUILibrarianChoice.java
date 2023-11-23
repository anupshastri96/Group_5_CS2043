import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUILibrarianChoice extends JFrame implements ActionListener {

    JButton bookButton;
    JButton memberButton;
    JButton backButton;

    GUILibrarianChoice() {

        bookButton = new JButton("Books");
		bookButton.setBounds(100,100,100,40);
        bookButton.setFocusable(false);
        bookButton.addActionListener(this);

        memberButton = new JButton("Members");
        memberButton.setBounds(100,200,100,40);
        memberButton.setFocusable(false);
        memberButton.addActionListener(this);

        backButton = new JButton("Back");
		backButton.setBounds(100,100,100,40);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 350);
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(300,40));
        topPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(200,330));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER,100,75));

        topPanel.add(backButton);
        this.add(topPanel);

        panel2.add(bookButton);
        panel2.add(memberButton);
        this.add(panel2);

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
