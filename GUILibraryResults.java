package lib;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class GUILibraryResults extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUILibraryResults frame = new GUILibraryResults();
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
	public GUILibraryResults() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(145, 103, 106, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("CONFIRM");
		btnNewButton.setBounds(365, 103, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblSearchResults = new JLabel("SEARCH RESULTS");
		lblSearchResults.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSearchResults.setBounds(245, 26, 184, 36);
		contentPane.add(lblSearchResults);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.setBounds(547, 34, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
