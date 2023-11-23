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


public class GUILibraryAdd extends JFrame implements ActionListener {

    JTextField nameTextField;
    JTextField addressTextField;
    JButton addButton;
    JButton backButton;

    GUILibraryAdd() {

        backButton = new JButton("Back");
		backButton.setBounds(100,100,100,40);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        addButton = new JButton("Add");
        addButton.setBounds(100,100,100,40);
        addButton.setFocusable(false);
        addButton.addActionListener(this);

        nameTextField = new JTextField();
        nameTextField.setPreferredSize(new Dimension(250,40));

        addressTextField = new JTextField();
        addressTextField.setPreferredSize(new Dimension(250,40));

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 350);
        this.setResizable(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        JPanel backPanel = new JPanel();
        backPanel.setPreferredSize(new Dimension(300,40));
        backPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(300,300));
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));

        backPanel.add(backButton);
        this.add(backPanel);

        panel2.add(nameTextField);
        panel2.add(addressTextField);
        panel2.add(addButton);
        this.add(panel2);

        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            if (nameTextField.getText() != "" && addressTextField.getText() != "") {
                Library toAdd = new Library(nameTextField.getText(), addressTextField.getText());
                LibraryManagementSystem.addLibrary(toAdd);
            }
        }  else if (e.getSource() == backButton) {
            this.dispose();
            GUILibrarySearch search = new GUILibrarySearch();

        }
	}
	
}