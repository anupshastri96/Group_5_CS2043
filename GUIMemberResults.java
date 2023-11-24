import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;


import javax.swing.JTextField;
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
    ArrayList<Integer> memberIDs;

    GUIMemberResults(ArrayList<Integer> memberIDs) {

        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(100,100,100,40);
        confirmButton.setFocusable(false);
        confirmButton.addActionListener(this);

        backButton = new JButton("Back");
		backButton.setBounds(100,100,100,40);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        this.memberIDs = memberIDs;

        String[] memberNames = new String[memberIDs.size()];
        for (int i = 0; i < memberIDs.size(); i++) {
            String toAdd = (LibraryManagementSystem.findMember(memberIDs.get(i)).getFirstname() + " " + LibraryManagementSystem.findMember(memberIDs.get(i)).getAddress());
            memberNames[i] = (toAdd);
        }
        
        options = new JComboBox<>(memberNames);
        options.addActionListener(this);

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

        topPanel.add(backButton);
        this.add(topPanel);

        panel2.add(options);
        panel2.add(confirmButton);
        this.add(panel2);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            this.dispose();
            GUIMemberShow show = new GUIMemberShow(LibraryManagementSystem.findMember(memberIDs.get(options.getSelectedIndex())));
        } else if (e.getSource() == backButton) {
            this.dispose();
            GUIMemberSearch search = new GUIMemberSearch();
        }
	}
	
}