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

public class GUILibraryAdd extends JFrame implements ActionListener {

    JLabel nameLabel;
    JTextField nameTextField;
    JLabel addressLabel;
    JTextField addressTextField;
    JButton addButton;
    JButton backButton;
    JPanel contentPane;

    GUILibraryAdd() {

        Font font = new Font("Arial", Font.PLAIN, 16); // Change the font, size, and style here

        backButton = new JButton("Back");
        backButton.setBounds(10, 15, 68, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setFont(font);

        addButton = new JButton("Add");
        addButton.setBounds(200, 215, 150, 50);
        addButton.setFocusable(false);
        addButton.addActionListener(this);
        addButton.setFont(font);

        nameLabel = new JLabel("Name:");
        nameLabel.setFont(font);
        nameLabel.setBounds(10, 75, 80, 25);

        nameTextField = new JTextField();
        nameTextField.setColumns(10);
        nameTextField.setBounds(75, 75, 275, 25);
        nameTextField.setFont(font);

        addressLabel = new JLabel("Address:");
        addressLabel.setFont(font);
        addressLabel.setBounds(10, 125, 80, 25);

        addressTextField = new JTextField();
        addressTextField.setColumns(10);
        addressTextField.setBounds(75, 125, 275, 25);
        addressTextField.setFont(font);

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 340);
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        contentPane.add(backButton);
        contentPane.add(nameLabel);
        contentPane.add(nameTextField);
        contentPane.add(addressLabel);
        contentPane.add(addressTextField);
        contentPane.add(addButton);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            if (nameTextField.getText() != "" && addressTextField.getText() != "") {
                String toCheck = (nameTextField.getText() + addressTextField.getText());
                if (toCheck.indexOf(",") == -1) {
                    Library toAdd = new Library(nameTextField.getText(), addressTextField.getText());
                    LibraryManagementSystem.addLibrary(toAdd, false);
                    nameTextField.setText("");
                    addressTextField.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "Cannot contain character ','");
                }
            }
        }  else if (e.getSource() == backButton) {
            this.dispose();
            GUILibrarySearch search = new GUILibrarySearch();

        }
	}
	
}