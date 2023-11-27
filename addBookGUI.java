import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addBookGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Add Book");
        frame.setSize(300, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel titleLabel = new JLabel("Title:");
        titleLabel.setBounds(10, 20, 80, 25);
        panel.add(titleLabel);

        JTextField titleText = new JTextField(20);
        titleText.setBounds(100, 20, 165, 25);
        panel.add(titleText);

        JLabel authorLabel = new JLabel("Author:");
        authorLabel.setBounds(10, 50, 80, 25);
        panel.add(authorLabel);

        JTextField authorText = new JTextField(20);
        authorText.setBounds(100, 50, 165, 25);
        panel.add(authorText);

        JLabel deweyLabel = new JLabel("Select Subject");
        deweyLabel.setBounds(10,80,120,25);
        deweyLabel.setVisible(true);

        panel.add(deweyLabel);

        String[] deweySubjects = {"000 Generalities","100 Philosophy & psychology","200 Religion","300 Social sciences","400 Language","500 Natural sciences & mathematics","600 Technology (Applied sciences)","700 The arts","800 Literature & rhetoric","900 Geography & history"};
        JComboBox<String> cb = new JComboBox<String>(deweySubjects);
        cb.setBounds(100, 80, 120, 25);

        cb.setVisible(true);
        panel.add(cb);

        JButton addButton = new JButton("Add Book");
        addButton.setBounds(10, 130, 150, 25);
        panel.add(addButton);


        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            
                String title = titleText.getText();
                String author = authorText.getText();
                String deweydecimal = (String) cb.getSelectedItem();
                String sub = deweydecimal.substring(0,3);
                int deweyIn = Integer.parseInt(sub);
            
                // Create a new book and add it to the library (assuming library is already created)
                Book newBook = new Book(title, author, deweyIn, true);
                // Library.addBook(newBook); fix this static method issue

                // Clear the text fields after adding the book
                titleText.setText("");
                authorText.setText("");
            }
        });
    }
}