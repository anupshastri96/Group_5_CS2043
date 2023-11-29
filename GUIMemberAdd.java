import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GUIMemberAdd extends JFrame implements ActionListener{

	JPanel contentPane;
	JTextField fnText;
	JTextField lnText;
	JTextField YOBText;
	JTextField addressText;
	JComboBox<String> genderField;
	JButton add;
	JButton backButton;
	String[] genders = {"Male", "Female", "Other", "Prefer to not say"};

	public GUIMemberAdd() {
		this.setTitle("Current Library: " + LibraryManagementSystem.getCurrentLibrary().getName());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(375, 340);
        this.setResizable(false);

        Font font = new Font("Arial", Font.PLAIN, 16); 

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

        JLabel nameLabel = new JLabel("Firstname:");
        nameLabel.setBounds(10, 75, 80, 25);
        nameLabel.setFont(font);
        contentPane.add(nameLabel);

        fnText = new JTextField(20);
        fnText.setBounds(115, 75, 220, 25);
        contentPane.add(fnText);

        JLabel lastLabel = new JLabel("Lastname:");
        lastLabel.setBounds(10, 115, 80, 25);
        lastLabel.setFont(font);
        contentPane.add(lastLabel);

        lnText = new JTextField(20);
        lnText.setBounds(115, 115, 220, 25);
        lnText.setFont(font);
        contentPane.add(lnText);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(10, 155, 110, 25);
        addressLabel.setFont(font);
        contentPane.add(addressLabel);

		addressText = new JTextField(20);
        addressText.setBounds(115, 155, 220, 25);
        addressText.setFont(font);
        contentPane.add(addressText);

		JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(10, 195, 110, 25);
    	genderLabel.setFont(font);
        contentPane.add(genderLabel);

        genderField = new JComboBox<>(genders);
        genderField.setBounds(115, 195, 220, 25);
        genderField.setFont(font);
        contentPane.add(genderField);

		JLabel yobLabel = new JLabel("Year of birth:");
        yobLabel.setBounds(10, 235, 110, 25);
    	yobLabel.setFont(font);
        contentPane.add(yobLabel);

        YOBText = new JTextField(20);
        YOBText.setBounds(115, 235, 220, 25);
        YOBText.setFont(font);
        contentPane.add(YOBText);

        add = new JButton("Add Member");
        add.setBounds(200, 15, 150, 50);
        contentPane.add(add);
        add.setFont(font);
        add.addActionListener(this);

        this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
			try {
				String gender = "";
				if (((String) genderField.getSelectedItem()).equals("Prefer not to say")) {
					gender = "Not provided";
				} else {
					gender = (String) genderField.getSelectedItem();
				}
				String address = addressText.getText();
				String YOB = YOBText.getText();
				String Fname = fnText.getText();
				String Lname = lnText.getText();
				Member membernew = new Member(Integer.parseInt(YOB),Fname,Lname,gender,address);
				LibraryManagementSystem.addMember(membernew);
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Error occured while parsing year of birth");
			}
        }  else if (e.getSource() == backButton) {
            this.dispose();
            GUIMemberAdd add = new GUIMemberAdd();
        } 
	}
}
