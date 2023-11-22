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


public class GUILibraryResults extends JFrame implements ActionListener {

    JButton confirmButton;
    JButton backButton;
    JComboBox<String> options;
    ArrayList<Integer> libraryIDs;

    GUILibraryResults(ArrayList<Integer> libraryIDs) {

        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(100,100,100,40);
        confirmButton.setFocusable(false);
        confirmButton.addActionListener(this);

        backButton = new JButton("Back");
		backButton.setBounds(100,100,100,40);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        this.libraryIDs = libraryIDs;

        String[] libraryNames = new String[libraryIDs.size()];
        for (int i = 0; i < libraryIDs.size(); i++) {
            String toAdd = LibraryManagementSystem.findLibrary(libraryIDs.get(i)).getName();
            libraryNames[i] = (toAdd);
        }
        options = new JComboBox<>(libraryNames);
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
            GUILibraryShow show = new GUILibraryShow(LibraryManagementSystem.findLibrary(libraryIDs.get(options.getSelectedIndex())));
        } else if (e.getSource() == backButton) {
            LibraryManagementSystem.logOut();
            this.dispose();
            GUILibraryStart start = new GUILibraryStart();
        }
	}
	
}