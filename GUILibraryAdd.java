package lib;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GUILibraryAdd extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUILibraryAdd frame = new GUILibraryAdd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUILibraryAdd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 711, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("NAME:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(168, 107, 81, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ADDRESS:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(168, 146, 81, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(319, 104, 146, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(319, 143, 146, 20);
		contentPane.add(textField_1);
		
		JLabel lblLibraryAdd = new JLabel("LIBRARY ADD");
		lblLibraryAdd.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblLibraryAdd.setBounds(253, 34, 184, 36);
		contentPane.add(lblLibraryAdd);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setBounds(552, 42, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setBounds(295, 236, 89, 23);
		contentPane.add(btnNewButton);
	}

}
