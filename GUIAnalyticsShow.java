/*import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class GUIAnalyticsShow extends JFrame implements ActionListener {

    JLabel commonlyFoundIn;
    JLabel ageGroup;
    JLabel commonGender;
    JButton backButton;
    JPanel contentPane;
    int deweyIn;

    GUIAnalyticsShow(int deweyIn) {

        this.deweyIn = deweyIn;

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 340);
        this.setResizable(false);

        JLabel subject = new JLabel(this.getSubject(deweyIn));
        subject.setBounds(10, 75, 340, 35);
         
        if (LibraryManagementSystem.getMostDewey(deweyIn).getName().equals("None") && LibraryManagementSystem.getMostDewey(deweyIn).getAddress().equals("None")) {
            commonlyFoundIn = new JLabel("Not available in any library at the moment");
            commonlyFoundIn.setBounds(10, 115, 340, 35);
        } else {
            commonlyFoundIn = new JLabel("Name: " + LibraryManagementSystem.getMostDewey(deweyIn).getName() + "Address : " + LibraryManagementSystem.getMostDewey(deweyIn).getAddress());
            commonlyFoundIn.setBounds(10, 115, 340, 35);
        } 
        
        if (LibraryManagementSystem.getAveAge(deweyIn) != 0) {
            ageGroup = new JLabel("Average age group: " + LibraryManagementSystem.getAveAge(deweyIn));
            ageGroup.setBounds(10, 155, 340, 35);
        } else {
            ageGroup = new JLabel("Not enough data to determine the age group");
            ageGroup.setBounds(10, 155, 340, 35);
        } 
 
        commonGender = new JLabel("Popular with " + LibraryManagementSystem.getTopGender(deweyIn));
        commonGender.setBounds(10, 195, 340, 35);
        
        backButton = new JButton("Back");
	    backButton.setBounds(10,15,68,50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);

        backButton.setFont(buttonFont);
        subject.setFont(buttonFont);
        commonlyFoundIn.setFont(buttonFont);
        ageGroup.setFont(buttonFont);
        commonGender.setFont(buttonFont);

        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        contentPane.add(backButton);
        contentPane.add(subject);
        contentPane.add(commonlyFoundIn);
        contentPane.add(ageGroup);
        contentPane.add(commonGender);

        this.setVisible(true);
    }

    private String getSubject(int deweyIn) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("DeweyDecimalData.txt"));
			String line = reader.readLine();
           
            while (line != null) {
                if (Integer.parseInt(line.substring(0,3)) == deweyIn) {
                    return line.substring(4,line.length());
                }
            }
            reader.close();
        } catch(FileNotFoundException fnf) {
            System.out.println("Dewey info is not there!");
            System.exit(1);
        } catch (IOException io) {
			System.out.print("Hi");
			System.exit(1);
		}
        return null;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            this.dispose();
            GUIAnalyticsSearch search = new GUIAnalyticsSearch();
        }
	}
	
} */

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
        if (LibraryManagementSystem.getMostDewey(deweyIn).getName().equals("None") && LibraryManagementSystem.getMostDewey(deweyIn).getAddress().equals("None")) {
            commonlyFoundIn = new JLabel("Not available in any library at the moment");
        } else {
            commonlyFoundIn = new JLabel("Name: " + LibraryManagementSystem.getMostDewey(deweyIn).getName() +
                                "Address : " + LibraryManagementSystem.getMostDewey(deweyIn).getAddress());
        }
        
        if (LibraryManagementSystem.getAveAge(deweyIn) != 0) {
            ageGroup = new JLabel("Average age group: " + LibraryManagementSystem.getAveAge(deweyIn));
        } else {
            ageGroup = new JLabel("Not enough data to determine the age group");
        }

        commonGender = new JLabel("Popular with " + LibraryManagementSystem.getTopGender(deweyIn));

        backButton = new JButton("Back");
	    backButton.setBounds(10,15,68,50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);

        backButton.setFont(buttonFont);
       


        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 350);
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
   


        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(300,70));
  
        topPanel.setLayout(null);

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
