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


public class GUIBookShow extends JFrame implements ActionListener {

    JLabel test;
    JButton editButton;
    JButton backButton;
    Book storeBook;

    GUIBookShow(Book bookIn) {

        storeBook = bookIn;

        // Add more labels that display the info
        test = new JLabel(bookIn.getName());

        backButton = new JButton("Back");
		backButton.setBounds(100,100,100,40);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        editButton = new JButton("Edit");
        editButton.setBounds(100,100,100,40);
        editButton.setFocusable(false);
        editButton.addActionListener(this);

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 350);
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(300,40));
        topPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(300,300));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        topPanel.add(editButton);
        topPanel.add(backButton);
        this.add(topPanel);

        panel2.add(test);
        this.add(panel2);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editButton) {
            //this.dispose();
           // GUIBookEdit edit = new GUIBookEdit(storeBook);
        } else if (e.getSource() == backButton) {
            this.dispose();
            GUIBookSearch search = new GUIBookSearch();

        }
	}
	
}