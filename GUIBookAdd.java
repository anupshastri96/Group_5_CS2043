import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Dimension;
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
    JCheckBox adultCheck;
    JTextField titleText;
    JTextField authorText;
    JPanel contentPane;

    public GUIBookAdd() {

        deweySubjects = this.getDeweyInfo();

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 340);
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        Font font = new Font("Arial", Font.PLAIN, 16); // Change the font, size, and style here

        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        backButton = new JButton("Back");
		backButton.setBounds(10, 15, 68, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setFont(font);

        contentPane.add(backButton);

        contentPane.setPreferredSize(new Dimension(375,340));

        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(10, 75, 80, 25);
        titleLabel.setFont(font);
        contentPane.add(titleLabel);

        titleText = new JTextField(20);
        titleText.setBounds(75, 75, 275, 25);
        contentPane.add(titleText);

        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(10, 125, 80, 25);
        authorLabel.setFont(font);

        contentPane.add(authorLabel);

        authorText = new JTextField(20);
        authorText.setBounds(75, 125, 275, 25);
        authorText.setFont(font);
        contentPane.add(authorText);

        JLabel deweyLabel = new JLabel("Select Subject:");
        deweyLabel.setBounds(10, 175, 110, 25);
        deweyLabel.setVisible(true);
        deweyLabel.setFont(font);
        contentPane.add(deweyLabel);

        cb = new JComboBox<>(deweySubjects);
        cb.setBounds(135, 175, 215, 25);
        cb.setFont(font);
        contentPane.add(cb);

        adultCheck = new JCheckBox("Adult");
        adultCheck.setBounds(50,225,75,25);
        adultCheck.setFocusable(false);
        adultCheck.setFont(font);

        contentPane.add(adultCheck);

        addButton = new JButton("Add Book");
        addButton.setBounds(200, 215, 150, 50);
        contentPane.add(addButton);
        addButton.setFont(font);

        addButton.addActionListener(this);

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
        if (e.getSource() == addButton) {
                if (titleText.getText().equals("") || authorText.getText().equals("")) {

                } else {
                    String title = titleText.getText();
                    String author = authorText.getText();
                    String deweydecimal = (String) cb.getSelectedItem();
                    boolean adult = adultCheck.isSelected();
                    String sub = deweydecimal.substring(0,3);
                    int deweyIn = Integer.parseInt(sub);
            
                    Book newBook = new Book(title, author, deweyIn, true);
                    LibraryManagementSystem.getCurrentLibrary().addBook(newBook);
                }
                // Clear the text fields after adding the book
                titleText.setText("");
                authorText.setText("");
        } else if (e.getSource() == backButton) {
            this.dispose();
            GUIBookSearch search = new GUIBookSearch();
        }
	}
}