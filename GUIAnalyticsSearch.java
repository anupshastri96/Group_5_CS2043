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

        subjectBox = new JComboBox<String>(this.getDeweyInfo());
        subjectBox.setBounds(100, 80, 120, 25);

        backButton = new JButton("Back");
		backButton.setBounds(498, 19, 89, 23);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        resultsButton = new JButton("Results");
        resultsButton.setBounds(168, 148, 89, 23);
        resultsButton.setFocusable(false);
        resultsButton.addActionListener(this);
        

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 600, 400);
        this.setResizable(false);

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
