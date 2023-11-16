import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryGUI extends JFrame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {new LibraryGUI().setVisible(true);});
    }

    public LibraryGUI() {
        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Harriet Irving Library");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));

        JButton librarianButton = new JButton("Librarian");
        librarianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {System.out.println("Librarian button clicked");} //add code for button pushed
        });

        JButton adminButton = new JButton("Admin");
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {System.out.println("Admin button clicked");} //add code for button pushed
        });
        
        root.add(titleLabel);
        root.add(librarianButton);
        root.add(adminButton);
        root.setAlignmentX(Component.CENTER_ALIGNMENT);

        setTitle("Harriet Irving Library");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setResizable(false);
        add(root);
    }
}
