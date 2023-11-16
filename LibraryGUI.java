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

    private static Library currentLibrary;
    private static String currentLibraryName;

    public static void main(String[] args) {
        currentLibrary = checkConfig();
        currentLibraryName = currentLibrary.getName();




        SwingUtilities.invokeLater(() -> {new LibraryGUI().setVisible(true);});
    }

    public LibraryGUI() {
        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel(currentLibraryName);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JButton librarianButton = new JButton("Librarian");
        librarianButton.addActionListener(new ActionListener() {
         
            public void actionPerformed(ActionEvent e) {System.out.println("Librarian button clicked");} //add code for button pushed
        });

        JButton adminButton = new JButton("Admin");
        adminButton.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e) {System.out.println("Admin button clicked");} //add code for button pushed
        });
        
        root.add(titleLabel);
        root.add(librarianButton);
        root.add(adminButton);
        root.setAlignmentX(Component.CENTER_ALIGNMENT);

        setTitle(currentLibraryName);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setResizable(false);
        add(root);
    }
    // Write all code for GUI above this for now
    static Library checkConfig() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("config.txt"));
			String line = reader.readLine();
			int buffer = -1;
			int count = 1;
			boolean first = true;
			String currentName = "";
			String currentAddress = "";
			int currentID = -1;
            Library cLibrary = new Library(currentName, currentAddress, currentID);
			while (line != null) {
				if (count == 1) {
					for (int i = 0; i < line.length(); i++) {
             	  		if (line.charAt(i) == ',') {
							if (first) {
								currentID = Integer.parseInt(line.substring(0,i));
								first = false;
							} else {
								currentName = line.substring(buffer + 1,i);
							} 
                    		buffer = i;
                		} else if (i == line.length()-1) {
							currentAddress = line.substring(buffer + 1,line.length());
                		}
            		}
					if (currentName == null || currentAddress == null || currentID == -1) {

					} else {
						cLibrary = new Library(currentName, currentAddress, currentID);
						LibraryManagementSystem l1 = new LibraryManagementSystem(cLibrary);
						buffer = -1;
					}
        		} else {

					int libraryHolder = -1;
					int bookHolder = -1;
					int memberHolder = -1;
					int borrowedBookHolder = -1;

					for (int i = 0; i < line.length(); i++) {
             	  		if (line.charAt(i) == ',') {
							if (count == 2) {
								libraryHolder = Integer.parseInt(line.substring(0,i));
							} else if (count == 3) {
								bookHolder = Integer.parseInt(line.substring(buffer + 1,i));
							} else if (count == 4) {
								memberHolder = Integer.parseInt(line.substring(buffer + 1,i));
							}
                    		buffer = i;
							count++;
                		} else if (i == line.length()-1) {
							borrowedBookHolder = Integer.parseInt(line.substring(buffer + 1,i + 1));
                		}
            		}
					Library configLibrary = new Library (libraryHolder);
					Book configBook = new Book (bookHolder);
					Member configMember = new Member (memberHolder);
					BorrowedBook configBorrowedBook = new BorrowedBook (borrowedBookHolder);
				}
				count++;
				line = reader.readLine();
				
			}
            return cLibrary;
		} catch(FileNotFoundException fnf) {
       		System.out.println("Config file is not there!");
        	System.exit(1);
    	} catch (IOException io) {
			System.out.print("Hi");
			System.exit(1);
		}
        return currentLibrary;
	} 
}
