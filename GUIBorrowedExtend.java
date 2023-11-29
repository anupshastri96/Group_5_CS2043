import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;


public class GUIBorrowedExtend extends JFrame implements ActionListener{

    private JPanel contentPane;
    private JButton backButton;
    private JButton submitButton;
    private JTextField extendField;
   
    private BorrowedBook bookIn;
    private boolean bookStart;

    public GUIBorrowedExtend(boolean bookStart, BorrowedBook bookIn) {
        this.bookIn = bookIn;
        this.bookStart = bookStart;

        this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 340);
        this.setResizable(false);

        contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

        backButton = new JButton("Back");
		backButton.setBounds(10, 15, 68, 50);
        backButton.setFocusable(false);
        backButton.addActionListener(this);

        submitButton = new JButton("Submit");
        submitButton.setBounds(140,240,85,50);
        submitButton.setFocusable(false);
        submitButton.addActionListener(this);

        JLabel extendLabel = new JLabel("Extend due date:");
        extendLabel.setBounds(10, 120, 200, 35);

        extendField = new JTextField();
        extendField.setBounds(130, 120, 200, 35);
        
       

        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        Font titleFont = new Font("Arial", Font.BOLD, 18);

        backButton.setFont(buttonFont);
        extendLabel.setFont(buttonFont);
        extendField.setFont(buttonFont);
        submitButton.setFont(buttonFont);

        contentPane.add(extendLabel);
        contentPane.add(extendField);
        contentPane.add(submitButton);
        contentPane.add(backButton);
        
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            boolean succeed = true;
            try {
                bookIn.extendReturnDate(Integer.parseInt(extendField.getText()));
            } catch (Exception ex) {
                succeed = false;
            }
            if (succeed) {
                this.dispose();
                GUIBorrowedShow show = new GUIBorrowedShow(bookStart, bookIn);
            } else {
                JOptionPane.showMessageDialog(null, "Field was not filled correctly");
            }
        } else if (e.getSource() == backButton) {
            this.dispose();
            GUIBorrowedShow show = new GUIBorrowedShow(bookStart, bookIn);
        } 
	}
}

