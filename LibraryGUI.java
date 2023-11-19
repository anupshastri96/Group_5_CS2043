import javax.swing.*;
import java.awt.*;
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


public class LibraryGUI extends JFrame {

    public static void main(String[] args) {

		LibraryManagementSystem.libraryReadFile();
		LibraryManagementSystem.memberReadFile();
		LibraryManagementSystem.adminReadFile();
		LibraryManagementSystem.readConfig();

        SwingUtilities.invokeLater(() -> {new LibraryGUI().setVisible(true);});

    }

    public LibraryGUI() {
        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 12));

        JButton librarianButton = new JButton("Librarian");
        librarianButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				//add code for button pushed
				System.out.println("Librarian button clicked");
			}
        });

        JButton adminButton = new JButton("Admin");
        adminButton.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e) {
				//add code for button pushed
				System.out.println("Admin button clicked");
			}
        });
        
        root.add(titleLabel);
		root.add(Box.createHorizontalStrut(1));
		root.add(Box.createHorizontalStrut(1));
		root.add(Box.createHorizontalStrut(1));
        root.add(librarianButton);
		root.add(Box.createHorizontalStrut(1));
        root.add(adminButton);
		root.add(Box.createHorizontalStrut(1));

        setTitle(LibraryManagementSystem.getCurrentLibrary().getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setResizable(false);
        add(root);
    }
	
}
