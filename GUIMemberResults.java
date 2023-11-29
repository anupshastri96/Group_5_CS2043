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
import javax.swing.JComboBox;
import javax.swing.JPanel;


import java.util.ArrayList;


public class GUIMemberResults extends JFrame implements ActionListener {

    JButton confirmButton;
    JButton backButton;
    JComboBox<String> options;
    JPanel contentPane;
    ArrayList<Integer> memberIDs;
    int storeBookID;
    boolean attemptBorrow;

    GUIMemberResults(boolean attemptBorrow, int storeBookID, ArrayList<Integer> memberIDs) {

        this.memberIDs = memberIDs;
        this.storeBookID = storeBookID;
        this.attemptBorrow = attemptBorrow;

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 340);
        this.setResizable(false);

        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        backButton = new JButton("Back");
		backButton.setBounds(10, 15, 68, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(130,240,110,50);
        confirmButton.setFocusable(false);
        confirmButton.addActionListener(this);

        JLabel resultLabel = new JLabel("Results:");
        resultLabel.setBounds(35, 120, 200, 35);

        this.memberIDs = memberIDs;

        String[] memberNames = new String[memberIDs.size()];
        for (int i = 0; i < memberIDs.size(); i++) {
            String toAdd = (LibraryManagementSystem.findMember(memberIDs.get(i)).getFirstname() + " " + LibraryManagementSystem.findMember(memberIDs.get(i)).getLastname());
            memberNames[i] = (toAdd);
        }
        
        options = new JComboBox<>(memberNames);
        options.setBounds(100, 120, 230, 35);
        options.setFocusable(false);
        options.addActionListener(this);

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Font titleFont = new Font("Arial", Font.BOLD, 18);

        backButton.setFont(buttonFont);
        options.setFont(buttonFont);
        resultLabel.setFont(buttonFont);
        confirmButton.setFont(buttonFont);

        contentPane.add(resultLabel);
        contentPane.add(options);
        contentPane.add(confirmButton);
        contentPane.add(backButton);
        
        this.setVisible(true);
    }

    GUIMemberResults(ArrayList<Integer> memberIDs) {

        this.memberIDs = memberIDs;

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 340);
        this.setResizable(false);

        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        backButton = new JButton("Back");
		backButton.setBounds(10, 15, 68, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(130,240,110,50);
        confirmButton.setFocusable(false);
        confirmButton.addActionListener(this);

        JLabel resultLabel = new JLabel("Results:");
        resultLabel.setBounds(35, 120, 200, 35);

        this.memberIDs = memberIDs;

        String[] memberNames = new String[memberIDs.size()];
        for (int i = 0; i < memberIDs.size(); i++) {
            String toAdd = (LibraryManagementSystem.findMember(memberIDs.get(i)).getFirstname() + " " + LibraryManagementSystem.findMember(memberIDs.get(i)).getLastname());
            memberNames[i] = (toAdd);
        }
        
        options = new JComboBox<>(memberNames);
        options.setBounds(100, 120, 230, 35);
        options.setFocusable(false);
        options.addActionListener(this);

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Font titleFont = new Font("Arial", Font.BOLD, 18);

        backButton.setFont(buttonFont);
        options.setFont(buttonFont);
        resultLabel.setFont(buttonFont);
        confirmButton.setFont(buttonFont);

        contentPane.add(resultLabel);
        contentPane.add(options);
        contentPane.add(confirmButton);
        contentPane.add(backButton);
        
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            if (attemptBorrow) {
                this.dispose();
                GUIBorrowedAdd add = new GUIBorrowedAdd(false, LibraryManagementSystem.getCurrentLibrary().findBook(storeBookID), LibraryManagementSystem.findMember(memberIDs.get(options.getSelectedIndex())));
            } else {
                this.dispose();
                GUIMemberShow show = new GUIMemberShow(LibraryManagementSystem.findMember(memberIDs.get(options.getSelectedIndex())));
            }
        } else if (e.getSource() == backButton) {
            if (attemptBorrow) {
                GUIMemberSearch search = new GUIMemberSearch(attemptBorrow, storeBookID);
            } else {
                this.dispose();
                GUIMemberSearch search = new GUIMemberSearch();
            }
        }
	}
	
}