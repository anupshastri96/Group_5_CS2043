package lib;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class GUIMemberSearch extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMemberSearch frame = new GUIMemberSearch();
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
	public GUIMemberSearch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("FIRST NAME:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(154, 84, 81, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("LAST NAME:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(154, 123, 81, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(305, 81, 146, 20);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(305, 120, 146, 20);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_4 = new JLabel("GENDER:");
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(154, 167, 81, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "MALE", "FEMALE", "OTHER"}));
		comboBox.setBounds(335, 163, 88, 22);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ID:");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(154, 212, 81, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(305, 209, 146, 20);
		contentPane.add(textField_2);
		
		JLabel lblMembershipSearch = new JLabel("MEMBERSHIP SEARCH");
		lblMembershipSearch.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblMembershipSearch.setBounds(239, 11, 184, 36);
		contentPane.add(lblMembershipSearch);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setBounds(257, 289, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setBounds(538, 19, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("ADD");
		btnNewButton_2.setBounds(10, 19, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
