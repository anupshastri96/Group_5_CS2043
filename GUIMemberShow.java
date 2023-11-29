import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class GUIMemberShow extends JFrame implements ActionListener {

    JLabel lateFeesText;
    JLabel membershipText;
    JButton backButton;
    JButton viewBorrowedButton;
    JButton borrowButton;
    JButton renewButton;
    JPanel contentPane;
    Member storeMember;

    GUIMemberShow(Member memberIn) {

        storeMember = memberIn;

        JLabel nameText = new JLabel("Name: " + memberIn.getFirstname() + " " + memberIn.getLastname());
        nameText.setBounds(10, 75, 200, 35);
        JLabel addressText = new JLabel("Address: " + memberIn.getAddress());
        addressText.setBounds(10, 115, 200, 35);
        JLabel genderText = new JLabel("Gender: " + memberIn.getGender());
        genderText.setBounds(10, 155, 200, 35);
        if (memberIn.getTotalLateFees() > 0) {
            lateFeesText = new JLabel("Amount due in late fees: $" + memberIn.getTotalLateFees());
            lateFeesText.setBounds(10, 195, 200, 35);
        } else {
            lateFeesText = new JLabel("No money owed");
            lateFeesText.setBounds(10, 195, 200, 35);
        }
        if (memberIn.memexpired()) {
            membershipText = new JLabel("Membership is expired");
            membershipText.setBounds(10, 235, 200, 35);
        } else {
            membershipText = new JLabel("Membership is active");
            membershipText.setBounds(10, 235, 200, 35);
        }
        JLabel IDText = new JLabel("ID: " + memberIn.getID());
        IDText.setBounds(10, 275, 200, 35);

        backButton = new JButton("Back");
		backButton.setBounds(10, 15, 68, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        borrowButton = new JButton("Borrow");
		borrowButton.setBounds(260, 65, 100, 50);
        borrowButton.setFocusable(false);
        borrowButton.addActionListener(this);

        renewButton = new JButton("Renew membership");
		renewButton.setBounds(170, 250, 190, 50);
        renewButton.setFocusable(false);
        renewButton.addActionListener(this);

        viewBorrowedButton = new JButton("Borrowed Log");
		viewBorrowedButton.setBounds(220, 15, 140, 50);
        viewBorrowedButton.setFocusable(false);
        viewBorrowedButton.addActionListener(this);

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Font titleFont = new Font("Arial", Font.BOLD, 18);

        backButton.setFont(buttonFont);
        borrowButton.setFont(buttonFont);
        viewBorrowedButton.setFont(buttonFont);
        renewButton.setFont(buttonFont);
        nameText.setFont(buttonFont);
        addressText.setFont(buttonFont);
        genderText.setFont(buttonFont);
        membershipText.setFont(buttonFont);
        lateFeesText.setFont(buttonFont);
        IDText.setFont(buttonFont);
        
        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 340);
        this.setResizable(false);

        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        contentPane.add(nameText);
        contentPane.add(addressText);
        contentPane.add(genderText);
        contentPane.add(lateFeesText);
        contentPane.add(membershipText);
        contentPane.add(IDText);
        contentPane.add(borrowButton);
        contentPane.add(viewBorrowedButton);
        contentPane.add(renewButton);
        contentPane.add(backButton);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == borrowButton) {
            if (!storeMember.memexpired()) {
                this.dispose();
                GUIBookSearch search = new GUIBookSearch(true, storeMember.getID());
            } else {
                JOptionPane.showMessageDialog(null, "Members with expired memberships cannot borrow books");
            }
        } else if (e.getSource() == renewButton) {
            if (storeMember.memexpired()) {
                storeMember.renewMembership();
                LibraryManagementSystem.memberWriteFile();
                this.dispose();
                GUIMemberShow show = new GUIMemberShow(storeMember);
            }
        } else if (e.getSource() == viewBorrowedButton) {
            if (!storeMember.getBorrowed().isEmpty() && storeMember.getBorrowed() != null) {
                this.dispose();
                GUIBorrowedView search = new GUIBorrowedView(false, storeMember.getID());
            } else {
                JOptionPane.showMessageDialog(null, "Member has no borrowing history");
            }
            
        } else if (e.getSource() == backButton) {
            this.dispose();
            GUIMemberSearch search = new GUIMemberSearch();
        }
	}
	
}