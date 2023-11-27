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

import java.util.ArrayList;


public class GUIAnalyticsShow extends JFrame implements ActionListener {

    //Add checkbox
    JLabel commonlyFoundIn;
    JLabel ageGroup;
    JLabel commonGender;
    JButton backButton;

    GUIAnalyticsShow(int deweyIn) {

        commonlyFoundIn = new JLabel("Name: " + LibraryManagementSystem.getMostDewey(deweyIn).getName() +
                                "Address : " + LibraryManagementSystem.getMostDewey(deweyIn).getAddress());
        // Add check for age group to make sure it doesnt display the 0
        ageGroup = new JLabel("Average age group: " + LibraryManagementSystem.getAveAge(deweyIn));

        commonGender = new JLabel("Popular with: " + LibraryManagementSystem.getTopGender(deweyIn));

        backButton = new JButton("Back");
		backButton.setBounds(100,100,100,40);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

       


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

        panel2.add(commonlyFoundIn);
        panel2.add(ageGroup);
        panel2.add(commonGender);
        this.add(panel2);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            this.dispose();
            GUIAnalyticsSearch search = new GUIAnalyticsSearch();
        }
	}
	
}
