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

	private static ArrayList<Integer> configInts;

	private static Library currentLibrary;
	// does nothing v
	private static int loginType;
    

    public static void main(String[] args) {

        configInts = LibraryManagementSystem.checkConfig();

		Library fakeLibrary = new Library(configInts.get(1));
		Book fakeBook = new Book(configInts.get(2));
		Member fakeMember = new Member(configInts.get(3));
		BorrowedBook fakeBorrowedBook = new BorrowedBook(configInts.get(4));
		
		LibraryManagementSystem.libraryReadFile();
		LibraryManagementSystem.memberReadFile();
		LibraryManagementSystem.adminReadFile();

		currentLibrary = LibraryManagementSystem.findLibrary(configInts.get(0));

        SwingUtilities.invokeLater(() -> {new LibraryGUI().setVisible(true);});

    }

    public LibraryGUI() {
        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel(currentLibrary.getName());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

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
        root.add(librarianButton);
        root.add(adminButton);
        root.setAlignmentX(Component.CENTER_ALIGNMENT);

        setTitle(currentLibrary.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setResizable(false);
        add(root);
    }
	
}
