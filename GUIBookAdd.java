import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.util.Scanner;

public class GUIBookAdd extends JFrame implements ActionListener{


    String[] deweySubjects;
    JComboBox<String> cb;
    JButton addButton;
    JButton backButton;
    JTextField titleText;
    JTextField authorText;

    public GUIBookAdd() {

        deweySubjects = this.getDeweyInfo();

        JPanel panel = new JPanel();

        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(10, 20, 80, 25);
        panel.add(titleLabel);

        titleText = new JTextField(20);
        titleText.setBounds(100, 20, 165, 25);
        panel.add(titleText);

        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(10, 50, 80, 25);
        panel.add(authorLabel);

        authorText = new JTextField(20);
        authorText.setBounds(100, 50, 165, 25);
        panel.add(authorText);

        JLabel deweyLabel = new JLabel("Select Subject");
        deweyLabel.setBounds(10,80,120,25);
        deweyLabel.setVisible(true);
        panel.add(deweyLabel);

        cb = new JComboBox<>(deweySubjects);
        cb.setBounds(100, 80, 120, 25);
        panel.add(cb);

        addButton = new JButton("Add Book");
        addButton.setBounds(10, 130, 150, 25);
        panel.add(addButton);
        addButton.addActionListener(this);

        addButton = new JButton("Back");
        addButton.setBounds(10, 130, 150, 25);
        panel.add(addButton);
        addButton.addActionListener(this);

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 250);
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));


        this.add(panel);

        this.setVisible(true);
    }

    private String[] getDeweyInfo() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("libraryStorage.txt"));
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
            System.out.println("Library storage file is not there!");
            System.exit(1);
        } catch (IOException io) {
			System.out.print("Hi");
			System.exit(1);
		}
        return null;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
                String title = titleText.getText();
                String author = authorText.getText();
                String deweydecimal = (String) cb.getSelectedItem();
                String sub = deweydecimal.substring(0,3);
                int deweyIn = Integer.parseInt(sub);
            
                
                Book newBook = new Book(title, author, deweyIn, true);
                LibraryManagementSystem.getCurrentLibrary().addBook(newBook);
                // Clear the text fields after adding the book
                titleText.setText("");
                authorText.setText("");
        } else if (e.getSource() == backButton) {
            this.dispose();
            GUIBookSearch search = new GUIBookSearch();
        }
	}
}