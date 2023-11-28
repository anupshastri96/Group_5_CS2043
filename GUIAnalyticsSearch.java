import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUIAnalyticsSearch extends JFrame implements ActionListener {

    private JButton backButton;
    private JButton resultsButton;
    private JPanel contentPane;
    private JComboBox<String> subjectBox;

    GUIAnalyticsSearch() {
        Font buttonFont = new Font("Arial", Font.PLAIN, 16); // Change the font, size, and style here

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 340);
        this.setResizable(false);

        backButton = new JButton("Back");
	    backButton.setBounds(10,15,68,50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        subjectBox = new JComboBox<String>(this.getDeweyInfo());
        subjectBox.setBounds(10, 80, 340, 50);

        resultsButton = new JButton("Results");
        resultsButton.setBounds(10,185,340,100);
        resultsButton.setFocusable(false);
        resultsButton.addActionListener(this);

        backButton.setFont(buttonFont);
        subjectBox.setFont(buttonFont);
        resultsButton.setFont(buttonFont);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        contentPane.add(backButton);
        contentPane.add(subjectBox);
        contentPane.add(resultsButton);

        this.setVisible(true);
    }

    private String[] getDeweyInfo() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("DeweyDecimalData.txt"));
			String line = reader.readLine();
            ArrayList<String> holder = new ArrayList<>();
            while (line != null) {
                holder.add(line);
                line = reader.readLine();
            }
            String[] toReturn = new String[holder.size()];
            for (int i = 0; i < holder.size(); i++) {
                toReturn[i] = holder.get(i);
            }
            return toReturn;
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
        if (e.getSource() == resultsButton) {
            String toReturn = (String) subjectBox.getSelectedItem();
            this.dispose();
            GUIAnalyticsShow show = new GUIAnalyticsShow(Integer.parseInt(toReturn.substring(0,3)));
        } else if (e.getSource() == backButton) {
            this.dispose();
            GUILibraryStart start = new GUILibraryStart();
        }
	}
}
